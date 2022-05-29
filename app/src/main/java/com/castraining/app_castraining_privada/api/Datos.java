package com.castraining.app_castraining_privada.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.CertPathTrustManagerParameters;

public class Datos {

    @SerializedName("post_content")
    private String descripcion;
    @SerializedName("post_title")
    private String title;
    @SerializedName("post_type")
    private String tipo;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /*
    private List<ConvocatoriaResponse> Datos;

    public List<ConvocatoriaResponse> getRaizConvocatoria() {
        return Datos;
    }

    public void setRaizConvocatoria(List<ConvocatoriaResponse> Datos) {
        this.Datos = Datos;
    }*/
}
