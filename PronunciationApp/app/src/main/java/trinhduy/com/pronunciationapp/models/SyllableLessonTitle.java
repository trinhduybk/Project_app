package trinhduy.com.pronunciationapp.models;

/**
 * Created by SON on 2/12/2016.
 */
public class SyllableLessonTitle {
    public static final String KEY_NUMBER_LESSON = "number_question";
    public static final String KEY_TITLE_QUESTION = "title_question";
    public static final String KEY_TYPE_TITLE = "type_title";
    private int numberOfLesson;
    private String titleLesson;

    public SyllableLessonTitle() {

    }

    public SyllableLessonTitle(int numberOfLesson, String titleLesson) {
        this.numberOfLesson = numberOfLesson;
        this.titleLesson = titleLesson;
    }

    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    public void setNumberOfLesson(int numberOfLesson) {
        this.numberOfLesson = numberOfLesson;
    }

    public String getTitleLesson() {
        return titleLesson;
    }

    public void setTitleLesson(String titleLesson) {
        this.titleLesson = titleLesson;
    }
}
