package com.castraining.app_castraining_privada.model;

public class RcyViewDatosConvocatoria {
    private String title;
    private int id;

    public RcyViewDatosConvocatoria () {}

    public RcyViewDatosConvocatoria (int id, String title)
    {
        this.id = id;
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override //Sobreescribimos este método para que nos devuelva un String y no la dirección de memoria
    public String toString() {
        return title;
    }
}
