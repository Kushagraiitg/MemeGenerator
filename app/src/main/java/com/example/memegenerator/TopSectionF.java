package com.example.memegenerator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class TopSectionF extends Fragment {

    private static final int RESULT_OK = 1;
    private static EditText etTopTextInput;
    private static EditText etBottomTextInput;

    private static final int PICK_IMAGE = 3;
    private static final int GENERATE = 2;
    Uri imageUri;
    TopSectionListener activityCommander;
    private String clr="Black";
    private String clr2="Black";
    public interface TopSectionListener{
        public void createClick(String top, String bottom,Uri imageUri,String clr1,String clr12);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = context instanceof Activity ? (Activity) context : null;
        try{
            activityCommander = (TopSectionListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }


    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragments, container, false);

        etTopTextInput = (EditText)view. findViewById(R.id.TopText);
        etBottomTextInput = (EditText)view.findViewById(R.id.BottomText);

        final Button generateButton = (Button)view.findViewById(R.id.button);
        final Button SelectPic = (Button)view.findViewById (R.id.SelectP);
        final RadioGroup rGroup = (RadioGroup)view.findViewById(R.id.radioGroup);
        final RadioButton RadioButton1 = (RadioButton)rGroup.findViewById(R.id.radioButton1);
        RadioButton1.setOnClickListener ( new View.OnClickListener(){

            @Override
            public void onClick(View v) {



                System.out.println ( "Kuch hua hai, dekho zara" );
                clr2=clr;
                clr=RadioButton1.getText().toString ();


            }
        } );
        final RadioButton RadioButton2 = (RadioButton)rGroup.findViewById(R.id.radioButton2);
        RadioButton2.setOnClickListener ( new View.OnClickListener(){

            @Override
            public void onClick(View v) {



                System.out.println ( "Kuch hua hai, dekho zara" );
                clr2=clr;
                clr=RadioButton2.getText().toString ();


            }
        } );
        final RadioButton RadioButton3 = (RadioButton)rGroup.findViewById(R.id.radioButton3);
        RadioButton3.setOnClickListener ( new View.OnClickListener(){

            @Override
            public void onClick(View v) {



                System.out.println ( "Kuch hua hai, dekho zara" );
                clr2=clr;
                clr=RadioButton3.getText().toString ();


            }
        } );
        final RadioButton RadioButton4 = (RadioButton)rGroup.findViewById(R.id.radioButton4);
        RadioButton4.setOnClickListener ( new View.OnClickListener(){

            @Override
            public void onClick(View v) {



                System.out.println ( "Kuch hua hai, dekho zara" );
                clr2=clr;
                clr=RadioButton4.getText().toString ();


            }
        } );


        /*
        // This will get the radiogroup
        RadioGroup rGroup = (RadioGroup)view.findViewById(R.id.radioGroup);
        // This will get the radiobutton in the radiogroup that is checked
        RadioButton checkedRadioButton = (RadioButton)rGroup.findViewById(rGroup.getCheckedRadioButtonId());


        clr=checkedRadioButton.getText().toString ();
        */
        SelectPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery, "Select Picture"), PICK_IMAGE);
                System.out.println ( "Selected the image" );
            }
        });

        generateButton.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                        buttonClicked(v);

                    }
                }
        );

        return view;
    }

    //Calls this when button clicked
    public void buttonClicked(View view){

        activityCommander.createClick(etTopTextInput.getText().toString(), etBottomTextInput.getText().toString(), imageUri,clr,clr2);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        imageUri = data.getData();


        }
    }
