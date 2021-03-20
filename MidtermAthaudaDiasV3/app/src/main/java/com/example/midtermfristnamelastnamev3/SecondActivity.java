package com.example.midtermfristnamelastnamev3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity {


    @Override protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        DecimalFormat form = new DecimalFormat("0.00");

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView showAmount = findViewById(R.id.textView2);

//        message = String.format("%.2f", message);
        showAmount.setText(message);

        Toast toast = Toast.makeText(this, "$$$ YOU ARE RICH $$$", Toast.LENGTH_LONG);
        toast.show();
    }


}
