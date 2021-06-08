import java.util.*;

public class Agenda {

    private ArrayList<Contacto> contactos;

    public Agenda() {
        this.contactos = new ArrayList<>();
    }

    public void ordenarContactosFecha() {
        contactos.sort(Comparator.comparing(Contacto::getFechaCreacion));
    }

    public void ordenarContactosNombre() {

        contactos.sort((o1, o2) -> {
            if (o1.getNombre().equals(o2.getNombre())) {
                if (o1.getApellido().equals(o2.getApellido())) {
                    return o1.getNumTelefono().compareTo(o2.getNumTelefono());
                }
                return o1.getApellido().compareTo(o2.getApellido());
            }
            return o1.getNombre().compareTo(o2.getNombre());
        });
    }

    public void cargarContactos(Archivo archivo) {

        ArrayList<String> datos = archivo.cargarArchivo();

        for (int i = 0; i < datos.size(); i = i + 5) {

            String nombre = datos.get(i);
            String apellido = datos.get(i + 1);
            String numTelefono = datos.get(i + 2);
            String direccion = datos.get(i + 3);
            String fechaCreacion = datos.get(i + 4);
            Contacto contacto = new Contacto(nombre, apellido, numTelefono, direccion, fechaCreacion);
            contactos.add(contacto);
            System.out.println("\n" + "Se ha cargado el contacto " + contacto.getNombre() + " " + contacto.getApellido() + " sin problemas");
        }
    }

    private String darNombre() {
        String nombre;
        do {
            System.out.println("\n" + "Nombre de contacto: ");
            nombre = Validador.entradaString();
        } while (!Validador.validarNombre(nombre));
        return nombre;
    }

    private String darApellido() {
        String apellido;
        do {
            System.out.println("\n" + "Apellido de contacto: ");
            apellido = Validador.entradaString();
        } while (!Validador.validarApellido(apellido));
        return apellido;
    }

    private String darNumeroTelefonico() {
        String numTelefono;
        do {
            System.out.println("\n" + "Número telefónico de contacto: ");
            numTelefono = String.valueOf(Validador.entradaInt());
        } while (!Validador.validarNumTelefono(numTelefono) || verificarNumContacto(numTelefono));
        return numTelefono;
    }

    private String darDireccion() {
        System.out.println("\n" + "Dirección de contacto");
        return Validador.entradaString();
    }

    public void crearContacto() {
        String nombre = darNombre();
        String apellido = darApellido();
        String numTelefono = darNumeroTelefonico();
        String direccion = darDireccion();
        Contacto contacto = new Contacto(nombre, apellido, numTelefono, direccion);
        contactos.add(contacto);
        System.out.println("Se ha creado el contacto sin problemas");
    }

    private boolean verificarNumContacto(String numero) {

        for (Contacto contacto : contactos) {
            if (contacto.getNumTelefono().equals(numero)) {
                return true;
            }
        }
        return false;
    }

    private void modificarContacto(Contacto contacto) {

        int opcion;

        do {
            mostrarInfoEdicion();
            opcion = Validador.entradaInt();

            switch (opcion) {
                case 1 -> {
                    String nombre = darNombre();
                    contacto.setNombre(nombre);
                }
                case 2 -> {
                    String apellido = darApellido();
                    contacto.setApellido(apellido);
                }
                case 3 -> {
                    String numTelefono = darNumeroTelefonico();
                    contacto.setNumTelefono(numTelefono);
                }
                case 4 -> {
                    String direccion = darDireccion();
                    contacto.setDireccion(direccion);
                }
                case 5 -> System.out.println("Saliendo del editor...");
                default -> System.out.println("Fallo al elegir la opción");
            }
        } while (opcion != 5);
    }

    public void editarContacto(int numTelefono) {

        for (Contacto contacto : contactos) {

            if (contacto.getNumTelefono().equals("+569" + numTelefono)) {
                modificarContacto(contacto);
                System.out.println("Se ha modificado el contacto sin problemas");
                return;
            }
        }
        System.out.println("No se ha encontrado el contacto");
    }

    public void eliminarContacto(int numTelefono) {

        for (Contacto contacto : contactos) {

            if (contacto.getNumTelefono().equals("+569" + numTelefono)) {
                contactos.remove(contacto);
                System.out.println("El contacto se ha eliminado sin problemas");
                return;
            }
        }
        System.out.println("No se ha encontrado el contacto");
    }

    public void mostrarContactos() {

        System.out.println("Los contactos son: " + "\n");

        for (Contacto contacto : contactos) {
            System.out.println(contacto.toString());
        }
    }

    private void mostrarMenu() {

        System.out.println("""

                Bienvenido al menú
                """);
        System.out.println("Elija una opción" + "\n");
        System.out.println("[1] Agregar un contacto");
        System.out.println("[2] Editar un contacto");
        System.out.println("[3] Borrar un contacto");
        System.out.println("[4] Ordenar contactos por fecha de creación");
        System.out.println("[5] Ordenar contactos por nombre");
        System.out.println("[6] Mostrar contactos");
        System.out.println("[7] Salir" + "\n");
    }

    private void mostrarInfoEdicion() {

        System.out.println("Elija una opción" + "\n");
        System.out.println("[1] Modificar nombre");
        System.out.println("[2] Modificar apellido");
        System.out.println("[3] Modificar número telefónico");
        System.out.println("[4] Modificar dirección");
        System.out.println("[5] Salir" + "\n");
    }

    public void menu() {
        Archivo archivo = new Archivo();
        if (archivo.getArchivo().exists()) {
            cargarContactos(archivo);
        }
        int opcion;

        do {
            mostrarMenu();
            opcion = Validador.entradaInt();

            switch (opcion) {

                case 1:
                    crearContacto();
                    break;

                case 2:
                    System.out.println("Ingrese el número telefónico del contacto: ");
                    int numTelefono = Validador.entradaInt();
                    editarContacto(numTelefono);
                    break;

                case 3:
                    System.out.println("Ingrese el número telefónico del contacto: ");
                    numTelefono = Validador.entradaInt();
                    eliminarContacto(numTelefono);
                    break;

                case 4:
                    ordenarContactosFecha();
                    break;

                case 5:
                    ordenarContactosNombre();
                    break;

                case 6:
                    mostrarContactos();
                    break;

                case 7:
                    System.out.println("Gracias por usar la agenda");
                    System.out.println("Adiós...");
                    break;

                default:
                    System.out.println("Fallo al elegir la opción");
            }
        } while (opcion != 7);

        archivo.setValor(toString());
        archivo.escribirArchivo();
    }

    @Override
    public String toString() {

        StringBuilder archivoGuardado = new StringBuilder();

        for (Contacto contacto : contactos) {
            archivoGuardado.append(contacto.toString());
        }
        return archivoGuardado.toString();
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
}