
public class Ejercicio02 {
    public static void main(String[] args){
        //2.1
        //Tipo de dato que puede ser solamente verdadero o falso y que ocupa 1 byte
        boolean verdadero = true;
        boolean falso = false;
        System.out.println("Variable boolean que puede ser "+ verdadero +" O "+ falso);
        //Tipo de dato que ocupa 1 byte y puede ser un numero de entre -128 hasta 127
        Byte numeroByte = 127;
        System.out.println("Variable byte que puede ir desde -128 hasta "+ numeroByte);
        //Tipo de dato que es un caracter unicode de 2bytes
        char letrachar = 'x';
        System.out.println("Variable char que puede mostrar un caracter unicode "+ letrachar);
        //Tipo de dato que ocupa 2bytes para representar numeros enteros
        short numeroshort = 4564;
        System.out.println("Variable short que puede mostrar un numero entero de 2 bytes "+ numeroshort);
        //Tipo de dato entero de 32 bits de longitud
        int numeroint = 89752;
        System.out.println("Variable tipo int muestra datos enteros de 32 bits. Ejemplo:"+ numeroint);
        //Tipo de dato entero de 64 bits de longitud
        long numerolong = 239785623;
        System.out.println("Variable tipo long muestra datos enteros de 64 bits. Ejemplo:"+ numerolong);
        //Tipo de dato decimal de 32 bits de longitud
        float numerofloat = 4.5241f;
        System.out.println("Variable tipo float muestra datos decimales de 32 bits. Ejemplo:"+ numerofloat);
        //Tipo de dato decimal de 64 bits de longitud
        double numerodouble = 6.23423234d;
        System.out.println("Variable tipo float muestra datos decimales de 64 bits. Ejemplo:"+ numerodouble);
        //2.2
        //OPERADORES ARITMETICOS BINARIOS
        int suma = numeroByte + numeroshort;
        System.out.println("Suma de dos numeros: "+ suma);
        int resta = numeroByte - numeroshort;
        System.out.println("Resta de dos numeros: "+ resta);
        int multiplicacion = numeroByte * numeroshort;
        System.out.println("Multiplicacion de dos numeros: "+ multiplicacion);
        int dividir = numeroshort / numeroByte;
        System.out.println("Division de dos numeros:"+ dividir);
        int resto = numeroByte / numeroshort ;
        System.out.println("Resto de una division de dos numeros:"+ resto);
        //OPERADORES ARITMETICOS UNARIOS
        int suma1 = numeroshort++;
        System.out.println("Suma 1 a la variable:"+ numeroshort);
        int resta1 = numeroByte--;
        System.out.println("Resta 1 a la variable:"+ numeroByte);
        int invertir = -numeroint;
        System.out.println("Cambia el signo de la variable:"+ invertir);
        boolean invertir1 = !verdadero;
        System.out.println("Invierte una variable boolean:"+ invertir1);
        //OPERADORES DE ASIGNACION
        int ASIGNACION = 20;
        ASIGNACION += 5;
        System.out.println("Sumar 5 :"+ ASIGNACION);
        ASIGNACION -= 5;
        System.out.println("Restar 5 :"+ ASIGNACION);
        ASIGNACION *= 4;
        System.out.println("Multiplicar x4 :"+ ASIGNACION);
        ASIGNACION /= 2;
        System.out.println("Dividir /2:"+ ASIGNACION);
        ASIGNACION %= 2;
        System.out.println("Resto de dividir /2:"+ ASIGNACION);
        //OPERADORES RELACIONALES
        int RELACIONALES1 = 10;
        System.out.println("A es igual a B :"+ (RELACIONALES1==10));
        System.out.println("A no es igual a B :"+ (RELACIONALES1!=10));
        System.out.println("A es mayor a B :"+ (RELACIONALES1>20));
        System.out.println("A es menor a B :"+ (RELACIONALES1<10));
        System.out.println("A es mayor o igual a B :"+ (RELACIONALES1>=10));
        System.out.println("A es menor o igual a B :"+ (RELACIONALES1<=20));
        //OPERADORES LOGICOS
        System.out.println("El resultado de true && false es:"+ (true && true) );
        System.out.println("El resultado de true || false es:"+ (true || false) );
        System.out.println("El resultado de (!true):"+ (!true) );
    }
}