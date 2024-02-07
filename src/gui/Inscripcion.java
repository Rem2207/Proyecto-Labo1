package gui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Curso;
import controller.Lista;
import model.DAOEstudiante;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import controller.Estudiante;
import model.DAOException;
import service.CursoService;
import service.ListaService;
import service.ServiceException;
import gui.PantallaEstudiante;

public class Inscripcion extends JFrame implements ActionListener{

    CursoService datos = new CursoService();
    ListaService baseLista = new ListaService();
    ArrayList<Curso> cursos = new ArrayList<>();
    ArrayList<Lista> lista = new ArrayList<>();
    private Estudiante alumno = new Estudiante();
    private JComboBox<Curso> CursoJComboBox;
    private JComboBox<Lista> comboL;
    private JButton button1;
    private JTextField textField,textField2,textField3;
    private JLabel label, label2, label3;
    private String nombreMat;
    private Curso mat = new Curso();
    ArrayList<String> Nombres = new ArrayList<>();

    Inscripcion (Estudiante alumno1){
        alumno = alumno1;
        CursoJComboBox = new JComboBox<>();
        try {cursos=datos.bucarTodos();
            for (Curso cursos:cursos) {
                CursoJComboBox.addItem(cursos);
                mat=cursos;
                Nombres.add(mat.getNombreMateria());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        comboL = new JComboBox<>();
        try {lista=baseLista.bucarTodos();
            for (Lista lista:lista) {
                comboL.addItem(lista);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        setLayout(null);
        setTitle("Inscripción");
        getContentPane().setBackground(new Color(52,72,202));
        setBounds(0,0,700,400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        CursoJComboBox.setBounds(50,10,600,25);
        add(CursoJComboBox);
        CursoJComboBox.addActionListener(this);

        button1 = new JButton("Inscribirse");
        button1.setBounds(500,150,100,50);
        add(button1);
        button1.addActionListener(this);


        label = new JLabel("Selecciona la Materia en la que te quieres Inscribir");
        label.setBounds(50,50,600,35);
        label.setFont(new Font("Andale mono",1,20));
        label.setForeground(new Color(0xFFFFFF));
        add(label);



    }






    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button1){
            Curso curso = (Curso) CursoJComboBox.getSelectedItem();
            int num = 0;
            num = comboL.getItemCount()+1 ;

               alumno.Inscribirse(alumno.getDni(),num,curso.getCodCurso(),0);

        }

    }
}


