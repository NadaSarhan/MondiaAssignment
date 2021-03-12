package com.nada.mondiaassignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nada.mondiaassignment.R;
import com.nada.mondiaassignment.model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<MainModel> searchModelModel;
    private Context context;

    public SearchAdapter(List<MainModel> searchModelModel, Context context) {
        this.searchModelModel = searchModelModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menue_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        MainModel model = searchModelModel.get(position);
        holder.songTitle.setText(model.getTitle());
        holder.artist.setText(model.getMainArtist().getName());
        holder.songType.setText(model.getType());
    }

    @Override
    public int getItemCount() {
        return searchModelModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView songTitle;
        private TextView artist;
        private TextView songType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            songTitle = (TextView) itemView.findViewById(R.id.songTitle);
            artist = (TextView) itemView.findViewById(R.id.artist);
            songType = (TextView) itemView.findViewById(R.id.songType);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }

    }

    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

}

