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
import trinhduy.com.pronunciationapp.utils.SessionManager;

/**
 * Created by SON on 1/25/2016.
 */
public class FinishPracticeFragment extends Fragment {
    public static final String DONE_LESSON = "done";
    Button btContinueLesson;
    FinishInterface mCallBack;
    SessionManager sessionManager;

    public static FinishPracticeFragment newInstance(String lesson_done) {
        FinishPracticeFragment finishPracticeFragment = new FinishPracticeFragment();
        Bundle argument = new Bundle();
        argument.putString(DONE_LESSON, lesson_done);
        finishPracticeFragment.setArguments(argument);
        return finishPracticeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_finish_practice, container, false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallBack = (FinishInterface) activity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpView();
        registerEvent();
        setDoneForLesson();
    }

    private void setDoneForLesson() {
        String positionLesson = getArguments().getString(DONE_LESSON);
        sessionManager.createLessonDone(positionLesson);

    }

    private void registerEvent() {
        btContinueLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.finishActivity();
            }
        });
    }

    private void setUpView() {
        btContinueLesson = (Button) getActivity().findViewById(R.id.bt_continue_after_practice);
        sessionManager = new SessionManager(getActivity());
    }

    public interface FinishInterface {
        public void finishActivity();
    }
}
