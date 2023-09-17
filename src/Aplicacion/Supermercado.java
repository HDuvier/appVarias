package Aplicacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Supermercado extends JFrame {

    public JPanel panelSup;
    public JTextField cajaValue;
    public JTextField cajaCant;
    public JTextArea areaSal;
    public Supermercado(){
        setSize(600,500);
        setLocationRelativeTo(null);
        setTitle("OFERTAS DEL SUPERMERCADO");
        panelSuper();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void panelSuper(){
        panelSup = new JPanel();
        panelSup.setLayout(null);
        this.getContentPane().add(panelSup);
        cajaValor();
        cajaCantidad();
        textoCant();
        textoValor();
        botonSup();
        salidaText();
    }
    private void cajaValor(){
        cajaValue = new JTextField();
        cajaValue.setBounds(50,100,100,15);
        panelSup.add(cajaValue);
    }

    private void cajaCantidad(){
        cajaCant = new JTextField();
        cajaCant.setBounds(50,130,100,15);
        panelSup.add(cajaCant);
    }

    private void textoValor(){
        JLabel textoVal = new JLabel();
        textoVal.setText("ingrese el valor del producto");
        textoVal.setBounds(200,100,200,15);
        panelSup.add(textoVal);
    }

    private void textoCant(){
        JLabel textoCan = new JLabel();
        textoCan.setBounds(200,130,200,15);
        textoCan.setText("ingrese las unidades del producto");
        panelSup.add(textoCan);
    }

    private void salidaText(){
        areaSal = new JTextArea();
        areaSal.setBounds(100,210,300,100);
        panelSup.add(areaSal);
    }
    private double esDocena(int cantidad){
        double docenas = cantidad/12;
        return docenas;
    }

    private void botonSup(){
        JButton botonSuper = new JButton();
        botonSuper.setBounds(100,180,200,20);
        botonSuper.setText("calcular oferta");
        panelSup.add(botonSuper);

        ActionListener oferta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cantidad = Integer.parseInt(cajaCant.getText());
                double cantDoc = esDocena(cantidad);
                double unidAd = cantDoc/3;
                int valor = Integer.parseInt(cajaValue.getText());

                if (unidAd<1){
                    double total = valor*cantidad;
                    areaSal.setText("no tiene unidades adicionales\n total de la compra"+total+"\ntotal a pagar"+(total-(total*0.1))
                            +"\ntotal descuento: "+(total-(total*0.9)));

                } else if (unidAd>=1) {
                    double total = valor *cantidad;
                    areaSal.setText("tiene"+unidAd+"unidades adicionales\n total de la compra: "+ total+"\ntotal a pagar: "+(total-(total*0.1))
                            +"\ntotal descuento: "+(total-(total*0.9)));
                }


            }
        };botonSuper.addActionListener(oferta);



    }


}
