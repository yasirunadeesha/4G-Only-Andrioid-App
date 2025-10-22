package com.techy404.FORGonly;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onAboutClick(View view) {
        Intent intent = new Intent(this, about.class);
        startActivity(intent);
    }

    public void onInstructionClick(View view) {
        Intent intent = new Intent(this, instructions.class);
        startActivity(intent);
    }
    public void onSet4GOnlyClick(View view) {
        try {
            Intent intent = new Intent(Intent.ACTION_MAIN);

            // Check Android SDK version to determine the correct package and activity name
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { // Android 11 (R) or higher
                intent.setClassName("com.android.phone", "com.android.phone.settings.RadioInfo");
            } else { // Older Android versions
                intent.setClassName("com.android.settings", "com.android.settings.RadioInfo");
            }

            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
            boolean isIntentSafe = activities.size() > 0;

            if (isIntentSafe) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "Phone information settings are not accessible on this device.", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            // Handle cases where the activity cannot be found (e.g., incompatible device)
            Toast.makeText(this, "Your device is not compatible with this App, Inconvenience is regretted :(", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
