package com.example.clubnba.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clubnba.Models.Player;
import com.example.clubnba.R;

import java.util.ArrayList;

//Adapter for inflating Cards
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    Context context;
    ArrayList<Player> players;

    public CardAdapter(Context context, ArrayList<Player> players) {
        this.context = context;
        this.players = players;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_items_layout, parent, false); //Inflates the card_items_layout we made
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.imageView.setImageResource(players.get(position).getImage()); //gets and sets the image from the position
        holder.imageView.setBackground(players.get(position).getColor()); // this one sets the image background colors
        holder.tv_name.setText(players.get(position).getName()); //name and stuff
        holder.division_tv.setText(players.get(position).getDivision());
        holder.team_tv.setText(players.get(position).getTeam_name());
        holder.city_name.setText(players.get(position).getCity_name());
        holder.height_tv.setText(players.get(position).getHeight());
        holder.weight_tv.setText(players.get(position).getWeight());
        holder.wins_tv.setText(players.get(position).getWins());
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name, division_tv, team_tv, city_name, height_tv, weight_tv, wins_tv;
        ImageView imageView;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.name_tv);
            division_tv = itemView.findViewById(R.id.division_tv);
            team_tv = itemView.findViewById(R.id.team_tv);
            city_name = itemView.findViewById(R.id.city_tv);
            height_tv = itemView.findViewById(R.id.height_tv);
            weight_tv = itemView.findViewById(R.id.weight_tv);
            wins_tv = itemView.findViewById(R.id.wins_tv);
            imageView = itemView.findViewById(R.id.player_image);
        }
    }
}
