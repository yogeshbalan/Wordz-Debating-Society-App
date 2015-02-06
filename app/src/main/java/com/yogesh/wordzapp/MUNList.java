package com.yogesh.wordzapp;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MUNList extends ActionBarActivity {
    
    private Toolbar toolbar;
    private TextView Manipal,NSIT;
    private Typeface font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_munlist);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("List of all MUN");
        toolbar.setTitleTextColor(getResources().getColor(R.color.White));
        setSupportActionBar(toolbar);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            toolbar.setElevation(10f);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        
        Manipal = (TextView) findViewById(R.id.textview_manipal);
        NSIT = (TextView) findViewById(R.id.textview_NSIT);
        Manipal.setMovementMethod(LinkMovementMethod.getInstance());
        NSIT.setMovementMethod(LinkMovementMethod.getInstance());
        font = Typeface.createFromAsset(getAssets(),"fonts/Gotham-BookItalic.ttf");
        Manipal.setTypeface(font);
        NSIT.setTypeface(font);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_munlist, menu);
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
}
