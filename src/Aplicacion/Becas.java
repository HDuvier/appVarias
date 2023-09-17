package Aplicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Becas extends JFrame{
    public JPanel panelBeca;
    public JTextField cajaBeca;
    public JTextArea areaSal;

    public Becas(){
        setSize(600,500);
        setLocationRelativeTo(null);
        setTitle("CALCULO DE BECAS");
        panelBecas();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void panelBecas() {
        panelBeca = new JPanel();
        panelBeca.setLayout(null);
        this.getContentPane().add(panelBeca);
        botonBecas();
        cajaBecas();
        salida();
        textoBecas();
        botonSalida();
    }

    private void textoBecas(){
        JLabel textoBeca = new JLabel() ;
        textoBeca.setBounds(200,70,200,25);
        textoBeca.setText("Ingrese el numero de estudiantes");
        panelBeca.add(textoBeca);
    }
    private void cajaBecas(){
        cajaBeca=new JTextField();
        cajaBeca.setBounds(150,100,70,25);
        panelBeca.add(cajaBeca);
    }

    private void salida(){
        areaSal = new JTextArea();
        areaSal.setBounds(100,180,400,200);
        panelBeca.add(areaSal);
    }

    private void botonSalida(){
        JButton botonSalida = new JButton();
        botonSalida.setText("Volver");
        botonSalida.setBounds(260,420,80,30);
        panelBeca.add(botonSalida);

        ActionListener volver = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
                pantallaPrincipal.setVisible(true);
            }
        };botonSalida.addActionListener(volver);
    }
    private void botonBecas(){
        JButton botonBeca = new JButton();
        botonBeca.setText("calcular");
        botonBeca.setBounds(300,100,100,30);
        panelBeca.add(botonBeca);


        ActionListener calcular = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int contador=0;
                String cant = cajaBeca.getText();
                boton(cant , contador);

            }
        };botonBeca.addActionListener(calcular);
    }



    private void boton(String cantidad, int contador) {
        int cant = Integer.parseInt(cantidad);
        double valorMatri = 0;
        double matriDesc =0;
        int contDesc = 0;

        for (int i = 0; i < cant; i++) {
            String promedio = JOptionPane.showInputDialog(null, "Promedio del estudiante entre 0 y 50");
            int prom = Integer.parseInt(promedio);
            if (prom <0 || prom>50){
                JOptionPane.showMessageDialog(null,"El valor del promedio debe estar entre cero y 50");
                break;
            }
            String deporte = JOptionPane.showInputDialog(null, "¿Practica algun deporte?");
            String matricula= JOptionPane.showInputDialog(null,"Valor de la matrícula");


            boolean y= descuento(prom, deporte,matricula);
            contador++;
            double matri = Double.parseDouble(matricula);
            valorMatri =valorMatri + matri;
            if (y){
            matriDesc=matriDesc + (matri/2);
            contDesc++;
            }
            areaSal.setText(" \nLa cantidad de descuentos aplicados han sido: "+contDesc+" \n El valor total de las matriculas sin descuento es: "
                    +valorMatri+"\n El valor total de los descuentos aplicados en matriculas es: "+matriDesc);

        }
    }


    private boolean descuento(int prom,String depor,String matricula) {
        double valorMatricula = Double.parseDouble(matricula);
        boolean si;


        if (prom >= 45) {
            JOptionPane.showMessageDialog(null, "aplica descuento 50% por promedio superior a 45 de "
                    +(valorMatricula/2));
            si=true;
        } else if (prom > 40 && "si".equals(depor)) {
            JOptionPane.showMessageDialog(null, "aplica descuento 50% por promedio superior a 40 y " +
                    "hacer algun deporte, el valor es" + (valorMatricula/2));
            si=true;
        } else {
            JOptionPane.showMessageDialog(null, "no aplica descuento");
            si=false;
        }
        return si;
    }


}
