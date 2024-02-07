package service;
import controller.Curso;
import controller.Estudiante;
import controller.Lista;
import model.DAOCurso;
import model.DAOException;

import java.util.ArrayList;

public class CursoService {

    private DAOCurso daoCurso;


    public CursoService(){
        daoCurso = new DAOCurso();

    }
    public ArrayList bucarTodos () throws Exception{
        ArrayList<Curso> datos=new ArrayList<>();


        try { datos = daoCurso.buscarTodos();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return datos;

    }
    public Curso buscar(int CODCurso)throws  ServiceException
    {
        System.out.println("que me traes perro:  "+CODCurso);
        Curso  curso=null;
        try {
            curso=daoCurso.buscar(CODCurso);
        }
        catch (DAOException e)
        {
            throw new ServiceException(e.getMessage());
        }
        return curso;
    }
    public void modificar(Curso curso) throws ServiceException {
        try {
            daoCurso.modificar(curso);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    public void eliminar(int CodCurso) throws ServiceException
    {
        try{
            daoCurso.eliminar(CodCurso);
        }
        catch (DAOException e)
        {
            throw  new ServiceException(e.getMessage());
        }
    }

    public void guardar(Curso materia) throws ServiceException {
        try {
            System.out.println(" lo que llega al service: " + materia);
            daoCurso.guardar(materia);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
