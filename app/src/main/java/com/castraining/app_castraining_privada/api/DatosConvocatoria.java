package com.castraining.app_castraining_privada.api;

import com.google.gson.annotations.SerializedName;

public class DatosConvocatoria {

    @SerializedName("ID")
    int id;
    @SerializedName("post_content")
    String descripcion;
    @SerializedName("post_title")
    String title;
    @SerializedName("post_type")
    String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
