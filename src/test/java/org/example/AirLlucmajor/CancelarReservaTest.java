package org.example.AirLlucmajor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class CancelarReservaTest {

    @Test
    void testCancelarReserva_ReservaExistente() {
        // Crear una lista de reservas con algunas entradas
        ArrayList<String> reservas = new ArrayList<>();
        reservas.add("Usuario: Maria | Palma ➡ Madrid - 12/5/2025");
        reservas.add("Usuario: Joan | Barcelona ➡ Sevilla - 15/5/2025");

        // Llamar al método cancelarReserva para cancelar la reserva de Maria a Madrid
        boolean resultado = CancelarReserva.cancelarReserva(reservas, "Maria", "Palma", "Madrid");

        // Verificar que la reserva fue eliminada correctamente
        assertTrue(resultado);  // El método debe retornar true si la reserva fue cancelada
        assertEquals(1, reservas.size());  // Solo debe quedar una reserva en la lista
        assertFalse(reservas.contains("Usuario: Maria | Palma ➡ Madrid - 12/5/2025"));  // La reserva de Maria debe haber sido eliminada
    }

    @Test
    void testCancelarReserva_ReservaNoExistente() {
        // Crear una lista de reservas con algunas entradas
        ArrayList<String> reservas = new ArrayList<>();
        reservas.add("Usuario: Maria | Palma ➡ Madrid - 12/5/2025");
        reservas.add("Usuario: Joan | Barcelona ➡ Sevilla - 15/5/2025");

        // Intentar cancelar una reserva que no existe (de un usuario distinto)
        boolean resultado = CancelarReserva.cancelarReserva(reservas, "Pedro", "Palma", "Madrid");

        // Verificar que la cancelación falló porque la reserva no existe
        assertFalse(resultado);  // El método debe retornar false si no se encuentra la reserva
        assertEquals(2, reservas.size());  // La lista de reservas no debe haberse modificado
    }

    @Test
    void testCancelarReserva_CancelacionDeReservaDuplicada() {
        // Crear una lista con reservas duplicadas
        ArrayList<String> reservas = new ArrayList<>();
        reservas.add("Usuario: Maria | Palma ➡ Madrid - 12/5/2025");
        reservas.add("Usuario: Maria | Palma ➡ Madrid - 12/5/2025");  // Duplicada

        // Llamar al método cancelarReserva para cancelar una de las reservas de Maria
        boolean resultado = CancelarReserva.cancelarReserva(reservas, "Maria", "Palma", "Madrid");

        // Verificar que la reserva fue eliminada correctamente
        assertTrue(resultado);  // El método debe retornar true si la reserva fue cancelada
        assertEquals(1, reservas.size());  // Solo debe quedar una reserva en la lista
        assertTrue(reservas.contains("Usuario: Maria | Palma ➡ Madrid - 12/5/2025"));  // La otra reserva de Maria debe seguir presente
    }
}