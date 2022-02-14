package org.launchcode.secretnote.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class SecretNote extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "notes_id")
    private User user;

    @NotBlank(message = "Please enter a note name")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    /** Removing Folder for now, will likely be re-added later - CR */
    //private Folder folder;

    @NotBlank(message = "Please enter a note")
    @Size(min = 1, max = 500, message = "Note must be between 1 and 500 characters")
    private String content;

    @NotNull
    private String color;

    @NotNull
    private String textcolor;

    public SecretNote(String name, String content, User aUser, String color) {
        super();
        this.name = name;
        this.content = content;
        this.user = aUser;
        this.color = color;
        this.setTextcolor();
    }

    public SecretNote() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    } */

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getColor() { return color; }

    public void setColor(String color) {
        this.color = color;
        this.setTextcolor();
    }

    public String getTextcolor() { return textcolor; }

    public void setTextcolor() {
        int colorR = Integer.decode("0x" + this.color.substring(1,3));
        int colorG = Integer.decode("0x" + this.color.substring(3,5));
        int colorB = Integer.decode("0x" + this.color.substring(5,7));
        int average = (colorR + colorG + colorB) / 3;
        if (average > 128) { this.textcolor = "#000000"; } else { this.textcolor = "#FFFFFF"; }
    }

    @Override
    public String toString() {
        return name;
    }
}
