/**
 * Implementa una busqeuda primero en profundidad.
 */
public class Busquedas {
    private TDAGrafo grafo;
    private Vertice inicial;
    private Object[] visitados;
    private int indexVisitados;

    public Busquedas() {
    }    
    
    public Busquedas(TDAGrafo grafo, Vertice inicial) {
        this.grafo = grafo;
        this.inicial = inicial;
        this.resetVertices();
    }

    private void resetVertices() {
        this.visitados = new Object[100];
        this.indexVisitados = 0;
    }

    public void ejecutarBPP() {
        this.resetVertices();
        this.busquedaPrimeroProfundidad(this.grafo, this.inicial);
    }

    public void ejecutarBPA() {
        this.resetVertices();
        this.busquedaPrimeroAncho(this.grafo, this.inicial);
    }

    private void agregarVisitado(Vertice v) {
        this.visitados[this.indexVisitados] = v;
        this.indexVisitados++;
    }
    
    public void busquedaPrimeroProfundidad(TDAGrafo grafo, Vertice v) {

        this.agregarVisitado(v);
        System.out.println(v.toString());

        Vertice[] adyacentes = grafo.Adyacentes(v);
        
        for (Vertice w : adyacentes) {
            if ((w != null) && !w.pertenece(this.visitados, this.indexVisitados)) {
                this.busquedaPrimeroProfundidad(grafo, w);
            }            
        }
    }

    public void busquedaPrimeroAncho(TDAGrafo grafo, Vertice v) {
            
        // Vertice[] adyacentes = grafo.Adyacentes(v);

        // for (Vertice w : adyacentes) {
        //     if (!w.isVisitado()) {
        //         w.setVisitado(true);    
        //         System.out.println(w.toString());
        //     }
        // }
        // for (Vertice w : adyacentes) {
        //     busquedaPrimeroAncho(grafo, w);    
        // }

    }

    // Inserta en el arreglo de arcos, un nuevo 
    // arco, pero manteniendo el orden:
    // [0 1 2 3 4 5]
    // [1 1 3 4 4 ] <-- 2
    // [1 1 2 3 4 4 ] 
    private void insertarArcoOrdenado(Arco[] arcos, Arco arco, int cantidad) {
        int peso = arco.getPeso();

        for (int i = 0; i < cantidad; i++) {
            Arco movil = arcos[i];
            if (movil.getPeso() > peso) {
                for (int j = cantidad; j > i; j--) {
                    arcos[j] = arcos[j-1];
                }
                arcos[i] = arco;
                return;
            }
        }
        // Si no encontro uno mayor, va al final
        arcos[cantidad] = arco;
    }

    private Arco[] arcosOrdenados(Arco[] arcos) {
        Arco[] salida = new Arco[100];
        Arco arco;
        int cantidad = this.cantidadArcos(arcos);
        for (int i = 0; i < cantidad; i++) {
            arco = arcos[i];
            insertarArcoOrdenado(salida, arco, i);
        }
        return salida;
    }

    private int cantidadArcos(Arco[] origen) {
        int cantidad = 0;
        for (Arco arco : origen) {
            if (arco == null) {
                return cantidad;
            } else {
                cantidad++;
            }
        }
        return cantidad;
    }

    private int cantidadVertices(Vertice[] origen) {
        int cantidad = 0;
        for (Vertice vertice : origen) {
            if (vertice == null) {
                return cantidad;
            } else {
                cantidad++;
            }
        }
        return cantidad;
    }    

    private void crearArboles(Vertice[] vertices, Conjunto[] arboles) {
        int cantidad = cantidadVertices(vertices);
        for (int i = 0; i < cantidad; i++) {
            Vertice v = vertices[i];
            arboles[i] = new Conjunto();
            arboles[i].Agregar(v.getInfo());
        }
    }

    private int conjuntoArbol(Conjunto[] arboles, Vertice v, int nVertices) {
        for (int i = 0; i < nVertices; i++) {
            Conjunto X = arboles[i];
            if (X.Pertenece(v.getInfo())) {
                return i;
            }
        }
        return 0;
    }

    private void agregarVertices(TDAGrafo grafo, Vertice[] vertices) {
        int cantidad = cantidadVertices(vertices);
        for (int i = 0; i < cantidad; i++) {
            Vertice v = vertices[i];
            grafo.AgregaVertice(v);
        }
    }

    private void unificarArboles(Conjunto[] arboles, int origen, int destino) {
        Conjunto cnjtDestino = arboles[destino];
        Conjunto cnjtOrigen = arboles[origen];

        while (!cnjtOrigen.ConjuntoVacio()) {
            int elemento = cnjtOrigen.Elegir();
            cnjtOrigen.Sacar(elemento);
            cnjtDestino.Agregar(elemento);
        }
    }

    private void mostrarArboles(Conjunto[] arboles, int nCantidad) {
        for (int i = 0; i < nCantidad; i++) {
            Conjunto A = arboles[i];
            System.out.print(i + ":"+A.toString()+" ");
        }
        System.out.println("");
    }

    public TDAGrafo kruskal(TDAGrafo grafo) {
        Grafo mst = new Grafo();

        Vertice[] vertices = grafo.Vertices();
        Conjunto[] arboles = new Conjunto[100];

        crearArboles(vertices, arboles);
        Arco[] arcos = arcosOrdenados(grafo.Arcos());

        int nArcos = cantidadArcos(arcos);
        int nVertices = cantidadVertices(vertices);

        agregarVertices(mst, vertices);

        int i = 0;
        Arco movil;
        while ((i < nArcos) && (i <= (nVertices-1))) {
            movil = arcos[i];
            i++;
            // Verificar que el origen y el destino del arco movil
            // pertenezcan a distinto arbol.
            int origen = conjuntoArbol(arboles, movil.getA(), nVertices);
            int destino = conjuntoArbol(arboles, movil.getB(), nVertices);
            mostrarArboles(arboles, nVertices);
            if (origen != destino) {
                mst.AgregaArco(movil.getA().getInfo(), movil.getB().getInfo(), movil.getPeso());
                System.out.println("Agrega arco:"+movil);
                unificarArboles(arboles, origen, destino);
            }
        }
        
        System.out.println(mst.toString());

        return mst;
    }

}
