package arbol;


public class ArbolB implements TDAArbol {

    private NodoAB raiz;

    public ArbolB() {
        this.InicializaArbol();
    }

    public void InicializaArbol() {
        this.raiz = null;
    }

    public boolean esVacio() {
        return this.raiz == null;
    } 

    public int Raiz() {
        return this.raiz.getInfo();
    }

    public TDAArbol HijoIzquierdo() {
        return this.raiz.getIzquierdo();
    }

    public TDAArbol HijoDerecho() {
        return this.raiz.getDerecho();
    }

    public void Agregar(int valor) {
        if (this.esVacio()) {
            this.raiz = new NodoAB(valor);
            
        } else {
            if (valor < this.Raiz() ) {
                this.raiz.getIzquierdo().Agregar(valor);
            } else {
                this.raiz.getDerecho().Agregar(valor);
            }
        }
    }

    private int menor(TDAArbol a) {
        if (a.HijoIzquierdo().esVacio()) {
            return a.Raiz();
        } else {
            return menor(a.HijoIzquierdo());
        }
    }

    private int mayor(TDAArbol a) {
        if (a.HijoDerecho().esVacio()) {
            return a.Raiz();
        } else {
            return mayor(a.HijoDerecho());
        }
    }

    private boolean esHoja() {
        return this.HijoDerecho().esVacio() && this.HijoIzquierdo().esVacio();
    }

    public void Eliminar(int valor) {
        if (this.esVacio())
        {
            return;
        }

        if ((this.Raiz() == valor) && esHoja()) {
            this.InicializaArbol();
        } else {
            if ((this.Raiz() == valor) && this.HijoDerecho().esVacio()) {
                this.raiz.setInfo(this.mayor(this.HijoIzquierdo()));
                this.HijoIzquierdo().Eliminar(this.raiz.getInfo());
            }
            if (this.Raiz() == valor) {
                this.raiz.setInfo(this.menor(this.HijoDerecho()));
                this.HijoDerecho().Eliminar(this.raiz.getInfo());
            }
            if (this.Raiz() > valor) {
                this.HijoIzquierdo().Eliminar(valor);
            } else {
                this.HijoDerecho().Eliminar(valor);
            }
        }
    }

    public String generarSalida(TDAArbol arbol, int nivel) {
        if (arbol.esVacio()) {
            return "";
        } else {
            String salida = "";

            for (int i = 0; i < nivel; i++) {
                salida = salida + "  ";
            }
    
            salida += arbol.Raiz() + "\n";
            salida += generarSalida(arbol.HijoIzquierdo(), nivel+1);
            salida += generarSalida(arbol.HijoDerecho(), nivel+1);
    
            return salida;
    
        }

    }

    public String toString() {
        String salida = "";

        salida = this.generarSalida(this, 0);

        return salida;
    }
}
