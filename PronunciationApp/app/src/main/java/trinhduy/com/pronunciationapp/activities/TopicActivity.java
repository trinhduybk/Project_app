package trinhduy.com.pronunciationapp.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.github.paolorotolo.appintro.AppIntro;

import trinhduy.com.pronunciationapp.fragments.LessonFragment;
import trinhduy.com.pronunciationapp.adapters.MyPagerAdapter;
import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.models.LessonRule;
import trinhduy.com.pronunciationapp.models.StaticVariable;
import trinhduy.com.pronunciationapp.models.SyllableLessonTitle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SON on 1/6/2016.
 */
public class TopicActivity extends AppCompatActivity {
    public static final String DOUBLE_VOWEL_SOUND = "double_vowel_sound";
    public static final String SYLLABLE_LESSON = "syllable_lesson";
    public static final String SINGLE_VOWEL_SOUND = "single_vowel_sound";
    public static final String VOICED_CONSONANT_SOUND = "voiced_consonant_sound";
    public static final String UNVOICED_CONSONANT_SOUND = "unvoiced_consonant_sound";
    public static final String WORD_STRESS_LESSON = "word_stress_lesson";
    public static final String SOUND_LESSON = "sound_lesson";
    public static final String LINKING = "linking";
    public static final String SENTENCE_STRESS = "sentence_stress";
    public static String TOPIC = "topic";
    private String currentTopic;
    private ArrayList<LessonFragment> listLesson = new ArrayList<LessonFragment>();
    private ViewPager viewPager;
    private ImageView imgSymbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        viewPager = (ViewPager) findViewById(R.id.view_pager_lesson);
        imgSymbol = (ImageView) findViewById(R.id.img_symbol);
        listLesson = getFragments();
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), listLesson);
        viewPager.setAdapter(myPagerAdapter);
        imgSymbol.setImageResource(R.drawable.rio);

    }

    private ArrayList<LessonFragment> getFragments() {
        currentTopic = getIntent().getStringExtra(TOPIC);
        switch (currentTopic) {
            case DOUBLE_VOWEL_SOUND:
                for (int i = 0; i < 8; i++) {
                    LessonFragment lessonFragment = LessonFragment.newInstance(DOUBLE_VOWEL_SOUND, i);
                    listLesson.add(lessonFragment);
                }
                break;
            case SINGLE_VOWEL_SOUND:
                for (int i = 8; i < 20; i++) {
                    LessonFragment lessonFragment = LessonFragment.newInstance(SINGLE_VOWEL_SOUND, i);
                    listLesson.add(lessonFragment);
                }
                break;
            case VOICED_CONSONANT_SOUND:
                for (int i = 20; i < 28; i++) {
                    LessonFragment lessonFragment = LessonFragment.newInstance(VOICED_CONSONANT_SOUND, i);
                    listLesson.add(lessonFragment);
                }
                for (int i = 36; i < 44; i++) {
                    LessonFragment lessonFragment = LessonFragment.newInstance(VOICED_CONSONANT_SOUND, i);
                    listLesson.add(lessonFragment);
                }
                break;
            case UNVOICED_CONSONANT_SOUND:
                for (int i = 28; i < 36; i++) {
                    LessonFragment lessonFragment = LessonFragment.newInstance(UNVOICED_CONSONANT_SOUND, i);
                    listLesson.add(lessonFragment);
                }
                break;
            case SYLLABLE_LESSON:
                for (SyllableLessonTitle syllableTitle : MainActivity.listSyllableLessonTitle) {
                    LessonFragment lessonFragment = LessonFragment.newInstance(SYLLABLE_LESSON, syllableTitle.getNumberOfLesson() - 1);
                    listLesson.add(lessonFragment);
                }
                break;
            case WORD_STRESS_LESSON:
                for (SyllableLessonTitle syllableTitle : MainActivity.listWordStressLessonTitle) {
                    LessonFragment lessonFragment = LessonFragment.newInstance(WORD_STRESS_LESSON, syllableTitle.getNumberOfLesson() - 1);
                    listLesson.add(lessonFragment);
                }
                break;
            case SENTENCE_STRESS:
                for (SyllableLessonTitle syllableTitle : MainActivity.listSentenceStressLessonTitle) {
                    LessonFragment lessonFragment = LessonFragment.newInstance(SENTENCE_STRESS, syllableTitle.getNumberOfLesson() - 1);
                    listLesson.add(lessonFragment);
                }
                break;
            case LINKING:
                for (SyllableLessonTitle syllableTitle : MainActivity.listLinkingLessonTitle) {
                    LessonFragment lessonFragment = LessonFragment.newInstance(LINKING, syllableTitle.getNumberOfLesson() - 1);
                    listLesson.add(lessonFragment);
                }
                break;
        }
        return listLesson;
    }
}
