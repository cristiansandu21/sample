package ro.home.sample.services;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ro.home.sample.R;
import ro.home.sample.entity.Movie;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Movie> moviesList;
    private MovieAdapterInterface delegate;

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageWallpaper;
        TextView textTitle;
        TextView textDescription;
        Button btnDetails;
        Button btnShare;

        MyViewHolder(View view) {
            super(view);
            imageWallpaper = (ImageView) view.findViewById(R.id.image_wallpaper);
            textTitle = (TextView) view.findViewById(R.id.text_title);
            textDescription = (TextView) view.findViewById(R.id.text_description);
            btnDetails = (Button) view.findViewById(R.id.btn_details);
            btnShare = (Button) view.findViewById(R.id.btn_share);
        }
    }

    public MyAdapter(ArrayList<Movie> movies, MovieAdapterInterface delegate) {
        this.moviesList = movies;
        this.delegate = delegate;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Movie movie = moviesList.get(position);

        holder.imageWallpaper.setImageDrawable(movie.getPicture());
        holder.textTitle.setText(movie.getTitle());
        holder.textDescription.setText(movie.getDescription());
        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onDetailsPress(movie);
            }
        });
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onSharePress(movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}
