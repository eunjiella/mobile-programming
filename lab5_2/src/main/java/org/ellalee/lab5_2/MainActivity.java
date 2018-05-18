package org.ellalee.lab5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int input;
    public TextView txtProgress;
    public TextView txtResult;
    public EditText txtInput;
    public Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = findViewById(R.id.input);
        txtProgress = findViewById(R.id.txtProgress);
        txtResult = findViewById(R.id.txtResult);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{
                    input = Integer.parseInt(txtInput.getText().toString());
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Wrong Input", Toast.LENGTH_SHORT).show();
                }
                new Factorial().execute(input);
            }
        });

    }
    private class Factorial extends AsyncTask< Integer ,String ,Integer>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            String progress = new String(" ");
            int result=1;
            for(int i=integers[0] ;i>0; i--){
                try{
                    Thread.sleep(500);
                    result *= i;
                    progress = progress + i + " ";
                    publishProgress(progress);
                }catch (Exception ex){}
            }
            return result;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            txtProgress.setText(values[0]);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            txtResult.setText("= "+integer);
        }
    }
}
