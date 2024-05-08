public class Lista {
    Nodo primero;

    public Lista() {
        this.primero = new Nodo();

        this.primero.setAnterior(this.primero);
    }

    public boolean Vacia() {
        return this.primero.getSiguiente() == null;
    }

    public void Agregar(int valor) {
        Nodo nuevo = new Nodo(valor);
        Nodo ultimo = this.primero.getAnterior();
        
        nuevo.setAnterior(ultimo);
        ultimo.setSiguiente(nuevo);

        this.primero.setAnterior(nuevo);
    }

    public boolean Existe(int valor) {
        if (this.Vacia()) {
            return false;
        }

        Nodo movil = this.primero.getSiguiente();
        while (movil != null) {
            if (movil.getInfo() == valor) {
                return true;
            }
            movil = movil.getSiguiente();
        }
        return false;
    }

    public String toString() {
        String salida = "";
        
        if (this.Vacia()) {
            return "<Lista vacia>";
        }

        Nodo movil = this.primero.getSiguiente();
        while (movil != null) {
            salida = salida + movil.getInfo() + " ";
            movil = movil.getSiguiente();
        }

        return "<"+salida+">";
    }

    public Nodo Buscar(int valor) {
        Nodo movil = primero.getSiguiente();
        while (movil != null) {
            if (movil.getInfo() == valor) {
                return movil;
            }
            movil = movil.getSiguiente();
        }
        return null;
    }

    public void Eliminar(int valor) {
        Nodo movil = this.Buscar(valor);

        // Lo encontro!
        if (movil != null) {
            Nodo anterior = movil.getAnterior();
            Nodo siguiente = movil.getSiguiente();

            anterior.setSiguiente(siguiente);
            if (siguiente != null) {
                siguiente.setAnterior(anterior);
            } else {
                this.primero.setAnterior(anterior);
            }
            
            
        }
    }

    public void EliminarUltimo() {
        if (this.Vacia()) {
            return;
        }

        Nodo borrar = this.primero.getAnterior();
        Nodo anterior = borrar.getAnterior();

        anterior.setSiguiente(null);
        this.primero.setAnterior(anterior);
        
        
    }
}
