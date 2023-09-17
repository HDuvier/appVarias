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
    }

    private void textoBecas(){
        JLabel textoBeca = new JLabel() ;
        textoBeca.setBounds(50,70,200,20);
        textoBeca.setText("Ingrese el numero de estudiantes");
        panelBeca.add(textoBeca);
    }
    private void cajaBecas(){
        cajaBeca=new JTextField();
        cajaBeca.setBounds(50,100,50,15);
        panelBeca.add(cajaBeca);
    }

    private void salida(){
        areaSal = new JTextArea();
        areaSal.setBounds(50,200,300,200);
        panelBeca.add(areaSal);
    }
    private void botonBecas(){
        JButton botonBeca = new JButton();
        botonBeca.setText("calcular");
        botonBeca.setBounds(200,100,100,15);
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
            String promedio = JOptionPane.showInputDialog(null, "promedio estudiante");
            int prom = Integer.parseInt(promedio);
            if (prom <0 || prom>50){
                JOptionPane.showMessageDialog(null,"El valor del promedio debe estar entre cero y 50");
                break;
            }
            String deporte = JOptionPane.showInputDialog(null, "hace deporte");
            String matricula= JOptionPane.showInputDialog(null,"valor de la matricula");


            boolean y= descuento(prom, deporte,matricula);
            contador++;
            double matri = Double.parseDouble(matricula);
            valorMatri =valorMatri + matri;
            if (y){
            matriDesc=matriDesc + (matri/2);
            contDesc++;
            }
            areaSal.setText(" contDesc: "+contDesc+" valorMatri: "+valorMatri+" matriDesc: "+matriDesc);

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
