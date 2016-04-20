package trinhduy.com.pronunciationapp.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import trinhduy.com.pronunciationapp.R;

/**
 * Created by SON on 1/12/2016.
 */
public class PracticeSoundListenFragment extends Fragment implements View.OnClickListener, Loader.OnLoadCompleteListener {
    private Button btPracticeListeningAnswer;
    private AnswerButtonClicked mCallBack;

    public PracticeSoundListenFragment() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallBack = (AnswerButtonClicked) activity;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = (View) inflater.inflate(R.layout.fragment_listening_practice_sound_1, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpView();
        registerForEvent();
        Log.e("Button Check", btPracticeListeningAnswer.getX() + "");
    }

    private void registerForEvent() {
        btPracticeListeningAnswer.setOnClickListener(this);

    }

    private void setUpView() {
        btPracticeListeningAnswer = (Button) getActivity().findViewById(R.id.practice_listening_sound_button_check_answer);
        Log.i("Button location", String.valueOf(btPracticeListeningAnswer.getHeight()));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.practice_listening_sound_button_check_answer:
                mCallBack.onListeningPraticeButtonCheckClick(id);
                break;
            default:
                break;
        }
    }

    @Override
    public void onLoadComplete(Loader loader, Object data) {
        Log.i("Button complete", String.valueOf(btPracticeListeningAnswer.getX()));
    }

    public interface AnswerButtonClicked {
        public void onListeningPraticeButtonCheckClick(int id);

    }


}
