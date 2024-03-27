package geometria;

public class Punto {
    private float x, y = 0;
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

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX(float x) {
        return this.x;
    }

    public float getY(float y) {
        return this.y;
    }
}
