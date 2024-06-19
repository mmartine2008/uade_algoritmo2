public class Lista<T> {
    private Object [] datos;
    private int count;

    public Lista() {
        this.datos = new Object[100];
        this.count = 0;
    }

    public boolean Vacia() {
        return this.count == 0;
    }

    public void Agregar(T dato) {
        this.datos[this.count] = dato;
        this.count++;
    }

    public boolean Existe(T valor) {
        if (this.Vacia()) {
            return false;
        }

        for(int i = 0; i < this.count; i++) {
            if (this.datos[i] == valor) {
                return true;
            }
           
        }

        return false;
    }

    public String toString() {
        String salida = "";
        
        if (this.Vacia()) {
            return "<Lista vacia>";
        }

        for(int i = 0; i < this.count; i++) {
            salida = salida + this.datos[i].toString() + " ";           
        }

        return "<"+salida+">";
    }
}
