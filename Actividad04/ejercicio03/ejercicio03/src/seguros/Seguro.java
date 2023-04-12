package seguros;

import vehiculos.IAlquilable;


public class Seguro implements IAlquilable {

    
    private String nombre_seguro;
    private String descripcion;
    private final double PRECIO_ALQUILER_DIA = 10.5;
    private int dias_alquiler;
    private double precio_alquiler;
    
    public Seguro(String nombre, String descripcion){
        this.nombre_seguro = nombre;
        this.descripcion = descripcion;
        this.dias_alquiler = 1;
    }
    
    
    @Override
    public void setNumeroDias(int n) {
        this.dias_alquiler = n;
    }
    

    @Override
    public double getPrecioTotalAlquilerDias() {
        precio_alquiler = dias_alquiler * PRECIO_ALQUILER_DIA;
        return precio_alquiler;
    }

    @Override
    public String toString() {
        return "Seguro: nombre_seguro " + nombre_seguro 
                + " --descripcion = " + descripcion 
                + " --PRECIO_ALQUILER_DIA = " + PRECIO_ALQUILER_DIA
                + " --dias alquiler = "+ dias_alquiler
                + " --precio alquiler = "+getPrecioTotalAlquilerDias();
    }
    
    
    
}
