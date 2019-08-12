package com.example.memegenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity implements TopSectionF.TopSectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This code called by the Top Fragment called when the user clicked the button
    @Override
    public void createClick(String top, String bottom) {
        BottomPictureF bottomFragment = (BottomPictureF)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottomFragment.setClickedText(top, bottom);
    }



}