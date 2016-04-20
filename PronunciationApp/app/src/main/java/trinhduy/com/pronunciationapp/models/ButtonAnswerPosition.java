package trinhduy.com.pronunciationapp.models;

/**
 * Created by SON on 1/23/2016.
 */
public class ButtonAnswerPosition {
    int button_id;
    int bt_situation;
    String text;
    float endPosX;
    float endPosY;

    public ButtonAnswerPosition() {

    }

    public ButtonAnswerPosition(int button_id, int bt_situation, String text, float endPosX, float endPosY) {
        this.button_id = button_id;
        this.bt_situation = bt_situation;
        this.text = text;
        this.endPosX = endPosX;
        this.endPosY = endPosY;
    }

    public int getButton_id() {
        return button_id;
    }

    public void setButton_id(int button_id) {
        this.button_id = button_id;
    }

    public float getEndPosX() {
        return endPosX;
    }

    public void setEndPosX(float endPosX) {
        this.endPosX = endPosX;
    }

    public float getEndPosY() {
        return endPosY;
    }

    public void setEndPosY(float endPosY) {
        this.endPosY = endPosY;
    }

    public int getBt_situation() {
        return bt_situation;
    }

    public void setBt_situation(int bt_situation) {
        this.bt_situation = bt_situation;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
