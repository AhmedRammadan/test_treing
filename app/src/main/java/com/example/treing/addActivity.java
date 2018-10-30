package com.example.treing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addActivity extends AppCompatActivity {
    dbhelper dbhelper ;
    EditText et_name , et_age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        dbhelper = new dbhelper(addActivity.this);
    }

    public void add(View view) {
        String name = et_name.getText().toString();
        String age = et_age.getText().toString();
        if (!name.equals("") && !age.equals("")){
            dbhelper.add(new Item(name,Integer.parseInt(age)));
            Toast.makeText(this, "add Data", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "enter name and age ", Toast.LENGTH_SHORT).show();
        }
    }
}
