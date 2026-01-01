package com.example.minipojetapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final android.R.attr R = R;
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private Button signInButton;
    private Button signUpButton;
    private TextView forgotPasswordText;

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Bind views from XML
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = signInButton.findViewById();
        signUpButton = findViewById(R.id.signUpButton);
        forgotPasswordText = signInButton.findViewById();

        // Set click listeners
        setupClickListeners();
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    private void setupClickListeners() {
        signInButton.setOnClickListener(v -> handleSignIn());
        signUpButton.setOnClickListener(v -> handleSignUp());
        forgotPasswordText.setOnClickListener(v -> handleForgotPassword());
    }

    // ---------------- Sign In ----------------
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    private void handleSignIn() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty()) {
            emailEditText.setError("Please enter your email");
            emailEditText.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordEditText.setError("Please enter your password");
            passwordEditText.requestFocus();
            return;
        }

        if (!isValidEmail(email)) {
            emailEditText.setError("Invalid email address");
            emailEditText.requestFocus();
            return;
        }

        if (password.length() < 6) {
            passwordEditText.setError("Password must be at least 6 characters");
            passwordEditText.requestFocus();
            return;
        }

        User user = new User(email, password);
        ApiService api = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Call<User> call = api.login(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(MainActivity.this, perActivity.class);
                    startActivity(intent);
                    finish(); // إغلاق MainActivity
                } else {
                    Toast.makeText(MainActivity.this, "Login failed! Check your credentials.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // ---------------- Sign Up ----------------
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    private void handleSignUp() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isValidEmail(email)) {
            emailEditText.setError("Invalid email address");
            emailEditText.requestFocus();
            return;
        }

        if (password.length() < 6) {
            passwordEditText.setError("Password must be at least 6 characters");
            passwordEditText.requestFocus();
            return;
        }

        User user = new User(email, password);
        ApiService api = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Call<User> call = api.signup(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Signup successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Signup failed! Try again.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // ---------------- Forgot Password ----------------
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    private void handleForgotPassword() {
        String email = emailEditText.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter your email first", Toast.LENGTH_SHORT).show();
            emailEditText.requestFocus();
            return;
        }

        if (!isValidEmail(email)) {
            Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show();
            return;
        }


        Toast.makeText(this, "Password recovery link has been sent", Toast.LENGTH_LONG).show();
    }

    // ---------------- Validate Email ----------------
    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
