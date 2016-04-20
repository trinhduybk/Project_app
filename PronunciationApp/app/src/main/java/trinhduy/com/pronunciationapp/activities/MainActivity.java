package trinhduy.com.pronunciationapp.activities;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import trinhduy.com.pronunciationapp.fragments.FragmentDrawer;
import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.fragments.MainFragment;
import trinhduy.com.pronunciationapp.models.LessonRule;
import trinhduy.com.pronunciationapp.models.LessonVideo;
import trinhduy.com.pronunciationapp.models.SentenceExample;
import trinhduy.com.pronunciationapp.models.SoundData;
import trinhduy.com.pronunciationapp.models.StaticVariable;
import trinhduy.com.pronunciationapp.models.SyllableLessonTitle;
import trinhduy.com.pronunciationapp.models.SyllableQuestion;
import trinhduy.com.pronunciationapp.models.WordData;
import trinhduy.com.pronunciationapp.utils.DatabaseHelper;
import trinhduy.com.pronunciationapp.utils.TestAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener, MainFragment.LayoutClick {
    private FragmentManager mFragmentManager;
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    public static ArrayList<SoundData> listSound;
    public static ArrayList<WordData> listExampleWord;
    public static ArrayList<SyllableLessonTitle> listSyllableLessonTitle;
    public static ArrayList<SyllableQuestion> listSyllableQuestion;

    public static ArrayList<SyllableLessonTitle> listWordStressLessonTitle;
    public static ArrayList<SyllableQuestion> listWordStressQuestion;

    public static ArrayList<SyllableLessonTitle> listSentenceStressLessonTitle;
    public static ArrayList<SyllableQuestion> listSentenceStressQuestion;

    public static ArrayList<SyllableLessonTitle> listLinkingLessonTitle;
    public static ArrayList<SyllableQuestion> listLinkingQuestion;

    public static ArrayList<LessonRule> listSoundLesson;
    public static ArrayList<LessonRule> listOtherLesson;
    public static ArrayList<LessonVideo> listLessonVideo;

    public static ArrayList<WordData> listWordSyllableExample = new ArrayList<WordData>();
    public static ArrayList<WordData> listWordStressExample = new ArrayList<WordData>();
    public static ArrayList<SentenceExample> listSentenceStressExample = new ArrayList<SentenceExample>();
    public static ArrayList<SentenceExample> listLinkingExample = new ArrayList<SentenceExample>();
    private boolean doubleBackToExitPressedOnce = false;
    private StaticVariable staticVariable;
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDataFromSqlite();
        setUpView();
    }

    private void setUpView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        mFragmentManager = getFragmentManager();
        addMainFragment();
    }

    private void addMainFragment() {
        MainFragment mainFragment = new MainFragment();
        FragmentTransaction fragmentTransaction = mFragmentManager
                .beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, mainFragment);
        fragmentTransaction.commit();
    }

    private void openTopic(String currentTopic) {
        Intent intent = new Intent(MainActivity.this, TopicActivity.class);
        intent.putExtra(TopicActivity.TOPIC, currentTopic);
        startActivity(intent);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);

    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0://Home
                break;
            case 1://Share
                shareApp();
                break;
            case 2://About
                showInfomationApp();
                break;
            case 3://feedback
                sendEmail();

            default:
                break;
        }
    }

    private void sendEmail() {
        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        email.setType("message/rfc822");
        email.putExtra(Intent.EXTRA_EMAIL, getResources().getString(R.string.developer_email));
        email.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.subject_email));
        try {
            startActivity(Intent.createChooser(email, "Choose an email client from..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "No email client installed.",
                    Toast.LENGTH_LONG).show();
        }

    }

    private void showInfomationApp() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.about_dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView textViewLinkFacebook = (TextView) dialog.findViewById(R.id.textview_link_facebook);
        textViewLinkFacebook.setClickable(true);
        textViewLinkFacebook.setMovementMethod(LinkMovementMethod.getInstance());
        String text = getResources().getString(R.string.link_facebook);
        textViewLinkFacebook.setText(text);
        Button btnOk = (Button) dialog.findViewById(R.id.button_ok);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    private void shareApp() {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
        share.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.link_google_play_for_share));

        startActivity(Intent.createChooser(share, getResources().getString(R.string.share_app_title)));
    }

    private void getDataFromSqlite() {
        TestAdapter mDbHelper = new TestAdapter(MainActivity.this);
        mDbHelper.createDatabase();
        mDbHelper.open();
        listSound = mDbHelper.getAllListSound();
        listExampleWord = mDbHelper.getAllListWord();
        listSyllableLessonTitle = mDbHelper.getAllTitleLesson(TopicActivity.SYLLABLE_LESSON);
        listSyllableQuestion = mDbHelper.getAllListSyllableLesson(SyllableQuestion.KEY_SYLLABLE_QUESTION);
        listWordStressLessonTitle = mDbHelper.getAllTitleLesson(TopicActivity.WORD_STRESS_LESSON);
        listWordStressQuestion = mDbHelper.getAllListSyllableLesson(SyllableQuestion.KEY_WORD_STRESS_QUESTION);
        listSentenceStressLessonTitle = mDbHelper.getAllTitleLesson(TopicActivity.SENTENCE_STRESS);
        listSentenceStressQuestion = mDbHelper.getAllListSyllableLesson(SyllableQuestion.KEY_SENTENCE_STRESS_QUESTION);
        listLinkingLessonTitle = mDbHelper.getAllTitleLesson(TopicActivity.LINKING);
        listLinkingQuestion = mDbHelper.getAllListSyllableLesson(SyllableQuestion.KEY_LINKING_QUESTION);
        listSoundLesson = mDbHelper.getAllSoundLessonRule();
        listOtherLesson = mDbHelper.getAllOthersLessonRule();
        listLessonVideo = mDbHelper.getAllOthersLessonVideo();
        listWordSyllableExample = mDbHelper.getAllListWordSyllable();
        listWordStressExample = mDbHelper.getAllListWordStress();
        listSentenceStressExample = mDbHelper.getAllSentenceStressExample();
        listLinkingExample = mDbHelper.getAllLinkingExample();
        mDbHelper.close();

    }

    private void insertData() {
        staticVariable = StaticVariable.getInst();
        mDatabaseHelper = new DatabaseHelper(this);
        for (SoundData soundData : staticVariable.listSound) {
            mDatabaseHelper.createSound(soundData.getSituation(), soundData.getPhonetic(), soundData.getLinkMusic(), soundData.getLinkVideo());
        }
        for (int i = 1; i <= 44; i++) {
            ArrayList<WordData> listWord = new ArrayList<WordData>();
            if (i < 10) {
                listWord = staticVariable.WordExampleHashMap.get("0" + i + "");
            } else {
                listWord = staticVariable.WordExampleHashMap.get("" + i);
            }
            if (listWord.size() > 0) {
                for (WordData wordData : listWord) {
                    mDatabaseHelper.createWord(wordData.getGroup(), wordData.getPhonetic(), wordData.getNumberPhonetic(), wordData.getWord(), wordData.getGroup());
                }
            }
        }
        for (SyllableLessonTitle syllableLessonTitle : staticVariable.StressLessonTitle.get(TopicActivity.SYLLABLE_LESSON))
            mDatabaseHelper.createTitlteLesson(TopicActivity.SYLLABLE_LESSON, syllableLessonTitle.getNumberOfLesson(), syllableLessonTitle.getTitleLesson());
        for (SyllableLessonTitle syllableLessonTitle : staticVariable.StressLessonTitle.get(TopicActivity.WORD_STRESS_LESSON))
            mDatabaseHelper.createTitlteLesson(TopicActivity.WORD_STRESS_LESSON, syllableLessonTitle.getNumberOfLesson(), syllableLessonTitle.getTitleLesson());
        for (SyllableLessonTitle syllableLessonTitle : staticVariable.StressLessonTitle.get(TopicActivity.SENTENCE_STRESS))
            mDatabaseHelper.createTitlteLesson(TopicActivity.SENTENCE_STRESS, syllableLessonTitle.getNumberOfLesson(), syllableLessonTitle.getTitleLesson());
        for (SyllableLessonTitle syllableLessonTitle : staticVariable.StressLessonTitle.get(TopicActivity.LINKING))
            mDatabaseHelper.createTitlteLesson(TopicActivity.LINKING, syllableLessonTitle.getNumberOfLesson(), syllableLessonTitle.getTitleLesson());

        for (SyllableQuestion syllableQuestion : staticVariable.SyllableQuestionLesson.get(1))
            mDatabaseHelper.createSyllableQuestion(SyllableQuestion.KEY_SYLLABLE_QUESTION, syllableQuestion.getIdQuestion(), syllableQuestion.getLinkAudio(), syllableQuestion.getQuestion(), syllableQuestion.getQuestionDetail(), syllableQuestion.getListAnswer()[0], syllableQuestion.getListAnswer()[1], syllableQuestion.getRightAnswer(), syllableQuestion.getTypeQuestion());
        for (SyllableQuestion syllableQuestion : staticVariable.WordStressQuestionLesson.get(1))
            mDatabaseHelper.createSyllableQuestion(SyllableQuestion.KEY_WORD_STRESS_QUESTION, syllableQuestion.getIdQuestion(), syllableQuestion.getLinkAudio(), syllableQuestion.getQuestion(), syllableQuestion.getQuestionDetail(), syllableQuestion.getListAnswer()[0], syllableQuestion.getListAnswer()[1], syllableQuestion.getRightAnswer(), syllableQuestion.getTypeQuestion());
        for (SyllableQuestion syllableQuestion : staticVariable.SentenceStressQuestion.get(1))
            mDatabaseHelper.createSyllableQuestion(SyllableQuestion.KEY_SENTENCE_STRESS_QUESTION, syllableQuestion.getIdQuestion(), syllableQuestion.getLinkAudio(), syllableQuestion.getQuestion(), syllableQuestion.getQuestionDetail(), syllableQuestion.getListAnswer()[0], syllableQuestion.getListAnswer()[1], syllableQuestion.getRightAnswer(), syllableQuestion.getTypeQuestion());
        for (SyllableQuestion syllableQuestion : staticVariable.LinkingQuestion.get(1))
            mDatabaseHelper.createSyllableQuestion(SyllableQuestion.KEY_LINKING_QUESTION, syllableQuestion.getIdQuestion(), syllableQuestion.getLinkAudio(), syllableQuestion.getQuestion(), syllableQuestion.getQuestionDetail(), syllableQuestion.getListAnswer()[0], syllableQuestion.getListAnswer()[1], syllableQuestion.getRightAnswer(), syllableQuestion.getTypeQuestion());

        for (int i = 1; i <= 44; i++) {
            String lessonRule = "";
            if (i < 10) {
                lessonRule = staticVariable.SoundLessonRule.get("0" + i + "");
                mDatabaseHelper.createSoundLesson("0" + i + "", lessonRule);
            } else {
                lessonRule = staticVariable.SoundLessonRule.get("" + i);
                mDatabaseHelper.createSoundLesson("" + i, lessonRule);
            }
        }
        mDatabaseHelper.createOthersLesson(TopicActivity.SYLLABLE_LESSON, staticVariable.OtherLessonRule.get(TopicActivity.SYLLABLE_LESSON));
        mDatabaseHelper.createOthersLesson(TopicActivity.WORD_STRESS_LESSON, staticVariable.OtherLessonRule.get(TopicActivity.WORD_STRESS_LESSON));
        mDatabaseHelper.createOthersLesson(TopicActivity.SENTENCE_STRESS, staticVariable.OtherLessonRule.get(TopicActivity.SENTENCE_STRESS));
        mDatabaseHelper.createOthersLesson(TopicActivity.LINKING, staticVariable.OtherLessonRule.get(TopicActivity.LINKING));

        mDatabaseHelper.createOthersLessonVideo(TopicActivity.SYLLABLE_LESSON, staticVariable.VideoOtherLessons.get(TopicActivity.SYLLABLE_LESSON));
        mDatabaseHelper.createOthersLessonVideo(TopicActivity.WORD_STRESS_LESSON, staticVariable.VideoOtherLessons.get(TopicActivity.WORD_STRESS_LESSON));
        mDatabaseHelper.createOthersLessonVideo(TopicActivity.SENTENCE_STRESS, staticVariable.VideoOtherLessons.get(TopicActivity.SENTENCE_STRESS));
        mDatabaseHelper.createOthersLessonVideo(TopicActivity.LINKING, staticVariable.VideoOtherLessons.get(TopicActivity.LINKING));

        for (WordData wordData : staticVariable.listWordStressExample) {
            mDatabaseHelper.createWordStress(wordData.getGroup(), wordData.getPhonetic(), wordData.getNumberPhonetic(), wordData.getWord(), wordData.getGroup());
        }

        for (WordData wordData : staticVariable.listWordSyllableExample) {
            mDatabaseHelper.createWordSyllable(wordData.getGroup(), wordData.getPhonetic(), wordData.getNumberPhonetic(), wordData.getWord(), wordData.getGroup());
        }

        for (SentenceExample sentenceExample : staticVariable.listSentenceStressExample) {
            mDatabaseHelper.createSentenceStressExample(sentenceExample.getSentenceDetail(), sentenceExample.getAudioId());
        }
        for (SentenceExample sentenceExample : staticVariable.listLinkingExample) {
            mDatabaseHelper.createLinkingExample(sentenceExample.getSentenceDetail(), sentenceExample.getAudioId());
        }


    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @Override
    public void onLayoutClick(String topic) {
        openTopic(topic);
    }
}
