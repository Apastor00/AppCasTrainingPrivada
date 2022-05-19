package com.castraining.app_castraining_privada.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.castraining.app_castraining_privada.api.AcfConvocatoria;
import com.castraining.app_castraining_privada.api.ConvocatoriaResponse;
import com.castraining.app_castraining_privada.api.DatosConvocatoria;
import com.castraining.app_castraining_privada.api.Interface.ApiCasTraining;
import com.castraining.app_castraining_privada.R;
import com.castraining.app_castraining_privada.api.raizConvocatoria;
import com.castraining.app_castraining_privada.databinding.ActivityPrivApiBinding;
import com.castraining.app_castraining_privada.model.CursoItineBootcamp;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrivApi extends AppCompatActivity implements View.OnClickListener{

    public static final String URL_BASE = "https://cas-training.com/wp-json/wp/v2/";

    ActivityPrivApiBinding privApiBinding;
    ArrayAdapter<String> adapter = null;

    //Retrofit
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        privApiBinding = ActivityPrivApiBinding.inflate(getLayoutInflater());
        setContentView(privApiBinding.getRoot());

        privApiBinding.btnConvocatorias.setOnClickListener(this);
        privApiBinding.btnCursos.setOnClickListener(this);
        privApiBinding.btnBusquedaApi.setOnClickListener(this);
        
    }
    /*private void getConvocatoria() {
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
                    JsonObject jsonObject = response.body().get(i).getAsJsonObject().get("acf").getAsJsonObject();
                    //Clase para seleccionar si viene del itinerario, del curso o de bootcamp en la API
                    CursoItineBootcamp cursoItineBootcamp = new CursoItineBootcamp(jsonObject);
                    String title = cursoItineBootcamp.title();
                    /*JsonObject title = jsonObject.get("title").getAsJsonObject();
                    String bootcamp = title.get("rendered").getAsString();
                    listadoConvocatorias.add(title);
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
            }
        });
    }*/
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
                    String nombreCurso = title.get("rendered").getAsString();
                    listadoCursos.add(nombreCurso);
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
    private void getBusquedaApi(int id) {
        privApiBinding.progressBar.setVisibility(View.VISIBLE);
        privApiBinding.txtProgressBar.setVisibility(View.VISIBLE);
        privApiBinding.lstView.setVisibility(View.INVISIBLE);
        ArrayList<String> listadoBusqueda = new ArrayList<String>();
        //int id = Integer.parseInt(privApiBinding.edtxtBusqueda.toString());
        Retrofit retrofit = new Retrofit.Builder() //Creamos la instancia retrofit
                .baseUrl(URL_BASE) //Le indicamos la url base
                .addConverterFactory(GsonConverterFactory.create()) //Usamos la librería Gson para convertir la respuesta a un objeto JSON
                .build(); //Construimos el objeto retrofit

        ApiCasTraining apiCasTraining = retrofit.create(ApiCasTraining.class);

        Call<JsonObject> call = apiCasTraining.getConvocatoriaid(id);

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject jsonObject = response.body().getAsJsonObject();
                JsonObject cursoConvocatoria = jsonObject.get("acf").getAsJsonObject();
                CursoItineBootcamp cursoItineBootcamp = new CursoItineBootcamp(cursoConvocatoria);
                String title = cursoItineBootcamp.title();


                //JsonObject jsonObject = response.body().getAsJsonObject();
                //JsonObject acf = jsonObject.get("acf").getAsJsonObject();
                //String title = acf.get("cursoconvocatoria").getAsJsonObject().get("post_title").getAsString();
                listadoBusqueda.add(title);
                privApiBinding.progressBar.setVisibility(View.INVISIBLE);
                privApiBinding.txtProgressBar.setVisibility(View.INVISIBLE);
                privApiBinding.txtResultadoBusqueda.setVisibility(View.VISIBLE);
                if (response.isSuccessful()) {
                    privApiBinding.progressBar.setVisibility(View.INVISIBLE);
                    privApiBinding.txtProgressBar.setVisibility(View.INVISIBLE);
                    privApiBinding.lstView.setVisibility(View.VISIBLE);
                }
                adapter = new ArrayAdapter<String>(PrivApi.this, android.R.layout.simple_list_item_1, listadoBusqueda);
                privApiBinding.lstView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                //privApiBinding.txtApi.setText(t.getMessage());
            }
        });
    }
    private void getConvocatoria(){
        privApiBinding.progressBar.setVisibility(View.VISIBLE);
        privApiBinding.txtProgressBar.setVisibility(View.VISIBLE);
        privApiBinding.lstView.setVisibility(View.INVISIBLE);
        ArrayList<String> listadoConvocatorias = new ArrayList<String>();

        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        ApiCasTraining apiCasTraining = retrofit.create(ApiCasTraining.class);
        Call<raizConvocatoria> call = apiCasTraining.getConvocatoria();
        call.enqueue(new Callback<raizConvocatoria>() {
            @Override
            public void onResponse(Call<raizConvocatoria> call, Response<raizConvocatoria> response) {
                int sizeConvocatoria = response.body().getRaiz().size();
                for (int i=0;i<sizeConvocatoria;i++){
                    AcfConvocatoria acf = response.body().getRaiz().get(i).getAcfConvocatoria();
                    String horario = acf.getHorario();
                    listadoConvocatorias.add(horario);
                }
                if (response.isSuccessful()) {
                    privApiBinding.progressBar.setVisibility(View.INVISIBLE);
                    privApiBinding.txtProgressBar.setVisibility(View.INVISIBLE);
                    privApiBinding.lstView.setVisibility(View.VISIBLE);
                }
                adapter = new ArrayAdapter<String>(PrivApi.this,android.R.layout.simple_list_item_1, listadoConvocatorias);
                privApiBinding.lstView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<raizConvocatoria> call, Throwable t) {

            }
        });
    }



/*
    private void getConvocatoria() {
        privApiBinding.progressBar.setVisibility(View.VISIBLE);
        privApiBinding.txtProgressBar.setVisibility(View.VISIBLE);
        privApiBinding.lstView.setVisibility(View.INVISIBLE);
        ArrayList<String> listadoConvocatorias = new ArrayList<String>();

        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        ApiCasTraining apiCasTraining = retrofit.create(ApiCasTraining.class);
        Call<List<raizConvocatoria>> call = apiCasTraining.getConvocatoria();
        call.enqueue(new Callback<List<raizConvocatoria>>() {
            @Override
            public void onResponse(Call<List<raizConvocatoria>> call, Response<List<raizConvocatoria>> response) {
                int sizeResponse = response.body().size();
                List<ConvocatoriaResponse> convocatoria = null;
                List<AcfConvocatoria> acf = null;
                for (int i=0;i<sizeResponse;i++){
                    convocatoria = response.body().get(i).getRaizConvocatoria();
                    acf = convocatoria.get(i).getAcfConvocatoria();
                    List<DatosConvocatoria> detalles = acf.get(i).getDatosConvocatoria();
                    listadoConvocatorias.add(detalles.get(i).getTitle());
                }
                adapter = new ArrayAdapter<String>(PrivApi.this, android.R.layout.simple_list_item_1,listadoConvocatorias);
                privApiBinding.lstView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<raizConvocatoria>> call, Throwable t) {

            }
        });

    }
*/
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnConvocatorias:
                getConvocatoria();
                break;
            case R.id.btnCursos:
                getCursos();
                break;
            case R.id.btnBusquedaApi:
                int id = Integer.parseInt(privApiBinding.edtxtBusqueda.getText().toString());
                getBusquedaApi(id);
                break;
            default:
                break;
        }
    }
}