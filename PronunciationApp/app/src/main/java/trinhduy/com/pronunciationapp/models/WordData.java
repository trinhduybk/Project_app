package trinhduy.com.pronunciationapp.models;

/**
 * Created by SON on 1/29/2016.
 */
public class WordData {
    public static final String KEY_POSITION = "position";
    public static final String KEY_PHONETIC = "word_phonetic";
    public static final String KEY_NUMBER_PHONETIC = "number_phonetic";
    public static final String KEY_WORD = "word";
    public static final String KEY_GROUP = "group_word";
    private String phonetic;
    private String numberPhonetic;
    private String word;
    private String group;

    public WordData() {

    }

    public WordData(String phonetic, String numberPhonetic, String word, String group) {
        this.phonetic = phonetic;
        this.numberPhonetic = numberPhonetic;
        this.word = word;
        this.group = group;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public String getNumberPhonetic() {
        return numberPhonetic;
    }

    public void setNumberPhonetic(String numberPhonetic) {
        this.numberPhonetic = numberPhonetic;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
