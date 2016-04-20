package trinhduy.com.pronunciationapp.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.activities.TopicActivity;
import trinhduy.com.pronunciationapp.utils.SessionManager;

/**
 * Created by SON on 3/19/2016.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    RelativeLayout layoutDoubleSound,layoutSingleSound,layoutVoicedSound,layoutUnvoicedSound;
    RelativeLayout layoutSyllable,layoutWordStress,layoutSentenceStress,layoutLinking;
    TextView tvLessonDoneDouble,tvLessonDoneSingle,tvLessonDoneVoiced,tvLessonDoneUnvoiced;
    TextView tvLessonDoneSyllable,tvLessonDoneWordStress,tvLessonDoneSentenceStress,tvLessonDoneLinking;
    LayoutClick mCallback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_main,container,false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback=(LayoutClick)activity;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupView();
        setDoneLesson();
        registerEvent();
    }

    private void registerEvent() {
        layoutDoubleSound.setOnClickListener(this);
        layoutSingleSound.setOnClickListener(this);
        layoutVoicedSound.setOnClickListener(this);
        layoutUnvoicedSound.setOnClickListener(this);
        layoutSyllable.setOnClickListener(this);
        layoutWordStress.setOnClickListener(this);
        layoutDoubleSound.setOnClickListener(this);
        layoutSentenceStress.setOnClickListener(this);
        layoutLinking.setOnClickListener(this);

    }

    private void setDoneLesson() {
        tvLessonDoneDouble.setText(getLessonDoneForTopic(TopicActivity.DOUBLE_VOWEL_SOUND)+"/8 DONE");
        tvLessonDoneSingle.setText(getLessonDoneForTopic(TopicActivity.SINGLE_VOWEL_SOUND)+"/12 DONE");
        tvLessonDoneVoiced.setText(getLessonDoneForTopic(TopicActivity.VOICED_CONSONANT_SOUND)+"/16 DONE");
        tvLessonDoneUnvoiced.setText(getLessonDoneForTopic(TopicActivity.UNVOICED_CONSONANT_SOUND)+"/8 DONE");
        tvLessonDoneSyllable.setText(getLessonDoneForTopic(TopicActivity.SYLLABLE_LESSON)+"/1 DONE");
        tvLessonDoneWordStress.setText(getLessonDoneForTopic(TopicActivity.WORD_STRESS_LESSON)+"/1 DONE");
        tvLessonDoneSentenceStress.setText(getLessonDoneForTopic(TopicActivity.SENTENCE_STRESS) + "/1 DONE");
        tvLessonDoneLinking.setText(getLessonDoneForTopic(TopicActivity.LINKING)+"/1 DONE");
    }

    private void setupView() {
        layoutDoubleSound=(RelativeLayout)getActivity().findViewById(R.id.layout_row_double_sound);
        layoutSingleSound=(RelativeLayout)getActivity().findViewById(R.id.layout_row_single_vowel_sound);
        layoutVoicedSound=(RelativeLayout)getActivity().findViewById(R.id.layout_row_voiced_sound);
        layoutUnvoicedSound=(RelativeLayout)getActivity().findViewById(R.id.layout_row_unvoiced_sound);
        layoutSyllable=(RelativeLayout)getActivity().findViewById(R.id.layout_row_textview_syllable);
        layoutWordStress=(RelativeLayout)getActivity().findViewById(R.id.layout_row_word_stress);
        layoutSentenceStress=(RelativeLayout)getActivity().findViewById(R.id.layout_row_sentence_stress);
        layoutLinking=(RelativeLayout)getActivity().findViewById(R.id.layout_row_linking);
        tvLessonDoneDouble=(TextView)getActivity().findViewById(R.id.textview_lesson_done_double_sound);
        tvLessonDoneSingle=(TextView)getActivity().findViewById(R.id.textview_lesson_done_single_vowel_sound);
        tvLessonDoneVoiced=(TextView)getActivity().findViewById(R.id.textview_lesson_done_voiced_sound);
        tvLessonDoneUnvoiced=(TextView)getActivity().findViewById(R.id.textview_lesson_done_unvoiced_sound);
        tvLessonDoneSyllable=(TextView)getActivity().findViewById(R.id.textview_lesson_done_syllable);
        tvLessonDoneWordStress=(TextView)getActivity().findViewById(R.id.textview_lesson_done_word_stress);
        tvLessonDoneSentenceStress=(TextView)getActivity().findViewById(R.id.textview_lesson_done_sentence_stress);
        tvLessonDoneLinking=(TextView)getActivity().findViewById(R.id.textview_lesson_done_linking);

    }

    private int getLessonDoneForTopic(String topic){
        int doneLesson=0;
        switch (topic){
            case TopicActivity.DOUBLE_VOWEL_SOUND:
                for(int i=0;i<8;i++){
                    if(new SessionManager(getActivity()).isLessonDone(i+"")){
                        doneLesson++;
                    }
                }
                break;
            case TopicActivity.SINGLE_VOWEL_SOUND:
                for(int i=8;i<20;i++){
                    if(new SessionManager(getActivity()).isLessonDone(i+"")){
                        doneLesson++;
                    }
                }
                break;
            case TopicActivity.VOICED_CONSONANT_SOUND:
                for(int i=20;i<28;i++){
                    if(new SessionManager(getActivity()).isLessonDone(i+"")){
                        doneLesson++;
                    }
                }
                for(int i=36;i<44;i++){
                    if(new SessionManager(getActivity()).isLessonDone(i+"")){
                        doneLesson++;
                    }
                }
                break;
            case TopicActivity.UNVOICED_CONSONANT_SOUND:
                for(int i=28;i<36;i++){
                    if(new SessionManager(getActivity()).isLessonDone(i+"")){
                        doneLesson++;
                    }
                }
                break;
            case TopicActivity.SYLLABLE_LESSON:
                if(new SessionManager(getActivity()).isLessonDone(TopicActivity.SYLLABLE_LESSON)){
                    doneLesson++;
                }
                break;
            case TopicActivity.WORD_STRESS_LESSON:
                if(new SessionManager(getActivity()).isLessonDone(TopicActivity.WORD_STRESS_LESSON)){
                    doneLesson++;
                }
                break;
            case TopicActivity.SENTENCE_STRESS:
                if(new SessionManager(getActivity()).isLessonDone(TopicActivity.SENTENCE_STRESS)){
                    doneLesson++;
                }
                break;
            case TopicActivity.LINKING:
                if(new SessionManager(getActivity()).isLessonDone(TopicActivity.LINKING)){
                    doneLesson++;
                }
                break;
        }
        return doneLesson;

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.layout_row_double_sound:
                mCallback.onLayoutClick(TopicActivity.DOUBLE_VOWEL_SOUND);
                break;
            case R.id.layout_row_single_vowel_sound:
                mCallback.onLayoutClick(TopicActivity.SINGLE_VOWEL_SOUND);
                break;
            case R.id.layout_row_voiced_sound:
                mCallback.onLayoutClick(TopicActivity.VOICED_CONSONANT_SOUND);
                break;
            case R.id.layout_row_unvoiced_sound:
                mCallback.onLayoutClick(TopicActivity.VOICED_CONSONANT_SOUND);
                break;
            case R.id.layout_row_textview_syllable:
                mCallback.onLayoutClick(TopicActivity.SYLLABLE_LESSON);
                break;
            case R.id.layout_row_word_stress:
                mCallback.onLayoutClick(TopicActivity.WORD_STRESS_LESSON);
                break;
            case R.id.layout_row_sentence_stress:
                mCallback.onLayoutClick(TopicActivity.SENTENCE_STRESS);
                break;
            case R.id.layout_row_linking:
                mCallback.onLayoutClick(TopicActivity.LINKING);
                break;
        }


    }

    public interface LayoutClick{
        public void onLayoutClick(String topic);

    }

}
