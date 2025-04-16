package org.example.AirLlucmajor;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConsultarReservasTest {

    @Test
    void testConsultarReservasPorNombre_UsuarioConReservas() {
        // Crear una lista de reservas con 2 reservas
        ArrayList<String> reservas = new ArrayList<>();
        reservas.add("Usuario: Maria | Palma ➡ Madrid - 12/5/2025");
        reservas.add("Usuario: Joan | Barcelona ➡ Sevilla - 15/5/2025");

        // Llamar al método consultarReservasPorNombre para Maria
        List<String> resultado = ConsultarReservas.consultarReservasPorNombre(reservas, "Maria");

        // Comprobar que solo se retorna la reserva de Maria
        assertEquals(1, resultado.size());
        assertTrue(resultado.get(0).contains("Maria"));  // Comprobar que la reserva de Maria está presente
    }

    @Test
    void testConsultarReservasPorNombre_UsuarioSinReservas() {
        // Crear una lista con una reserva de Maria
        ArrayList<String> reservas = new ArrayList<>();
        reservas.add("Usuario: Maria | Palma ➡ Madrid - 12/5/2025");

        // Llamar al método para buscar Joan, que no tiene reservas
        List<String> resultado = ConsultarReservas.consultarReservasPorNombre(reservas, "Joan");

        // Comprobar que la lista de resultados está vacía porque Joan no tiene reservas
        assertTrue(resultado.isEmpty());
    }

    @Test
    void testConsultarReservasPorNombre_CaseInsensitive() {
        // Crear una lista con una reserva de Maria (en mayúsculas)
        ArrayList<String> reservas = new ArrayList<>();
        reservas.add("Usuario: MARIA | Palma ➡ Madrid - 12/5/2025");

        // Llamar al método para buscar Maria, pero escribiendo en minúsculas
        List<String> resultado = ConsultarReservas.consultarReservasPorNombre(reservas, "maria");

        // Comprobar que la reserva de Maria se ha encontrado correctamente, independientemente de mayúsculas/minúsculas
        assertEquals(1, resultado.size());
    }

    @Test
    void testConsultarReservasPorNombre_VariosUsuarios() {
        // Crear una lista con reservas de diferentes usuarios
        ArrayList<String> reservas = new ArrayList<>();
        reservas.add("Usuario: Maria | Palma ➡ Madrid - 12/5/2025");
        reservas.add("Usuario: Joan | Barcelona ➡ Sevilla - 15/5/2025");
        reservas.add("Usuario: Maria | Mallorca ➡ Valencia - 20/5/2025");

        // Llamar al método para obtener todas las reservas de Maria
        List<String> resultado = ConsultarReservas.consultarReservasPorNombre(reservas, "Maria");

        // Comprobar que se devuelven todas las reservas de Maria
        assertEquals(2, resultado.size());
        assertTrue(resultado.get(0).contains("Maria"));
        assertTrue(resultado.get(1).contains("Maria"));
    }
}
