package Pago;

public class ModeloPago {

    private String placa;
    private long horas;
    private double total;

    public ModeloPago(String placa, long horas, double total) {
        this.placa = placa;
        this.horas = horas;
        this.total = total;
    }

    public String getPlaca() {
        return placa;
    }

    public long getHoras() {
        return horas;
    }

    public double getTotal() {
        return total;
    }
}