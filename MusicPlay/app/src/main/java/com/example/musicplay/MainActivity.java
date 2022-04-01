package com.example.musicplay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView l;
    String[] music ={"1","2","3","4","5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = findViewById(R.id.list);
        ArrayAdapter arr = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,music);
        l.setAdapter(arr);
        l.setOnItemClickListener((adapterView, view, i, l) -> {
            String selectedItem = (String) adapterView.getItemAtPosition(i);
            Toast.makeText(getApplicationContext(),"U clicked "+selectedItem,Toast.LENGTH_LONG).show();
        });
    }
}