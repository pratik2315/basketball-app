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
        playerArrayList.add(new Player("Lebron James", "A", "Golden State", "Golden Ohio", "6'3", "185", "65", R.drawable.player31, drawable2));
        playerArrayList.add(new Player("Micheal Jordan", "A", "Golden State", "Golden Ohio", "6'3", "185", "65", R.drawable.player4, drawable3));
        playerArrayList.add(new Player("Stephen Curry", "A", "Golden State", "Golden Ohio", "6'3", "185", "65", R.drawable.player21, drawable4));
        playerArrayList.add(new Player("Stephen Curry", "A", "Golden State", "Golden Ohio", "6'3", "185", "65", R.drawable.player31, drawable5));
        playerArrayList.add(new Player("Stephen Curry", "A", "Golden State", "Golden Ohio", "6'3", "185", "65", R.drawable.player4, drawable1));
        playerArrayList.add(new Player("Stephen Curry", "A", "Golden State", "Golden Ohio", "6'3", "185", "65", R.drawable.player21, drawable2));
        playerArrayList.add(new Player("Stephen Curry", "A", "Golden State", "Golden Ohio", "6'3", "185", "65", R.drawable.player31, drawable3));
        playerArrayList.add(new Player("Stephen Curry", "A", "Golden State", "Golden Ohio", "6'3", "185", "65", R.drawable.player4, drawable4));
        playerArrayList.add(new Player("Stephen Curry", "A", "Golden State", "Golden Ohio", "6'3", "185", "65", R.drawable.player21, drawable5));
        playerArrayList.add(new Player("Stephen Curry", "A", "Golden State", "Golden Ohio", "6'3", "185", "65", R.drawable.player31, drawable1));
        recyclerView.setAdapter(new CardAdapter(getContext(), playerArrayList));

        return view;
    }

}
