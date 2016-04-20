package trinhduy.com.pronunciationapp.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import trinhduy.com.pronunciationapp.models.LessonRule;
import trinhduy.com.pronunciationapp.models.LessonVideo;
import trinhduy.com.pronunciationapp.models.SentenceExample;
import trinhduy.com.pronunciationapp.models.SoundData;
import trinhduy.com.pronunciationapp.models.SyllableLessonTitle;
import trinhduy.com.pronunciationapp.models.SyllableQuestion;
import trinhduy.com.pronunciationapp.models.WordData;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by SON on 3/4/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String WORD_DATA_TABLE_CREATED = "create table word_data (position text not null,word_phonetic text not null, "
            + "number_phonetic text not null, word text not null, group_word text not null)";
    private static final String SOUND_DATA_TABLE_CREATED = "create table sound_data (position integer not null,phonetic text not null, "
            + "link_audio integer not null, link_video text not null)";
    private static final String SYLLABLE_QUESTION_TABLE_CREATED = "create table syllable_question (type_lesson text not null,question_id integer not null, "
            + "link_audio integer not null, question text not null,question_detail text not null,list_answer_one text not null,list_answer_two text not null,"
            + "right_answer text not null,type_question text not null)";
    private static final String TITLE_TABLE_CREATED = "create table lesson_title (type_title text not null,number_question integer not null, "
            + "title_question text not null)";
    private static final String SOUND_LESSON_RULE_TABLE = "create table sound_lesson_rule (position text not null,lesson_rule text not null)";
    private static final String OTHERS_LESSON_RULE_TABLE = "create table others_lesson_rule (type_lesson text not null,lesson_rule text not null)";
    private static final String OTHERS_LESSON_VIDEO_TABLE = "create table others_lesson_video (type_lesson text not null,video text not null)";

    private static final String WORD_STRESS_EXAMPLE_CREATED = "create table word_stress (position text not null,word_phonetic text not null, "
            + "number_phonetic text not null, word text not null, group_word text not null)";
    private static final String WORD_SYLLABLE_EXAMPLE_CREATED = "create table word_syllable (position text not null,word_phonetic text not null, "
            + "number_phonetic text not null, word text not null, group_word text not null)";
    private static final String SENTENCE_STRESS_EXAMPLE_TABLE = "create table sentence_stress_example (sentence_detail text not null,audio integer not null)";
    private static final String SENTENCE_LINKING_TABLE = "create table linking_example (sentence_detail text not null,audio integer not null)";

    private static final String TABLE_WORD_DATA = "word_data";
    private static final String TABLE_SOUND_DATA = "sound_data";
    private static final String TABLE_SYLLABLE_DATA = "syllable_question";
    private static final String TABLE_TITLE_DATA = "lesson_title";
    private static final String TABLE_SOUND_LESSON = "sound_lesson_rule";
    private static final String TABLE_OTHERS_LESSON = "others_lesson_rule";
    private static final String TABLE_OTHERS_LESSON_VIDEO = "others_lesson_video";
    private static final String TABLE_WORD_STRESS_EXAMPLE = "word_stress";
    private static final String TABLE_WORD_SYLLABLE_EXAMPLE = "word_syllable";
    private static final String TABLE_SENTENCE_STRESS_EXAMPLE = "sentence_stress_example";
    private static final String TABLE_LINKING_EXAMPLE = "linking_example";
    private static final String DATABASE_NAME = "pronunciation_db_new";
    private static final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase mDb = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WORD_DATA_TABLE_CREATED);
        db.execSQL(SOUND_DATA_TABLE_CREATED);
        db.execSQL(SYLLABLE_QUESTION_TABLE_CREATED);
        db.execSQL(TITLE_TABLE_CREATED);
        db.execSQL(SOUND_LESSON_RULE_TABLE);
        db.execSQL(OTHERS_LESSON_RULE_TABLE);
        db.execSQL(OTHERS_LESSON_VIDEO_TABLE);
        db.execSQL(WORD_STRESS_EXAMPLE_CREATED);
        db.execSQL(WORD_SYLLABLE_EXAMPLE_CREATED);
        db.execSQL(SENTENCE_STRESS_EXAMPLE_TABLE);
        db.execSQL(SENTENCE_LINKING_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS word_data");
        db.execSQL("DROP TABLE IF EXISTS sound_data");
        db.execSQL("DROP TABLE IF EXISTS syllable_lesson_question");
        db.execSQL("DROP TABLE IF EXISTS lesson_title");
        db.execSQL("DROP TABLE IF EXISTS sound_lesson_rule");
        db.execSQL("DROP TABLE IF EXISTS others_lesson_rule");
        db.execSQL("DROP TABLE IF EXISTS others_lesson_video");
        db.execSQL("DROP TABLE IF EXISTS word_stress");
        db.execSQL("DROP TABLE IF EXISTS word_syllable");
        db.execSQL("DROP TABLE IF EXISTS sentence_stress_example");
        db.execSQL("DROP TABLE IF EXISTS linking_example");
        onCreate(db);
    }

    public long createWord(String position, String phonetic, String numberPhonetic, String word, String group) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        ContentValues mContentValue = new ContentValues();
        mContentValue.put(WordData.KEY_POSITION, position);
        mContentValue.put(WordData.KEY_PHONETIC, phonetic);
        mContentValue.put(WordData.KEY_NUMBER_PHONETIC, numberPhonetic);
        mContentValue.put(WordData.KEY_WORD, word);
        mContentValue.put(WordData.KEY_GROUP, group);
        return mDb.insert(TABLE_WORD_DATA, null, mContentValue);
    }

    public long createWordStress(String position, String phonetic, String numberPhonetic, String word, String group) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        ContentValues mContentValue = new ContentValues();
        mContentValue.put(WordData.KEY_POSITION, position);
        mContentValue.put(WordData.KEY_PHONETIC, phonetic);
        mContentValue.put(WordData.KEY_NUMBER_PHONETIC, numberPhonetic);
        mContentValue.put(WordData.KEY_WORD, word);
        mContentValue.put(WordData.KEY_GROUP, group);
        return mDb.insert(TABLE_WORD_STRESS_EXAMPLE, null, mContentValue);
    }

    public long createWordSyllable(String position, String phonetic, String numberPhonetic, String word, String group) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        ContentValues mContentValue = new ContentValues();
        mContentValue.put(WordData.KEY_POSITION, position);
        mContentValue.put(WordData.KEY_PHONETIC, phonetic);
        mContentValue.put(WordData.KEY_NUMBER_PHONETIC, numberPhonetic);
        mContentValue.put(WordData.KEY_WORD, word);
        mContentValue.put(WordData.KEY_GROUP, group);
        return mDb.insert(TABLE_WORD_SYLLABLE_EXAMPLE, null, mContentValue);
    }

    public long createSound(int position, String phonetic, int link_audio, String link_video) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        ContentValues mContentValue = new ContentValues();
        mContentValue.put(SoundData.KEY_POSITION, position);
        mContentValue.put(SoundData.KEY_PHONETIC, phonetic);
        mContentValue.put(SoundData.KEY_AUDIO, link_audio);
        mContentValue.put(SoundData.KEY_VIDEO, link_video);
        return mDb.insert(TABLE_SOUND_DATA, null, mContentValue);
    }

    public long createSyllableQuestion(String type_lesson, int question_id, int linkAudio, String question, String questionDetail, String answer1, String answer2, String rightAnswer, String type_question) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        ContentValues mContentValue = new ContentValues();
        mContentValue.put(SyllableQuestion.KEY_TYPE_LESSON, type_lesson);
        mContentValue.put(SyllableQuestion.KEY_ID, question_id);
        mContentValue.put(SyllableQuestion.KEY_AUDIO, linkAudio);
        mContentValue.put(SyllableQuestion.KEY_QUESTION, question);
        mContentValue.put(SyllableQuestion.KEY_QUESTION_DETAIL, questionDetail);
        mContentValue.put(SyllableQuestion.KEY_LIST_ANSWER_ONE, answer1);
        mContentValue.put(SyllableQuestion.KEY_LIST_ANSWER_TWO, answer2);
        mContentValue.put(SyllableQuestion.KEY_RIGHT_ANSWER, rightAnswer);
        mContentValue.put(SyllableQuestion.KEY_TYPE_QUESTION, type_question);
        return mDb.insert(TABLE_SYLLABLE_DATA, null, mContentValue);
    }

    public long createSoundLesson(String position, String lesson_rule) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        ContentValues mContentValue = new ContentValues();
        mContentValue.put(LessonRule.KEY_POSITION, position);
        mContentValue.put(LessonRule.KEY_RULE, lesson_rule);
        return mDb.insert(TABLE_SOUND_LESSON, null, mContentValue);
    }

    public long createOthersLesson(String type_lesson, String lesson_rule) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        ContentValues mContentValue = new ContentValues();
        mContentValue.put(LessonRule.KEY_TYPE_LESSON, type_lesson);
        mContentValue.put(LessonRule.KEY_RULE, lesson_rule);
        return mDb.insert(TABLE_OTHERS_LESSON, null, mContentValue);
    }

    public long createOthersLessonVideo(String type_lesson, String video) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        ContentValues mContentValue = new ContentValues();
        mContentValue.put(LessonVideo.TYPE_LESSON, type_lesson);
        mContentValue.put(LessonVideo.VIDEO, video);
        return mDb.insert(TABLE_OTHERS_LESSON_VIDEO, null, mContentValue);
    }

    public long createTitlteLesson(String type_title, int number_question, String title_question) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        ContentValues mContentValue = new ContentValues();
        mContentValue.put(SyllableLessonTitle.KEY_TYPE_TITLE, type_title);
        mContentValue.put(SyllableLessonTitle.KEY_NUMBER_LESSON, number_question);
        mContentValue.put(SyllableLessonTitle.KEY_TITLE_QUESTION, title_question);
        return mDb.insert(TABLE_TITLE_DATA, null, mContentValue);
    }

    public long createSentenceStressExample(String sentence_detail, int audio) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        ContentValues mContentValue = new ContentValues();
        mContentValue.put(SentenceExample.SENTENCE_DETAIL, sentence_detail);
        mContentValue.put(SentenceExample.AUDIO, audio);
        return mDb.insert(TABLE_SENTENCE_STRESS_EXAMPLE, null, mContentValue);
    }

    public long createLinkingExample(String sentence_detail, int audio) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        ContentValues mContentValue = new ContentValues();
        mContentValue.put(SentenceExample.SENTENCE_DETAIL, sentence_detail);
        mContentValue.put(SentenceExample.AUDIO, audio);
        return mDb.insert(TABLE_LINKING_EXAMPLE, null, mContentValue);
    }

    public boolean deleteWord(String word) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        return mDb.delete(TABLE_WORD_DATA, WordData.KEY_WORD + "=" + word, null) > 0;
    }

    public ArrayList<WordData> getAllListWord() {
        ArrayList<WordData> mWordList = new ArrayList<WordData>();

        SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_WORD_DATA, new String[]{WordData.KEY_POSITION, WordData.KEY_PHONETIC, WordData.KEY_NUMBER_PHONETIC, WordData.KEY_WORD, WordData.KEY_GROUP}, null, null, null, null, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            WordData mWord = new WordData(cursor.getString(cursor.getColumnIndex(WordData.KEY_PHONETIC)), cursor.getString(cursor.getColumnIndex(WordData.KEY_NUMBER_PHONETIC)), cursor.getString(cursor.getColumnIndex(WordData.KEY_WORD)), cursor.getString(cursor.getColumnIndex(WordData.KEY_GROUP)));
            mWordList.add(mWord);
            cursor.moveToNext();
        }
        return mWordList;
    }

    public ArrayList<WordData> getAllListWordStress() {
        ArrayList<WordData> mWordList = new ArrayList<WordData>();

        SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_WORD_STRESS_EXAMPLE, new String[]{WordData.KEY_POSITION, WordData.KEY_PHONETIC, WordData.KEY_NUMBER_PHONETIC, WordData.KEY_WORD, WordData.KEY_GROUP}, null, null, null, null, null);
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

        SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_WORD_SYLLABLE_EXAMPLE, new String[]{WordData.KEY_POSITION, WordData.KEY_PHONETIC, WordData.KEY_NUMBER_PHONETIC, WordData.KEY_WORD, WordData.KEY_GROUP}, null, null, null, null, null);
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

        SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_TITLE_DATA, new String[]{SyllableLessonTitle.KEY_TYPE_TITLE, SyllableLessonTitle.KEY_NUMBER_LESSON, SyllableLessonTitle.KEY_TITLE_QUESTION}, null, null, null, null, null);
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

        SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_SOUND_DATA, new String[]{SoundData.KEY_POSITION, SoundData.KEY_PHONETIC, SoundData.KEY_AUDIO, SoundData.KEY_VIDEO}, null, null, null, null, null);
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

        SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_SOUND_LESSON, new String[]{LessonRule.KEY_POSITION, LessonRule.KEY_RULE}, null, null, null, null, null);
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

        SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_OTHERS_LESSON, new String[]{LessonRule.KEY_TYPE_LESSON, LessonRule.KEY_RULE}, null, null, null, null, null);
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

        SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_OTHERS_LESSON_VIDEO, new String[]{LessonVideo.TYPE_LESSON, LessonVideo.VIDEO}, null, null, null, null, null);
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

        SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_SYLLABLE_DATA,
                new String[]{SyllableQuestion.KEY_TYPE_LESSON, SyllableQuestion.KEY_ID, SyllableQuestion.KEY_AUDIO, SyllableQuestion.KEY_QUESTION, SyllableQuestion.KEY_QUESTION_DETAIL, SyllableQuestion.KEY_LIST_ANSWER_ONE, SyllableQuestion.KEY_LIST_ANSWER_TWO, SyllableQuestion.KEY_RIGHT_ANSWER, SyllableQuestion.KEY_TYPE_QUESTION}, null, null, null, null, null);
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


    public Cursor getWord(String word) throws SQLException {
        SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor mCursor = mDb.query(true, TABLE_WORD_DATA, new String[]{WordData.KEY_POSITION, WordData.KEY_PHONETIC, WordData.KEY_NUMBER_PHONETIC, WordData.KEY_WORD, WordData.KEY_GROUP}, WordData.KEY_WORD + "=" + word, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updateWord(String position, String phonetic, String numberPhonetic, String word, String group) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        ContentValues mContentValue = new ContentValues();
        mContentValue.put(WordData.KEY_POSITION, position);
        mContentValue.put(WordData.KEY_PHONETIC, phonetic);
        mContentValue.put(WordData.KEY_NUMBER_PHONETIC, numberPhonetic);
        mContentValue.put(WordData.KEY_WORD, word);
        mContentValue.put(WordData.KEY_GROUP, group);
        return mDb.update(TABLE_WORD_DATA, mContentValue, WordData.KEY_WORD + "=" + word, null) > 0;
    }

}
