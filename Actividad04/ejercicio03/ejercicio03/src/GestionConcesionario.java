import seguros.Seguro;
import vehiculos.Coche;
import vehiculos.IAlquilable;
import vehiculos.Vehiculo;
import vehiculos.VehiculoCarga;
import java.util.Scanner;


public class GestionConcesionario {
    
    private Seguro [] seguros;
    private Vehiculo [] flota;
    private  IAlquilable [] alquileres;
    private Scanner sc;
    
    
    public GestionConcesionario(){
        sc = new Scanner(System.in);
        Seguro s1 = new Seguro("Mapfre" , "todo riesgo");
        Seguro s2 = new Seguro("Mutua", "terceros");
        seguros = new Seguro[2];
        seguros[0] = s1;
        seguros[1] = s2;
        
        Vehiculo c1 = new Coche("3022-BNJ", "citroen", 4, 'A');
        Vehiculo c2 = new Coche("4582-FRM", "mercedes", 5, 'B');
        Vehiculo vc1 = new VehiculoCarga("4521-NVG", "scania", 2, "3500");
        Vehiculo vc2 = new VehiculoCarga("7531-LMV", "man", 3, "12000");
        
        flota = new Vehiculo[4];
        flota[0] = c1;
        flota[1] = c2;
        flota[2] = vc1;
        flota[3] = vc2;
        
        seleccionaOpcion();
    }
    
    
    private void initMenu(){
        System.out.println("");
        System.out.println("Inicio...");
        System.out.println("1 - Mostrar información de flota");
        System.out.println("2 - Mostrar información de seguros");
        System.out.println("3 - Reiniciar alquiler total vehiculos y seguros a alquilar");
        System.out.println("4 - Mostrar alquiler");
        System.out.println("0 - Salir");
        System.out.println("Escoger opción: ");
    }
    
    
    private void seleccionaOpcion() {
        int op = -1;
        do {
            try {
                initMenu();
                op = sc.nextInt();
                tratarOpcion(op);
            } catch (Exception e) {
                op = -1;
                sc.next();
            }
        } while (op != 0);
    }
    
    
    private void tratarOpcion(int op){
        switch(op){
            case 1:
                mostrarFlota();
                break;
            case 2:
                mostrarSeguros();
                break;
            case 3:
                reiniciarAlquiler();
                break;
            case 4:
                mostrarAlquiler();
                break;
            default:
                if(op != 0){
                  System.out.println(" !!! La opción no es correcta...");    
                }
                break;
        }
    }
    
    private void mostrarFlota(){
        System.out.println("\n -----------------------------------------");
        System.out.println(" ---Información flota");
        for (int i = 0; i < flota.length; i++) {
            System.out.println((i+1) + " - "+flota[i]);
        }
    }
    
    private void mostrarSeguros(){
        System.out.println("\n -----------------------------------------");
        System.out.println(" ---Información seguros");
        for (int i = 0; i < seguros.length; i++) {
            System.out.println((i+1) + " - "+seguros[i]);
        }
    }
    
    private void reiniciarAlquiler(){
        System.out.println("\n -----------------------------------------");
        System.out.println(" ---Reiniciar alquiler");
        
        String v = "Número de vehiculos a alquilar (1-5): ";
        int v_alquiler = getAlquiler(v);
        String s = "Número de seguros a alquilar (1-5): ";
        int s_alquiler = getAlquiler(s);
           
        alquileres = new IAlquilable[v_alquiler + s_alquiler];
        
        System.out.println("\nEscoger por el número de indice...");
        mostrarFlota();
        String vs = "Escoger vehiculos de la flota: ";
        setVehiculoSeguro(vs, v_alquiler, alquileres, flota);
        
        System.out.println("Escoger por el número de indice...");
        mostrarSeguros();
        String ss = "Escoger seguros: ";
        setVehiculoSeguro(ss, s_alquiler, alquileres, seguros);
        
        int dias_alquiler = solicitarDiasAlquiler();
        for(IAlquilable aux: alquileres){
            aux.setNumeroDias(dias_alquiler);
        }
    }
    
    private void mostrarAlquiler(){
        if(alquileres != null && alquileres.length > 0){
            System.out.println("\n -----------------------------------------");
            System.out.println(" ---Resumen alquileres");
            for(IAlquilable aux: alquileres){
                System.out.println(aux);
            }
        } else {
            System.out.println("\n !!! No existen alquileres...");
        }
    }
    
    
    /**
     * Guarda en el array alquileres la selección del usuario
     * @param s
     * @param t
     * @param alquileres
     * @param aux 
     */
    private void setVehiculoSeguro(String s, int t, IAlquilable[] alquileres, IAlquilable[] aux) {
        int p = 0;
        while (alquileres[p] != null) { //posición libre dentro del array alquileres para guardar el siguiente elemento
            p++;
        }
        System.out.println(s);
        System.out.println("Primero :");
        for (int i = 0; i < t; i++) {
            if (i > 0) {
                System.out.println("Siguiente: ");
            }
            int indice = getEntero();
            if (indice <= 0 || indice > aux.length) {
                System.out.println("!!!Error, esa opción no existe...");
                System.out.println("Volver a probar: ");
                i--;
            } else {
                alquileres[p++] = aux[indice - 1];
            }
        }
    }
    
    
    private int solicitarDiasAlquiler(){
        System.out.println("\nSelecionar dias alquiler (1-30): ");
        int n = 0;
        do {
            n = getEntero();
            if(n < 1 || n > 30){
                System.out.println(" !!! Error el valor tiene que estar entre 1 y 30 dias...");
                System.out.println("Vovler a intentar: ");
            }
        } while(n < 1 || n > 30);
        return n;
    }
    
    
    /**
     * Pide cantidad a alquilar ya sea Vehiculo o seguro
     * @param s
     * @return 
     */
    private int getAlquiler(String s){
        int alquiler = -1;
        do {
            System.out.println(s);
            alquiler = getEntero();
            
            if (alquiler <= 0 || alquiler > 5) {
                System.out.println(" !!! Error, el valor tiene que estar entre 1 y 5...");
            }
        } while (alquiler <= 0 || alquiler > 5);
        return alquiler;
    }
    
    
    private int getEntero() {
        int n = 0;
        do {
            try {
                if (n == -1) {
                    System.out.println(" !!! Valor incorrecto...");
                    System.out.println("Volver a probar: ");
                }
                n = sc.nextInt();
            } catch (Exception e) {
                n = -1;
                sc.next();
            }
        } while (n < 0);
        return n;
    }
    
    public static void main(String[] args) {
        new GestionConcesionario();
    }
    
}
