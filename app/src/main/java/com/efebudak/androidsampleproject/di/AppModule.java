package com.efebudak.androidsampleproject.di;

import android.app.Application;
import android.content.Context;

import com.efebudak.androidsampleproject.moviedetail.MovieDetailFragmentSubComponent;
import com.efebudak.androidsampleproject.movielist.MovieListFragmentSubComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by efebudak on 23/06/2017.
 */

@Module(subcomponents = {
        MovieListFragmentSubComponent.class,
        MovieDetailFragmentSubComponent.class})
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }
}
