package Entrada;

import java.time.LocalDateTime;

public class ModeloEntrada {

    private String placa;
    private LocalDateTime horaEntrada;
    private String tipo;

    public ModeloEntrada(String placa, LocalDateTime horaEntrada, String tipo) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public String getTipo() {
        return tipo;
    }
}
