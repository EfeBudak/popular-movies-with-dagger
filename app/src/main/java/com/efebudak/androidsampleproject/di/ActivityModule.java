package com.efebudak.androidsampleproject.di;

import com.efebudak.androidsampleproject.moviedetail.MovieDetailActivity;
import com.efebudak.androidsampleproject.moviedetail.MovieDetailFragmentProvider;
import com.efebudak.androidsampleproject.movielist.MovieListActivity;
import com.efebudak.androidsampleproject.movielist.MovieListFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by efebudak on 23/06/2017.
 */

@ActivityScope
@Module
public abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MovieListFragmentProvider.class)
    abstract MovieListActivity contributesMovieListActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = MovieDetailFragmentProvider.class)
    abstract MovieDetailActivity contributesMovieDetailActivity();
}
