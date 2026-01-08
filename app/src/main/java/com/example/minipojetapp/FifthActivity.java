package com.example.minipojetapp;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        // ربط العناصر من الواجهة
        ProgressBar progressBar = findViewById(R.id.progressBar);
        ImageButton btnCorrect = findViewById(R.id.btnCorrect);
        ImageButton btnWrong = findViewById(R.id.btnWrong);

        // عند الضغط على زر الصح (الإجابة الصحيحة)
        btnCorrect.setOnClickListener(v -> {
            Toast.makeText(this, "Correct! Keep it up!", Toast.LENGTH_SHORT).show();
            // زيادة التقدم في الشريط
            progressBar.setProgress(progressBar.getProgress() + 10);
        });

        // عند الضغط على زر الخطأ
        btnWrong.setOnClickListener(v -> {
            Toast.makeText(this, "Reviewing this word later", Toast.LENGTH_SHORT).show();
        });
    }
}