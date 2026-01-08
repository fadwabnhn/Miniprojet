package com.example.minipojetapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ربط ملف الجافا بالتصميم الذي أنشأناه
        setContentView(R.layout.activity_fourth);

        // 1. استقبال البيانات القادمة من الواجهة السابقة
        // استلمنا الاسم (USER_NAME) لكي نعرضه في فقاعة النمو
        String userName = getIntent().getStringExtra("USER_NAME");

        // 2. ربط العناصر البرمجية بالعناصر الموجودة في الـ XML
        TextView tvUserProgressMsg = findViewById(R.id.tvUserProgressMsg);
        Button btnStartMission = findViewById(R.id.btnStartMission);

        // 3. تحديث نص الترحيب باسم المستخدم الحقيقي
        if (userName != null && !userName.isEmpty()) {
            // سنقوم بتغيير النص الافتراضي ليحتوي على اسم المستخدم مع الرموز التعبيرية
            tvUserProgressMsg.setText("Amazing progress, " + userName + "! Keep going ✨");
        } else {
            // في حال لم يصل الاسم، نضع نصاً افتراضياً
            tvUserProgressMsg.setText("Amazing progress, Hero! Keep going ✨");
        }

        // 4. برمجة زر "Start Today's Mission" (ابدأ مهمة اليوم)
        btnStartMission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // هنا يمكنك وضع الكود للانتقال للواجهة الخامسة أو بدء درس
                Toast.makeText(FourthActivity.this, "Mission Started! 🚀", Toast.LENGTH_SHORT).show();

                /* إذا كان لديك واجهة خامسة، فكي هذا التعليق:
                Intent intent = new Intent(FourthActivity.this, FifthActivity.class);
                startActivity(intent);
                */
            }
        });

        // 5. برمجة أيقونة الإعدادات (الموجودة في أعلى يمين الشاشة)
        // بما أننا لم نعطها ID في الـ XML السابق، تأكدي من إضافة android:id="@+id/imgSettings" للـ ImageView
        View imgSettings = findViewById(android.R.id.home); // مثال عام
        // يمكنك إضافة حدث ضغط هنا إذا أردتِ
    }
}