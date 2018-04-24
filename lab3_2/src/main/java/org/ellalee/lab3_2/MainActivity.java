package org.ellalee.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText name;
    RadioGroup gender;
    RadioButton female;
    RadioButton male;
    CheckBox SMS;
    CheckBox Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editName);
        gender = findViewById(R.id.radGender);
        female = findViewById(R.id.female);
        male = findViewById(R.id.male);   
        SMS = findViewById(R.id.chkSMS);
        Email = findViewById(R.id.chkEmail);

        Button btnAssign = findViewById(R.id.btnAssign);

        btnAssign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("name",name.getText().toString());

                int radId = gender.getCheckedRadioButtonId();
                if(radId==female.getId())
                    intent.putExtra("gender","여");
                else if(radId==male.getId())
                    intent.putExtra("gender","남");

                String msg ="";
                if(SMS.isChecked())
                    msg += " SMS";
                if(Email.isChecked())
                    msg += " e-mail";
                if(!SMS.isChecked()&&!Email.isChecked())
                    msg +=" N/A";
                intent.putExtra("contact",msg);

                startActivity(intent);
            }
        });
    }
}
