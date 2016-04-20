package trinhduy.com.pronunciationapp.models;

/**
 * Created by SON on 1/29/2016.
 */
public class SoundData {
    public static final String KEY_POSITION = "position";
    public static final String KEY_PHONETIC = "phonetic";
    public static final String KEY_AUDIO = "link_audio";
    public static final String KEY_VIDEO = "link_video";
    public static final String KEY_RULE = "lesson_rule";
    private int situation;
    private String phonetic;
    private int linkMusic;
    private String linkVideo;

    public SoundData() {

    }

    public SoundData(int situation, String phonetic, int linkMusic, String linkVideo) {
        this.situation = situation;
        this.phonetic = phonetic;
        this.linkMusic = linkMusic;
        this.linkVideo = linkVideo;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public int getLinkMusic() {
        return linkMusic;
    }

    public void setLinkMusic(int linkMusic) {
        this.linkMusic = linkMusic;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }
}
