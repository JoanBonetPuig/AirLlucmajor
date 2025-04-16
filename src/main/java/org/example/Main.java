package org.example;

import org.example.AirLlucmajor.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> reservas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<añadirVuelosDisp> vuelos = new ArrayList<>();

        int opcion;
        do {
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

            switch (opcion) {
                case 1:
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
                    break;

                case 2:
                    System.out.println("📆 Consultando vuelos disponibles por día y mes...");
                    consultarVuelos CV = new consultarVuelos();
                    System.out.print("¿Qué mes deseas consultar?: ");
                    int mesConsulta = scanner.nextInt();
                    System.out.print("¿Qué día del mes?: ");
                    int diaConsulta = scanner.nextInt();
                    CV.consultarVuelosDiaYMes(vuelos, diaConsulta, mesConsulta);
                    break;

                case 3:
                    System.out.println("🛎️ Reservando un vuelo...");
                    reservarVuelo.reservarVuelo(vuelos, reservas);
                    break;

                case 4:
                    System.out.println("🔍 Consultando vuelos reservados por usuario...");
                    scanner.nextLine(); // limpiar buffer
                    System.out.print("Introduce el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();

                    var reservasUsuario = ConsultarReservas.consultarReservasPorNombre(reservas, nombreUsuario);
                    if (reservasUsuario.isEmpty()) {
                        System.out.println("❌ No se encontraron reservas para el usuario " + nombreUsuario);
                    } else {
                        System.out.println("✅ Reservas encontradas:");
                        for (String r : reservasUsuario) {
                            System.out.println("🧾 " + r);
                        }
                    }
                    break;

                case 5:
                    System.out.println("🚫 Cancelando una reserva...");
                    scanner.nextLine(); // limpiar buffer
                    System.out.print("Introduce tu nombre: ");
                    String nombreCancelacion = scanner.nextLine();
                    System.out.print("Origen del vuelo: ");
                    String origenCancelacion = scanner.nextLine();
                    System.out.print("Destino del vuelo: ");
                    String destinoCancelacion = scanner.nextLine();

                    boolean cancelado = CancelarReserva.cancelarReserva(reservas, nombreCancelacion, origenCancelacion, destinoCancelacion);
                    if (cancelado) {
                        System.out.println("✅ Reserva cancelada correctamente.");
                    } else {
                        System.out.println("❌ No se encontró una reserva con esos datos.");
                    }
                    break;

                case 6:
                    System.out.println("📨 Enviando notificaciones...");
                    enviarNotificacion en = new enviarNotificacion();
                    en.notificacion();
                    break;

                case 7:
                    System.out.println("👋 Saliendo del sistema... ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("❌ Opción no válida. Introduzca un número del 1 al 7.");
                    break;
            }

        } while (opcion != 7);
    }
}