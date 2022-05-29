package com.castraining.app_castraining_privada.model;

import static com.castraining.app_castraining_privada.view.PrivApi.URL_BASE;

import android.util.Log;

import com.castraining.app_castraining_privada.api.Interface.ApiCasTraining;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DatosCurso {


    private String linkCurso,
            tituloCurso,
            acercaDeCurso,
            dirigidoA,
            objetivosCurso,
            contentidosCurso,
            requisitosCurso,
            materialCurso,
            perfilDocenteCurso,
            certificacionCurso;

    public DatosCurso () {}

    public DatosCurso (String linkCurso, String tituloCurso, String acercaDeCurso, String dirigidoA,
                      String objetivosCurso, String contentidosCurso, String requisitosCurso, String materialCurso,
                      String perfilDocenteCurso, String certificacionCurso) {
        this.linkCurso = linkCurso;
        this.tituloCurso = tituloCurso;
        this.acercaDeCurso = acercaDeCurso;
        this.dirigidoA = dirigidoA;
        this.objetivosCurso = objetivosCurso;
        this.contentidosCurso = contentidosCurso;
        this.requisitosCurso = requisitosCurso;
        this.materialCurso = materialCurso;
        this.perfilDocenteCurso = perfilDocenteCurso;
        this.certificacionCurso = certificacionCurso;
    }
    public HashMap<String, String> llamadaCurso (int id) {
        HashMap<String, String> hashMap = new HashMap<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiCasTraining apiCasTraining = retrofit.create(ApiCasTraining.class);
        /*Call<JsonObject> call = apiCasTraining.getCursosid(id);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject jsonObject = response.body().getAsJsonObject();
                JsonObject acf = jsonObject.get("acf").getAsJsonObject();
                linkCurso = jsonObject.get("link").getAsString();
                tituloCurso = jsonObject.get("title").getAsJsonObject().get("rendered").getAsString();
                acercaDeCurso = jsonObject.get("content").getAsJsonObject().get("rendered").getAsString();
                dirigidoA = acf.get("audiencia_curso").getAsString();
                objetivosCurso = acf.get("objetivos_curso").getAsString();
                contentidosCurso = acf.get("contenidos_curso").getAsString();
                requisitosCurso = acf.get("requisitos_del_curso").getAsString();
                materialCurso = acf.get("materiales_del_curso").getAsString();
                perfilDocenteCurso = acf.get("perfil_del_docente").getAsString();
                certificacionCurso = acf.get("certificacion-detalle").getAsString();
                hashMap.put("linkCurso", linkCurso);
                hashMap.put("tituloCurso", tituloCurso);
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d ("Error DatoCurso", t.getMessage());
            }
        });*/
        return hashMap;
    }

    //Getter y setter

    public String getLinkCurso() {
        return linkCurso;
    }

    public void setLinkCurso(String linkCurso) {
        this.linkCurso = linkCurso;
    }

    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    public String getAcercaDeCurso() {
        return acercaDeCurso;
    }

    public void setAcercaDeCurso(String acercaDeCurso) {
        this.acercaDeCurso = acercaDeCurso;
    }

    public String getDirigidoA() {
        return dirigidoA;
    }

    public void setDirigidoA(String dirigidoA) {
        this.dirigidoA = dirigidoA;
    }

    public String getObjetivosCurso() {
        return objetivosCurso;
    }

    public void setObjetivosCurso(String objetivosCurso) {
        this.objetivosCurso = objetivosCurso;
    }

    public String getContentidosCurso() {
        return contentidosCurso;
    }

    public void setContentidosCurso(String contentidosCurso) {
        this.contentidosCurso = contentidosCurso;
    }

    public String getRequisitosCurso() {
        return requisitosCurso;
    }

    public void setRequisitosCurso(String requisitosCurso) {
        this.requisitosCurso = requisitosCurso;
    }

    public String getMaterialCurso() {
        return materialCurso;
    }

    public void setMaterialCurso(String materialCurso) {
        this.materialCurso = materialCurso;
    }

    public String getPerfilDocenteCurso() {
        return perfilDocenteCurso;
    }

    public void setPerfilDocenteCurso(String perfilDocenteCurso) {
        this.perfilDocenteCurso = perfilDocenteCurso;
    }

    public String getCertificacionCurso() {
        return certificacionCurso;
    }

    public void setCertificacionCurso(String certificacionCurso) {
        this.certificacionCurso = certificacionCurso;
    }
}
