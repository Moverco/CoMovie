package top.moverco.comovie.log;

import android.util.Log;

/**
 * Created by liuzongxiang on 13/04/2017.
 */

public class Logger {
    public static boolean DEBUG = true;
    private static String TAG = "CO_MOVIE";


    public static void d(String log) {
        Log.d(TAG, log);
    }
}
