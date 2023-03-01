// https://www.aceptaelreto.com/problem/statement.php?id=153

import java.io.IOException;
import java.util.Scanner;

public class Reto153 {
    public static void main(String[] args)throws IOException{
        
        Scanner sc = new Scanner(System.in);
        int horas, mins;

        for (;;){
            
            System.out.println("Introduce la hora:"); horas = sc.nextInt();
            System.out.println("Introduce los minutos"); mins = sc.nextInt();

            if(mins == 60)
            {
                horas = 11 - horas;
                mins = 00;

            }else if(horas == 12)
            {
                mins = 60 - mins;
                horas = 12;

            }else
            {
                horas = 11 - horas;
                mins = 60 - mins;

            }
            System.out.println("Realmente son las " + horas + ":" + mins);
        }
       
    }
}