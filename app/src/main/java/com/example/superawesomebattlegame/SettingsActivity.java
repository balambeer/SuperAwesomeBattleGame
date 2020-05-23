package com.example.superawesomebattlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    //TODO: Create an inner subclass of PreferenceFragment that implements
    // Preference.OnPreferenceChangeListener. That solution is out of date,
    // so first check for an easier one
}
