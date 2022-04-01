package com.example.agecalculatorbasab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText dob;
    private Button submit;
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dob = findViewById(R.id.editTextNumber);
        submit = findViewById(R.id.button);
        show = findViewById(R.id.textView2);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int year = 0;
                year = Integer.parseInt(dob.getText().toString());
                CalculateAge(year);
            }
        });

    }
    private void CalculateAge(int year) {
        int PresentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (PresentYear > year) {
            int age = PresentYear-year;
            show.setText("Your age is "+age+" years.");
        }
        else {
            Toast.makeText(MainActivity.this, "Please Enter a Valid Number", Toast.LENGTH_SHORT).show();
        }
    }
}