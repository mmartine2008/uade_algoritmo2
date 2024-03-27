class Punto {
    int x;
    int y;
    String nota;
}

class ej01 {

    public static void main(String[] args) {
        Punto a, b;
        int z = 10;

        z = 10;
        a = new Punto();
        a.x = 10; 
        a.y = 15;
        a.nota = "Este es un punto";

        b = new Punto();
        b.x = 30; 
        b.y = 45;
        b.nota = "Este es otro punto";

        System.out.println("X:"+a.x+" Y:"+a.y+" Nota:"+a.nota);
        System.out.println("X:"+b.x+" Y:"+b.y+" Nota:"+b.nota);

    }

}