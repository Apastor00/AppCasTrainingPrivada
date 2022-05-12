package com.castraining.app_castraining_privada.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.castraining.app_castraining_privada.databinding.ActivityPrivInicioMailBinding;

public class Priv_InicioMail extends AppCompatActivity {

    private ActivityPrivInicioMailBinding pri_IniMaiBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pri_IniMaiBinding = ActivityPrivInicioMailBinding.inflate(getLayoutInflater());
        setContentView(pri_IniMaiBinding.getRoot());

        Intent i = getIntent();
        String usuario = i.getStringExtra("usuario");
        String login = i.getStringExtra("loginOk");
        pri_IniMaiBinding.txtResultadoLogin.setText("Usuario logueado: \n"
                + usuario + "\n Login: " + login);

    }
}