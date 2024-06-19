
public class TestGrafo {

    public static void testSimple() {
        Grafo g = new Grafo();

        g.AgregaVertice(new Vertice(1));
        g.AgregaVertice(new Vertice(2));
        g.AgregaVertice(new Vertice(3));

        g.AgregaArco(1, 2);
        g.AgregaArco(1, 3);
        g.AgregaArco(2, 3);

        System.out.println(g);

        int ady = 2;
        System.out.println("Adyacentes: "+ady );
        Vertice[] adyacentes = g.Adyacentes(new Vertice (ady));
        for (Vertice vertice : adyacentes) {
            if (vertice != null) {
                System.out.println(vertice);    
            }
        }

    }

    public static void BPP() {
        Grafo g = new Grafo();

        Vertice inicial = new Vertice(1);
        g.AgregaVertice(inicial);
        g.AgregaVertice(new Vertice(2));
        g.AgregaVertice(new Vertice(3));
        g.AgregaVertice(new Vertice(4));
        g.AgregaVertice(new Vertice(5));

        g.AgregaArco(1, 2);
        g.AgregaArco(1, 3);
        g.AgregaArco(1, 4);
        g.AgregaArco(2, 4);
        g.AgregaArco(2, 5);
        g.AgregaArco(3, 4);
        g.AgregaArco(4, 5);

        Busquedas B = new Busquedas(g, inicial);
        B.ejecutarBPP();

    }

    public static void testKruskal() {
        Grafo g = new Grafo();

        g.AgregaVertice(new Vertice(1));
        g.AgregaVertice(new Vertice(2));
        g.AgregaVertice(new Vertice(3));
        g.AgregaVertice(new Vertice(4));
        g.AgregaVertice(new Vertice(5));
        g.AgregaVertice(new Vertice(6));
        g.AgregaVertice(new Vertice(7));

        g.AgregaArco(1, 2, 3);
        g.AgregaArco(1, 5, 1);
        g.AgregaArco(2, 5, 8);
        g.AgregaArco(2, 3, 7);
        g.AgregaArco(2, 6, 5);
        g.AgregaArco(3, 6, 6);
        g.AgregaArco(3, 4, 9);
        g.AgregaArco(4, 6, 2);
        g.AgregaArco(4, 7, 4);
        g.AgregaArco(6, 7, 1);

        Busquedas B = new Busquedas();
        TDAGrafo k = B.kruskal(g);
        
    }

    public static void main(String[] args) {
        testKruskal();
    }
}
