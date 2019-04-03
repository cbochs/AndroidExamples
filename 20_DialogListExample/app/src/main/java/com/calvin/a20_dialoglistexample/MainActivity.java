package com.calvin.a20_dialoglistexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnDialogList, btnDialogCheckbox, btnDialogRadio, btnDialogCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialogList = findViewById(R.id.btn_dialog_list);
        btnDialogCheckbox = findViewById(R.id.btn_dialog_checkbox);
        btnDialogRadio = findViewById(R.id.btn_dialog_radio);
        btnDialogCustom = findViewById(R.id.btn_dialog_custom);

        btnDialogList.setOnClickListener(this);
        btnDialogCheckbox.setOnClickListener(this);
        btnDialogRadio.setOnClickListener(this);
        btnDialogCustom.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dialog_list:
                new ListDialogFragment().show(getSupportFragmentManager(), "color_picker");
                break;
            case R.id.btn_dialog_checkbox:
                new CheckboxDialogFragment().show(getSupportFragmentManager(), "topping_chooser");
                break;
            case R.id.btn_dialog_radio:
                new RadioDialogFragment().show(getSupportFragmentManager(), "color_picker");
                break;
            case R.id.btn_dialog_custom:
                new CustomDialogFragment().show(getSupportFragmentManager(), "custom_thing");
                break;
        }
    }
}
