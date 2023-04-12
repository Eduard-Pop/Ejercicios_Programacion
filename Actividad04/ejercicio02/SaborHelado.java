class SaborHelado extends Comida {
    private double porcentajeGrasa;
    private String tipoEdulcorante;

    public SaborHelado(String nombre, double precio, double kcal, double porcentajeGrasa, String tipoEdulcorante) {
        super(nombre, precio, kcal);
        this.porcentajeGrasa = porcentajeGrasa;
        this.tipoEdulcorante = tipoEdulcorante;
    }

    public double getPorcentajeGrasa() {
        return porcentajeGrasa;
    }

    public void setPorcentajeGrasa(double porcentajeGrasa) {
        this.porcentajeGrasa = porcentajeGrasa;
    }

    public String getTipoEdulcorante() {
        return tipoEdulcorante;
    }

    public void setTipoEdulcorante(String tipoEdulcorante) {
        this.tipoEdulcorante = tipoEdulcorante;
    }

    @Override
    public String toString() {
        return super.toString() + " grasa:" + porcentajeGrasa + "%, edulcorante:" + tipoEdulcorante;
    }
}