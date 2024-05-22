package arbol;

public class NodoAB {
    private int info;
    private ArbolB izquierdo;
    private ArbolB derecho;
    private int diferenciaAltura;

    public int getDiferenciaAltura() {
        return diferenciaAltura;
    }

    public void setDiferenciaAltura(int diferenciaAltura) {
        this.diferenciaAltura = diferenciaAltura;
    }

    public NodoAB(int info) {
        this.info = info;
        this.izquierdo = new ArbolB();
        this.derecho = new ArbolB();
        this.diferenciaAltura = 0;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
    public ArbolB getIzquierdo() {
        return izquierdo;
    }
    public void setIzquierdo(ArbolB izquierdo) {
        this.izquierdo = izquierdo;
    }
    public ArbolB getDerecho() {
        return derecho;
    }
    public void setDerecho(ArbolB derecho) {
        this.derecho = derecho;
    }
    
        
}
