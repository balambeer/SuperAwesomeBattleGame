package com.example.superawesomebattlegame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean mapSettings = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Here we get back the settings
        // the user made on the the Settings screen

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        mapSettings = sp.getBoolean("map_size", false);

        //TODO: You can place values in intents with keys. Pass the
        // boolean value over to the BattleActivity, and use it there
        // to load the appropriate map layout.

        Button startButton = (Button) findViewById(R.id.start_game);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BattleActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Adds a predefined menu layout to the options menu on the
     * top of the screen
     *
     * @param menu is the stock menu on top of the screen
     * @return true if layout was inflated and attached
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Method determines the action taken based in
     * which menu item the user selects
     *
     * @param item represents the menu button the user taps
     * @return true if action was performed, otherwise return super method
     * and nothing happens
     */

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.main_settings_menu){
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
