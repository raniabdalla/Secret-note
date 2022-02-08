package org.launchcode.secretnote.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity{

    @OneToMany
    @JoinColumn
    private List<SecretNote> notes = new ArrayList<>();

    @NotNull
    private String username;

    @NotNull
    private String hPassword;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.hPassword = encoder.encode(password);
    }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public boolean isMatching(String password){
        return encoder.matches(password, hPassword);
    }

}
