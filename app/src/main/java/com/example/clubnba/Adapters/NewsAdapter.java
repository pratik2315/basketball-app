package com.example.clubnba.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.clubnba.Models.News;
import com.example.clubnba.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    Context context;
    ArrayList<News> newsArrayList;

    public NewsAdapter(Context context, ArrayList<News> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.newsTitle.setText(newsArrayList.get(position).getmTitle());
        Glide.with(context).load(newsArrayList.get(position).getmPoster()).into(holder.newsPhoto);
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView newsTitle;
        ImageView newsPhoto;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsPhoto = itemView.findViewById(R.id.newsPhoto);
        }
    }
}
