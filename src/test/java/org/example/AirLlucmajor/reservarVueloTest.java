package org.example.AirLlucmajor;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class reservarVueloTest {

    @Test
    public void testReservaSinVuelosDisponibles() {
        ArrayList<añadirVuelosDisp> vuelos = new ArrayList<>();
        ArrayList<String> reservas = new ArrayList<>();

        // Simular entrada aunque no se usará
        String input = "\nCarlos\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        reservarVuelo.reservarVuelo(vuelos, reservas);

        assertTrue(reservas.isEmpty(), "No debería haber reservas si no hay vuelos disponibles.");
    }

    @Test
    public void testReservaCorrecta() {
        ArrayList<añadirVuelosDisp> vuelos = new ArrayList<>();
        ArrayList<String> reservas = new ArrayList<>();

        // Añadir un vuelo activo
        vuelos.add(new añadirVuelosDisp(12, 5, 2025, 99.99, "Palma", "Madrid", true));

        // Simular entrada: nombre del usuario + número del vuelo (0)
        String input = "\nLaura\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        reservarVuelo.reservarVuelo(vuelos, reservas);

        assertEquals(1, reservas.size(), "Debería haberse añadido una reserva.");
        String reserva = reservas.get(0);
        assertTrue(reserva.contains("Laura"));
        assertTrue(reserva.contains("Palma"));
        assertTrue(reserva.contains("Madrid"));

        // Comprobar que el vuelo ha sido marcado como no disponible
        assertFalse(vuelos.get(0).estado, "El vuelo reservado debe marcarse como no disponible.");
    }

    @Test
    public void testReservaConIndiceInvalido() {
        ArrayList<añadirVuelosDisp> vuelos = new ArrayList<>();
        ArrayList<String> reservas = new ArrayList<>();

        vuelos.add(new añadirVuelosDisp(10, 6, 2025, 150.0, "Ibiza", "Barcelona", true));

        // Simular entrada: nombre válido, índice inválido
        String input = "\nCarlos\n5\n";  // 5 está fuera de rango
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        reservarVuelo.reservarVuelo(vuelos, reservas);

        assertTrue(reservas.isEmpty(), "No debe haber reservas si el índice es inválido.");
        assertTrue(vuelos.get(0).estado, "El vuelo no debe ser marcado como reservado si el índice es inválido.");
    }
}