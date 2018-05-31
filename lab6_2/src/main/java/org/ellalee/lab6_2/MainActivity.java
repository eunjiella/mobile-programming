package org.ellalee.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText SN;
    EditText Name;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SN = findViewById(R.id.editSN);
        Name = findViewById(R.id.editName);
        pref = getSharedPreferences("lab6_2",MODE_PRIVATE);
        editor = pref.edit();

    }

    public void load(View v){
        if(isEditTextEmpty(SN)){
            Toast.makeText(this, "Please enter student number to load data", Toast.LENGTH_SHORT).show();
        }else{
            String result;
            result = pref.getString(SN.getText().toString(),"");
            if(result.equals("")){
                Toast.makeText(this, "There is no matching value.", Toast.LENGTH_SHORT).show();
            }
            else{
                Name.setText(result);
            }
        }
    }
    public void save(View v) {
        if (isEditTextEmpty(SN) || isEditTextEmpty(Name)) {
            Toast.makeText(this, "Please enter both values.", Toast.LENGTH_SHORT).show();
        } else {
            editor.putString(SN.getText().toString(), Name.getText().toString());
            editor.commit();
        }
    }

    public void reset(View v){
        SN.setText("");
        Name.setText("");
    }

    public boolean isEditTextEmpty(EditText mInput){
        return mInput.length() == 0;
    }
}
