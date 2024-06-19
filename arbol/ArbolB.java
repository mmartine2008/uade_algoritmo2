package arbol;
public class ArbolB implements TDAArbol {
    NodoAB raiz ;

    public NodoAB getNodo() {
        return this.raiz;
    }

    public NodoAB setNodo(NodoAB raiz) {
        return this.raiz = raiz;
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

    private int getFE(ArbolB a) {
        int FE = a.getNodo().getDiferenciaAltura();
        return FE;
	}

	private void balancear(ArbolB a) {	
		if (getFE(a) >= 2) {
			System.out.print("Rotacion ");
			if (getFE((ArbolB) a.HijoDerecho()) >= 0) {
				System.out.println("Simple a izquierda ");
				rotarIzq(a);
			}
			else
			{
				System.out.println("Doble derecha-izquierda");
				rotarDer((ArbolB) a.HijoDerecho());
				rotarIzq(a);
			}
		}
		else
			if (getFE(a) <= -2) {	
				System.out.print("Rotacion ");
				if (getFE((ArbolB) a.HijoIzquierdo()) <= 0) {			
					System.out.println("Simple a derecha ");
					rotarDer(a);
				}
				else
				{
					System.out.println("Doble izquierda-derecha");
					rotarIzq((ArbolB) a.HijoIzquierdo());
					rotarDer(a);
				}
			}
				
	}

    public void Agregar(int x) {
        if (this.EsVacio()) {
            this.raiz = new NodoAB(x);
        } else {
            if (x < this.Raiz()) {
                this.raiz.getIzquierdo().Agregar(x);
                setDiferenciaAltura(this);
                balancear(this);
            } else {
                this.raiz.getDerecho().Agregar(x);
                setDiferenciaAltura(this);
                balancear(this);
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
        this.setDiferenciaAltura(this);
        this.balancear(this);
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
            
            if (!arbol.HijoIzquierdo().EsVacio()) {
                setDiferenciaAltura((ArbolB) arbol.HijoIzquierdo());
            }
            if (!arbol.HijoDerecho().EsVacio()) {
                setDiferenciaAltura((ArbolB) arbol.HijoDerecho());
            }

        }
    }   

    private void rotarIzq(ArbolB a) {
        NodoAB nuevoPadre = ((ArbolB) a.HijoDerecho()).getNodo(); 
//El hijo derecho pasa a ser raiz (nuevo padre)
        ArbolB hijoDerecho = (ArbolB)a.HijoDerecho();
        hijoDerecho.setNodo(nuevoPadre.getIzquierdo().getNodo()); 
// El hijo izquierdo de la nueva ra�z pasa a ser el hijo derecho del padre antiguo
        nuevoPadre.getIzquierdo().setNodo(a.getNodo()); 
//El padre antiguo se convierte hijo izquierdo de la nueva ra�z
        a.setNodo(nuevoPadre); 
//Se reemplaza la raiz (el nodo padre) por el nuevo nodo padre
    }
    
    private void rotarDer(ArbolB a) {
        NodoAB nuevoPadre = ((ArbolB) a.HijoIzquierdo()).getNodo(); 
//El hijo izquierdo pasa a ser el padre
        ((ArbolB) a.HijoIzquierdo()).setNodo(nuevoPadre.getDerecho().getNodo());
// El hijo derecho del nuevo padre pasa a ser el izquierdo del padre antiguo
        nuevoPadre.getDerecho().setNodo(a.getNodo()); 
//El padre se convierte en hijo derecho de la nueva raiz
        a.setNodo(nuevoPadre); 
//Se reemplaza la ra�z (el nodo padre) por el nuevo nodo padre
    }    
    
}
