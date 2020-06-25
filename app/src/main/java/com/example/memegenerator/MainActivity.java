package com.example.memegenerator;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends FragmentActivity implements TopSectionF.TopSectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void createClick(String top, String bottom, Uri imageUri, String clr,String clr2) {
        BottomPictureF bottomFragment = (BottomPictureF)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottomFragment.setClickedText(top, bottom, imageUri,clr,clr2);
    }



}
