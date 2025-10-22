package com.techy404.FORGonly;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Back button functionality
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        // Facebook button
        LinearLayout facebookBtn = findViewById(R.id.facebook_button);
        facebookBtn.setOnClickListener(v -> openUrl("https://www.facebook.com/profile.php?id=61550000733902"));

        // LinkedIn button
        LinearLayout linkedinBtn = findViewById(R.id.linkedin_button);
        linkedinBtn.setOnClickListener(v -> openUrl("https://www.linkedin.com/in/yasirunadeesha/"));

        // GitHub button
        LinearLayout githubBtn = findViewById(R.id.github_button);
        githubBtn.setOnClickListener(v -> openUrl("https://github.com/yasirunadeesha"));

        // Instagram button
        LinearLayout instagramBtn = findViewById(R.id.instagram_button);
        instagramBtn.setOnClickListener(v -> openUrl("https://www.instagram.com/yasirunadeesha8/"));
    }

    // Helper method to open URLs in browser
    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
