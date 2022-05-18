package com.castraining.app_castraining_privada.model;

import com.google.gson.JsonObject;

public class CursoItineBootcamp {

    private JsonObject jsonObject;

    public CursoItineBootcamp(){}

    public CursoItineBootcamp(JsonObject json){
        this.jsonObject = json;
    }
    public String title(){
        String title = SelecCurItiBoot(jsonObject).get("post_title").getAsString();
        return title;
    }

    public JsonObject SelecCurItiBoot(JsonObject acf){
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
}
