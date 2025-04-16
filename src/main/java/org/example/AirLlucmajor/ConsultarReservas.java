package org.example.AirLlucmajor;

import java.util.ArrayList;
import java.util.List;

public class ConsultarReservas {
    public static List<String> consultarReservasPorNombre(ArrayList<String> reservas, String nombreUsuario) {
        List<String> reservasUsuario = new ArrayList<>();

        for (String reserva : reservas) {
            if (reserva.toLowerCase().contains("usuario: " + nombreUsuario.toLowerCase())) {
                reservasUsuario.add(reserva);
            }
        }

        return reservasUsuario;
    }
}