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
 * Created by SON on 3/17/2016.
 */
public class Fragment_Word_Stress_Example extends Fragment {
    ListView listViewWordStressExample;
    ArrayList<WordData> listWordStressExample;
    ListExampleAdapter listWordStressExampleAdapter;

    public Fragment_Word_Stress_Example() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_word_stress_example, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listViewWordStressExample = (ListView) getActivity().findViewById(R.id.list_view_word_stress_example);
        listWordStressExample = MainActivity.listWordStressExample;
        listWordStressExampleAdapter = new ListExampleAdapter(getActivity(), R.layout.list_example_item, listWordStressExample);
        listViewWordStressExample.setAdapter(listWordStressExampleAdapter);

    }

    private void setDefaultWordStressExample() {
        listWordStressExample = new ArrayList<WordData>();
        WordData rule_one = new WordData("", "", "RULE ONE", "");
        listWordStressExample.add(rule_one);
        WordData progress = new WordData("ˈprəʊɡres", "", "progress", "");
        listWordStressExample.add(progress);
        WordData present = new WordData("ˈpreznt", "", "present", "");
        listWordStressExample.add(present);
        WordData engine = new WordData("ˈendʒɪn", "", "engine", "");
        listWordStressExample.add(engine);
        WordData record = new WordData("ˈrekɔːd", "", "record", "");
        listWordStressExample.add(record);
        WordData jealous = new WordData("ˈdʒeləs", "", "jealous", "");
        listWordStressExample.add(jealous);

        WordData rule_two = new WordData("", "", "RULE TWO", "");
        listWordStressExample.add(rule_two);
        WordData admit = new WordData("ədˈmɪt", "", "admit", "");
        listWordStressExample.add(admit);
        WordData announce = new WordData("əˈnaʊns", "", "announce", "");
        listWordStressExample.add(announce);
        WordData begin = new WordData("bɪˈɡɪn", "", "begin", "");
        listWordStressExample.add(begin);
        WordData decide = new WordData("dɪˈsaɪd", "", "decide", "");
        listWordStressExample.add(decide);
        WordData impress = new WordData("ɪmˈpres", "", "impress", "");
        listWordStressExample.add(impress);

        WordData rule_three = new WordData("", "", "RULE THREE", "");
        listWordStressExample.add(rule_three);
        WordData education = new WordData("ˌedʒuˈkeɪʃn", "", "education", "");
        listWordStressExample.add(education);
        WordData concentration = new WordData("ˌkɒnsnˈtreɪʃn", "", "concentration", "");
        listWordStressExample.add(concentration);
        WordData demonstration = new WordData("ˌdemənˈstreɪʃn", "", "demonstration", "");
        listWordStressExample.add(demonstration);
        WordData permission = new WordData("pəˈmɪʃn", "", "permission", "");
        listWordStressExample.add(permission);
        WordData musician = new WordData("mjuˈzɪʃn", "", "musician", "");
        listWordStressExample.add(musician);

        WordData rule_four = new WordData("", "", "RULE FOUR", "");
        listWordStressExample.add(rule_four);
        WordData economic = new WordData("ˌiːkəˈnɒmɪk", "", "economic", "");
        listWordStressExample.add(economic);
        WordData strategic = new WordData("strəˈtiːdʒɪk", "", "strategic", "");
        listWordStressExample.add(strategic);
        WordData mechanic = new WordData("məˈkænɪk", "", "mechanic", "");
        listWordStressExample.add(mechanic);
        WordData academic = new WordData("ˌækəˈdemɪk", "", "academic", "");
        listWordStressExample.add(academic);
        WordData dramatic = new WordData("drəˈmætɪk", "", "dramatic", "");
        listWordStressExample.add(dramatic);

        WordData rule_five = new WordData("", "", "RULE FIVE", "");
        listWordStressExample.add(rule_five);
        WordData employee = new WordData("ɪmˈplɔɪiː", "", "employee", "");
        listWordStressExample.add(employee);
        WordData degree = new WordData("dɪˈɡriː", "", "degree", "");
        listWordStressExample.add(degree);
        WordData shampoo = new WordData("ʃæmˈpuː", "", "shampoo", "");
        listWordStressExample.add(shampoo);
        WordData guarantee = new WordData("ˌɡærənˈtiː", "", "guarantee", "");
        listWordStressExample.add(guarantee);
        WordData refugee = new WordData("ˌrefjuˈdʒiː", "", "refugee", "");
        listWordStressExample.add(refugee);
    }
}
