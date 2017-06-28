package com.efebudak.androidsampleproject.di;

import com.efebudak.androidsampleproject.moviedetail.MovieDetailActivity;
import com.efebudak.androidsampleproject.movielist.MovieListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by efebudak on 23/06/2017.
 */

@Module
public abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract MovieListActivity contributesMovieListActivity();

    @ActivityScope
    @ContributesAndroidInjector
    abstract MovieDetailActivity contributesMovieDetailActivity();
}
