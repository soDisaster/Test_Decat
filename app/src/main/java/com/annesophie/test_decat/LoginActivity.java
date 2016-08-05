package com.annesophie.test_decat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements OnClickListener{

    private Button buttonCreateAccount, buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Create account

        buttonCreateAccount = (Button)findViewById(R.id.buttonCreateAccount);
        buttonCreateAccount.setOnClickListener(this);

    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonCreateAccount: {
                Intent intentCreateAccount = new Intent(this, CreateAccountActivity.class);
                startActivity(intentCreateAccount);
                break;
            }
            case  R.id.buttonLogin: {
                // do something
                break;
            }

        }

    }

}
