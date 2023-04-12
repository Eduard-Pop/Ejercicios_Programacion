

import java.util.Scanner;

public class Utilidades {
   private static Scanner sc = new Scanner(System.in);

   public static int pedirEntero(String pregunta) {
      int numero = 0;
      boolean esValido = false;

      while (!esValido) {
         System.out.print(pregunta);

         try {
            numero = sc.nextInt();
            esValido = true;
         } catch (Exception e) {
            System.out.println("El valor introducido no es válido. Inténtelo de nuevo.");
            sc.nextLine();
         }
      }

      return numero;
   }

   public static double pedirDoble(String pregunta) {
      double numero = 0;
      boolean esValido = false;

      while (!esValido) {
         System.out.print(pregunta);

         try {
            numero = sc.nextDouble();
            esValido = true;
         } catch (Exception e) {
            System.out.println("El valor introducido no es válido. Inténtelo de nuevo.");
            sc.nextLine();
         }
      }

      return numero;
   }
}

class Cuenta {
   private int numeroCuenta;
   private double saldo;
   private String titular;

   public Cuenta(int numeroCuenta, double saldo, String titular) {
      this.numeroCuenta = numeroCuenta;
      this.saldo = saldo;
      this.titular = titular;
   }

   public int getNumeroCuenta() {
      return numeroCuenta;
   }

   public double getSaldo() {
      return saldo;
   }

   public String getTitular() {
      return titular;
   }

   public void setSaldo(double saldo) {
      this.saldo = saldo;
   }

   public void setTitular(String titular) {
      this.titular = titular;
   }
}