package trinhduy.com.pronunciationapp.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import trinhduy.com.pronunciationapp.models.LessonRule;
import trinhduy.com.pronunciationapp.models.LessonVideo;
import trinhduy.com.pronunciationapp.models.SentenceExample;
import trinhduy.com.pronunciationapp.models.SoundData;
import trinhduy.com.pronunciationapp.models.SyllableLessonTitle;
import trinhduy.com.pronunciationapp.models.SyllableQuestion;
import trinhduy.com.pronunciationapp.models.WordData;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by SON on 3/7/2016.
 */
public class TestAdapter {

    private final Context mContext;
    private SQLiteDatabase mDb;
    private MyDatabaseHelper mDbHelper;

    public TestAdapter(Context context) {
        this.mContext = context;
        mDbHelper = new MyDatabaseHelper(mContext);
    }

    public TestAdapter createDatabase() throws SQLException {
        try {
            mDbHelper.createDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public TestAdapter open() throws SQLException {
        try {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public ArrayList<WordData> getAllListWord() {
        ArrayList<WordData> mWordList = new ArrayList<WordData>();

        SQLiteDatabase mDb = mDbHelper.getReadableDatabase();
        String sql = "SELECT * FROM word_data";

        Cursor cursor = mDb.rawQuery(sql, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            WordData mWord = new WordData(cursor.getString(cursor.getColumnIndex(WordData.KEY_PHONETIC)), cursor.getString(cursor.getColumnIndex(WordData.KEY_NUMBER_PHONETIC)), cursor.getString(cursor.getColumnIndex(WordData.KEY_WORD)), cursor.getString(cursor.getColumnIndex(WordData.KEY_GROUP)));
            mWordList.add(mWord);
            cursor.moveToNext();
        }
        return mWordList;
    }

    public ArrayList<SyllableLessonTitle> getAllTitleLesson(String type_lesson) {
        ArrayList<SyllableLessonTitle> syllableLessonTitles = new ArrayList<SyllableLessonTitle>();

        SQLiteDatabase mDb = mDbHelper.getReadableDatabase();
        String sql = "SELECT * FROM lesson_title";

        Cursor cursor = mDb.rawQuery(sql, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            SyllableLessonTitle lessonTitle = new SyllableLessonTitle(cursor.getInt(cursor.getColumnIndex(SyllableLessonTitle.KEY_NUMBER_LESSON)), cursor.getString(cursor.getColumnIndex(SyllableLessonTitle.KEY_TITLE_QUESTION)));
            if (cursor.getString(cursor.getColumnIndex(SyllableLessonTitle.KEY_TYPE_TITLE)).equals(type_lesson)) {
                syllableLessonTitles.add(lessonTitle);
            }
            cursor.moveToNext();
        }
        return syllableLessonTitles;
    }

    public ArrayList<SoundData> getAllListSound() {
        ArrayList<SoundData> mSoundList = new ArrayList<SoundData>();

        SQLiteDatabase mDb = mDbHelper.getReadableDatabase();
        String sql = "SELECT * FROM sound_data";

        Cursor cursor = mDb.rawQuery(sql, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            SoundData mSoundData = new SoundData(cursor.getInt(cursor.getColumnIndex(SoundData.KEY_POSITION)), cursor.getString(cursor.getColumnIndex(SoundData.KEY_PHONETIC)), cursor.getInt(cursor.getColumnIndex(SoundData.KEY_AUDIO)), cursor.getString(cursor.getColumnIndex(SoundData.KEY_VIDEO)));
            mSoundList.add(mSoundData);
            cursor.moveToNext();
        }
        return mSoundList;
    }

    public ArrayList<LessonRule> getAllSoundLessonRule() {
        ArrayList<LessonRule> listLessonRule = new ArrayList<LessonRule>();

        SQLiteDatabase mDb = mDbHelper.getReadableDatabase();
        String sql = "SELECT * FROM sound_lesson_rule";

        Cursor cursor = mDb.rawQuery(sql, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            LessonRule lessonRule = new LessonRule(cursor.getString(cursor.getColumnIndex(LessonRule.KEY_POSITION)), cursor.getString(cursor.getColumnIndex(LessonRule.KEY_RULE)));
            listLessonRule.add(lessonRule);
            cursor.moveToNext();
        }
        return listLessonRule;
    }

    public ArrayList<LessonRule> getAllOthersLessonRule() {
        ArrayList<LessonRule> listLessonRule = new ArrayList<LessonRule>();

        SQLiteDatabase mDb = mDbHelper.getReadableDatabase();
        String sql = "SELECT * FROM others_lesson_rule";

        Cursor cursor = mDb.rawQuery(sql, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            LessonRule lessonRule = new LessonRule(cursor.getString(cursor.getColumnIndex(LessonRule.KEY_TYPE_LESSON)), cursor.getString(cursor.getColumnIndex(LessonRule.KEY_RULE)));
            listLessonRule.add(lessonRule);
            cursor.moveToNext();
        }
        return listLessonRule;
    }

    public ArrayList<LessonVideo> getAllOthersLessonVideo() {
        ArrayList<LessonVideo> listLessonVideo = new ArrayList<LessonVideo>();

        SQLiteDatabase mDb = mDbHelper.getReadableDatabase();
        String sql = "SELECT * FROM others_lesson_video";

        Cursor cursor = mDb.rawQuery(sql, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            LessonVideo lessonVideo = new LessonVideo(cursor.getString(cursor.getColumnIndex(LessonVideo.TYPE_LESSON)), cursor.getString(cursor.getColumnIndex(LessonVideo.VIDEO)));
            listLessonVideo.add(lessonVideo);
            cursor.moveToNext();
        }
        return listLessonVideo;
    }

    public ArrayList<SyllableQuestion> getAllListSyllableLesson(String type_lesson) {
        ArrayList<SyllableQuestion> syllableQuestions = new ArrayList<SyllableQuestion>();

        SQLiteDatabase mDb = mDbHelper.getReadableDatabase();
        String sql = "SELECT * FROM syllable_question";

        Cursor cursor = mDb.rawQuery(sql, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            SyllableQuestion mSyllableQuestion = new SyllableQuestion(cursor.getInt(cursor.getColumnIndex(SyllableQuestion.KEY_ID)), cursor.getInt(cursor.getColumnIndex(SyllableQuestion.KEY_AUDIO)), cursor.getString(cursor.getColumnIndex(SyllableQuestion.KEY_QUESTION)), cursor.getString(cursor.getColumnIndex(SyllableQuestion.KEY_QUESTION_DETAIL)), new String[]{cursor.getString(cursor.getColumnIndex(SyllableQuestion.KEY_LIST_ANSWER_ONE)), cursor.getString(cursor.getColumnIndex(SyllableQuestion.KEY_LIST_ANSWER_TWO))}, cursor.getString(cursor.getColumnIndex(SyllableQuestion.KEY_RIGHT_ANSWER)), cursor.getString(cursor.getColumnIndex(SyllableQuestion.KEY_TYPE_QUESTION)));
            if (cursor.getString(cursor.getColumnIndex(SyllableQuestion.KEY_TYPE_LESSON)).equals(type_lesson)) {
                syllableQuestions.add(mSyllableQuestion);
            }
            cursor.moveToNext();
        }
        return syllableQuestions;
    }

    public ArrayList<WordData> getAllListWordStress() {
        ArrayList<WordData> mWordList = new ArrayList<WordData>();

        SQLiteDatabase mDb = mDbHelper.getReadableDatabase();
        String sql = "SELECT * FROM word_stress";
        Cursor cursor = mDb.rawQuery(sql, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            WordData mWord = new WordData(cursor.getString(cursor.getColumnIndex(WordData.KEY_PHONETIC)), cursor.getString(cursor.getColumnIndex(WordData.KEY_NUMBER_PHONETIC)), cursor.getString(cursor.getColumnIndex(WordData.KEY_WORD)), cursor.getString(cursor.getColumnIndex(WordData.KEY_GROUP)));
            mWordList.add(mWord);
            cursor.moveToNext();
        }
        return mWordList;
    }

    public ArrayList<WordData> getAllListWordSyllable() {
        ArrayList<WordData> mWordList = new ArrayList<WordData>();

        SQLiteDatabase mDb = mDbHelper.getReadableDatabase();
        String sql = "SELECT * FROM word_syllable";

        Cursor cursor = mDb.rawQuery(sql, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            WordData mWord = new WordData(cursor.getString(cursor.getColumnIndex(WordData.KEY_PHONETIC)), cursor.getString(cursor.getColumnIndex(WordData.KEY_NUMBER_PHONETIC)), cursor.getString(cursor.getColumnIndex(WordData.KEY_WORD)), cursor.getString(cursor.getColumnIndex(WordData.KEY_GROUP)));
            mWordList.add(mWord);
            cursor.moveToNext();
        }
        return mWordList;
    }

    public ArrayList<SentenceExample> getAllSentenceStressExample() {
        ArrayList<SentenceExample> sentenceExamples = new ArrayList<SentenceExample>();

        SQLiteDatabase mDb = mDbHelper.getReadableDatabase();
        String sql = "SELECT * FROM sentence_stress_example";

        Cursor cursor = mDb.rawQuery(sql, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            SentenceExample sentence = new SentenceExample(cursor.getString(cursor.getColumnIndex(SentenceExample.SENTENCE_DETAIL)), cursor.getInt(cursor.getColumnIndex(SentenceExample.AUDIO)));
            sentenceExamples.add(sentence);
            cursor.moveToNext();
        }
        return sentenceExamples;
    }

    public ArrayList<SentenceExample> getAllLinkingExample() {
        ArrayList<SentenceExample> sentenceExamples = new ArrayList<SentenceExample>();

        SQLiteDatabase mDb = mDbHelper.getReadableDatabase();
        String sql = "SELECT * FROM linking_example";

        Cursor cursor = mDb.rawQuery(sql, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            SentenceExample sentence = new SentenceExample(cursor.getString(cursor.getColumnIndex(SentenceExample.SENTENCE_DETAIL)), cursor.getInt(cursor.getColumnIndex(SentenceExample.AUDIO)));
            sentenceExamples.add(sentence);
            cursor.moveToNext();
        }
        return sentenceExamples;
    }

}
