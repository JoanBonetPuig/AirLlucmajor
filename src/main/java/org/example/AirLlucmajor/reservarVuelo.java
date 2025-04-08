package org.example.AirLlucmajor;

import java.util.ArrayList;
import java.util.Scanner;

public class reservarVuelo {
    private static ArrayList<String> reservas = new ArrayList<>();

    public static void reservarVuelo(ArrayList<añadirVuelosDisp> vuelosDisponibles) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<añadirVuelosDisp> vuelosActivos = new ArrayList<>();
        for (añadirVuelosDisp vuelo : vuelosDisponibles) {
            if (vuelo.estado) {
                vuelosActivos.add(vuelo);
            }
        }

        if (vuelosActivos.isEmpty()) {
            System.out.println("No hay vuelos disponibles para reservar.");
            return;
        }

        System.out.print("Ingrese su nombre para la reserva: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese el número del vuelo que desea reservar: ");
        int indiceVuelo = scanner.nextInt();

        if (indiceVuelo < 0 || indiceVuelo >= vuelosActivos.size()) {
            System.out.println("Numero de vuelo no válido.");
            return;
        }

        añadirVuelosDisp vueloSeleccionado = vuelosActivos.get(indiceVuelo);
        vueloSeleccionado.estado = false;

        String infoReserva = "Usuario: " + nombreUsuario + " | " + vueloSeleccionado.origen + " " +
                vueloSeleccionado.destino + " - " + vueloSeleccionado.dia + "/" +
                vueloSeleccionado.mes + "/" + vueloSeleccionado.año;

        reservas.add(infoReserva);
        System.out.println("Vuelo reservado correctamente por " + nombreUsuario + "!");
    }


    public static ArrayList<String> getReservas() {
        return reservas;
    }
}
