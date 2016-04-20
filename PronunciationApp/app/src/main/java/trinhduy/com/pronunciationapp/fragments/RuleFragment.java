package trinhduy.com.pronunciationapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import trinhduy.com.pronunciationapp.R;

/**
 * Created by SON on 2/26/2016.
 */
public class RuleFragment extends Fragment {
    TextView textViewLessonRule;
    String lessonRule;

    public RuleFragment() {

    }

    public static final RuleFragment newInstance(String lessonRule) {
        RuleFragment ruleFragment = new RuleFragment();
        Bundle argument = new Bundle();
        argument.putString("rule", lessonRule);
        ruleFragment.setArguments(argument);

        return ruleFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        lessonRule = getArguments().getString("rule");
        View rootView = inflater.inflate(R.layout.fragment_rule, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpView();

    }

    private void setUpView() {
        textViewLessonRule = (TextView) getActivity().findViewById(R.id.tv_lesson_rule);
        textViewLessonRule.setText(lessonRule);
    }
}
