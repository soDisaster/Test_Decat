package com.annesophie.test_decat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.annesophie.test_decat.classes.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

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
    private String firstname, lastname, email, password, confirmPassword, namePreferDecat;
    private User user;

    private Retrofit retrofit;
    private GitHubService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefer_decathlon_store);

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

        radioGroupDecat = new RadioGroup(this);
        radioGroupDecat.setOrientation(LinearLayout.VERTICAL);

        buttonCreateAccount = (Button)findViewById(R.id.buttonCreateAccount);
        buttonCreateAccount.setOnClickListener(this);

        JsonDecathlon();

    }

    public void JsonDecathlon(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://dktmobile.oxylane.com/backofficemobile-server-mvc/service/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(GitHubService.class);
        Call<DataDecathlon> call = service.groupListNameDecat();
        call.enqueue(new Callback<DataDecathlon>() {
            @Override
            public void onResponse(Call<DataDecathlon> call, Response<DataDecathlon> response) {
                ArrayList<String> storesNamesDecathlon = response.body().getData().getStoresDecathlonNames();
                for (int i = 0; i < storesNamesDecathlon.size(); i++) {
                    RadioButton rdbtn = new RadioButton(getApplicationContext());
                    rdbtn.setText(storesNamesDecathlon.get(i));
                    int textColor = Color.parseColor("#000000");
                    rdbtn.setButtonTintList(ColorStateList.valueOf(textColor));
                    rdbtn.setTextColor(textColor);
                    radioGroupDecat.addView(rdbtn);
                }
                ((ViewGroup) findViewById(R.id.radioGroupDecat)).addView(radioGroupDecat);
            }

            @Override
            public void onFailure(Call<DataDecathlon> call, Throwable t) {

                System.out.println("Erreur");
            }
        });
    }


    public void onClick(final View v) {

        switch (v.getId()) {
            case R.id.buttonCreateAccount: {

                radioButtonDecat = (RadioButton)findViewById(radioGroupDecat.getCheckedRadioButtonId());
                namePreferDecat = radioButtonDecat.getText().toString();

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

                                    writeNewUser(mAuth.getCurrentUser().getUid(), firstname, lastname, email, password, confirmPassword, namePreferDecat);

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

    public void writeNewUser(String userID, String firstname, String lastname, String email, String password, String confirmPassword, String namePreferDecat) {

        mDatabase = FirebaseDatabase.getInstance().getReference();
        User user = new User(firstname, lastname, email, password, confirmPassword, namePreferDecat);

        mDatabase.child("users").push();
        Map<String, Object> userValues = user.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/users/" + userID + "/", userValues);

        mDatabase.updateChildren(childUpdates);

    }

}
