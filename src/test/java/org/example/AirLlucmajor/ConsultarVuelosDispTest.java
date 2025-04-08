package org.example.AirLlucmajor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ConsultarVuelosDispTest {



    @Test
    public void testConsultarVuelosDiaYMesNoVuelosEncontrados() {
        añadirVuelosDisp vuelo1 = new añadirVuelosDisp(1, 11, 2025, 200.75, "Sevilla", "Valencia", false);
        ArrayList<añadirVuelosDisp> vuelos = new ArrayList<>();
        vuelos.add(vuelo1);
        consultarVuelos consulta = new consultarVuelos();
        boolean resultado = consulta.consultarVuelosDiaYMes(vuelos, 11, 2025);
        assertFalse(resultado);
    }

    @Test
    public void testConsultarVuelosDiaYMesVuelosEncontrados() {
        añadirVuelosDisp vuelo1 = new añadirVuelosDisp(30, 11, 2025, 200.75, "Sevilla", "Valencia", true);
        ArrayList<añadirVuelosDisp> vuelos = new ArrayList<>();
        vuelos.add(vuelo1);
        consultarVuelos consulta = new consultarVuelos();
        boolean resultado = consulta.consultarVuelosDiaYMes(vuelos, 30, 11);
        assertTrue(resultado);
    }
}

