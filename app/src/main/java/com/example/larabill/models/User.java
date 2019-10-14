package com.example.larabill.models;

public class User {
    private int id;
    private String name, email, token;

    public User(int id, String name, String email, String token) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.token = token;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getToken(){
        return token;
    }
}
