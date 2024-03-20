class Punto {
    float x, y = 0;
    public Punto() {
        this.x = 0;
        this.y = 0;
    }
}

class Linea {
    Punto origen;
    Punto destino;
    public Linea() {
        this.origen = new Punto();
        this.destino = new Punto();
    }
}

class ej02 {

    public static void main(String[] args) {

        Linea l = new Linea();
        l.origen = new Punto();
        l.destino = new Punto();

        l.origen.x = 0;
        l.origen.y = 0;
        l.destino.x = 10;
        l.destino.y = 20;

        System.out.println(l.origen.x);
    }

}