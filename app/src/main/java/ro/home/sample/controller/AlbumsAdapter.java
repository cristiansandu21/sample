package ro.home.sample.controller;


import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ro.home.sample.R;
import ro.home.sample.entity.Album;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Album> albumList;
    private AlbumsAdapterInterface delegate;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, count;
        ImageView thumbnail, overflow;

        private MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }

    public AlbumsAdapter(ArrayList<Album> albumList, Context context, AlbumsAdapterInterface delegate) {
        this.context = context;
        this.albumList = albumList;
        this.delegate = delegate;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Album album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(String.valueOf(album.getNumOfSongs()));

        // loading album cover using Glide library

        Glide.with(context).load(album.getThumbnail()).into(holder.thumbnail);
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    private class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {

        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_add_favourite:
                    delegate.onAddFavouritePress(null);
                    return true;
                case R.id.action_play_next:
                    delegate.onPlayNextPress(null);
                    return true;
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return this.albumList.size();
    }
}
