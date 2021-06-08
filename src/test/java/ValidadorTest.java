import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

    class ValidadorTest {

        @Test
        @DisplayName("Test para verificar nombres vacíos")
        void nombreVacio() {

            assertFalse(Validador.validarNombre(""));
        }

        @Test
        @DisplayName("Test para verificar nombres con números")
        void nombreNumero() {

            assertFalse(Validador.validarNombre("Javier12"));
        }

        @Test
        @DisplayName("Test para verificar nombres en minúsculas")
        void nombreMinuscula() {

            assertFalse(Validador.validarNombre("javier"));
        }

        @Test
        @DisplayName("Test para verificar nombres en mayúsculas")
        void nombreMayuscula() {

            assertFalse(Validador.validarNombre("JAVIER"));
        }

        @Test
        @DisplayName("Test para verificar nombres con tilde")
        void nombreTilde() {

            assertFalse(Validador.validarNombre("Andrés"));
        }

        @Test
        @DisplayName("Test para verificar apellidos vacíos")
        void apellidoVacio() {

            assertFalse(Validador.validarApellido(""));
        }

        @Test
        @DisplayName("Test para verificar apellidos con números")
        void apellidoNumero() {

            assertFalse(Validador.validarApellido("Marquez05"));
        }

        @Test
        @DisplayName("Test para verificar apellidos en minúsculas")
        void apellidoMinuscula() {

            assertFalse(Validador.validarApellido("marquez"));
        }

        @Test
        @DisplayName("Test para verificar apellidos en mayúsculas")
        void apellidoMayuscula() {

            assertFalse(Validador.validarApellido("MARQUEZ"));
        }

        @Test
        @DisplayName("Test para verificar apellidos con tilde")
        void apellidoTilde() {

            assertFalse(Validador.validarApellido("Márquez"));
        }

        @Test
        @DisplayName("Test para verificar números telefónicos con letras")
        void numTelLetra() {

            assertFalse(Validador.validarNumTelefono("numero"));
        }

        @Test
        @DisplayName("Test para verificar números con menos de 8 dígitos")
        void numMenorOchoDigitos() {

            assertFalse(Validador.validarNumTelefono("4530371"));
        }

        @Test
        @DisplayName("Test para verificar números con más de 8 dígitos")
        void numMayorOchoDigitos() {

            assertFalse(Validador.validarNumTelefono("945303715"));
        }

        @Test
        @DisplayName("Test para verificar números que comiencen con 0")
        void numCero() {

            assertFalse(Validador.validarNumTelefono("05303715"));
        }

        @Test
        @DisplayName("Test para verificar números vacíos")
        void numVacio() {

            assertFalse(Validador.validarNumTelefono(""));
        }

        @Test
        @DisplayName("Test para validar si se ingresan letras")
        void entradaNumLetra() {
            ByteArrayInputStream in = new ByteArrayInputStream("a".getBytes());
            System.setIn(in);
            assertEquals(0, Validador.entradaInt());
        }

        @Test
        @DisplayName("Test para validar si la entrada es vacía")
        void entradaNumVacia() {
            ByteArrayInputStream in = new ByteArrayInputStream(("" + System.lineSeparator()).getBytes());
            System.setIn(in);
            assertEquals(0, Validador.entradaInt());
        }
}
