public class TestCuenta {
    public static void main(String[] args) {
        Cuenta c1 = new Cuenta(1, 1000, "Juan");
        Cuenta c2 = new Cuenta(2, 500, "Pedro");

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("1. Consultar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Sacar dinero");
            System.out.println("4. Realizar transferencia");
            System.out.println("5. Salir");
            System.out.print("Elije una opción: ");
            opcion = Utilidades.pedirEntero("");

            switch (opcion) {
                case 1:
                    int numCuenta = Utilidades.pedirEntero("Introduce el número de la cuenta");
                    Cuenta c = (numCuenta == c1.getNumeroCuenta()) ? c1 : c2;
                    System.out.println("El saldo de la cuenta " + c.getNumeroCuenta() + " es " + c.getSaldo());
                    break;
                case 2:
                    numCuenta = Utilidades.pedirEntero("Introduce el número de la cuenta");
                    c = (numCuenta == c1.getNumeroCuenta()) ? c1 : c2;
                    double cantidad = Utilidades.pedirDoble("Introduce la cantidad a ingresar");
                    c.setSaldo(c.getSaldo() + cantidad);
                    System.out.println("Se ha ingresado " + cantidad + " en la cuenta " + c.getNumeroCuenta());
                    break;
                case 3:
                    numCuenta = Utilidades.pedirEntero("Introduce el número de la cuenta");
                    c = (numCuenta == c1.getNumeroCuenta()) ? c1 : c2;
                    cantidad = Utilidades.pedirDoble("Introduce la cantidad a retirar");
                    if (c.getSaldo() >= cantidad) {
                        c.setSaldo(c.getSaldo() - cantidad);
                        System.out.println("Se ha retirado " + cantidad + " de la cuenta " + c.getNumeroCuenta());
                    } else {
                        System.out.println("No hay suficiente saldo en la cuenta " + c.getNumeroCuenta());
                    }
                    break;
                case 4:
                    System.out.println("Realizar transferencia");
                    System.out.println("Cuentas disponibles:");
        
                    int cuentaOrigen = Utilidades.pedirEntero("Selecciona la cuenta de origen :") - 1;
                    int cuentaDestino = Utilidades.pedirEntero("Selecciona la cuenta destino :") - 1;
        
                    double cantidad2 = Utilidades.pedirDoble("Introduce la cantidad a transferir:");
                    Cuenta cOrigen, cDestino;
                    if (cuentaOrigen == 0) {
                        cOrigen = c1;
                    } else {
                        cOrigen = c2;
                    }
                    if (cuentaDestino == 0) {
                        cDestino = c1;
                    } else {
                        cDestino = c2;
                    }
                    if (cOrigen.getSaldo() >= cantidad2) {
                        cOrigen.setSaldo(cOrigen.getSaldo() - cantidad2);
                        cDestino.setSaldo(cDestino.getSaldo() + cantidad2);
                        System.out.println("Transferencia realizada con éxito");
                    } else {
                        System.out.println("No hay suficiente saldo en la cuenta de origen");
                    }
                    break;
                }
            }
        }
    }
//}