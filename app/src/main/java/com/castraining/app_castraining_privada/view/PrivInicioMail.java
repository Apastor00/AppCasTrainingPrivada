package com.castraining.app_castraining_privada.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.castraining.app_castraining_privada.PrivMainActivity;
import com.castraining.app_castraining_privada.databinding.ActivityPrivInicioMailBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PrivInicioMail extends AppCompatActivity {

    private GoogleSignInClient mGoogleSignInClient;
    private ActivityPrivInicioMailBinding privIniMaiBinding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        privIniMaiBinding = ActivityPrivInicioMailBinding.inflate(getLayoutInflater());
        setContentView(privIniMaiBinding.getRoot());

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        Intent i = getIntent();
        String usuario = i.getStringExtra("usuario");
        String login = i.getStringExtra("loginOk");
        privIniMaiBinding.txtResultadoLogin.setText("Usuario logueado: \n"
                + usuario + "\n Login: " + login);

        privIniMaiBinding.btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cerrarSesion();
            }
        });
    }
    private void cerrarSesion() {
        mGoogleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
            }
        });
        Intent i = new Intent(this, PrivMainActivity.class);
        startActivity(i);
    }
    private void updateUI(FirebaseUser user) {}
}