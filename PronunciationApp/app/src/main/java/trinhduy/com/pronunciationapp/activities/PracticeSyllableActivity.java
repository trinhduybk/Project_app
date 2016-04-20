package trinhduy.com.pronunciationapp.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.fragments.FinishPracticeFragment;
import trinhduy.com.pronunciationapp.fragments.LessonFragment;
import trinhduy.com.pronunciationapp.fragments.PracticeFailFragment;
import trinhduy.com.pronunciationapp.fragments.PracticeSpeakingFragment;
import trinhduy.com.pronunciationapp.fragments.SyllableChooseQuestionFragment;
import trinhduy.com.pronunciationapp.fragments.SyllableFillQuestionFragment;
import trinhduy.com.pronunciationapp.models.StaticVariable;
import trinhduy.com.pronunciationapp.models.SyllableQuestion;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by SON on 2/11/2016.
 */
public class PracticeSyllableActivity extends AppCompatActivity implements SyllableChooseQuestionFragment.NotifyDoneChooseInterface, PracticeFailFragment.FinishAfterFailInterface,
        FinishPracticeFragment.FinishInterface, SyllableFillQuestionFragment.NotifyDoneFillQuestionInterface, PracticeSpeakingFragment.NotifyDoneQuestion {
    public static final String LESSON = "lesson";
    public static final String QUESTION = "question";
    public static final String FILL = "FILL";
    public static final String CHOOSE = "CHOOSE";
    public static final String SPEAK = "SPEAK";
    private FragmentManager fragmentManager;
    private int point = 0;
    private int countQuestion = 1;
    private int stars = 3;
    private String currentTopic;
    private String resultQuestion;
    private int currentPositionQuestion;
    private int currentLesson;
    private ImageView practiceStarOne;
    private ImageView practiceStarTwo;
    private ImageView practiceStarThree;
    private TextView tvPoints;
    ProgressBar progressBarScore;
    private ArrayList<SyllableQuestion> listQuestion = new ArrayList<SyllableQuestion>();
    private PracticeFailFragment practiceFailFragment;
    private FinishPracticeFragment finishPracticeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_sound);
        getDataFromIntent();
        setUpView();
    }

    private void getDataFromIntent() {
        currentLesson = getIntent().getIntExtra(LessonFragment.POSITION_LESSON, 0);
        currentTopic = getIntent().getStringExtra(LessonFragment.CURRENT_TOPIC);
        switch (currentTopic) {
            case TopicActivity.SYLLABLE_LESSON:
                listQuestion = MainActivity.listSyllableQuestion;
                break;
            case TopicActivity.WORD_STRESS_LESSON:
                listQuestion = MainActivity.listWordStressQuestion;
                break;
            case TopicActivity.SENTENCE_STRESS:
                listQuestion = MainActivity.listSentenceStressQuestion;
                break;
            case TopicActivity.LINKING:
                listQuestion = MainActivity.listLinkingQuestion;
                break;
        }


    }

    private void setUpView() {
        tvPoints = (TextView) findViewById(R.id.tvScore);
        practiceStarOne = (ImageView) findViewById(R.id.practice_star_one);
        practiceStarTwo = (ImageView) findViewById(R.id.practice_star_two);
        practiceStarThree = (ImageView) findViewById(R.id.practice_star_three);
        progressBarScore = (ProgressBar) findViewById(R.id.progress_score);
        fragmentManager = getFragmentManager();
        currentPositionQuestion = new Random().nextInt(30) + 1;
        addQuestion(currentLesson + 1, currentPositionQuestion);

    }

    private void addQuestion(int id_lesson, int currentPositionQuestion) {
        SyllableQuestion syllableQuestion = listQuestion.get(currentPositionQuestion);
        switch (syllableQuestion.getTypeQuestion()) {
            case CHOOSE:
                addListenChooseQuestionFragment(id_lesson, currentPositionQuestion, currentTopic);
                break;
            case FILL:
                addReafFillQuestionFragment(id_lesson, currentPositionQuestion, currentTopic);
                break;
            case SPEAK:
                addSpeakPracticeFragment(id_lesson, currentPositionQuestion, currentTopic);
                break;
        }

    }

    private void addReafFillQuestionFragment(int id_lesson, int currentPositionQuestion, String currentTopic) {
        SyllableFillQuestionFragment syllableFillQuestionFragment = new SyllableFillQuestionFragment();
        Bundle argument = new Bundle();
        argument.putString(TopicActivity.TOPIC, currentTopic);
        argument.putInt(LESSON, id_lesson);
        argument.putInt(QUESTION, currentPositionQuestion);
        syllableFillQuestionFragment.setArguments(argument);
        // Start a new FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(R.id.fr_practice_sound, syllableFillQuestionFragment);
        fragmentTransaction.commit();
    }

    private void addListenChooseQuestionFragment(int lesson, int number_question, String currentTopic) {
        SyllableChooseQuestionFragment listenChooseTypeQuestionFragment = new SyllableChooseQuestionFragment();
        Bundle argument = new Bundle();
        argument.putString(TopicActivity.TOPIC, currentTopic);
        argument.putInt(LESSON, lesson);
        argument.putInt(QUESTION, number_question);
        listenChooseTypeQuestionFragment.setArguments(argument);
        // Start a new FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(R.id.fr_practice_sound, listenChooseTypeQuestionFragment);
        fragmentTransaction.commit();
    }

    private void addSpeakPracticeFragment(int lesson, int number_question, String currentTopic) {
        PracticeSpeakingFragment practiceSpeakingFragment = new PracticeSpeakingFragment();
        Bundle argument = new Bundle();
        argument.putString(TopicActivity.TOPIC, currentTopic);
        argument.putInt(LESSON, lesson);
        argument.putInt(QUESTION, number_question);
        practiceSpeakingFragment.setArguments(argument);
        // Start a new FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(R.id.fr_practice_sound, practiceSpeakingFragment);
        fragmentTransaction.commit();
    }


    private void hideHeaderLayout() {
        practiceStarOne.setVisibility(View.GONE);
        practiceStarTwo.setVisibility(View.GONE);
        practiceStarThree.setVisibility(View.GONE);
        tvPoints.setVisibility(View.GONE);
        progressBarScore.setVisibility(View.GONE);
    }

    public void checkStar(int countStar) {
        switch (countStar) {
            case 0:
                practiceStarOne.setImageResource(R.drawable.star_false);
            case 1:
                practiceStarTwo.setImageResource(R.drawable.star_false);
                break;
            case 2:
                practiceStarThree.setImageResource(R.drawable.star_false);
                break;
            case -1:
                hideHeaderLayout();
                addFinishAfterFail();
                break;
        }

    }

    private void addFinishAfterFail() {
        practiceFailFragment = new PracticeFailFragment();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(R.id.fr_practice_sound, practiceFailFragment);
        fragmentTransaction.commit();
    }

    private void addFinishPracticeFragment() {
        finishPracticeFragment = FinishPracticeFragment.newInstance(currentTopic);
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(R.id.fr_practice_sound, finishPracticeFragment);
        fragmentTransaction.commit();

    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void finishActivityAfterFail() {
        finish();
    }

    @Override
    public void finishActivity() {
        finish();
    }

    public void updateResult(boolean result) {
        if (result) {
            point++;
        } else {
            stars--;
        }
        checkStar(stars);
        if (stars >= 0) {
            countQuestion++;
            tvPoints.setText(point + "points");
            progressBarScore.setProgress(countQuestion * 10);
            if (countQuestion > 10) {
                hideHeaderLayout();
                addFinishPracticeFragment();
            } else {
                currentPositionQuestion++;
                if (currentPositionQuestion >= 30)
                    currentPositionQuestion = currentPositionQuestion % 30;
                addQuestion(currentLesson + 1, currentPositionQuestion);
            }
        }


    }

    @Override
    public void notifyDoneQuestion(boolean result) {
        updateResult(result);
    }

    @Override
    public void notifyDoneFillQuestion(boolean result) {
        updateResult(result);
    }

    @Override
    public void notifyDoneChooseQuestion(boolean result) {
        updateResult(result);
    }
}
