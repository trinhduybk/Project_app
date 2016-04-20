package trinhduy.com.pronunciationapp.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.activities.MainActivity;
import trinhduy.com.pronunciationapp.activities.PracticeSyllableActivity;
import trinhduy.com.pronunciationapp.activities.TopicActivity;
import trinhduy.com.pronunciationapp.models.StaticVariable;
import trinhduy.com.pronunciationapp.models.SyllableQuestion;
import trinhduy.com.pronunciationapp.models.WordData;

import java.util.ArrayList;

/**
 * Created by SON on 2/15/2016.
 */
public class PracticeSpeakingFragment extends Fragment implements RecognitionListener, MediaPlayer.OnPreparedListener {
    Button btNextQuestion;
    ImageView btRecord;
    TextView tvWordQuestion;
    TextView tvRequest;
    Button imageRightAnswer;
    Button imageWrongAnswer;
    MediaPlayer mediaPlayer;
    WordData wordQuestion;
    int numberStar;
    int numberQuestion;
    int score;
    int positionLessonSound;
    int numberOfSpeech = 5;
    boolean result;
    ArrayList<WordData> listWord = new ArrayList<WordData>();
    ArrayList<SyllableQuestion> listQuestion = new ArrayList<SyllableQuestion>();
    SyllableQuestion question;
    String currentTopic;
    int lessonId;
    int positionLesson;
    NotifyDoneQuestion mCallBack;
    SpeechRecognizer speechRecognizer = null;
    private Intent recognizerIntent;
    private String LOG_TAG = "VoiceRecognitionActivity";
    String answer;

    public PracticeSpeakingFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = (View) inflater.inflate(R.layout.fragment_speak_question, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpView();
        registerEvent();

    }

    private void registerEvent() {
        btRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speechRecognizer.startListening(recognizerIntent);
                btRecord.setImageResource(R.drawable.record_red);
            }
        });
        btNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (numberQuestion < 20) {
//                    tvResult.setText("");
//                    numberOfSpeech = 5;
//                    numberQuestion++;
//                    setUpQuestion();
//                    tvNumberQuestion.setText(numberQuestion + "/20");
//                    btNextQuestion.setBackgroundColor(getResources().getColor(R.color.check_button));
//                    imgResult.setAlpha(0.0f);
//                } else {
//                    mCallBack.notifyDoneQuestion(true);
//
//                }
                imageRightAnswer.setVisibility(View.GONE);
                imageWrongAnswer.setVisibility(View.GONE);
                mCallBack.notifyDoneQuestion(result);
            }
        });
    }

    public void setUpQuestion() {
        switch (currentTopic) {
            case TopicActivity.SOUND_LESSON:
                int wordPosition = numberQuestion % listWord.size();
                wordQuestion = listWord.get(wordPosition);
                tvWordQuestion.setText(wordQuestion.getWord());
                break;
            case TopicActivity.WORD_STRESS_LESSON:
                question = listQuestion.get(positionLesson);
                tvWordQuestion.setText(question.getQuestionDetail());
                tvRequest.setText(question.getQuestion());
                break;
            case TopicActivity.SENTENCE_STRESS:
                question = listQuestion.get(positionLesson);
                tvWordQuestion.setText(question.getQuestionDetail());
                tvRequest.setText(question.getQuestion());
                break;
            case TopicActivity.SYLLABLE_LESSON:
                question = listQuestion.get(positionLesson);
                tvWordQuestion.setText(question.getQuestionDetail());
                tvRequest.setText(question.getQuestion());
                break;
            case TopicActivity.LINKING:
                question = listQuestion.get(positionLesson);
                tvWordQuestion.setText(question.getQuestionDetail());
                tvRequest.setText(question.getQuestion());
                break;


        }


    }

    private void setUpView() {
        btNextQuestion = (Button) getActivity().findViewById(R.id.bt_next_question_speaking_question);
        btRecord = (ImageView) getActivity().findViewById(R.id.btRecord_speaking_question);
        tvWordQuestion = (TextView) getActivity().findViewById(R.id.tv_word_practice_speaking_question);
        tvRequest = (TextView) getActivity().findViewById(R.id.tv_request_speaking_question);
        imageRightAnswer = (Button) getActivity().findViewById(R.id.image_right_answer);
        imageWrongAnswer = (Button) getActivity().findViewById(R.id.image_wrong_answer);
        getDataFromPreviousFragment();
//        updateResult(numberStar, numberQuestion, score);

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(getActivity());
        speechRecognizer.setRecognitionListener(this);
        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE,
                "en");
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                getActivity().getPackageName());
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);
    }

    private void getDataFromPreviousFragment() {
        Bundle argument = getArguments();
        currentTopic = argument.getString(TopicActivity.TOPIC);
        switch (currentTopic) {
            case TopicActivity.SOUND_LESSON:
                numberQuestion = argument.getInt(StaticVariable.NUM_OF_QUESTION);
                positionLessonSound = argument.getInt(StaticVariable.POSITION);
                String position;
                if (positionLessonSound < 10) {
                    position = "0" + positionLessonSound;
                } else {
                    position = positionLessonSound + "";
                }
                for (WordData wordData : MainActivity.listExampleWord) {
                    if (wordData.getGroup().equals(position))
                        listWord.add(wordData);
                }
                break;
            case TopicActivity.WORD_STRESS_LESSON:
                lessonId = argument.getInt(PracticeSyllableActivity.LESSON);
                positionLesson = argument.getInt(PracticeSyllableActivity.QUESTION);
                listQuestion = MainActivity.listWordStressQuestion;
                break;
            case TopicActivity.SENTENCE_STRESS:
                lessonId = argument.getInt(PracticeSyllableActivity.LESSON);
                positionLesson = argument.getInt(PracticeSyllableActivity.QUESTION);
                listQuestion = MainActivity.listSentenceStressQuestion;
                break;
            case TopicActivity.LINKING:
                lessonId = argument.getInt(PracticeSyllableActivity.LESSON);
                positionLesson = argument.getInt(PracticeSyllableActivity.QUESTION);
                listQuestion = MainActivity.listLinkingQuestion;
                break;
            case TopicActivity.SYLLABLE_LESSON:
                lessonId = argument.getInt(PracticeSyllableActivity.LESSON);
                positionLesson = argument.getInt(PracticeSyllableActivity.QUESTION);
                listQuestion = MainActivity.listSyllableQuestion;
                break;
        }

        setUpQuestion();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallBack = (NotifyDoneQuestion) activity;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        if (speechRecognizer != null) {
            speechRecognizer.destroy();
            Log.i(LOG_TAG, "destroy");
        }
        super.onDestroyView();
    }

    @Override
    public void onBeginningOfSpeech() {
        Log.i(LOG_TAG, "onBeginningOfSpeech");
    }

    @Override
    public void onBufferReceived(byte[] buffer) {
        Log.i(LOG_TAG, "onBufferReceived: " + buffer);
    }

    @Override
    public void onEndOfSpeech() {
        Log.i(LOG_TAG, "onEndOfSpeech");
        speechRecognizer.stopListening();
        btRecord.setImageResource(R.drawable.record);
    }

    @Override
    public void onError(int errorCode) {
        String errorMessage = getErrorText(errorCode);
        Log.d(LOG_TAG, "FAILED " + errorMessage);
    }

    @Override
    public void onEvent(int arg0, Bundle arg1) {
        Log.i(LOG_TAG, "onEvent");
    }

    @Override
    public void onPartialResults(Bundle arg0) {
        Log.i(LOG_TAG, "onPartialResults");
    }

    @Override
    public void onReadyForSpeech(Bundle arg0) {
        Log.i(LOG_TAG, "onReadyForSpeech");
    }

    @Override
    public void onResults(Bundle results) {
        Log.i(LOG_TAG, "onResults");
        ArrayList<String> matches = results
                .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        String text = matches.get(0) + "";
        checkAnswer(text);

    }

    private void checkAnswer(String text) {
        if (question != null) {
            answer = question.getRightAnswer() + "";
        } else {
            answer = wordQuestion.getWord() + "";
        }
        if (text.equals(answer)) {
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.right_answer_pronunciation);
            mediaPlayer.setOnPreparedListener(this);
            imageRightAnswer.setVisibility(View.VISIBLE);
            score++;
            btNextQuestion.setBackgroundColor(getResources().getColor(R.color.button_keyboard_practice_color_enable));
            result = true;

        } else {
            numberOfSpeech--;

            if (numberOfSpeech < 0) {
                numberStar--;
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.wrong_answer_pronuncation);
                mediaPlayer.setOnPreparedListener(this);
                imageWrongAnswer.setVisibility(View.VISIBLE);
                btNextQuestion.setBackgroundColor(getResources().getColor(R.color.button_keyboard_practice_color_enable));
                result = false;

            } else {
                Toast.makeText(getActivity(), "You pronounce " + text + ".You have " + numberOfSpeech + " times to try.Try again!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onRmsChanged(float rmsdB) {
        Log.i(LOG_TAG, "onRmsChanged: " + rmsdB);
    }

    public static String getErrorText(int errorCode) {
        String message;
        switch (errorCode) {
            case SpeechRecognizer.ERROR_AUDIO:
                message = "Audio recording error";
                break;
            case SpeechRecognizer.ERROR_CLIENT:
                message = "Client side error";
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                message = "Insufficient permissions";
                break;
            case SpeechRecognizer.ERROR_NETWORK:
                message = "Network error";
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                message = "Network timeout";
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
                message = "No match";
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                message = "RecognitionService busy";
                break;
            case SpeechRecognizer.ERROR_SERVER:
                message = "error from server";
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                message = "No speech input";
                break;
            default:
                message = "Didn't understand, please try again.";
                break;
        }
        return message;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }


    public interface FinishSpeakingPractice {
        public void finishSpeakingPractice(boolean success);
    }

    public interface NotifyDoneQuestion {
        public void notifyDoneQuestion(boolean result);
    }

}
