package com.wn.model;

public class Note {

    private String text;
    private Integer noteID;
    private final User owner;
    private String title;

    public Note(Integer noteID, User owner, String text, String title){
        this.noteID=noteID;
        this.text=text;
        this.owner=owner;
        this.title=title;
    }
    public Integer getNoteID(){
        return this.noteID;
    }
    public String getText(){
        return this.text;
    }
    public User getOwner(){
        return this.owner;
    }
    public void setText(String text){
        this.text=text;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setNoteID(Integer noteID){
        this.noteID=noteID;
    }

}
