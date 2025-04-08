package org.example.AirLlucmajor;

import java.util.ArrayList;
import java.util.Scanner;

public class cancelarReserva {

    private static ArrayList<String> reservas = new ArrayList<>();

    // Método para reservar un vuelo
    public static void reservarVuelo(ArrayList<AñadirVuelosDisp> vuelosDisponibles) {
        Scanner scanner = new Scanner(System.in);

        // Filtrar vuelos activos (disponibles)
        ArrayList<AñadirVuelosDisp> vuelosActivos = new ArrayList<>();
        for (AñadirVuelosDisp vuelo : vuelosDisponibles) {
            if (vuelo.estado) {
                vuelosActivos.add(vuelo);
            }
        }

        // Verificar si hay vuelos disponibles
        if (vuelosActivos.isEmpty()) {
            System.out.println("No hay vuelos disponibles para reservar.");
            return;
        }

        // Solicitar información al usuario para realizar la reserva
        System.out.print("Ingrese su nombre para la reserva: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese el número del vuelo que desea reservar: ");
        int indiceVuelo = scanner.nextInt();

        if (indiceVuelo < 0 || indiceVuelo >= vuelosActivos.size()) {
            System.out.println("Número de vuelo no válido.");
            return;
        }

        // Realizar la reserva
        AñadirVuelosDisp vueloSeleccionado = vuelosActivos.get(indiceVuelo);
        vueloSeleccionado.estado = false;

        // Crear un string con la información de la reserva
        String infoReserva = "Usuario: " + nombreUsuario + " | " + vueloSeleccionado.origen + " " +
                vueloSeleccionado.destino + " - " + vueloSeleccionado.dia + "/" +
                vueloSeleccionado.mes + "/" + vueloSeleccionado.año;

        // Guardar la reserva
        reservas.add(infoReserva);
        System.out.println("Vuelo reservado correctamente por " + nombreUsuario + "!");
    }

    // Método para cancelar una reserva
    public static void cancelarReserva() {
        Scanner scanner = new Scanner(System.in);

        // Si no hay reservas, mostrar un mensaje
        if (reservas.isEmpty()) {
            System.out.println("No tienes reservas para cancelar.");
            return;
        }

        // Mostrar las reservas actuales
        System.out.println("Reservas actuales:");
        for (int i = 0; i < reservas.size(); i++) {
            System.out.println(i + ". " + reservas.get(i));
        }

        System.out.print("Ingrese el número de la reserva que desea cancelar: ");
        int indiceReserva = scanner.nextInt();

        // Verificar si la reserva es válida
        if (indiceReserva < 0 || indiceReserva >= reservas.size()) {
            System.out.println("Número de reserva no válido.");
            return;
        }

        // Eliminar la reserva seleccionada
        reservas.remove(indiceReserva);
        System.out.println("Reserva cancelada correctamente.");
    }

    // Método para obtener las reservas actuales
    public static ArrayList<String> getReservas() {
        return reservas;
    }

    // Clase para representar un vuelo (simplificado)
    public static class AñadirVuelosDisp {
        String origen;
        String destino;
        int dia;
        int mes;
        int año;
        boolean estado;  // true si el vuelo está disponible

        public AñadirVuelosDisp(String origen, String destino, int dia, int mes, int año) {
            this.origen = origen;
            this.destino = destino;
            this.dia = dia;
            this.mes = mes;
            this.año = año;
            this.estado = true;  // El vuelo está disponible por defecto
        }
    }

    public static void main(String[] args) {
        // Crear algunos vuelos disponibles
        ArrayList<AñadirVuelosDisp> vuelosDisponibles = new ArrayList<>();
        vuelosDisponibles.add(new AñadirVuelosDisp("Madrid", "Barcelona", 10, 5, 2025));
        vuelosDisponibles.add(new AñadirVuelosDisp("Barcelona", "Sevilla", 15, 5, 2025));
        vuelosDisponibles.add(new AñadirVuelosDisp("Madrid", "Valencia", 20, 5, 2025));

        // Probar la reserva
        reservarVuelo(vuelosDisponibles);

        // Ver las reservas
        System.out.println("Reservas actuales:");
        System.out.println(getReservas());

        // Probar la cancelación
        cancelarReserva();

        // Ver las reservas después de la cancelación
        System.out.println("Reservas después de cancelar:");
        System.out.println(getReservas());
    }
}