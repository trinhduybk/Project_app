package trinhduy.com.pronunciationapp.activities;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import trinhduy.com.pronunciationapp.fragments.LessonFragment;
import trinhduy.com.pronunciationapp.fragments.PracticeFailFragment;
import trinhduy.com.pronunciationapp.fragments.PracticeSpeakingFragment;
import trinhduy.com.pronunciationapp.models.ButtonAnswerPosition;
import trinhduy.com.pronunciationapp.fragments.CurrentFragmentPractice;
import trinhduy.com.pronunciationapp.fragments.FinishPracticeFragment;
import trinhduy.com.pronunciationapp.fragments.PracticeSoundListenFragment;
import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.models.SoundData;
import trinhduy.com.pronunciationapp.models.StaticVariable;
import trinhduy.com.pronunciationapp.models.WordData;
import trinhduy.com.pronunciationapp.utils.TextToSpeechUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by SON on 1/11/2016.
 */
public class PracticeActivity extends AppCompatActivity implements PracticeSoundListenFragment.AnswerButtonClicked,
        View.OnClickListener, FinishPracticeFragment.FinishInterface,
        MediaPlayer.OnPreparedListener, PracticeFailFragment.FinishAfterFailInterface, PracticeSpeakingFragment.NotifyDoneQuestion {
    private FragmentManager fragmentManager;
    PracticeSoundListenFragment practiceSoundListenFragment;
    FinishPracticeFragment finishPracticeFragment;
    PracticeFailFragment practiceFailFragment;
    PracticeSpeakingFragment practiceSpeakingSoundFragment;
    Button btPracticeAnswer1;
    Button btPracticeAnswer2;
    Button btPracticeAnswer3;
    Button btPracticeAnswer4;
    Button btPracticeAnswer5;
    Button btPracticeAnswer6;
    Button btPracticeAnswer7;
    Button btPracticeAnswer8;
    Button btCheckAnswer;
    EditText editAnswer;
    TextView tvQuestion;
    TextView tvRequest;
    TextView tvScore;
    ImageView imgSoundSpeaker;
    ImageView practiceStarOne;
    ImageView practiceStarTwo;
    ImageView practiceStarThree;
    Button imageRightAnswer;
    Button imageWrongAnswer;
    ProgressBar progressBarScore;
    List<SoundData> soundDataList = new ArrayList<SoundData>();
    WordData wordQuestion = null;
    ArrayList<WordData> listWord = new ArrayList<WordData>();
    int listWordLength;
    Boolean wantToBack = false;
    StateButtonAnswer stateButtonAnswer = StateButtonAnswer.NOT_ANSWER_ALREADY;
    MediaPlayer mediaPlayer;
    ObjectAnimator translateButtonX = new ObjectAnimator();
    ObjectAnimator translateButtonY = new ObjectAnimator();
    int countClickButtonAnswer[] = new int[8];
    int countButtonInAnswer = 0;
    int countQuestionPractice = 0;
    int points = 0;
    int stars = 3;
    int positionLesson;
    float arrBtAnswerPosX[] = new float[16];
    float arrBtAnswerPosY[] = new float[16];
    HashMap<Integer, ButtonAnswerPosition> stackForListening = new HashMap<Integer, ButtonAnswerPosition>();
    TextToSpeechUtil textToSpeechUtil;
    boolean firstFocus = true;
    String resultQuestion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_sound);
        setUpView();

    }

    private void addListeningPracticeFragment() {
        Log.e("setUpView", "1");
        practiceSoundListenFragment = new PracticeSoundListenFragment();
        // Start a new FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(R.id.fr_practice_sound, practiceSoundListenFragment);
        fragmentTransaction.commit();
    }

    private void addFinishPracticeFragment() {
        finishPracticeFragment = FinishPracticeFragment.newInstance(positionLesson + "");
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(R.id.fr_practice_sound, finishPracticeFragment);
        fragmentTransaction.commit();

    }

    private void addFinishAfterFail() {
        practiceFailFragment = new PracticeFailFragment();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(R.id.fr_practice_sound, practiceFailFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onListeningPraticeButtonCheckClick(int id) {
        switch (id) {
            case R.id.practice_listening_sound_button_check_answer:
//                addReadingPracticeFragment();

                break;
        }
    }

    private void registerForEventClick() {
        btPracticeAnswer1.setOnClickListener(this);
        btPracticeAnswer2.setOnClickListener(this);
        btPracticeAnswer3.setOnClickListener(this);
        btPracticeAnswer4.setOnClickListener(this);
        btPracticeAnswer5.setOnClickListener(this);
        btPracticeAnswer6.setOnClickListener(this);
        btPracticeAnswer7.setOnClickListener(this);
        btPracticeAnswer8.setOnClickListener(this);
        btCheckAnswer.setOnClickListener(this);
        imgSoundSpeaker.setOnClickListener(this);
        editAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkAnswerAlready(countButtonInAnswer);

            }
        });
    }

    private void setUpView() {
        progressBarScore = (ProgressBar) findViewById(R.id.progress_score);
        imageRightAnswer = (Button) findViewById(R.id.image_right_answer);
        imageWrongAnswer = (Button) findViewById(R.id.image_wrong_answer);
        textToSpeechUtil = TextToSpeechUtil.getInst(getApplicationContext());
        getDataFromIntent();
        fragmentManager = getFragmentManager();
        addListeningPracticeFragment();
    }

    private void getDataFromIntent() {
        positionLesson = getIntent().getIntExtra(LessonFragment.POSITION_LESSON, 0) + 1;
        String position;
        if (positionLesson < 10) {
            position = "0" + positionLesson;
        } else {
            position = positionLesson + "";
        }
        for (WordData wordData : MainActivity.listExampleWord) {
            if (wordData.getGroup().equals(position))
                listWord.add(wordData);
        }
        listWordLength = listWord.size();
    }

    public void checkAnswerAlready(int countButtonInAnswer) {
        if (countButtonInAnswer > 0) {
            btCheckAnswer.setBackgroundResource(R.drawable.button_already);
            stateButtonAnswer = StateButtonAnswer.ANSWER_ALREADY;
        } else {
            btCheckAnswer.setBackgroundResource(R.drawable.button);
            stateButtonAnswer = StateButtonAnswer.NOT_ANSWER_ALREADY;
            btCheckAnswer.setText(getResources().getString(R.string.Check));
        }
        if (countQuestionPractice >= 11) {
            if (editAnswer.getText().toString().equals("")) {
                btCheckAnswer.setBackgroundResource(R.drawable.button);
                stateButtonAnswer = StateButtonAnswer.NOT_ANSWER_ALREADY;
                btCheckAnswer.setText(getResources().getString(R.string.Check));
            } else {
                btCheckAnswer.setBackgroundResource(R.drawable.button_already);
                stateButtonAnswer = StateButtonAnswer.ANSWER_ALREADY;
            }
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_practice_listening_answer1:
                moveButton(R.id.bt_practice_listening_answer1, 1);
                break;
            case R.id.bt_practice_listening_answer2:
                moveButton(R.id.bt_practice_listening_answer2, 2);
                break;
            case R.id.bt_practice_listening_answer3:
                moveButton(R.id.bt_practice_listening_answer3, 3);
                break;
            case R.id.bt_practice_listening_answer4:
                moveButton(R.id.bt_practice_listening_answer4, 4);
                break;
            case R.id.bt_practice_listening_answer5:
                moveButton(R.id.bt_practice_listening_answer5, 5);
                break;
            case R.id.bt_practice_listening_answer6:
                moveButton(R.id.bt_practice_listening_answer6, 6);
                break;
            case R.id.bt_practice_listening_answer7:
                moveButton(R.id.bt_practice_listening_answer7, 7);
                break;
            case R.id.bt_practice_listening_answer8:
                moveButton(R.id.bt_practice_listening_answer8, 8);
                break;
            case R.id.practice_listening_sound_button_check_answer:
                changeStateButton(stateButtonAnswer);
                break;
            case R.id.bt_practice_listening_speaker:
                speakWord();
                break;
        }
    }

    private void speakWord() {
        String word = wordQuestion.getWord() + "";
        textToSpeechUtil.speakWordOrSentence(word);

    }

    public void moveButton(int buttonId, int index) {
        if (stateButtonAnswer != StateButtonAnswer.DONE) {
            if (countClickButtonAnswer[index - 1] % 2 == 0) {
                countClickButtonAnswer[index - 1]++;
                countButtonInAnswer++;
                moveToAnswer(buttonId, countButtonInAnswer - 1, CurrentFragmentPractice.PRACTICE_SOUND_LISTENING);
            } else {
                moveBack(buttonId);
            }
            checkAnswerAlready(countButtonInAnswer);
        }
    }

    private void checkAnswer() {
        if (countQuestionPractice <= 10) {
            resultQuestion = wordQuestion.getPhonetic();
        } else {
            resultQuestion = wordQuestion.getWord();
        }
        String result = "";
        if (countQuestionPractice <= 10) {
            for (int i = 0; i < stackForListening.size(); i++) {
                result = result + stackForListening.get(i + 1).getText();
            }
        } else {
            result = editAnswer.getText() + "";
        }
        Log.e("Result", result + "");
        if (result.equals(wordQuestion.getPhonetic()) || result.equals(wordQuestion.getWord())) {
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.right_answer_pronunciation);
            mediaPlayer.setOnPreparedListener(this);
            points++;
            tvScore.setText(points + " points");
            imageRightAnswer.setVisibility(View.VISIBLE);
        } else {
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            imageWrongAnswer.setVisibility(View.VISIBLE);
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.wrong_answer_pronuncation);
            mediaPlayer.setOnPreparedListener(this);
            imageWrongAnswer.setText("You wrong!\n" + "\r\n" + resultQuestion);
            stars--;
            checkStar(stars);
            if (stars < 0) {
                addFinishAfterFail();
            }
        }
        btCheckAnswer.setText(getResources().getString(R.string.next_question));
        btCheckAnswer.setBackgroundResource(R.drawable.button_already);
        stateButtonAnswer = StateButtonAnswer.DONE;
    }

    private void changeStateButton(StateButtonAnswer stateAnswer) {
        if (countQuestionPractice <= 15) {
            switch (stateAnswer) {
                case ANSWER_ALREADY:
                    new ChangeStateAsyncTask().execute();
                    break;
                case DONE:
                    imageWrongAnswer.setVisibility(View.GONE);
                    imageRightAnswer.setVisibility(View.GONE);
                    resultQuestion = "";
                    wantToBack = false;
                    if (countButtonInAnswer > 0) {
                        removeButonAnswer(countQuestionPractice);
                    }
                    changeRequest(countQuestionPractice);
                    countButtonInAnswer = 0;
                    countClickButtonAnswer = new int[8];
                    countQuestionPractice++;
                    setupQuestion();
                    progressBarScore.setProgress(countQuestionPractice * 100 / 20);
                    stateButtonAnswer = StateButtonAnswer.NOT_ANSWER_ALREADY;
                    editAnswer.setText("");
                    checkAnswerAlready(countButtonInAnswer);

                    break;
            }
            if (countQuestionPractice == 16) {

                addSpeakingPracticeFragment(positionLesson, countQuestionPractice, TopicActivity.SOUND_LESSON);
            }
            if (countQuestionPractice > 20) {
                addFinishPracticeFragment();
            }

        }

    }

    private void changeRequest(int countQuestionPractice) {
        switch (countQuestionPractice) {
            case 5:
                tvRequest.setText(getResources().getString(R.string.writing_practice_sound));
                break;
            case 10:
                editAnswer.setAlpha(1);
                tvRequest.setText(getResources().getString(R.string.reading_practice_sound));
                tvQuestion.setText(wordQuestion.getPhonetic());
                break;
        }

    }

    private void removeButonAnswer(int countQuestionPractice) {
        moveBack(stackForListening.get(1).getButton_id());
        if (countQuestionPractice == 10) {
            btPracticeAnswer1.setEnabled(false);
            btPracticeAnswer1.setAlpha(0);
            btPracticeAnswer2.setEnabled(false);
            btPracticeAnswer2.setAlpha(0);
            btPracticeAnswer3.setEnabled(false);
            btPracticeAnswer3.setAlpha(0);
            btPracticeAnswer4.setEnabled(false);
            btPracticeAnswer4.setAlpha(0);
            btPracticeAnswer5.setEnabled(false);
            btPracticeAnswer5.setAlpha(0);
            btPracticeAnswer6.setEnabled(false);
            btPracticeAnswer6.setAlpha(0);
            btPracticeAnswer7.setEnabled(false);
            btPracticeAnswer7.setAlpha(0);
            btPracticeAnswer8.setEnabled(false);
            btPracticeAnswer8.setAlpha(0);
            editAnswer.setClickable(true);
            editAnswer.setFocusable(true);
            editAnswer.setFocusableInTouchMode(true);

        }
        if (countQuestionPractice == 5) {
            imgSoundSpeaker.setEnabled(false);
            imgSoundSpeaker.setAlpha(0.0f);
        }


    }

    public void moveToAnswer(int id, int position, CurrentFragmentPractice currentFragmentPractice) {
        Button btPracticeListeningAnswer1 = (Button) findViewById(id);
        playPronunciationSound(btPracticeListeningAnswer1);
        LinearLayout layoutButtonContainer = new LinearLayout(PracticeActivity.this);
        int bt_click = 0;
        switch (id) {
            case R.id.bt_practice_listening_answer1:
                bt_click = 1;
                break;
            case R.id.bt_practice_listening_answer2:
                bt_click = 2;
                break;
            case R.id.bt_practice_listening_answer3:
                bt_click = 3;
                break;
            case R.id.bt_practice_listening_answer4:
                bt_click = 4;
                break;
            case R.id.bt_practice_listening_answer5:
                bt_click = 5;
                break;
            case R.id.bt_practice_listening_answer6:
                bt_click = 6;
                break;
            case R.id.bt_practice_listening_answer7:
                bt_click = 7;
                break;
            case R.id.bt_practice_listening_answer8:
                bt_click = 8;
                break;
        }
        switch (currentFragmentPractice) {
            case PRACTICE_SOUND_LISTENING:
                layoutButtonContainer = (LinearLayout) findViewById(R.id.word_and_sound);
                break;
        }
        float layoutButtonContainerposX = layoutButtonContainer.getX();
        float layoutButtonContainerposY = layoutButtonContainer.getY() - 100;
        translateButtonX.setStartDelay(0);
        translateButtonX.setRepeatCount(0);
        translateButtonX.setRepeatMode(ValueAnimator.REVERSE);
        translateButtonX.setInterpolator(new LinearInterpolator());
        translateButtonY.setStartDelay(0);
        translateButtonY.setRepeatCount(0);
        translateButtonY.setRepeatMode(ValueAnimator.REVERSE);
        translateButtonY.setInterpolator(new LinearInterpolator());
        switch (position) {
            case 0:
                startAnimation(btPracticeListeningAnswer1, bt_click, layoutButtonContainerposX, layoutButtonContainerposY, 0);
                stackForListening.put(countButtonInAnswer, new ButtonAnswerPosition(id, bt_click, btPracticeListeningAnswer1.getText() + "", layoutButtonContainerposX + 0, layoutButtonContainerposY));
                break;
            case 1:
                startAnimation(btPracticeListeningAnswer1, bt_click, layoutButtonContainerposX, layoutButtonContainerposY, 110);
                stackForListening.put(countButtonInAnswer, new ButtonAnswerPosition(id, bt_click, btPracticeListeningAnswer1.getText() + "", layoutButtonContainerposX + 90, layoutButtonContainerposY));
                break;
            case 2:
                startAnimation(btPracticeListeningAnswer1, bt_click, layoutButtonContainerposX, layoutButtonContainerposY, 220);
                stackForListening.put(countButtonInAnswer, new ButtonAnswerPosition(id, bt_click, btPracticeListeningAnswer1.getText() + "", layoutButtonContainerposX + 180, layoutButtonContainerposY));
                break;
            case 3:
                startAnimation(btPracticeListeningAnswer1, bt_click, layoutButtonContainerposX, layoutButtonContainerposY, 330);
                stackForListening.put(countButtonInAnswer, new ButtonAnswerPosition(id, bt_click, btPracticeListeningAnswer1.getText() + "", layoutButtonContainerposX + 270, layoutButtonContainerposY));
                break;
            case 4:
                startAnimation(btPracticeListeningAnswer1, bt_click, layoutButtonContainerposX, layoutButtonContainerposY + 80, 0);
                stackForListening.put(countButtonInAnswer, new ButtonAnswerPosition(id, bt_click, btPracticeListeningAnswer1.getText() + "", layoutButtonContainerposX + 0, layoutButtonContainerposY + 80));
                break;
            case 5:
                startAnimation(btPracticeListeningAnswer1, bt_click, layoutButtonContainerposX, layoutButtonContainerposY + 80, 110);
                stackForListening.put(countButtonInAnswer, new ButtonAnswerPosition(id, bt_click, btPracticeListeningAnswer1.getText() + "", layoutButtonContainerposX + 90, layoutButtonContainerposY + 80));
                break;
            case 6:
                startAnimation(btPracticeListeningAnswer1, bt_click, layoutButtonContainerposX, layoutButtonContainerposY + 80, 220);
                stackForListening.put(countButtonInAnswer, new ButtonAnswerPosition(id, bt_click, btPracticeListeningAnswer1.getText() + "", layoutButtonContainerposX + 180, layoutButtonContainerposY + 80));
                break;
            case 7:
                startAnimation(btPracticeListeningAnswer1, bt_click, layoutButtonContainerposX, layoutButtonContainerposY + 80, 330);
                stackForListening.put(countButtonInAnswer, new ButtonAnswerPosition(id, bt_click, btPracticeListeningAnswer1.getText() + "", layoutButtonContainerposX + 270, layoutButtonContainerposY + 80));
                break;
        }


    }

    public void startAnimation(Button btPracticeListeningAnswer1, int bt_click, float layoutButtonContainerposX,
                               float layoutButtonContainerposY, int offset) {

        translateButtonX = ObjectAnimator.ofFloat(btPracticeListeningAnswer1, "x",
                new float[]{arrBtAnswerPosX[bt_click - 1], layoutButtonContainerposX + offset}).setDuration(1000);
        translateButtonY = ObjectAnimator.ofFloat(btPracticeListeningAnswer1, "y",
                new float[]{arrBtAnswerPosY[bt_click - 1], layoutButtonContainerposY}).setDuration(1000);
        final AnimatorSet animation = new AnimatorSet();
        ((AnimatorSet) animation).playTogether(translateButtonY, translateButtonX);
        animation.start();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (firstFocus) {
            btPracticeAnswer1 = (Button) findViewById(R.id.bt_practice_listening_answer1);
            btPracticeAnswer2 = (Button) findViewById(R.id.bt_practice_listening_answer2);
            btPracticeAnswer3 = (Button) findViewById(R.id.bt_practice_listening_answer3);
            btPracticeAnswer4 = (Button) findViewById(R.id.bt_practice_listening_answer4);
            btPracticeAnswer5 = (Button) findViewById(R.id.bt_practice_listening_answer5);
            btPracticeAnswer6 = (Button) findViewById(R.id.bt_practice_listening_answer6);
            btPracticeAnswer7 = (Button) findViewById(R.id.bt_practice_listening_answer7);
            btPracticeAnswer8 = (Button) findViewById(R.id.bt_practice_listening_answer8);
            btCheckAnswer = (Button) findViewById(R.id.practice_listening_sound_button_check_answer);
            editAnswer = (EditText) findViewById(R.id.edit_answer_practice_reading);
            tvQuestion = (TextView) findViewById(R.id.tv_word_practice);
            tvScore = (TextView) findViewById(R.id.tvScore);
            practiceStarOne = (ImageView) findViewById(R.id.practice_star_one);
            practiceStarTwo = (ImageView) findViewById(R.id.practice_star_two);
            practiceStarThree = (ImageView) findViewById(R.id.practice_star_three);

            imgSoundSpeaker = (ImageView) findViewById(R.id.bt_practice_listening_speaker);
            tvRequest = (TextView) findViewById(R.id.tv_request_listening);

//        progressBarScore.getProgressDrawable().setColorFilter(
//                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);


            if (btPracticeAnswer1 != null && !wantToBack) {
                arrBtAnswerPosX[0] = btPracticeAnswer1.getX();
                arrBtAnswerPosY[0] = btPracticeAnswer1.getY();
                arrBtAnswerPosX[1] = btPracticeAnswer2.getX();
                arrBtAnswerPosY[1] = btPracticeAnswer2.getY();
                arrBtAnswerPosX[2] = btPracticeAnswer3.getX();
                arrBtAnswerPosY[2] = btPracticeAnswer3.getY();
                arrBtAnswerPosX[3] = btPracticeAnswer4.getX();
                arrBtAnswerPosY[3] = btPracticeAnswer4.getY();
                arrBtAnswerPosX[4] = btPracticeAnswer5.getX();
                arrBtAnswerPosY[4] = btPracticeAnswer5.getY();
                arrBtAnswerPosX[5] = btPracticeAnswer6.getX();
                arrBtAnswerPosY[5] = btPracticeAnswer6.getY();
                arrBtAnswerPosX[6] = btPracticeAnswer7.getX();
                arrBtAnswerPosY[6] = btPracticeAnswer7.getY();
                arrBtAnswerPosX[7] = btPracticeAnswer8.getX();
                arrBtAnswerPosY[7] = btPracticeAnswer8.getY();
                countQuestionPractice = 1;
                editAnswer.setFocusable(false);
                editAnswer.setAlpha(0);
                setupQuestion();
                registerForEventClick();
            }
            firstFocus = false;
        }
    }

    private void moveBack(int bt_practice_listening_answer) {
        for (int i = countButtonInAnswer; i > 0; i--) {
            if (stackForListening.get(i).getButton_id() != bt_practice_listening_answer) {
                Button btAnswer = (Button) findViewById(stackForListening.get(i).getButton_id());

                if (btAnswer != null) {
                    countButtonInAnswer--;
                    countClickButtonAnswer[stackForListening.get(i).getBt_situation() - 1]--;
                    translateButtonX = ObjectAnimator.ofFloat(btAnswer, "x",
                            new float[]{btAnswer.getX(), arrBtAnswerPosX[stackForListening.get(i).getBt_situation() - 1]}).setDuration(1000);
                    translateButtonY = ObjectAnimator.ofFloat(btAnswer, "y",
                            new float[]{btAnswer.getY(), arrBtAnswerPosY[stackForListening.get(i).getBt_situation() - 1]}).setDuration(1000);
                    final AnimatorSet animation = new AnimatorSet();
                    ((AnimatorSet) animation).playTogether(translateButtonY, translateButtonX);
                    stackForListening.remove(i);
                    animation.start();

                }
            } else {
                Button btAnswer = (Button) findViewById(stackForListening.get(i).getButton_id());

                if (btAnswer != null) {

                    countButtonInAnswer--;
                    countClickButtonAnswer[stackForListening.get(i).getBt_situation() - 1]--;
                    translateButtonX = ObjectAnimator.ofFloat(btAnswer, "x",
                            new float[]{btAnswer.getX(), arrBtAnswerPosX[stackForListening.get(i).getBt_situation() - 1]}).setDuration(1000);
                    translateButtonY = ObjectAnimator.ofFloat(btAnswer, "y",
                            new float[]{btAnswer.getY(), arrBtAnswerPosY[stackForListening.get(i).getBt_situation() - 1]}).setDuration(1000);
                    final AnimatorSet animation = new AnimatorSet();
                    ((AnimatorSet) animation).playTogether(translateButtonY, translateButtonX);
                    stackForListening.remove(i);
                    animation.start();
                    break;
                }
            }
        }
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    public void finishActivityAfterFail() {
        finish();
    }

    public void playPronunciationSound(Button button) {
        String str = button.getText().toString();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.release();
        }
        if (str.equals(getResources().getString(R.string.sound01))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound01);
        }
        if (str.equals(getResources().getString(R.string.sound02))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound02);
        }
        if (str.equals(getResources().getString(R.string.sound03))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound03);
        }
        if (str.equals(getResources().getString(R.string.sound04))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound04);
        }
        if (str.equals(getResources().getString(R.string.sound05))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound05);
        }
        if (str.equals(getResources().getString(R.string.sound06))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound06);
        }
        if (str.equals(getResources().getString(R.string.sound07))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound07);
        }
        if (str.equals(getResources().getString(R.string.sound08))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound08);
        }
        if (str.equals(getResources().getString(R.string.sound09))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound09);
        }
        if (str.equals(getResources().getString(R.string.sound10))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound10);
        }
        if (str.equals(getResources().getString(R.string.sound11))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound11);
        }
        if (str.equals(getResources().getString(R.string.sound12))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound12);
        }
        if (str.equals(getResources().getString(R.string.sound13))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound13);
        }
        if (str.equals(getResources().getString(R.string.sound14))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound14);
        }
        if (str.equals(getResources().getString(R.string.sound15))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound15);
        }
        if (str.equals(getResources().getString(R.string.sound16))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound16);
        }
        if (str.equals(getResources().getString(R.string.sound17))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound17);
        }
        if (str.equals(getResources().getString(R.string.sound18))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound18);
        }
        if (str.equals(getResources().getString(R.string.sound19))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound19);
        }
        if (str.equals(getResources().getString(R.string.sound20))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound20);
        }
        if (str.equals(getResources().getString(R.string.sound21))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound21);
        }
        if (str.equals(getResources().getString(R.string.sound22))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound22);
        }
        if (str.equals(getResources().getString(R.string.sound23))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound23);
        }
        if (str.equals(getResources().getString(R.string.sound24))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound24);
        }
        if (str.equals(getResources().getString(R.string.sound25))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound25);
        }
        if (str.equals(getResources().getString(R.string.sound26))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound26);
        }
        if (str.equals(getResources().getString(R.string.sound27))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound27);
        }
        if (str.equals(getResources().getString(R.string.sound28))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound28);
        }
        if (str.equals(getResources().getString(R.string.sound29))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound29);
        }
        if (str.equals(getResources().getString(R.string.sound30))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound30);
        }
        if (str.equals(getResources().getString(R.string.sound31))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound31);
        }
        if (str.equals(getResources().getString(R.string.sound32))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound32);
        }
        if (str.equals(getResources().getString(R.string.sound33))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound33);
        }
        if (str.equals(getResources().getString(R.string.sound34))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound34);
        }
        if (str.equals(getResources().getString(R.string.sound35))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound35);
        }
        if (str.equals(getResources().getString(R.string.sound36))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound36);
        }
        if (str.equals(getResources().getString(R.string.sound37))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound37);
        }
        if (str.equals(getResources().getString(R.string.sound38))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound38);
        }
        if (str.equals(getResources().getString(R.string.sound39))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound39);
        }
        if (str.equals(getResources().getString(R.string.sound40))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound40);
        }
        if (str.equals(getResources().getString(R.string.sound41))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound41);
        }
        if (str.equals(getResources().getString(R.string.sound42))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound42);
        }
        if (str.equals(getResources().getString(R.string.sound43))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound43);
        }
        if (str.equals(getResources().getString(R.string.sound44))) {
            mediaPlayer = MediaPlayer.create(PracticeActivity.this, R.raw.sound44);
        }
        mediaPlayer.setOnPreparedListener(this);
    }

    public void setupQuestion() {
        String soundPhonetic[];
        int[] array;
        boolean kt;
        soundDataList = MainActivity.listSound;
        randomTextForButton(btPracticeAnswer1);
        randomTextForButton(btPracticeAnswer2);
        randomTextForButton(btPracticeAnswer3);
        randomTextForButton(btPracticeAnswer4);
        randomTextForButton(btPracticeAnswer5);
        randomTextForButton(btPracticeAnswer6);
        randomTextForButton(btPracticeAnswer7);
        randomTextForButton(btPracticeAnswer8);
        Random random = new Random();
        int wordPosition = countQuestionPractice % listWordLength;
        wordQuestion = listWord.get(wordPosition);
        if (countQuestionPractice > 5) {
            tvQuestion.setText(wordQuestion.getWord());
        }
        int numOfPhonetic = wordQuestion.getNumberPhonetic().length() / 2;
        soundPhonetic = new String[numOfPhonetic];
        array = new int[numOfPhonetic];
        for (int i = 1; i <= numOfPhonetic; i++) {
            int n = Integer.parseInt(wordQuestion.getNumberPhonetic().substring((i - 1) * 2, i * 2));
            soundPhonetic[i - 1] = soundDataList.get(n - 1).getPhonetic();
        }
        for (int i = 0; i < numOfPhonetic; i++) {

            do {
                kt = true;
                array[i] = random.nextInt(8) + 1;
                for (int j = 0; j < i; j++) {
                    if (array[j] == array[i]) {
                        kt = false;
                        break;
                    }
                }
            } while (kt == false);
        }
        for (int i = 0; i < numOfPhonetic; i++) {
            setTextAnswerForButton(soundPhonetic[i], array[i]);
        }
        if (countQuestionPractice > 10) {
            tvQuestion.setText(wordQuestion.getPhonetic());
        }


    }

    private void setTextAnswerForButton(String phoneticAnswer, int numberOfButton) {
        switch (numberOfButton) {
            case 1:
                btPracticeAnswer1.setText(phoneticAnswer);
                break;
            case 2:
                btPracticeAnswer2.setText(phoneticAnswer);
                break;
            case 3:
                btPracticeAnswer3.setText(phoneticAnswer);
                break;
            case 4:
                btPracticeAnswer4.setText(phoneticAnswer);
                break;
            case 5:
                btPracticeAnswer5.setText(phoneticAnswer);
                break;
            case 6:
                btPracticeAnswer6.setText(phoneticAnswer);
                break;
            case 7:
                btPracticeAnswer7.setText(phoneticAnswer);
                break;
            case 8:
                btPracticeAnswer8.setText(phoneticAnswer);
                break;
        }

    }

    private void randomTextForButton(Button btPracticeAnswer1) {
        Random random = new Random();
        int n = random.nextInt(43);
        btPracticeAnswer1.setText(soundDataList.get(n + 1).getPhonetic());
    }

    @Override
    public void onBackPressed() {
        wantToBack = true;
//        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                switch (which){
//                    case DialogInterface.BUTTON_POSITIVE:
//                        finish();
//                        break;
//
//                    case DialogInterface.BUTTON_NEGATIVE:
//                        break;
//                }
//            }
//        };
//        AlertDialog.Builder builder = new AlertDialog.Builder(PracticeActivity.this);
//        builder.setMessage("Are you sure to exit practice?").setPositiveButton("Yes", dialogClickListener)
//                .setNegativeButton("No", dialogClickListener).show();
        super.onBackPressed();
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


    private void addSpeakingPracticeFragment(int id_lesson, int currentPositionQuestion, String currentTopic) {
        practiceSpeakingSoundFragment = new PracticeSpeakingFragment();
        Bundle argument = new Bundle();
        argument.putInt(StaticVariable.NUM_OF_QUESTION, currentPositionQuestion);
        argument.putString(TopicActivity.TOPIC, TopicActivity.SOUND_LESSON);
        argument.putInt(StaticVariable.POSITION, id_lesson);
        practiceSpeakingSoundFragment.setArguments(argument);
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(R.id.fr_practice_sound, practiceSpeakingSoundFragment);
        fragmentTransaction.commit();
    }


    @Override
    public void notifyDoneQuestion(boolean result) {
        if (result) {
            points++;
            countQuestionPractice++;
            progressBarScore.setProgress(countQuestionPractice * 5);
        } else {
            countQuestionPractice++;
            progressBarScore.setProgress(countQuestionPractice * 5);
            stars--;
        }
        if (countQuestionPractice == 21) {
            hideHeaderLayout();
            addFinishPracticeFragment();
        } else {
            addSpeakingPracticeFragment(positionLesson, countQuestionPractice, TopicActivity.SOUND_LESSON);
        }
        checkStar(stars);

    }

    class ChangeStateAsyncTask extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Void doInBackground(Void... params) {
            publishProgress(R.drawable.button);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            btCheckAnswer.setBackgroundResource(values[0]);
            btCheckAnswer.setEnabled(false);
            btCheckAnswer.setText(getResources().getString(R.string.checking));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            stateButtonAnswer = StateButtonAnswer.CHECKING;
            btCheckAnswer.setEnabled(true);
            checkAnswer();
        }
    }

    enum StateButtonAnswer {
        NOT_ANSWER_ALREADY,
        ANSWER_ALREADY,
        CHECKING,
        DONE
    }

    private void hideHeaderLayout() {
        practiceStarOne.setVisibility(View.GONE);
        practiceStarTwo.setVisibility(View.GONE);
        practiceStarThree.setVisibility(View.GONE);
        tvScore.setVisibility(View.GONE);
        progressBarScore.setVisibility(View.GONE);
    }

}
