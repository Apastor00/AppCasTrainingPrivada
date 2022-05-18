package com.castraining.app_castraining_privada.api.Interface;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiCasTraining {

    //Definimos los EndPoint
    String URL_CONVOCTATORIA = "convocatoria";
    String URL_CURSOS = "cursos";
    String URL_CONVOCATORIA_ID = "convocatoria/{id}";

    @GET(URL_CONVOCTATORIA) //Listado de las comvocatorias
    Call<JsonArray> getConvocatoria ();

    @GET(URL_CURSOS) //Listado de los cursos
    Call<JsonArray> getCursos();

    @GET(URL_CONVOCATORIA_ID)
    Call<JsonObject> getConvocatoriaid (@Path("id")int id);

    @GET(URL_CURSOS)
    Call<JsonArray> getCursosid (@Query("ID") int id);
}
