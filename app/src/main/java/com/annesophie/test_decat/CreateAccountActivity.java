package com.annesophie.test_decat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/* Classe permettant à l'utilisateur d'entrer les informations le concernant.
   Etape 1/2
 */

public class CreateAccountActivity extends AppCompatActivity {

    private EditText editTextFirstname, editTextLastname, editTextEmail, editTextPassword, editTextConfirmPassword;
    private String firstname, lastname, email, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        /* EditText */

        editTextFirstname = (EditText)findViewById(R.id.editTextFirstname);
        editTextLastname = (EditText)findViewById(R.id.editTextLastname);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextConfirmPassword = (EditText)findViewById(R.id.editTextConfirmPassword);

    }

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
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

        if(firstname.equals("") || lastname.equals("")
                || email.equals("") || password.equals("") || confirmPassword.equals("") || firstname.equals(" ") || lastname.equals(" ")
                || email.equals(" ") || password.equals(" ") || confirmPassword.equals(" ") || firstname.isEmpty() || lastname.isEmpty()
                || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {

            Toast.makeText(this, "Please complete text fields which are empty.", Toast.LENGTH_LONG).show();

        }
        else if(!(isValidEmail(email))){

            Toast.makeText(this, "The email address is not correct", Toast.LENGTH_LONG).show();
        }
        else if(!(password.equals(confirmPassword))){

            Toast.makeText(this, "The two passwords don't match", Toast.LENGTH_LONG).show();

        }
        else if(password.length() < 6){

            Toast.makeText(this, "This password is too short", Toast.LENGTH_LONG).show();
        }
        else {

            /* Intent vers PreferDecathlonStoreActivity */

            Intent intentNext = new Intent(this, PreferDecathlonStoreActivity.class);
            Bundle extras = new Bundle();
            extras.putString("EXTRA_FIRSTNAME", firstname);
            extras.putString("EXTRA_LASTNAME", lastname);
            extras.putString("EXTRA_EMAIL", email);
            extras.putString("EXTRA_PASSWORD", password);
            extras.putString("EXTRA_CONFIRM_PASSWORD", confirmPassword);
            intentNext.putExtras(extras);
            startActivity(intentNext);
        }

    }
}