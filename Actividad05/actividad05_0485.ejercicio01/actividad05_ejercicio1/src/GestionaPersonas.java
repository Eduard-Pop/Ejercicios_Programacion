import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
public class GestionaPersonas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Persona> trabajadores = new HashMap<>();
        ArrayList<Persona> grupoTrabajo = new ArrayList<>();

        try {
            trabajadores.put("12345678A", new Persona("Edu", 20, "y0123482P"));
            trabajadores.put("23456789B", new Persona("PEPE", 25, "123456789"));
        } catch (EdadIncorrecta | NombreIncorrecto | DniIncorrecto e) {
            e.printStackTrace();
        }

        int opcion;

        do {
            //MENU

            System.out.println("Menú:");
            System.out.println("1- Crea un trabajador");
            System.out.println("2- Borra un trabajador");
            System.out.println("3- Añade un trabajador al grupo de trabajo");
            System.out.println("4- Borra un trabajador del grupo de trabajo");
            System.out.println("0- Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            //SWITCH
            switch (opcion) {
                
                case 1:
                
                    System.out.print("Nombre: ");
                    scanner.nextLine(); 
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    System.out.print("DNI: ");
                    scanner.nextLine(); 
                    String dni = scanner.nextLine();

                    try {
                        Persona persona = new Persona(nombre, edad, dni);
                        trabajadores.put(dni, persona);
                        System.out.println("Trabajador creado.");
                    } catch (EdadIncorrecta | NombreIncorrecto | DniIncorrecto e) {
                        System.out.println(e.getMessage());
                    }
                    mostrarInformacion(trabajadores, grupoTrabajo);
                    break;

                case 2:
                    // f. Borrar un trabajador
                    System.out.print("DNI del trabajador a borrar: ");
                    scanner.nextLine(); // Limpiar el buffer
                    String dniBorrar = scanner.nextLine();
                    if (trabajadores.containsKey(dniBorrar)) {
                        trabajadores.remove(dniBorrar);
                        System.out.println("Trabajador borrado.");
                    } else {
                        System.out.println("Trabajador no encontrado.");
                    }
                    mostrarInformacion(trabajadores, grupoTrabajo);
                    break;

                case 3:
                    // g. Añadir trabajador al grupo de trabajo
                    System.out.print("DNI del trabajador a añadir al grupo de trabajo: ");
                    scanner.nextLine(); // Limpiar el buffer
                    String dniAgregar = scanner.nextLine();
                    if (trabajadores.containsKey(dniAgregar)) {
                        try {
                            agregarAlGrupo(grupoTrabajo, trabajadores.get(dniAgregar));
                            System.out.println("Trabajador añadido al grupo de trabajo.");
                        } catch (DemasiadosObjetos e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Trabajador no encontrado.");
                    }
                    mostrarInformacion(trabajadores, grupoTrabajo);
                    break;

                // case 4
                case 4:
                    // h. Borrar trabajador del grupo de trabajo
                    System.out.print("Índice del trabajador a borrar del grupo de trabajo: ");
                    int indice = scanner.nextInt();
                    try {
                        borrarDelGrupo(grupoTrabajo, indice);
                        System.out.println("Trabajador borrado del grupo de trabajo.");
                    } catch (PosicionIncorrecta e) {
                        System.out.println(e.getMessage());
                    }
                    mostrarInformacion(trabajadores, grupoTrabajo);
                    break;

            }
        } while (true);

    }

    public static void agregarAlGrupo(ArrayList<Persona> grupoTrabajo, Persona persona) throws DemasiadosObjetos {
         if (grupoTrabajo.size() >= 2) {
         throw new DemasiadosObjetos("El grupo de trabajo no puede contener más de 2 personas.");
         }
        grupoTrabajo.add(persona);
    }

    public static void borrarDelGrupo(ArrayList<Persona> grupoTrabajo, int indice) throws PosicionIncorrecta {
         if (indice < 0 || indice >= grupoTrabajo.size()) {
         throw new PosicionIncorrecta("Índice fuera del rango válido.");
         }
        grupoTrabajo.remove(indice);
    }

    public static class DemasiadosObjetos extends Exception {
        public DemasiadosObjetos(String message) {
            super(message);
        }
    }

    public static class PosicionIncorrecta extends Exception {
        public PosicionIncorrecta(String message) {
            super(message);
        }
    }

    public static void mostrarInformacion(HashMap<String, Persona> trabajadores, ArrayList<Persona> grupoTrabajo) {
        System.out.println("\nTrabajadores:");
        for (Persona persona : trabajadores.values()) {
            System.out.println(
                    "Nombre: " + persona.getNombre() + ", Edad: " + persona.getEdad() + ", DNI: " + persona.getDni());
        }
    
        System.out.println("\nGrupo de trabajo:");
        for (int i = 0; i < grupoTrabajo.size(); i++) {
            Persona persona = grupoTrabajo.get(i);
            System.out.println("Índice: " + i + ", Nombre: " + persona.getNombre() + ", Edad: " + persona.getEdad() + ", DNI: " + persona.getDni());
        }
    }    
}