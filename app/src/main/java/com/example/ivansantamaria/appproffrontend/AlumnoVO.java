package com.example.ivansantamaria.appproffrontend;

public class AlumnoVO {

    private String nombreUsuario = null;
    private String password = null;

    public AlumnoVO(String nombreUsuario, String password) {

        if (nombreUsuario != null) this.nombreUsuario = nombreUsuario;
        if (password != null) this.password = password;

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
    public void setPassword(String telefono) {
        this.password = password;
    }

}
