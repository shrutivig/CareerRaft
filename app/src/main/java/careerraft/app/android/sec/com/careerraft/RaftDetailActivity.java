package careerraft.app.android.sec.com.careerraft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

import careerraft.app.android.sec.com.careerraft.Adapter.RaftDetailAdapter;
import careerraft.app.android.sec.com.careerraft.Model.RaftDetail;

/**
 * Created by shruti.vig on 3/10/16.
 */
public class RaftDetailActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raft_detail);

        TextView headerText = (TextView) findViewById(R.id.header_text);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        if (intent != null) {
            headerText.setText(intent.getStringExtra("category_name"));
            getSupportActionBar().setTitle(intent.getStringExtra("category_name"));
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_raft_detail);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        try {
            mAdapter = new RaftDetailAdapter(getDataFromAssetJson(), RaftDetailActivity.this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mRecyclerView.setAdapter(mAdapter);
    }

    public ArrayList<RaftDetail> getDataFromAssetJson() throws JSONException {

        JSONObject jsonObject = new JSONObject(loadJSONFromAsset());

        JSONArray jsonRaftDetail = jsonObject.getJSONArray("raftDetail");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<RaftDetail>>() {
        }.getType();
        ArrayList<RaftDetail> fromJson = gson.fromJson(jsonRaftDetail.toString(), type);

        return fromJson;
    }

    public String loadJSONFromAsset() {

        String json;
        try {
            InputStream is = this.getAssets().open("RaftDetail.json");
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


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar_with_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
