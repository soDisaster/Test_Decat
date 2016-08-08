package com.annesophie.test_decat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anne-So on 07/08/2016.
 */

@IgnoreExtraProperties
public class User {

    private String id, firstname, lastname, email, password, confirmPassword;
    private DatabaseReference mDatabase;

    public User(String id, String firstname, String lastname, String email, String password, String confirmPassword) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;

    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("userID", id);
        result.put("firstname", firstname);
        result.put("lastname", lastname);
        result.put("email", email);
        result.put("password", password);
        result.put("confirmPassword", confirmPassword);
        return result;
    }


}