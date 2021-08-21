package com.example.clubnba;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class sliderAdapter extends PagerAdapter{
    Context context;
    LayoutInflater layoutInflater;
    public sliderAdapter(Context context){
        this.context=context;
    }
    public int[] slide_images={
            R.drawable.running_player,
            R.drawable.spinning_wheel,
            R.drawable.news_img

    };
    public String[] slide_headings={
            "Players",
            "Lucky Wheel",
            "News"
    };

    public String[] slide_desc= {
            "here you get to know amazing facts about your favourite players",
            "Test your luck and get opportunities to win exciting prizes",
            "Stay updated with recent news and events of Basketball"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view,@NonNull  Object object) {
        return view==(RelativeLayout) object;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.img1);
        TextView slideHeading = (TextView) view.findViewById(R.id.textView);
        TextView slideDescription = (TextView) view.findViewById(R.id.textView2);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position,@NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}

