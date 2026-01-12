package com.example.minipojetapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import okhttp3.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SixthActivity extends AppCompatActivity {

    private final List<SwitchCompat> switches = new ArrayList<>();
    private Long goalId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        // ===== استرجاع goalId =====
        goalId = getIntent().getLongExtra("GOAL_ID", -1);

        if (goalId == -1) {
            Toast.makeText(this, "Goal not found", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // ===== جمع كل SwitchCompat =====
        View root = findViewById(android.R.id.content);
        findAllSwitches(root);

        Button btnSaveAndExecute = findViewById(R.id.btnConfirmStrategy);

        btnSaveAndExecute.setOnClickListener(v -> saveStrategies());
    }

    // ================= SAVE =================

    private void saveStrategies() {

        String[] names = {
                "LISTENING",
                "VOCABULARY",
                "SPEAKING",
                "GRAMMAR",
                "READING",
                "AI_COACH"
        };

        List<String> selectedStrategies = new ArrayList<>();

        for (int i = 0; i < switches.size() && i < names.length; i++) {
            if (switches.get(i).isChecked()) {
                selectedStrategies.add(names[i]);
            }
        }

        if (selectedStrategies.isEmpty()) {
            Toast.makeText(this,
                    "Select at least one strategy",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        StrategyRequest request =
                new StrategyRequest(goalId, selectedStrategies);


        ApiService api = RetrofitClient.getRetrofitInstance()
                .create(ApiService.class);

        api.saveStrategies(request).enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call,
                                   Response<Void> response) {

                if (response.isSuccessful()) {

                    Toast.makeText(SixthActivity.this,
                            "Strategies saved",
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(
                            SixthActivity.this,
                            SeventhActivity.class
                    );
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(SixthActivity.this,
                            "Save failed",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(SixthActivity.this,
                        "Network error: " + t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
        // ================= HELPERS =================

    private void findAllSwitches(View view) {
        if (view instanceof SwitchCompat) {
            switches.add((SwitchCompat) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                findAllSwitches(group.getChildAt(i));
            }
        }
        }
    }
