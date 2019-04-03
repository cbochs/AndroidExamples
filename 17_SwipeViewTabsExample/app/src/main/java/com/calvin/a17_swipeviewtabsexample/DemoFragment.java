package com.calvin.a17_swipeviewtabsexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DemoFragment extends Fragment {

    private TextView tvDisplayMessage;

    public DemoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);

        tvDisplayMessage = view.findViewById(R.id.tv_display_message);

        String message = getArguments().getString("message");
        tvDisplayMessage.setText(message);

        return view;
    }

}
