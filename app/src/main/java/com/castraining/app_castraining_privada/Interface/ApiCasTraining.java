package com.castraining.app_castraining_privada.Interface;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCasTraining {

    //Definimos los EndPoint
    String URL_CONVOCTATORIA = "convocatoria";
    String URL_CURSOS = "cursos";

    @GET(URL_CONVOCTATORIA) //Listado de las comvocatorias
    Call<JsonArray> getConvocatoria ();

    @GET(URL_CURSOS) //Listado de los cursos
    Call<JSONArray> getCursos();

    @GET(URL_CONVOCTATORIA)
    Call<JSONArray> getConvocatoriaid (@Query("id") int id);

    @GET(URL_CURSOS)
    Call<JSONArray> getCursosid (@Query("id") int id);
}
