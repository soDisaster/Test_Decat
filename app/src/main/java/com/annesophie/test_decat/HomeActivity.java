package com.annesophie.test_decat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {


    private TextView userName;
    private String firstname, lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userName = (TextView)findViewById(R.id.textViewUserName);

        Intent intent = getIntent();

        firstname = intent.getStringExtra("EXTRA_FIRSTNAME");
        lastname = intent.getStringExtra("EXTRA_LASTNAME");
        userName.setText("Hello " + firstname + " " + lastname + " !");

    }
}
