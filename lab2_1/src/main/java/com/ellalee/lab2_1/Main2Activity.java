package com.ellalee.lab2_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    public static String key_name = "KeyName";
    public static String key_age = "KeyAge";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) { //if bundle is not empty
            String name = bundle.getString(key_name);
            String age = bundle.getString(key_age);

            Toast.makeText(this, "Student info "+name+", "+age, Toast.LENGTH_SHORT).show();
        }

        Button btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //discard current activity
            }
        });
    }
}
