package com.efebudak.androidsampleproject.di;

import android.app.Activity;

import com.efebudak.androidsampleproject.moviedetail.MovieDetailActivity;
import com.efebudak.androidsampleproject.moviedetail.MovieDetailActivitySubComponent;
import com.efebudak.androidsampleproject.movielist.MovieListActivity;
import com.efebudak.androidsampleproject.movielist.MovieListActivitySubComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by efebudak on 23/06/2017.
 */

@Module
public abstract class ActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MovieListActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMovieListActivity(MovieListActivitySubComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(MovieDetailActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMovieDetailActivity(MovieDetailActivitySubComponent.Builder builder);
}
