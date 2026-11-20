package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        for (int topic = 0; topic < Topics.COUNT; topic++) {
            openTopicOnClick(Topics.BUTTON_IDS[topic], topic);
        }
    }

    /**
     * Shows the click confirmation and opens the detail screen, passing the topic index
     * as the unique identifier.
     */
    private void openTopicOnClick(int buttonId, int topic) {
        ImageButton button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Toast.makeText(this, getString(Topics.LABEL_IDS[topic]) + " clicked",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_TOPIC, topic);
            startActivity(intent);
        });
    }
}
