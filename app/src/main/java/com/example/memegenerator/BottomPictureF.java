package com.example.memegenerator;

import android.graphics.Bitmap;
import android.graphics.Color;
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
import java.util.HashMap;


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

    public void setClickedText(String top, String bottom, Uri imageUri, String clr) {

        txtTop.setText ( top );
        HashMap<String, String> map=new HashMap<String, String> (  );
        /*<color name="Black">#000000</color>
    <color name="White">#FFFFFF</color>
    <color name="Red">#EB226B</color>
    <color name="Blue">	#000080</color>*/
        map.put ( "Black","#000000" );
        map.put ( "White","#FFFFFF" );
        map.put ( "Red","#EB226B" );
        map.put ( "Blue","#000080" );

        int str=Color.parseColor (map.get ( clr ));


        txtTop.setTextColor ( str  );
        txtBottom.setText ( bottom );
        txtBottom.setTextColor ( str );
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