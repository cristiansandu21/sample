package ro.home.sample.entity;

import android.graphics.drawable.Drawable;

public class Movie {
    private Drawable Picture;
    private String Title;
    private String Description;

    public Drawable getPicture() {
        return Picture;
    }

    public void setPicture(Drawable picture) {
        Picture = picture;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
