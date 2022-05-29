package com.castraining.app_castraining_privada.api;

import com.castraining.app_castraining_privada.api.cursos.AcfCursos;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetallesCurso {

    @SerializedName("content")
    private Rendered acercaDelCurso;
    @SerializedName("acf")
    private AcfCursos datosCurso;
    @SerializedName("title")
    private Rendered titulo;
    private String link;
    @SerializedName("modalidad_curso")
    private List<Integer> modalidad;

    //Getter and setter

    public List<Integer> getModalidad() {
        return modalidad;
    }

    public void setModalidad(List<Integer> modalidad) {
        this.modalidad = modalidad;
    }

    public Rendered getAcercaDelCurso() {
        return acercaDelCurso;
    }

    public void setAcercaDelCurso(Rendered acercaDelCurso) {
        this.acercaDelCurso = acercaDelCurso;
    }

    public AcfCursos getDatosCurso() {
        return datosCurso;
    }

    public void setDatosCurso(AcfCursos datosCurso) {
        this.datosCurso = datosCurso;
    }

    public Rendered getTitulo() {
        return titulo;
    }

    public void setTitulo(Rendered titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
