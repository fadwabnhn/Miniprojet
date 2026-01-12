package com.example.minipojetapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ThirdActivity extends AppCompatActivity {
    private long userId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        userId = UserSession.userId;


        TextView tvWelcome = findViewById(R.id.tvWelcomeTitle);

        String name = getIntent().getStringExtra("USER_NAME");
        if (name != null && !name.isEmpty()) {
            tvWelcome.setText("Hi " + name + " 👋");
        }

        // CardView Your Goals
        CardView cardYourGoals = findViewById(R.id.cardYourGoals);

        cardYourGoals.setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, FifthActivity.class);
            intent.putExtra("USER_ID", userId);
            startActivity(intent);

        });

    }
}
