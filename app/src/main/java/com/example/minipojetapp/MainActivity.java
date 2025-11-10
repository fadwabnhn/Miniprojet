package com.example.englishapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private Button signInButton;
    private Button signUpButton;
    private TextView forgotPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ربط العناصر من XML
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);
        signUpButton = findViewById(R.id.signUpButton);
        forgotPasswordText = findViewById(R.id.forgotPasswordText);

        // إعداد الأحداث
        setupClickListeners();
    }

    private void setupClickListeners() {
        // حدث زر Sign In
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignIn();
            }
        });

        // حدث زر Sign Up
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignUp();
            }
        });

        // حدث نسيت كلمة المرور
        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleForgotPassword();
            }
        });
    }

    private void handleSignIn() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // التحقق من الحقول
        if (email.isEmpty()) {
            emailEditText.setError("الرجاء إدخال البريد الإلكتروني");
            emailEditText.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordEditText.setError("الرجاء إدخال كلمة المرور");
            passwordEditText.requestFocus();
            return;
        }

        if (!isValidEmail(email)) {
            emailEditText.setError("البريد الإلكتروني غير صحيح");
            emailEditText.requestFocus();
            return;
        }

        if (password.length() < 6) {
            passwordEditText.setError("كلمة المرور يجب أن تكون 6 أحرف على الأقل");
            passwordEditText.requestFocus();
            return;
        }

        // هنا يمكنك إضافة كود تسجيل الدخول الفعلي
        Toast.makeText(this, "جاري تسجيل الدخول...", Toast.LENGTH_SHORT).show();

        // مثال: الانتقال إلى صفحة أخرى
        // Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        // startActivity(intent);
    }

    private void handleSignUp() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "الرجاء ملء جميع الحقول", Toast.LENGTH_SHORT).show();
            return;
        }

        // هنا يمكنك إضافة كود التسجيل الفعلي
        Toast.makeText(this, "جاري إنشاء حساب جديد...", Toast.LENGTH_SHORT).show();

        // مثال: الانتقال إلى صفحة التسجيل
        // Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        // startActivity(intent);
    }

    private void handleForgotPassword() {
        String email = emailEditText.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(this, "الرجاء إدخال البريد الإلكتروني أولاً", Toast.LENGTH_SHORT).show();
            emailEditText.requestFocus();
            return;
        }

        if (!isValidEmail(email)) {
            Toast.makeText(this, "البريد الإلكتروني غير صحيح", Toast.LENGTH_SHORT).show();
            return;
        }

        // هنا يمكنك إضافة كود استعادة كلمة المرور
        Toast.makeText(this, "تم إرسال رابط استعادة كلمة المرور", Toast.LENGTH_LONG).show();
    }

    // دالة للتحقق من صحة البريد الإلكتروني
    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}