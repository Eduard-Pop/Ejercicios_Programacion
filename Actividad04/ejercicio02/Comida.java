public class Comida {
    protected String nombre;
    protected double precio;
    protected double kcal;

    public Comida(String nombre, double precio, double kcal) {
        this.nombre = nombre;
        this.precio = precio;
        this.kcal = kcal;
    }

    public Comida(String nombre2, double precio2, String string) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", " + kcal + "kcal, precio:" + precio + "€";
    }
}