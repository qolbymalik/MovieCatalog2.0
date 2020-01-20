package com.example.sub2.listmovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sub2.R;
import com.example.sub2.listmovies.WatchModel;

import java.util.ArrayList;

public class ListWatchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext ;
    private ArrayList<WatchModel>modelList;

    private OnItemClickListener mItemClickListener;

    public ListWatchAdapter(Context context, ArrayList<WatchModel>modelList){
        this.mContext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<WatchModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            final WatchModel model = getItem(position);
            ViewHolder genericViewHolder = (ViewHolder) holder;
            genericViewHolder.itemJudul.setText(model.getTitle());

            if (model.getOverview().length()>50){
                genericViewHolder.itemDesc.setText(model.getOverview().substring(0,49)+" ...");
            }else{
                genericViewHolder.itemDesc.setText(model.getOverview());
            }

            genericViewHolder.imgPoster.setImageResource(model.getPoster());
        }

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }
    private WatchModel getItem(int position){
        return modelList.get(position);
    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position, WatchModel model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPoster;
        private TextView itemJudul;
        private TextView itemDesc;

        public ViewHolder(final View itemView) {
            super(itemView);

            this.imgPoster = itemView.findViewById(R.id.img_poster);
            this.itemDesc = itemView.findViewById(R.id.txtDesc);
            this.itemJudul = itemView.findViewById(R.id.txtJudul);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), modelList.get(getAdapterPosition()));
                }
            });
        }
    }
}
