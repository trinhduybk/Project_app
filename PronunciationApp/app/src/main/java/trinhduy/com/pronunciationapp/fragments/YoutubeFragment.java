package trinhduy.com.pronunciationapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import trinhduy.com.pronunciationapp.R;

/**
 * Created by SON on 2/26/2016.
 */
public class YoutubeFragment extends Fragment {
    private static final String API_KEY = "AIzaSyDbtULLiFvHJfv7U7bscAjaU2ZIrmp2GNs";
    private static final String VIDEO_LINK = "video_link";

    private static String VIDEO_ID = "TNFKG0yvDx4";

    public static final YoutubeFragment newInstance(String videoId) {
        YoutubeFragment youtubeFragment = new YoutubeFragment();
        Bundle argument = new Bundle();
        argument.putString(VIDEO_LINK, videoId);
        youtubeFragment.setArguments(argument);
        return youtubeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.youtube_fragment, container, false);
        VIDEO_ID = getArguments().getString(VIDEO_LINK);


        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();


        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout, youTubePlayerFragment).commit();


        youTubePlayerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {


            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player.loadVideo(VIDEO_ID);
                    player.play();
                }
            }


            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {

                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });

        return rootView;
    }
}
