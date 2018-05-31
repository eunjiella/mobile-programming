package org.ellalee.lab6_1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    File root = Environment.getExternalStorageDirectory();
    EditText txtData;
    String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtData = findViewById(R.id.txtData);
        state = Environment.getExternalStorageState();
    }

    public void write(View v){
        if(!state.equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(this, "SD card is unable to write ", Toast.LENGTH_SHORT).show();
            return;
        }
        String data = txtData.getText().toString();

        try{
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File f = new File(path, "mySDfile.txt");

            FileWriter writer = new FileWriter(f,false);
            PrintWriter out = new PrintWriter(writer);

            out.print(data);
            out.close();

            Toast.makeText(this, "Done writing mySDfile.txt", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clear(View v){
        txtData.setText("");
    }

    public void read(View v){
        if (!state.equals(Environment.MEDIA_MOUNTED) && !state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            Toast.makeText(this, "SD card is unable to read", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            StringBuffer data = new StringBuffer();
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File f = new File(path, "mySDfile.txt");

            BufferedReader buffer = new BufferedReader(new FileReader(f));
            String str = buffer.readLine();
            while (str!=null) {
                data.append(str+"\n");
                str = buffer.readLine();
            }
            txtData.setText(data);
            buffer.close();

            Toast.makeText(this, "Done reading mySDfile.txt", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finish(View v){
        finish();
    }
}
