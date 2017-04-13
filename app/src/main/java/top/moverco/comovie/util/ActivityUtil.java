package top.moverco.comovie.util;

import android.content.Context;
import android.content.Intent;

import top.moverco.comovie.MyApplication;
import top.moverco.comovie.activity.BaseActivity;

/**
 * Created by liuzongxiang on 13/04/2017.
 */

public class ActivityUtil {
    public static Context getContext(){
        return MyApplication.getApplication();
    }

    public static void startActivity(Intent intent){
        if (BaseActivity.activity==null){
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getContext().startActivity(intent);
        }else {
            BaseActivity.activity.startActivity(intent);
        }
    }


}
