package com.example.clubnba.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clubnba.Adapters.CardAdapter;
import com.example.clubnba.Models.Player;
import com.example.clubnba.R;

import java.util.ArrayList;

public class CardFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Player> playerArrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_cards, container, false);
        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        playerArrayList = new ArrayList<>();

        //Colors for image background colors
        Drawable drawable1 = getResources().getDrawable(R.drawable.yellow_bg);
        Drawable drawable2 = getResources().getDrawable(R.drawable.purple_bg);
        Drawable drawable3 = getResources().getDrawable(R.drawable.blue_bg);
        Drawable drawable4 = getResources().getDrawable(R.drawable.red_bg);
        Drawable drawable5 = getResources().getDrawable(R.drawable.green_bg);

        //set the content of the cards
        playerArrayList.add(new Player("Stephen Curry", "A", "Golden State", "Golden Ohio", "6'3", "185", "65", R.drawable.player21, drawable1));
        playerArrayList.add(new Player("Lebron James", "A", "Cleveland Cavs", "Akron, Ohio", "6'9", "250", "30", R.drawable.player31, drawable2));
        playerArrayList.add(new Player("Micheal Jordan", "B", "Chicago Bulls", "Brooklyn", "6'6", "216", "65", R.drawable.player4, drawable3));
        playerArrayList.add(new Player("Magic Johnson", "B", "Los Ang. lakers", "Lansing", "6'9", "220", "65", R.drawable.magic_jhonson, drawable4));
        playerArrayList.add(new Player("Wilt Chamberlain", "A", "Philad. Warriors", "Philadelphia", "7'1", "275", "55", R.drawable.player_5, drawable5));
        playerArrayList.add(new Player("Oscar Robertson", "C", "Cincinnati Royals", "Charlotte", "6'5", "205", "40", R.drawable.player_6, drawable1));
        playerArrayList.add(new Player("Bill Russell", "A", "St.Louis Hawks", "Monroe", "6'10", "220", "58", R.drawable.player_7, drawable2));
        playerArrayList.add(new Player("Larry Bird", "B", "Boston celtics", "Indiana", "6'9", "220", "60", R.drawable.player_8, drawable3));
        playerArrayList.add(new Player("Shaquille O’Neal", "A", "Orlando Magic", "New Jersey", "7'1", "325", "65", R.drawable.player_9, drawable4));
        playerArrayList.add(new Player("Tim Duncan", "C", "San Ant. Spurs", "Virgin Islands", "6'11", "250", "50", R.drawable.player_10, drawable5));
       // playerArrayList.add(new Player("Stephen Curry", "A", "Golden State", "Golden Ohio", "6'3", "185", "65", R.drawable.player31, drawable1));
        recyclerView.setAdapter(new CardAdapter(getContext(), playerArrayList));

        return view;
    }

}
