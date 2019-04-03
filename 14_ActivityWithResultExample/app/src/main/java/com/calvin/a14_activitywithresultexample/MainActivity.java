package com.calvin.a14_activitywithresultexample;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int message_request = 01;

    private TextView tvMessage;
    private Button btnGetMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMessage = findViewById(R.id.tv_message);
        btnGetMessage = findViewById(R.id.btn_get_message);
        btnGetMessage.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == message_request && resultCode == RESULT_OK) {
            String message = data.getStringExtra("message");
            tvMessage.setText(message);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MessageActivity.class);
        startActivityForResult(intent, message_request);
    }
}
