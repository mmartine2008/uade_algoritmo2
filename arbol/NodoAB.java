package arbol;

class NodoAB {
    private int info;
    private ArbolB izquierdo;
    private ArbolB derecho;

    public NodoAB (int valor) {
        this.info = valor;
        this.izquierdo = new ArbolB();
        this.derecho = new ArbolB();
    }

    public void setInfo(int info) {
        this.info = info;
    }
    
    public int getInfo() {
        return this.info;
    }

    public void setIzquierdo(ArbolB izquierdo) {
        this.izquierdo = izquierdo;
    }
    public ArbolB getIzquierdo() {
        return izquierdo;
    }
    public ArbolB getDerecho() {
        return derecho;
    }

}
