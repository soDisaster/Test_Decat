package com.annesophie.test_decat;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/* Classe User */

@IgnoreExtraProperties
public class User {

    private String firstname, lastname, email, password, confirmPassword, namePreferDecat;

    public User() {

    }

    public User(String firstname, String lastname, String email, String password, String confirmPassword, String namePreferDecat) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.namePreferDecat = namePreferDecat;

    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("firstname", firstname);
        result.put("lastname", lastname);
        result.put("email", email);
        result.put("password", password);
        result.put("confirmPassword", confirmPassword);
        result.put("namePreferDecat", namePreferDecat);
        return result;
    }

    public String getFirstname(){

        return firstname;
    }

    public String getLastname(){

        return lastname;
    }

    public String getNamePreferDecat(){

        return namePreferDecat;
    }


}