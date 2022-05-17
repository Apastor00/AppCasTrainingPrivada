package com.castraining.app_castraining_privada.model;

import com.google.gson.annotations.SerializedName;

public class Acf {

    @SerializedName("curso_convocatoria")
    CursoConvocatoria cursoConvocatoria;
    @SerializedName("inicio_convocatoria")
    String inicioConvocatoria;
    @SerializedName("fin_convocatoria")
    String finConvocatoria;
    @SerializedName("horario_convocatoria")
    String horario;
    @SerializedName("lugar_convocatoria")
    String lugarConvocatoria;
    @SerializedName("modalidad_convocatoria")
    String modalidad;
    String duracion;
    Turno turno;

    /** ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * Aquí añadimos los precios y los descuentos cuando se quiera implementar +
     ***+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/

}
