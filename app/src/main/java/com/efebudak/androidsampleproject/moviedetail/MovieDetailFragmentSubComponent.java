package com.efebudak.androidsampleproject.moviedetail;

import com.efebudak.androidsampleproject.di.FragmentScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by efebudak on 25/06/2017.
 */

@FragmentScope
@Subcomponent(modules = MovieDetailFragmentModule.class)
public interface MovieDetailFragmentSubComponent extends AndroidInjector<MovieDetailFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MovieDetailFragment> {
    }
}
