package controller;
import controller.Profesor;

public class Curso {

    private String nombreMateria;
    private int codCurso, cupo, notaDeAprobacion,profesor_dni;
    private float valorcurso;


    public Curso(String nombreMateria, int codCurso, int cupo, int notaDeAprobacion, float valorcurso, int profesor_dni) {
        this.nombreMateria = nombreMateria;
        this.codCurso = codCurso;
        this.cupo = cupo;
        this.notaDeAprobacion = notaDeAprobacion;
        this.valorcurso = valorcurso;
        this.profesor_dni = profesor_dni;
    }


    public Curso() {

    }


    public Curso(int codCurso, String nombreMateria, int cupo, int notaDeAprobacion, float valorcurso, int profesor_dni) {
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    @Override
    public String toString() {
        return "CodCurso "+codCurso +" Materia= " + nombreMateria + '\'' +
                " cupo= " + cupo +
                " nota Aprobacion= " + notaDeAprobacion + " valor= " + valorcurso
                +" Profesor= " + profesor_dni;

    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public int getNotaDeAprobacion() {return notaDeAprobacion;}

    public void setNotaDeAprobacion(int notaDeAprobacion) {
        this.notaDeAprobacion = notaDeAprobacion;
    }

    public float getValorcurso() {
        return valorcurso;
    }

    public void setValorcurso(float valorcurso) {
        this.valorcurso = valorcurso;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public int getprofesor_dni(){return profesor_dni;}
    public void setprofesor_dni(int profesor_dni){this.profesor_dni = profesor_dni;}
}
