public class PilaTDA {
    void InicializarPila(){

    };

    // La pila está inicializada
    void Apilar(int x) {

    };

    // Pila inicializada y no vacia
    void Desapilar() {

    };

    // Pila inicializada
    boolean PilaVacia() {

    };

    // Pila inicializada y no vacia
    int Tope() {

    };

    public void pasarPila(PilaTDA origen, PilaTDA destino) {
        while (!origen.PilaVacia()) {
            destino.Apilar(origen.Tope());
            origen.Desapilar();
        }
    }

    int sumar(PilaTDA p1) { 
 	 	PilaTDA aux = new Pila();  	 	
        aux.inicializarPila();  	 	
        int sum=0;  
        int valor;
 	 	while(!p1.pilaVacia()) {  	 	 	
            valor = p1.tope(); 
            sum += valor;  	 	 	
            p1.desapilar();
            aux.Apilar(valor); 
	 	} 
        pasarPila(aux, p1);
        return sum;  
    } 
}