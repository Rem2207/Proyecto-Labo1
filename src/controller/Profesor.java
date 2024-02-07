package controller;
import service.*;

import javax.swing.*;
import java.util.AbstractList;
import java.util.ArrayList;

public class Profesor extends Usuario {
    private ListaService baseL = new ListaService();
    private CursoService baseC = new CursoService();
    Lista lista = new Lista();
    Curso curso = new Curso();

    public Profesor(String nombre, String email, int telefono, int legajo, int dni) {
        super(nombre, email, telefono, legajo, dni);
    }

    public Profesor() {

    }
    public ArrayList ListaProfe(int DNI){
        ArrayList<Lista> datos=new ArrayList<>();
        try {
            datos= baseL.buscar1(DNI);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return datos;
    }
    public void SubirNotas(int CodLista, int nota){
        try {
            boolean aprodado=false;
        curso=baseC.buscar(baseL.buscar(CodLista).getCodMateria());
        if (nota >= curso.getNotaDeAprobacion() ){
            aprodado=true;
        }
        baseL.modificar(CodLista,nota,aprodado);
            JOptionPane.showMessageDialog(null,"Se ha subido Correctamente");
        }catch (Exception e){

            throw new RuntimeException(e);
        }


    }

}
