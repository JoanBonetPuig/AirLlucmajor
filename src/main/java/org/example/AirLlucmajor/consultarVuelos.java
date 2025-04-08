package org.example.AirLlucmajor;

import java.util.ArrayList;

public class consultarVuelos {

    public boolean consultarVuelosDiaYMes(ArrayList<añadirVuelosDisp> vuelos, int dia, int mes) {
        boolean vuelosEncontrados = false;

        for (añadirVuelosDisp vuelo : vuelos) {
            if (vuelo.dia == dia && vuelo.mes == mes) {
                vuelosEncontrados = true;
                System.out.println("📅 Vuelo encontrado, su estado actual es: " + vuelo.estado);
            }
        }


        if (!vuelosEncontrados) {
            System.out.println("❌ No hay vuelos reservados para esa fecha.");
        }
        return vuelosEncontrados;
    }
}
