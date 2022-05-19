package com.castraining.app_castraining_privada.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class raizConvocatoria {

    private ArrayList<ConvocatoriaResponse> raiz;

    public ArrayList<ConvocatoriaResponse> getRaiz() {
        return raiz;
    }
    public void setRaiz(ArrayList<ConvocatoriaResponse> raiz) {
        this.raiz = raiz;
    }

    /*
    private List<ConvocatoriaResponse> raizConvocatoria;

    public List<ConvocatoriaResponse> getRaizConvocatoria() {
        return raizConvocatoria;
    }

    public void setRaizConvocatoria(List<ConvocatoriaResponse> raizConvocatoria) {
        this.raizConvocatoria = raizConvocatoria;
    }*/
}
