import java.util.Date;

public class Contacto {

	private String nombre;
	private String apellido;
	private String numTelefono;
	private String direccion;
	private final String fechaCreacion;

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = "+569" + numTelefono;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNumTelefono() {
		return this.numTelefono;
	}

	public String getFechaCreacion() {
		return this.fechaCreacion;
	}

	public Contacto(String nombre, String apellido, String numTelefono, String direccion) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.numTelefono = "+569" + numTelefono;
		this.direccion = direccion;
		this.fechaCreacion = new Date().toString();
	}

	public Contacto(String nombre, String apellido, String numTelefono, String direccion, String fechaCreacion) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.numTelefono = "+569" + numTelefono;
		this.direccion = direccion;
		this.fechaCreacion = fechaCreacion;
	}
	@Override
	public String toString() {
		return "  Nombre = " + nombre + "\n" +
				"  Apellido = " + apellido + "\n" +
				"  NumTelefono = " + numTelefono + "\n" +
				"  Direccion = " + direccion + "\n" +
				"  FechaCreacion = " + fechaCreacion + "\n";
	}
}