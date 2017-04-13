package top.moverco.comovie.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import top.moverco.comovie.MyApplication;
import top.moverco.comovie.util.ActivityUtil;

/**
 * Created by liuzongxiang on 13/04/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected String TAG = getClass().getSimpleName();
    public static BaseActivity activity;

    protected abstract void initEvents();

    protected abstract void initDatas();

    public void init() {
        initEvents();
        initDatas();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        init();
        activity = this;
        ((MyApplication)ActivityUtil.getContext()).addActivity(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        activity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        activity = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((MyApplication)ActivityUtil.getContext()).removeActivity(this);
    }
}
