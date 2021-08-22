package com.example.clubnba.Models;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

public class Player {
    String name, division, team_name, city_name;
    String height, weight, wins;
    int image;
    Drawable color;
    public Player(String name, String division, String team_name, String city_name, String height, String weight, String wins, int image, Drawable color) {
        this.name = name;
        this.division = division;
        this.team_name = team_name;
        this.city_name = city_name;
        this.height = height;
        this.weight = weight;
        this.wins = wins;
        this.image = image;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Drawable getColor() {
        return color;
    }

    public void setColor(Drawable color) {
        this.color = color;
    }
}
