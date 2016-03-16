package careerraft.app.android.sec.com.careerraft;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
/**
 * Created by shruti.vig on 3/10/16.
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.landing_page:
                startActivityLandingPage(this);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void startActivityLandingPage(Context context) {
        Intent intent = new Intent(context, RaftActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
