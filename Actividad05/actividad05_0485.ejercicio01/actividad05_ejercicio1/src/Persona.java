public class Persona {
    private String nombre;
    private int edad;
    private String dni;

    public Persona(String nombre, int edad, String dni) throws EdadIncorrecta, NombreIncorrecto, DniIncorrecto {
        setNombre(nombre);
        setEdad(edad);
        setDni(dni);
    }

    //Getter del Nombre
    public String getNombre() {
        return nombre;
    }

    //Setter del Nombre
    public void setNombre(String nombre) throws NombreIncorrecto {
        if (nombre.length() < 3) {
            throw new NombreIncorrecto("El nombre debe tener mínimo 3 letras");
        }
        if (!nombre.matches("[a-zA-Z]+")) {
            throw new NombreIncorrecto("El nombre no puede tener dígitos");
        }
        this.nombre = nombre;
    }

    //Getter de la Edad
    public int getEdad() {
        return edad;
    }

    //Setter de la Edad
    public void setEdad(int edad) throws EdadIncorrecta {
        if (edad < 1 || edad > 110) {
            throw new EdadIncorrecta("La edad no puede ser menor a 1 ni mayor a 110");
        }
        this.edad = edad;
    }

    //Getter del DNI
    public String getDni() {
        return dni;
    }

    //Setter del DNI
    public void setDni(String dni) throws DniIncorrecto {
        if (dni.length() != 9) {
            throw new DniIncorrecto("El DNI ha de ser una string de 9 valores");
        }
        this.dni = dni;
    }
}

//CLASES DE DniIncorrecto,EdadIncorrecta,NombreIncorrecto
class DniIncorrecto extends Exception {
    public DniIncorrecto(String message) {
        super(message);
    }
}

class EdadIncorrecta extends Exception {
    public EdadIncorrecta(String message) {
        super(message);
    }
}

class NombreIncorrecto extends Exception {
    public NombreIncorrecto(String message) {
        super(message);
    }
}
