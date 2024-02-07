package gui;
import controller.Estudiante;
import model.DAOException;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.DAOEstudiante;
import service.EstudianteService;

public class PantallaEstudiante extends  JFrame implements ActionListener{


    private JLabel label1, label2, label3;
    private JMenuBar mb;
    private JMenu inscripciones, calificaciones, salir;
    private JMenuItem inscripcionMat, califiCursada,cerrarSeion;

   private Estudiante alumno1 = new Estudiante();
   private String estudiante, legajo;
    public PantallaEstudiante(Estudiante alumno) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        alumno1 = alumno;
        setLayout(null);
        setTitle("Pantalla Estudiante");
        getContentPane().setBackground(new Color(52,72,202));
        setBounds(0,0,800,500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        DAOEstudiante base = new DAOEstudiante();

        estudiante = alumno1.getNombre();
        legajo = String.valueOf(alumno1.getLegajo());
        mb = new JMenuBar();
        mb.setBackground(new Color(35,53,168));
        setJMenuBar(mb);

        inscripciones = new JMenu("Inscripcion");
        inscripciones.setBackground(new Color(35,53,168));
        inscripciones.setForeground(new Color(255,255,255));
        mb.add(inscripciones);

        calificaciones = new JMenu("Calificaciones");
        calificaciones.setBackground(new Color(35,53,168));
        calificaciones.setForeground(new Color(255,255,255));
        mb.add(calificaciones);

        salir = new JMenu("Salir");
        salir.setBackground(new Color(35,53,168));
        salir.setForeground(new Color(255,255,255));
        mb.add(salir);

        inscripcionMat = new JMenuItem("Inscripcion a Cursada");
        inscripcionMat.setForeground(new Color(0,0,0));
        inscripciones.add(inscripcionMat);
        inscripcionMat.addActionListener(this);

        califiCursada = new JMenuItem("Ver Calificaciones");
        califiCursada.setForeground(new Color(0,0,0));
        calificaciones.add(califiCursada);
        califiCursada.addActionListener(this);

        cerrarSeion = new JMenuItem("Cerrar Sesión");
        cerrarSeion.setForeground(new Color(0,0,0));
        salir.add(cerrarSeion);
        cerrarSeion.addActionListener(this);

        label1 = new JLabel("Hola Bienvenido al Sistema de Alumnos ");
        label1.setBounds(90,90,800,200);
        label1.setFont(new Font("Andale Mono",1,28));
        label1.setForeground(new Color(0,0,0));
        add(label1);

        label2 = new JLabel("Datos personales");
        label2.setBounds(100,120,400,200);
        label2.setFont(new Font("Andale Mono",1,24));
        label2.setForeground(new Color(0,0,0));
        add(label2);

        label3 = new JLabel("El estudiante: "+estudiante+" con Legajo " +legajo);
        label3.setBounds(100,200,800,200);
        label3.setFont(new Font("Andale Mono",1,24));
        label3.setForeground(new Color(0,0,0));
        add(label3);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == califiCursada){
            Calificaciones calificaciones1 = new Calificaciones(alumno1);


        }
        if(e.getSource() == cerrarSeion) {
            Login login = new Login();
            this.setVisible(false);

        }
        if (e.getSource() == inscripcionMat){
            Inscripcion inscripcion = new Inscripcion(alumno1);


        }
    }
}
