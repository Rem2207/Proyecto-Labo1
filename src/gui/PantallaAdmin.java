package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



import controller.*;
import service.*;


public class PantallaAdmin extends  JFrame implements ActionListener {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        EstudianteService datosE = new EstudianteService();
        ArrayList<Profesor> profesores = new ArrayList<>();
        ProfesorService datosP = new ProfesorService();
        ArrayList<Curso> cursos = new ArrayList<>();
        CursoService datosC = new CursoService();
        private JLabel label1, label2, label3,label4,label5, label6,label7,label8;
        public JTextField field1, field2, field3, field4, field5, field6, field7, field8,field9,field10,field11,field12,field13;
        private JButton button1, button2, button3, button4;
        private JComboBox comboE, comboP,comboP2, comboC;
        private JPanel panel1,panel2,panel3;
        private JScrollPane scroll;
        Admin admin = new Admin();
        Estudiante estudiante = new Estudiante();
        public PantallaAdmin() {
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
                setTitle("Pantalla Administrador");
                getContentPane().setBackground(new Color(52, 72, 202));
                setBounds(0, 0, 1000, 1000);
                setVisible(true);
                setResizable(false);
                setLocationRelativeTo(null);

                comboE = new JComboBox();
                try {estudiantes=datosE.bucarTodos();
                        for (Estudiante estudiante:estudiantes) {
                                comboE.addItem(estudiante);
                        }
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
                comboP = new JComboBox<>();
                comboP2 = new JComboBox<>();
                try {profesores=datosP.bucarTodos();
                        for (Profesor profesor:profesores) {
                                comboP.addItem(profesores);
                                comboP2.addItem(profesor);
                        }
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
                comboC = new JComboBox<>();

                try {cursos=datosC.bucarTodos();
                        for (Curso curso:cursos) {
                                comboC.addItem(curso);
                        }
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }


                label5 = new JLabel("Administración");
                label5.setBounds(400,0,400,80);
                label5.setFont(new Font("Andale Mono",1,30));
                label5.setForeground(new Color(0,0,0));
                add(label5);

                button1 = new JButton("Refresh");
                button1.setBounds(900,0,100,40);
                button1.addActionListener(this);
                add(button1);

                panel1 = new JPanel();
                panel1.setLayout(null);
                panel1.setPreferredSize(new Dimension(800, 250));
                panel1.setBackground(new Color(202, 52, 104));


                label1 = new JLabel("Ingresa los Datos del estudiante ");
                label1.setBounds(90, 10, 800, 50);

                label1.setFont(new Font("Andale Mono", 1, 28));
                label1.setForeground(new Color(0, 0, 0));
                panel1.add(label1);

                field1 = new JTextField("Dni");
                field1.setBounds(90, 65, 90, 20);
                panel1.add(field1);
                field2 = new JTextField("Nombre");
                field2.setBounds(190, 65, 90, 20);
                panel1.add(field2);
                field3 = new JTextField("Email");
                field3.setBounds(290, 65, 90, 20);
                panel1.add(field3);
                field4 = new JTextField("Telefono");
                field4.setBounds(390, 65, 90, 20);
                panel1.add(field4);
                label6 = new JLabel(" Lista de Estudiantes");
                label6.setBounds(90, 150, 800, 50);
                label6.setFont(new Font("Andale Mono", 1, 24));
                label6.setForeground(new Color(0, 0, 0));
                panel1.add(label6);
                comboE.setBounds(90,200,500,25);
                panel1.add(comboE);
                Botonera botonera = new Botonera(1);
                comboE.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                Estudiante Eselecionado = (Estudiante) comboE.getSelectedItem();
                                botonera.codigo_estu(Eselecionado);
                        }
                });
                botonera.setTextFieldReferences(field1, field2, field3, field4,field1);

                panel1.add(botonera);
                botonera.setBounds(90, 100, 550, 80);
                add(panel1);


                /*button1 = new JButton("Crear Alumno");
                button1.setBounds(590, 170, 150, 50);
                panel1.add(button1);
                button1.addActionListener(this);*/
                panel2 = new JPanel();
                panel2.setLayout(null);
                panel2.setPreferredSize(new Dimension(800, 250));
                panel2.setBackground(new Color(202, 52, 104));

                label2 = new JLabel("Ingresa los Datos del Profesor");
                label2.setBounds(90, 10, 800, 50);
                label2.setFont(new Font("Andale Mono", 1, 28));
                label2.setForeground(new Color(0, 0, 0));
                panel2.add(label2);

                field5 = new JTextField("Dni");
                field5.setBounds(90, 65, 90, 20);
                panel2.add(field5);
                field6 = new JTextField("Nombre");
                field6.setBounds(190, 65, 90, 20);
                panel2.add(field6);
                field7 = new JTextField("Email");
                field7.setBounds(290, 65, 90, 20);
                panel2.add(field7);
                field8 = new JTextField("Telefono");
                field8.setBounds(390, 65, 90, 20);
                panel2.add(field8);
                label4 = new JLabel(" Lista de Profesores");
                label4.setBounds(90, 150, 800, 50);
                label4.setFont(new Font("Andale Mono", 1, 24));
                label4.setForeground(new Color(0, 0, 0));
                panel2.add(label4);
                comboP2.setBounds(90,200,500,25);
                Botonera botonera2 = new Botonera(2);
                comboP2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                Profesor Pseleccionado = (Profesor) comboP2.getSelectedItem();
                                botonera2.codigo_profe(Pseleccionado);
                        }
                });

                panel2.add(comboP2);
                botonera2.setBounds(90, 100, 550, 80);
                botonera2.setTextFieldReferences(field5, field6, field7, field8,field5);
                panel2.add(botonera2);
                add(panel2);
                /*button2 = new JButton("Crear Profesor");
                button2.setBounds(590, 420, 150, 50);
                add(button2);
                button2.addActionListener(this);
                 */

                panel3 = new JPanel();
                panel3.setLayout(null);
                panel3.setPreferredSize(new Dimension(800, 250));
                panel3.setBackground(new Color(202, 52, 104));

                label3 = new JLabel("Ingresa los Datos de la Materia");
                label3.setBounds(90, 10, 800, 50);
                label3.setFont(new Font("Andale Mono", 1, 28));
                label3.setForeground(new Color(0, 0, 0));
                panel3.add(label3);

                field9 = new JTextField(" Materia");
                field9.setBounds(90, 65, 90, 20);
                panel3.add(field9);
                field10 = new JTextField("Cupo");
                field10.setBounds(190, 65, 90, 20);
                panel3.add(field10);
                field11 = new JTextField("Nota");
                field11.setBounds(290, 65, 90, 20);
                panel3.add(field11);
                field12 = new JTextField("Costo");
                field12.setBounds(390, 65, 90, 20);
                panel3.add(field12);
                field13 = new JTextField("dni profesor");
                field13.setBounds(490, 65, 90, 20);
                panel3.add(field13);
                label7 = new JLabel(" Lista de Materias");
                label7.setBounds(90, 150, 800, 50);
                label7.setFont(new Font("Andale Mono", 1, 24));
                label7.setForeground(new Color(0, 0, 0));
                panel3.add(label7);
                comboC.setBounds(90,200,600,25);
                Botonera botonera3 = new Botonera(3);
                comboC.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                Curso Cselecionado = (Curso) comboC.getSelectedItem();
                                botonera3.codigo_curso(Cselecionado);
                        }
                });
                comboC.addActionListener(this);
                panel3.add(comboC);

                botonera3.setBounds(90, 100, 550, 80);
                botonera3.setTextFieldReferences(field9, field10, field11, field12,field13);
                panel3.add(botonera3);
                add(panel3);




                button4 = new JButton("Emitir Reporte");
                button4.setPreferredSize(new Dimension(400, 80));
                button4.addActionListener(this);
                add(button4);





        }

        @Override
        public void actionPerformed(ActionEvent e) {
                Curso Cselecionado = (Curso) comboC.getSelectedItem();

                if(e.getSource() == button1){
                        PantallaAdmin pantallaAdmin = new PantallaAdmin();
                        this.setVisible(false);


                }


                if(e.getSource() == button4){
                        System.out.println("Si me preciono :)");

                        admin.emitirReporte(Cselecionado.getCodCurso());

                }
        }
}
