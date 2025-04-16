package org.example.AirLlucmajor;

import java.util.ArrayList;

public class CancelarReserva {
    public static boolean cancelarReserva(ArrayList<String> reservas, String nombreUsuario, String origen, String destino) {
        for (int i = 0; i < reservas.size(); i++) {
            String reserva = reservas.get(i);
            if (reserva.contains("Usuario: " + nombreUsuario) &&
                    reserva.contains(origen) &&
                    reserva.contains(destino)) {
                reservas.remove(i);
                return true;
            }
        }
        return false;
    }
}