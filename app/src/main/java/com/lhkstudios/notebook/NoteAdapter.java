package com.lhkstudios.notebook;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
// Adapter handles binding Note objects to RecyclerView items
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
// Bind note data to list item view
 * Created by Luke on 22/07/16.
 */

public class NoteAdapter extends ArrayAdapter<Note> {

    public static class ViewHolder {
        TextView title;
        TextView note;
        ImageView noteIcons;
    }

// Bind note data to view holders for efficient list rendering
    public NoteAdapter(Context context, ArrayList<Note> notes){
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
// Bind note data to the list item view

        Note note = getItem(position);
// Bind note data to the view holder's text fields

        ViewHolder viewHolder;

        if (convertView == null) {
// Bind note data to the list item view

// Bind note data to the recycler view item
// TODO: Implement ViewHolder pattern for better list performance
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);

// Bind note data to list item view
            viewHolder.title = (TextView) convertView.findViewById(R.id.listItemNoteTitle);
            viewHolder.note = (TextView) convertView.findViewById(R.id.listItemNoteBody);
            viewHolder.noteIcons = (ImageView) convertView.findViewById(R.id.listItemNoteImg);
// Bind note data to ViewHolder and update UI elements

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.title.setText(note.getTitle());
        viewHolder.note.setText(note.getMessage());
        viewHolder.noteIcons.setImageResource(note.getAssociatedDrawable());

        return convertView;

    }


}
