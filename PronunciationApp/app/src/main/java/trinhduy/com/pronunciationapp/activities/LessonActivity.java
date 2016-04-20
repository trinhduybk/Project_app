package trinhduy.com.pronunciationapp.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.fragments.ExampleFragment;
import trinhduy.com.pronunciationapp.fragments.FragmentSentenceExample;
import trinhduy.com.pronunciationapp.fragments.Fragment_Syllable_Example;
import trinhduy.com.pronunciationapp.fragments.Fragment_Word_Stress_Example;
import trinhduy.com.pronunciationapp.fragments.LessonFragment;
import trinhduy.com.pronunciationapp.fragments.RuleFragment;
import trinhduy.com.pronunciationapp.fragments.YoutubeFragment;
import trinhduy.com.pronunciationapp.models.StaticVariable;
import trinhduy.com.pronunciationapp.models.WordData;

/**
 * Created by SON on 2/26/2016.
 */
public class LessonActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int positionLessonSound;
    private String currentTopic;
    YoutubeFragment youtubeFragment;
    //    StaticVariable staticVariable=StaticVariable.getInst();
    private String lessonRule;
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        setUpView();
    }

    private void setUpView() {
        getDataFromIntent();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        addYoutubeFragment();
    }

    private void addYoutubeFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.videoLesson, youtubeFragment)
                .addToBackStack(null)
                .commit();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(RuleFragment.newInstance(lessonRule), "RULE");
        switch (currentTopic) {
            case TopicActivity.DOUBLE_VOWEL_SOUND:
                adapter.addFragment(ExampleFragment.newInstance(positionLessonSound), "EXAMPLE");
                youtubeFragment = YoutubeFragment.newInstance(MainActivity.listSound.get(positionLessonSound - 1).getLinkVideo());
                break;
            case TopicActivity.SINGLE_VOWEL_SOUND:
                adapter.addFragment(ExampleFragment.newInstance(positionLessonSound), "EXAMPLE");
                youtubeFragment = YoutubeFragment.newInstance(MainActivity.listSound.get(positionLessonSound - 1).getLinkVideo());
                break;
            case TopicActivity.VOICED_CONSONANT_SOUND:
                adapter.addFragment(ExampleFragment.newInstance(positionLessonSound), "EXAMPLE");
                youtubeFragment = YoutubeFragment.newInstance(MainActivity.listSound.get(positionLessonSound - 1).getLinkVideo());
                break;
            case TopicActivity.UNVOICED_CONSONANT_SOUND:
                adapter.addFragment(ExampleFragment.newInstance(positionLessonSound), "EXAMPLE");
                youtubeFragment = YoutubeFragment.newInstance(MainActivity.listSound.get(positionLessonSound - 1).getLinkVideo());
                break;
            case TopicActivity.SENTENCE_STRESS:
                adapter.addFragment(FragmentSentenceExample.newInstance(TopicActivity.SENTENCE_STRESS), "EXAMPLE");
                youtubeFragment = YoutubeFragment.newInstance(MainActivity.listLessonVideo.get(2).getLinkVideo());
                break;
            case TopicActivity.LINKING:
                adapter.addFragment(FragmentSentenceExample.newInstance(TopicActivity.LINKING), "EXAMPLE");
                youtubeFragment = YoutubeFragment.newInstance(MainActivity.listLessonVideo.get(3).getLinkVideo());
                break;
            case TopicActivity.SYLLABLE_LESSON:
                adapter.addFragment(new Fragment_Syllable_Example(), "EXAMPLE");
                youtubeFragment = YoutubeFragment.newInstance(MainActivity.listLessonVideo.get(0).getLinkVideo());
                break;
            case TopicActivity.WORD_STRESS_LESSON:
                adapter.addFragment(new Fragment_Word_Stress_Example(), "EXAMPLE");
                youtubeFragment = YoutubeFragment.newInstance(MainActivity.listLessonVideo.get(1).getLinkVideo());
                break;
        }

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    private void getDataFromIntent() {
        currentTopic = getIntent().getStringExtra(LessonFragment.CURRENT_TOPIC);
        switch (currentTopic) {
            case TopicActivity.DOUBLE_VOWEL_SOUND:
                setSoundLessonRule();
                break;
            case TopicActivity.SINGLE_VOWEL_SOUND:
                setSoundLessonRule();
                break;
            case TopicActivity.VOICED_CONSONANT_SOUND:
                setSoundLessonRule();
                break;
            case TopicActivity.UNVOICED_CONSONANT_SOUND:
                setSoundLessonRule();
                break;
            case TopicActivity.SYLLABLE_LESSON:
                lessonRule = MainActivity.listOtherLesson.get(0).getLesson_rule();
                break;
            case TopicActivity.WORD_STRESS_LESSON:
                lessonRule = MainActivity.listOtherLesson.get(1).getLesson_rule();
                break;
            case TopicActivity.SENTENCE_STRESS:
                lessonRule = MainActivity.listOtherLesson.get(2).getLesson_rule();
                break;
            case TopicActivity.LINKING:
                lessonRule = MainActivity.listOtherLesson.get(3).getLesson_rule();
                break;
        }

    }

    private void setSoundLessonRule() {
        positionLessonSound = getIntent().getIntExtra(LessonFragment.POSITION_LESSON, 0) + 1;
        String position;
        lessonRule = MainActivity.listSoundLesson.get(positionLessonSound - 1).getLesson_rule();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}
