package trinhduy.com.pronunciationapp.models;

import java.util.ArrayList;

/**
 * Created by SON on 2/11/2016.
 */
public class SyllableQuestion {
    public static final String KEY_ID = "question_id";
    public static final String KEY_QUESTION = "question";
    public static final String KEY_AUDIO = "link_audio";
    public static final String KEY_QUESTION_DETAIL = "question_detail";
    public static final String KEY_LIST_ANSWER_ONE = "list_answer_one";
    public static final String KEY_LIST_ANSWER_TWO = "list_answer_two";
    public static final String KEY_RIGHT_ANSWER = "right_answer";
    public static final String KEY_TYPE_QUESTION = "type_question";
    public static final String KEY_SYLLABLE_QUESTION = "syllable_question";
    public static final String KEY_WORD_STRESS_QUESTION = "word_stress_question";
    public static final String KEY_SENTENCE_STRESS_QUESTION = "sentence_stress_question";
    public static final String KEY_LINKING_QUESTION = "linking_question";
    public static final String KEY_TYPE_LESSON = "type_lesson";
    public static final String KEY_LESSON_RULE = "lesson_rule";
    private int idQuestion;
    private int linkAudio;
    private String question;
    private String questionDetail;
    private String[] listAnswer;
    private String rightAnswer;
    private String typeQuestion;

    public SyllableQuestion() {

    }

    public SyllableQuestion(int idQuestion, int linkAudio, String question, String questionDetail, String[] listAnswer, String rightAnswer, String typeQuestion) {
        this.idQuestion = idQuestion;
        this.linkAudio = linkAudio;
        this.question = question;
        this.questionDetail = questionDetail;
        this.listAnswer = listAnswer;
        this.rightAnswer = rightAnswer;
        this.typeQuestion = typeQuestion;
    }

    public String getQuestionDetail() {
        return questionDetail;
    }

    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail;
    }

    public String[] getListAnswer() {
        return listAnswer;
    }

    public String getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(String typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public void setListAnswer(String[] listAnswer) {
        this.listAnswer = listAnswer;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getLinkAudio() {
        return linkAudio;
    }

    public void setLinkAudio(int linkAudio) {
        this.linkAudio = linkAudio;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
