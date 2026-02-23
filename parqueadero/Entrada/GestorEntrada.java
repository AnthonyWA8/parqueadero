package Entrada;

import java.time.LocalDateTime;

public class GestorEntrada {

    public ModeloEntrada registrarEntrada(String placa, String tipo) {

        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("La placa es obligatoria");
        }

        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("El tipo de vehículo es obligatorio");
        }

        LocalDateTime horaActual = LocalDateTime.now();

        return new ModeloEntrada(placa, horaActual, tipo);
    }
}
