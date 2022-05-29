package com.castraining.app_castraining_privada.api.convocatoria;

import com.castraining.app_castraining_privada.api.convocatoria.AcfConvocatoria;
import com.google.gson.annotations.SerializedName;

public class ConvocatoriaResponse {

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
