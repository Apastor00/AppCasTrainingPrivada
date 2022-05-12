package com.castraining.app_castraining_privada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.castraining.app_castraining_privada.View.Priv_InicioApple;
import com.castraining.app_castraining_privada.View.Priv_InicioFacebook;
import com.castraining.app_castraining_privada.View.Priv_InicioGoogle;
import com.castraining.app_castraining_privada.View.Priv_InicioMail;
import com.castraining.app_castraining_privada.View.Priv_Login;
import com.castraining.app_castraining_privada.databinding.ActivityPriMainBinding;

public class Pri_MainActivity extends AppCompatActivity {

    private ActivityPriMainBinding priMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        priMainBinding = ActivityPriMainBinding.inflate(getLayoutInflater());
        setContentView(priMainBinding.getRoot());

        priMainBinding.btnInicioCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inicioSesion = "Iniciada sesión con Cuenta Correo";
                InicioSesionCorreo(inicioSesion);
            }
        });
        priMainBinding.btnInicioGoogle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String inicioSesion = "Iniciada sesión con Cuenta Google";
                InicioSesionGoogle(inicioSesion);
            }
        });
        priMainBinding.btnInicioApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inicioSesion = "Iniciada sesión con Cuenta Apple";
                InicioSesionApple(inicioSesion);
            }
        });
        priMainBinding.btnInicioFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inicioSesion = "Iniciada sesión con Cuenta Facebook";
                InicioSesionFacebook(inicioSesion);
            }
        });
    }

    private void InicioSesionApple(String inicioSesion) {
        Intent i = new Intent(this, Priv_InicioApple.class );
        i.putExtra("incioSesion", inicioSesion);
        startActivity(i);
    }
    private void InicioSesionGoogle(String inicioSesion) {
        Intent i = new Intent(this, Priv_InicioGoogle.class );
        i.putExtra("incioSesion", inicioSesion);
        startActivity(i);
    }
    private void InicioSesionCorreo(String inicioSesion) {
        Intent i = new Intent(this, Priv_Login.class );
        i.putExtra("incioSesion", inicioSesion);
        startActivity(i);
    }
    private void InicioSesionFacebook(String inicioSesion) {
        Intent i = new Intent(this, Priv_InicioFacebook.class );
        i.putExtra("incioSesion", inicioSesion);
        startActivity(i);
    }


}