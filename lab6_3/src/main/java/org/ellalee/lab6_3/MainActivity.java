package org.ellalee.lab6_3;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText inputName;
    EditText inputSN;
    String name;
    String sn;

    ListView listView;
    SQLiteDatabase db;
    DbOpenHelper helper;
    String[] studentList;

    Button btnAdd;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.editName);
        inputSN = findViewById(R.id.editSN);

        listView = findViewById(R.id.listView);
        helper = new DbOpenHelper(MainActivity.this,"student.db",null,1);

        btnAdd =findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = inputName.getText().toString();
                sn = inputSN.getText().toString();

                if(isEmpty(name)||isEmpty(sn)){
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    insert(name, sn);
                    invalidate();
                }
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = inputName.getText().toString();

                if(isEmpty(name)){
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    delete(name);
                    invalidate();
                }
            }
        });
    }
    
    public void insert(String inputName,String inputSN){

            db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name",inputName);
            values.put("sn",inputSN);
            db.insert("student",null,values);
    }
    
    public void delete(String inputName){
            db = helper.getWritableDatabase();
            db.delete("student","name=?",new String[]{inputName});
    }

    public void select(){
        db =helper.getReadableDatabase();
        Cursor cursor = db.query("student",null,null,null,null,null,null);
        studentList = new String[cursor.getCount()];
        int i=0;
        while(cursor.moveToNext()){
            studentList[i++]=cursor.getString(cursor.getColumnIndex("name"))+" "+cursor.getString(cursor.getColumnIndex("sn"));
        }
        cursor.close();
    }

    public void invalidate(){
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,studentList);
        listView.setAdapter(adapter);
    }

    public boolean isEmpty(String mInput){
        return mInput.length() == 0;
    }
}
