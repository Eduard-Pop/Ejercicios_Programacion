package ejercicio01.operaciones;
import java.util.Random;

import ejercicio01.introduceDatos.pregunta;

public class valores {
    public static void muestrapi(){
        System.out.println(Math.PI);
    }

    public static void MuestraValorAleatorio(){
        int num = pregunta.pideEntero("Quieres un valor aleatorio entre el 0 y el ... : ");
        Random rnd = new Random();
        int aleatorio = rnd.nextInt(num + 1);
        System.out.println("Valor aleatorio: " + aleatorio);
    }
}
