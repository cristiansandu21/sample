package ro.home.sample.entity;

public class Album {
    private String Name;
    private int NumOfSongs;
    private int Thumbnail;

    public Album() {

    }

    public Album(String name, int numOfSongs, int thumbnail) {
        this.Name = name;
        this.NumOfSongs = numOfSongs;
        this.Thumbnail = thumbnail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNumOfSongs() {
        return NumOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        NumOfSongs = numOfSongs;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
