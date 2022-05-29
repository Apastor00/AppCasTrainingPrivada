package com.castraining.app_castraining_privada.model;

import com.google.gson.JsonObject;

public class CursoItineBootcamp {

    private JsonObject acf;
    private JsonObject convocatoria;

    public CursoItineBootcamp(){}

    public CursoItineBootcamp(JsonObject convocatoria, JsonObject acf){
        this.convocatoria = convocatoria;
        this.acf = acf;
    }
    public String title(){
        String title = SelecCurItiBoot(acf).get("post_title").getAsString();
        return title;
    }
    public int id (){
        int id = idSelect(convocatoria);
        return id;
    }
    private JsonObject SelecCurItiBoot(JsonObject acf){
        JsonObject jsonObject = null;
        if (acf.get("curso_convocatoria").isJsonObject()){
            jsonObject = acf.get("curso_convocatoria").getAsJsonObject();
        } else if (acf.get("itinerario_convocatoria").isJsonObject()){
            jsonObject = acf.get("itinerario_convocatoria").getAsJsonObject();
        } else if (acf.get("bootcamp").isJsonObject()){
            jsonObject = acf.get("bootcamp").getAsJsonObject();
        }
        return jsonObject;
    }
    private int idSelect (JsonObject convocatoria){
        int id = convocatoria.get("id").getAsInt();
        return id;
    }
}
