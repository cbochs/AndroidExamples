package com.calvin.a14_activitywithresultexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        txtMessage = findViewById(R.id.txt_message);
        btnSend = findViewById(R.id.btn_send);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String message = txtMessage.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("message", message);

        setResult(RESULT_OK, intent);
        finish();
    }
}
