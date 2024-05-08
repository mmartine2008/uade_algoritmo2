public class Lista {
    Nodo primero;

    public Lista() {
        this.primero = new Nodo();
    }

    public boolean Vacia() {
        return this.primero.getSiguiente() == null;
    }

    public void Agregar(int valor) {
        Nodo nuevo = new Nodo(valor);

        Nodo movil = this.primero;
        while (movil.getSiguiente() != null) {
            movil = movil.getSiguiente();
        }
        movil.setSiguiente(nuevo);
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

    public void Eliminar(int valor) {
        Nodo anterior = this.primero;
        Nodo movil = anterior.getSiguiente();

        while ((movil != null) && (movil.getInfo() != valor)) {
            anterior = movil;
            movil = movil.getSiguiente();
        }

        // Lo encontro!
        if (movil != null) {
            anterior.setSiguiente(movil.getSiguiente());
        }
    }

    public void EliminarUltimo() {
        Nodo anterior = this.primero;
        Nodo movil = anterior.getSiguiente();

        while (movil.getSiguiente() != null) {
            anterior = movil;
            movil = movil.getSiguiente();
        }

        anterior.setSiguiente(null);

    }
}
