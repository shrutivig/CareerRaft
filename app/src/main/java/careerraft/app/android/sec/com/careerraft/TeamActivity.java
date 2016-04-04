package careerraft.app.android.sec.com.careerraft;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by shruti.vig on 4/4/16.
 */
public class TeamActivity extends BaseActivity {
    View mVisibleView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_team);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("The team");

        Drawable teamBackground = findViewById(R.id.scroll_view).getBackground();
        teamBackground.setAlpha(100);

        LinearLayout atulTiwari = (LinearLayout) findViewById(R.id.atul_tiwari);
        final TextView atulTiwariDetail = (TextView) findViewById(R.id.atul_tiwari_detail);
        atulTiwari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (atulTiwariDetail.getVisibility() == View.VISIBLE) {
                    atulTiwariDetail.setVisibility(View.GONE);
                    mVisibleView = null;
                } else {
                    if (mVisibleView != null) {
                        mVisibleView.setVisibility(View.GONE);
                    }
                    atulTiwariDetail.setVisibility(View.VISIBLE);
                    mVisibleView = atulTiwariDetail;
                }
            }
        });

        LinearLayout abhishek = (LinearLayout) findViewById(R.id.abhishek);
        final TextView abhishekDetail = (TextView) findViewById(R.id.abhishek_detail);
        abhishek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (abhishekDetail.getVisibility() == View.VISIBLE) {
                    abhishekDetail.setVisibility(View.GONE);
                    mVisibleView = null;
                } else {
                    if (mVisibleView != null) {
                        mVisibleView.setVisibility(View.GONE);
                    }
                    abhishekDetail.setVisibility(View.VISIBLE);
                    mVisibleView = abhishekDetail;
                }
            }

        });

        LinearLayout amitava = (LinearLayout) findViewById(R.id.amitava);
        final TextView amitavaDetail = (TextView) findViewById(R.id.amitava_detail);
        amitava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (amitavaDetail.getVisibility() == View.VISIBLE) {
                    amitavaDetail.setVisibility(View.GONE);
                    mVisibleView = null;
                } else {

                    if (mVisibleView != null) {
                        mVisibleView.setVisibility(View.GONE);
                    }
                    amitavaDetail.setVisibility(View.VISIBLE);
                    mVisibleView = amitavaDetail;
                }
            }

        });

        ImageView atulLinkedin = (ImageView) findViewById(R.id.atul_linkedin);
        atulLinkedin.setOnClickListener(openWebLinkClickListener);

        ImageView abhishekLinkedin = (ImageView) findViewById(R.id.abhishek_linkedin);
        abhishekLinkedin.setOnClickListener(openWebLinkClickListener);

        ImageView amitavaLinkedin = (ImageView) findViewById(R.id.amitava_linkedin);
        amitavaLinkedin.setOnClickListener(openWebLinkClickListener);

    }

    View.OnClickListener openWebLinkClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.atul_linkedin:
                    openWebLink(Constants.ATUL_LINKEDIN);
                    break;
                case R.id.amitava_linkedin:
                    openWebLink(Constants.ATUL_LINKEDIN);
                    break;
                case R.id.abhishek_linkedin:
                    openWebLink(Constants.ATUL_LINKEDIN);
                    break;
            }
        }
    };

    private void openWebLink(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar_with_home, menu);
        return super.onCreateOptionsMenu(menu);
    }
}