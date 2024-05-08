class Nodo {
    int info;
    Nodo siguiente;
    Nodo anterior;

    public Nodo() {
        this.siguiente = null;
        this.anterior = null;
    }

    public Nodo(int info) {
        this.siguiente = null;
        this.anterior = null;
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

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getAnterior() {
        return this.anterior;
    }    
}