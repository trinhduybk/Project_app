package trinhduy.com.pronunciationapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.activities.TopicActivity;
import trinhduy.com.pronunciationapp.adapters.ListExampleAdapter;
import trinhduy.com.pronunciationapp.adapters.ListSentenceExampleAdapter;
import trinhduy.com.pronunciationapp.models.SentenceExample;
import trinhduy.com.pronunciationapp.models.StaticVariable;

import java.util.ArrayList;

/**
 * Created by SON on 3/15/2016.
 */
public class FragmentSentenceExample extends Fragment {
    private ArrayList<SentenceExample> listSentenceExample;
    private ListView listViewSentenceExample;
    private ListSentenceExampleAdapter lisSentenceStresstExampleAdapter;
    TextView textViewTitleLesson;
    String typeLesson;

    public FragmentSentenceExample() {

    }

    public static Fragment newInstance(String type_lesson) {
        FragmentSentenceExample fragmentSentenceExample = new FragmentSentenceExample();
        Bundle argument = new Bundle();
        argument.putString("type_lesson", type_lesson);
        fragmentSentenceExample.setArguments(argument);
        return fragmentSentenceExample;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sentence_stress_example, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listViewSentenceExample = (ListView) getActivity().findViewById(R.id.list_view_sentence_stress_example);
        textViewTitleLesson = (TextView) getActivity().findViewById(R.id.lesson_introduction);
        typeLesson = getArguments().getString("type_lesson");
        switch (typeLesson) {
            case TopicActivity.LINKING:
                textViewTitleLesson.setText(getResources().getString(R.string.linking_stress_example_title));
                listSentenceExample = StaticVariable.getInst().listLinkingExample;
                break;
            case TopicActivity.SENTENCE_STRESS:
                textViewTitleLesson.setText(getResources().getString(R.string.sentence_stress_example_title));
                listSentenceExample = StaticVariable.getInst().listSentenceStressExample;
                break;
        }
        lisSentenceStresstExampleAdapter = new ListSentenceExampleAdapter(getActivity(), R.layout.list_sentence_example_item, listSentenceExample);
        listViewSentenceExample.setAdapter(lisSentenceStresstExampleAdapter);

    }
}
