package com.castraining.app_castraining_privada.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConvocatoriaResponse {

    @SerializedName("id") //Lo hacemos serialized por si quisiéramos cambiar nombre para tratar la variable
    int id;
    @SerializedName("acf")
    List<AcfConvocatoria> datosConvocatoria;


    //Getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AcfConvocatoria> getDatosConvocatoria() {
        return datosConvocatoria;
    }

    public void setDatosConvocatoria(List<AcfConvocatoria> datosConvocatoria) {
        this.datosConvocatoria = datosConvocatoria;
    }
}
