package com.example.memegenerator;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class BottomPictureF extends Fragment {

    private static TextView txtTop;
    private static TextView txtBottom;
    private static ImageView img;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);
        txtTop = (TextView)view.findViewById(R.id.txtTop);
        txtBottom = (TextView)view.findViewById(R.id.txtBottom);

        img=(ImageView)view.findViewById ( R.id.imageView );
        return view;
    }

    public void setClickedText(String top, String bottom, Uri imageUri) {

        txtTop.setText ( top );
        txtBottom.setText ( bottom );
        try{
            Bitmap bitmap=MediaStore.Images.Media.getBitmap ( getContext ().getContentResolver (),imageUri );
            img.setImageBitmap ( bitmap );
        }
        catch(IOException e){

        }
        catch(NullPointerException e){
            img.setImageDrawable ( getResources().getDrawable(R.drawable.messed) );
        }
    }
}