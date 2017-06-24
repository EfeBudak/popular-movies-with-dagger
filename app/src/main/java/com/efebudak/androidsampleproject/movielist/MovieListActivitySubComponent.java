package com.efebudak.androidsampleproject.movielist;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by efebudak on 23/06/2017.
 */

@Subcomponent(modules = MovieListActivityModule.class)
public interface MovieListActivitySubComponent extends AndroidInjector<MovieListActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MovieListActivity> {
    }
}
