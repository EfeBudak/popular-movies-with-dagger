package com.efebudak.androidsampleproject.movielist;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.efebudak.androidsampleproject.R;
import com.efebudak.androidsampleproject.data.Movie;
import com.efebudak.androidsampleproject.moviedetail.MovieDetailActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by efebudak on 23/06/2017.
 */

public class MovieListFragment extends Fragment implements MovieListContract.View, MovieListAdapter.MovieListListener {

    private static final String BUNDLE_LAYOUT_MANAGER_STATE = "bundleLayoutManagerState";

    @Inject
    MovieListContract.Presenter mPresenter;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private MovieListAdapter mAdapter;

    private Parcelable mLayoutManagerState;

    @NonNull
    public static MovieListFragment newInstance() {
        return new MovieListFragment();
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mLayoutManagerState = savedInstanceState.getParcelable(BUNDLE_LAYOUT_MANAGER_STATE);
        }

        final View root = inflater.inflate(R.layout.fragment_movie_list, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) root.findViewById(R.id.fragment_movie_list_swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.colorSwipeRed),
                ContextCompat.getColor(getActivity(), R.color.colorSwipeBlue),
                ContextCompat.getColor(getActivity(), R.color.colorSwipePurple),
                ContextCompat.getColor(getActivity(), R.color.colorSwipeGreen));
        mSwipeRefreshLayout.setOnRefreshListener(() -> mPresenter.onRefresh());
        mRecyclerView = (RecyclerView) root.findViewById(R.id.fragment_movie_list_recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mAdapter = new MovieListAdapter(new ArrayList<>(), this);
        mRecyclerView.setAdapter(mAdapter);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_LAYOUT_MANAGER_STATE, mRecyclerView.getLayoutManager().onSaveInstanceState());
    }

    @Override
    public void updateMovieList(@NonNull List<Movie> movieList) {
        mAdapter.updateList(movieList);
        restoreLayoutPosition();
    }

    @Override
    public void setRefreshing(boolean active) {
        mSwipeRefreshLayout.setRefreshing(active);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void openDetail(long movieId) {
        startActivity(MovieDetailActivity.newIntent(getActivity(), movieId));
    }

    @Override
    public void onItemClicked(long movieId) {
        mPresenter.onItemClicked(movieId);
    }

    private void restoreLayoutPosition() {
        if (mLayoutManagerState != null) {
            mRecyclerView.getLayoutManager().onRestoreInstanceState(mLayoutManagerState);
            mLayoutManagerState = null;
        }
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
