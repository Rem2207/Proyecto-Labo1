package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.Lista;
import java.util.ArrayList;
import controller.Estudiante;


public class Calificaciones extends JFrame {
    private JComboBox<Lista> listaJComboBox = new JComboBox<>();

    ArrayList<Lista> lista = new ArrayList<>();
    private Estudiante alumno = new Estudiante();

    Calificaciones(Estudiante alumno1) {
        alumno = alumno1;


        setLayout(null);
        setTitle("Calificaciones");
        getContentPane().setBackground(new Color(52, 72, 202));
        setBounds(0, 0, 700, 400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        lista = alumno.VerNotas(alumno.getDni());
        for (Lista lista : lista) {
            listaJComboBox.addItem(lista);
        }
        listaJComboBox.setBounds(120, 100, 500, 25);
        add(listaJComboBox);

    }
}


