package com.example.clubnba.Fragments;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;
import com.example.clubnba.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameFragment extends Fragment {

    private LuckyWheel luckyWheel;
    List<WheelItem> wheelItems;

    int i;

    public  View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        generateWheel();
        View view=inflater.inflate(R.layout.fragment_game, container, false);
        Random r=new Random();
        i=r.nextInt(5-0);
        luckyWheel= view.findViewById(R.id.lucky);
                luckyWheel.addWheelItems(wheelItems);
                luckyWheel.setTarget(i);
                luckyWheel.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
                    @Override
                    public void onReachTarget() {
                        Toast.makeText(getContext(),"Whooaa!", Toast.LENGTH_SHORT).show();
                        i=r.nextInt(5-0);
                    }
                });
        Button start= view.findViewById(R.id.btn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                luckyWheel.rotateWheelTo(i);
            }
        });

        return view;
    }

    private void generateWheel() {
        wheelItems=new ArrayList<>();
        wheelItems.add(new WheelItem(Color.parseColor("#fc6c6c"), BitmapFactory.decodeResource(getResources(),
                R.drawable.basket_sv),"b a s k e t b a l l"));
        wheelItems.add(new WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(getResources(),
                R.drawable.nothingfound),""));
        wheelItems.add(new WheelItem(Color.parseColor("#F00E6F"), BitmapFactory.decodeResource(getResources(),
                R.drawable.dollar_img),"10  $"));
        wheelItems.add(new WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(getResources(),
                R.drawable.player_icon),"m e e t  a  p l a y e r"));
        wheelItems.add(new WheelItem(Color.parseColor("#fc6c6c"), BitmapFactory.decodeResource(getResources(),
                R.drawable.iphone),"S m a r t p h o n e"));
        wheelItems.add(new WheelItem(Color.parseColor("#F00E6F"), BitmapFactory.decodeResource(getResources(),
                R.drawable.nike_shirt),"j e r s e y"));

    }
}
