public class Arco {
    
    public Arco(Vertice a, Vertice b) {
        this.a = a;
        this.b = b;
        this.peso = -1;
    }

    public Arco(Vertice a, Vertice b, int peso) {
        this.a = a;
        this.b = b;
        this.peso = peso;
    }

    Vertice a;
    Vertice b;
    int peso;

    public Vertice getA() {
        return a;
    }
    public void setA(Vertice a) {
        this.a = a;
    }
    public Vertice getB() {
        return b;
    }
    public void setB(Vertice b) {
        this.b = b;
    }

    public int getPeso() {
        return this.peso;
    }
    
    public String toString() {
        String output = "";

        if (this.getPeso() >= 0) {
            output = "["+this.a.getInfo()+";"+this.b.getInfo()+":"+this.getPeso()+"]";
        } else {
            output = "["+this.a.getInfo()+";"+this.b.getInfo()+"]";
        }
        

        return output;
    }

}
