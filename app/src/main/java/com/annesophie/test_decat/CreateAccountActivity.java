package com.annesophie.test_decat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText editTextFirstname, editTextLastname, editTextEmail, editTextPassword, editTextConfirmPassword;
    private String firstname, lastname, email, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        editTextFirstname = (EditText)findViewById(R.id.editTextFirstname);
        editTextLastname = (EditText)findViewById(R.id.editTextLastname);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextConfirmPassword = (EditText)findViewById(R.id.editTextConfirmPassword);

    }

    public void goToNext(View v){

        /*
            Vers l'activité PreferDecathlonStoreActivity
            Prochaine étape pour créer un compte.
            Choisir son Décathlon préféré

        */

        firstname = editTextFirstname.getText().toString();
        lastname = editTextLastname.getText().toString();
        email = editTextEmail.getText().toString();
        password = editTextPassword.getText().toString();
        confirmPassword = editTextConfirmPassword.getText().toString();

        Intent intentNext = new Intent(this, PreferDecathlonStoreActivity.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_FIRSTNAME", firstname);
        extras.putString("EXTRA_LASTNAME", lastname);
        extras.putString("EXTRA_EMAIL", email);
        extras.putString("EXTRA_PASSWORD",password);
        extras.putString("EXTRA_CONFIRM_PASSWORD", confirmPassword);
        intentNext.putExtras(extras);
        startActivity(intentNext);

    }
}