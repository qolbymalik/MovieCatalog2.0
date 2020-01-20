package com.example.sub2.listtvshow;

import androidx.lifecycle.ViewModel;

import com.example.sub2.listmovies.WatchModel;

import java.util.ArrayList;

public class ListTvShowViewModel extends ViewModel {
    private ArrayList<WatchModel> modelList = new ArrayList<>();

    public void addTvShowModel(String title, String overview, Integer poster){
        this.modelList.add(new WatchModel(title,overview,poster));
    }

    public ArrayList<WatchModel> getTvShowList(){
        return modelList;
    }
}
