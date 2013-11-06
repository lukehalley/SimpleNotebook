package com.lhkstudios.notebook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {


    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        notes = new ArrayList<Note>();

            notes.add(new Note("Title Here", "Body here",
                    Note.Category.PERSONAL));

            notes.add(new Note("Title Here", "Body here",
                    Note.Category.FINANCE));

            notes.add(new Note("Title Here", "Body here",
                    Note.Category.QUOTE));

            notes.add(new Note("Title Here", "Body here",
                    Note.Category.TECHNICAL));

            notes.add(new Note("Title Here", "Body here",
                    Note.Category.PERSONAL));

            notes.add(new Note("Title Here", "Body here",
                    Note.Category.FINANCE));

            notes.add(new Note("Title Here", "Body here",
                    Note.Category.QUOTE));

            notes.add(new Note("Title Here", "Body here",
                    Note.Category.TECHNICAL));

            notes.add(new Note("Title Here", "Body here",
                    Note.Category.PERSONAL));

            notes.add(new Note("Title Here", "Body here",
                    Note.Category.FINANCE));

            notes.add(new Note("Title Here", "Body here",
                    Note.Category.QUOTE));


        noteAdapter = new NoteAdapter(getActivity(), notes);

        setListAdapter(noteAdapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
    }

}
