public class Vertice {
    
    public Vertice(int info) {
        this.info = info;
    }

    int info;

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public boolean igual(Vertice otro) {
        if (this.info == otro.getInfo()) 
            return true;
        else
            return false;
    }

    public boolean pertenece(Object[] contenido, int largo) {
        Vertice movil;

        for (int i = 0; i < largo; i++) {
            movil = (Vertice) contenido[i];
            if (this.igual(movil)) {
                return true;
            }    
        }

        return false;
    }


    public String toString() {
        String output = "";

        output = "("+this.getInfo()+")";

        return output;
    }
}
