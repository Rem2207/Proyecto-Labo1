package model;

import controller.Admin;
import controller.Curso;
import controller.Lista;

import java.sql.*;
import java.util.ArrayList;
public class DAOAdmin implements DAO<Admin> {
    private String DB_JDBC_DRIVER="org.h2.Driver";
    private String DB_URL="jdbc:h2:C:/Users/rienm/IdeaProjects/Proyecto Lab/Base";
    private String DB_USER="sa";
    private String DB_PASSWORD="";
    @Override
    public void guardar(Admin elemento) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("INSERT into Admin Values(?,?,?,?,?)");
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
    public void modificar(Admin elemento) throws DAOException {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("UPDATE dni=?, nombre=?, email=?, legajo= ?, telefono=?");
            preparedStatement.setLong(1,elemento.getDni());
            preparedStatement.setString(2, elemento.getNombre());
            preparedStatement.setString(3, elemento.getEmail());
            preparedStatement.setInt(4, elemento.getLegajo());
            preparedStatement.setInt(5,elemento.getTelefono());
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
    public Admin eliminar(int DNI) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("DELETE FROM Admin  WHERE dni=?");

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
    public Admin buscar(int id) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Admin admin=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM Admin WHERE dni=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                admin = new Admin();
                admin.setDni(resultSet.getInt("DNI"));
                admin.setNombre(resultSet.getString("NOMBRE"));
                admin.setEmail(resultSet.getString("EMAIL"));
                admin.setLegajo(resultSet.getInt("LEGAJO"));
                admin.setTelefono(resultSet.getInt("TELEFONO"));
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return admin;
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
        ArrayList<Admin> datos=new ArrayList<>();
        Admin admin;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM Admin");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                admin = new Admin();
                admin.setDni(resultSet.getInt("DNI"));
                admin.setNombre(resultSet.getString("NOMBRE"));
                admin.setEmail(resultSet.getString("EMAIL"));
                admin.setLegajo(resultSet.getInt("TELEFONO"));
                admin.setLegajo(resultSet.getInt("TELEFONO"));

                datos.add(admin);
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
