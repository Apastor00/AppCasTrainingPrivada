package com.castraining.app_castraining_privada.api.cursos;

import com.castraining.app_castraining_privada.api.Rendered;
import com.google.gson.annotations.SerializedName;

public class CursosResponse {

    private int id;
    private String link;
    private Rendered title;
    @SerializedName("content")
    private Rendered acercaDelCurso;
    @SerializedName("acf")
    private AcfCursos acfCursos;


    //Getter and Setter




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Rendered getTitle() {
        return title;
    }

    public void setTitle(Rendered title) {
        this.title = title;
    }

    public Rendered getAcercaDelCurso() {
        return acercaDelCurso;
    }

    public void setAcercaDelCurso(Rendered acercaDelCurso) {
        this.acercaDelCurso = acercaDelCurso;
    }

    public AcfCursos getAcfCursos() {
        return acfCursos;
    }

    public void setAcfCursos(AcfCursos acfCursos) {
        this.acfCursos = acfCursos;
    }
}
