package model;
import controller.Curso;
import controller.Estudiante;
import controller.Lista;
import controller.Profesor;

import java.sql.*;
import java.util.ArrayList;
public class DAOCurso implements DAO<Curso>{
    private String DB_JDBC_DRIVER="org.h2.Driver";
    private String DB_URL="jdbc:h2:C:/Users/rienm/IdeaProjects/Proyecto Lab/Base";
    private String DB_USER="sa";
    private String DB_PASSWORD="";
    @Override
    public void guardar(Curso elemento) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("INSERT into Curso Values(?,?,?,?,?,?)");
            preparedStatement.setInt(1, elemento.getCodCurso());
            preparedStatement.setString(2,elemento.getNombreMateria());
            preparedStatement.setInt(3, elemento.getCupo());
            preparedStatement.setInt(4, elemento.getNotaDeAprobacion());
            preparedStatement.setFloat(5, elemento.getValorcurso());
            preparedStatement.setInt(6,elemento.getprofesor_dni());
            int res=preparedStatement.executeUpdate();
            System.out.println("Se agregaron " + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Curso elemento) throws DAOException {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("UPDATE Curso SET NombreMateria=?, cupo=?, notaAprob=?, valor=? , ProfesorDni=? WHERE CoDCurso=?");

            preparedStatement.setString(1, elemento.getNombreMateria());
            preparedStatement.setInt(2, elemento.getCupo());
            preparedStatement.setInt(3, elemento.getNotaDeAprobacion());
            preparedStatement.setFloat(4,elemento.getValorcurso());
            preparedStatement.setInt(5,elemento.getprofesor_dni());
            preparedStatement.setInt(6, elemento.getCodCurso());
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
    public Curso eliminar(int CODCURSO) throws DAOException {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("DELETE FROM Curso  WHERE codCurso=?");

            preparedStatement.setInt(1,1);
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
    public Curso buscar(int codCurso) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Curso materia=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("Select* FROM CURSO WHERE \"CodCurso\"=?");
            preparedStatement.setInt(1,codCurso);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                materia = new Curso();
                materia.setCodCurso(resultSet.getInt("CodCurso"));
                materia.setNombreMateria(resultSet.getString("NombreMateria"));
                materia.setCupo(resultSet.getInt("CUPO"));
                materia.setNotaDeAprobacion(resultSet.getInt("NotaAprob"));
                materia.setValorcurso(resultSet.getFloat("Valor"));
                materia.setprofesor_dni(resultSet.getInt("ProfesorDni"));
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return materia;
    }

    @Override
    public ArrayList buscar1(int CodCurso) throws DAOException {
        return null;
    }

    @Override
    public ArrayList buscarTodos() throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Curso> datos=new ArrayList<>();
        Curso materia;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM CURSO");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                materia = new Curso();
                materia.setCodCurso(resultSet.getInt("CodCurso"));
                materia.setNombreMateria(resultSet.getString("NombreMateria"));
                materia.setCupo(resultSet.getInt("CUPO"));
                materia.setNotaDeAprobacion(resultSet.getInt("NotaAprob"));
                materia.setValorcurso(resultSet.getFloat("Valor"));
                materia.setprofesor_dni(resultSet.getInt("ProfesorDni"));
                datos.add(materia);
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
}
