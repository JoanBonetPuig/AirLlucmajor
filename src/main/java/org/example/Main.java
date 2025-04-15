package org.example;

import org.example.AirLlucmajor.añadirVuelosDisp;
import org.example.AirLlucmajor.consultarVuelos;
import org.example.AirLlucmajor.enviarNotificacion;
import org.example.AirLlucmajor.reservarVuelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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
                //Funcion 1
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
                //Funcion 2

                // Lógica para consultar vuelos Miguel Angel
            } else if (opcion == 3) {
                System.out.println("🛎️ Reservando un vuelo...");
                //Funcion 3
                reservarVuelo.reservarVuelo(vuelos);
                // Lógica para reservar un vuelo Gemelo
            } else if (opcion == 4) {
                System.out.println("🧐 Consultando vuelos reservados...");
                //Funcion 4
                consultarVuelos CV = new consultarVuelos();
                System.out.println("¿Que mes deseas consultar?");
                int mes = scanner.nextInt();
                System.out.println("¿Que dia del mes deseas consultar?");
                int dia = scanner.nextInt();
                CV.consultarVuelosDiaYMes(vuelos, dia, mes);
                // Lógica para consultar vuelos reservados Adri
            } else if (opcion == 5) {
                System.out.println("🚫 Cancelando una reserva...");
                //Funcion 5

                // Lógica para cancelar una reserva Miguel Angel
            } else if (opcion == 6) {
                System.out.println("📨 Enviando notificaciones...");
                //Funcion 6
                enviarNotificacion en = new enviarNotificacion();
                en.notificacion();
                // Lógica para enviar notificaciones Gemelo
            } else if (opcion == 7) {
                System.out.println("👋 Saliendo del sistema... ¡Hasta pronto!");
                break;
            } else {
                System.out.println("❌ Entrada no válida. Introduzca un número del 1 al 7.");
            }

            System.out.println("✈️  ===== MENÚ DE GESTIÓN DE VUELOS DE AIRLLUCMAJOR ===== ✈️");
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
    }
}