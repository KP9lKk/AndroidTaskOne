package com.example.myapplication;

import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public String email;
    public String password;

    public User(String name, String email, String password){
            this.name = name;
            this.email = email;
            this.password = password;
    }
}
