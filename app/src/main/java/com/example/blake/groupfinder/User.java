package com.example.blake.groupfinder;

public class User {
    private String username;
    private String email;
    private String password;
    private String interests;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public void ChangeInterests(String interests){
        this.interests = interests;
    }
}
