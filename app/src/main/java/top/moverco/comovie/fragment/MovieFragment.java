package top.moverco.comovie.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import top.moverco.comovie.R;
import top.moverco.comovie.log.Logger;

/**
 * Created by liuzongxiang on 13/04/2017.
 */

public class MovieFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view;
        view = inflater.inflate(R.layout.movie_fragment_layout,container,false);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.setting,menu);
        setIconEnable(menu,true);
    }

    private void setIconEnable(Menu menu,boolean enable)  {
        try {
            Class<?> clazz = Class.forName("android.support.v7.view.menu.MenuBuilder");
            try {
                Method m = clazz.getDeclaredMethod("setOptionalIconsVisible",boolean.class);
                m.setAccessible(true);
                try {
                    m.invoke(menu,enable);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.refresh:
                Logger.d("refresh");
                break;
            case R.id.order_by_popular:
                Logger.d("order_by_popular");
                break;
            case R.id.order_by_rate:
                Logger.d("order_by_rate");
                break;
            default:
                break;
        }
        return true;

    }
}
