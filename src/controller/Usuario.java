package controller;

public abstract class Usuario {
    private String nombre, email;
    private int telefono, legajo, dni;



    public Usuario(String nombre, String email, int telefono, int legajo, int dni) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.legajo = legajo;
        this.dni = dni;
    }

    public Usuario() {

    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getLegajo() {
        return legajo;
    }

    public int getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "nombre= " + nombre  +
                " email= " + email  +
                " telefono= " + telefono +
                " legajo= " + legajo +
                " dni= " + dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}
