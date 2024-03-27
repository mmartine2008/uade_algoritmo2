class Linea {
    Punto origen;
    Punto destino;
    public Linea() {
        this.origen = new Punto();
        this.destino = new Punto();
    }

    @Override
    public String toString() {
        String salida;
        salida = "Origen: "+ this.origen
                    + " Destino: "+this.destino;
        return salida;
    }
}
