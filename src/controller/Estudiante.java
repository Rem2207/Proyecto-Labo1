package controller;

import model.DAOException;
import service.ServiceException;

import javax.swing.*;
import java.util.ArrayList;
import service.*;
public class Estudiante extends Usuario {


    private ArrayList<Curso> cursosInscriptos;
    private ArrayList<Lista> notas;
    ListaService baseLista = new ListaService();




    public Estudiante(String nombre, String email, int telefono, int legajo, int dni) {
        super(nombre, email, telefono, legajo, dni);


    }

    public Estudiante() {

    }
    public void Inscribirse( int dni, int codLista, int codMateria, int nota){
        Curso materia = new Curso();
        int cont = 0;
        CursoService baseCurso = new CursoService();
        ArrayList<Lista> validacion = new ArrayList<>();
        try {
            validacion = baseLista.buscarTodos(dni);
            materia= baseCurso.buscar(codMateria);
        }catch (Exception e){
            throw new RuntimeException();
        }
        Lista lista = new Lista();
        if(materia != null) {
            lista.setMateria(materia.getNombreMateria());
            lista.setDni(dni);
            lista.setCodLista(codLista);
            lista.setCodMateria(codMateria);
            lista.setNota(nota);
        }

        for (Lista lista1 : validacion){
            if(lista1.getAprobado() == false){
                cont++;

            }

        }
        System.out.println("Contador de booleanos: "+cont);
        if (cont < 3) {
            try {
                baseLista.guardar(lista);
                JOptionPane.showMessageDialog(null, "Te has inscrito correctamente");
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }
        }else {
            JOptionPane.showMessageDialog(null,"Has alcanzado el limite máximo de materias, necesitas aprobar para inscribirte");
        }

    }
    public ArrayList VerNotas(int DNI){
        ArrayList<Lista> datos = new ArrayList<>();
        try {datos=baseLista.buscarTodos(DNI);

        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

        return  datos;
    }
}
