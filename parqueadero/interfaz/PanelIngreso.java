package interfaz;

import Entrada.GestorEntrada;
import Entrada.ModeloEntrada;

import javax.swing.*;
import java.util.List;

public class PanelIngreso extends JFrame {

    private List<ModeloEntrada> entradasRegistradas;
    private EmisorUI emisorUI;

    private JTextField jTextPlaca;
    private JTextField jTextTipo;
    private JButton jButtonRegistrar;

    public PanelIngreso(List<ModeloEntrada> entradas, EmisorUI emisor) {
        this.entradasRegistradas = entradas;
        this.emisorUI = emisor;
        initComponents();
    }

    private void initComponents() {
        jTextPlaca = new JTextField();
        jTextTipo = new JTextField();
        jButtonRegistrar = new JButton("Registrar Entrada");

        JLabel labelPlaca = new JLabel("PLACA");
        JLabel labelTipo = new JLabel("TIPO (Carro/Moto)");

        jButtonRegistrar.addActionListener(e -> registrarEntrada());

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
                                .addComponent(labelTipo)
                                .addComponent(jTextTipo, 200, 200, 200))
                        .addComponent(jButtonRegistrar, 200, 200, 200)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelPlaca)
                                .addComponent(jTextPlaca, 40, 40, 40))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelTipo)
                                .addComponent(jTextTipo, 40, 40, 40))
                        .addComponent(jButtonRegistrar, 50, 50, 50)
        );

        setTitle("Registro de Entrada");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void registrarEntrada() {
        try {
            String placa = jTextPlaca.getText().trim();
            String tipo = jTextTipo.getText().trim();

            if (placa.isEmpty() || tipo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar placa y tipo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ModeloEntrada entrada = GestorEntrada.registrarEntrada(placa, tipo);
            entradasRegistradas.add(entrada);

            JOptionPane.showMessageDialog(this,
                    "Entrada registrada: " + entrada.getPlaca() + " Tipo: " + entrada.getTipo());

            jTextPlaca.setText("");
            jTextTipo.setText("");

            emisorUI.actualizarLista();

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}