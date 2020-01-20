package com.example.sub2.listtvshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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
import com.example.sub2.listmovies.WatchModel;

public class ListTvShowFragment extends Fragment {

    private ListTvShowViewModel mViewModel;
    private ListWatchAdapter mAdapter;

    public static ListTvShowFragment newInstance() {
        return new ListTvShowFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedinstance) {
        return inflater.inflate(R.layout.list_tv_show_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        mViewModel = ViewModelProviders.of(this).get(ListTvShowViewModel.class);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_thewalking), getString(R.string.tv_ov_thewalking),R.drawable.tv_poster_thewalking);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_mandalorian), getString(R.string.tv_ov_mandalorian),R.drawable.tv_poster_mandalorian);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_silicon),getString(R.string.tv_ov_silicon),R.drawable.tv_poster_silicon);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_watchmen),getString(R.string.tv_ov_watchmen),R.drawable.tv_poster_watchmen);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_his),getString(R.string.tv_ov_his),R.drawable.tv_poster_his);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_crown),getString(R.string.tv_ov_crown),R.drawable.tv_poster_crown);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_theend),getString(R.string.tv_ov_theend),R.drawable.tv_poster_theend);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_theman),getString(R.string.tv_ov_theman),R.drawable.tv_poster_theman);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_cloak),getString(R.string.tv_ov_cloak),R.drawable.tv_poster_cloak);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_mr),getString(R.string.tv_ov_mr),R.drawable.tv_poster_mr);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_back),getString(R.string.tv_ov_back),R.drawable.tv_poster_back);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_rick),getString(R.string.tv_ov_rick),R.drawable.tv_poster_rick);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_mrs),getString(R.string.tv_ov_mrs),R.drawable.tv_poster_mrs);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_bless),getString(R.string.tv_ov_bless),R.drawable.tv_poster_bless);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_dublin),getString(R.string.tv_ov_dublin),R.drawable.tv_poster_dublin);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_agents),getString(R.string.tv_ov_agents),R.drawable.tv_poster_agents);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_stranger),getString(R.string.tv_ov_stranger),R.drawable.tv_poster_stranger);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_thehaunting),getString(R.string.tv_ov_thehaunting),R.drawable.tv_poster_thehaunting);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_timeless),getString(R.string.tv_ov_timeless),R.drawable.tv_poster_timeless);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_thex),getString(R.string.tv_ov_thex),R.drawable.tv_poster_thex);


        mAdapter = new ListWatchAdapter(view.getContext(),mViewModel.getTvShowList());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        mAdapter.setOnItemClickListener(new ListWatchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent goToDetailMovie = new Intent(view.getContext(), DetailMovie.class);
                goToDetailMovie.putExtra(ListMovie.SELECTED_MOVIE, model);
                startActivity(goToDetailMovie);
            }
        });
    }
}
