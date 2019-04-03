package com.calvin.a19_snackbarexample;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayPopup(View view) {
        Snackbar.make(findViewById(R.id.root_layout), R.string.offline_message, Snackbar.LENGTH_LONG)
                .setAction(R.string.undo_string, this)
                .show();

        new FireMissileFragment().show(getSupportFragmentManager(), "missile_dialog");

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Undo Operation Selected", Toast.LENGTH_SHORT).show();
    }
}
