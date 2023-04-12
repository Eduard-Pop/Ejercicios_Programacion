package ejercicio01.main;

import ejercicio01.introduceDatos.pregunta;
import ejercicio01.operaciones.valores;
import ejercicio01.operaciones.algebraicas.operaciones;
import ejercicio01.operaciones.geometricas.operaciones2;





public class ejercicio01 {
    public static void main(String[] args) {
        
        do{
            System.out.println("--- Menú ---");
            System.out.println("1. Ejecutar funcion MuestraPi");
            System.out.println("2. Ejecutar función MuestraValorAleatorio");
            System.out.println("3. Ejecutar función MuestraRaizCuadrada");
            System.out.println("4. Ejecutar función CalculaPotencia");
            System.out.println("5. Ejecutar función MuestraSeno");
            System.out.println("6. Ejecutar función MuestraCoseno");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
    
            switch(pregunta.pideEntero("")){
                case 1:

                valores.muestrapi(); break;

                case 2:

                valores.MuestraValorAleatorio(); break;

                case 3:

                operaciones.MuestraRaizCuadrada(); break;

                case 4:

                operaciones.calculaPotencia(pregunta.pideDouble("¿Que numero quieres que sea tu base?: "), pregunta.pideDouble("¿Que numero quieres que sea tu exponente?: ")); break;

                case 5:

               
                operaciones2.MuestraSeno(pregunta.pideDouble("¿De que numero quieres mostrar el seno?: ")); break;
            
                case 6:
                
                operaciones2.MuestraCoseno(pregunta.pideDouble("¿De que numero quieres mostrar el coseno?:")); break;

                case 0:
                    System.out.println("CERRANDO PROGRAMA");
                    System.exit(0);
                break;

            }
        }while(true);
    





    }
}
