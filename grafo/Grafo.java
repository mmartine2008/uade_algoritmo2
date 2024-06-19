import java.text.spi.NumberFormatProvider;

public class Grafo implements TDAGrafo {

    int ultimoVertice;
    private Vertice[] vertices;

    int ultimoArco;
    private Arco[] arcos;

    public Grafo () {
        this.GrafoVacio();
    }

    public void GrafoVacio() {
        this.ultimoVertice = 0;
        this.vertices = new Vertice[100];

        this.ultimoArco = 0;
        this.arcos = new Arco[100];
    }

    public void AgregaVertice(Vertice v) {
        this.vertices[this.ultimoVertice] = v;
        this.ultimoVertice++;
    }

    private void addArco(Arco a)  {
        this.arcos[this.ultimoArco] = a;
        this.ultimoArco++;
    }

    public void AgregaArco(int a, int b)  {
        Vertice vA = new Vertice(a);
        Vertice vB = new Vertice(b);

        if (vA.pertenece(this.vertices, this.ultimoVertice) && 
            vB.pertenece(this.vertices, this.ultimoVertice)) {
                Arco nuevo = new Arco(vA, vB);
                this.addArco(nuevo);
        }
    }

    public void AgregaArco(int a, int b, int peso)  {
        Vertice vA = new Vertice(a);
        Vertice vB = new Vertice(b);

        if (vA.pertenece(this.vertices, this.ultimoVertice) && 
            vB.pertenece(this.vertices, this.ultimoVertice)) {
                Arco nuevo = new Arco(vA, vB, peso);
                this.addArco(nuevo);
        }
    }

    public Vertice[] Vertices() {
        return this.vertices;
    }

    public Arco[] Arcos() {
        return this.arcos;
    } 

    // [0 2 3 5]
    // [0 3 5]
    public void BorrarVertice(Vertice v)
    {
        int pos = 0;
        for (Vertice vertice : this.vertices) {
            if (vertice.getInfo() == v.getInfo()) {
                this.BorrarVectorPosicion(pos, this.ultimoVertice, this.vertices);
                return;
            }
            pos ++;
        }
    }

    public void BorrarVectorPosicion(int posicion, int ultimo, Object[] vector) {
        for (int i=posicion; i<ultimo; i++ ) {
            vector[i] = vector[i+1];
        }
    }


    public void BorrarArco(Arco a) {
        int pos = 0;
        for (Arco arco : this.arcos) {
            if ((arco.getA() == a.getA()) &&
                (arco.getB() == a.getB())) {
                this.BorrarVectorPosicion(pos, this.ultimoArco, this.arcos);
                return;
            }
            pos ++;
        }

    }

    // Adyacentes  (5)   en adayacentes [5, 6] ó [5, 10]
    // No cargar repetidos   [6, 10]
    public Vertice[] Adyacentes(Vertice v) {
        Vertice[] adyacentes = new Vertice[100];
        int ultimo = 0;
        for (int i = 0; i < this.ultimoArco; i++ ) {
            Arco arco = this.arcos[i];
            if (arco.getA().igual(v) && !v.pertenece(adyacentes, ultimo))  {
                adyacentes[ultimo++] = arco.getB();
            }

            if (arco.getB().igual(v) && !v.pertenece(adyacentes, ultimo)) {
                
                adyacentes[ultimo++] = arco.getA();
            }
        }

        return adyacentes;

    }
    
    private String toStringVertices() {
        String output = "";
        
        for (int i = 0; i < this.ultimoVertice; i++) {
            output = output + this.vertices[i] + " ";
        }

        return "{"+output+"}";
    }

    private String toStringArcos() {

        String output = "";
        
        for (int i = 0; i < this.ultimoArco; i++) {
            output = output + this.arcos[i].toString() + " ";
        }

        return "{"+output+"}";
    }
    
    public String toString() {
        String output = "";

        output += "Vertices:" + this.toStringVertices();
        output += "\n";
        output += "Arcos:" +this.toStringArcos();

        return output;
    }
}