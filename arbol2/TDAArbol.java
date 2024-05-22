package arbol;

public interface TDAArbol {
    boolean esVacio(); 
    void InicializaArbol();
    TDAArbol HijoIzquierdo();
    TDAArbol HijoDerecho();
    int Raiz();
    void Agregar(int valor);
    void Eliminar(int valor);
}
