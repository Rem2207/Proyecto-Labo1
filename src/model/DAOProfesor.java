package model;

import controller.*;

import java.sql.*;
import java.util.ArrayList;

public class DAOProfesor  implements  DAO<Profesor>{

    private String DB_JDBC_DRIVER="org.h2.Driver";
    private String DB_URL="jdbc:h2:C:/Users/rienm/IdeaProjects/Proyecto Lab/Base";
    private String DB_USER="sa";
    private String DB_PASSWORD="";
    @Override
    public void guardar(Profesor elemento) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("INSERT into Profesor Values(?,?,?,?,?)");
            preparedStatement.setInt(1,elemento.getDni());
            preparedStatement.setString(2, elemento.getNombre());
            preparedStatement.setString(3, elemento.getEmail());
            preparedStatement.setInt(4, elemento.getLegajo());
            preparedStatement.setInt(5, elemento.getTelefono());
            int res=preparedStatement.executeUpdate();
            System.out.println("Se agregaron " + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Profesor elemento) throws DAOException {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("UPDATE Profesor SET   nombre=?, email=?, legajo= ?, telefono=? WHERE dni=?");
            preparedStatement.setString(1, elemento.getNombre());
            preparedStatement.setString(2, elemento.getEmail());
            preparedStatement.setInt(3, elemento.getLegajo());
            preparedStatement.setInt(4, elemento.getTelefono());
            preparedStatement.setInt(5, elemento.getDni());
            int res=preparedStatement.executeUpdate();
            System.out.println("Se modificaron " + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }


    }

    @Override
    public void modificar(int CODLista, int nota) throws DAOException {

    }

    @Override
    public void modificar(int CODLista, int nota, boolean aprodado) throws DAOException {

    }

    @Override
    public Profesor eliminar(int DNI) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("DELETE FROM Profesor WHERE dni=?");

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
    public Profesor buscar(int DNI) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Profesor maestro=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM Profesor  WHERE Dni=?");
            preparedStatement.setInt(1,DNI);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                maestro = new Profesor();
                maestro.setDni(resultSet.getInt("DNI"));
                maestro.setNombre(resultSet.getString("NOMBRE"));
                maestro.setEmail(resultSet.getString("EMAIL"));
                maestro.setLegajo(resultSet.getInt("LEGAJO"));
                maestro.setTelefono(resultSet.getInt("TELEFONO"));

            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return maestro;
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
        ArrayList<Profesor> datos=new ArrayList<>();
        Profesor maestro;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM Profesor");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                maestro = new Profesor();
                maestro.setDni(resultSet.getInt("DNI"));
                maestro.setNombre(resultSet.getString("NOMBRE"));
                maestro.setEmail(resultSet.getString("EMAIL"));
                maestro.setLegajo(resultSet.getInt("LEGAJO"));
                maestro.setTelefono(resultSet.getInt("TELEFONO"));

                datos.add(maestro);
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
