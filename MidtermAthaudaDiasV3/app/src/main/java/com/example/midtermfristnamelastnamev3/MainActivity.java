package com.example.midtermfristnamelastnamev3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.midtermfirstnamelastnamev3";
    private EditText euro_amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        euro_amt = findViewById(R.id.et_amount);
    }


    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        double dollars = 0;

        String message = euro_amt.getText().toString();

        dollars = Double.parseDouble(message) * 1.13;

        message = String.valueOf(dollars);

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

        Log.d(LOG_TAG, "Button Clicked" + message);
    }
}