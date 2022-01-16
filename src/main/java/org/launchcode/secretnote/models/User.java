package org.launchcode.secretnote.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class User {

    @Id
    private UUID id = UUID.randomUUID();

    public UUID getId() {
        return id;
    }

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

    public boolean isMatching(String password){
        return encoder.matches(password, hPassword);
    }

}
