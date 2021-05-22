import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Archivo {

    private final String ruta = "src/main/resources/bovedaContactos.txt";
    private final File archivo = new File(ruta);
    private ArrayList<String> informacion = new ArrayList<>();
    private String valor = "";


    public Archivo(){

    }

    private void crearArchivo(){

        try {
            boolean b = archivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribirArchivo(){

        if(!archivo.exists()){
            crearArchivo();
        }try {
            FileWriter escritor = new FileWriter(archivo);
            escritor.write(valor);
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void leerArchivo() {

        try {
            if (!archivo.exists()) {
                informacion.add("El archivo no existe");
                return;
            }
            String[] lineas;
            FileReader file = new FileReader(archivo);
            BufferedReader lector = new BufferedReader(file);
            String cadena;

            while ((cadena = lector.readLine()) != null) {
                cadena = cadena.replace(" ", "");
                cadena = cadena.replace("+569", "");
                lineas = cadena.split("=");
                informacion.add(lineas[1]);
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public ArrayList<String> cargarArchivo(){
        leerArchivo();
        return informacion;
    }

    public void setValor(String valor) {

        this.valor = valor;
    }

    public void getValor(String valor) {

        this.valor = valor;
    }
    public File getArchivo() {
        return archivo;
    }

    public ArrayList<String> getInformacion() {
        return informacion;
    }
}