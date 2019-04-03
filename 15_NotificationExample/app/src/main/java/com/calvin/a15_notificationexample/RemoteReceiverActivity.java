package com.calvin.a15_notificationexample;

import android.app.NotificationManager;
import android.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RemoteReceiverActivity extends AppCompatActivity {

    private TextView tvDisplayMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_receiver);

        tvDisplayMessage = findViewById(R.id.tv_display_message);

        Bundle remoteeReply = RemoteInput.getResultsFromIntent(getIntent());

        if (remoteeReply != null) {
            String message = remoteeReply.getCharSequence(MainActivity.TXT_REPLY).toString();
            tvDisplayMessage.setText(message);
        }

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(MainActivity.NOTIFICATION_ID);
    }
}
