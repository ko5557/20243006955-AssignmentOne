package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_TOPIC = "com.example.assignmentone.extra.TOPIC";

    // Display names for the four topics, matching the order of arrays.xml.
    private static final int[] TOPIC_NAME_IDS = {
            R.string.label_facilities, R.string.label_events,
            R.string.label_clubs, R.string.label_support
    };

    private static final String DRAWABLE_TYPE = "drawable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        showTopic(getIntent().getIntExtra(EXTRA_TOPIC, 0));
    }

    /**
     * Fills the header and the scrolling body from the arrays in arrays.xml.
     */
    private void showTopic(int topic) {
        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        String[] contents = getResources().getStringArray(R.array.string_array_content);
        String[] images = getResources().getStringArray(R.array.string_array_images);

        ImageView image = findViewById(R.id.imageTopic);
        image.setImageResource(drawableId(images[topic].trim()));

        TextView name = findViewById(R.id.textTopicName);
        name.setText(TOPIC_NAME_IDS[topic]);

        TextView title = findViewById(R.id.textTopicTitle);
        title.setText(titles[topic].trim());

        TextView content = findViewById(R.id.textTopicContent);
        content.setText(contents[topic]);
    }

    /**
     * Resolves a drawable name from arrays.xml to a resource id.
     */
    private int drawableId(String name) {
        return getResources().getIdentifier(name, DRAWABLE_TYPE, getPackageName());
    }
}
