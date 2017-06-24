package com.efebudak.androidsampleproject.movielist;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by efebudak on 24/06/2017.
 */

@Subcomponent(modules = MovieListFragmentModule.class)
public interface MovieListFragmentSubComponent extends AndroidInjector<MovieListFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MovieListFragment> {
    }
}
