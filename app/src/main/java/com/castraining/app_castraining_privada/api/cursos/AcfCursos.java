package com.castraining.app_castraining_privada.api.cursos;

import com.google.gson.annotations.SerializedName;

public class AcfCursos {

    @SerializedName("duracion_curso")
    private String duracionCurso;
    @SerializedName("audiencia_curso")
    private String audienciaCurso;
    @SerializedName("objetivos_curso")
    private String objetivosCurso;
    @SerializedName("contenidos_curso")
    private String contenidosCurso;
    @SerializedName("requisitos_del_curso")
    private String requisitosCurso;
    @SerializedName("materiales_del_curso")
    private String materialCurso;
    @SerializedName("perfil_del_docente")
    private String docenteCurso;
    @SerializedName("certificacion-detalle")
    private String certificacionCurso;
    @SerializedName("examen_incluido")
    private String examenCursoIncluido;

    public String getDuracionCurso() {
        return duracionCurso;
    }

    public void setDuracionCurso(String duracionCurso) {
        this.duracionCurso = duracionCurso;
    }

    public String getAudienciaCurso() {
        return audienciaCurso;
    }

    public void setAudienciaCurso(String audienciaCurso) {
        this.audienciaCurso = audienciaCurso;
    }

    public String getObjetivosCurso() {
        return objetivosCurso;
    }

    public void setObjetivosCurso(String objetivosCurso) {
        this.objetivosCurso = objetivosCurso;
    }

    public String getContenidosCurso() {
        return contenidosCurso;
    }

    public void setContenidosCurso(String contenidosCurso) {
        this.contenidosCurso = contenidosCurso;
    }

    public String getRequisitosCurso() {
        return requisitosCurso;
    }

    public void setRequisitosCurso(String requisitosCurso) {
        this.requisitosCurso = requisitosCurso;
    }

    public String getMaterialCurso() {
        return materialCurso;
    }

    public void setMaterialCurso(String materialCurso) {
        this.materialCurso = materialCurso;
    }

    public String getDocenteCurso() {
        return docenteCurso;
    }

    public void setDocenteCurso(String docenteCurso) {
        this.docenteCurso = docenteCurso;
    }

    public String getCertificacionCurso() {
        return certificacionCurso;
    }

    public void setCertificacionCurso(String certificacionCurso) {
        this.certificacionCurso = certificacionCurso;
    }

    public String getExamenCursoIncluido() {
        return examenCursoIncluido;
    }

    public void setExamenCursoIncluido(String examenCursoIncluido) {
        this.examenCursoIncluido = examenCursoIncluido;
    }
}
