package trinhduy.com.pronunciationapp.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.activities.MainActivity;
import trinhduy.com.pronunciationapp.activities.PracticeSyllableActivity;
import trinhduy.com.pronunciationapp.activities.TopicActivity;
import trinhduy.com.pronunciationapp.models.StaticVariable;
import trinhduy.com.pronunciationapp.models.SyllableQuestion;
import trinhduy.com.pronunciationapp.utils.SoundEffect;

import java.util.ArrayList;

/**
 * Created by SON on 2/12/2016.
 */
public class SyllableChooseQuestionFragment extends Fragment implements View.OnClickListener, MediaPlayer.OnPreparedListener {
    private String currentTopic;
    private int currentLesson;
    private int idQuestion;
    TextView tvRequest, tvQuestion;
    ImageView imgSpeaker;
    Button imageRightAnswer;
    Button imageWrongAnswer;
    Button btCheckAnswer;
    RadioButton rbChoiceA, rbChoiceB;
    ArrayList<SyllableQuestion> listQuestion = new ArrayList<SyllableQuestion>();
    SyllableQuestion syllableQuestion;
    MediaPlayer mediaPlayer;
    private StateButtonAnswer stateButtonAnswer = StateButtonAnswer.NOT_ANSWER_ALREADY;
    boolean result;
    NotifyDoneChooseInterface mCallBacks;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_syllable_choose_question, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpView();
        getDataFromArguemnt();
        setUpQuestion();
        registerForEvent();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallBacks = (NotifyDoneChooseInterface) activity;
    }

    private void registerForEvent() {
        imgSpeaker.setOnClickListener(this);
        rbChoiceA.setOnClickListener(this);
        rbChoiceB.setOnClickListener(this);
        btCheckAnswer.setOnClickListener(this);
    }

    private void setUpQuestion() {
        tvRequest.setText(syllableQuestion.getQuestion());
        tvQuestion.setText(syllableQuestion.getQuestionDetail());
        rbChoiceA.setText(syllableQuestion.getListAnswer()[0]);
        rbChoiceB.setText(syllableQuestion.getListAnswer()[1]);
    }

    private void getDataFromArguemnt() {
        Bundle argument = getArguments();
        currentTopic = argument.getString(TopicActivity.TOPIC);
        currentLesson = argument.getInt(PracticeSyllableActivity.LESSON);
        idQuestion = argument.getInt(PracticeSyllableActivity.QUESTION);
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

        syllableQuestion = listQuestion.get(idQuestion);
        if (syllableQuestion.getLinkAudio() == 0) {
            imgSpeaker.setVisibility(View.GONE);
        }
    }

    private void setUpView() {
        tvQuestion = (TextView) getActivity().findViewById(R.id.tv_syllable_listen_choice_question);
        tvRequest = (TextView) getActivity().findViewById(R.id.tv_request_syllable_listen_choice_question);
        rbChoiceA = (RadioButton) getActivity().findViewById(R.id.radio_button_syllable_listen_choice_question_A);
        rbChoiceB = (RadioButton) getActivity().findViewById(R.id.radio_button_syllable_listen_choice_question_B);
        imgSpeaker = (ImageView) getActivity().findViewById(R.id.bt_speaker_syllable_listen_choice_question);
        imageRightAnswer = (Button) getActivity().findViewById(R.id.image_right_answer);
        imageWrongAnswer = (Button) getActivity().findViewById(R.id.image_wrong_answer);
        btCheckAnswer = (Button) getActivity().findViewById(R.id.button_check_answer_syllable_listen_choice_question);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_speaker_syllable_listen_choice_question:
                speakQuestion();
                break;
            case R.id.radio_button_syllable_listen_choice_question_A:
                stateButtonAnswer = StateButtonAnswer.ANSWER_ALREADY;
                btCheckAnswer.setBackgroundColor(Color.rgb(26, 255, 26));
                break;
            case R.id.radio_button_syllable_listen_choice_question_B:
                stateButtonAnswer = StateButtonAnswer.ANSWER_ALREADY;
                btCheckAnswer.setBackgroundColor(Color.rgb(26, 255, 26));
                break;
            case R.id.button_check_answer_syllable_listen_choice_question:
                changeState(stateButtonAnswer);
                break;
        }
    }

    private void changeState(StateButtonAnswer stateButtonAnswer) {
        switch (stateButtonAnswer) {
            case ANSWER_ALREADY:
                new ChangeStateAsyncTask().execute();
                break;
            case DONE:
                imageWrongAnswer.setVisibility(View.GONE);
                imageRightAnswer.setVisibility(View.GONE);
                mCallBacks.notifyDoneChooseQuestion(result);
                break;

        }
    }

    private void speakQuestion() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (syllableQuestion.getLinkAudio() != 0) {
            mediaPlayer = MediaPlayer.create(getActivity(), syllableQuestion.getLinkAudio());
            mediaPlayer.setOnPreparedListener(this);
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    class ChangeStateAsyncTask extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Void doInBackground(Void... params) {
            publishProgress(getResources().getColor(R.color.check_button));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            btCheckAnswer.setBackgroundColor(values[0]);
            btCheckAnswer.setEnabled(false);
            btCheckAnswer.setText(getResources().getString(R.string.checking));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            stateButtonAnswer = StateButtonAnswer.CHECKING;
            btCheckAnswer.setEnabled(true);
            checkAnswer();
            disableEventClick();
        }
    }

    private void disableEventClick() {
        imgSpeaker.setClickable(false);
        rbChoiceA.setClickable(false);
        rbChoiceB.setClickable(false);
    }

    private void checkAnswer() {
        if (rbChoiceA.isChecked()) {
            if (rbChoiceA.getText().equals(syllableQuestion.getRightAnswer())) {
                new SoundEffect().playTrueSound((AppCompatActivity) getActivity(), mediaPlayer);
                imageRightAnswer.setVisibility(View.VISIBLE);
                result = true;
            } else {
                new SoundEffect().playWrongSound((AppCompatActivity) getActivity(), mediaPlayer);
                imageWrongAnswer.setVisibility(View.VISIBLE);
                result = false;
            }
        }
        if (rbChoiceB.isChecked()) {
            if (rbChoiceB.getText().equals(syllableQuestion.getRightAnswer())) {
                new SoundEffect().playTrueSound((AppCompatActivity) getActivity(), mediaPlayer);
                imageRightAnswer.setVisibility(View.VISIBLE);
                result = true;
            } else {
                new SoundEffect().playWrongSound((AppCompatActivity) getActivity(), mediaPlayer);
                imageWrongAnswer.setVisibility(View.VISIBLE);
                result = false;
            }
        }
        stateButtonAnswer = StateButtonAnswer.DONE;
        btCheckAnswer.setText(getResources().getString(R.string.next_question));
        btCheckAnswer.setBackgroundColor(Color.rgb(26, 255, 26));
    }

    public interface NotifyDoneChooseInterface {
        public void notifyDoneChooseQuestion(boolean result);
    }
}
