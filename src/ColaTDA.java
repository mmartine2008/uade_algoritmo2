public interface ColaTDA {
    void InicializarCola();

    // La cola está inicializada
    void Acolar(int x);

    // Cola inicializada y no vacia
    void Desacolar();

    // Cola inicializada
    boolean ColaVacia();

    // Cola inicializada y no vacia
    int Primero();
}