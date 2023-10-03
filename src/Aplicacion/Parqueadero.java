package Aplicacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Parqueadero extends JFrame {
    public JPanel panelParqueadero;
    public JTextField nombre;
    public JTextField placa;
    public JTextField Marca;
    public JTextField horaEntrada;
    public JTextField minEntrada;
    public JTextField horaSalida;
    public JTextField minSalida;
    public JTextArea areaSalida;

    public Parqueadero(){
        this.setSize(600,500);
        setLocationRelativeTo(null);
        setTitle("PARQUEADERO");
        panelParquea();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void panelParquea(){
        panelParqueadero=new JPanel();
        panelParqueadero.setLayout(null);
        this.getContentPane().add(panelParqueadero);
        tituloparqueadero();
        textoparqueadero();
        textonombre();
        cajaNombre();
        textoplaca();
        cajaPlaca();
        textomarca();
        cajaMarca();
        textoentrada();
        textosalida();
        horaEntrada();
        minEntrada();
        minSalida();
        horaSalida();
        calcular();
        salidaDatos();
        salir();
        volver();
    }

    private void tituloparqueadero(){
        JLabel tituloP = new JLabel();
        tituloP.setText("COSTO DEL PARQUEADERO");
        tituloP.setBounds(200,20,300,10);
        panelParqueadero.add(tituloP);
    }
    private void textoparqueadero(){
        JLabel textoP = new JLabel();
        textoP.setText("INGRESE LOS DATOS");
        textoP.setBounds(200,40,300,10);
        panelParqueadero.add(textoP);
    }
    private void textonombre(){
        JLabel textoNombre = new JLabel();
        textoNombre.setText("INGRESE EL NOMBRE");
        textoNombre.setBounds(50,100,300,10);
        panelParqueadero.add(textoNombre);
    }
    private void cajaNombre(){
        nombre=new JTextField();
        nombre.setBounds(300,100,100,15);
        nombre.setText("NOMBRE");
        panelParqueadero.add(nombre);

    }
    private void textoplaca(){
        JLabel textoPlaca = new JLabel();
        textoPlaca.setText("INGRESE LA PLACA");
        textoPlaca.setBounds(50,130,300,10);
        panelParqueadero.add(textoPlaca);

    }
    private void cajaPlaca(){
        placa =new JTextField();
        placa.setBounds(300,130,100,15);
        placa.setText("PLACA");
        panelParqueadero.add(placa);
    }
    private void textomarca(){
        JLabel textoMarca = new JLabel();
        textoMarca.setText("INGRESE LA MARCA");
        textoMarca.setBounds(50,150,300,10);
        panelParqueadero.add(textoMarca);
    }

    private void cajaMarca(){
        Marca =new JTextField();
        Marca.setBounds(300,150,100,15);
        Marca.setText("MARCA");
        panelParqueadero.add(Marca);
    }
    private void textoentrada(){
        JLabel textoEntrada = new JLabel();
        textoEntrada.setText("INGRESE LA HORA DE ENTRADA");
        textoEntrada.setBounds(50,170,300,10);
        panelParqueadero.add(textoEntrada);
    }

    private void horaEntrada(){
        horaEntrada =new JTextField();
        horaEntrada.setBounds(300,170,100,15);
        horaEntrada.setText("HORAS");
        panelParqueadero.add(horaEntrada);
    }

    private void minEntrada(){
        minEntrada =new JTextField();
        minEntrada.setBounds(420,170,100,15);
        minEntrada.setText("MINUTOS");
        panelParqueadero.add(minEntrada);
    }
    private void textosalida(){
        JLabel textoSalida = new JLabel();
        textoSalida.setText("INGRESE LA HORA DE SALIDA");
        textoSalida.setBounds(50,190,300,10);
        panelParqueadero.add(textoSalida);
    }

    private void horaSalida(){
        horaSalida =new JTextField();
        horaSalida.setBounds(300,190,100,15);
        horaSalida.setText("HORAS");
        panelParqueadero.add(horaSalida);
    }

    private void minSalida(){
        minSalida =new JTextField();
        minSalida.setBounds(420,190,100,15);
        minSalida.setText("MINUTOS");
        panelParqueadero.add(minSalida);
    }

    private void salidaDatos(){
        areaSalida =new JTextArea();
        areaSalida.setBounds(150,330,400,120);
        panelParqueadero.add(areaSalida);
    }
    private void calcular(){
        JButton bCalculo = new JButton();
        bCalculo.setText("CALCULAR VALOR");
        bCalculo.setBounds(300,240,210,15);
        panelParqueadero.add(bCalculo);

        ActionListener calcular = e -> {
            int hourA = Integer.parseInt(horaEntrada.getText());
            int minA = Integer.parseInt(minEntrada.getText());
            int hourB = Integer.parseInt(horaSalida.getText());
            int minB = Integer.parseInt(minSalida.getText());

            ArrayList tiempos = new ArrayList<>(inputs(hourA,minA,hourB,minB));
            int valor = valores(inputs(hourA,minA,hourB,minB));

            areaSalida.append(" nombre: "+ nombre.getText()+ "\n placa: "+placa.getText()+"\n marca: "+Marca.getText()+
                    "\n valor total: "+ valor+"\n tiempo: "+tiempos.get(0)+":"+tiempos.get(1));
        };
        bCalculo.addActionListener(calcular);

    }

    private void salir(){
        JButton bsalir = new JButton();
        bsalir.setText("SALIR");
        bsalir.setBounds(380,300,110,15);
        panelParqueadero.add(bsalir);

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
        bvolver.setBounds(150,300,210,15);
        panelParqueadero.add(bvolver);

        ActionListener volver = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaPrincipal pantalla= new PantallaPrincipal();
                pantalla.setVisible(true);
            }
        };
        bvolver.addActionListener(volver);

    }
    public static ArrayList inputs(int hA, int A, int hB, int B) {

        int totalMin = 0;
        int totalH = 0;
        ArrayList<String> time = new ArrayList<>();

        if (A > 59 || B > 59 || hB > 23 || hA > 23) {
            JOptionPane.showMessageDialog(null, "valor incorrecto");
        } else if (A < B) {
            totalMin = B - A;
            totalH = hB - hA;
            time.add(String.valueOf(totalH));
            time.add(String.valueOf(totalMin));
        } else if (A > B) {
            totalMin = (B + 60) - A;
            totalH = hB - hA - 1;
            time.add(String.valueOf(totalH));
            time.add(String.valueOf(totalMin));
        }
        System.out.println(time);
        return time;
    }


    public static int valores(ArrayList a) {
        int hours = Integer.parseInt((String) a.get(0));
        int minutes = Integer.parseInt((String) a.get(1));
        int valorTotal = 0;

        if (hours >= 3) {
            valorTotal = 16000;
        } else if (hours >= 1 || hours < 3) {
            valorTotal = (hours * 4600) + (minutes * 75);
        } else if (hours == 0) {
            valorTotal = minutes * 75;
        }
        return valorTotal;
    }
}

