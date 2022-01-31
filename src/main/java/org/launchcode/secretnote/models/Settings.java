package org.launchcode.secretnote.models;

public class Settings {

    private boolean darkMode;

    public Settings(boolean darkMode) {
        this.darkMode = darkMode;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }
}
