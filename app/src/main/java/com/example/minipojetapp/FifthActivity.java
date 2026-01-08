package com.example.minipojetapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.google.android.material.slider.Slider;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        // 1. ربط المربعات الأربعة (Skills)
        CardView cardListen = findViewById(R.id.cardListen);
        CardView cardSpeak = findViewById(R.id.cardSpeak);
        CardView cardWrite = findViewById(R.id.cardWrite);
        CardView cardRead = findViewById(R.id.cardRead);

        // 2. ربط عناصر الوقت (Slider & Value)
        Slider sliderTime = findViewById(R.id.sliderTime);
        TextView tvTimeValue = findViewById(R.id.tvTimeValue);

        // 3. ربط زر الاستراتيجية
        Button btnStrategy = findViewById(R.id.btnStrategy);

        // --- برمجة الأكشن ---

        // برمجة السلايدر لعرض الدقائق فور تغييرها
        sliderTime.addOnChangeListener((slider, value, fromUser) -> {
            tvTimeValue.setText((int) value + " min");
        });

        // برمجة النقر على مربعات المهارات
        cardListen.setOnClickListener(v -> showMessage("Listening mode selected 🎧"));
        cardSpeak.setOnClickListener(v -> showMessage("Speaking mode selected 💬"));
        cardWrite.setOnClickListener(v -> showMessage("Writing mode selected 🖋️"));
        cardRead.setOnClickListener(v -> showMessage("Reading mode selected 📖"));

        // برمجة زر الاستراتيجية (الزر الأصفر الكبير)
        btnStrategy.setOnClickListener(v -> {
            int selectedTime = (int) sliderTime.getValue();
            showMessage("Strategy saved with " + selectedTime + " minutes! 🚀");
            // هنا يمكنك إضافة Intent للانتقال لواجهة أخرى إذا أردت
        });
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}