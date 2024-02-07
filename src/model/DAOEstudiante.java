package model;

import controller.Curso;
import controller.Estudiante;
import controller.Lista;

import java.sql.*;
import java.util.ArrayList;

public class DAOEstudiante implements DAO<Estudiante> {
    private String DB_JDBC_DRIVER = "org.h2.Driver";
    private String DB_URL = "jdbc:h2:C:/Users/rienm/IdeaProjects/Proyecto Lab/Base";
    private String DB_USER = "sa";
    private String DB_PASSWORD = "";


    @Override
    public void guardar(Estudiante elemento) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("INSERT into Estudiante Values(?,?,?,?,?)");
            preparedStatement.setInt(1, elemento.getDni());
            preparedStatement.setString(2, elemento.getNombre());
            preparedStatement.setString(3, elemento.getEmail());
            preparedStatement.setInt(4, elemento.getLegajo());
            preparedStatement.setInt(5, elemento.getTelefono());
            int res = preparedStatement.executeUpdate();
            System.out.println("Se agregaron " + res);
        } catch (ClassNotFoundException | SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }


    @Override
    public void modificar(Estudiante elemento) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE ESTUDIANTE SET NOMBRE=?, EMAIL =?, LEGAJO=?, TELEFONO=? WHERE DNI=?");

            preparedStatement.setString(1, elemento.getNombre());
            preparedStatement.setString(2, elemento.getEmail());
            preparedStatement.setInt(3, elemento.getLegajo());
            preparedStatement.setInt(4, elemento.getTelefono());
            preparedStatement.setInt(5, elemento.getDni());
            int res = preparedStatement.executeUpdate();
            System.out.println("Se modificaron " + res);
        } catch (ClassNotFoundException | SQLException e) {
            throw new DAOException(e.getMessage());
        }


    }

    @Override
    public void modificar(int CODLista, int nota) throws DAOException {

    }

    @Override
    public void modificar(int CODLista, int nota, boolean aprodado) throws DAOException {

    }

    @Override
    public Estudiante eliminar(int DNI) throws DAOException {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("DELETE FROM Estudiante  WHERE DNI=?");

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
    public Estudiante buscar(int DNI) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Estudiante alumno = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Estudiante  WHERE Dni=?");
            preparedStatement.setInt(1, DNI);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                alumno = new Estudiante();
                alumno.setDni(resultSet.getInt("DNI"));
                alumno.setNombre(resultSet.getString("NOMBRE"));
                alumno.setEmail(resultSet.getString("EMAIL"));
                alumno.setLegajo(resultSet.getInt("LEGAJO"));
                alumno.setTelefono(resultSet.getInt("TELEFONO"));

            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return alumno;
    }

    @Override
    public ArrayList buscar1(int CodCurso) throws DAOException {
        return null;
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
        ArrayList<Estudiante> datos=new ArrayList<>();
        Estudiante alumno;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM Estudiante");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                alumno = new Estudiante();
                alumno.setDni(resultSet.getInt("DNI"));
                alumno.setNombre(resultSet.getString("NOMBRE"));
                alumno.setEmail(resultSet.getString("EMAIL"));
                alumno.setLegajo(resultSet.getInt("LEGAJO"));
                alumno.setTelefono(resultSet.getInt("TELEFONO"));
                datos.add(alumno);

            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return datos;
    }

    @Override
    public ArrayList buscarTodos(int DNI) throws DAOException {
        return null;
    }
}



