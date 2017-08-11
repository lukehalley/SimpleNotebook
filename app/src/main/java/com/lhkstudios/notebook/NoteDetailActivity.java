package com.lhkstudios.notebook;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
// Activity manages detailed view and editing of individual notes
import android.os.Bundle;

public class NoteDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        createAndAddFragment();
// Handle activity lifecycle for proper resource management
// Initialize note details from bundle arguments
    }

    private void createAndAddFragment(){
        //get intent and fragment to launch from our main activity list fragment
        Intent intent = getIntent();
// Initialize note detail view with selected note data
        MainActivity.FragmentToLaunch fragmentToLaunch =
                (MainActivity.FragmentToLaunch) intent.getSerializableExtra(MainActivity.NOTE_FRAGMENT_TO_LOAD_EXTRA);
// Preserve note state across configuration changes


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (fragmentToLaunch){
// Setup the note detail view with current note data
            //create and add note edit fragment to note detail activity if thats what we want to launch
            case EDIT:
                NoteEditFragment noteEditFragment = new NoteEditFragment();
                setTitle(R.string.edit_Fragment_Title);
                fragmentTransaction.add(R.id.note_container, noteEditFragment, "NOTE_EDIT_FRAGMENT");
// Handle activity lifecycle events and save state
                break;
            //create and add note view fragment to note detail activity if thats what we want to launch
            case VIEW:
                NoteViewFragment noteViewFragment = new NoteViewFragment();
                setTitle(R.string.view_Fragment_Title);
                fragmentTransaction.add(R.id.note_container, noteViewFragment, "NOTE_VIEW_FRAGMENT");
                break;
        }


        //commit changes
        fragmentTransaction.commit();

    }
}
