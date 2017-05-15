package com.example.ivansantamaria.appproffrontend;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProfesorVO extends PersonaVO{

    private String telefono = null;
    private String mail = null;
    private String ciudad = null;
    private ArrayList<String> horarios = null;
    private ArrayList<String> cursos = null;
    private ArrayList<String> asignaturas = null;
    private Double valoracion = -1.00;
    private String experiencia = null;
    private String modalidad = null;

    public ProfesorVO() { }
    public ProfesorVO (String nombreUsuario, String password, String telefono, String mail, String ciudad,
                       ArrayList<String> horarios, ArrayList<String> cursos,
                       ArrayList<String> asignaturas, Double valoracion, String experiencia,
                       String modalidad) {

        if (nombreUsuario != null) super.nombreUsuario = nombreUsuario;
        if (password != null) super.password = password;
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

    public ProfesorVO (JSONObject jsonObject) {
        try {
            if (jsonObject.has("userName")) super.nombreUsuario = jsonObject.getString("userName");
            if (jsonObject.has("password")) super.password = jsonObject.getString("password");
            if (jsonObject.has("telefono")) this.telefono = jsonObject.getString("telefono");
            if (jsonObject.has("mail")) this.mail = jsonObject.getString("mail");
            if (jsonObject.has("ciudad")) this.ciudad = jsonObject.getString("ciudad");
            if (jsonObject.has("horarios")) {
                horarios = new ArrayList<>();
                JSONArray jArray = jsonObject.getJSONArray("horarios");
                for (int i = 0; i < jArray.length(); i++) {
                    horarios.add(jArray.getString(i));
                }
            }
            if (jsonObject.has("cursos")) {
                cursos = new ArrayList<>();
                JSONArray jArray = jsonObject.getJSONArray("cursos");
                for (int i = 0; i < jArray.length(); i++) {
                    cursos.add(jArray.getString(i));
                }
            }
            if (jsonObject.has("asignaturas")) {
                asignaturas = new ArrayList<>();
                JSONArray jArray = jsonObject.getJSONArray("asignaturas");
                for (int i = 0; i < jArray.length(); i++) {
                    asignaturas.add(jArray.getJSONObject(i).getString("nombre"));
                }
            }
            if (jsonObject.has("valoracion")) this.valoracion = jsonObject.getDouble("valoracion");
            if (jsonObject.has("experiencia")) this.experiencia = jsonObject.getString("experiencia");
            if (jsonObject.has("modalidad")) this.modalidad = jsonObject.getString("modalidad");


        } catch (JSONException e) {e.printStackTrace();}
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Double getValoracion() {
        return valoracion;
    }
    public void setValoracion(Double valoracion) {
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
