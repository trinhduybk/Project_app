package trinhduy.com.pronunciationapp.models;

/**
 * Created by SON on 3/15/2016.
 */
public class SentenceExample {
    public static final String SENTENCE_DETAIL = "sentence_detail";
    public static final String AUDIO = "audio";
    private String sentenceDetail;
    private int audioId;

    public SentenceExample() {

    }

    public SentenceExample(String sentenceDetail, int audioId) {
        this.sentenceDetail = sentenceDetail;
        this.audioId = audioId;
    }

    public String getSentenceDetail() {
        return sentenceDetail;
    }

    public void setSentenceDetail(String sentenceDetail) {
        this.sentenceDetail = sentenceDetail;
    }

    public int getAudioId() {
        return audioId;
    }

    public void setAudioId(int audioId) {
        this.audioId = audioId;
    }
}
