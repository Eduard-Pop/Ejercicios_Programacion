
package vehiculos;

import java.util.Scanner;


public class Coche extends Vehiculo {

    private char gama;
    private Scanner sc;
    
    public Coche(){}

    public Coche(String matricula, String modelo, int numero_plazas, char gama) {
        super(matricula, modelo, numero_plazas);
        this.gama = gama;
    }
    
    
    @Override
    public void pideDatos(){
        super.pideDatos();
        sc = new Scanner(System.in); 
        System.out.println("Gama");
        gama = sc.nextLine().charAt(0);
    }
    
    
    @Override
    public void setNumeroDias(int n) {
        super.setNumeroDias(n);
    }

    @Override
    public double getPrecioTotalAlquilerDias() {
        super.setPrecioAlquiler(super.getNumeroPlazas() * 1.5);
        return super.getPrecioBase() + super.getPrecioTotalAlquilerDias();
    }

    @Override
    public String toString() {
        return "Coche: " + super.toString().concat(" --precio alquiler = "+this.getPrecioTotalAlquilerDias() +" --gama = " + gama);
    }
    
    
    
}
