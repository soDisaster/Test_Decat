package com.annesophie.test_decat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateAccountActivity extends AppCompatActivity {

    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // Next step

        buttonNext = (Button) findViewById(R.id.buttonNext);

    }



    public void goToNext(View v){

        Intent intentNext = new Intent(this, PreferDecathlonStoreActivity.class);
        startActivity(intentNext);
    }

}