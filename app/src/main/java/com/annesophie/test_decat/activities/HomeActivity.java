package com.annesophie.test_decat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.annesophie.test_decat.R;
import com.google.firebase.auth.FirebaseAuth;


/* Page de l'utilisateur (quand l'utilisateur vient de se connecter) */

public class HomeActivity extends AppCompatActivity {


    private TextView textViewUserName, textViewDecat, textViewAddress, textViewCity, textViewCountry;
    private String firstname, lastname, decat, address, city, country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /* Le nom de l'utilisateur, son Décathlon préféré et l'adresse correspondante */

        textViewUserName = (TextView)findViewById(R.id.textViewUserName);
        textViewDecat = (TextView)findViewById(R.id.textViewDecat);
        textViewAddress = (TextView)findViewById(R.id.textViewAddress);
        textViewCity = (TextView)findViewById(R.id.textViewCity);
        textViewCountry = (TextView)findViewById(R.id.textViewCountry);

        /* On récupère les informations transmises par l'intent */

        Intent intent = getIntent();
        firstname = intent.getStringExtra("EXTRA_FIRSTNAME");
        lastname = intent.getStringExtra("EXTRA_LASTNAME");
        decat = intent.getStringExtra("EXTRA_DECAT");
        address = intent.getStringExtra("EXTRA_ADDRESS");
        city = intent.getStringExtra("EXTRA_CITY");
        country = intent.getStringExtra("EXTRA_COUNTRY");

        /* On modifie les textView pour obtenir les informations sur le layout */

        textViewUserName.setText("Hello " + firstname + " " + lastname + " !");
        textViewDecat.setText(decat);
        textViewAddress.setText(address);
        textViewCity.setText(city);
        textViewCountry.setText(country);


    }

    /* Au clic sur le bouton Logout */

    public void goToLogin(View v){
        FirebaseAuth.getInstance().signOut();
        Intent intentLogin = new Intent(this, LoginActivity.class);
        startActivity(intentLogin);
    }
}
