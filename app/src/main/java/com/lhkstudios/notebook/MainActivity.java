package com.lhkstudios.notebook;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
// Initialize main activity with note list and navigation
import android.view.MenuItem;
// Initialize the main activity with default note list view
// Main activity for notebook application - handles note list display and navigation

public class MainActivity extends AppCompatActivity {

    public static final String NOTE_ID_EXTRA = "com.lhkstudios.notebook.Identifier";
    public static final String NOTE_TITLE_EXTRA = "com.lhkstudios.notebook.Title";
    public static final String NOTE_MESSAGE_EXTRA = "com.lhkstudios.notebook.Message";
    public static final String NOTE_CATEGORY_EXTRA = "com.lhkstudios.notebook.Category";
    public static final String NOTE_FRAGMENT_TO_LOAD_EXTRA = "com.lhkstudios.notebook.Fragment_To_Load";
    public enum FragmentToLaunch{ VIEW, EDIT}
// Initialize main activity with note list view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Initialize the main activity and set up the fragment container
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
// Load list fragment on first activity creation

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
