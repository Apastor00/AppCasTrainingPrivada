package com.castraining.app_castraining_privada.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.castraining.app_castraining_privada.databinding.ActivityPrivInicioAppleBinding;

public class Priv_InicioApple extends AppCompatActivity {

    private ActivityPrivInicioAppleBinding pri_IniAppBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pri_IniAppBinding = ActivityPrivInicioAppleBinding.inflate(getLayoutInflater());
        setContentView(pri_IniAppBinding.getRoot());
    }
}