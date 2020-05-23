package com.example.superawesomebattlegame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View startButton) {
        Intent szar = new Intent(this, BattleActivity.class);
        startActivity(szar);
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
