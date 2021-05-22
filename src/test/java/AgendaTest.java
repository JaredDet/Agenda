import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    Agenda agenda;

    @BeforeEach
    void setUp() {

        agenda = new Agenda();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    @DisplayName("Test para verificar que se crea el usuario")
    void crearUsuario() {

        ByteArrayInputStream in = new ByteArrayInputStream(("Javier" + System.lineSeparator() + "Marquez" + System.lineSeparator() + "45303715" + System.lineSeparator() + "Barros_Arana_843").getBytes());
        System.setIn(in);
        agenda.crearContacto();
        agenda.mostrarContactos();
    }
}