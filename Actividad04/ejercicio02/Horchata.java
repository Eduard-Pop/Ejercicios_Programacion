class Horchata extends Comida {
    private double cantidad;
    private double porcentajeChufa;

    public Horchata(String nombre, double precio, double kcal, double cantidad, double porcentajeChufa) {
        super(nombre, precio, kcal);
        this.cantidad = cantidad;
        this.porcentajeChufa = porcentajeChufa;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPorcentajeChufa() {
        return porcentajeChufa;
    }

    public void setPorcentajeChufa(double porcentajeChufa) {
        this.porcentajeChufa = porcentajeChufa;
    }

    @Override
    public String toString() {
        return super.toString() + ", cantidad:" + cantidad + ", chufa:" + porcentajeChufa + "%";
    }
}