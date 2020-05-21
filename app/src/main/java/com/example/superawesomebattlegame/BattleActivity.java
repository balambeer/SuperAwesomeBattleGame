package com.example.superawesomebattlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        TableLayout map = (TableLayout) findViewById( R.id.batlleMap );

        for(int row = 1; row <= numRows; row++) {
            TableRow newRow = new TableRow(this );
            for(int col = 1; col <= numCols; col++) {
                Button cell = new Button(this );
                setupCell(cell, row, col);
                newRow.addView(cell);
            }
            map.addView(newRow);
        }
    }

    private void setupCell (Button cell, int row, int col) {
        cell.setWidth((int) getResources().getDimension(R.dimen.button_size));
        cell.setHeight((int) getResources().getDimension(R.dimen.button_size));
        cell.setText(Integer.toString(row)+Integer.toString(col));
        cell.setId(10*row+col);
        cell.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View button) {
                doStuff(button.getId());
            }
        });
    }

    private void doStuff (int buttonID) {
        TextView response = (TextView) findViewById(R.id.buttonResponse);
        response.setText(Integer.toString(buttonID));
    }
}
