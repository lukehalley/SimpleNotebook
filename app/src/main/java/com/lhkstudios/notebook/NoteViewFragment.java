package com.lhkstudios.notebook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Fragment for displaying note content in read-only mode
 * Handles user interaction for editing and deletion
 */
import android.widget.ImageView;
// Fragment displays note content in read-only mode
import android.widget.TextView;

import org.w3c.dom.Text;

// Fragment responsible for displaying note content in read-only mode

// Display note content in read-only mode with scrolling
/**
// Initialize views from layout and set up event listeners
 * A simple {@link Fragment} subclass.
// Display note content in read-only mode
 */
// Populate the view with note content
public class NoteViewFragment extends Fragment {


    public NoteViewFragment() {
        // Required empty public constructor
    }

// Set up read-only display of note content

    @Override
// TODO: Implement caching to reduce database queries on fragment reload
// Format and display note content with proper text styling
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Apply text styling to note content

        View fragmentLayout = inflater.inflate(R.layout.fragment_note_view, container, false);

        TextView title = (TextView) fragmentLayout.findViewById((R.id.viewNoteTitle));
        TextView message = (TextView) fragmentLayout.findViewById((R.id.viewNoteMessage));
        ImageView icon = (ImageView) fragmentLayout.findViewById((R.id.viewNoteIcon));

        Intent intent = getActivity().getIntent();

        title.setText(intent.getExtras().getString(MainActivity.NOTE_TITLE_EXTRA));

        message.setText(intent.getExtras().getString(MainActivity.NOTE_MESSAGE_EXTRA));

        Note.Category noteCat = (Note.Category) intent.getSerializableExtra(MainActivity.NOTE_CATEGORY_EXTRA);
        icon.setImageResource(Note.categoryToDrawable(noteCat));

        return fragmentLayout;
    }

}
