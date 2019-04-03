package com.calvin.a12_intentexampleappa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSharePost;
    private Button btnSendMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSharePost = findViewById(R.id.btn_share_post);
        btnSendMail = findViewById(R.id.btn_send_mail);

        btnSharePost.setOnClickListener(this);
        btnSendMail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_share_post:
                Intent explicitIntent = new Intent(this, SharePostActivity.class);
                startActivity(explicitIntent);
                break;
            case R.id.btn_send_mail:
                Intent implicitIntent = new Intent();
                implicitIntent.setAction(Intent.ACTION_SEND);
                implicitIntent.setType("text/plain");
                implicitIntent.putExtra("message", "This is a simple message");
                startActivity(implicitIntent);
                break;
        }
    }
}
