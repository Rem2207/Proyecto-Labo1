package service;
import controller.Estudiante;
import controller.Lista;
import controller.Profesor;
import model.DAOProfesor;
import model.DAOException;
import javax.swing.*;
import java.util.ArrayList;

public class ProfesorService {
    private DAOProfesor daoProfesor;

    public ProfesorService() {
        daoProfesor =new DAOProfesor();
    }
    public void guardar(Profesor profesor) throws ServiceException {
        try {
            daoProfesor.guardar(profesor);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    public void modificar(Profesor profesor) throws ServiceException {
        try {
            daoProfesor.modificar(profesor);
            System.out.println("Datos: "+profesor);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    public void eliminar(int DNI) throws ServiceException
    {
        try{
            daoProfesor.eliminar(DNI);
        }
        catch (DAOException e)
        {
            throw  new ServiceException(e.getMessage());
        }
    }

    public Profesor buscar(int DNI)throws  ServiceException
    {
        Profesor  profesor=null;
        try {
            profesor=daoProfesor.buscar(DNI);
        }
        catch (DAOException e)
        {
            throw new ServiceException(e.getMessage());
        }
        return profesor;
    }

    public ArrayList<Profesor> bucarTodos() {
        ArrayList<Profesor> datos=new ArrayList<>();


        try { datos = daoProfesor.buscarTodos();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return datos;
    }
}

