package com.ellalee.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private TextView textView;
    private Button button_go;
    private Button button_back;
    public static String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.text_url);
        button_go = findViewById(R.id.btn_go);
        button_back = findViewById(R.id.btn_back);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            final String url = bundle.getString(URL);

            if(url != null && !url.equals("")) {
                textView.setText(url);
                button_go.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+url));
                        startActivity(intent);
                    }
                });
            }
            else if(url.equals("")){
                Toast.makeText(this, "주소를 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        }

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "뒤로가기 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
