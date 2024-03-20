class Punto {
    float x, y = 0;
    public Punto() {
        this.x = 10;
        this.y = 10;
    }

    @Override
    public String toString() {
        String salida;
        salida = "X: "+this.x+" Y: "+this.y;
        return salida;
    }
    
}

class ej04 {

    public static void main(String[] args) {

        Punto a = new Punto();
        System.out.println(a);
    }

}