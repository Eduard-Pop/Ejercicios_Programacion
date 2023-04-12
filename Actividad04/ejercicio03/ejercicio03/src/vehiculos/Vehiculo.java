
package vehiculos;


import java.util.Scanner;


public abstract class Vehiculo implements IAlquilable {
    
    private String matricula;
    private String modelo;
    private int numero_plazas;
    private int numero_dias_alquiler = 1;
    private final double PRECIO_BASE_ALQUILER_DIA = 50;
    private double precio_alquiler;
    private Scanner sc;
    
    
    public Vehiculo(){}

    
    public Vehiculo(String matricula, String modelo, int numero_plazas) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.numero_plazas = numero_plazas;
    }
    
  
    public void pideDatos(){
        sc = new Scanner(System.in);
        System.out.println("Matricula: ");
        this.matricula = sc.nextLine();
        System.out.println("Modelo: ");
        this.modelo = sc.nextLine();
        System.out.println("Número de plazas: ");
        try {
            this.numero_plazas = sc.nextInt();    
        } catch(Exception e){
            numero_plazas = 0;
        }
        
    }
    
    
    @Override
    public void setNumeroDias(int n){
        this.numero_dias_alquiler = n;
    }
    
    public int getNumeroDias(){
        return this.numero_dias_alquiler;
    }
    
    public int getNumeroPlazas(){
        return this.numero_plazas;
    }
    
    public double getPrecioBase(){
        return this.PRECIO_BASE_ALQUILER_DIA;
    }
    
    public void setPrecioAlquiler(double d){
        this.precio_alquiler += d;
    }
    
    @Override
    public double getPrecioTotalAlquilerDias(){ 
        return precio_alquiler * numero_dias_alquiler;
    }

    
    @Override
    public String toString() {
        return " matricula = " + matricula + " --modelo = " + modelo + " --numero_plazas = " + numero_plazas +
                " --precio base alquiler = " + PRECIO_BASE_ALQUILER_DIA + " --dias alquiler = "+numero_dias_alquiler;
    }
    
    
    
}
