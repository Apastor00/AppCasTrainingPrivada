package com.castraining.app_castraining_privada.api.convocatoria;

import com.castraining.app_castraining_privada.api.TurnoConvocatoria;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.List;

public class AcfConvocatoria<Datos> {

    @SerializedName("curso_convocatoria")
    private Datos datosConvocatoria;
    @SerializedName("itinerario_convocatoria")
    private Datos itinerarioConvocatoria;
    private Datos bootcamp;

    @SerializedName("inicio_convocatoria")
    private String fechaInicio ;
    @SerializedName("fin_convocatoria")
    private String fechaFin;
    @SerializedName("horario_convocatoria")
    private String horario;
    @SerializedName("lugar_convocatoria")
    private String lugarConvocatoria;
    @SerializedName("modalidad_convocatoria")
    private String modalidad;
    private String duracion;
    private List<TurnoConvocatoria> turno;

    /**+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     + Aquí añadimos los precios y los descuentos cuando se quiera implementar +
     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++**/

    //Getter and Setter



    public List<TurnoConvocatoria> getTurno() {
        return turno;
    }
    public void setTurno(List<TurnoConvocatoria> turno) {
        this.turno = turno;
    }

    public Datos getDatosConvocatoria() {
        return datosConvocatoria;
    }
    public void setDatosConvocatoria(Datos datosConvocatoria) {
        this.datosConvocatoria = datosConvocatoria;
    }

    public Datos getItinerarioConvocatoria() {
        return itinerarioConvocatoria;
    }

    public void setItinerarioConvocatoria(Datos itinerarioConvocatoria) {
        this.itinerarioConvocatoria = itinerarioConvocatoria;
    }

    public Datos getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(Datos bootcamp) {
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
}

