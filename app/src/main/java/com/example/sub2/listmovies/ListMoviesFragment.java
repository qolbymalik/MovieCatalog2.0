package com.example.sub2.listmovies;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sub2.R;
import com.example.sub2.detailmovie.DetailMovie;
import com.example.sub2.listmovie.ListMovie;
import com.example.sub2.listmovie.ListWatchAdapter;

import java.util.List;

public class ListMoviesFragment extends Fragment {

    private ListMoviesViewModel mViewModel;
    private ListWatchAdapter mAdapter;

    public static ListMoviesFragment newInstance() {
        return new ListMoviesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstance) {
        return inflater.inflate(R.layout.list_movies_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstance) {
        super.onActivityCreated(savedInstance);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        mViewModel = ViewModelProviders.of(this).get(ListMoviesViewModel.class);
        mViewModel.addMovieModel(getResources().getString(R.string.title_frozen2), getString(R.string.ov_frozen2),R.drawable.poster_frozen2);
        mViewModel.addMovieModel(getResources().getString(R.string.title_terminator), getString(R.string.ov_terminator),R.drawable.poster_terminator);
        mViewModel.addMovieModel(getResources().getString(R.string.title_ford),getString(R.string.ov_ford),R.drawable.poster_ford);
        mViewModel.addMovieModel(getResources().getString(R.string.title_abominable),getString(R.string.ov_abominable),R.drawable.poster_abominable);
        mViewModel.addMovieModel(getResources().getString(R.string.title_doctor),getString(R.string.ov_doctor),R.drawable.poster_doctor);
        mViewModel.addMovieModel(getResources().getString(R.string.title_count),getString(R.string.ov_count),R.drawable.poster_count);
        mViewModel.addMovieModel(getResources().getString(R.string.title_last),getString(R.string.ov_last),R.drawable.poster_last);
        mViewModel.addMovieModel(getResources().getString(R.string.title_addams),getString(R.string.ov_addams),R.drawable.poster_addams);
        mViewModel.addMovieModel(getResources().getString(R.string.title_a),getString(R.string.ov_a),R.drawable.poster_a);
        mViewModel.addMovieModel(getResources().getString(R.string.title_charlies),getString(R.string.ov_charlies),R.drawable.poster_charlies);
        mViewModel.addMovieModel(getResources().getString(R.string.title_playing),getString(R.string.ov_playing),R.drawable.poster_playing);
        mViewModel.addMovieModel(getResources().getString(R.string.title_thegood),getString(R.string.ov_thegood),R.drawable.poster_thegood);
        mViewModel.addMovieModel(getResources().getString(R.string.title_midway),getString(R.string.ov_midway),R.drawable.poster_midway);

        mAdapter = new ListWatchAdapter(view.getContext(),mViewModel.getModelList());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        mAdapter.setOnItemClickListener(new ListWatchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view,int position, WatchModel model) {
                Intent goToDetailMovie = new Intent(view.getContext(), DetailMovie.class);
                goToDetailMovie.putExtra(ListMovie.SELECTED_MOVIE,model);
                startActivity(goToDetailMovie);
            }
        });
    }
}
