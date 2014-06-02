package com.androidhuman.example.navigationdrawer.basicfragments.app;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Text;

public class MainActivity extends ActionBarActivity {

    DrawerLayout dlDrawer;
    ActionBarDrawerToggle dtToggle;

    ListView lvDrawerList;
    ArrayAdapter<String> adtDrawerList;
    String[] menuItems = new String[]{"TextFragment", "ImageFragment"};

    TextFragment fragText;
    ImageFragment fragImage;

    static final String KEY_FRAGMENT_ID = "fragment_id";
    static final int FRAGMENT_TEXT = 0;
    static final int FRAGMENT_IMAGE = 1;

    int lastFragmentId = FRAGMENT_TEXT;

    private void selectFragment(int fragmentId){
        switch(fragmentId){
            case FRAGMENT_TEXT:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_activity_main, fragText).commit();
                break;
            case FRAGMENT_IMAGE:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_activity_main, fragImage).commit();
                break;
        }
        lastFragmentId = fragmentId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fragments
        fragText = TextFragment.newInstance();
        fragImage = new ImageFragment().newInstance();

        if(savedInstanceState==null){
            selectFragment(FRAGMENT_TEXT);
        }else{
            selectFragment(savedInstanceState.getInt(KEY_FRAGMENT_ID));
        }

        // Navigation drawer : menu lists
        lvDrawerList = (ListView) findViewById(R.id.lv_activity_main);
        adtDrawerList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuItems);
        lvDrawerList.setAdapter(adtDrawerList);
        lvDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectFragment(position);
                dlDrawer.closeDrawer(lvDrawerList);
            }
        });

        // Navigation drawer : ActionBar Toggle
        dlDrawer = (DrawerLayout) findViewById(R.id.dl_activity_main);
        dtToggle = new ActionBarDrawerToggle(this, dlDrawer, R.drawable.ic_drawer, R.string.app_name, R.string.app_name);
        dlDrawer.setDrawerListener(dtToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        dtToggle.syncState();
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_FRAGMENT_ID, lastFragmentId);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        dtToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(dtToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
