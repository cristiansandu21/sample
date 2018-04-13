package ro.home.sample.services;

import ro.home.sample.entity.Movie;

public interface MovieAdapterInterface {
    void onDetailsPress(Movie movie);

    void onSharePress(Movie movie);
}
