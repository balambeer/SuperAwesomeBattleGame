package com.example.superawesomebattlegame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.prefs.PreferenceChangeEvent;

public class SettingsActivity extends AppCompatActivity {

    /**
     * This activity's function only function is to house
     * one single fragment that takes up the size of the whole screen.
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }


    public static class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

        private static final String TAG = "SettingsFragment";

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);

            Preference mapSize = findPreference("map_size");
            mapSize.setOnPreferenceChangeListener(this);
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mapSize.getContext());
            boolean preferenceBoolean = sharedPreferences.getBoolean(mapSize.getKey(),false);
            onPreferenceChange(mapSize, preferenceBoolean);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {

            if (newValue.toString().equals("true")){
                preference.setSummary("Large map");
            } else {
                preference.setSummary("Regular map");
            }
            return true;
        }
        }
}

