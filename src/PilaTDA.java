public interface PilaTDA {
    void InicializarPila();

    // La pila está inicializada
    void Apilar(int x);

    // Pila inicializada y no vacia
    void Desapilar();

    // Pila inicializada
    boolean PilaVacia();

    // Pila inicializada y no vacia
    int Tope();
}