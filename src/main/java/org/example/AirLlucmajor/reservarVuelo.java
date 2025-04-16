package org.example.AirLlucmajor;

import org.example.AirLlucmajor.añadirVuelosDisp;

import java.util.ArrayList;
import java.util.Scanner;

public class reservarVuelo {

    public static void reservarVuelo(ArrayList<añadirVuelosDisp> vuelosDisponibles, ArrayList<String> reservas) {
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

        // Mostrar vuelos disponibles al usuario
        System.out.println("✈️ Vuelos disponibles:");
        for (int i = 0; i < vuelosActivos.size(); i++) {
            añadirVuelosDisp v = vuelosActivos.get(i);
            System.out.println("[" + i + "] " + v.origen + " ➡ " + v.destino + " | " +
                    v.dia + "/" + v.mes + "/" + v.año + " | 💶 " + v.precio);
        }

        scanner.nextLine(); // limpiar buffer
        System.out.print("Ingrese su nombre para la reserva: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese el número del vuelo que desea reservar: ");
        int indiceVuelo = scanner.nextInt();

        if (indiceVuelo < 0 || indiceVuelo >= vuelosActivos.size()) {
            System.out.println("❌ Número de vuelo no válido.");
            return;
        }

        añadirVuelosDisp vueloSeleccionado = vuelosActivos.get(indiceVuelo);
        vueloSeleccionado.estado = false;

        String infoReserva = "Usuario: " + nombreUsuario + " | " + vueloSeleccionado.origen + " ➡ " +
                vueloSeleccionado.destino + " - " + vueloSeleccionado.dia + "/" +
                vueloSeleccionado.mes + "/" + vueloSeleccionado.año;

        reservas.add(infoReserva);
        System.out.println("✅ Vuelo reservado correctamente por " + nombreUsuario + "!");
    }
}