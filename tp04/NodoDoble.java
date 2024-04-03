public class NodoDoble {
    private int info;
    private NodoDoble next;
    private NodoDoble prev;

    public NodoDoble() {
        this.next = null;
        this.prev = this;
    }

    public void setInfo(int value) {
        this.info = value;
    }

    public int getInfo() {
        return this.info;
    }

    public void setNext(NodoDoble next) {
        this.next = next;
    }

    public NodoDoble getNext() {
        return this.next;
    }

    public void setPrev(NodoDoble prev) {
        this.prev = prev;
    }

    public NodoDoble getPrev() {
        return this.prev;
    }    
}