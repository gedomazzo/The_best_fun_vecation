package com.example.the_best_fun_vecation;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MyActivityName extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a TextView to display the credits
        TextView creditsText = new TextView(this);
        creditsText.setText("App created by: [Your Name Here]"); // <-- *** REPLACE WITH YOUR NAME ***
        creditsText.setGravity(Gravity.CENTER);
        creditsText.setTextSize(24);

        // Set the TextView as the content view for this activity
        setContentView(creditsText);
    }
}
