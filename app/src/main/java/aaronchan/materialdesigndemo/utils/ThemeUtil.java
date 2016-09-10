package aaronchan.materialdesigndemo.utils;

import android.app.Activity;
import android.support.annotation.StyleRes;

import aaronchan.materialdesigndemo.R;

/**
 * Created by AaronChan on 2016/9/7.
 */
public class ThemeUtil {
    public static final int CUSTOM_THEME1 = R.style.CustomTheme1;
    public static final int NO_TITLE_THEME = R.style.CustomTheme2;
    public static final int DEFAULT_THEME = R.style.AppTheme;
    public static final int DARK_THEME = R.style.darkTheme;
    public static int sTheme = DEFAULT_THEME;

    public static void onActivityCreateSetTheme(Activity activity) {
        activity.setTheme(sTheme);
    }

    public static void changeTheme(Activity activity, @StyleRes int theme){
        sTheme = theme;
        activity.recreate();
    }



}
