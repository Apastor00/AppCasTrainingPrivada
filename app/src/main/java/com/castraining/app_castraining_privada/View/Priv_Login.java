package com.castraining.app_castraining_privada.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.castraining.app_castraining_privada.databinding.ActivityPrivLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Priv_Login extends AppCompatActivity {

    private ActivityPrivLoginBinding privLoginBinding;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        privLoginBinding = ActivityPrivLoginBinding.inflate(getLayoutInflater());
        setContentView(privLoginBinding.getRoot());
        mAuth = FirebaseAuth.getInstance();
    }


    @Override
    public void onStart(){
        super.onStart();
        //Checkeamos que el usuario está logado y lo actualizamos en la ui
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    public void startSignin(View view){
        String mail = privLoginBinding.edtxtLoginMail.getText().toString();
        //String mail = privLoginBinding.edtxtLoginMail.getEditText().toString();
        String password = privLoginBinding.edtxtLoginPassword.getText().toString();
        //String password = privLoginBinding.edtxtLoginPassword.getEditText().toString();
        mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            String loginOk = "Autentificación correcta";
                            FirebaseUser firebaseUser = mAuth.getCurrentUser();
                            updateUI(firebaseUser);
                            Intent i = new Intent(Priv_Login.this, Priv_InicioMail.class);
                            i.putExtra("usuario", mail);
                            i.putExtra("loginOk", loginOk);
                            startActivity(i);
                        }
                        else {
                            //Toast.makeText(Priv_Login.this, "Autentifiación fallida", Toast.LENGTH_SHORT).show();
                            Toast.makeText(Priv_Login.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }
    private void updateUI(FirebaseUser currentUser) { }
}