package com.efebudak.androidsampleproject.moviedetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.efebudak.androidsampleproject.R;
import com.efebudak.androidsampleproject.util.ui.ActivityUtils;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by efebudak on 23/06/2017.
 */

public class MovieDetailActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private static final String BUNDLE_MOVIE_ID = "bundleMovieId";
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    public long movieId;

    @NonNull
    public static Intent newIntent(@NonNull final Context context, long movieId) {
        final Intent intent = new Intent(context, MovieDetailActivity.class);
        final Bundle bundle = new Bundle();
        bundle.putLong(BUNDLE_MOVIE_ID, movieId);
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        movieId = getIntent().getExtras().getLong(BUNDLE_MOVIE_ID);
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        MovieDetailFragment movieDetailFragment
                = (MovieDetailFragment) getSupportFragmentManager().findFragmentById(R.id.activity_main_frame_layout);
        if (movieDetailFragment == null) {
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    MovieDetailFragment.newInstance(),
                    R.id.activity_main_frame_layout);
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
