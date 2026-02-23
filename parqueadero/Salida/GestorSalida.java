package Salida;

import Entrada.ModeloEntrada;

import java.time.LocalDateTime;

public class GestorSalida {

    public ModeloSalida registrarSalida(ModeloEntrada entrada) {

        if (entrada == null) {
            throw new IllegalArgumentException("No existe registro de entrada");
        }

        LocalDateTime horaSalida = LocalDateTime.now();

        return new ModeloSalida(
                entrada.getPlaca(),
                horaSalida
        );
    }
}