package model;

import controller.Lista;
import controller.Curso;

import java.sql.*;
import java.util.ArrayList;

public class DAOLista implements DAO<Lista> {
    private String DB_JDBC_DRIVER="org.h2.Driver";
    private String DB_URL="jdbc:h2:C:/Users/rienm/IdeaProjects/Proyecto Lab/Base";
    private String DB_USER="sa";
    private String DB_PASSWORD="";
    @Override
    public void guardar(Lista elemento) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("INSERT into Lista Values(?,?,?,?,?,?)");
            preparedStatement.setInt(1,elemento.getCodLista());
            preparedStatement.setString(2, elemento.getMateria());
            preparedStatement.setInt(3, elemento.getDni());
            preparedStatement.setInt(4,elemento.getNota());
            preparedStatement.setInt(5, elemento.getCodMateria());
            preparedStatement.setBoolean(6,elemento.getAprobado());
            int res=preparedStatement.executeUpdate();
            System.out.println("Se agregaron " + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Lista elemento) throws DAOException {

    }

    @Override
    public void modificar(int CODLista, int nota) throws DAOException {

    }

    @Override
    public void modificar(int CODLista, int nota, boolean aprodado) throws DAOException {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("UPDATE LISTA SET NOTA=?, APROBADO=? WHERE CODLISTA=?");

            preparedStatement.setInt(1,nota);
            preparedStatement.setBoolean(2,aprodado);
            preparedStatement.setInt(3, CODLista);


            int res=preparedStatement.executeUpdate();
            System.out.println("Se modificaron " + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }


    }

    @Override
    public Lista eliminar(int DNI) throws DAOException {
        return null;
    }


    @Override
    public ArrayList buscar1(int DNI) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Lista> datos=new ArrayList<>();
        Lista lista=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement = connection.prepareStatement("select CODLISTA,CURSO,ALUMNO,NOTA,l.CODCURSO,APROBADO  from LISTA as l inner join CURSO C on C.\"CodCurso\" = l.CODCURSO where C.\"ProfesorDni\"=?");
            preparedStatement.setInt(1,DNI);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                lista = new Lista();
                lista.setMateria(resultSet.getString("CURSO"));
                lista.setDni(resultSet.getInt("ALUMNO"));
                lista.setCodLista(resultSet.getInt("CODLISTA"));
                lista.setCodMateria(resultSet.getInt("CODCURSO"));
                lista.setNota(resultSet.getInt("NOTA"));
                datos.add(lista);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return datos;
    }



    @Override
    public Curso eliminar(String nombreMateria) throws DAOException {
        return null;
    }

    @Override
    public Curso buscar(String nombreMateria) throws DAOException {
        return null;
    }

    @Override
    public Lista eliminar(String Materia, int DNI) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("DELETE FROM Lista  WHERE CODLISTA=?");

            preparedStatement.setString(1,Materia);
            preparedStatement.setInt(1,DNI);
            int res=preparedStatement.executeUpdate();
            System.out.println("Se elimino" + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return null;
    }

    @Override
    public Lista buscar(String Materia, int DNI) throws DAOException {
        return null;
    }

    @Override
    public ArrayList buscarTodos() throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Lista> datos=new ArrayList<>();
        Lista lista;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM LISTA");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                lista = new Lista();
                lista.setMateria(resultSet.getString("CURSO"));
                lista.setDni(resultSet.getInt("ALUMNO"));
                lista.setCodLista(resultSet.getInt("CODLISTA"));
                lista.setCodMateria(resultSet.getInt("CODCURSO"));
                lista.setNota(resultSet.getInt("NOTA"));
                lista.setAprobado(resultSet.getBoolean("APROBADO"));
                datos.add(lista);

            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return datos;
    }


    @Override
    public Lista buscar(int CODLISTA) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Lista lista=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("Select* FROM LISTA WHERE \"CODLISTA\"=?");
            preparedStatement.setInt(1,CODLISTA);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                lista = new Lista();
                lista.setMateria(resultSet.getString("CURSO"));
                lista.setDni(resultSet.getInt("ALUMNO"));
                lista.setCodLista(resultSet.getInt("CODLISTA"));
                lista.setCodMateria(resultSet.getInt("CODCURSO"));
                lista.setNota(resultSet.getInt("NOTA"));
                lista.setAprobado(resultSet.getBoolean("APROBADO"));

            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return lista;
    }


    @Override
    public ArrayList buscarTodos(int ALUMNO) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Lista> datos=new ArrayList<>();
        Lista lista;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM Lista WHERE ALUMNO=?");
            preparedStatement.setInt(1,ALUMNO);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                lista = new Lista();
                lista.setMateria(resultSet.getString("CURSO"));
                lista.setDni(resultSet.getInt("ALUMNO"));
                lista.setCodLista(resultSet.getInt("CODLISTA"));
                lista.setCodMateria(resultSet.getInt("CODCURSO"));
                lista.setNota(resultSet.getInt("NOTA"));
                lista.setAprobado(resultSet.getBoolean("APROBADO"));
                datos.add(lista);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return datos;
    }
    public ArrayList buscarTodosporCurso(int CodCurso) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Lista> datos=new ArrayList<>();
        Lista lista;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM Lista WHERE CODCURSO=?");
            preparedStatement.setInt(1,CodCurso);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                lista = new Lista();
                lista.setMateria(resultSet.getString("CURSO"));
                lista.setDni(resultSet.getInt("ALUMNO"));
                lista.setCodLista(resultSet.getInt("CODLISTA"));
                lista.setCodMateria(resultSet.getInt("CODCURSO"));
                lista.setNota(resultSet.getInt("NOTA"));
                lista.setAprobado(resultSet.getBoolean("APROBADO"));
                datos.add(lista);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return datos;
    }

    public ArrayList obtenerReporteCursos(int CodCurso) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Lista> datos=new ArrayList<>();
        Lista lista=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement = connection.prepareStatement("select CODLISTA ,CURSO , ALUMNO, CODCURSO from LISTA  where CODCURSO=?");
            preparedStatement.setInt(1,CodCurso);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                lista = new Lista();
                lista.setCodLista(resultSet.getInt("CODLISTA"));
                lista.setMateria(resultSet.getString("CURSO"));
                lista.setDni(resultSet.getInt("ALUMNO"));
                lista.setCodMateria(resultSet.getInt("CODCURSO"));
                datos.add(lista);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return datos;
    }


}

