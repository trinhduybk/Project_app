package trinhduy.com.pronunciationapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import trinhduy.com.pronunciationapp.fragments.LessonFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SON on 1/10/2016.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    List<LessonFragment> listLesson = new ArrayList<LessonFragment>();

    public MyPagerAdapter(FragmentManager fragmentManager, List<LessonFragment> listLesson) {
        super(fragmentManager);
        this.listLesson = listLesson;
    }

    @Override
    public Fragment getItem(int position) {
        return this.listLesson.get(position);
    }

    @Override
    public int getCount() {
        return listLesson.size();
    }

}
