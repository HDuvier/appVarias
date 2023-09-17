package Aplicacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JFrame {
    public JPanel panel1;
    public PantallaPrincipal(){
        setSize(600,500);
        setTitle("PANTALLA PRINCIPAL");
        setLocationRelativeTo(null);

        panel1();
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
    //panel principal
    private void panel1(){
        panel1 = new JPanel();
        panel1.setLayout(null);
        this.getContentPane().add(panel1);
        titulo();
        botonParqueadero();
        botonBecas();
        botonTablas();
        botonSuper();
        salir();



    }
    private void titulo(){
        JLabel texto1 = new JLabel();
        texto1.setText(" ELIJA LA FUNCION A LA QUE QUIERE ACCEDER");
        texto1.setBounds(100,20,300,10);
        panel1.add(texto1);
    }


    private void botonParqueadero(){
        JButton bparqueadero = new JButton();
        bparqueadero.setText("PARQUEADEROS");
        bparqueadero.setBounds(350,60,130,15);
        panel1.add(bparqueadero);



        ActionListener abrirParque = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Parqueadero parquea =new Parqueadero();
                parquea.setVisible(true);
            }
        };
        bparqueadero.addActionListener(abrirParque);

    }
    private void botonBecas(){
        JButton bBecas = new JButton();
        bBecas.setText("BECAS");
        bBecas.setBounds(70,60,130,15);
        panel1.add(bBecas);

        ActionListener abrirBeca = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Becas beca=new Becas();
                beca.setVisible(true);
            }
        };
        bBecas.addActionListener(abrirBeca);


    }

    private void botonTablas(){
        JButton bTablas = new JButton();
        bTablas.setText("TABLAS DE MULTIPLICAR");
        bTablas.setBounds(50,160,200,15);
        panel1.add(bTablas);

        ActionListener abrirTablas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Tablas tabla= new Tablas();
               tabla.setVisible(true);
            }
        };
        bTablas.addActionListener(abrirTablas);

    }

    private void botonSuper(){
        JButton bsuper = new JButton();
        bsuper.setText("SUPERMERCADO");
        bsuper.setBounds(350,160,150,15);
        panel1.add(bsuper);
        ActionListener abrirSuper = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Supermercado superme= new Supermercado();
                superme.setVisible(true);
            }
        };
        bsuper.addActionListener(abrirSuper);

    }

    private void salir(){
        JButton bsalir = new JButton();
        bsalir.setText("SALIR");
        bsalir.setBounds(150,260,110,15);
        panel1.add(bsalir);

        ActionListener salida = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        };
        bsalir.addActionListener(salida);

    }


}
