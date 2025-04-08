package org.example.AirLlucmajor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AñadirVueloDisTest {

    @Test
    public void testAñadirVuelosDisp() {

        añadirVuelosDisp vuelo = new añadirVuelosDisp(10, 5, 2025, 150.50, "Madrid", "Barcelona", true);


        assertEquals(10, vuelo.dia);
        assertEquals(5, vuelo.mes);
        assertEquals(2025, vuelo.año);
        assertEquals(150.50, vuelo.precio);
        assertEquals("Madrid", vuelo.origen);
        assertEquals("Barcelona", vuelo.destino);
        assertTrue(vuelo.estado);


        añadirVuelosDisp vuelo2 = new añadirVuelosDisp(32, 13, 2025, 200.75, "Sevilla", "Valencia", false);

        assertNotEquals(32, vuelo2.dia, "El día fuera de rango fue asignado incorrectamente");
        assertNotEquals(13, vuelo.mes, "El mes fuera de rango fue asignado incorrectamente");
    }


    @Test
    public void testAñadirVuelosDispVacio() {
        añadirVuelosDisp VueloVacio = new añadirVuelosDisp();
        assertNotNull(VueloVacio);
    }
}
