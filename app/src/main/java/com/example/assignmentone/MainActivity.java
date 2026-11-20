package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int[] TOPIC_BUTTON_IDS = {
            R.id.buttonFacilities, R.id.buttonEvents, R.id.buttonClubs, R.id.buttonSupport
    };

    private static final int[] TOPIC_LABEL_IDS = {
            R.string.label_facilities, R.string.label_events,
            R.string.label_clubs, R.string.label_support
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

    private void setUpTopicButtons() {
        for (int topic = 0; topic < TOPIC_BUTTON_IDS.length; topic++) {
            showClickedMessage(TOPIC_BUTTON_IDS[topic], TOPIC_LABEL_IDS[topic]);
        }
    }

    private void showClickedMessage(int buttonId, int labelId) {
        ImageButton button = findViewById(buttonId);
        button.setOnClickListener(v -> Toast.makeText(this,
                getString(labelId) + " clicked", Toast.LENGTH_SHORT).show());
    }
}
