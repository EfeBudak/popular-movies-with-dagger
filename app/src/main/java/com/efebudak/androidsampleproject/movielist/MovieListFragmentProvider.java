package com.efebudak.androidsampleproject.movielist;

import com.efebudak.androidsampleproject.di.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by efebudak on 24/06/2017.
 */

@FragmentScope
@Module
public abstract class MovieListFragmentProvider {

    @ContributesAndroidInjector(modules = MovieListFragmentModule.class)
    abstract MovieListFragment contributesMovieListFragment();

}
