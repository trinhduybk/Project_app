package trinhduy.com.pronunciationapp.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import trinhduy.com.pronunciationapp.R;

/**
 * Created by SON on 1/30/2016.
 */
public class PracticeFailFragment extends Fragment {
    Button btContinuneAfterFail;
    FinishAfterFailInterface mCallBack;

    public PracticeFailFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.practice_fail_fragment, container, false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallBack = (FinishAfterFailInterface) activity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpView();
        registerForEvent();
    }

    private void registerForEvent() {
        btContinuneAfterFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.finishActivityAfterFail();
            }
        });

    }

    private void setUpView() {
        btContinuneAfterFail = (Button) getActivity().findViewById(R.id.bt_continue_after_fail_practice);
    }

    public interface FinishAfterFailInterface {
        public void finishActivityAfterFail();
    }
}
