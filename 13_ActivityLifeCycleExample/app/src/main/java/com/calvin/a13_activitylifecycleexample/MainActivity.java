package com.calvin.a13_activitylifecycleexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartActivity;
    private Button btnFinishActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartActivity = findViewById(R.id.btn_start_activity);
        btnFinishActivity = findViewById(R.id.btn_finish_activity);

        btnStartActivity.setOnClickListener(this);
        btnFinishActivity.setOnClickListener(this);

        showLog("onCreate Finished...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showLog("onStart Finished...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLog("onResume Finished...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showLog("onPause Finished...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLog("onStop Finished...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showLog("onRestart Finished...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLog("onDestroy Finished...");
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_start_activity:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.btn_finish_activity:
                finish();
                break;
        }
    }

    private void showLog(String message) {
        Log.d("Lifecycle Test", message);
    }
}
