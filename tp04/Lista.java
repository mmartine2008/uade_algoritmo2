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

    public String toString() {
        Nodo pivote;
        String out = "";

        pivote = primero.getNext();
        while (pivote != null) {
            out = out + " " + pivote.getInfo();
            pivote = pivote.getNext();
        } 

        return out;
    } 

}