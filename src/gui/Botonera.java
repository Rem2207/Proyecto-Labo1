package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.*;
import service.*;

public class Botonera extends JPanel implements ActionListener{

    ArrayList<Estudiante> estudiantes = new ArrayList<>();
    EstudianteService datosE = new EstudianteService();
    ArrayList<Profesor> profesores = new ArrayList<>();
    ProfesorService datosP = new ProfesorService();
    ArrayList<Curso> cursos = new ArrayList<>();
    CursoService datosC = new CursoService();
    Estudiante estudiante = new Estudiante();
    Profesor profesor = new Profesor();
    Curso curso = new Curso();
    private JButton button1, button2, button3;
    private JComboBox comboE, comboP, comboC;
    public JTextField field1, field2, field3, field4, field5;
    private String d,n,em,t,dni;
    Admin admin = new Admin();
    private int validar;
    public Botonera(int validacion){
        validar = validacion;
        comboE = new JComboBox();
        try {estudiantes=datosE.bucarTodos();
            for (Estudiante estudiante:estudiantes) {
                comboE.addItem(estudiante);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        comboP = new JComboBox<>();

        try {profesores=datosP.bucarTodos();
            for (Profesor profesor:profesores) {
                comboP.addItem(profesores);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        comboC = new JComboBox<>();

        try {cursos=datosC.bucarTodos();
            for (Curso curso:cursos) {
                comboC.addItem(cursos);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        setLayout(null);
        setBackground(new Color(202, 52, 104));

        button1 = new JButton("Crear");
        button1.setBounds(0, 0, 120, 50);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Modificar");
        button2.setBounds(160, 0, 120, 50);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("Borrar");
        button3.setBounds(320, 0, 120, 50);
        button3.addActionListener(this);
        add(button3);


    }







    @Override
    public void actionPerformed(ActionEvent e) {
        int Codcurso, legajoP, legajoE;

        legajoE = comboE.getItemCount() + 100;
        legajoP = comboP.getItemCount();
        Codcurso = comboC.getItemCount();
      //  System.out.println("Codigo curso" + Codcurso);
        if(e.getSource() == button1){
            if (validar == 1){
                admin.GestionAlumno(field2.getText(),field3.getText(),Integer.parseInt(field4.getText()),legajoE,Integer.parseInt(field1.getText()),1);
            }

            if(validar ==2 ){
                admin.GestionProfesor(field2.getText(),field3.getText(),Integer.parseInt(field4.getText()),legajoP,Integer.parseInt(field1.getText()),1);
            }
            if(validar == 3){
                admin.GestionMateria(Codcurso,field1.getText(),Integer.parseInt(field2.getText()),Integer.parseInt(field3.getText()),Float.parseFloat(field4.getText()),Integer.parseInt(field5.getText()),1);
            }

        }
        if(e.getSource() == button2){
            if (validar == 1){
                admin.GestionAlumno(field2.getText(),field3.getText(),Integer.parseInt(field4.getText()),estudiante.getLegajo(),Integer.parseInt(field1.getText()),2);
            }

            if(validar ==2 ){
                admin.GestionProfesor(field2.getText(),field3.getText(),Integer.parseInt(field4.getText()),profesor.getLegajo(),Integer.parseInt(field1.getText()),2);
            }
            if(validar == 3){
                admin.GestionMateria(curso.getCodCurso(),field1.getText(),Integer.parseInt(field2.getText()),Integer.parseInt(field3.getText()),Float.parseFloat(field4.getText()),Integer.parseInt(field5.getText()),2);
            }
        }
        if(e.getSource() == button3){
            if (validar == 1){
                admin.GestionAlumno(field2.getText(),field3.getText(),Integer.parseInt(field4.getText()),estudiante.getLegajo(),Integer.parseInt(field1.getText()),3);
            }

            if(validar ==2 ){
                admin.GestionProfesor(field2.getText(),field3.getText(),Integer.parseInt(field4.getText()),profesor.getLegajo(),Integer.parseInt(field1.getText()),3);
            }
            if(validar == 3){
                admin.GestionMateria(curso.getCodCurso(),field1.getText(),Integer.parseInt(field2.getText()),Integer.parseInt(field3.getText()),Float.parseFloat(field4.getText()),Integer.parseInt(field5.getText()),3);
            }



        }
    }
    public void codigo_estu(Estudiante estu) {

        this.estudiante = estu;
    }
    public void codigo_profe(Profesor profe){
        this.profesor = profe;
    }
    public void codigo_curso(Curso cur){
         this.curso = cur;
    }
    public void setTextFieldReferences(JTextField field1, JTextField field2, JTextField field3, JTextField field4,JTextField field5) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
    }
}
