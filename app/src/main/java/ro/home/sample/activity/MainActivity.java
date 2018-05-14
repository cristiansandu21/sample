package ro.home.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import ro.home.sample.R;
import ro.home.sample.controller.VerticalSpaceItemDecoration;
import ro.home.sample.entity.Movie;
import ro.home.sample.services.MovieAdapterInterface;
import ro.home.sample.services.MyAdapter;
import ro.home.sample.utils.LoremIpsum;

public class MainActivity extends AppCompatActivity implements MovieAdapterInterface {
    private ArrayList<Movie> moviesList;
    private RecyclerView recyclerView;
    private MyAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initialize();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                this.onMenuAddPress();
                return true;

            case R.id.action_remove:
                this.onMenuRemovePress();
                return true;
        }
        return false;
    }

    private void initialize() {
        try {
            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

            moviesList = LoremIpsum.getMoviesList(this);
            moviesAdapter = new MyAdapter(moviesList, this);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(moviesAdapter);
            moviesAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onMenuAddPress() {
        Movie movie = LoremIpsum.getMovieSample(this);
        moviesList.add(movie);
        moviesAdapter.notifyDataSetChanged();
    }

    private void onMenuRemovePress() {
        if (moviesList != null && moviesList.size() > 0) {
            moviesList.remove(0);
            moviesAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDetailsPress(Movie movie) {
        Toast.makeText(this, getResources().getString(R.string.toast_details).concat(movie.getTitle()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSharePress(Movie movie) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.message_share).concat(movie.getTitle()));
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
    }
}
