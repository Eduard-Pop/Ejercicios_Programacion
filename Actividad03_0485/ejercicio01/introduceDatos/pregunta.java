package ejercicio01.introduceDatos;
import java.util.Scanner;

public class pregunta {
    public static int pideEntero(String pregunta) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean error = true;
        while (error) {
            try {
                System.out.print(pregunta);
                numero = sc.nextInt();
                error = false;
            } catch (Exception e) {
                System.out.println("Por favor, introduce un valor correcto.");
                sc.nextLine();
            }
        }
        return numero;
    }
    public static double pideDouble(String pregunta) {
        Scanner sc = new Scanner(System.in);
        double numero = 0.0;
        boolean error = true;
        while (error) {
            try {
                System.out.print(pregunta);
                numero = sc.nextDouble();
                error = false;
            } catch (Exception e) {
                System.out.println("Por favor, introduce un valor correcto.");
                sc.nextLine();
            }
        }
        return numero;
    }
}