package org.example.AirLlucmajor;

public class añadirVuelosDisp {
    int dia;
    int mes;
    int año;
    double precio;
    String origen;
    String destino;
    boolean estado;

    public añadirVuelosDisp(int dia, int mes, int año, double precio, String origen, String destino, boolean estado) {
        if (dia >= 1 && dia <= 31) {
            this.dia = dia;
        }

        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        }
        this.año = año;
        this.precio = precio;
        this.origen = origen;
        this.destino = destino;
        this.estado = estado;
    }

    public añadirVuelosDisp() {
    }

}
