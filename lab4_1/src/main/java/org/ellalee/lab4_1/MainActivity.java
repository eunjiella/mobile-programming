package org.ellalee.lab4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout canvas = new LinearLayout(this);
        canvas.setOrientation(LinearLayout.VERTICAL);
        MyDraw draw = new MyDraw(MainActivity.this);

        canvas.addView(draw);
        setContentView(canvas);
    }
}
