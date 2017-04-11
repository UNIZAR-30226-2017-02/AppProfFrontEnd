package com.example.ivansantamaria.appproffrontend;

public class AlumnoDAO {

    public AlumnoVO perfilProfesor(String alumno_) {

        //Integrar con la base de datos, con la conexión parsear el JSON
        AlumnoVO alumno = null;

        /* Falta realizar hash de la password en el lado de la autenticación
         * Se está usando Guava de Google
         *       - https://github.com/google/guava
         * Ejemplo:
         * final HashCode hashCode = Hashing.sha1().hashString(yourValue, Charset.defaultCharset());
         */
        alumno = new AlumnoVO("lfueris", "Salty_as02!KjanUQP},,<as");

        return alumno;
    }

}
