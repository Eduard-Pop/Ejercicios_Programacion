package Actividad02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio2 {

    public static void mostrarinfopeliculas(String[][] array_peliculas) {

        for (int x=0; x < array_peliculas.length; x++){
            for (int y=0; y < array_peliculas[x].length; y++)
                  System.out.print(" | " + array_peliculas[x][y]+ " | ");   
            System.out.println("\n----------------------------------------");
        }
    }


    public static void modificanombrepelicula(String[][] array_peliculas){
        
        Scanner teclado1 = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);
        int variablecaso2;
        do {

            System.out.println("Selecciona que pelicula quieres modificar 1-3");
            variablecaso2 = teclado2.nextInt();

        }while( variablecaso2 > 3 || variablecaso2 <= 0);

        if (variablecaso2 == 1){

            System.out.println("¿Que nombre le quieres poner a la pelicula 1 ?");
            array_peliculas[0][0] = teclado1.nextLine();
        }
        if (variablecaso2 == 2){

            System.out.println("¿Que nombre le quieres poner a la pelicula 2 ?");
            array_peliculas[0][1] = teclado1.nextLine();
        }
        if (variablecaso2 == 3){

            System.out.println("¿Que nombre le quieres poner a la pelicula 3 ?");
            array_peliculas[0][2] = teclado1.nextLine();
        }
    }

    public static void modificarpuntuacionpelicula (String [][] array_peliculas){

                
        Scanner teclado1 = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);
        int variablecaso3;
        int variablecaso3_1;
        do {

            System.out.println("Selecciona a que pelicula le quieres modificar la puntuacion 1-3");
            variablecaso3 = teclado2.nextInt();

        }while( variablecaso3 > 3 || variablecaso3 <= 0);

        if (variablecaso3 == 1){

            do {

            System.out.println("¿Que puntuacion quieres modificar 1-4 ?");
            variablecaso3_1 = teclado2.nextInt();

            }while(variablecaso3_1 > 4 || variablecaso3_1 <= 0);
        
            if (variablecaso3_1 == 1){

            System.out.println("¿Que nota quieres poner en la posicion 1 ?");
            array_peliculas[1][0] = teclado1.nextLine();

            }else if (variablecaso3_1 == 2){

            System.out.println("¿Que nota quieres poner en la posicion 2 ?");
            array_peliculas[2][0] = teclado1.nextLine();
        

            }else if (variablecaso3_1 == 3){

            System.out.println("¿Que nota quieres poner en la posicion 3 ?");
            array_peliculas[3][0] = teclado1.nextLine();

            }else if (variablecaso3_1 == 4){

                System.out.println("¿Que nota quieres poner en la posicion 4 ?");
                array_peliculas[4][0] = teclado1.nextLine();

            }
    
        }else if (variablecaso3 == 2){

            do {

                System.out.println("¿Que puntuacion quieres modificar 1-4 ?");
                variablecaso3_1 = teclado2.nextInt();

            }while(variablecaso3_1 > 4 || variablecaso3_1 <= 0);
            
            if (variablecaso3_1 == 1){

                System.out.println("¿Que nota quieres poner en la posicion 1 ?");
                array_peliculas[1][1] = teclado1.nextLine();

            }else if (variablecaso3_1 == 2){

                System.out.println("¿Que nota quieres poner en la posicion 2 ?");
                array_peliculas[2][1] = teclado1.nextLine();
            

            }else if (variablecaso3_1 == 3){

                System.out.println("¿Que nota quieres poner en la posicion 3 ?");
                array_peliculas[3][1] = teclado1.nextLine();

            }else if (variablecaso3_1 == 4){

                System.out.println("¿Que nota quieres poner en la posicion 4 ?");
                array_peliculas[4][1] = teclado1.nextLine();

            }

        }else if (variablecaso3 == 3){

            do {

            System.out.println("¿Que puntuacion quieres modificar 1-4 ?");
            variablecaso3_1 = teclado2.nextInt();

            }while(variablecaso3_1 > 4 || variablecaso3_1 <= 0);
                
            if (variablecaso3_1 == 1){

                System.out.println("¿Que nota quieres poner en la posicion 1 ?");
                array_peliculas[1][2] = teclado1.nextLine();

            }else if (variablecaso3_1 == 2){

                System.out.println("¿Que nota quieres poner en la posicion 2 ?");
                array_peliculas[2][2] = teclado1.nextLine();
                

            }else if (variablecaso3_1 == 3){

                System.out.println("¿Que nota quieres poner en la posicion 3 ?");
                array_peliculas[3][2] = teclado1.nextLine();

            }else if (variablecaso3_1 == 4){

                System.out.println("¿Que nota quieres poner en la posicion 4 ?");
                array_peliculas[4][2] = teclado1.nextLine();

            }
        }
    }
    public static void mostrarpuntuacionespelicula (String[][] array_peliculas){
        Scanner teclado2 = new Scanner(System.in);
        int variablecaso4;
        do {

            System.out.println("Selecciona a que pelicula le quieres ver las puntuaciones 1-3");
            variablecaso4 = teclado2.nextInt();

        }while( variablecaso4 > 3 || variablecaso4 <= 0);
        
        if(variablecaso4 == 1){

            System.out.print(" | " + array_peliculas[0][0] +" | ");
            System.out.println("\n---------------");
            System.out.print(" | " + array_peliculas[1][0] +" | ");
            System.out.println("\n--------------");
            System.out.print(" | " + array_peliculas[2][0] +" | ");
            System.out.println("\n---------------");
            System.out.print(" | " + array_peliculas[3][0] +" | ");
            System.out.println("\n---------------");
            System.out.print(" | " + array_peliculas[4][0] +" | ");
            System.out.println("\n---------------");

        }
        else if (variablecaso4 == 2) {

            System.out.print(" | " + array_peliculas[0][1] +" | ");
            System.out.println("\n---------------");
            System.out.print(" | " + array_peliculas[1][1] +" | ");
            System.out.println("\n--------------");
            System.out.print(" | " + array_peliculas[2][1] +" | ");
            System.out.println("\n---------------");
            System.out.print(" | " + array_peliculas[3][1] +" | ");
            System.out.println("\n---------------");
            System.out.print(" | " + array_peliculas[4][1] +" | ");
            System.out.println("\n---------------");
            
        }
        else if (variablecaso4 == 3){

            System.out.print(" | " + array_peliculas[0][2] +" | ");
            System.out.println("\n---------------");
            System.out.print(" | " + array_peliculas[1][2] +" | ");
            System.out.println("\n--------------");
            System.out.print(" | " + array_peliculas[2][2] +" | ");
            System.out.println("\n---------------");
            System.out.print(" | " + array_peliculas[3][2] +" | ");
            System.out.println("\n---------------");
            System.out.print(" | " + array_peliculas[4][2] +" | ");
            System.out.println("\n---------------");

        }
    }

    public static void main(String[] args) throws IOException {
        
        String [][]  array_peliculas;
        array_peliculas = new String[5][3];

        array_peliculas[0][0] = "ET"; array_peliculas[0][1] = "Sharknado"; array_peliculas[0][2]= "Godzilla";
        
        array_peliculas[1][0] = "8"; array_peliculas[1][1]= "3"; array_peliculas[1][2] = "9";

        array_peliculas[2][0] = "5"; array_peliculas[2][1]= "8"; array_peliculas[2][2] = "7";

        array_peliculas[3][0] = "10"; array_peliculas[3][1]= "9"; array_peliculas[3][2] = "6";

        array_peliculas[4][0] = "4"; array_peliculas[4][1]= "7"; array_peliculas[4][2] = "8";
    
        mostrarinfopeliculas(array_peliculas);
    

        do{
            System.out.println("Introduzca la operacion a realizar del siguiente menu de opciones");
            System.out.println("1- Mostrar el nombre y puntuaciones de todas las películas.");
            System.out.println("2- Modificar el nombre de una película según su posición en el array");
            System.out.println("3- Modificar una puntuación de una película según su posición en el array");
            System.out.println("4- Mostrar las puntuaciones de una película en concreto seleccionada según su posición en el array.");
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
                
                mostrarinfopeliculas(array_peliculas);

                break;

                case "2":

                modificanombrepelicula(array_peliculas);

                break;
            
                case "3":

                modificarpuntuacionpelicula(array_peliculas);

                break;

                case "4":
                
                mostrarpuntuacionespelicula(array_peliculas);
                
                break;

                case "0":
                    System.out.println("CERRANDO PROGRAMA");
                    System.exit(0);
                break;

            }
            }while(true);
    }
} 