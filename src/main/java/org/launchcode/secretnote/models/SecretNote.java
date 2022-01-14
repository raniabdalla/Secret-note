package org.launchcode.secretnote.models;

import java.util.UUID;

public class SecretNote {

    private String name;

    private Folder folder;

    private String description;

    private UUID id = UUID.randomUUID();

    public SecretNote(String name, Folder folder) {
        this.name = name;
        this.folder = folder;
        this.id = id;
    }

    public SecretNote() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public UUID getId() { return id;}

    @Override
    public String toString() {
        return name;
    }
}
