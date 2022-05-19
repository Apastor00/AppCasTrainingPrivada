package com.castraining.app_castraining_privada.api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ConvocatoriaResponse {

    @SerializedName("id") //Lo hacemos serialized por si quisiéramos cambiar nombre para tratar la variable
    private int id;
    @SerializedName("acf")
    private AcfConvocatoria acfConvocatoria;

    //Getter and setter

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public AcfConvocatoria getAcfConvocatoria() {
        return acfConvocatoria;
    }
    public void setAcfConvocatoria(AcfConvocatoria acfConvocatoria) {
        this.acfConvocatoria = acfConvocatoria;
    }
}
