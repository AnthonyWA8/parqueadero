package Pago;

public class Calculadora {

    private final double TARIFA_CARRO = 3000;
    private final double TARIFA_MOTO = 2000;

    public double calcularTotal(String tipo, long horas) {

        double tarifa = obtenerTarifa(tipo);

        return tarifa * horas;
    }

    private double obtenerTarifa(String tipo) {

        if (tipo.equalsIgnoreCase("Carro")) {
            return TARIFA_CARRO;
        } else if (tipo.equalsIgnoreCase("Moto")) {
            return TARIFA_MOTO;
        } else {
            throw new IllegalArgumentException("Tipo de vehículo no soportado");
        }
    }
}
