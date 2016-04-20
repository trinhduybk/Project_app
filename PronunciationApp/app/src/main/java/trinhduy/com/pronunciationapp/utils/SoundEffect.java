package trinhduy.com.pronunciationapp.utils;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;

import trinhduy.com.pronunciationapp.R;

/**
 * Created by SON on 2/12/2016.
 */
public class SoundEffect implements MediaPlayer.OnPreparedListener {
    public void playTrueSound(AppCompatActivity activity, MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(activity, R.raw.right_answer_pronunciation);
        mediaPlayer.setOnPreparedListener(this);
    }

    public void playWrongSound(AppCompatActivity activity, MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(activity, R.raw.wrong_answer_pronuncation);
        mediaPlayer.setOnPreparedListener(this);
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
}
