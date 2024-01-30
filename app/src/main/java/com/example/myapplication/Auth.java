package com.example.myapplication;

import java.io.Serializable;

public class Auth  implements Serializable {
    public String email;
    public String password;

    public Auth(String email, String password){
        this.email = email;
        this.password =password;
    }
}
