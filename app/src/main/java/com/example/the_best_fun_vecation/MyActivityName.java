package com.example.the_best_fun_vecation;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Displays the credits screen for the application.
 * @author benjamin rogachevsky
 * @version 1.0
 * @since 1/7/26
 */
public class MyActivityName extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     * <p>
     * This method initializes the activity, creates a TextView to display the credits,
     * and sets it as the content view.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
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
