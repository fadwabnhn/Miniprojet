package com.example.minipojetapp;

import android.content.Intent; // إضافة المكتبة
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.slider.Slider;

public class PerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per);

        // ربط العناصر
        EditText etName = findViewById(R.id.etName);
        ChipGroup chipGroupLevel = findViewById(R.id.chipGroupLevel);
        ChipGroup chipGroupStyle = findViewById(R.id.chipGroupStyle);
        Slider sliderTime = findViewById(R.id.sliderTime);
        Button btnNext = findViewById(R.id.btnGoNext);

        btnNext.setOnClickListener(v -> {
            String name = etName.getText().toString();

            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
                return;
            }

            // الحصول على الخيارات المحددة
            int levelId = chipGroupLevel.getCheckedChipId();
            String level = (levelId != -1) ? ((Chip) findViewById(levelId)).getText().toString() : "None";

            int styleId = chipGroupStyle.getCheckedChipId();
            String style = (styleId != -1) ? ((Chip) findViewById(styleId)).getText().toString() : "None";

            float minutes = sliderTime.getValue();

            // --- الانتقال للواجهة الثالثة وتمرير البيانات ---
            Intent intent = new Intent(PerActivity.this, ThirdActivity.class);
            intent.putExtra("USER_NAME", name);
            intent.putExtra("USER_LEVEL", level);
            startActivity(intent);

            // اختياري: إنهاء الواجهة الحالية حتى لا يعود إليها المستخدم عند الضغط على زر الرجوع
            // finish();
        });
    }
}