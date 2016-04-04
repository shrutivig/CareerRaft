package careerraft.app.android.sec.com.careerraft;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CoreValuesActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_values);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Core Values");

        final TextView coreValue1 = (TextView) findViewById(R.id.core_value_1);
        final TextView coreValueDetail1 = (TextView) findViewById(R.id.core_value_detail_1);

        coreValue1.postDelayed(new Runnable() {

            @Override
            public void run() {
                coreValue1.setVisibility(View.VISIBLE);
                coreValueDetail1.setVisibility(View.VISIBLE);
            }

        }, 1000);

        final TextView coreValue2 = (TextView) findViewById(R.id.core_value_2);
        final TextView coreValueDetail2 = (TextView) findViewById(R.id.core_value_detail_2);

        coreValue2.postDelayed(new Runnable() {

            @Override
            public void run() {
                coreValue2.setVisibility(View.VISIBLE);
                coreValueDetail2.setVisibility(View.VISIBLE);
            }

        }, 2000);

        final TextView coreValue3 = (TextView) findViewById(R.id.core_value_3);
        final TextView coreValueDetail3 = (TextView) findViewById(R.id.core_value_detail_3);

        coreValue3.postDelayed(new Runnable() {

            @Override
            public void run() {
                coreValue3.setVisibility(View.VISIBLE);
                coreValueDetail3.setVisibility(View.VISIBLE);
            }

        }, 3000);

        final TextView coreValue4 = (TextView) findViewById(R.id.core_value_4);
        final TextView coreValueDetail4 = (TextView) findViewById(R.id.core_value_detail_4);

        coreValue4.postDelayed(new Runnable() {

            @Override
            public void run() {
                coreValue4.setVisibility(View.VISIBLE);
                coreValueDetail4.setVisibility(View.VISIBLE);
            }

        }, 4000);

        final TextView coreValue5 = (TextView) findViewById(R.id.core_value_5);
        final TextView coreValueDetail5 = (TextView) findViewById(R.id.core_value_detail_5);

        coreValue5.postDelayed(new Runnable() {

            @Override
            public void run() {
                coreValue5.setVisibility(View.VISIBLE);
                coreValueDetail5.setVisibility(View.VISIBLE);
            }

        }, 5000);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar_with_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
