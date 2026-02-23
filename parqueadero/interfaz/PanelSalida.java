package interfaz;

import Entrada.ModeloEntrada;
import Salida.GestorSalida;
import Salida.ModeloSalida;
import Pago.GestorPago;
import Pago.ModeloPago;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

public class PanelSalida extends JFrame {

    private List<ModeloEntrada> entradasRegistradas;
    private GestorPago gestorPago;
    private EmisorUI emisorUI;

    private JTextField jTextPlaca;
    private JTextField jTextTotal;
    private JButton jButtonSalida;

    public PanelSalida(List<ModeloEntrada> entradas, GestorPago gestor, EmisorUI emisor) {
        this.entradasRegistradas = entradas;
        this.gestorPago = gestor;
        this.emisorUI = emisor;
        initComponents();
    }

    private void initComponents() {
        jTextPlaca = new JTextField();
        jTextTotal = new JTextField();
        jTextTotal.setEditable(false);
        jButtonSalida = new JButton("Solicitar salida");

        JLabel labelPlaca = new JLabel("PLACA");
        JLabel labelTotal = new JLabel("Total a pagar");

        jButtonSalida.addActionListener(e -> procesarSalida());

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(labelPlaca)
                                .addComponent(jTextPlaca, 200, 200, 200))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(labelTotal)
                                .addComponent(jTextTotal, 100, 100, 100))
                        .addComponent(jButtonSalida, 200, 200, 200)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelPlaca)
                                .addComponent(jTextPlaca, 40, 40, 40))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelTotal)
                                .addComponent(jTextTotal, 40, 40, 40))
                        .addComponent(jButtonSalida, 50, 50, 50)
        );

        setTitle("Salida de Vehículo");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void procesarSalida() {
        try {
            String placa = jTextPlaca.getText().trim();
            if (placa.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese una placa", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ModeloEntrada entrada = entradasRegistradas.stream()
                    .filter(e -> e.getPlaca().equalsIgnoreCase(placa))
                    .findFirst()
                    .orElse(null);

            if (entrada == null) {
                JOptionPane.showMessageDialog(this, "Placa no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ModeloSalida salida = new GestorSalida().registrarSalida(entrada);
            ModeloPago pago = gestorPago.generarPago(entrada, salida);

            jTextTotal.setText(String.valueOf(pago.getTotal()));

            entradasRegistradas.remove(entrada);

            emisorUI.actualizarLista();

            JOptionPane.showMessageDialog(this, "Salida procesada correctamente");

            jTextPlaca.setText("");
            jTextTotal.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}