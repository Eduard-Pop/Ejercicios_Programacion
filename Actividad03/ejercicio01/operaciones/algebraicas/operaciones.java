package ejercicio01.operaciones.algebraicas;

import ejercicio01.introduceDatos.pregunta;

public class operaciones {
    public static void MuestraRaizCuadrada() {
        double resultado = Math.sqrt(pregunta.pideDouble("¿De que numero quieres realizar la raiz cuadrada?: "));
        System.out.println("La raiz cuadrada es " + resultado);
    }

    public static void calculaPotencia(double base, double exponente) {
        //base = pregunta.pideDouble("¿Que numero quieres que sea tu base?: ");
        //exponente = pregunta.pideDouble("¿Que numero quieres que sea tu exponente?: ");
        double resultado = Math.pow(base, exponente);
        System.out.println("El resultado es: " + resultado);
    }
}
