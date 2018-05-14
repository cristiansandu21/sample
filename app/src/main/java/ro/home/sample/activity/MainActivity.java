package ro.home.sample.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ro.home.sample.R;
import ro.home.sample.controller.AlbumsAdapter;
import ro.home.sample.controller.AlbumsAdapterInterface;
import ro.home.sample.controller.GridSpacingDecoration;
import ro.home.sample.entity.Album;
import ro.home.sample.utils.LoremIpsum;

public class MainActivity extends AppCompatActivity implements AlbumsAdapterInterface {

    private RecyclerView recyclerView;
    private AlbumsAdapter mAdapter;
    private ArrayList<Album> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initialize();
    }

    private void initialize() {
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            initCollapseBar();

            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            albumList = LoremIpsum.getAlbumList(this);
            mAdapter = new AlbumsAdapter(albumList, this, this);

            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new GridSpacingDecoration(this, 2, 10, true));
            recyclerView.setAdapter(mAdapter);

            Glide.with(this).load(R.drawable.cover)
                    .into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapseBar() {
        final CollapsingToolbarLayout collapsingToolbarLayout =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    @Override
    public void onAddFavouritePress(Album album) {
        Toast.makeText(this, "Add to favourites", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPlayNextPress(Album album) {
        Toast.makeText(this, "Play next", Toast.LENGTH_SHORT).show();

    }
}
