package org.launchcode.secretnote.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class SecretNote {

    @NotBlank(message = "Please enter a note name")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    /** Removing Folder for now, will likely be re-added later - CR */
    //private Folder folder;

    @NotBlank(message = "Please enter a note")
    @Size(min = 1, max = 500, message = "Note must be between 1 and 500 characters")
    private String content;

    @Id
    private int id;

    public SecretNote(String name, String content, int id) {
        this.name = name;
        this.content = content;
        this.id = id++;
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

    public int getId() { return id;}

    @Override
    public String toString() {
        return name;
    }
}
