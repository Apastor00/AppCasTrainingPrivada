package com.castraining.app_castraining_privada.model;

import com.google.gson.annotations.SerializedName;

public class CursoConvocatoria {

    @SerializedName("ID")
    int id;
    @SerializedName("post_content")
    String descripcion;
    @SerializedName("post_title")
    String titleCurso;
    @SerializedName("post_status")
    String estado;

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

    public String getTitleCurso() {
        return titleCurso;
    }

    public void setTitleCurso(String titleCurso) {
        this.titleCurso = titleCurso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
