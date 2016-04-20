package trinhduy.com.pronunciationapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.models.SentenceExample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SON on 3/15/2016.
 */
public class ListSentenceExampleAdapter extends ArrayAdapter<SentenceExample> {
    private Activity context;
    private ArrayList<SentenceExample> listSentenceExample;
    private MediaPlayer mediaPlayer;

    public ListSentenceExampleAdapter(Activity context, int resource, ArrayList<SentenceExample> objects) {
        super(context, resource, objects);
        this.context = context;
        listSentenceExample = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_sentence_example_item, parent, false);
        }
        TextView tvSentenceExample = (TextView) convertView.findViewById(R.id.tv_example_sentence_item);
        ImageView imgSpeaker = (ImageView) convertView.findViewById(R.id.img_speak_sentence_example);

        tvSentenceExample.setText(listSentenceExample.get(position).getSentenceDetail());
        imgSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(context, listSentenceExample.get(position).getAudioId());
                mediaPlayer.start();
            }
        });
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
