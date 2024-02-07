package model;
import controller.*;

import java.util.ArrayList;



    public interface DAO<T>{
        public void guardar(T elemento) throws DAOException;
        public void modificar(T elemento) throws DAOException;


        void modificar(int CODLista, int nota) throws DAOException;

        void modificar(int CODLista, int nota, boolean aprodado) throws DAOException;

        public T eliminar(int DNI) throws DAOException;
        public T buscar(int DNI ) throws DAOException;
        public ArrayList buscar1(int DNI ) throws DAOException;

        Curso eliminar(String nombreMateria) throws DAOException;

        Curso buscar(String nombreMateria) throws DAOException;

        Lista eliminar(String Materia, int DNI) throws DAOException;

        Lista buscar(String Materia, int DNI) throws DAOException;

        public ArrayList buscarTodos() throws DAOException;

        ArrayList buscarTodos(int DNI) throws DAOException;
    }


