package controller;

public class Lista {

    private String materia;
    private int Dni,codLista,codMateria,nota;

    private boolean aprobado;

    public Lista(String materia, int dni, int codLista, int codMateria, int nota, boolean aprobado) {
        this.materia = materia;
        Dni = dni;
        this.codLista = codLista;
        this.codMateria = codMateria;
        this.nota = nota;
        this.aprobado = aprobado;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getDni() {
        return Dni;
    }

    public void setDni(int dni) {
        Dni = dni;
    }

    public int getCodLista() {
        return codLista;
    }

    public void setCodLista(int codLista) {
        this.codLista = codLista;
    }

    public int getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(int codMateria) {
        this.codMateria = codMateria;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Lista() {

    }

    @Override
    public String toString() {
        return
                "CodLista= "+ codLista+
                " materia='" + materia  +
                " Dni= " + Dni +
                " nota= " + nota
                ;
    }
}
