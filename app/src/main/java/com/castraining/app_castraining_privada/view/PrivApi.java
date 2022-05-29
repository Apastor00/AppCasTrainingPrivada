package com.castraining.app_castraining_privada.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.castraining.app_castraining_privada.adapter.ConvocatoriaAdapter;
import com.castraining.app_castraining_privada.adapter.CursosAdapter;
import com.castraining.app_castraining_privada.api.DetallesCurso;
import com.castraining.app_castraining_privada.api.convocatoria.AcfConvocatoria;
import com.castraining.app_castraining_privada.api.cursos.AcfCursos;
import com.castraining.app_castraining_privada.api.convocatoria.ConvocatoriaResponse;
import com.castraining.app_castraining_privada.api.cursos.CursosResponse;
import com.castraining.app_castraining_privada.api.DatosConvocatoria;
import com.castraining.app_castraining_privada.api.Interface.ApiCasTraining;
import com.castraining.app_castraining_privada.R;
import com.castraining.app_castraining_privada.api.DatosLstview;
import com.castraining.app_castraining_privada.api.LlamadaApi;
import com.castraining.app_castraining_privada.databinding.ActivityPrivApiBinding;
import com.castraining.app_castraining_privada.model.CursoItineBootcamp;
import com.castraining.app_castraining_privada.model.CursoItineriarioBootcamp;
import com.castraining.app_castraining_privada.model.RcyViewDatosConvocatoria;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrivApi extends AppCompatActivity implements View.OnClickListener{

    public static final String URL_BASE = "https://cas-training.com/wp-json/wp/v2/";

    ActivityPrivApiBinding privApiBinding;

    //Adapter de los RecyclerView
    private RecyclerView.Adapter adapterConvocatoria = null;
    private RecyclerView.Adapter adapterCursos = null;

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
    private void getConvocatoria(){
        privApiBinding.progressBar.setVisibility(View.VISIBLE);
        privApiBinding.txtProgressBar.setVisibility(View.VISIBLE);
        privApiBinding.rcyView.setVisibility(View.INVISIBLE);
        ArrayList<RcyViewDatosConvocatoria> listadoConvocatorias = new ArrayList<RcyViewDatosConvocatoria>();

        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        ApiCasTraining apiCasTraining = retrofit.create(ApiCasTraining.class);
        Call<List<ConvocatoriaResponse>> call = apiCasTraining.getConvocatoria();
        call.enqueue(new Callback<List<ConvocatoriaResponse>>() {
            @Override
            public void onResponse(Call<List<ConvocatoriaResponse>> call, Response<List<ConvocatoriaResponse>> response) {
                List<ConvocatoriaResponse> convocatoriaResponses = response.body();

                for (int i = 0; i<response.body().size();i++){
                    ConvocatoriaResponse convocatoriaResponse = convocatoriaResponses.get(i);
                    AcfConvocatoria acf = convocatoriaResponse.getAcfConvocatoria();
                    CursoItineriarioBootcamp cursoItineriarioBootcamp = new CursoItineriarioBootcamp(acf);
                    String title = cursoItineriarioBootcamp.title();
                    int id = convocatoriaResponse.getId();
                    listadoConvocatorias.add(new RcyViewDatosConvocatoria(id, title));
                }
                if (response.isSuccessful()) {
                    privApiBinding.progressBar.setVisibility(View.INVISIBLE);
                    privApiBinding.txtProgressBar.setVisibility(View.INVISIBLE);
                    privApiBinding.rcyView.setVisibility(View.VISIBLE);
                }
                adapterConvocatoria = new ConvocatoriaAdapter (listadoConvocatorias);
                privApiBinding.rcyView.setLayoutManager(new LinearLayoutManager(PrivApi.this));
                privApiBinding.rcyView.setHasFixedSize(true);
                privApiBinding.rcyView.setAdapter(adapterConvocatoria);

            }

            @Override
            public void onFailure(Call<List<ConvocatoriaResponse>> call, Throwable t) {
                Log.d("Response convocatoria:" ,t.getMessage());

            }
        });
    }
    private void getCursos() {
        privApiBinding.progressBar.setVisibility(View.VISIBLE);
        privApiBinding.txtProgressBar.setVisibility(View.VISIBLE);
        privApiBinding.rcyView.setVisibility(View.INVISIBLE);
        //ArrayList<DatosLstview> listadoCursos = new ArrayList<DatosLstview>();
        ArrayList<RcyViewDatosConvocatoria> listadoCursos = new ArrayList<RcyViewDatosConvocatoria>();
        Retrofit retrofit = new Retrofit.Builder() //Creamos la instancia retrofit
                .baseUrl(URL_BASE) //Le indicamos la url base
                .addConverterFactory(GsonConverterFactory.create()) //Usamos la librería Gson para convertir la respuesta a un objeto JSON
                .build(); //Construimos el objeto retrofit

        ApiCasTraining apiCasTraining = retrofit.create(ApiCasTraining.class);

        Call<List<CursosResponse>> call = apiCasTraining.getCursos();

        call.enqueue(new Callback<List<CursosResponse>>() {
            @Override
            public void onResponse(Call<List<CursosResponse>> call, Response<List<CursosResponse>> response) {
                List<CursosResponse> cursosResponses = response.body();
                for (int i = 0; i < response.body().size(); i++) {
                    CursosResponse cursoResponse = cursosResponses.get(i);
                    AcfCursos acf = cursoResponse.getAcfCursos();
                    int id = cursoResponse.getId();
                    String title = cursoResponse.getTitle().getRendered();
                    listadoCursos.add(new RcyViewDatosConvocatoria(id, title));
                }
                if (response.isSuccessful()) {
                    privApiBinding.progressBar.setVisibility(View.INVISIBLE);
                    privApiBinding.txtProgressBar.setVisibility(View.INVISIBLE);
                    privApiBinding.rcyView.setVisibility(View.VISIBLE);
                }
                adapterCursos = new CursosAdapter(listadoCursos);
                privApiBinding.rcyView.setLayoutManager(new LinearLayoutManager(PrivApi.this));
                privApiBinding.rcyView.setAdapter(adapterCursos);

                /**
                //adapterCursos = new ArrayAdapter<DatosLstview>(PrivApi.this, android.R.layout.simple_list_item_1,listadoCursos);
                adapterCursos = new ArrayAdapter<DatosLstview>(PrivApi.this, android.R.layout.simple_list_item_1, listadoCursos);
                privApiBinding.lstView.setAdapter(adapterCursos);
                privApiBinding.lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(PrivApi.this, PrivDetallesCurso.class);
                        intent.putExtra("id", listadoCursos.get(i).getId());
                        intent.putExtra("title", listadoCursos.get(i).getTitle());
                        startActivity(intent);
                    }
                });*/

            }
            @Override
            public void onFailure(Call<List<CursosResponse>> call, Throwable t) {
                Log.d("Response curso: ",t.getMessage() );
            }
        });
    }
    private void getBusquedaApi(int id) {
        Intent intent = new Intent(PrivApi.this, PrivDetallesCurso.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

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