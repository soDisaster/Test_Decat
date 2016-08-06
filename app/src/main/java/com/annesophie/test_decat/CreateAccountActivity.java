package com.annesophie.test_decat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

    }

    public void goToNext(View v){

        /*
            Vers l'activité PreferDecathlonStoreActivity
            Prochaine étape pour créer un compte.
            Choisir son Décathlon préféré

        */

        Intent intentNext = new Intent(this, PreferDecathlonStoreActivity.class);
        startActivity(intentNext);

    }
}