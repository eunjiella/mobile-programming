package com.ellalee.lap1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity1_2 extends AppCompatActivity {

    public TextView content;
    public EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity1_2);
        init(); //initialize
    }
    public void init(){ //getting objects
        content = findViewById(R.id.printHere);
        input = findViewById(R.id.input);
    }
    public void onB_ClearClicked(View v){
        input.setText(""); //make it empty
        content.setText("contents"); //default view text
    }
    public void onB_PrintClicked(View v){
        content.setText(input.getText().toString()); //get text from editText
    }
}
