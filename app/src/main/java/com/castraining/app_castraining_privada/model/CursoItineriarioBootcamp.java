package com.castraining.app_castraining_privada.model;

import com.castraining.app_castraining_privada.api.convocatoria.AcfConvocatoria;
import com.google.gson.internal.LinkedTreeMap;

public class CursoItineriarioBootcamp {

    private AcfConvocatoria acf;

    public CursoItineriarioBootcamp(){}

    public CursoItineriarioBootcamp(AcfConvocatoria acf){
        this.acf = acf;
    }
    public String title(){
        String select = SelectCursoItinerarioBootcamp(acf);
        String titulo = "";
        switch (select){
            case "curso":
                Object curso = acf.getDatosConvocatoria();
                LinkedTreeMap<Object, Object> arbolCurso = (LinkedTreeMap) curso;
                titulo = arbolCurso.get("post_title").toString();
                break;
            case "itinerario":
                Object itinerario = acf.getItinerarioConvocatoria();
                LinkedTreeMap<Object, Object> arbolItinerario = (LinkedTreeMap) itinerario;
                titulo = arbolItinerario.get("post_title").toString();
                break;
            case "bootcamp":
                Object bootcamp = acf.getBootcamp();
                LinkedTreeMap<Object, Object> arbolBootcamp = (LinkedTreeMap) bootcamp;
                titulo = arbolBootcamp.get("post_title").toString();
                break;
            default:
                break;
        }
        return titulo;
    }
    public String SelectCursoItinerarioBootcamp(AcfConvocatoria acf){
        String select = "";
        if (acf.getDatosConvocatoria().equals(false) && acf.getItinerarioConvocatoria().equals(false)){
            select = "bootcamp";
        }else if (acf.getDatosConvocatoria().equals(false) && acf.getBootcamp().equals(false)){
            select = "itinerario";
        }else select = "curso";
        return select;
    }
}
