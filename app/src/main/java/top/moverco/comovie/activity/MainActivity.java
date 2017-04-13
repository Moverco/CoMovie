package top.moverco.comovie.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;

import top.moverco.comovie.R;

public class MainActivity extends BaseActivity {

    private Fragment mMovieFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.movie_dashboard:
                    return true;
                case R.id.me_dashboard:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    @Override
    protected void initEvents() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        mMovieFragment = fragmentManager.findFragmentById(R.id.movie_fragment);
        if (mMovieFragment == null) {
            fragmentManager.beginTransaction().add(R.id.movie_fragment, mMovieFragment).commit();
        }

        android.app.ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("CoMovie");
        actionBar.setIcon(R.drawable.app_icon);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }


    @Override
    protected void initDatas() {

    }

}
