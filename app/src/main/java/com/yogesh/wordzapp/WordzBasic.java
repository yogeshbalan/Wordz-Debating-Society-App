package com.yogesh.wordzapp;

import android.app.ActivityOptions;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.yogesh.wordzapp.fragments.Model_UN_pro;


public class WordzBasic extends ActionBarActivity {
    
    private Toolbar toolbar;
    private CharSequence mTitle;
    Fragment newFragment;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordz_basic);
        
        mTitle = "Rules of procedure";

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(mTitle);
        toolbar.setTitleTextColor(getResources().getColor(R.color.White));
        setSupportActionBar(toolbar);
        

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        newFragment = new Model_UN_pro();
        fragmentTransaction = getFragmentManager().beginTransaction();

    }
    
    public void ModelUN(final View view){
        Intent intent = new Intent(this, MODEL_UN_PRO.class);
        if(Build.VERSION.SDK_INT==Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }else{
            startActivity(intent);
        }

        //fragmentTransaction.replace(R.id.scrollview_un, newFragment);
        //fragmentTransaction.addToBackStack(null);
        //fragmentTransaction.commit();
        

    }

    public void MUNvocab(final View view){
        Intent intent = new Intent(this, MUNVocab.class);
        if(Build.VERSION.SDK_INT==Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }else{
            startActivity(intent);
        }

    }

    public void PointsAndMotionList(final View view){
        Intent intent = new Intent(this, PointsAndMotionList.class);
        if(Build.VERSION.SDK_INT==Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }else{
            startActivity(intent);
        }

    }

    public void Resolutions(final View view) {
        Intent intent = new Intent(this, Resolutions.class);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(intent);
        }

    }

    public void SampleResolutions(final View view){
        Intent intent = new Intent(this, SampleResolution.class);
        if(Build.VERSION.SDK_INT==Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }else{
            startActivity(intent);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wordz_basic, menu);
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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /*
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(Build.VERSION.SDK_INT==Build.VERSION_CODES.LOLLIPOP) {
            // previously visible view
            final View myView = findViewById(R.id.wordzbasic);

// get the center for the clipping circle
            int cx = (myView.getLeft() + myView.getRight()) / 2;
            int cy = (myView.getTop() + myView.getBottom()) / 2;

// get the initial radius for the clipping circle
            int initialRadius = myView.getWidth();

// create the animation (the final radius is zero)
            Animator anim =
                    ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0);

// make the view invisible when the animation is done
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    myView.setVisibility(View.INVISIBLE);
                }
            });

// start the animation
            anim.start();
            finish();
        }else{
            finish();
        }
    }
    */
}
