package com.example.multiplicationtable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.mipmap.ic_launcher);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }

        setContentView(R.layout.activity_main);
        button = findViewById(R.id.Submit);
        textView = findViewById(R.id.Output);
        editText = findViewById(R.id.Input);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.Submit) {
                    StringBuffer result = new StringBuffer();
                    int ans;
                    String s = editText.getText().toString();
                    // todo: add limit to n value upto 99,999
                    int n = Integer.parseInt(s);
                    for (int i = 1; i <= 10; i++) {
                        ans = i * n;
                        result.append(n + " x " + i + " = " + ans + "\n\n");
                    }
                    textView.setText(result);
                }
            }
        });
    }
}