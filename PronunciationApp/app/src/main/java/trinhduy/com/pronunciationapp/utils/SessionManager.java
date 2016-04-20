package trinhduy.com.pronunciationapp.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by SON on 3/9/2016.
 */
public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "Pronunciation";

    // Constructor
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLessonDone(String lesson_done) {
        // Storing login value as TRUE
        editor.putBoolean(lesson_done, true);
        // commit changes
        editor.commit();
    }

    public boolean isLessonDone(String lesson_done) {
        return pref.getBoolean(lesson_done, false);
    }
}
