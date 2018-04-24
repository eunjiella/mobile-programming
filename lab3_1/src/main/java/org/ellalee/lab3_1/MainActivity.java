package org.ellalee.lab3_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button textBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBtn = findViewById(R.id.textBtn);
        registerForContextMenu(textBtn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Button Menu");
        menu.add(0,1,100,"Red");
        menu.add(0,2,100,"Green");
        menu.add(0,3,100,"Blue");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                textBtn.setTextColor(Color.RED);
                return true;
            case 2:
                textBtn.setTextColor(Color.GREEN);
                return true;
            case 3:
                textBtn.setTextColor(Color.BLUE);
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
