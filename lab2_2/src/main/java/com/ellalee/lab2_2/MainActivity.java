package com.ellalee.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.URL = findViewById(R.id.url);
        Button bNext = findViewById(R.id.btnNext);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendURL = URL.getText().toString();

                Intent intent = new Intent(getBaseContext(),Main2Activity.class);
                intent.putExtra(Main2Activity.URL,sendURL);
                startActivity(intent);
            }
        });





    }
}
