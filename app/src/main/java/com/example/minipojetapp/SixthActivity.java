package com.example.minipojetapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class SixthActivity extends AppCompatActivity {

    // تعريف المتغيرات للأزرار الستة
    private SwitchCompat switchListen, switchVocab, switchSpeak, switchGrammar, switchRead, switchAI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        // 1. ربط أزرار الـ Switch بالـ XML
        switchListen = findViewById(R.id.switchListen); // تأكد من إضافة هذه الـ IDs في ملف XML
        switchVocab = findViewById(R.id.switchVocab);
        switchSpeak = findViewById(R.id.switchSpeak);
        switchGrammar = findViewById(R.id.switchGrammar);
        switchRead = findViewById(R.id.switchRead);
        switchAI = findViewById(R.id.switchAI);

        // 2. ربط زر الحفظ والتنفيذ
        @SuppressLint("MissingInflatedId")
        Button btnSaveAndExecute = findViewById(R.id.btnSaveAndExecute);

        // 3. مراقبة تغيير حالة الأزرار (On/Off)
        setupSwitchListeners();

        // 4. برمجة زر التنفيذ النهائي
        btnSaveAndExecute.setOnClickListener(v -> {
            String finalPlan = "Plan Saved: ";
            if (switchListen.isChecked()) finalPlan += "Listening, ";
            if (switchSpeak.isChecked()) finalPlan += "Speaking, ";

            Toast.makeText(this, "Strategy Executed! 🚀", Toast.LENGTH_LONG).show();

            // هنا يمكنك الانتقال للواجهة التالية (الدرس الأول)
            // Intent intent = new Intent(this, LessonActivity.class);
            // startActivity(intent);
        });
    }

    private void setupSwitchListeners() {
        // مثال لمراقبة زر الاستماع
        switchListen.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Listening Session: ON", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Listening Session: OFF", Toast.LENGTH_SHORT).show();
            }
        });

        // يمكنك تكرار ذلك للبقية إذا أردت تفاعلاً فورياً
    }
}