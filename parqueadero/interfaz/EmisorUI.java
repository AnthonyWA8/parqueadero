package interfaz;

import Entrada.ModeloEntrada;
import Pago.GestorPago;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EmisorUI extends JFrame {

    private List<ModeloEntrada> entradasRegistradas = new ArrayList<>();
    private GestorPago gestorPago = new GestorPago();

    private JTextArea areaVehiculos;
    private JButton btnEntrada;
    private JButton btnSalida;

    public EmisorUI() {
        initComponents();
    }

    private void initComponents() {
        areaVehiculos = new JTextArea(10, 40);
        areaVehiculos.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaVehiculos);

        btnEntrada = new JButton("ENTRADA");
        btnSalida = new JButton("SALIDA");

        btnEntrada.addActionListener(e -> abrirIngreso());
        btnSalida.addActionListener(e -> abrirSalida());

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(scroll)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEntrada, 150, 150, 150)
                                .addComponent(btnSalida, 150, 150, 150))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(scroll, 200, 200, 200)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnEntrada, 50, 50, 50)
                                .addComponent(btnSalida, 50, 50, 50))
        );

        setTitle("Parqueadero");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        actualizarLista();
    }

    private void abrirIngreso() {
        PanelIngreso ingreso = new PanelIngreso(entradasRegistradas, this);
        ingreso.setVisible(true);
        ingreso.setLocationRelativeTo(this);
    }

    private void abrirSalida() {
        PanelSalida salida = new PanelSalida(entradasRegistradas, gestorPago, this);
        salida.setVisible(true);
        salida.setLocationRelativeTo(this);
    }

    public void actualizarLista() {
        StringBuilder sb = new StringBuilder();
        sb.append("Placa | Tipo\n");
        for (ModeloEntrada e : entradasRegistradas) {
            sb.append(e.getPlaca())
                    .append(" | ")
                    .append(e.getTipo())
                    .append("\n");
        }
        areaVehiculos.setText(sb.toString());
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new EmisorUI().setVisible(true));
    }
}