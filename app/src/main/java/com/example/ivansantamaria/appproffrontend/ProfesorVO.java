package com.example.ivansantamaria.appproffrontend;

import java.util.ArrayList;

public class ProfesorVO {

    private String nombreUsuario = null;
    private String telefono = null;
    private String mail = null;
    private String ciudad = null;
    private ArrayList<String> horarios = null;
    private ArrayList<String> cursos = null;
    private ArrayList<String> asignaturas = null;
    private Float valoracion = -1.0f;
    private String experiencia = null;
    private String modalidad = null;

    public ProfesorVO (String nombreUsuario, String telefono, String mail, String ciudad,
                       ArrayList<String> horarios, ArrayList<String> cursos,
                       ArrayList<String> asignaturas, Float valoracion, String experiencia,
                       String modalidad) {

        if (nombreUsuario != null) this.nombreUsuario = nombreUsuario;
        if (telefono != null) this.telefono = telefono;
        if (mail != null) this.mail = mail;
        if (ciudad != null) this.ciudad = ciudad;
        if (horarios != null) this.horarios = horarios;
        if (cursos != null) this.cursos = cursos;
        if (asignaturas != null) this.asignaturas = asignaturas;
        if (valoracion != -1.0f) this.valoracion = valoracion;
        if (experiencia != null) this.experiencia = experiencia;
        if (modalidad != null) this.modalidad = modalidad;

    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<String> horarios) {
        this.horarios = horarios;
    }

    public ArrayList<String> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<String> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Float getValoracion() {
        return valoracion;
    }

    public void setValoracion(Float valoracion) {
        this.valoracion = valoracion;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
}
