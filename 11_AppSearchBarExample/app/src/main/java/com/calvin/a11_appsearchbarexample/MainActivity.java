package com.calvin.a11_appsearchbarexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;
    private List<String> names = new ArrayList<>();

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        names = Arrays.asList(getResources().getStringArray(R.array.country_names));

        recyclerAdapter = new RecyclerAdapter(names);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerView.setHasFixedSize(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                Toast.makeText(MainActivity.this, "Action View Expanded...", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                Toast.makeText(MainActivity.this, "Action View Collapsed...", Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(this);

        searchItem.setOnActionExpandListener(onActionExpandListener);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        String userInput = s.toLowerCase();
        List<String> newList = new ArrayList<>();

        for (String n : names) {
            if (n.toLowerCase().contains(userInput)) newList.add(n);
        }

        Log.d("Filter Example", names.toString());
        Log.d("Filter Example", newList.toString());
        Log.d("Filter Example", userInput);
        recyclerAdapter.updateList(newList);

        return true;
    }
}
