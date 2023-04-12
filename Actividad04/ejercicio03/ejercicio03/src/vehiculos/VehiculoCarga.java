package vehiculos;
import java.util.Scanner;


public class VehiculoCarga extends Vehiculo {

    private String pma; 
    private Scanner sc;
    
    
    public VehiculoCarga(){}

    
    public VehiculoCarga(String matricula, String modelo, int numero_plazas, String pma) {
        super(matricula, modelo, numero_plazas);
        this.pma = pma;
    }
    
    
    @Override
    public void pideDatos(){
        super.pideDatos();
        sc = new Scanner(System.in);
        System.out.println("Peso máximo autorizado: ");
        pma = sc.nextLine();
    }
    
    @Override
    public void setNumeroDias(int n) {
        super.setNumeroDias(n);
    }

    @Override
    public double getPrecioTotalAlquilerDias() {
        int pma = Integer.parseInt(this.pma);
        super.setPrecioAlquiler(1.5 * (pma/1000));
        return super.getPrecioBase() + super.getPrecioTotalAlquilerDias();
    }

    
    @Override
    public String toString() {
        return "VehiculoCarga: " + super.toString().concat(" --precio alquiler = "+ this.getPrecioTotalAlquilerDias() + " --pma = " + pma);
    }
    
    
    
}
