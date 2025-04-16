package org.example.AirLlucmajor;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class enviarNotificacionTest {

    @Test
    public void testNotificacionImprimeMensajeCorrecto() {
        ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(salidaCapturada));
        enviarNotificacion en = new enviarNotificacion();
        en.notificacion();
        System.setOut(originalOut);
        String salidaEsperada = "Notificacion enviada" + System.lineSeparator();
        assertEquals(salidaEsperada, salidaCapturada.toString());
    }
}
