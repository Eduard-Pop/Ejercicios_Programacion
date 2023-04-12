package ejercicio01.operaciones.geometricas;

public class operaciones2 {
    public static void MuestraSeno(double num) {
        double seno = Math.sin(num);
        System.out.println("El seno de " + num + " es: " + seno);
    }

    public static double MuestraCoseno(double num) {
        double coseno = Math.cos(num);
        System.out.println("El coseno de " + num + " es: " + coseno);
        return coseno;
    }
}
