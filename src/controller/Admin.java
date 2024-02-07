package controller;
import service.*;
import service.ServiceException;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Admin extends Usuario {

    EstudianteService baseE = new EstudianteService();
    ProfesorService baseP = new ProfesorService();
    CursoService baseC = new CursoService();
    ListaService baseL = new ListaService();

    public Admin(String nombre, String email, int telefono, int legajo, int dni) {
        super(nombre, email, telefono, legajo, dni);
    }

    public Admin() {

    }

    public void GestionAlumno(String nombre, String email, int telefono, int legajo, int dni, int valor) {

        Estudiante Alumno = new Estudiante(nombre, email, telefono, legajo, dni);
        if (valor == 1) {
            try {
                baseE.guardar(Alumno);
                JOptionPane.showMessageDialog(null, "Se ha creado correctamente");
            } catch (ServiceException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrio algun problema");
                throw new RuntimeException(ex);
            }
        }
        if (valor == 2){
            try {
                baseE.modificar(Alumno);
                JOptionPane.showMessageDialog(null,"Se ha modificado correctamente");
            } catch (ServiceException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio algun problema");
                throw new RuntimeException(e);
            }
        }
        if (valor == 3){
            try {
                baseE.eliminar(Alumno.getDni());
                JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente");
            } catch (ServiceException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio algun problema");
                throw new RuntimeException(e);
            }
        }


    }

    public void GestionMateria(int CodCurso, String nombreMateria, int cupo, int notaDeAprobacion, float valorcurso, int profesor_dni, int valor) {
        System.out.println("codigo curso que llega = " + CodCurso);
        Curso curso= new Curso();
        curso.setCodCurso(CodCurso);
        curso.setNombreMateria(nombreMateria);
        curso.setCupo(cupo);
        curso.setNotaDeAprobacion(notaDeAprobacion);
        curso.setValorcurso(valorcurso);
        curso.setprofesor_dni(profesor_dni);

        if (valor == 1) {
            try {
                baseC.guardar(curso);
                JOptionPane.showMessageDialog(null, "Se ha creado correctamente");
            } catch (ServiceException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrio algun problema");
                throw new RuntimeException(ex);
            }
        }
        if (valor == 2){
            try {
                baseC.modificar(curso);
                JOptionPane.showMessageDialog(null,"Se ha modificado correctamente");
            } catch (ServiceException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio algun problema");
                throw new RuntimeException(e);
            }
        }
        if (valor == 3){
            try {
                baseC.eliminar(curso.getCodCurso());
                JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente");
            } catch (ServiceException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio algun problema");
                throw new RuntimeException(e);
            }
        }
    }

    public void GestionProfesor(String nombre, String email, int telefono, int legajo, int dni, int valor) {

        Profesor profesor = new Profesor(nombre, email, telefono, legajo, dni);
        if (valor == 1) {
            try {
                baseP.guardar(profesor);
                JOptionPane.showMessageDialog(null, "Se ha creado correctamente");
            } catch (ServiceException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrio algun problema");
                throw new RuntimeException(ex);
            }
        }
        if (valor == 2){
            try {
                baseP.modificar(profesor);
                JOptionPane.showMessageDialog(null,"Se ha modificado correctamente");
            } catch (ServiceException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio algun problema");
                throw new RuntimeException(e);
            }
        }
        if (valor == 3){
            try {
                baseP.eliminar(profesor.getDni());
                JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente");
            } catch (ServiceException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio algun problema");
                throw new RuntimeException(e);
            }
        }
    }
    public void emitirReporte(int CodCurso){
        System.out.println("eto "+ CodCurso);
        ArrayList<Lista> datos = new ArrayList<>();
        Curso materia = new Curso();
        float recaudacion;
        try {
            datos=baseL.obtenerReporteCursos(CodCurso);
            materia=baseC.buscar(CodCurso);
            recaudacion = (materia.getValorcurso())*(datos.size());

            // Crear archivo de reporte
            String nombreArchivo = "reporte_" + CodCurso + ".txt";
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir recaudación en el archivo
            bufferedWriter.write("Nombre de la materia: " + materia.getNombreMateria() + "\n");
            bufferedWriter.write("Valor del curso: " + materia.getValorcurso() + "\n");
            bufferedWriter.write("Cantidad de alumnos: " + datos.size() + "\n");
            bufferedWriter.write("Recaudación total: " + recaudacion + " pesos\n\n");

            // Escribir datos de los alumnos en el archivo
            for (Lista lista : datos) {
                bufferedWriter.write("CodLista: " + lista.getCodLista() + "\n");
                bufferedWriter.write("Materia: " + lista.getMateria() + "\n");
                bufferedWriter.write("DNI del alumno: " + lista.getDni() + "\n");
                bufferedWriter.write("CodCurso: " + lista.getCodMateria() + "\n\n");
            }

            // Cerrar el archivo
            bufferedWriter.close();

            System.out.println("Reporte generado correctamente en el archivo: " + nombreArchivo);

            JOptionPane.showMessageDialog(null,"Se Recaudo de la Materia "+ materia.getNombreMateria()+ " un total de "+ recaudacion + " pesos");
        } catch (ServiceException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio algun problema");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}



