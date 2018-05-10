package com.ellalee.lab2_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.name = findViewById(R.id.name);
        this.age = findViewById(R.id.age);

        Button button = findViewById(R.id.btnAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentName = name.getText().toString();
                String studentAge = age.getText().toString();

                Intent intent = new Intent(getBaseContext(), Main2Activity.class);
                intent.putExtra(Main2Activity.key_name, studentName); //send the student name to main2activity
                intent.putExtra(Main2Activity.key_age, studentAge); //send the student age to main2activity
                startActivity(intent);
            }
        });
    }
}
