package com.efebudak.androidsampleproject.di;

import com.efebudak.androidsampleproject.moviedetail.MovieDetailFragment;
import com.efebudak.androidsampleproject.moviedetail.MovieDetailFragmentModule;
import com.efebudak.androidsampleproject.movielist.MovieListFragment;
import com.efebudak.androidsampleproject.movielist.MovieListFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by efebudak on 24/06/2017.
 */

@Module
public abstract class FragmentModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MovieListFragmentModule.class)
    abstract MovieListFragment contributesMovieListFragment();

    @ActivityScope
    @ContributesAndroidInjector(modules = MovieDetailFragmentModule.class)
    abstract MovieDetailFragment contributesMovieDetailFragment();
}
