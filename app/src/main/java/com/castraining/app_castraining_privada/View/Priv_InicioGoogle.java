package com.castraining.app_castraining_privada.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.castraining.app_castraining_privada.databinding.ActivityPrivInicioGoogleBinding;

public class Priv_InicioGoogle extends AppCompatActivity {

    private ActivityPrivInicioGoogleBinding pri_IniGooBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pri_IniGooBinding = ActivityPrivInicioGoogleBinding.inflate(getLayoutInflater());
        setContentView(pri_IniGooBinding.getRoot());
    }
}