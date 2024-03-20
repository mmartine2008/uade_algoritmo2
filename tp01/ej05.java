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

class ej05 {

    public static void main(String[] args) {

        Linea l = new Linea();
        l.origen = new Punto();
        l.destino = new Punto();

        l.origen.x = 0;
        l.origen.y = 0;
        l.destino.x = 10;
        l.destino.y = 20;

        System.out.println(l);
    }

}