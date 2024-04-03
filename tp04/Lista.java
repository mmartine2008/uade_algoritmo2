public class Lista {

    Nodo primero;

    public Lista() {
        this.primero = new Nodo();
    }

    public void add(int x) {
        Nodo nuevo = new Nodo();
        nuevo.setInfo(x);

        Nodo pivote = this.primero;
        while (pivote.getNext() != null) {
            pivote = pivote.getNext();
        }
        pivote.setNext(nuevo);
    }

    public boolean vacia() {
        return this.primero.getNext() == null;
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

        }
    }

}