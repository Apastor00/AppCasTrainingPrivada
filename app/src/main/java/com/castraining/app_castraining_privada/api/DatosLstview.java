package com.castraining.app_castraining_privada.api;

public class DatosLstview {

    private String title;
    private int id;

    public DatosLstview(){}

    public DatosLstview(String title, int id){
        this.title = title;
        this.id = id;
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
