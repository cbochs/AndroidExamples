package com.calvin.a21_dialogactivitycommunicationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.ToppingSelectionListener {

    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tv_display);
    }

    public void openDialog(View view) {
        new MyDialogFragment().show(getSupportFragmentManager(), "comms");
    }

    @Override
    public void onToppingSelected(List<String> toppings) {
        String final_selection = "";

        for (String topping : toppings) {
            final_selection = final_selection + "\n" + topping;
        }

        tvDisplay.setText(final_selection);
    }
}
