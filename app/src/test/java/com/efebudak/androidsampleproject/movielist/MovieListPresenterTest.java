package com.efebudak.androidsampleproject.movielist;

import com.efebudak.androidsampleproject.data.Movie;
import com.efebudak.androidsampleproject.data.MovieListPage;
import com.efebudak.androidsampleproject.data.source.MovieDataSource;
import com.efebudak.androidsampleproject.data.source.MovieRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by efebudak on 26/06/2017.
 */

public class MovieListPresenterTest {

    private static MovieListPage MOVIE_LIST_PAGE;
    private static List<Movie> MOVIE_LIST;
    @Mock
    MovieRepository movieRepository;

    @Mock
    MovieListContract.View view;
    @Captor
    private ArgumentCaptor<MovieDataSource.Callback<MovieListPage>> mLoadMovieCallbackCaptor;

    private MovieListPresenter mPresenter;

    @Before
    public void setupTasksPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mPresenter = new MovieListPresenter(view, movieRepository);

        // The presenter won't update the view unless it's active.
        when(view.isActive()).thenReturn(true);

        MOVIE_LIST = new ArrayList<>();
        MOVIE_LIST.add(new Movie("Wonder Woman", "about a wonderful woman"));
        MOVIE_LIST.add(new Movie("Logan", "Wolverine as you know"));
        MOVIE_LIST_PAGE = new MovieListPage(MOVIE_LIST);
    }

    @Test
    public void loadAllMoviesFromRepositoryAndLoadIntoView() {
        mPresenter.subscribe();

        verify(movieRepository).getMovies(mLoadMovieCallbackCaptor.capture());
        mLoadMovieCallbackCaptor.getValue().onSuccess(MOVIE_LIST_PAGE);

        InOrder inOrder = inOrder(view);
        inOrder.verify(view).setRefreshing(true);
        inOrder.verify(view).setRefreshing(false);
        ArgumentCaptor<List<Movie>> showTasksArgumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(view).updateMovieList(showTasksArgumentCaptor.capture());
        assertTrue(showTasksArgumentCaptor.getValue().size() == 2);
    }

    @Test
    public void openMovieDetail() {
        mPresenter.onItemClicked(1);
        verify(view).openDetail(1);
    }
}