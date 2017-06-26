package com.efebudak.androidsampleproject.movielist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.efebudak.androidsampleproject.R;
import com.efebudak.androidsampleproject.util.ui.ActivityUtils;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MovieListActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        MovieListFragment movieListFragment
                = (MovieListFragment) getSupportFragmentManager().findFragmentById(R.id.activity_main_frame_layout);
        if (movieListFragment == null) {
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    MovieListFragment.newInstance(),
                    R.id.activity_main_frame_layout);
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
