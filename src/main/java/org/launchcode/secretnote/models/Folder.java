package org.launchcode.secretnote.models;

//import javax.persistence.*;
//import javax.validation.Valid;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class Folder {

//    @NotBlank(message = "Please enter a folder name")
//    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    public Folder(String name) {
        this.name = name;
    }

    public Folder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
