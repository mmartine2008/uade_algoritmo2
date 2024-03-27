import geometria.*;

class ej01 {

    public static void main(String[] args) {

        Linea l = new Linea();
        l.origen = new Punto();
        l.destino = new Punto();

        l.origen.setX(0);
        l.origen.setY(0);
        l.destino.setX(10);
        l.destino.setY(20);

        System.out.println(l);
    }

}
