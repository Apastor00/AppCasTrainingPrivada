package com.castraining.app_castraining_privada.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.castraining.app_castraining_privada.databinding.ActivityPrivInicioGoogleBinding;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PrivInicioGoogle extends AppCompatActivity {

    public static final int RC_SIGN_IN = 9001;
    public static final String TAG = "GoogleActivity";

    private ActivityPrivInicioGoogleBinding pri_IniGooBinding;
    //Declaramos la variable auth de Firebase
    private FirebaseAuth mAuth;
    //Declaramos Google Sign
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pri_IniGooBinding = ActivityPrivInicioGoogleBinding.inflate(getLayoutInflater());
        setContentView(pri_IniGooBinding.getRoot());

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        pri_IniGooBinding.btnGoogleRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicioSesionGoogle();
            }
        });
    }

    private void inicioSesionGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    //Tras el inicio de sesión trabajamos con la actividad resultado
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            GoogleSignInAccount account = null;
            try {
                account = task.getResult(ApiException.class);
                updateUI(account);
            } catch (ApiException e) {
                Log.w(TAG, "Resultado login Google: "+ e.getStatusCode());
                updateUI(null);
            }
            Intent i = new Intent(PrivInicioGoogle.this, PrivInicioMail.class);
            i.putExtra("usuario", account.getEmail());
            i.putExtra("loginOk", "Login de Google ya autenticado");
            startActivity(i);
        } else {
            Log.w(TAG, "Fallo requestCode");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Comprobamos si ya hay un usuario logeado anteriormente
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        //Elegimos las opciones según exista un usuario logueado o no
        if (account != null){
            //Actulizamos la UI
            updateUI(account);
            Intent i = new Intent(PrivInicioGoogle.this, PrivInicioMail.class);
            i.putExtra("usuario", account.getEmail());
            i.putExtra("loginOk", "Login de Google ya autenticado");
            startActivity(i);
        } else {
            //Actulizamos la UI
            updateUI(account);
            Log.d(TAG, "No había usuario logueado anteriormente");
        }
    }
    private void updateUI(GoogleSignInAccount account) {}
}