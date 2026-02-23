package Pago;

import Entrada.ModeloEntrada;
import Salida.ModeloSalida;

import java.time.Duration;

public class GestorPago {

    private Calculadora calculadora;

    public GestorPago() {
        this.calculadora = new Calculadora();
    }

    public ModeloPago generarPago(ModeloEntrada entrada, ModeloSalida salida) {

        if (entrada == null || salida == null) {
            throw new IllegalArgumentException("Entrada o salida inválida");
        }

        long horas = Duration.between(
                entrada.getHoraEntrada(),
                salida.getHoraSalida()
        ).toHours();

        if (horas <= 0) {
            horas = 1;
        }

        double total = calculadora.calcularTotal(
                entrada.getTipo(),
                horas
        );

        return new ModeloPago(
                entrada.getPlaca(),
                horas,
                total
        );
    }
}