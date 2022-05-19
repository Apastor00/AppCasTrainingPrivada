package com.castraining.app_castraining_privada.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AcfConvocatoria {

    @SerializedName("curso_convocatoria")
    DatosConvocatoria datosConvocatoria;
    @SerializedName("itinerario_convocatoria")
    DatosConvocatoria itinerarioConvocatoria;
    @SerializedName("bootcamp")
    DatosConvocatoria bootcamp;
    @SerializedName("inicio_convocatoria")
    String fechaInicio ;
    @SerializedName("fin_convocatoria")
    String fechaFin;
    @SerializedName("horario_convocatoria")
    String horario;
    @SerializedName("lugar_convocatoria")
    String lugarConvocatoria;
    @SerializedName("modalidad_convocatoria")
    String modalidad;
    String duracion;
    TurnoConvocatoria turno;
    /**+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     + Aquí añadimos los precios y los descuentos cuando se quiera implementar +
     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++**/

    //Getter and Setter


    public DatosConvocatoria getDatosConvocatoria() {
        return datosConvocatoria;
    }

    public void setDatosConvocatoria(DatosConvocatoria datosConvocatoria) {
        this.datosConvocatoria = datosConvocatoria;
    }

    public DatosConvocatoria getItinerarioConvocatoria() {
        return itinerarioConvocatoria;
    }

    public void setItinerarioConvocatoria(DatosConvocatoria itinerarioConvocatoria) {
        this.itinerarioConvocatoria = itinerarioConvocatoria;
    }

    public DatosConvocatoria getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(DatosConvocatoria bootcamp) {
        this.bootcamp = bootcamp;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLugarConvocatoria() {
        return lugarConvocatoria;
    }

    public void setLugarConvocatoria(String lugarConvocatoria) {
        this.lugarConvocatoria = lugarConvocatoria;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public TurnoConvocatoria getTurno() {
        return turno;
    }

    public void setTurno(TurnoConvocatoria turno) {
        this.turno = turno;
    }
}

