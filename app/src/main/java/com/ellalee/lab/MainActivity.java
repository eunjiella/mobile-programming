package com.ellalee.lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= findViewById(R.id.imageView1);
        imageView2= findViewById(R.id.imageView2);
    }
    public void onButtonClicked(View v){
       changeImage();
    }//when the button is clicked


    private void changeImage(){ //convert between 2 images
        if (imageView2.getVisibility()==View.VISIBLE){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
        }
        else if(imageView.getVisibility()==View.VISIBLE){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
        }
    }
}
