package ro.home.sample.controller;

import ro.home.sample.entity.Album;

public interface AlbumsAdapterInterface {
    void onAddFavouritePress(Album album);

    void onPlayNextPress(Album album);
}
