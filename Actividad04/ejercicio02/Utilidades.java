import java.util.Scanner;

public class Utilidades {
    
    private Scanner sc;
    
    public Utilidades(){
        sc = new Scanner(System.in);
    }
    
    public int pideEntero(String pregunta) {
        int v = -1;
        boolean b = false;
        while (!b) {
            try {
                System.out.println(pregunta);
                v = Integer.parseInt(sc.nextLine());
                b = true;
            } catch (Exception e) {
                System.out.println("\n !!!Error el número no es entero...");
                System.out.println("Volver a intentar: ");
            }
        }
        return v;
    }
    
    
    public double pideDouble(String pregunta){
        double v = -1;
        boolean b = false;
        while(!b){
            try {
                System.out.println(pregunta);
                v = Double.parseDouble(sc.nextLine());
                b = true;
            } catch(NumberFormatException e){
                System.out.println("\n !!!Error el número no es un double...");
                System.out.println("Volver a intentar: ");
            } 
        }
        return v;
    }
    
    
    public String pideString(String pregunta){
        String r = "";
        System.out.println(pregunta);
        r = sc.nextLine();
        return r;
    }
    
}
