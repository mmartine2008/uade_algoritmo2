class Punto {
    private int x, y = 0;
    
    int[] valores;

    public Punto() {
        this.x = 0;
        this.y = 0;
        System.out.println("Creando un objeto de tipo punto con valores "+x+":"+y);
    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Creando un objeto de tipo punto con valores "+x+":"+y);
    }

    public int getX() {

        return this.valores[0];
    }

    public int getY() {

        return this.valores[1];
    }

    public int recuperarX() {
        int valor = this.x;
        return valor;
    }

    public void setX(int x) {
        this.valores[0] = x;
    }

    public void cambiarX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public String toString() {
        String salida;
        salida = "("+this.getX()+":"+this.getY()+")";

        return salida;
    }

}

class ej03 {

    public static void main(String[] args) {
        Punto a = new Punto(5, 3);
        Punto b = new Punto();
        
        System.out.println(a.x);
        a.x = 10;
        System.out.println(a.recuperarX());
        a.cambiarX(10);

        System.out.println(a.getX()+":"+a.getY());
        System.out.println(a);
        System.out.println(b);        

    }

}