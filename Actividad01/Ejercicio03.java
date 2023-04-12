import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) throws IOException {
        float recipiente1 = 0;
        float recipiente2 = 0;

        do{

            System.out.println("Introduzca la operacion a realizar del siguiente menu de opciones");
            System.out.println("1- Añadir refresco al primer recipiente");
            System.out.println("2- Traspasar refresco del primer al segundo recipiente");
            System.out.println("3- Quitar refresco del segundo recipiente");
            System.out.println("0- Finalizar programa");
            BufferedReader mr = new BufferedReader(new InputStreamReader(System.in));
            String valor_usuario = mr.readLine();
            int valorincorrecto = Integer.parseInt (valor_usuario);
            
            if (valorincorrecto > 3){
            System.out.println("EL VALOR INTRODUCIDO ES INCORRECTRO INTRODUCE UN VALOR CORRECTO");    
            }
            if (valorincorrecto < 0){
            System.out.println("EL VALOR INTRODUCIDO ES INCORRECTRO INTRODUCE UN VALOR CORRECTO");   
            }
        
            switch (valor_usuario){

                case "1":
                Scanner valor_1 = new Scanner(System.in);
                System.out.println("Introduce un numero decimal");
                float dato1 = valor_1.nextFloat();

                if (dato1 < 0){
                    
                    System.out.println("Introduce un numero positivo");
                    break;

                }else{
                    
                    recipiente1 = dato1 + recipiente1;
                }
                if ( dato1 < 0) {

                    recipiente1 = recipiente1 - dato1;
                    System.out.println ("No puedes tener numeros negativos en un recipiente");
                    
        
                } else {
        
                    System.out.println("El estado actual del recipiente 1 es:"+ recipiente1);
                    System.out.println("El estado actual del recipiente 2 es:"+ recipiente2);
        
                }
                break;

                case "2":
                Scanner valor_2 = new Scanner(System.in);
                System.out.println("Introduce un numero decimal");
                float dato2 = valor_2.nextFloat();
                if (dato2 < 0){
                    
                    System.out.println("Introduce un numero positivo");
                    break;

                }else{

                    recipiente1 = recipiente1 - dato2;
                    recipiente2 = recipiente2 + dato2;
                    
                }
                if ( recipiente1 < 0) {

                    System.out.println ("No puedes tener numeros negativos en un recipiente");
                    recipiente1 = recipiente1 + dato2;
                    recipiente2 = recipiente2 - dato2;
        
                } else {
        
                    System.out.println("El estado actual del recipiente 1 es:"+ recipiente1);
                    System.out.println("El estado actual del recipiente 2 es:"+ recipiente2);
        
                }
                break;
            
                case "3":
                Scanner valor_3 = new Scanner(System.in);
                System.out.println("Introduce un numero decimal");
                float dato3 = valor_3.nextFloat();
                if (dato3 < 0){

                    System.out.println("Introduce un numero positivo");
                    break;

                } else {
                
                    recipiente2 = recipiente2 - dato3;

                }
                if ( recipiente2 < 0){

                    System.out.println ("No puedes tener numeros negativos en un recipiente");
                    recipiente2 = recipiente2 + dato3;

                } else { 

                    System.out.println("El estado actual del recipiente 1 es:"+ recipiente1);
                    System.out.println("El estado actual del recipiente 2 es:"+ recipiente2);
                } 
                break;

                case "0":
                System.out.println("CERRANDO PROGRAMA");
                System.exit(0);
            }


        }while(true);

    }
}