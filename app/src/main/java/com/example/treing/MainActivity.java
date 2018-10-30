package com.example.treing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    dbhelper dbhelper ;
    ArrayList<Item> items ;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        dbhelper = new dbhelper(MainActivity.this);
        items = dbhelper.getAll();
        ItemAdapter adapter = new ItemAdapter(MainActivity.this,0,items);
        list.setAdapter(adapter);

    }

    public void add(View view) {
        startActivity(new Intent(MainActivity.this,addActivity.class));
    }
}
