package careerraft.app.android.sec.com.careerraft;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import careerraft.app.android.sec.com.careerraft.Utils.CustomScrollView;

/**
 * Created by shruti.vig on 4/5/16.
 */
public class AboutUsActivity extends BaseActivity implements CustomScrollView.ScrollViewListener {
    TextView step1;
    TextView step2;
    TextView step3;

    Animation animScaleAndShift;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        setContentView(R.layout.layout_about_us);

        CustomScrollView scrollView = (CustomScrollView) findViewById(R.id.scroll);
        scrollView.setScrollViewListener(this);
        TextView titleText = (TextView) findViewById(R.id.title_text);
        Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.enter);
        titleText.setAnimation(animFadein);

        step1 = (TextView) findViewById(R.id.step_1);
        step2 = (TextView) findViewById(R.id.step_2);
        step3 = (TextView) findViewById(R.id.step_3);
        animScaleAndShift = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.scale);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(android.R.color.black));
        }
    }

    @Override
    public void onScrollChanged(CustomScrollView scrollView, int x, int y, int oldx, int oldy) {
        //     View view = (View) scrollView.getChildAt(scrollView.getChildCount() - 1);
        View view = step1;
        int diff = (view.getBottom() - (scrollView.getHeight() + scrollView.getScrollY()));
        if (diff <= 0) {
            step1.startAnimation(animScaleAndShift);
            step2.startAnimation(animScaleAndShift);
            step3.startAnimation(animScaleAndShift);
        }
    }
}
