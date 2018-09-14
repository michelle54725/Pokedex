package com.mao.mp2;

import android.widget.ImageView;

public class Pokemon {
    private final static String URL = "https://img.pokemondb.net/artwork/%s.jpg";
    String name;
    String urlString;

    public Pokemon(String name) {
        this.name = name;
        this.urlString = String.format(URL, name.toLowerCase());
    }
}
