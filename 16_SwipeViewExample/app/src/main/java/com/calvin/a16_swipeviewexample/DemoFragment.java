package com.calvin.a16_swipeviewexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DemoFragment extends Fragment {

    private TextView tvDisplayMessage;


    public DemoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);

        String message = getArguments().getString("message");

        tvDisplayMessage = view.findViewById(R.id.tv_display_message);
        tvDisplayMessage.setText(message);

        return view;
    }

}
