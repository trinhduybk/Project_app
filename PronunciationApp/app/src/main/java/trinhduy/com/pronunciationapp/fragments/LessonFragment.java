package trinhduy.com.pronunciationapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.activities.LessonActivity;
import trinhduy.com.pronunciationapp.activities.MainActivity;
import trinhduy.com.pronunciationapp.activities.PracticeActivity;
import trinhduy.com.pronunciationapp.activities.PracticeSyllableActivity;
import trinhduy.com.pronunciationapp.activities.TopicActivity;
import trinhduy.com.pronunciationapp.models.StaticVariable;
import trinhduy.com.pronunciationapp.utils.SessionManager;

/**
 * Created by SON on 1/10/2016.
 */
public class LessonFragment extends Fragment {
    public static final String POSITION_LESSON = "position_lesson";
    public static final String CURRENT_TOPIC = "current_topic";
    private String name_lesson;
    private String title_lesson;
    Intent intentToPractice;
    Intent intentToLesson;
    SessionManager sessionManager;
    boolean doneLesson;

    public LessonFragment() {

    }

    public static final LessonFragment newInstance(String currentTopic, int positionLesson) {
        LessonFragment lessonFragment = new LessonFragment();
        Bundle argument = new Bundle();
        argument.putString("current_topic", currentTopic);
        argument.putInt("position_lesson", positionLesson);
        lessonFragment.setArguments(argument);
        return lessonFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String current_topic = getArguments().getString("current_topic");
        int positionLesson = getArguments().getInt("position_lesson");
        View rootView = (View) inflater.inflate(R.layout.item_lesson, container, false);
        sessionManager = new SessionManager(getActivity());
        switch (current_topic) {
            case TopicActivity.DOUBLE_VOWEL_SOUND:
                name_lesson = MainActivity.listSound.get(positionLesson).getPhonetic();
                title_lesson = "";
                intentToPractice = new Intent(getActivity(), PracticeActivity.class);
                intentToPractice.putExtra(POSITION_LESSON, positionLesson);
                doneLesson = sessionManager.isLessonDone(positionLesson + "");
                break;
            case TopicActivity.SINGLE_VOWEL_SOUND:
                name_lesson = MainActivity.listSound.get(positionLesson).getPhonetic();
                title_lesson = "";
                intentToPractice = new Intent(getActivity(), PracticeActivity.class);
                intentToPractice.putExtra(POSITION_LESSON, positionLesson);
                doneLesson = sessionManager.isLessonDone(positionLesson + "");
                break;
            case TopicActivity.VOICED_CONSONANT_SOUND:
                name_lesson = MainActivity.listSound.get(positionLesson).getPhonetic();
                title_lesson = "";
                intentToPractice = new Intent(getActivity(), PracticeActivity.class);
                intentToPractice.putExtra(POSITION_LESSON, positionLesson);
                doneLesson = sessionManager.isLessonDone(positionLesson + "");
                break;
            case TopicActivity.UNVOICED_CONSONANT_SOUND:
                name_lesson = MainActivity.listSound.get(positionLesson).getPhonetic();
                title_lesson = "";
                intentToPractice = new Intent(getActivity(), PracticeActivity.class);
                intentToPractice.putExtra(POSITION_LESSON, positionLesson);
                doneLesson = sessionManager.isLessonDone(positionLesson + "");
                break;
            case TopicActivity.SYLLABLE_LESSON:
                name_lesson = MainActivity.listSyllableLessonTitle.get(positionLesson).getNumberOfLesson() + "";
                title_lesson = MainActivity.listSyllableLessonTitle.get(positionLesson).getTitleLesson();
                intentToPractice = new Intent(getActivity(), PracticeSyllableActivity.class);
                intentToPractice.putExtra(POSITION_LESSON, positionLesson);
                intentToPractice.putExtra(CURRENT_TOPIC, current_topic);
                doneLesson = sessionManager.isLessonDone(current_topic);
                break;
            case TopicActivity.WORD_STRESS_LESSON:
                name_lesson = MainActivity.listWordStressLessonTitle.get(positionLesson).getNumberOfLesson() + "";
                title_lesson = MainActivity.listWordStressLessonTitle.get(positionLesson).getTitleLesson();
                intentToPractice = new Intent(getActivity(), PracticeSyllableActivity.class);
                intentToPractice.putExtra(POSITION_LESSON, positionLesson);
                intentToPractice.putExtra(CURRENT_TOPIC, current_topic);
                doneLesson = sessionManager.isLessonDone(current_topic);
                break;
            case TopicActivity.SENTENCE_STRESS:
                name_lesson = MainActivity.listSentenceStressLessonTitle.get(positionLesson).getNumberOfLesson() + "";
                title_lesson = MainActivity.listSentenceStressLessonTitle.get(positionLesson).getTitleLesson();
                intentToPractice = new Intent(getActivity(), PracticeSyllableActivity.class);
                intentToPractice.putExtra(POSITION_LESSON, positionLesson);
                intentToPractice.putExtra(CURRENT_TOPIC, current_topic);
                doneLesson = sessionManager.isLessonDone(current_topic);
                break;
            case TopicActivity.LINKING:
                name_lesson = MainActivity.listLinkingLessonTitle.get(positionLesson).getNumberOfLesson() + "";
                title_lesson = MainActivity.listLinkingLessonTitle.get(positionLesson).getTitleLesson();
                intentToPractice = new Intent(getActivity(), PracticeSyllableActivity.class);
                intentToPractice.putExtra(POSITION_LESSON, positionLesson);
                intentToPractice.putExtra(CURRENT_TOPIC, current_topic);
                doneLesson = sessionManager.isLessonDone(current_topic);
                break;

        }
        intentToLesson = new Intent(getActivity(), LessonActivity.class);
        intentToLesson.putExtra(POSITION_LESSON, positionLesson);
        intentToLesson.putExtra(CURRENT_TOPIC, current_topic);
        Button bt_lesson_sound = (Button) rootView.findViewById(R.id.button_lesson_sound);
        ImageView bt_main_lesson = (ImageView) rootView.findViewById(R.id.button_main_lesson);
        ImageView bt_lesson_practice = (ImageView) rootView.findViewById(R.id.button_lesson_practice);
        TextView tv_title_lesson = (TextView) rootView.findViewById(R.id.textview_lesson_example);
        ImageView imageViewDoneLesson = (ImageView) rootView.findViewById(R.id.done_icon);

        if (doneLesson)
            imageViewDoneLesson.setVisibility(View.VISIBLE);
        bt_lesson_sound.setText(name_lesson);
        tv_title_lesson.setText(title_lesson);
        bt_lesson_practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentToPractice);
            }
        });
        bt_main_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentToLesson);
            }
        });
        return rootView;
    }
}
