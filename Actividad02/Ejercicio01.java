package Actividad02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;


public class Ejercicio01 {


    public static void mostrarEnPantalla(int[] array_principal) {
        System.out.println("Los numeros del array son:");
        int i = 0;
        while (i < array_principal.length) {
            System.out.println(array_principal[i]);
            i++;
        }
    }

    public static void ordenarparesimpares(int[] array_principal){
        int i = 0;
        for (i = 0 ; i < array_principal.length ; i ++){
            if (array_principal[i] % 2 == 0){
                System.out.printf(" [%d] ", array_principal[i]);
            }
        }
        for (i = 0 ; i < array_principal.length ; i ++){
            if (array_principal[i] % 2 == 1){
                System.out.printf(" [%d] ", array_principal[i]);
            }
        }

    }


    public static void menorymayor(int[] array_principal){
        int mayor = array_principal[0];
                for (int x = 1; x < array_principal.length; x++) {
                    if (array_principal[x] > mayor) {
                        mayor = array_principal[x];
                    }
                }
                System.out.println("El numero mas grande es: " + mayor);
                
                int menor = array_principal[0];
                
                for (int x = 1; x > array_principal.length; x++) {
                    if (array_principal[x] < menor) {
                        menor = array_principal[x];
                    }
                }
                System.out.println("El numero mas pequeño es: " + menor);
    }


    public static void sumarvalores(int[]array_principal){
        int i = 0;
        int sum = 0;
                    for ( i = 0; i < array_principal.length; i++) {
                        sum+=array_principal[i];
                    }
                    System.out.println("La suma del array es: = "+sum);
    }


    public static void modificarunvalor(int[]array_principal){
        Scanner teclado2 = new Scanner(System.in);
        int variablecaso1;

        do {
            System.out.println("Selecciona que posicion quieres modificar (1-5)");
            variablecaso1 = teclado2.nextInt();
        

        }while( variablecaso1 > 5 || variablecaso1 <= 0);

        if (variablecaso1 == 1 ){

            do{
                System.out.println("Has seleccionado la posicion 1 del array Introduce un numero del 0 al 100" );
                array_principal [0] = teclado2.nextInt();


            }while( array_principal [0] < 0 || array_principal [0] > 100);

        } else if (variablecaso1 == 2 ){

            do{
                System.out.println("Has seleccionado la posicion 2 del array Introduce un numero del 0 al 100" );
                array_principal [1] = teclado2.nextInt();


            }while( array_principal [1] < 0 || array_principal [1] > 100);

        }else if (variablecaso1 == 3){

            do{
                System.out.println("Has seleccionado la posicion 3 del array Introduce un numero del 0 al 100" );
                array_principal [2] = teclado2.nextInt();


            }while( array_principal [2] < 0 || array_principal [2] > 100);

        }else if (variablecaso1 == 4){

           do{
                System.out.println("Has seleccionado la posicion 4 del array Introduce un numero del 0 al 100" );
                array_principal [3] = teclado2.nextInt();


            }while( array_principal [3] < 0 || array_principal [3] > 100);

        }else if (variablecaso1 == 5){

            do{
                System.out.println("Has seleccionado la posicion 5 del array Introduce un numero del 0 al 100" );
                array_principal [4] = teclado2.nextInt();


            }while( array_principal [4] < 0 || array_principal [4] > 100);
        }
    }

    
    public static void pideenteroentre(int[]array_principal){

        Scanner teclado1 = new Scanner(System.in);

        System.out.println("Introduce el numero 1 ");
        array_principal[0] = teclado1.nextInt();
        do{
            if (array_principal[0] < 0){
                System.out.println("El valor introducido es incorrecto, introduce un valor entre 0 y 100");
                array_principal[0] = 0 ;
                array_principal[0] = teclado1.nextInt();
            }
            if (array_principal[0] > 100){
                System.out.println("El valor introducido es incorrecto, introduce un valor entre 0 y 100");
                array_principal[0] = 0 ;
                array_principal[0] = teclado1.nextInt();
            }
        }while(array_principal[0] < 0 || array_principal[0] > 100);
            
        System.out.println("Introduce el numero 2 ");
        array_principal[1] = teclado1.nextInt();
        do{
            if (array_principal[1] < 0){
                System.out.println("El valor introducido es incorrecto, introduce un valor entre 0 y 100");
                array_principal[1] = 0 ;
                array_principal[1] = teclado1.nextInt();
            }
            if (array_principal[1] > 100){
                System.out.println("El valor introducido es incorrecto, introduce un valor entre 0 y 100");
                array_principal[1] = 0 ;
                array_principal[1] = teclado1.nextInt();
            }
        }while(array_principal[1] < 0 || array_principal[1] > 100);


        System.out.println("Introduce el numero 3 ");
        array_principal[2] = teclado1.nextInt();
        do{
            if (array_principal[2] < 0){
                System.out.println("El valor introducido es incorrecto, introduce un valor entre 0 y 100");
                array_principal[2] = 0 ;
                array_principal[2] = teclado1.nextInt();
            }
            if (array_principal[2] > 100){
                System.out.println("El valor introducido es incorrecto, introduce un valor entre 0 y 100");
                array_principal[2] = 0 ;
                array_principal[2] = teclado1.nextInt();
            }
        }while(array_principal[2] < 0 || array_principal[2] > 100);

        System.out.println("Introduce el numero 4 ");
        array_principal[3] = teclado1.nextInt();
        do{
            if (array_principal[3] < 0){
                System.out.println("El valor introducido es incorrecto, introduce un valor entre 0 y 100");
                array_principal[3] = 0 ;
                array_principal[3] = teclado1.nextInt();
            }
            if (array_principal[3] > 100){
                System.out.println("El valor introducido es incorrecto, introduce un valor entre 0 y 100");
                array_principal[3] = 0 ;
                array_principal[3] = teclado1.nextInt();
            }
        }while(array_principal[3] < 0 || array_principal[3] > 100);

        System.out.println("Introduce el numero 5 ");
        array_principal[4] = teclado1.nextInt();
        do{
            if (array_principal[4] < 0)
            {
            System.out.println("El valor introducido es incorrecto, introduce un valor entre 0 y 100");
            array_principal[4] = 0 ;
            array_principal[4] = teclado1.nextInt();
            }
            if (array_principal[4] > 100)
            {
                System.out.println("El valor introducido es incorrecto, introduce un valor entre 0 y 100");
                array_principal[4] = 0 ;
                array_principal[4] = teclado1.nextInt();
            }
        }while(array_principal[4] < 0 || array_principal[4] > 100);

    }

    public static void main(String[] args) throws IOException {
        int[] array_principal;
        array_principal = new int[5];
        

        pideenteroentre(array_principal);
        mostrarEnPantalla(array_principal);

        do{
            System.out.println("Introduzca la operacion a realizar del siguiente menu de opciones");
            System.out.println("1- Modificar el valor almacenado en una posicion");
            System.out.println("2- Resultado de sumar todos los numeros");
            System.out.println("3- Mostrar el numero mas bajo y mas alto");
            System.out.println("4- Ordenar el array situando primero todos los numeros pares y luego los impares");
            System.out.println("0- Cerrar el programa :)");

            BufferedReader mr = new BufferedReader(new InputStreamReader(System.in));
            String valor_usuario = mr.readLine();

            int valorincorrecto = Integer.parseInt (valor_usuario);
            
            if (valorincorrecto > 4){
            System.out.println("EL VALOR INTRODUCIDO ES INCORRECTRO INTRODUCE UN VALOR CORRECTO");    
            }
            if (valorincorrecto < 0){
            System.out.println("EL VALOR INTRODUCIDO ES INCORRECTRO INTRODUCE UN VALOR CORRECTO");   
            }

            switch (valor_usuario){
                
                case "1":

                    modificarunvalor(array_principal);
                    mostrarEnPantalla(array_principal);

                break;

                case "2":

                    sumarvalores(array_principal);
                    mostrarEnPantalla(array_principal);

                break;

                case "3":

                    menorymayor(array_principal);

                    mostrarEnPantalla(array_principal);

                break;

                case "4":

                    ordenarparesimpares(array_principal);

                    mostrarEnPantalla(array_principal);

                break;

                case "0":
                System.out.println("CERRANDO PROGRAMA");
                System.exit(0);

            }

        }while(true);

    }       
}
