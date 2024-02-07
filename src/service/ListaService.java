package service;
import controller.Estudiante;
import controller.Lista;
import model.DAOLista;
import model.DAOException;

import java.util.ArrayList;

public class ListaService {
    private DAOLista daoLista;

    public ListaService() {
        daoLista = new DAOLista();

    }

    public void guardar(Lista lista) throws ServiceException {
        try {
            daoLista.guardar(lista);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Lista buscar(int CODLista) throws ServiceException {
        Lista lista = null;
        try {
            lista = daoLista.buscar(CODLista);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return lista;
    }

    public ArrayList buscar1(int DNI) throws ServiceException {
        ArrayList<Lista> datos = new ArrayList<>();

        try {
            datos = daoLista.buscar1(DNI);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return datos;
    }

    public void modificar(int codLista, int nuevaNota, boolean aprobado) throws ServiceException {
        try {
            daoLista.modificar(codLista, nuevaNota, aprobado);
        } catch (DAOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList buscarTodos(int ALUMNO) throws DAOException {
        ArrayList<Lista> datos = new ArrayList<>();


        try {
            datos = daoLista.buscarTodos(ALUMNO);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return datos;
    }


    public ArrayList<Lista> bucarTodos() {
        ArrayList<Lista> datos = new ArrayList<>();


        try {
            datos = daoLista.buscarTodos();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return datos;
    }

    public ArrayList<Lista> buscarTodosPorCurso(int codCurso) {
        ArrayList<Lista> datos = new ArrayList<>();


        try {
            datos = daoLista.buscarTodos(codCurso);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return datos;

    }

    public ArrayList obtenerReporteCursos(int CodCurso) throws ServiceException {
        {
            ArrayList<Lista> datos = new ArrayList<>();

            try {
                datos = daoLista.obtenerReporteCursos(CodCurso);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());
            }
            return datos;
        }
    }
}