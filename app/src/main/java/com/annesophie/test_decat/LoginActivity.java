package com.annesophie.test_decat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.annesophie.test_decat.classes.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements OnClickListener{

    private Button buttonCreateAccount, buttonLogin;
    private EditText editTextEmail, editTextPassword;
    private String firstname, lastname, email, password, namePreferDecat;

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private User user;

    private Retrofit retrofit;
    private GitHubService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Bouton pour la création d'un compte.

        buttonCreateAccount = (Button) findViewById(R.id.buttonCreateAccount);
        buttonCreateAccount.setOnClickListener(this);

        // Bouton pour se loger.

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        /* Réagit quand :
         - il y a une connexion/déconnexion d'utilisateur
         - l'utilisateur courant change
         - etc
        */

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
            }
        };
    }

    // Enregistrer un listener


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    // Supprimer un listener


    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void onClick(final View v) {

        switch (v.getId()) {
            case R.id.buttonCreateAccount: {

                /*
                    Passe à l'activité qui permet de rentrer les informations pour créer son compte.
                 */

                Intent intentCreateAccount = new Intent(this, CreateAccountActivity.class);
                startActivity(intentCreateAccount);
                break;
            }
            case  R.id.buttonLogin: {

                /*
                    Récupère les infos entrées dans email et password.
                 */

                email = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();

                // Login

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Invalid user/password", Toast.LENGTH_LONG).show();
                                } else {

                                    /* Récupère l'id de l'utilisateur courant */

                                    String userID = mAuth.getCurrentUser().getUid();

                                    mDatabase.child("users").child(userID).addListenerForSingleValueEvent(
                                            new ValueEventListener() {
                                                @Override
                                                public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {

                                                    /* Récupère les informations sur l'user à un moment donné */
                                                    user = dataSnapshot.getValue(User.class);

                                                    firstname = user.getFirstname();
                                                    lastname = user.getLastname();
                                                    namePreferDecat = user.getNamePreferDecat();

                                                    retrofit = new Retrofit.Builder()
                                                            .baseUrl("https://dktmobile.oxylane.com/backofficemobile-server-mvc/service/")
                                                            .addConverterFactory(GsonConverterFactory.create())
                                                            .build();
                                                    service = retrofit.create(GitHubService.class);
                                                    Call<DataDecathlon> call = service.groupListNameDecat();
                                                    call.enqueue(new Callback<DataDecathlon>() {
                                                        @Override
                                                        public void onResponse(Call<DataDecathlon> call, Response<DataDecathlon> response) {
                                                            ArrayList<String> storeInformation = response.body().getData().getStoreInformation(namePreferDecat);
                                                            final Intent intentHome = new Intent(v.getContext(), HomeActivity.class);
                                                            Bundle extras = new Bundle();
                                                            extras.putString("EXTRA_FIRSTNAME", firstname);
                                                            extras.putString("EXTRA_LASTNAME", lastname);
                                                            extras.putString("EXTRA_DECAT", namePreferDecat);
                                                            extras.putString("EXTRA_ADDRESS", storeInformation.get(0));
                                                            extras.putString("EXTRA_CITY", storeInformation.get(1));
                                                            extras.putString("EXTRA_COUNTRY", storeInformation.get(2));
                                                            intentHome.putExtras(extras);
                                                            startActivity(intentHome);
                                                        }

                                                        @Override
                                                        public void onFailure(Call<DataDecathlon> call, Throwable t) {

                                                            System.out.println("Erreur");
                                                        }
                                                    });

                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {
                                                    //Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                                                }
                                            });
                                }
                            }
                        });

                break;
            }

        }

    }

}
