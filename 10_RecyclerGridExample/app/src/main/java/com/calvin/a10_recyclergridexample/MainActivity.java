package com.calvin.a10_recyclergridexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;

    private int[] images = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5};
//            R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10, R.drawable.pic11,
//            R.drawable.pic12, R.drawable.pic13, R.drawable.pic14, R.drawable.pic15, R.drawable.pic16, R.drawable.pic17,
//            R.drawable.pic18, R.drawable.pic19, R.drawable.pic20, R.drawable.pic21, R.drawable.pic22, R.drawable.pic23,
//            R.drawable.pic24, R.drawable.pic25, R.drawable.pic26, R.drawable.pic28, R.drawable.pic29, R.drawable.pic30};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerAdapter = new RecyclerAdapter(images, this);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerView.setHasFixedSize(true);
    }
}
