package com.calvin.a21_dialogactivitycommunicationexample;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

public class MyDialogFragment extends DialogFragment {

    private List<String> selection;

    private ToppingSelectionListener selectionListener;
    public interface ToppingSelectionListener {
        void onToppingSelected(List<String> toppings);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final String[] toppings = getActivity().getResources().getStringArray(R.array.toppings);
        selection = new ArrayList<>();

        Dialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Pick your toppings")
                .setMultiChoiceItems(toppings, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        String topping = toppings[which];
                        if (isChecked && !selection.contains(topping)) {
                            selection.add(topping);
                        } else if (!isChecked && selection.contains(topping)) {
                            selection.remove(topping);
                        }
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        selectionListener.onToppingSelected(selection);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .create();

        return dialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        try {
            selectionListener = (ToppingSelectionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement ToppingSelectionListener methods");
        }
    }
}
