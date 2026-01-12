package com.example.minipojetapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.slider.Slider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FifthActivity extends AppCompatActivity {

    private String selectedSkill = null;
    private String selectedSuggestedGoal = null;
    private int selectedTime = 0;
    private Long userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        // ===== userId =====
        userId = UserSession.userId;



        // ===== Skills =====
        CardView cardListen = findViewById(R.id.cardListen);
        CardView cardSpeak = findViewById(R.id.cardSpeak);
        CardView cardWrite = findViewById(R.id.cardWrite);
        CardView cardRead = findViewById(R.id.cardRead);

        // ===== Suggested goals =====
        CardView suggested1 = (CardView)
                ((android.widget.LinearLayout) findViewById(R.id.suggestedLayout)).getChildAt(0);
        CardView suggested2 = (CardView)
                ((android.widget.LinearLayout) findViewById(R.id.suggestedLayout)).getChildAt(1);


        Slider sliderTime = findViewById(R.id.sliderTime);
        TextView tvTimeValue = findViewById(R.id.tvTimeValue);
// ⬅️ الحل هنا
        selectedTime = (int) sliderTime.getValue();
        tvTimeValue.setText(selectedTime + " min");

// تعيين القيمة الافتراضية
        selectedTime = (int) sliderTime.getValue();
        tvTimeValue.setText(selectedTime + " min");

        sliderTime.addOnChangeListener((slider, value, fromUser) -> {
            selectedTime = (int) value;
            tvTimeValue.setText(selectedTime + " min");
        });



        // Skills
        cardListen.setOnClickListener(v ->
                selectSkill("LISTENING", cardListen, cardSpeak, cardWrite, cardRead));
        cardSpeak.setOnClickListener(v ->
                selectSkill("SPEAKING", cardSpeak, cardListen, cardWrite, cardRead));
        cardWrite.setOnClickListener(v ->
                selectSkill("WRITING", cardWrite, cardListen, cardSpeak, cardRead));
        cardRead.setOnClickListener(v ->
                selectSkill("READING", cardRead, cardListen, cardSpeak, cardWrite));

        // Suggested goals
        suggested1.setOnClickListener(v -> {
            selectedSuggestedGoal = "REVIEW_FLASHCARDS";
            highlight(suggested1);
            resetHighlight(suggested2);
        });

        suggested2.setOnClickListener(v -> {
            selectedSuggestedGoal = "WRITE_SENTENCES";
            highlight(suggested2);
            resetHighlight(suggested1);
        });
        Button btnStrategy = findViewById(R.id.btnStrategy);

        // My Strategy
        btnStrategy.setOnClickListener(v -> {


            if (userId == null ||
                    userId <= 0 ||
                    selectedSkill == null ||
                    selectedSuggestedGoal == null ||
                    selectedTime <= 0) {

                Toast.makeText(this,
                        "Please complete all selections",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            GoalRequest request = new GoalRequest(
                    userId,
                    selectedSkill,
                    selectedSuggestedGoal,
                    selectedTime
            );

            ApiService api = RetrofitClient.getRetrofitInstance()
                    .create(ApiService.class);


            api.saveGoal(request).enqueue(new Callback<GoalResponse>() {

                @Override
                public void onResponse(Call<GoalResponse> call,
                                       Response<GoalResponse> response) {

                    if (response.isSuccessful()) {

                        Long goalId = response.body().getGoalId();



                        Intent intent = new Intent(
                                FifthActivity.this,
                                SixthActivity.class
                        );

                        intent.putExtra("GOAL_ID", goalId);
                        Toast.makeText(FifthActivity.this,
                                "Saved",
                                Toast.LENGTH_SHORT).show();

                        startActivity(intent);

                    } else {
                        Toast.makeText(FifthActivity.this,
                                "Save failed",
                                Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<GoalResponse> call, Throwable t) {
                    Toast.makeText(FifthActivity.this,
                            "Network error: " + t.getMessage(),
                            Toast.LENGTH_LONG).show();
                }

            });

        });
    }

    // ===== Helpers =====
    private void selectSkill(String skill,
                             CardView selected,
                             CardView... others) {
        selectedSkill = skill;
        highlight(selected);
        for (CardView c : others) resetHighlight(c);
    }

    private void highlight(CardView card) {
        card.setAlpha(1f);
        card.setScaleX(1.05f);
        card.setScaleY(1.05f);
    }

    private void resetHighlight(CardView card) {
        card.setAlpha(0.6f);
        card.setScaleX(1f);
        card.setScaleY(1f);
    }
}
