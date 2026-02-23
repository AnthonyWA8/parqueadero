import interfaz.EmisorUI;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            EmisorUI ventanaPrincipal = new EmisorUI();
            ventanaPrincipal.setVisible(true);
        });
    }
}