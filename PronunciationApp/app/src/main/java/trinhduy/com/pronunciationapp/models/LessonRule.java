package trinhduy.com.pronunciationapp.models;

/**
 * Created by SON on 3/12/2016.
 */
public class LessonRule {
    public static final String KEY_POSITION = "position";
    public static final String KEY_RULE = "lesson_rule";
    public static final String KEY_TYPE_LESSON = "type_lesson";
    private String position;
    private String lesson_rule;

    public LessonRule() {

    }

    public LessonRule(String position, String lesson_rule) {
        this.position = position;
        this.lesson_rule = lesson_rule;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLesson_rule() {
        return lesson_rule;
    }

    public void setLesson_rule(String lesson_rule) {
        this.lesson_rule = lesson_rule;
    }
}
