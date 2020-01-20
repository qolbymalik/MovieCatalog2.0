package com.example.sub2.listmovie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sub2.R;
import com.example.sub2.detailmovie.DetailMovie;
import com.example.sub2.listmovies.WatchModel;

import java.util.ArrayList;

public class ListMovie extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListWatchAdapter mAdapter;

    private ArrayList<WatchModel> modelList = new ArrayList<>();
    public static final String SELECTED_MOVIE = "selected_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);
        findViews();
        setAdapter();
    }
    private void findViews() {
        recyclerView = findViewById(R.id.recycler_view);
    }
    private void setAdapter() {

        modelList.add(new WatchModel(getResources().getString(R.string.title_frozen2), getString(R.string.ov_frozen2),R.drawable.poster_frozen2));
        modelList.add(new WatchModel(getResources().getString(R.string.title_terminator), getString(R.string.ov_terminator),R.drawable.poster_terminator));
        modelList.add(new WatchModel(getResources().getString(R.string.title_ford), getString(R.string.ov_ford),R.drawable.poster_ford));
        modelList.add(new WatchModel(getResources().getString(R.string.title_abominable), getString(R.string.ov_abominable),R.drawable.poster_abominable));
        modelList.add(new WatchModel(getResources().getString(R.string.title_count), getString(R.string.ov_count),R.drawable.poster_count));
        modelList.add(new WatchModel(getResources().getString(R.string.title_doctor), getString(R.string.ov_doctor),R.drawable.poster_doctor));
        modelList.add(new WatchModel(getResources().getString(R.string.title_last), getString(R.string.ov_last),R.drawable.poster_last));
        modelList.add(new WatchModel(getResources().getString(R.string.title_addams), getString(R.string.ov_addams),R.drawable.poster_addams));
        modelList.add(new WatchModel(getResources().getString(R.string.title_a), getString(R.string.ov_a),R.drawable.poster_a));
        modelList.add(new WatchModel(getResources().getString(R.string.title_charlies), getString(R.string.ov_charlies),R.drawable.poster_charlies));
        modelList.add(new WatchModel(getResources().getString(R.string.title_playing), getString(R.string.ov_playing),R.drawable.poster_playing));
        modelList.add(new WatchModel(getResources().getString(R.string.title_thegood),getString(R.string.ov_thegood),R.drawable.poster_thegood));
        modelList.add(new WatchModel(getResources().getString(R.string.title_midway), getString(R.string.ov_midway),R.drawable.poster_midway));

        mAdapter = new ListWatchAdapter(ListMovie.this, modelList);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ListWatchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent goToDetailMovie = new Intent(ListMovie.this, DetailMovie.class);
                goToDetailMovie.putExtra(ListMovie.SELECTED_MOVIE,model);
                startActivity(goToDetailMovie);
            }
        });
    }
}
