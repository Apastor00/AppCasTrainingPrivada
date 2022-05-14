package com.castraining.app_castraining_privada.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//import com.castraining.app_castraining_privada.databinding.ActivityPrivNuevoUsuarioBinding;
import com.castraining.app_castraining_privada.databinding.ActivityPrivNuevoUsuarioBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PrivNuevoUsuario extends AppCompatActivity {

    private ActivityPrivNuevoUsuarioBinding privNuevoUsuarioBinding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        privNuevoUsuarioBinding = ActivityPrivNuevoUsuarioBinding.inflate(getLayoutInflater());
        setContentView(privNuevoUsuarioBinding.getRoot());
        //Inicializamos FirebaseAuth
        mAuth = FirebaseAuth.getInstance();
        //Recogemos el intent y comprobamos que el usuario no ha metido ningún valor
        Intent i = getIntent();
        if (i.getStringExtra("usuario") != null){
            privNuevoUsuarioBinding.edtxtLoginMail.setText(i.getStringExtra("usuario").toString());
        }
        privNuevoUsuarioBinding.btnGoogleRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = privNuevoUsuarioBinding.edtxtLoginMail.getText().toString();
                String password = privNuevoUsuarioBinding.edtxtLoginPassword1.getText().toString();
                String validar = privNuevoUsuarioBinding.edtxtLoginPassword2.getText().toString();
                if (validar.equals(password)){
                    nuevoUsuario(mail, password);
                }
                else Toast.makeText(PrivNuevoUsuario.this, "Error: Las contraseñas deben coincidir", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void nuevoUsuario(String mail, String password) {
        //Método para crear un usuario nuevo
        mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(PrivNuevoUsuario.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            String login = "Usuario creado con éxito";
                            Toast.makeText(PrivNuevoUsuario.this,login, Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            envioMailVerifica();
                            //Iniciamos la actividad tras registrarse con éxito
                            Intent i = new Intent(PrivNuevoUsuario.this, PrivInicioMail.class);
                            //Parámetros que pasamos al intent para que los muestre en la nueva actividad
                            i.putExtra("usuario", mail);
                            i.putExtra("loginOk", login);
                            startActivity(i);
                        } else {
                            Toast.makeText(PrivNuevoUsuario.this, "Creación de usuario fallida", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }
    private void envioMailVerifica (){
        FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
            }
        });
    }
    private void updateUI(FirebaseUser user) {}
}