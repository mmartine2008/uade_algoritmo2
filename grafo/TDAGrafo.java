interface TDAGrafo {

    void GrafoVacio();
    void AgregaVertice(Vertice v);
    void AgregaArco(int a, int b);
    Vertice[] Vertices();
    Arco[] Arcos();
    Vertice[] Adyacentes(Vertice v); 
    void BorrarVertice(Vertice v);
    void BorrarArco(Arco arco);


}