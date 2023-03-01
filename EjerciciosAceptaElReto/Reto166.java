import java.util.Scanner;

// https://www.aceptaelreto.com/problem/statement.php?id=166

import java.io.IOException;
import java.util.Scanner;

public class Reto166 {
    public static void main(String[] args)throws IOException{
        
        Scanner sc = new Scanner(System.in);
        int c_actual, c_final;
        int saltos = 0;

        for(;;){
            c_actual = sc.nextInt();
            c_final = sc.nextInt();
        
            if(c_actual == 0 && c_final == 0)
            {
                System.exit(0);
            }
            else if ( c_final > c_actual)
            {
                if((c_final - c_actual) <= 50)
                {
                    saltos = c_final - c_actual;
                }
                else
                {
                saltos = ((c_final - c_actual) - 99);
                saltos = saltos *-1 ;
                }
            }
            else if ( c_final < c_actual )
            {
                saltos = ((c_final - c_actual) + 99);
            }
            System.out.println("El numero de saltos seria: " + saltos );
        }
    }
}