package com.castraining.app_castraining_privada.api;

import com.google.gson.annotations.SerializedName;

public class TurnoConvocatoria {

    @SerializedName("name")
    String turno;

    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
}
