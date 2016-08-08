package com.annesophie.test_decat;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anne-So on 07/08/2016.
 */

@IgnoreExtraProperties
public class User {

    private String id, firstname, lastname, email, password, confirmPassword;

    public User() {

    }

    public User(String firstname, String lastname, String email, String password, String confirmPassword) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;

    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("firstname", firstname);
        result.put("lastname", lastname);
        result.put("email", email);
        result.put("password", password);
        result.put("confirmPassword", confirmPassword);
        return result;
    }

    public String getFirstname(){

        return firstname;
    }

    public String getLastname(){

        return lastname;
    }


}