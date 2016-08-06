package com.annesophie.test_decat;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.auth.FirebaseUser;

public class PreferDecathlonStoreActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private AuthStateListener mAuthListener;
    private Button buttonCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefer_decathlon_store);
        //Firebase.setAndroidContext(this);

       mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                System.out.println(user.getUid());
            }
        };

        buttonCreateAccount = (Button)findViewById(R.id.buttonCreateAccount);
        buttonCreateAccount.setOnClickListener(this);

    }


    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonCreateAccount: {
                mAuth = FirebaseAuth.getInstance();
                mAuth.createUserWithEmailAndPassword("anne.sophie.saint.omer28@gmail.com", "test1test1")
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()) {
                                    Toast.makeText(PreferDecathlonStoreActivity.this, "Your account was not created", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                break;
            }

        }

    }

}
