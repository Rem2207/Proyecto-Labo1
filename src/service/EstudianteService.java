package service;
import controller.Curso;
import controller.Estudiante;
import controller.Lista;
import model.DAOEstudiante;
import model.DAOException;
import javax.swing.*;
import java.util.ArrayList;

public class EstudianteService {
    private DAOEstudiante daoEstudiante;

    public EstudianteService() {
        daoEstudiante =new DAOEstudiante();
    }
    public void guardar(Estudiante estudiante) throws ServiceException {
        try {
            daoEstudiante.guardar(estudiante);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    public void modificar(Estudiante alumno ) throws ServiceException {
        try {
            daoEstudiante.modificar(alumno);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void eliminar(int DNI) throws ServiceException
    {
        try{
            daoEstudiante.eliminar(DNI);
        }
        catch (DAOException e)
        {
            throw  new ServiceException(e.getMessage());
        }
    }

    public Estudiante buscar(int DNI)throws  ServiceException
    {
        Estudiante  alumno=null;
        try {
            alumno=daoEstudiante.buscar(DNI);
        }
        catch (DAOException e)
        {
            throw new ServiceException(e.getMessage());
        }
        return alumno;
    }
    public ArrayList bucarTodos () throws Exception{
        ArrayList<Estudiante> datos=new ArrayList<>();


        try { datos = daoEstudiante.buscarTodos();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return datos;

    }
}



