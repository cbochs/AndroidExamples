package com.calvin.a21_optionsmenuexample;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionsMenuActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cast:
                displayMessage("Cast options selected...");
                return true;
            case R.id.action_search:
                displayMessage("Search options selected...");
                return true;
            case R.id.action_settings:
                displayMessage("Settings options selected...");
                return true;
            default:
                return false;
        }
    }

    protected void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
