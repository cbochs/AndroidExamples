package com.calvin.a20_dialoglistexample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class ListDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final String[] colors = getActivity().getResources().getStringArray(R.array.colors);

        Dialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Pick A Color")
                .setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Selected Color: " + colors[i], Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        return dialog;
    }
}
