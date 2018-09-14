package com.mao.mp2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import static com.bumptech.glide.request.RequestOptions.centerCropTransform;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.request.RequestOptions;

import java.net.URL;
import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {
    ArrayList<Pokemon> data;
    private Context context;
    private boolean isGrid;

    PokemonAdapter(Context context, ArrayList<Pokemon> data, boolean isGrid) {
        this.data = data;
        this.context = context;
        this.isGrid = isGrid;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (isGrid){
            view = LayoutInflater.from(context).inflate(R.layout.activity_grid, viewGroup,false);

        }else{
            view = LayoutInflater.from(context).inflate(R.layout.activity_list, viewGroup,false);

        }
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder PokemonViewHolder, int position) {
        PokemonViewHolder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;
        ImageView imageView;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.img);
        }

        void bind (Pokemon pokemon) {
            nameView.setText(pokemon.name);
            String url = "https://img.pokemondb.net/artwork/archeops.jpg";
//            String url = String.format("http://img.pokemondb.net/artwork/%s.jpg", pokemon.name.toLowerCase());
//            String url = "http://img.pokemondb.net/artwork/" + pokemon.name.toLowerCase() + ".jpg";
//            String url = String.format("http://img.pokemondb.net/artwork/%s.jpg", pokemon.name).toLowerCase();
//            String url = String.format("http://img.pokemondb.net/artwork/%s.jpg", pokemon.name.toLowerCase());
            //TODO: how the hell to format url

            //use Glide to set img
            RequestOptions myOptions = new RequestOptions()
                    .error(R.drawable.ic_error_black_24dp)
                    .override(100, 100);
            Glide.with(context)
                    .load(url)
                    .apply(myOptions)
                    .into(imageView);
            }
    }
}
