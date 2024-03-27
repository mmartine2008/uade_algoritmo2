class Punto {
    float x, y = 0;
    public Punto() {
        this.x = 0;
        this.y = 0;
    }
    @Override
    public String toString() {
        String salida;
        salida = "X: "+this.x+" Y: "+this.y;
        return salida;
    }    
}
