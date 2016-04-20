package trinhduy.com.pronunciationapp.adapters;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.models.WordData;
import trinhduy.com.pronunciationapp.utils.TextToSpeechUtil;

import java.util.ArrayList;

/**
 * Created by SON on 2/28/2016.
 */
public class ListExampleAdapter extends ArrayAdapter<WordData> {
    TextToSpeechUtil textToSpeechUtil;
    private Activity context;
    private ArrayList<WordData> listWordExample;

    public ListExampleAdapter(Activity context, int resource, ArrayList<WordData> listWord) {
        super(context, resource, listWord);
        this.context = context;
        listWordExample = listWord;
        textToSpeechUtil = TextToSpeechUtil.getInst(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_example_item, parent, false);
        }
        TextView tvWordExample = (TextView) convertView.findViewById(R.id.tv_example_item_word);
        TextView tvPhoneticExample = (TextView) convertView.findViewById(R.id.tv_example_item_phonetic);
        ImageView imgSpeakerView = (ImageView) convertView.findViewById(R.id.img_speak_example);
        tvWordExample.setTextColor(Color.GRAY);
        imgSpeakerView.setVisibility(View.VISIBLE);
        tvWordExample.setText(listWordExample.get(position).getWord());
        tvPhoneticExample.setText("/" + listWordExample.get(position).getPhonetic() + "/");
        if (position % 2 == 0) {
            convertView.setBackgroundResource(R.color.white);
        } else {
            convertView.setBackgroundResource(R.color.line);
        }

        imgSpeakerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeechUtil.speakWordOrSentence(listWordExample.get(position).getWord());
            }
        });
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeechUtil.speakWordOrSentence(listWordExample.get(position).getWord());
            }
        });
        if (listWordExample.get(position).getWord().contains("RULE") || listWordExample.get(position).getWord().contains("SYLLABLE")) {
            tvWordExample.setTextColor(Color.RED);
            tvPhoneticExample.setText("");
            imgSpeakerView.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int arg0) {
        return true;
    }

}
