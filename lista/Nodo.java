class Nodo {
    int info;
    Nodo siguiente;

    public Nodo() {
        this.siguiente = null;
    }

    public Nodo(int info) {
        this.siguiente = null;
        this.setInfo(info);
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public int getInfo() {
        return this.info;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return this.siguiente;
    }

}