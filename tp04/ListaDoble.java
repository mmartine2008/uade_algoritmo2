public class ListaDoble {

    NodoDoble primero;

    public ListaDoble() {
        this.primero = new NodoDoble();
    }

    public void add(int x) {
        // Creo el nuevo
        NodoDoble nuevo = new NodoDoble();
        nuevo.setInfo(x);
        // Modificaciones sobre el nuevo
        NodoDoble ultimo = this.primero.getPrev();
        nuevo.setPrev(ultimo);

        // Modificaciones sobre el ultimo
        ultimo.setNext(nuevo);
        this.primero.setPrev(nuevo);
    }

    public boolean vacia() {
        return this.primero.getPrev() == this.primero;
    }

    public String toString() {
        NodoDoble pivote;
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

    // Si el valor existe, devuelve el NodoDoble, sino null
    public NodoDoble existe(int value) {
        NodoDoble pivote;
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
        NodoDoble pivote;

        pivote = this.existe(value);

        if (pivote != null) {
            NodoDoble prev = pivote.getPrev();
            NodoDoble next = pivote.getNext();

            prev.setNext(next);
            next.setPrev(prev);

            pivote.setNext(null);
            pivote.setNext(null);
        }
    }

}