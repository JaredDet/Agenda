import java.util.*;

public class Agenda {

	private ArrayList<Contacto> contactos;

	public Agenda() {
		this.contactos = new ArrayList<>();
	}

	public void ordenarContactosFecha() {
		contactos.sort(new Comparator<Contacto>() {
			@Override
			public int compare(Contacto o1, Contacto o2) {
				return o1.getFechaCreacion().compareTo(o2.getFechaCreacion());
			}
		});
	}

	public void ordenarContactosNombre() {

		contactos.sort(new Comparator<Contacto>() {
			@Override
			public int compare(Contacto o1, Contacto o2) {
				if(o1.getNombre().equals(o2.getNombre())){
					if(o1.getApellido().equals(o2.getApellido())){
						return o1.getNumTelefono().compareTo(o2.getNumTelefono());
					}
					return o1.getApellido().compareTo(o2.getApellido());
				}
				return o1.getNombre().compareTo(o2.getNombre());
			}
		});
	}

	public void cargarContactos(Archivo archivo){

		ArrayList<String> datos = archivo.cargarArchivo();

		for(int i = 0; i < datos.size(); i = i + 5){

			String nombre = datos.get(i);
			String apellido = datos.get(i+1);
			String numTelefono = datos.get(i+2);
			String direccion = datos.get(i+3);
			String fechaCreacion = datos.get(i+4);
			Contacto contacto = new Contacto(nombre, apellido, numTelefono, direccion, fechaCreacion);
			contactos.add(contacto);
			System.out.println("\n" + "Se ha cargado el contacto " +contacto.getNombre() + " " + contacto.getApellido() + " sin problemas");
		}
	}
	public void crearContacto() {

		String nombre;
		do {
			System.out.println("\n" + "Nombre de contacto: ");
			nombre = Validador.entradaString();
		}while(!Validador.validarNombre(nombre));

		String apellido;
		do {
			System.out.println("\n"+"Apellido de contacto: ");
			apellido = Validador.entradaString();
		}while(!Validador.validarApellido(apellido));

		String numTelefono;
		do {
			System.out.println("\n"+"Número telefónico de contacto: ");
			numTelefono = String.valueOf(Validador.entradaInt());
		}while(!Validador.validarNumTelefono(numTelefono) || !verificarNumContacto(numTelefono));

		System.out.println("\n"+"Dirección de contacto");
		String direccion = Validador.entradaString();

		Contacto contacto = new Contacto(nombre, apellido, numTelefono, direccion);
		contactos.add(contacto);
		System.out.println("Se ha creado el contacto sin problemas");
	}

	private boolean verificarNumContacto(String numero){

		for (Contacto contacto : contactos) {
			if(contacto.getNumTelefono().equals(numero)) {
				return false;
			}
		}
		return true;
	}
	private void modificarContacto(Contacto contacto) {

		int opcion = 0;

		do {
			mostrarInfoEdicion();
			opcion = Validador.entradaInt();

			switch (opcion) {
				case 1 -> {
					String nombre;
					do {
						System.out.println("\n" + "Nombre de contacto: ");
						nombre = Validador.entradaString();
					}while(!Validador.validarNombre(nombre));
					contacto.setNombre(nombre);
				}
				case 2 -> {
					String apellido;
					do {
						System.out.println("\n"+"Apellido de contacto: ");
						apellido = Validador.entradaString();
					}while(!Validador.validarApellido(apellido));
					contacto.setApellido(apellido);
				}
				case 3 -> {
					String numTelefono;
					do {
						System.out.println("\n"+"Número telefónico de contacto: ");
						numTelefono = String.valueOf(Validador.entradaInt());
					}while(!Validador.validarNumTelefono(numTelefono) || !verificarNumContacto(numTelefono));
					contacto.setNumTelefono(numTelefono);
				}
				case 4 -> {
					System.out.println("\n"+"Dirección de contacto");
					contacto.setDireccion(Validador.entradaString());
				}
				case 5 -> System.out.println("Saliendo del editor...");
				default -> System.out.println("Fallo al elegir la opción");
			}
			}while(opcion !=5);
		}

	public void editarContacto(int numTelefono) {

		for (Contacto contacto : contactos) {

			if (contacto.getNumTelefono().equals("+569" + String.valueOf(numTelefono))) {
				modificarContacto(contacto);
				System.out.println("Se ha modificado el contacto sin problemas");
				return;
			}
		}
		System.out.println("No se ha encontrado el contacto");
	}

	public void eliminarContacto(int numTelefono) {

		for(Contacto contacto : contactos) {

			if (contacto.getNumTelefono().equals("+569" + String.valueOf(numTelefono))){
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

	private void mostrarMenu(){

		System.out.println("\n" + "Bienvenido al menú" + "\n");
		System.out.println("Elija una opción" + "\n");
		System.out.println("[1] Agregar un contacto");
		System.out.println("[2] Editar un contacto");
		System.out.println("[3] Borrar un contacto");
		System.out.println("[4] Ordenar contactos por fecha de creación");
		System.out.println("[5] Ordenar contactos por nombre");
		System.out.println("[6] Mostrar contactos");
		System.out.println("[7] Salir" + "\n");
	}

	private void mostrarInfoEdicion(){

		System.out.println("Elija una opción" + "\n");
		System.out.println("[1] Modificar nombre");
		System.out.println("[2] Modificar apellido");
		System.out.println("[3] Modificar número telefónico");
		System.out.println("[4] Modificar dirección");
		System.out.println("[5] Salir" + "\n");
	}

	public void menu() {
		Scanner teclado = new Scanner(System.in);
		Archivo archivo = new Archivo();
		if(archivo.getArchivo().exists()){
			cargarContactos(archivo);
		}
		int opcion = 0;

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
		}while(opcion !=7);

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
}