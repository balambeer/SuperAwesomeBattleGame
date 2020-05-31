package com.example.superawesomebattlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BattleActivity extends AppCompatActivity {

    int numRows = 5;
    int numCols = 6;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        ArrayList<String> mapCells = new ArrayList<String>();
        for(int row = 1; row <= numRows; row++) {
            for(int col = 1; col <= numCols; col++) {
                mapCells.add(""+row+col);
            }
        }

        ArrayAdapter<String> mapAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mapCells);

        GridView map = (GridView) findViewById(R.id.battleMap);
        map.setNumColumns(numCols);
        map.setAdapter(mapAdapter);
    }
}
