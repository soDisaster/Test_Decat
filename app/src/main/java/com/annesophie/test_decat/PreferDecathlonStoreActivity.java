package com.annesophie.test_decat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/* Classe permettant la création finale d'un compte utilisateur
   Etape 2/2
 * Le layout associé affiche des Radio Buttons permettant à l'utilisateur de choisir son Décathlon préféré.
 */

public class PreferDecathlonStoreActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private AuthStateListener mAuthListener;
    private DatabaseReference mDatabase;

    private Button buttonCreateAccount;
    private RadioGroup radioGroupDecat;
    private RadioButton radioButtonDecat;
    private String firstname, lastname, email, password, confirmPassword, preferDecat;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefer_decathlon_store);

        buttonCreateAccount = (Button)findViewById(R.id.buttonCreateAccount);
        buttonCreateAccount.setOnClickListener(this);

        /* On récupère les informations de CreateAccountActivity */

        Intent intent = getIntent();
        firstname = intent.getStringExtra("EXTRA_FIRSTNAME");
        lastname = intent.getStringExtra("EXTRA_LASTNAME");
        email = intent.getStringExtra("EXTRA_EMAIL");
        password = intent.getStringExtra("EXTRA_PASSWORD");
        confirmPassword = intent.getStringExtra("EXTRA_CONFIRM_PASSWORD");


       mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
            }
        };

    }


    public void onClick(final View v) {

        switch (v.getId()) {
            case R.id.buttonCreateAccount: {

                /* Radio boutons en brut */

                radioGroupDecat = (RadioGroup)findViewById(R.id.radioButtonGroupDecat);
                radioButtonDecat = (RadioButton)findViewById(radioGroupDecat.getCheckedRadioButtonId());
                preferDecat = radioButtonDecat.getText().toString();

                mAuth = FirebaseAuth.getInstance();

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()) {

                                    /* Une erreur est survenue
                                     * Faire attention aux mdps trop courts !
                                     */

                                    Toast.makeText(PreferDecathlonStoreActivity.this, "Your account was not created", Toast.LENGTH_LONG).show();
                                }
                                else {

                                    /* Enregistre les informations sur un utilisateur */

                                    writeNewUser(mAuth.getCurrentUser().getUid(), firstname, lastname, email, password, confirmPassword);

                                    Toast.makeText(PreferDecathlonStoreActivity.this, "Your account was created", Toast.LENGTH_LONG).show();

                                    final Intent intentLogin = new Intent(v.getContext(), LoginActivity.class);
                                    startActivity(intentLogin);
                                }
                            }
                        });
                break;
            }

        }

    }

    /* Enregistre les infos de l'utilisateur dans la base de données */

    public void writeNewUser(String userID, String firstname, String lastname, String email, String password, String confirmPassword) {

        mDatabase = FirebaseDatabase.getInstance().getReference();
        User user = new User(firstname, lastname, email, password, confirmPassword);

        mDatabase.child("users").push();
        Map<String, Object> userValues = user.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/users/" + userID + "/", userValues);

        mDatabase.updateChildren(childUpdates);

    }

}
