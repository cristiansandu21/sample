package ro.home.sample.services;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ro.home.sample.R;
import ro.home.sample.entity.Movie;

public class MovieAdapter extends ArrayAdapter<Movie> {
    private MovieAdapterInterface delegate;

    public MovieAdapter(Context context, ArrayList<Movie> array, MovieAdapterInterface delegate) {
        super(context, 0, array);
        this.delegate = delegate;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_row, parent, false);
        }
        final Movie movie = getItem(position);

        ImageView imageWallpaper = (ImageView) convertView.findViewById(R.id.image_wallpaper);
        TextView textTitle = (TextView) convertView.findViewById(R.id.text_title);
        TextView textDescription = (TextView) convertView.findViewById(R.id.text_description);
        Button btnDetails = (Button) convertView.findViewById(R.id.btn_details);
        Button btnShare = (Button) convertView.findViewById(R.id.btn_share);

        imageWallpaper.setImageDrawable(movie.getPicture());
        textTitle.setText(movie.getTitle());
        textDescription.setText(movie.getDescription());
        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onDetailsPress(movie);
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onSharePress(movie);
            }
        });

        return convertView;
    }
}
