package com.efebudak.androidsampleproject.movielist;

import dagger.Binds;
import dagger.Module;

/**
 * Created by efebudak on 24/06/2017.
 */

@Module
public abstract class MovieListFragmentModule {

    @Binds
    abstract MovieListContract.View provideView(MovieListFragment movieListFragment);

    @Binds
    abstract MovieListContract.Presenter providePresenter(MovieListPresenter movieListPresenter);
}
