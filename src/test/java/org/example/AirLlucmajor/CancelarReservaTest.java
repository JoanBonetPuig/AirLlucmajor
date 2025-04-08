package org.example.AirLlucmajor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CancelarReservaTest {
    private cancelarReserva gestor;
    private ArrayList<cancelarReserva.AñadirVuelosDisp> vuelosDisponibles;

    @BeforeEach
    public void setUp() {
        // Crear una instancia del gestor y la lista de vuelos
        gestor = new cancelarReserva();
        vuelosDisponibles = new ArrayList<>();

        // Añadir algunos vuelos disponibles
        vuelosDisponibles.add(new cancelarReserva.AñadirVuelosDisp("Madrid", "Barcelona", 10, 5, 2025));
        vuelosDisponibles.add(new cancelarReserva.AñadirVuelosDisp("Barcelona", "Sevilla", 15, 5, 2025));
        vuelosDisponibles.add(new cancelarReserva.AñadirVuelosDisp("Madrid", "Valencia", 20, 5, 2025));
    }

    @Test
    public void testReservarVuelo() {
        // Simulamos la entrada del usuario
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextLine()).thenReturn("Juan");
        when(scannerMock.nextInt()).thenReturn(1);  // El usuario selecciona el vuelo 1 (Barcelona-Sevilla)

        // Llamar al método de reservar
        cancelarReserva.reservarVuelo(vuelosDisponibles);

        // Verificar que la reserva se haya realizado correctamente
        assertEquals(1, cancelarReserva.getReservas().size(), "Debe haber una reserva.");
        assertTrue(cancelarReserva.getReservas().get(0).contains("Juan"), "La reserva debe contener el nombre del usuario.");
        assertFalse(vuelosDisponibles.get(1).estado, "El vuelo seleccionado debe marcarse como no disponible.");
    }

    @Test
    public void testCancelarReserva() {
        // Primero, simular la reserva
        cancelarReserva.reservarVuelo(vuelosDisponibles);

        // Crear un mock de Scanner para simular la entrada del usuario para la cancelación
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(0);  // El usuario quiere cancelar la reserva número 0

        // Llamar al método cancelarReserva
        cancelarReserva.cancelarReserva();

        // Verificar que la reserva se haya cancelado correctamente
        assertEquals(0, cancelarReserva.getReservas().size(), "Las reservas deben estar vacías después de cancelarlas.");
    }

    @Test
    public void testCancelarReservaNoExistenReservas() {
        // Int
        // entamos cancelar una reserva cuando no hay ninguna
        cancelarReserva.cancelarReserva();

        // Verificar que no haya reservas
        assertEquals(0, cancelarReserva.getReservas().size(), "No debe haber reservas si no se ha realizado ninguna.");
    }

    @Test
    public void testCancelarReservaConEntradaInvalida() {
        // Primero, simular la reserva
        cancelarReserva.reservarVuelo(vuelosDisponibles);

        // Crear un mock de Scanner para simular la entrada de un número de reserva inválido
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(10);  // El usuario ingresa un número de reserva inválido

        // Llamar al método cancelarReserva
        cancelarReserva.cancelarReserva();

        // Verificar que la reserva no haya sido cancelada
        assertEquals(1, cancelarReserva.getReservas().size(), "Las reservas no deben haberse cancelado con un número inválido.");
    }
}
