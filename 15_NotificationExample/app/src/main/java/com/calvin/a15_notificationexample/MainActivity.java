package com.calvin.a15_notificationexample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "personal_notifications";
    public static final int NOTIFICATION_ID = 001;
    public static final String TXT_REPLY = "text_reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayNotification(View view) {
        createNotificationChannel();

        // Tap on the notification itself
        Intent landingIntent = new Intent(this, LandingActivity.class);
        landingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent landingPendingIntent = PendingIntent.getActivity(this, 0, landingIntent, PendingIntent.FLAG_ONE_SHOT);

        // Tap on action button under notification
        Intent yesIntent = new Intent(this, YesActivity.class);
        yesIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent yesPendingIntent = PendingIntent.getActivity(this, 0, yesIntent, PendingIntent.FLAG_ONE_SHOT);

        // Tap on action button under notification
        Intent noIntent = new Intent(this, NoActivity.class);
        noIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent noPendingIntent = PendingIntent.getActivity(this, 0, noIntent, PendingIntent.FLAG_ONE_SHOT);

        // Build the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_sms_notification);
        builder.setContentTitle("Simple Notification");
        builder.setContentText("This is a simple notification...");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setAutoCancel(true);
        builder.setContentIntent(landingPendingIntent);
        builder.addAction(R.drawable.ic_sms_notification, "Yes", yesPendingIntent);
        builder.addAction(R.drawable.ic_sms_notification, "No", noPendingIntent);

        // Direct reply action
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            RemoteInput remoteInput = new RemoteInput.Builder(TXT_REPLY).setLabel("Reply").build();

            Intent replyIntent = new Intent(this, RemoteReceiverActivity.class);
            replyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

            PendingIntent replyPendingIntent = PendingIntent.getActivity(this, 0, replyIntent, PendingIntent.FLAG_ONE_SHOT);

            NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_sms_notification, "Reply", replyPendingIntent)
                    .addRemoteInput(remoteInput)
                    .build();

            builder.addAction(action);
        }

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
    }

    public void downloadNotification(View view) {
        createNotificationChannel();

        // Build the notification
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_download);
        builder.setContentTitle("Image Download");
        builder.setContentText("Download in progress");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setSound(null);

        // Setup progress bar
        final int max_progress  = 100;
        int current_progress = 0;

        builder.setProgress(max_progress, current_progress, false);
        // builder.setProgress(0, 0, true); // indeterminant progress bar

        final NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

        Thread thread = new Thread() {
            @Override
            public void run() {
                int count = 0;
                try {
                    while (count <= max_progress) {
                        count += 10;
                        sleep(1000);
                        builder.setProgress(max_progress, count, false);
                        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
                    }
                    builder.setContentText("Download finished");
                    builder.setProgress(0, 0, false); // remove progress bar
                    notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
                } catch (InterruptedException e) {}

            }
        };

        thread.start();
    }

    public void expandNotification(View view) {
        createNotificationChannel();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.project);
        String message = getString(R.string.notification_text);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_sms_notification)
                .setContentTitle("Expand me!")
                .setContentText(message.substring(0, 40) + "...")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setLargeIcon(bitmap)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                //.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null))
                .build();


        NotificationManagerCompat.from(this).notify(NOTIFICATION_ID, notification);
    }

    public void customNotification(View view) {
        createNotificationChannel();

        RemoteViews normal_layout = new RemoteViews(getPackageName(), R.layout.custom_normal);
        RemoteViews expanded_layout = new RemoteViews(getPackageName(), R.layout.custom_expanded);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_sms_notification)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(normal_layout)
                .setCustomBigContentView(expanded_layout)
                .build();

        NotificationManagerCompat.from(this).notify(NOTIFICATION_ID, notification);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Personal Notifications";
            String description = "Include all the personal notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }



}
