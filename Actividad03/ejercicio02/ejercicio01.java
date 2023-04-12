package ejercicio02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejercicio01 {
    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("Menú:");
            System.out.println("1. Nuevo Archivo");
            System.out.println("2. Listar Archivos");
            System.out.println("3. Mostrar un Archivo");
            System.out.println("4. Borrar un Archivo");
            System.out.println("5. Renombrar un Archivo");
            System.out.println("6. Reemplazar caracteres de un Archivo");
            System.out.println("7. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    nuevoArchivo();
                    break;
                case 2:
                    listarArchivos();
                    break;
                case 3:
                    mostrarUnArchivo();
                    break;
                case 4:
                    borrarUnArchivo();
                    break;
                case 5:
                    renombrarUnArchivo();
                    break;
                case 6:
                    reemplazarCaracteres();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, por favor elige una opción válida.");
                    break;
            }
        }
    }
    //FUNCION NUEVOARCHIVO
    public static void nuevoArchivo() {
        Scanner sc = new Scanner(System.in);
    
        // Crear carpeta "archivos" si no existe
        File carpeta = new File("archivos");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
    
        // Pedir nombre del archivo y texto a escribir
        System.out.println("Ingresa el nombre del archivo (incluye la extensión): ");
        String nombreArchivo = sc.nextLine();
        System.out.println("Ingresa el texto a escribir en el archivo: ");
        String texto = sc.nextLine();

        // Crear archivo y escribir texto
        try {
            FileWriter writer = new FileWriter("archivos/" + nombreArchivo);
            writer.write(texto);
            writer.close();
            System.out.println("Archivo creado y texto escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
    }

    //FUNCION LISTAR ARCHIVOS 
    public static String[] listarArchivos() {
        File carpeta = new File("archivos");
        File[] listaArchivos = carpeta.listFiles();
        String[] rutasArchivos = new String[listaArchivos.length];
    
        for (int i = 0; i < listaArchivos.length; i++) {
            if (listaArchivos[i].isFile()) {
                System.out.println((i + 1) + "-" + listaArchivos[i].getName());
                rutasArchivos[i] = listaArchivos[i].getAbsolutePath();
            }
        }
        return rutasArchivos;
    }

    //FUNCION MOSTRAR ARCHIVOS
    public static void mostrarUnArchivo() {
        Scanner sc = new Scanner(System.in);
    
        String[] rutasArchivos = listarArchivos();
    
        System.out.println("Ingresa el número del archivo que deseas ver: ");
        int opcion = sc.nextInt();
        if (opcion <= 0 || opcion > rutasArchivos.length) {
            System.out.println("Opción inválida, por favor elige una opción válida.");
        } else {
            try {
                File archivo = new File(rutasArchivos[opcion - 1]);
                Scanner lectura = new Scanner(archivo);
                while (lectura.hasNextLine()) {
                    System.out.println(lectura.nextLine());
                }
                lectura.close();
            } catch (IOException e) {
                System.out.println("Ocurrió un error al abrir el archivo.");
                e.printStackTrace();
            }
        }
    }

    //FUNCION BORRAR ARCHIVOS
    public static void borrarUnArchivo() {
        Scanner sc = new Scanner(System.in);
    
        String[] rutasArchivos = listarArchivos();
    
        System.out.println("Ingresa el número del archivo que deseas borrar: ");
        int opcion = sc.nextInt();
        if (opcion <= 0 || opcion > rutasArchivos.length) {
            System.out.println("Opción inválida, por favor elige una opción válida.");
        } else {
            File archivo = new File(rutasArchivos[opcion - 1]);
            if (archivo.delete()) {
                System.out.println("Archivo eliminado correctamente.");
            } else {
                System.out.println("Ocurrió un error al eliminar el archivo.");
            }
        }
    }

    //FUNCION REMPLAZAR CARACTERES
    public static void reemplazarCaracteres(){
        String[] rutasArchivos = listarArchivos();

        if(rutasArchivos.length==0){
            System.out.println("No hay archivos para modificar");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige el número del archivo que deseas modificar:");
        int opcion = scanner.nextInt();
        if(opcion>rutasArchivos.length){
            System.out.println("Opcion Invalida");
            return;
        }

        String rutaArchivo = rutasArchivos[opcion - 1];
        System.out.println("Elige el caracter que deseas reemplazar:");
        char caracterViejo = scanner.next().charAt(0);
        System.out.println("Elige el caracter por el cual deseas reemplazar:");
        char caracterNuevo = scanner.next().charAt(0);

        try (RandomAccessFile archivo = new RandomAccessFile(rutaArchivo, "rw")) {
            for (int i = 0; i < archivo.length(); i++) {
                archivo.seek(i);
                char caracterActual = (char) archivo.read();
                if (caracterActual == caracterViejo) {
                    archivo.seek(i);
                    archivo.write(caracterNuevo);
                }
            }
            System.out.println("Archivo modificado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al abrir o modificar el archivo.");
        }
    }
    // FUNCION RENOMBRAR ARCHIVO
    public static void renombrarUnArchivo(){
        String[] rutasArchivos = listarArchivos();
        if(rutasArchivos.length==0){
            System.out.println("No hay archivos para renombrar");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige el número del archivo que deseas renombrar:");
        int opcion = scanner.nextInt();
        if(opcion>rutasArchivos.length){
            System.out.println("Opcion Invalida");
            return;
        }
        String rutaArchivo = rutasArchivos[opcion - 1];
        File archivo = new File(rutaArchivo);
        System.out.println("Ingresa el nuevo nombre del archivo:");
        String nuevoNombre = scanner.next();
        //valida si el nuevo nombre es valido
        if(!nuevoNombre.matches("^[a-zA-Z0-9_-]*$")){
            System.out.println("Nombre de archivo invalido");
            return;
        }
        //Hace que el nombre se ponga con .txt al final.
        if (!nuevoNombre.endsWith(".txt")) {
            nuevoNombre += ".txt";
        }
        // obtiene la ruta del archivo
        String ruta = archivo.getParent();
        // construye el nuevo archivo con el nuevo nombre
        File archivoRenombrado = new File(ruta + File.separator + nuevoNombre);
        // renombra el archivo
        boolean resultado = archivo.renameTo(archivoRenombrado);
        if (resultado) {
            System.out.println("Archivo renombrado correctamente.");
        } else {
            System.out.println("Error al renombrar el archivo.");
        }
    }


}
    



