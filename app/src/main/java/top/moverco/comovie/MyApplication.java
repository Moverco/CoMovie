package top.moverco.comovie;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import top.moverco.comovie.activity.BaseActivity;

/**
 * Created by liuzongxiang on 13/04/2017.
 */

public class MyApplication extends Application {
    public static final String TAG = "BASEAPPLICATION";
    public static MyApplication application;
    private static int mainTid;

    private static List<BaseActivity> activities;
    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        activities = new LinkedList<>();
        mainTid = android.os.Process.myTid();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .readTimeout(10000,TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    public static Context getApplication(){
        return application;
    }

    public static int getMainTid(){
        return mainTid;
    }
    public static void addActivity(BaseActivity activity){
        activities.add(activity);
    }
    public static void removeActivity(BaseActivity activity){
        activities.remove(activity);
    }
    public static void clearActivities(){
        ListIterator<BaseActivity> iterator = activities.listIterator();
        BaseActivity activity;
        if (iterator.hasNext()){
            activity=iterator.next();
            if (activity!=null){
                activity.finish();
            }
        }
    }

    public static void quitApplication(){
        clearActivities();
        System.exit(0);
    }
}
