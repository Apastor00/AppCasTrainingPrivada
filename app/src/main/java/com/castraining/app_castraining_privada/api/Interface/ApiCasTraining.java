package com.castraining.app_castraining_privada.api.Interface;

import com.castraining.app_castraining_privada.api.DetallesCurso;
import com.castraining.app_castraining_privada.api.convocatoria.ConvocatoriaResponse;
import com.castraining.app_castraining_privada.api.cursos.CursosResponse;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiCasTraining {

    //Definimos los EndPoint
    String URL_CONVOCTATORIA = "convocatoria";
    String URL_CURSOS = "cursos";
    String URL_CONVOCATORIA_ID = "convocatoria/{id}";
    String URL_CURSOS_ID = "cursos/{id}";

    @GET(URL_CONVOCTATORIA) //Listado de las comvocatorias
    Call<List<ConvocatoriaResponse>> getConvocatoria ();

    @GET(URL_CURSOS) //Listado de los cursos
    Call<List<CursosResponse>> getCursos();

    @GET(URL_CONVOCATORIA_ID)
    Call<List<ConvocatoriaResponse>> getConvocatoriaid (@Path("id")int id);

    @GET(URL_CURSOS_ID)
    Call<DetallesCurso> getCursosid (@Path("id") int id);
}
