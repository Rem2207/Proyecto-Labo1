package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.*;
import service.*;


public class Login extends JFrame implements ActionListener {
    private JComboBox combo1;
    private JLabel label1, label2, label3;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPanel jPanel1;
    private JButton jButton1;
    private JButton button1;
    public static String texto = "";
    public static String valordepassword = "";
    Estudiante alumno1 = new Estudiante();
    Admin admin1 = new Admin();
    Profesor profe1 = new Profesor();
    private EstudianteService baseE = new EstudianteService();
    private AdminService baseA = new AdminService();
    private ProfesorService baseP = new ProfesorService();

    public Login()  {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Login");
        getContentPane().setBackground(new Color(52,72,202));
        label1 = new JLabel("Registro de Alumnos");
        label1.setBounds(120,25,200,30);
        label1.setForeground(new Color(0, 0, 0));
        add(label1);

        label2 = new JLabel("Email");
        label2.setBounds(50,70,100,30);
        label2.setForeground(new Color(0,0,0));
        add(label2);

        label3 = new JLabel("Contraseña");
        label3.setBounds(50,90,100,30);
        label3.setForeground(new Color(0,0,0));
        add(label3);

        textField1 = new JTextField("");
        textField1.setBounds(120,75,150,20);
        add(textField1);

        passwordField1 = new  JPasswordField("");
        passwordField1.setBounds(120,95,150,20);
        add(passwordField1);

        jButton1 = new JButton("Iniciar Sesion");
        jButton1.setBounds(10,200,120,50);
        add(jButton1);
        jButton1.addActionListener(this);

        combo1 = new JComboBox<>();
        combo1.setBounds(250,150,100,20);
        add(combo1);

        combo1.addItem("Estudiante");
        combo1.addItem("Profesor");
        combo1.addItem("Administrador");
        combo1.addActionListener(this);

        setBounds(0,0,400,300);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario = null;
        int contra = 0;
        if (e.getSource() == jButton1) {
            String seleccion = combo1.getSelectedItem().toString();
            texto = textField1.getText().trim();
            valordepassword = passwordField1.getText().trim();
            if(!valordepassword.isEmpty() && !texto.isEmpty()) {
                if(seleccion.equals("Estudiante")) {



                    try {
                        alumno1 = baseE.buscar(Integer.parseInt(passwordField1.getText()));

                    } catch (ServiceException ex) {
                        throw new RuntimeException(ex);
                    }

                    if (alumno1 != null) {
                        usuario = alumno1.getEmail();
                        contra = alumno1.getDni();
                    }
                    if (texto.equals(usuario) && valordepassword.equals(String.valueOf(contra))) {
                        label1.setText("Logeo exitoso");
                        PantallaEstudiante pantalla = new PantallaEstudiante(alumno1);
                        this.setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "La contraseña o el Usuario son incorrectos");
                    }

                }

                if(seleccion.equals("Administrador")){





                            try {
                                admin1 = baseA.buscar(Integer.parseInt(passwordField1.getText()));

                            } catch (ServiceException ex) {
                                JOptionPane.showMessageDialog(null, "La contraseña o el Usuario son incorrectos");
                                throw new RuntimeException(ex);
                            }
                            if(admin1 != null) {
                                usuario = admin1.getEmail();
                                contra = admin1.getDni();
                            }
                            if (texto.equals(usuario) && valordepassword.equals(String.valueOf(contra))) {
                                label1.setText("Logeo exitoso");
                                PantallaAdmin pantalla = new PantallaAdmin();
                                this.setVisible(false);

                            } else {
                                JOptionPane.showMessageDialog(null, "La contraseña o el Usuario son incorrectos");
                            }


                }

                if(seleccion.equals("Profesor")){
                    try {
                        profe1 = baseP.buscar(Integer.parseInt(passwordField1.getText()));

                    } catch (ServiceException ex) {
                        JOptionPane.showMessageDialog(null, "La contraseña o el Usuario son incorrectos");
                        throw new RuntimeException(ex);
                    }
                    if (profe1 != null) {
                        usuario = profe1.getEmail();
                        contra = profe1.getDni();
                    }
                    if (texto.equals(usuario) && valordepassword.equals(String.valueOf(contra))) {
                        label1.setText("Logeo exitoso");
                        PantallaProfe pantalla = new PantallaProfe(profe1);
                        this.setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "La contraseña o el Usuario son incorrectos");
                    }



                }
            }else if(valordepassword.isEmpty() || texto.isEmpty()){
                JOptionPane.showMessageDialog(null, "Debes Ingesar los datos");
            }
        }
    }
}
