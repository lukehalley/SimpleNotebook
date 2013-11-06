package com.lhkstudios.notebook;

/**
 * Created by Luke on 21/07/16.
 */
public class Note {

    private String title, message;
    private long noteId, dateCreatedMilli;
    private Category category;

    public enum Category{PERSONAL, TECHNICAL, QUOTE, FINANCE}

    public Note(String title, String message, Category category)
    {
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = 0;
        this.dateCreatedMilli = 0;
    }

    public Note(String title, String message, Category category, long noteId, long dateCreatedMilli)
    {
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = noteId;
        this.dateCreatedMilli = dateCreatedMilli;
    }

    public String getTitle(){
        return title;
    }

    public String getMessage(){
        return message;
    }

    public Category getCategory(){
        return category;
    }

    public long getDate(){ return dateCreatedMilli; }

    public long getId(){ return noteId; }

    public String toString() {
        return "ID: " + noteId + " Title: " + title + " Message: "
                      + message + " IconID " + category.name()
                      + " Date: ";

    }

    public int getAssociatedDrawable() {
        return categoryToDrawable(category);
    }

    public static int categoryToDrawable(Category noteCategory){
        switch (noteCategory) {
            case PERSONAL:
                return R.drawable.personal;
            case TECHNICAL:
                return R.drawable.technical;
            case FINANCE:
                return R.drawable.finance;
            case QUOTE:
                return R.drawable.quote;
        }

        return R.drawable.personal;
    }


}
