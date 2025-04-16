package org.example;

import org.example.AirLlucmajor.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> reservas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<añadirVuelosDisp> vuelos = new ArrayList<>();

        System.out.println("✈️  ===== MENÚ DE GESTIÓN DE VUELOS DE AIRLLUCMAJOR ===== ✈️");
        System.out.println("1️⃣  ✍️ Añadir vuelos disponibles");
        System.out.println("2️⃣  📅 Consultar los vuelos disponibles por día y por semana");
        System.out.println("3️⃣  🎟️ Reservar un vuelo");
        System.out.println("4️⃣  🔍 Consultar vuelos reservados por usuario");
        System.out.println("5️⃣  ❌ Cancelar una reserva");
        System.out.println("6️⃣  📩 Enviar notificaciones a los usuarios");
        System.out.println("7️⃣  🚪 Salir");
        System.out.print("🛠️ Seleccione una opción: ");

        añadirVuelosDisp añadirVuelosD = new añadirVuelosDisp();
        int opcion = scanner.nextInt();

        while (opcion != 7) {

            if (opcion == 1) {
                System.out.println("🛫 Añadiendo vuelos disponibles...");
                System.out.print("Día del vuelo: ");
                int dia = scanner.nextInt();
                System.out.print("Mes del vuelo: ");
                int mes = scanner.nextInt();
                System.out.print("Año del vuelo: ");
                int año = scanner.nextInt();
                System.out.print("Precio del vuelo: ");
                double precio = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Origen del vuelo: ");
                String origen = scanner.nextLine();
                System.out.print("Destino del vuelo: ");
                String destino = scanner.nextLine();
                añadirVuelosDisp nuevoVuelo = new añadirVuelosDisp(dia, mes, año, precio, origen, destino, true);
                vuelos.add(nuevoVuelo);
                System.out.println("✔️ Vuelo añadido correctamente!");
            } else if (opcion == 2) {
                System.out.println("📆 Consultando vuelos disponibles...");
                // Consultar vuelos (pendiente)
            } else if (opcion == 3) {
                System.out.println("🛎️ Reservando un vuelo...");
                reservarVuelo.reservarVuelo(vuelos);
            } else if (opcion == 4) {
                System.out.println("🧐 Consultando vuelos reservados...");
                consultarVuelos CV = new consultarVuelos();
                System.out.println("¿Que mes deseas consultar?");
                int mes = scanner.nextInt();
                System.out.println("¿Que dia del mes deseas consultar?");
                int dia = scanner.nextInt();
                CV.consultarVuelosDiaYMes(vuelos, dia, mes);
            } else if (opcion == 5) {
                System.out.println("🚫 Cancelando una reserva...");
                // cancelar reserva (pendiente)
            } else if (opcion == 6) {
                System.out.println("📨 Enviando notificaciones...");
                enviarNotificacion en = new enviarNotificacion();
                en.notificacion();
            } else {
                System.out.println("❌ Entrada no válida. Introduzca un número del 1 al 7.");
            }

            System.out.println("\n✈️  ===== MENÚ DE GESTIÓN DE VUELOS DE AIRLLUCMAJOR ===== ✈️");
            System.out.println("1️⃣  ✍️ Añadir vuelos disponibles");
            System.out.println("2️⃣  📅 Consultar los vuelos disponibles por día y por semana");
            System.out.println("3️⃣  🎟️ Reservar un vuelo");
            System.out.println("4️⃣  🔍 Consultar vuelos reservados por usuario");
            System.out.println("5️⃣  ❌ Cancelar una reserva");
            System.out.println("6️⃣  📩 Enviar notificaciones a los usuarios");
            System.out.println("7️⃣  🚪 Salir");
            System.out.print("🛠️ Seleccione una opción: ");
            opcion = scanner.nextInt();
        }

        System.out.println("👋 Saliendo del sistema... ¡Hasta pronto!");
    }
}
