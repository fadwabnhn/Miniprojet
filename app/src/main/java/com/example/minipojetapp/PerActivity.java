package com.example.minipojetapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.slider.Slider;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per);

        // ربط عناصر الواجهة
        EditText etName = findViewById(R.id.etName);
        ChipGroup chipGroupLevel = findViewById(R.id.chipGroupLevel);
        ChipGroup chipGroupStyle = findViewById(R.id.chipGroupStyle);
        Slider sliderTime = findViewById(R.id.sliderTime);
        Button btnNext = findViewById(R.id.btnGoNext);

        // استلام userId من MainActivity
        int userId = getIntent().getIntExtra("USER_ID", -1);
        if (userId == -1) {
            Toast.makeText(this, "User ID not found", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        btnNext.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
                return;
            }

            // Level
            int levelId = chipGroupLevel.getCheckedChipId();
            String level = (levelId != -1)
                    ? ((Chip) findViewById(levelId)).getText().toString()
                    : "None";

            // Preference / Style
            int styleId = chipGroupStyle.getCheckedChipId();
            String style = (styleId != -1)
                    ? ((Chip) findViewById(styleId)).getText().toString()
                    : "None";

            int timeSelected = (int) sliderTime.getValue();


            ProfileRequest request = new ProfileRequest();
            request.setUserId((long) userId);

            request.setName(name);
            request.setLevel(level);
            request.setPreference(style);
            request.setTimeSelected(timeSelected);


            ApiService apiService =
                    RetrofitClient.getRetrofitInstance().create(ApiService.class);


            apiService.saveProfile(request).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call,
                                       Response<Void> response) {

                    if (response.isSuccessful()) {
                        Toast.makeText(PerActivity.this,
                                "Profile saved successfully",
                                Toast.LENGTH_SHORT).show();
                        UserSession.userId = userId;

                        Intent intent =
                                new Intent(PerActivity.this, ThirdActivity.class);
                        intent.putExtra("USER_ID", userId);
                        intent.putExtra("USER_NAME", name);
                        intent.putExtra("USER_LEVEL", level);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(PerActivity.this,
                                "Error saving profile: " + response.code(),
                                Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t)
                {Toast.makeText(PerActivity.this, "Failed: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}
