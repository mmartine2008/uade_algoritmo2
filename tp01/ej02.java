class Punto {
    int x, y = 0;
    String nota;
}

class Linea {
    Punto origen;
    Punto destino;
}

class ej02 {

    public static void main(String[] args) {

        Linea l;
        
        l = new Linea();

        l.origen = new Punto();
        l.destino = new Punto();

        l.origen.x = 0;
        l.origen.y = 0;
        l.origen.nota = "Punto origen";

        l.destino.x = 10;
        l.destino.y = 20;
        l.destino.nota = "Punto destino";

        System.out.println(l.origen.nota);
        System.out.println(l.destino.nota);
    }

}