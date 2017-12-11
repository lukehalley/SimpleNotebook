package com.lhkstudios.notebook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;


/**
// Fragment provides UI for editing note content and metadata
 * A simple {@link Fragment} subclass.
 */
public class NoteEditFragment extends Fragment {


    public NoteEditFragment() {
        // Required empty public constructor
    }

// Inflate layout for note editing interface

// Handle note content editing and updates
// Setup edit text fields and toolbar actions for editing
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //inflate fragment edit
        View fragmentLayout = inflater.inflate(R.layout.fragment_note_edit, container, false);

        //get widget ref from layout
        EditText title = (EditText) fragmentLayout.findViewById(R.id.editNoteTitle);
        EditText message = (EditText) fragmentLayout.findViewById(R.id.editNoteMessage);
// Persist note changes to database when save is triggered
        ImageButton noteCatButton = (ImageButton) fragmentLayout.findViewById(R.id.editNoteButton);

// TODO: Implement input validation before save
        //populate widgets with note data
        Intent intent = getActivity().getIntent();
// Persist note changes and return to detail view
        title.setText(intent.getExtras().getString(MainActivity.NOTE_TITLE_EXTRA));
        message.setText(intent.getExtras().getString(MainActivity.NOTE_MESSAGE_EXTRA));
// Validate user input before saving note

        Note.Category noteCat = (Note.Category) intent.getSerializableExtra(MainActivity.NOTE_CATEGORY_EXTRA);
        noteCatButton.setImageResource(Note.categoryToDrawable(noteCat));
// Validate note content before persisting changes

// Persist note changes to storage after user confirmation
        return fragmentLayout;
    }

}
// Configure EditText with spell checker enabled
