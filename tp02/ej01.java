class ej01 {

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