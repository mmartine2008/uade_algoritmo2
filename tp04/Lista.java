public class Lista {

    Nodo primero;
    Nodo ultimo;

    public Lista() {
        this.primero = new Nodo();
        this.ultimo = this.primero;
    }

    public void add(int x) {
        Nodo nuevo = new Nodo();
        nuevo.setInfo(x);
        this.ultimo.setNext(nuevo);
        this.ultimo = nuevo;
    }

    public boolean vacia() {
        // return this.primero.getNext() == null;
        return this.primero == this.ultimo;
    }

    public String toString() {
        Nodo pivote;
        String out = "";

        if (this.vacia()) {
            return "<vacia>";
        }

        pivote = primero.getNext();
        while (pivote != null) {
            out = out + " " + pivote.getInfo();
            pivote = pivote.getNext();
        } 

        return out;
    } 

    // Si el valor existe, devuelve el nodo, sino null
    public Nodo existe(int value) {
        Nodo pivote;
        String out = "";

        pivote = primero.getNext();
        while (pivote != null) {
            if (pivote.getInfo() == value) {
                return pivote;
            }
            pivote = pivote.getNext();
        } 

        return null;
    }

    public void eliminar(int value) {
        Nodo prev;
        Nodo pivote;

        prev = this.primero;
        pivote = prev.getNext();
        while ((pivote != null) && (pivote.getInfo() != value)) {
            prev = pivote;
            pivote = prev.getNext();
        } 
        if (pivote != null) {
            prev.setNext(pivote.getNext());

            if (pivote == this.ultimo) {
                this.ultimo = prev;
            }
        }
    }

}