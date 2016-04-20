package trinhduy.com.pronunciationapp.models;

/**
 * Created by SON on 3/17/2016.
 */
public class LessonVideo {
    public static final String TYPE_LESSON = "type_lesson";
    public static final String VIDEO = "video";
    String typeLesson;
    String linkVideo;

    public LessonVideo(String typeLesson, String linkVideo) {
        this.typeLesson = typeLesson;
        this.linkVideo = linkVideo;
    }

    public String getTypeLesson() {
        return typeLesson;
    }

    public void setTypeLesson(String typeLesson) {
        this.typeLesson = typeLesson;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }
}
