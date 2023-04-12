class Cucurucho extends Comida {
    private SaborHelado[] saboresHelado;

    public Cucurucho(String nombre, double precio, double kcal, int numBolas) {
        super(nombre, precio, kcal);
        this.saboresHelado = new SaborHelado[numBolas];
    }

    public boolean addBolaHelado(SaborHelado bola, int posicion) {
        if (posicion >= 0 && posicion < saboresHelado.length && saboresHelado[posicion] ==  null) {
            saboresHelado[posicion] = bola;
            return true;
        }
        return false;
    }

    public double calculaPrecioTotal() {
        double total = precio;
        for (SaborHelado sabor : saboresHelado) {
            if (sabor != null) {
                total += sabor.getPrecio();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        for (int i = 0; i < saboresHelado.length; i++) {
            if (saboresHelado[i] != null) {
                sb.append("\nBola").append(i).append("- ").append(saboresHelado[i].toString());
            }
        }
        return sb.toString();
    }
}