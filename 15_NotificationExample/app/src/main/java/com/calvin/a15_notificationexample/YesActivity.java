package com.calvin.a15_notificationexample;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class YesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(MainActivity.NOTIFICATION_ID);
    }
}
