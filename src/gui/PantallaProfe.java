package gui;

import controller.*;
import service.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PantallaProfe extends JFrame implements ActionListener {




    private JLabel label1, label2;
    private JTextField field1,field2;


    private JButton button1;
    ArrayList<Lista> lista = new ArrayList<>();
    private JComboBox combo1;
    Profesor profe = new Profesor();
    public PantallaProfe(Profesor profe1) {
        profe=profe1;
        String nombre = profe.getNombre();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Pantalla Administrador");
        getContentPane().setBackground(new Color(52, 72, 202));
        setBounds(0, 0, 1000, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        combo1 = new JComboBox();
        lista = profe.ListaProfe(profe.getDni());
        for (Lista lista:lista){
            combo1.addItem(lista);
        }
        combo1.setBounds(100,220,300,25);
        combo1.addActionListener(this);
        add(combo1);
        label1 = new JLabel("Lista de Cursos");
        label1.setBounds(100,150,400,90);
        label1.setFont(new Font("Andale Mono",1,24));
        label1.setForeground(new Color(0,0,0));
        add(label1);
        label2=new JLabel("Hola de vuelta profe "+profe.getNombre());
        label2.setBounds(220,50,700,200);
        label2.setFont(new Font("Andale Mono",1,38));
        label2.setForeground(new Color(0,0,0));
        add(label2);
        field2=new JTextField("Nota");
        field2.setBounds(200,280,80,20);
        add(field2);
        button1 = new JButton("Subir nota");
        button1.setBounds(320,280,100,40);
        button1.addActionListener(this);
        add(button1);


    }





    @Override
    public void actionPerformed(ActionEvent e) {
        Lista Lselec = (Lista) combo1.getSelectedItem();
    if(e.getSource() == button1){
        int nota = Integer.parseInt(field2.getText());
        if (nota > 0 && nota < 11  ) {
            profe.SubirNotas(Lselec.getCodLista(), nota);
        }else {
            JOptionPane.showMessageDialog(null,"la nota que ingreso no esta dentro de los limites");
        }

    }
    }
}
