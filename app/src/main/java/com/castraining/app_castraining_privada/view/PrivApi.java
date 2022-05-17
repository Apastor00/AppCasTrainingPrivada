package com.castraining.app_castraining_privada.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.JsonReader;
import android.view.View;
import android.widget.ArrayAdapter;

import com.castraining.app_castraining_privada.Interface.ApiCasTraining;
import com.castraining.app_castraining_privada.R;
import com.castraining.app_castraining_privada.databinding.ActivityPrivApiBinding;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrivApi extends AppCompatActivity {

    public static final String URL_BASE = "https://cas-training.com/wp-json/wp/v2/";

    ActivityPrivApiBinding privApiBinding;

    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        privApiBinding = ActivityPrivApiBinding.inflate(getLayoutInflater());
        setContentView(privApiBinding.getRoot());

        privApiBinding.btnConvocatorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConvocatoria();
            }
        });
        privApiBinding.btnCursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCursos();
            }
        });
    }
    private void getConvocatoria() {
        privApiBinding.progressBar.setVisibility(View.VISIBLE);
        privApiBinding.txtProgressBar.setVisibility(View.VISIBLE);
        privApiBinding.lstView.setVisibility(View.INVISIBLE);
        ArrayList<String> listadoConvocatorias = new ArrayList<String>();
        Retrofit retrofit = new Retrofit.Builder() //Creamos la instancia retrofit
                .baseUrl(URL_BASE) //Le indicamos la url base
                .addConverterFactory(GsonConverterFactory.create()) //Usamos la librería Gson para convertir la respuesta a un objeto JSON
                .build(); //Construimos el objeto retrofit

        ApiCasTraining apiCasTraining = retrofit.create(ApiCasTraining.class);

        Call<JsonArray> call = apiCasTraining.getConvocatoria();

        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                int numeroConvocatorias = response.body().size();
                for (int i= 0; i<numeroConvocatorias;i++){
                    JsonObject jsonObject = response.body().get(i).getAsJsonObject();
                    JsonObject title = jsonObject.get("title").getAsJsonObject();
                    String bootcamp = title.get("rendered").toString();
                    listadoConvocatorias.add(bootcamp);
                    //listadoConvocatorias.add(jsonObject.get("title").getAsJsonObject().get("rendered").toString());
                    if (numeroConvocatorias == listadoConvocatorias.size()){
                        privApiBinding.progressBar.setVisibility(View.INVISIBLE);
                        privApiBinding.txtProgressBar.setVisibility(View.INVISIBLE);
                        privApiBinding.lstView.setVisibility(View.VISIBLE);}
                }
                adapter = new ArrayAdapter<String>(PrivApi.this, android.R.layout.simple_list_item_1,listadoConvocatorias);
                privApiBinding.lstView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                //privApiBinding.txtApi.setText(t.getMessage());
            }
        });
    }
    private void getCursos() {
        privApiBinding.progressBar.setVisibility(View.VISIBLE);
        privApiBinding.txtProgressBar.setVisibility(View.VISIBLE);
        privApiBinding.lstView.setVisibility(View.INVISIBLE);
        ArrayList<String> listadoCursos = new ArrayList<String>();
        Retrofit retrofit = new Retrofit.Builder() //Creamos la instancia retrofit
                .baseUrl(URL_BASE) //Le indicamos la url base
                .addConverterFactory(GsonConverterFactory.create()) //Usamos la librería Gson para convertir la respuesta a un objeto JSON
                .build(); //Construimos el objeto retrofit

        ApiCasTraining apiCasTraining = retrofit.create(ApiCasTraining.class);

        Call<JsonArray> call = apiCasTraining.getCursos();

        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                int numeroCursos = response.body().size();
                for (int i= 0; i<numeroCursos;i++){
                    JsonObject jsonObject = response.body().get(i).getAsJsonObject();
                    JsonObject title = jsonObject.get("title").getAsJsonObject();
                    String nombreCurso = title.get("rendered").toString();
                    listadoCursos.add(nombreCurso);
                    //listadoConvocatorias.add(jsonObject.get("title").getAsJsonObject().get("rendered").toString());
                    if (numeroCursos == listadoCursos.size()){
                        privApiBinding.progressBar.setVisibility(View.INVISIBLE);
                        privApiBinding.txtProgressBar.setVisibility(View.INVISIBLE);
                        privApiBinding.lstView.setVisibility(View.VISIBLE);}
                }
                adapter = new ArrayAdapter<String>(PrivApi.this, android.R.layout.simple_list_item_1,listadoCursos);
                privApiBinding.lstView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                //privApiBinding.txtApi.setText(t.getMessage());

            }
        });
    }

}