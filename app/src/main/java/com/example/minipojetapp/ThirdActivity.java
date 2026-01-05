package com.example.minipojetapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // ربط نص الترحيب
        TextView tvWelcome = findViewById(R.id.tvWelcomeTitle); // تأكد أن هذا الـ ID موجود في XML

        // استقبال الاسم الممرر من الواجهة السابقة
        String name = getIntent().getStringExtra("USER_NAME");

        if (name != null && !name.isEmpty()) {
            tvWelcome.setText("Hi " + name + " 👋");
        }
    }
}