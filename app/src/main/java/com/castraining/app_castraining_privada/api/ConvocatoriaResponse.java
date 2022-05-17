package com.castraining.app_castraining_privada.api;

import com.castraining.app_castraining_privada.model.Acf;
import com.castraining.app_castraining_privada.model.Title;
import com.google.gson.annotations.SerializedName;

public class ConvocatoriaResponse {

    @SerializedName("id") //Lo hacemos serialized por si quisiéramos cambiar nombre para tratar la variable
    int id;
    @SerializedName("title")
    Title title;
    @SerializedName("acf")
    Acf acf;


    //Getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Acf getAcf() {
        return acf;
    }

    public void setAcf(Acf acf) {
        this.acf = acf;
    }
}
