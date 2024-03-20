class Punto {
    float x, y = 0;
}

class ej01 {

    public static void main(String[] args) {

        Punto a = new Punto();
        Punto b = new Punto();

        a.x = 10; a.y = 15;
        b.x = 10; b.y = 20;

        System.out.println("X:"+a.x+" Y:"+a.y);
        System.out.println("X:"+b.x+" Y:"+b.y);

    }

}