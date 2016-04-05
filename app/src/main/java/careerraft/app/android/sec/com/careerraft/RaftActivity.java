package careerraft.app.android.sec.com.careerraft;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

import careerraft.app.android.sec.com.careerraft.Adapter.CategoryAdapter;
import careerraft.app.android.sec.com.careerraft.Model.Category;

public class RaftActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Session mSession;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_drawer_main);
        mSession = Session.getInstance(this);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_nav_drawer, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                RecyclerView recyclerView = (RecyclerView) navigationView.getChildAt(0);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                layoutManager.smoothScrollToPosition(recyclerView, null, 0);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        try {
            mAdapter = new CategoryAdapter(getDataFromAssetJson(), new CategoryAdapter.OnItemClickListenerCustom() {
                @Override
                public void onItemClickCustom(Category item, View view) {

                    mSession.getRaftDetailSubCategories(item.getCategoryTitle());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        view.setTransitionName("transitionCategory");
                    }

                    Intent intent = new Intent(RaftActivity.this, RaftDetailActivity.class);
                    intent.putExtra("category_name", item.getCategoryTitle());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ActivityOptionsCompat options = ActivityOptionsCompat.
                                makeSceneTransitionAnimation(RaftActivity.this, view, "transitionCategory");
                        startActivity(intent, options.toBundle());
                    } else {
                        startActivity(intent);
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mRecyclerView.setAdapter(mAdapter);


    }

    public ArrayList<Category> getDataFromAssetJson() throws JSONException {

        JSONObject jsonObject = new JSONObject(loadJSONFromAsset());

        JSONArray jsonCategoryArray = jsonObject.getJSONArray("categories");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Category>>() {
        }.getType();
        ArrayList<Category> fromJson = gson.fromJson(jsonCategoryArray.toString(), type);

        return fromJson;
    }

    public String loadJSONFromAsset() {

        String json;
        try {
            InputStream is = this.getAssets().open("categoryJson.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.drawer:
                if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
                    mDrawerLayout.closeDrawer(GravityCompat.END);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.END);
                }
                return true;

            case android.R.id.home:
                onBackPressed();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
            mDrawerLayout.closeDrawer(GravityCompat.END);
            return;
        } else
            super.onBackPressed();
    }

    void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(final MenuItem menuItem) {

                        mDrawerLayout.closeDrawers();

                        if (menuItem.getTitle().equals("Core Values")) {
                            startActivity(new Intent(RaftActivity.this, CoreValuesActivity.class));
                        }

                        if (menuItem.getTitle().equals("Team")) {
                            startActivity(new Intent(RaftActivity.this, TeamActivity.class));
                        }

                        if (menuItem.getTitle().equals("About")) {
                            startActivity(new Intent(RaftActivity.this, AboutUsActivity.class));
                        }
                        return true;
                    }
                });
    }
}
