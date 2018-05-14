package ro.home.sample.utils;

import android.content.Context;

import java.util.ArrayList;

import ro.home.sample.R;
import ro.home.sample.entity.Movie;

public class LoremIpsum {
    public static ArrayList<Movie> getMoviesList(Context context) {
        ArrayList<Movie> moviesList = new ArrayList<Movie>();

        Movie movie1 = new Movie();
        movie1.setTitle("Captain America");
        movie1.setDescription("Captain America: Civil War is a 2016 American superhero film based on the Marvel Comics character Captain America.");
        movie1.setPicture(context.getResources().getDrawable(R.drawable.picture_captain_america));
        moviesList.add(movie1);

//        Movie movie2 = new Movie();
//        movie2.setTitle("Inception");
//        movie2.setDescription("Inception is a 2010 science fiction film written, co-produced, and directed by Christopher Nolan, and co-produced by Emma Thomas.");
//        movie2.setPicture(context.getResources().getDrawable(R.drawable.picture_inception));
//        moviesList.add(movie2);
//
//        Movie movie3 = new Movie();
//        movie3.setTitle("Black Panther");
//        movie3.setDescription("Black Panther is a 2018 American superhero film based on the Marvel Comics character of the same name.");
//        movie3.setPicture(context.getResources().getDrawable(R.drawable.picture_black_panther));
//        moviesList.add(movie3);

        return moviesList;
    }

    public static Movie getMovieSample(Context context) {
        Movie movie = new Movie();
        movie.setTitle("Captain America");
        movie.setDescription("Captain America: Civil War is a 2016 American superhero film based on the Marvel Comics character Captain America.");
        movie.setPicture(context.getResources().getDrawable(R.drawable.picture_captain_america));

        return movie;
    }
}
