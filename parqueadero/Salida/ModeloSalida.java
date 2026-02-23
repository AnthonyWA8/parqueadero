package Salida;

import java.time.LocalDateTime;

public class ModeloSalida {

    private String placa;
    private LocalDateTime horaSalida;

    public ModeloSalida(String placa, LocalDateTime horaSalida) {
        this.placa = placa;
        this.horaSalida = horaSalida;
    }

    public String getPlaca() {
        return placa;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }
}