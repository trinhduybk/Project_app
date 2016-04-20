package trinhduy.com.pronunciationapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.activities.MainActivity;
import trinhduy.com.pronunciationapp.adapters.ListExampleAdapter;
import trinhduy.com.pronunciationapp.models.WordData;

import java.util.ArrayList;

/**
 * Created by SON on 3/16/2016.
 */
public class Fragment_Syllable_Example extends Fragment {
    ArrayList<WordData> listSyllableWord = new ArrayList<WordData>();
    ListView listViewOneSyllable;
    ListExampleAdapter listExampleAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_syllable_example, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpView();
        setAdapterForListView();
    }

    private void setAdapterForListView() {
        listSyllableWord = MainActivity.listWordSyllableExample;
        listExampleAdapter = new ListExampleAdapter(getActivity(), R.layout.list_example_item, listSyllableWord);
        listViewOneSyllable.setAdapter(listExampleAdapter);
    }

    private void setDefaultDataForListExample() {
        WordData one_syllable = new WordData("", "", "ONE SYLLABLE WORD", "");
        listSyllableWord.add(one_syllable);
        WordData dog = new WordData("dɒg", "221724", "dog", "");
        listSyllableWord.add(dog);
        WordData green = new WordData("gri:n", "", "green", "");
        listSyllableWord.add(green);
        WordData quite = new WordData("kwait", "", "quite", "");
        listSyllableWord.add(quite);

        WordData two_syllable = new WordData("", "", "TWO SYLLABLE WORD", "");
        listSyllableWord.add(two_syllable);
        WordData kitchen = new WordData("'kittʃin", "", "kitchen", "");
        listSyllableWord.add(kitchen);
        WordData orange = new WordData("'ɒrindʒ", "", "orange", "");
        listSyllableWord.add(orange);
        WordData table = new WordData("'teibl", "", "table", "");
        listSyllableWord.add(table);

        WordData three_syllable = new WordData("", "", "THREE SYLLABLE WORD", "");
        listSyllableWord.add(three_syllable);
        WordData expensive = new WordData("ik'spensiv", "", "expensive", "");
        listSyllableWord.add(expensive);
        WordData wonderful = new WordData("'wʌndəfl", "", "wonderful", "");
        listSyllableWord.add(wonderful);
        WordData beautiful = new WordData("'bju:tiful", "", "beautiful", "");
        listSyllableWord.add(beautiful);

        WordData four_syllable = new WordData("", "", "FOUR SYLLABLE WORD", "");
        listSyllableWord.add(four_syllable);
        WordData comfortable = new WordData("'kʌmfətəbl", "", "comfortable", "");
        listSyllableWord.add(comfortable);
        WordData unrealistic = new WordData("ʌnriə'listik", "", "unrealistic", "");
        listSyllableWord.add(unrealistic);
        WordData increasable = new WordData("'inkri:səbl", "", "increasable", "");
        listSyllableWord.add(increasable);

        WordData five_syllable = new WordData("", "", "FIVE SYLLABLE WORD", "");
        listSyllableWord.add(five_syllable);
        WordData unbelievable = new WordData("ʌnbi'li:vəbl", "", "unbelievable", "");
        listSyllableWord.add(unbelievable);
        WordData disadvantageous = new WordData("disædva:n'teidʒəs", "", "disadvantageous", "");
        listSyllableWord.add(disadvantageous);
        WordData manufactory = new WordData("mænju'fæktəri", "", "manufactory", "");
        listSyllableWord.add(manufactory);


    }

    private void setUpView() {
        listViewOneSyllable = (ListView) getActivity().findViewById(R.id.list_view_syllable_word);

    }
}
