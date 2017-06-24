package com.efebudak.androidsampleproject.movielist;

import dagger.Binds;
import dagger.Module;

/**
 * Created by efebudak on 23/06/2017.
 */

@Module
public abstract class MovieListActivityModule {

    @Binds
    abstract MovieListContract.View provideView(MovieListFragment movieListFragment);
}
