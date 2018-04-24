package org.ellalee.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView name;
    TextView gender;
    TextView contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.txtName);
        gender = findViewById(R.id.txtGender);
        contact = findViewById(R.id.txtContact);

        Intent data = getIntent();
        name.setText(data.getStringExtra("name"));
        gender.setText(data.getStringExtra("gender"));
        contact.setText(data.getStringExtra("contact"));

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
