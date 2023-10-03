package Aplicacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tablas extends JFrame{

    public JPanel panelTablas;
    public Tablas(){
        setSize(600,500);
        setLocationRelativeTo(null);
        setTitle("TABLAS DE MULTIPLICAR");
        panelTablas();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void panelTablas(){
        panelTablas= new JPanel();
        panelTablas.setLayout(null);
        this.getContentPane().add(panelTablas);
        titulotablas();
        textotablas();
        botontabla2();
        botontabla4();
        botontabla6();
        volver();
        salir();
    }

    private void titulotablas(){
        JLabel tituloT = new JLabel();
        tituloT.setText("TABLAS DE MULTIPLICAR");
        tituloT.setBounds(200,20,300,10);
        panelTablas.add(tituloT);
    }

    private void textotablas(){
        JLabel textoT = new JLabel();
        textoT.setText("ELIJA LA TABLA DE MULTIPLICAR QUE DESEA CONOCER");
        textoT.setBounds(100,50,500,10);
        panelTablas.add(textoT);
    }

    private void botontabla2(){
        JButton tabla2 =new JButton();
        tabla2.setText("TABLA DEL 2");
        tabla2.setBounds(100,150,150,20);
        panelTablas.add(tabla2);

        ActionListener tablade2 = e -> {
            int number =2;
            ArrayList result = new ArrayList<>(multiplicar(number));
            JOptionPane.showMessageDialog(null,("tabla del "+number+"\n"+number+" * 0= "+result.get(0))+
                    "\n"+number+" * 1= "+result.get(1)+"\n"+number+" * 2= "+result.get(2)+"\n"+number+" * 3= "+result.get(3)+
                    "\n"+number+" * 4= "+result.get(4)+"\n"+number+" * 5= "+result.get(5)+"\n"+number+" * 6= "+result.get(6)
                    +"\n"+number+" * 7= "+result.get(7)+"\n"+number+" * 8= "+result.get(8)+"\n"+number+" * 9= "+result.get(9)+
                    "\n"+number+" * 10= "+result.get(10));
        };
        tabla2.addActionListener(tablade2);
    }

    private void botontabla4(){
        JButton tabla4 =new JButton();
        tabla4.setText("TABLA DEL 4");
        tabla4.setBounds(100,250,150,20);
        panelTablas.add(tabla4);

        ActionListener tablade4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number =4;
                ArrayList result = new ArrayList<>(multiplicar(number));
                JOptionPane.showMessageDialog(null,("tabla del "+number+"\n"+number+" * 0= "+result.get(0))+
                        "\n"+number+" * 1= "+result.get(1)+"\n"+number+" * 2= "+result.get(2)+"\n"+number+" * 3= "+result.get(3)+
                        "\n"+number+" * 4= "+result.get(4)+"\n"+number+" * 5= "+result.get(5)+"\n"+number+" * 6= "+result.get(6)
                        +"\n"+number+" * 7= "+result.get(7)+"\n"+number+" * 8= "+result.get(8)+"\n"+number+" * 9= "+result.get(9)+
                        "\n"+number+" * 10= "+result.get(10));
            }
        };
        tabla4.addActionListener(tablade4);
    }

    private void botontabla6(){
        JButton tabla6 =new JButton();
        tabla6.setText("TABLA DEL 6");
        tabla6.setBounds(100,350,150,20);
        panelTablas.add(tabla6);

        ActionListener tablade6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number =6;
                ArrayList result = new ArrayList<>(multiplicar(number));
                JOptionPane.showMessageDialog(null,("tabla del "+number+"\n"+number+" * 0= "+result.get(0))+
                        "\n"+number+" * 1= "+result.get(1)+"\n"+number+" * 2= "+result.get(2)+"\n"+number+" * 3= "+result.get(3)+
                        "\n"+number+" * 4= "+result.get(4)+"\n"+number+" * 5= "+result.get(5)+"\n"+number+" * 6= "+result.get(6)
                        +"\n"+number+" * 7= "+result.get(7)+"\n"+number+" * 8= "+result.get(8)+"\n"+number+" * 9= "+result.get(9)+
                        "\n"+number+" * 10= "+result.get(10));

            }
        };
        tabla6.addActionListener(tablade6);
    }

    private void salir(){
        JButton bsalir = new JButton();
        bsalir.setText("SALIR");
        bsalir.setBounds(380,300,110,15);
        panelTablas.add(bsalir);

        ActionListener salida = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        };
        bsalir.addActionListener(salida);

    }

    private void volver(){
        JButton bvolver = new JButton();
        bvolver.setText("PANTALLA PRINCIPAL");
        bvolver.setBounds(350,200,210,15);
        panelTablas.add(bvolver);

        ActionListener volver = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaPrincipal pantalla= new PantallaPrincipal();
                pantalla.setVisible(true);
            }
        };
        bvolver.addActionListener(volver);

    }


    public static ArrayList multiplicar(int multi) {
        int a;
        ArrayList result = new ArrayList<>();
        for (int i = 1; i <= multi; i++) {
            if(i==multi) {
                for (int j = 0; j < 11; j++) {
                    a = i * j;
                    result.add(a);
                }
            }

        }System.out.println(result);
        return result;

    }
}
