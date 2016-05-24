package com.example.l.gaadivaada;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityLongRoute extends AppCompatActivity {
    private  DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_long_route);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //EditText initial_position = (EditText) findViewById(R.id.initial_position);
        // Get a reference to the AutoCompleteTextView in the layout
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.initial_position);
// Get the string array
        String[] countries = getResources().getStringArray(R.array.countries_array);
// Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        textView.setAdapter(adapter);
        //initial_position.set
        mydb  = new DBHelper(getApplicationContext());
        Cursor rs = mydb.getData();
        rs.moveToFirst();
        String dbrad = rs.getString(rs.getColumnIndex(DBHelper.STARTING_PLACE));
        TextView mytextview = (TextView) findViewById(R.id.distancetext);
        mytextview.setText(dbrad);
    }

}
