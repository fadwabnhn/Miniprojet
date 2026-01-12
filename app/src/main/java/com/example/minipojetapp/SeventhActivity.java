package com.example.minipojetapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeventhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setText("🎉 Welcome 🎉");
        tv.setTextSize(28f);
        tv.setTextColor(0xFF000000);
        tv.setGravity(android.view.Gravity.CENTER);

        setContentView(tv);
    }
}
