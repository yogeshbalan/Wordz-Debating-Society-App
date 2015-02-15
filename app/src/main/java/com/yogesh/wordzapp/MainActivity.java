package com.yogesh.wordzapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.yogesh.wordzapp.utils.NotifyScrollView;

public class MainActivity extends ActionBarActivity implements NotifyScrollView.Callback {

    private Toolbar toolbar;
    ImageButton Wbasic, Wschedule, Wsupport;

    //this is it
    private NotifyScrollView mNotifyScrollView;
    private FrameLayout mImageFrameLayout;
    private ImageView mImageView;
    private LinearLayout mContentLinearLayout;
    private LinearLayout mToolbarLinearLayout;
    //yep

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new
        mNotifyScrollView = (NotifyScrollView) findViewById(R.id.notify_scroll_view);
        mImageFrameLayout = (FrameLayout) findViewById(R.id.image_frame_layout);
        mImageView = (ImageView) findViewById(R.id.image_view);
        mContentLinearLayout = (LinearLayout) findViewById(R.id.content_linear_layout);
        mToolbarLinearLayout = (LinearLayout) findViewById(R.id.toolbar_linear_layout);
        //end

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.White));
        toolbar.setTitle("Wordz");
        toolbar.setSubtitle("The Debating Society");
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.md_blue_300));
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10f);
        }

        /*
        FadingActionBarHelper helper = new FadingActionBarHelper()
                .actionBarBackground(R.drawable.ic_support)
                .headerLayout(R.layout.header)
                .contentLayout(R.layout.activity_main);
        setContentView(helper.createView(this));
        helper.initActionBar(this);
        */

        Wbasic = (ImageButton) findViewById(R.id.basics);
        Wschedule = (ImageButton) findViewById(R.id.calender);
        Wsupport = (ImageButton) findViewById(R.id.support);

        // more setup
        //setupNotifyScrollView();
        //setupToolbar();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Drawable d = getResources().getDrawable(R.drawable.ic_launcher);
            new MaterialDialog.Builder(this)
                    .title("About Me")
                    .content(Html.fromHtml(getString(R.string.about_body)))
                            //.positiveText("Agree")
                            //.negativeText("Disagree")
                    .icon(d)
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void ShowBasic(final View view) {
        Intent intent = new Intent(this, WordzBasic.class);
        //startActivity(intent);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(intent);
        }
        //overridePendingTransition(R.anim.slide_in, R.anim.fade_out);
    }

    public void ShowSchedule(final View view) {
        Intent intent = new Intent(this, WordzSchedule.class);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(intent);
        }
        //overridePendingTransition(R.anim.slide_in, R.anim.fade_out);
    }

    public void ShowSupport(final View view) {
        Intent intent = new Intent(this, WordzSupport.class);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(intent);
        }
        //overridePendingTransition(R.anim.slide_in, R.anim.fade_out);
    }

    //toolbar methods
    private void setupNotifyScrollView() {
        mNotifyScrollView.setCallback(this);

        ViewTreeObserver viewTreeObserver = mNotifyScrollView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    // get size
                    int toolbarLinearLayoutHeight = mToolbarLinearLayout.getHeight();
                    int imageHeight = mImageView.getHeight();

                    // adjust image frame layout height
                    ViewGroup.LayoutParams layoutParams = mImageFrameLayout.getLayoutParams();
                    if (layoutParams.height != imageHeight) {
                        layoutParams.height = imageHeight;
                        mImageFrameLayout.setLayoutParams(layoutParams);
                    }

                    // adjust top margin of content linear layout
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) mContentLinearLayout.getLayoutParams();
                    if (marginLayoutParams.topMargin != toolbarLinearLayoutHeight + imageHeight) {
                        marginLayoutParams.topMargin = toolbarLinearLayoutHeight + imageHeight;
                        mContentLinearLayout.setLayoutParams(marginLayoutParams);
                    }

                    // call onScrollChange to update initial properties.
                    onScrollChanged(0, 0, 0, 0);
                }
            });
        }
    }

    private void setupToolbar() {
        // set ActionBar as Toolbar
        setSupportActionBar(toolbar);
    }

    @Override
    public void onScrollChanged(int left, int top, int oldLeft, int oldTop) {
        // get scroll y
        int scrollY = mNotifyScrollView.getScrollY();

        // calculate new y (for toolbar translation)
        float newY = Math.max(mImageView.getHeight(), scrollY);

        // translate toolbar linear layout and image frame layout
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mToolbarLinearLayout.setTranslationY(newY);
            mImageFrameLayout.setTranslationY(scrollY * 0.5f);
        } else {
            ViewCompat.setTranslationY(mToolbarLinearLayout, newY);
            ViewCompat.setTranslationY(mImageFrameLayout, scrollY * 0.5f);
        }
    }

    //end

}
