package trinhduy.com.pronunciationapp.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.activities.MainActivity;
import trinhduy.com.pronunciationapp.adapters.ListExampleAdapter;
import trinhduy.com.pronunciationapp.models.StaticVariable;
import trinhduy.com.pronunciationapp.models.WordData;
import trinhduy.com.pronunciationapp.utils.TextToSpeechUtil;

import java.util.ArrayList;

/**
 * Created by SON on 2/26/2016.
 */
public class ExampleFragment extends Fragment {
    TextToSpeechUtil textToSpeechUtil;
    ArrayList<WordData> listWord = new ArrayList<WordData>();
    int positionLesson;
    int listWordLength;
    ListView listViewExample;
    ListExampleAdapter listExampleAdapter;


    public static final ExampleFragment newInstance(int positionLesson) {
        ExampleFragment exampleFragment = new ExampleFragment();
        Bundle argument = new Bundle();
        argument.putInt("example", positionLesson);
        exampleFragment.setArguments(argument);
        return exampleFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        textToSpeechUtil = TextToSpeechUtil.getInst(getActivity());
        getDataFromArgument();
        View rootView = inflater.inflate(R.layout.fragment_example, container, false);
        return rootView;
    }

    private void getDataFromArgument() {
        positionLesson = getArguments().getInt("example");
        String position;
        if (positionLesson < 10) {
            position = "0" + positionLesson;
        } else {
            position = positionLesson + "";
        }
        for (WordData wordData : MainActivity.listExampleWord) {
            if (wordData.getGroup().equals(position))
                listWord.add(wordData);
        }
        listWordLength = listWord.size();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpView();
        setAdapterForListExample();

    }

    private void setAdapterForListExample() {
        listExampleAdapter = new ListExampleAdapter(getActivity(), R.layout.list_example_item, listWord);
        listViewExample.setAdapter(listExampleAdapter);
    }

    private void setUpView() {
        listViewExample = (ListView) getActivity().findViewById(R.id.list_view_example);
    }
}
