package com.efebudak.androidsampleproject.moviedetail;

import com.efebudak.androidsampleproject.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by efebudak on 25/06/2017.
 */

@ActivityScope
@Subcomponent(modules = MovieDetailActivityModule.class)
public interface MovieDetailActivitySubComponent extends AndroidInjector<MovieDetailActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MovieDetailActivity> {
    }
}
