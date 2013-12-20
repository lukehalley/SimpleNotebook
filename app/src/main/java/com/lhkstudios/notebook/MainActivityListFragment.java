package com.lhkstudios.notebook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

        registerForContextMenu(getListView());

    }

    @Override
    public boolean onContextItemSelected(MenuItem item){

        //gets pos of whatever that was long pressed
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int rowPosition = info.position;

        switch (item.getItemId()){

            case R.id.edit:
                launchNoteDetailActivity(MainActivity.FragmentToLaunch.EDIT, rowPosition);
                return true;

        }

        return super.onContextItemSelected(item);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        launchNoteDetailActivity(MainActivity.FragmentToLaunch.VIEW, position);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.long_press_menu, menu);
    }

    private void launchNoteDetailActivity (MainActivity.FragmentToLaunch ftl, int position) {

        Note note = (Note) getListAdapter().getItem(position);
        Intent intent = new Intent(getActivity(), NoteDetailActivity.class);
        intent.putExtra(MainActivity.NOTE_TITLE_EXTRA, note.getTitle());
        intent.putExtra(MainActivity.NOTE_MESSAGE_EXTRA, note.getMessage());
        intent.putExtra(MainActivity.NOTE_CATEGORY_EXTRA, note.getCategory());
        intent.putExtra(MainActivity.NOTE_ID_EXTRA, note.getId());

        switch(ftl){
            case VIEW:
                intent.putExtra(MainActivity.NOTE_FRAGMENT_TO_LOAD_EXTRA, MainActivity.FragmentToLaunch.VIEW);
                break;
            case EDIT:
                intent.putExtra(MainActivity.NOTE_FRAGMENT_TO_LOAD_EXTRA, MainActivity.FragmentToLaunch.EDIT);
                break;
        }

    }

}
