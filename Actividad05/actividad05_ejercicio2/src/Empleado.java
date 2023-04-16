import java.io.Serializable;
import java.util.ArrayList;

public class Empleado implements Serializable {
    private String nombre;
    private String sexo;
    private String franjaEdad;
    private ArrayList<String> aficiones;

    public Empleado(String nombre, String sexo, String franjaEdad, ArrayList<String> aficiones) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.franjaEdad = franjaEdad;
        this.aficiones = aficiones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFranjaEdad() {
        return franjaEdad;
    }

    public void setFranjaEdad(String franjaEdad) {
        this.franjaEdad = franjaEdad;
    }

    public ArrayList<String> getAficiones() {
        return aficiones;
    }

    public void setAficiones(ArrayList<String> aficiones) {
        this.aficiones = aficiones;
    }
}
