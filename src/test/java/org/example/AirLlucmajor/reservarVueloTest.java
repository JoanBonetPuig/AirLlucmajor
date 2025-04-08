package org.example.AirLlucmajor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class reservarVueloTest {
    @Test
    public void testSinVuelosDisponibles() {
        ArrayList<añadirVuelosDisp> vuelos = new ArrayList<>();
        String input = "CualquierNombre\n0\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        reservarVuelo.reservarVuelo(vuelos);
        assertEquals(0, reservarVuelo.getReservas().size());
    }
}