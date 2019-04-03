package com.calvin.a20_dialoglistexample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CheckboxDialogFragment extends DialogFragment {

    private List<String> mSelectedToppings;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final String[] toppings = getActivity().getResources().getStringArray(R.array.toppings);
        mSelectedToppings = new ArrayList<>();

        Dialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Pick Your Toppings")
                .setMultiChoiceItems(R.array.toppings, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        String topping = toppings[which];
                        if (isChecked) {
                            mSelectedToppings.add(topping);
                        } else if (mSelectedToppings.contains(topping)) {
                            mSelectedToppings.remove(topping);
                        }
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String final_selection = "";

                        for (String topping : mSelectedToppings) {
                            final_selection = final_selection + "\n" + topping;
                        }

                        Toast.makeText(getActivity(), "Selected Items: " + final_selection, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Dialog Canceled.", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();

        return dialog;
    }
}
