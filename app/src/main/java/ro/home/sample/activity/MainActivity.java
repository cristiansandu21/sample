package ro.home.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ro.home.sample.R;
import ro.home.sample.entity.Movie;
import ro.home.sample.services.MovieAdapter;
import ro.home.sample.services.MovieAdapterInterface;
import ro.home.sample.utils.LoremIpsum;

public class MainActivity extends AppCompatActivity implements MovieAdapterInterface {
    private ArrayList<Movie> movieList;
    private ListView listViewMovies;
    private MovieAdapter movieAdapter;

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
            movieList = LoremIpsum.getMoviesList(this);
            movieAdapter = new MovieAdapter(this, movieList, this);
            listViewMovies = (ListView) findViewById(R.id.list_view_movies);
            listViewMovies.setAdapter(movieAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onMenuAddPress() {
        Movie movie = LoremIpsum.getMovieSample(this);
        movieList.add(movie);
        movieAdapter.notifyDataSetChanged();
    }

    private void onMenuRemovePress() {
        if (movieList != null && movieList.size() > 0) {
            movieList.remove(0);
            movieAdapter.notifyDataSetChanged();
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
