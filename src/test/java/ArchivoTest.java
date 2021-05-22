import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ArchivoTest {

    Archivo archivo;
    @BeforeEach
    void setUp() {

       archivo  = new Archivo();
    }

    @AfterEach
    void tearDown() {

        boolean b = archivo.getArchivo().delete();
    }

    @Test
    @DisplayName("Test para validar que si no existe el archivo se crea")
    void TestCrearArchivo() {

        archivo.escribirArchivo();
        assertTrue(archivo.getArchivo().exists());
    }

    @Test
    @DisplayName("Test para validar que si no existe el archivo devuelve: Archivo no existe")
    void TestArchivoNoExiste() {

        archivo.cargarArchivo();
        assertEquals(archivo.getInformacion().get(0), "El archivo no existe");
    }

    @Test
    @DisplayName("Test para validar que guarda las líneas del archivo")
    void guardarLineas() {
        archivo.setValor("Prueba = Hola, mundo");
        archivo.escribirArchivo();
        archivo.cargarArchivo();
        assertEquals(archivo.getInformacion().get(0), "Hola,mundo");
    }
}
