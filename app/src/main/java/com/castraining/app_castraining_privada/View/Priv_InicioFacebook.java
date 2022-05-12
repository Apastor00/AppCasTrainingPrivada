package com.castraining.app_castraining_privada.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.castraining.app_castraining_privada.databinding.ActivityPrivInicioFacebookBinding;

public class Priv_InicioFacebook extends AppCompatActivity {

    private ActivityPrivInicioFacebookBinding pri_IniFacBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pri_IniFacBinding = ActivityPrivInicioFacebookBinding.inflate(getLayoutInflater());
        setContentView(pri_IniFacBinding.getRoot());
    }
}