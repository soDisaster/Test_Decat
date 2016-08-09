package com.annesophie.test_decat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


/* Page d'accueil (quand l'utilisateur est connecté) */

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

    /* Au clic sur le bouton Déconnexion */

    public void goToLogin(View v){
        FirebaseAuth.getInstance().signOut();
        Intent intentLogin = new Intent(this, LoginActivity.class);
        startActivity(intentLogin);
    }
}
