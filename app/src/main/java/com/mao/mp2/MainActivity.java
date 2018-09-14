package com.mao.mp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;
    GridLayoutManager mGridLayourManager;

    boolean isGrid = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Pokemon> pokemon = new ArrayList<>();
        //TODO: import list of Pokemon to display into pokemon. Using test values for now
        pokemon.add(new Pokemon("Abomasnow"));
        pokemon.add(new Pokemon("Abra"));
        pokemon.add(new Pokemon("Absol"));
        pokemon.add(new Pokemon("thisshouldfail"));
        pokemon.add(new Pokemon("Abomasnow"));
        pokemon.add(new Pokemon("Abra"));
        pokemon.add(new Pokemon("Absol"));
        pokemon.add(new Pokemon("thisshouldfail"));
        pokemon.add(new Pokemon("Abomasnow"));
        pokemon.add(new Pokemon("Abra"));
        pokemon.add(new Pokemon("Absol"));
        pokemon.add(new Pokemon("thisshouldfail"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mGridLayourManager = new GridLayoutManager(this,2);
        setLayoutManager();
        mRecyclerView.setAdapter(new PokemonAdapter(this, pokemon, isGrid));

        findViewById(R.id.switchButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isGrid=!isGrid;
                setLayoutManager();
                mRecyclerView.setAdapter(new PokemonAdapter(MainActivity.this, pokemon, isGrid));
            }
        });
    }

    private void setLayoutManager() {
        if (isGrid) {
            mRecyclerView.setLayoutManager(mGridLayourManager);
        }else{
            mRecyclerView.setLayoutManager(mLinearLayoutManager);
        }
    }
}

