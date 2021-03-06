package com.efebudak.androidsampleproject.movielist;


import com.efebudak.androidsampleproject.di.FragmentScope;

import dagger.Binds;
import dagger.Module;

/**
 * Created by efebudak on 24/06/2017.
 */

@FragmentScope
@Module
public abstract class MovieListFragmentModule {

    @FragmentScope
    @Binds
    abstract MovieListContract.View provideView(MovieListFragment movieListFragment);

    @FragmentScope
    @Binds
    abstract MovieListContract.Presenter providePresenter(MovieListPresenter movieListPresenter);
}
