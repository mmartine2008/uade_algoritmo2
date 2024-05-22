package arbol;
public class ArbolB implements TDAArbol {
    NodoAB raiz ;

    NodoAB getNodo() {
        return this.raiz;
    }

    public ArbolB() {
        this.InicializaArbol();
    }

    //Indica si el arbol está vacio
    public boolean EsVacio() {
        return (this.raiz == null);
    }

    //Crea un arbol vacio
    public void InicializaArbol() {
        this.raiz = null;
    }

    //Devuelve el sub-Arbol izquierdo
    public TDAArbol HijoIzquierdo() {
        return this.raiz.getIzquierdo();
    }

    //Devuelve el sub-Arbol derecho
    public TDAArbol HijoDerecho() {
        return this.raiz.getDerecho();
    }

    //Devuelve la raiz de un árbol, si es que existe.
    public int Raiz() {
        return this.raiz.getInfo();
    }

    // agrega un elemento x
    public void Agregar(int x) {
        if (this.EsVacio()) {
            this.raiz = new NodoAB(x);
        } else {
            if (x < this.Raiz()) {
                this.raiz.getIzquierdo().Agregar(x);
            } else {
                this.raiz.getDerecho().Agregar(x);
            }
        }
    }

    private boolean esHoja() {
        if (this.HijoIzquierdo().EsVacio() && this.HijoDerecho().EsVacio()) {
            return true;
        } else {
            return false;
        }

    }

    private int mayor(TDAArbol arbol) {
        if (arbol.HijoDerecho().EsVacio()) {
            return arbol.Raiz();
        } else {
            return mayor(arbol.HijoDerecho());
        }
    }

    private int menor(TDAArbol arbol) {
        if (arbol.HijoIzquierdo().EsVacio()) {
            return arbol.Raiz();
        } else {
            return menor(arbol.HijoIzquierdo());
        }
    }

    // elimina un elemento x    
    public void Eliminar(int x) {
        if (this.EsVacio()) {
            return;
        }
        if ((this.Raiz() == x) && this.esHoja()) {
            this.InicializaArbol();
        } else {
            if ((this.Raiz() == x) && this.HijoDerecho().EsVacio()) {
                int valorMayor = this.mayor(this.HijoIzquierdo());
                this.raiz.setInfo(valorMayor);
                this.HijoIzquierdo().Eliminar(valorMayor);
            }
            if (this.Raiz() == x) {
                int valorMenor = this.menor(this.HijoDerecho());
                this.raiz.setInfo(valorMenor);
                this.HijoDerecho().Eliminar(valorMenor);
            }
            if (this.Raiz() > x) {
                this.HijoIzquierdo().Eliminar(x);
            } else {
                this.HijoDerecho().Eliminar(x);
            }

        }
    }

    // Devuelve espacios, para estetica
    private String espacios(int n) {
        String salida = "";
        for (int i = 0; i < n*2; i++) {
            salida = salida + " ";
        }
        return salida;
    }

    /**
     *  Arbol (6, (2, ((1,5), 8) ), (8,,(9,,)))        
     * 
     * 6
     *   2
     *      1
     *      5
     *   8
     *      9
     */
    private String show(TDAArbol arbol, int profundidad)
    {
        if (arbol.EsVacio())        
        {
            return "";
        }

        String salida = this.espacios(profundidad);

        salida += arbol.Raiz() + "\n";
        salida += show(arbol.HijoIzquierdo(), profundidad+1);
        salida += show(arbol.HijoDerecho(), profundidad+1);
        return salida;
    }  

    public String toString() {
        int profundidadArbol = profundidad(this);

        String salida = this.show(this, 0);
        salida += "\n" + "La profundidad del arbol es: "+profundidadArbol;
        salida += "\n" + "La suma de sus nodos es:" + this.suma(this);
        salida += "\n" + "La cantidad de nodos es:" + this.cantidad(this);
        double prom = ((double) this.suma(this)) / this.cantidad(this);
        salida += "\n" + "el promedio de los nodos es :" + prom;

        salida += "\n" + "Diferencia de altura es :" + this.getNodo().getDiferenciaAltura();

        return salida;
    }

    public int profundidad(TDAArbol arbol) {
        if (arbol.EsVacio() || (arbol.HijoIzquierdo().EsVacio() && arbol.HijoDerecho().EsVacio()))
        {
            return 0;
        } else {
            return 1 +Math.max(
                            profundidad(arbol.HijoIzquierdo()), 
                            profundidad(arbol.HijoDerecho())
                            );
        }
    }

    public int cantidad(TDAArbol arbol) {
        if (arbol.EsVacio())
        {
            return 0;
        } else {
            return 1 + cantidad(arbol.HijoIzquierdo()) + 
            cantidad(arbol.HijoDerecho())
                            ;
        }
    }    

    public int suma(TDAArbol arbol) {
        if (arbol.EsVacio()) {
            return 0;
        } else {

            return arbol.Raiz() + 
                            suma(arbol.HijoIzquierdo()) + 
                            suma(arbol.HijoDerecho());
        }
    }

    public void preOrder(TDAArbol arbol) {

        if (!arbol.EsVacio()) {
            System.out.print(arbol.Raiz() + " ");
            preOrder(arbol.HijoIzquierdo());
            preOrder(arbol.HijoDerecho());
        }
    }

    public void inOrder(TDAArbol arbol) {

        if (!arbol.EsVacio()) {
            inOrder(arbol.HijoIzquierdo());
            System.out.print(arbol.Raiz() + " ");
            inOrder(arbol.HijoDerecho());
        }
    }    


    public void postOrder(TDAArbol arbol) {

        if (!arbol.EsVacio()) {
            inOrder(arbol.HijoIzquierdo());
            inOrder(arbol.HijoDerecho());
            
            System.out.print(arbol.Raiz() + " ");
        }
    } 

    public void setDiferenciaAltura(ArbolB arbol) {

        if (!arbol.EsVacio()) {
            int altIzq = profundidad(arbol.HijoIzquierdo());
            int altDer = profundidad(arbol.HijoDerecho());
            int diferencia = altDer - altIzq;
            arbol.getNodo().setDiferenciaAltura(diferencia);            
        }
    }   
    
    
}
