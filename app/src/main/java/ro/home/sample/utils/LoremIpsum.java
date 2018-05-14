package ro.home.sample.utils;

import android.content.Context;

import java.util.ArrayList;

import ro.home.sample.R;
import ro.home.sample.entity.Album;

public class LoremIpsum {
    public static ArrayList<Album> getAlbumList(Context context) {
        ArrayList<Album> albumList = new ArrayList<Album>();

        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        Album a = new Album("True Romance", 13, covers[0]);
        albumList.add(a);

        a = new Album("Xscpae", 8, covers[1]);
        albumList.add(a);

        a = new Album("Maroon 5", 11, covers[2]);
        albumList.add(a);

        a = new Album("Born to Die", 12, covers[3]);
        albumList.add(a);

        a = new Album("Honeymoon", 14, covers[4]);
        albumList.add(a);

        a = new Album("I Need a Doctor", 1, covers[5]);
        albumList.add(a);

        a = new Album("Loud", 11, covers[6]);
        albumList.add(a);

        a = new Album("Legend", 14, covers[7]);
        albumList.add(a);

        a = new Album("Hello", 11, covers[8]);
        albumList.add(a);

        a = new Album("Greatest Hits", 17, covers[9]);
        albumList.add(a);

        return albumList;
    }

//    public static Album getAlbumSample(Context context) {
//        Album Album = new Album();
//        Album.setTitle("Captain America");
//        Album.setDescription("Captain America: Civil War is a 2016 American superhero film based on the Marvel Comics character Captain America.");
//        Album.setPicture(context.getResources().getDrawable(R.drawable.picture_captain_america));
//
//        return Album;
//    }
}
