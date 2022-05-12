package com.castraining.app_castraining_privada.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.castraining.app_castraining_privada.databinding.ActivityPrivNuevoUsuarioBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Priv_NuevoUsuario extends AppCompatActivity {

    private ActivityPrivNuevoUsuarioBinding privNuevoUsuarioBinding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        privNuevoUsuarioBinding = ActivityPrivNuevoUsuarioBinding.inflate(getLayoutInflater());
        setContentView(privNuevoUsuarioBinding.getRoot());
        //Inicializamos FirebaseAuth
        mAuth = FirebaseAuth.getInstance();
        privNuevoUsuarioBinding.btnRegistroNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = privNuevoUsuarioBinding.edtxtLoginMail.getText().toString();
                String password = privNuevoUsuarioBinding.edtxtLoginPassword1.getText().toString();
                String validar = privNuevoUsuarioBinding.edtxtLoginPassword2.getText().toString();
                if (validar.equals(password)){
                    nuevoUsuario(mail, password);
                }
                else Toast.makeText(Priv_NuevoUsuario.this, "Error: Las contraseñas deben coincidir", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void nuevoUsuario(String mail, String password) {
        //Método para crear un usuario nuevo
        mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(Priv_NuevoUsuario.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            String login = "Usuario creado con éxito";
                            Toast.makeText(Priv_NuevoUsuario.this,login, Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            //Iniciamos la actividad tras registrarse con éxito
                            Intent i = new Intent(Priv_NuevoUsuario.this, Priv_InicioMail.class);
                            //Parámetros que pasamos al intent para que los muestre en la nueva actividad
                            i.putExtra("usuario", mail);
                            i.putExtra("loginOk", login);
                            startActivity(i);
                        } else {
                            Toast.makeText(Priv_NuevoUsuario.this, "Creación de usuario fallida", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }
    private void updateUI(FirebaseUser user) {}
}