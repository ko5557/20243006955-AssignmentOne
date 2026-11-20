package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Topic buttons, in the same order as the arrays in res/values/arrays.xml.
    private static final int[] TOPIC_BUTTON_IDS = {
            R.id.buttonFacilities, R.id.buttonEvents, R.id.buttonClubs, R.id.buttonSupport
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpTopicButtons();
    }

    /**
     * Attaches a click listener to each of the four topic image buttons.
     */
    private void setUpTopicButtons() {
        for (int topic = 0; topic < TOPIC_BUTTON_IDS.length; topic++) {
            openTopicOnClick(TOPIC_BUTTON_IDS[topic], topic);
        }
    }

    /**
     * Opens the detail screen, passing the topic index as the unique identifier.
     */
    private void openTopicOnClick(int buttonId, int topic) {
        ImageButton button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_TOPIC, topic);
            startActivity(intent);
        });
    }
}
