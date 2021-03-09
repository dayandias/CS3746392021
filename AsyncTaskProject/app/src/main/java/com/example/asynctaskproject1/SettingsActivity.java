package com.example.asynctaskproject1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asynctaskproject1.R;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_act);

        TextView textView = findViewById(R.id.textView2);
        textView.setText(R.string.settings_txt);
    }
}
