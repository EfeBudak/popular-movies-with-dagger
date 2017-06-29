package com.efebudak.androidsampleproject.moviedetail;

import com.efebudak.androidsampleproject.di.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by efebudak on 29/06/2017.
 */
@FragmentScope
@Module
public abstract class MovieDetailFragmentProvider {

    @ContributesAndroidInjector(modules = MovieDetailFragmentModule.class)
    abstract MovieDetailFragment contributesMovieDetailFragment();
}
