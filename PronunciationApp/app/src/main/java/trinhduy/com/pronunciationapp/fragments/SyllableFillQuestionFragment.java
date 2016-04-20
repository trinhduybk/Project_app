package trinhduy.com.pronunciationapp.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
public class SyllableFillQuestionFragment extends Fragment implements View.OnClickListener,MediaPlayer.OnPreparedListener {
    private String currentTopic;
    private int currentLesson;
    private int idQuestion;
    TextView tvRequest,tvQuestion;
    Button imageRightAnswer;
    Button imageWrongAnswer;
    Button btCheckAnswer;
    EditText editAnswer;
    ImageView imgSpeaker;
    ArrayList<SyllableQuestion> listQuestion=new ArrayList<SyllableQuestion>();
    SyllableQuestion syllableQuestion;
    MediaPlayer mediaPlayer;
    private StateButtonAnswer stateButtonAnswer=StateButtonAnswer.NOT_ANSWER_ALREADY;
    String rightAnswerOne;
    String rightAnswerTwo;
    boolean result;
    NotifyDoneFillQuestionInterface mCallBacks;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_syllable_fill_question,container,false);
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
        mCallBacks=(NotifyDoneFillQuestionInterface)activity;
    }

    private void registerForEvent() {
        btCheckAnswer.setOnClickListener(this);
        editAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editAnswer.getText().toString().equals("")) {
                    btCheckAnswer.setBackgroundColor(Color.rgb(204, 204, 179));
                    stateButtonAnswer = StateButtonAnswer.NOT_ANSWER_ALREADY;
                    btCheckAnswer.setText(getResources().getString(R.string.Check));
                } else {
                    btCheckAnswer.setBackgroundColor(Color.rgb(26, 255, 26));
                    stateButtonAnswer = StateButtonAnswer.ANSWER_ALREADY;
                }

            }
        });
        imgSpeaker.setOnClickListener(this);
    }

    private void setUpQuestion() {
        tvRequest.setText(syllableQuestion.getQuestion());
        tvQuestion.setText(syllableQuestion.getQuestionDetail());
    }

    private void getDataFromArguemnt() {
        Bundle argument=getArguments();
        currentTopic=argument.getString(TopicActivity.TOPIC);
        currentLesson=argument.getInt(PracticeSyllableActivity.LESSON);
        idQuestion=argument.getInt(PracticeSyllableActivity.QUESTION);
        switch (currentTopic){
            case TopicActivity.SYLLABLE_LESSON:
                listQuestion= MainActivity.listSyllableQuestion;
                break;
            case TopicActivity.WORD_STRESS_LESSON:
                listQuestion=MainActivity.listWordStressQuestion;
                break;
            case TopicActivity.SENTENCE_STRESS:
                listQuestion=MainActivity.listSentenceStressQuestion;
                break;
            case TopicActivity.LINKING:
                listQuestion=MainActivity.listLinkingQuestion;
                break;
        }
        syllableQuestion=listQuestion.get(idQuestion);
        rightAnswerOne=syllableQuestion.getListAnswer()[0];
        rightAnswerTwo=syllableQuestion.getListAnswer()[1];
        if(syllableQuestion.getLinkAudio()==0){
            imgSpeaker.setVisibility(View.GONE);
        }
    }

    private void setUpView() {
        tvQuestion=(TextView)getActivity().findViewById(R.id.tv_syllable_read_fill_question);
        tvRequest=(TextView)getActivity().findViewById(R.id.tv_request_syllable_read_fill_question);
        imageRightAnswer=(Button)getActivity().findViewById(R.id.image_right_answer);
        imageWrongAnswer=(Button)getActivity().findViewById( R.id.image_wrong_answer);
        btCheckAnswer=(Button)getActivity().findViewById(R.id.button_check_answer_syllable_read_fill_question);
        editAnswer=(EditText)getActivity().findViewById(R.id.edit_answer_syllable_read_fill_question);
        imgSpeaker=(ImageView)getActivity().findViewById(R.id.bt_speaker_syllable_listen_fill_question);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.button_check_answer_syllable_read_fill_question:
                changeState(stateButtonAnswer);
                break;
            case R.id.bt_speaker_syllable_listen_fill_question:
                speakQuestion();
                break;

        }
    }
    private void speakQuestion() {
        if(mediaPlayer!=null){
            mediaPlayer.release();
        }
        if(syllableQuestion.getLinkAudio()!=0) {
            mediaPlayer = MediaPlayer.create(getActivity(), syllableQuestion.getLinkAudio());
            mediaPlayer.setOnPreparedListener(this);
        }
    }

    private void changeState(StateButtonAnswer stateButtonAnswer) {
        switch (stateButtonAnswer){
            case ANSWER_ALREADY:
                new ChangeStateAsyncTask().execute();
                break;
            case DONE:
                imageRightAnswer.setVisibility(View.GONE);
                imageWrongAnswer.setVisibility(View.GONE);
                mCallBacks.notifyDoneFillQuestion(result);
                break;

        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    class ChangeStateAsyncTask extends AsyncTask<Void,Integer,Void> {
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
        editAnswer.setEnabled(false);
    }

    private void checkAnswer() {

        String answer=editAnswer.getText()+"";
        answer=answer.toUpperCase();
        rightAnswerOne=rightAnswerOne.toUpperCase();
        rightAnswerTwo=rightAnswerTwo.toUpperCase();
        if(rightAnswerTwo.equals("")) {
            if (answer.equals(rightAnswerOne)) {
                new SoundEffect().playTrueSound((AppCompatActivity) getActivity(), mediaPlayer);
                imageRightAnswer.setVisibility(View.VISIBLE);
                result = true;
            } else {
                new SoundEffect().playWrongSound((AppCompatActivity) getActivity(), mediaPlayer);
                imageWrongAnswer.setVisibility(View.VISIBLE);
                result = false;
            }
        }else {
            if (answer.equals(rightAnswerOne)||answer.equals(rightAnswerTwo)) {
                new SoundEffect().playTrueSound((AppCompatActivity) getActivity(), mediaPlayer);
                imageRightAnswer.setVisibility(View.VISIBLE);
                result = true;
            } else {
                new SoundEffect().playWrongSound((AppCompatActivity) getActivity(), mediaPlayer);
                imageWrongAnswer.setVisibility(View.VISIBLE);
                result = false;
            }
        }
        stateButtonAnswer=StateButtonAnswer.DONE;
        btCheckAnswer.setText(getResources().getString(R.string.next_question));
        btCheckAnswer.setBackgroundColor(Color.rgb(26, 255, 26));
    }
    public interface  NotifyDoneFillQuestionInterface{
        public void notifyDoneFillQuestion(boolean result);
    }
}
