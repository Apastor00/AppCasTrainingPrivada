package com.castraining.app_castraining_privada;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.castraining.app_castraining_privada.view.PrivInicioApple;
import com.castraining.app_castraining_privada.view.PrivInicioFacebook;
import com.castraining.app_castraining_privada.databinding.ActivityPrivMainBinding;
import com.castraining.app_castraining_privada.view.PrivInicioMail;
import com.castraining.app_castraining_privada.view.PrivNuevoUsuario;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PrivMainActivity extends AppCompatActivity {

    private ActivityPrivMainBinding privMainBinding;

    //Variables fijas
    public static final int RC_SIGN_IN = 9001;
    public static final String TAG = "GoogleActivity";

    //Declaramos la variable auth de Firebase
    private FirebaseAuth mAuth;
    //Declaramos Google Sign
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        privMainBinding = ActivityPrivMainBinding.inflate(getLayoutInflater());
        setContentView(privMainBinding.getRoot());
        //Inicializamos la instancia de Firebase
        mAuth = FirebaseAuth.getInstance();
        //Inicializamos las credenciales de google
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);

        //Listener de los botones
        privMainBinding.btnInicioCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = privMainBinding.edtxtLoginMail.getText().toString();
                String password = privMainBinding.edtxtLoginPassword.getText().toString();
                InicioSesionCorreo(mail, password);
            }
        });
        privMainBinding.btnNuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrivMainActivity.this, PrivNuevoUsuario.class);
                if (privMainBinding.edtxtLoginMail.getText().toString().isEmpty()){
                    startActivity(i);
                } else {
                    String usuario = privMainBinding.edtxtLoginMail.getText().toString();
                    i.putExtra("usuario", usuario);
                    startActivity(i);
                }
            }
        });
        privMainBinding.btnInicioGoogle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                inicioSesionGoogle();
            }
        });
        privMainBinding.btnInicioApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inicioSesion = "Iniciada sesión con Cuenta Apple";
                InicioSesionApple(inicioSesion);
            }
        });
        privMainBinding.btnInicioFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inicioSesion = "Iniciada sesión con Cuenta Facebook";
                InicioSesionFacebook(inicioSesion);
            }
        });
    }
    /************************** Autentificación con Google ********************/
    //Método que iniciamos al pulsar el botón de inicio sesión en google.
    private void inicioSesionGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        //Nos abre el OnTap de inicio de sesión de Google
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
            Intent i = new Intent(PrivMainActivity.this, PrivInicioMail.class);
            i.putExtra("usuario", account.getEmail());
            i.putExtra("loginOk", "Login de Google ya autenticado");
            startActivity(i);
        } else {
            Log.w(TAG, "Fallo requestCode");
        }
    }
    /****************************** Fin Autenticación Google ****************************/
    //En el onStart de la actividad comprobamos si había iniciado sesión en google anteriormente
    @Override
    protected void onStart() {
        super.onStart();
        //Comprobamos si ya hay un usuario logeado anteriormente en google
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        //Elegimos las opciones según exista un usuario logueado o no en google
        if (account != null){
            //Actulizamos la UI
            updateUI(account);
            Intent i = new Intent(PrivMainActivity.this, PrivInicioMail.class);
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


    //Métodos que llaman a cada Intent según el botón pulsado
    private void InicioSesionApple(String inicioSesion) {
        Intent i = new Intent(this, PrivInicioApple.class );
        i.putExtra("incioSesion", inicioSesion);
        startActivity(i);
    }
    private void InicioSesionCorreo(String mail, String password) {
        mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            String loginOk = "Autentificación correcta";
                            FirebaseUser firebaseUser = mAuth.getCurrentUser();
                            updateUIFirebase(firebaseUser);
                            Intent i = new Intent(PrivMainActivity.this, PrivInicioMail.class);
                            i.putExtra("usuario", mail);
                            i.putExtra("loginOk", loginOk);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(PrivMainActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }
    private void updateUIFirebase(FirebaseUser currentUser) { }

    private void InicioSesionFacebook(String inicioSesion) {
        Intent i = new Intent(this, PrivInicioFacebook.class );
        i.putExtra("incioSesion", inicioSesion);
        startActivity(i);
    }


}