import java.util.Random;

public class Conjunto implements ConjuntoTDA {
    int[] datos;     
    int indice;      
    Random randomNum;

    public Conjunto() {
        this.InicializarConjunto();
        this.randomNum = new Random();
    }

    public void InicializarConjunto() {
        // Declara un array de 100 elementos
        this.datos = new int[100]; 
        // indice también es contador
        this.indice=0;
    }

    public boolean ConjuntoVacio() {
        return (this.indice == 0); 
    }

    public void Agregar(int x) {
        if (!this.Pertenece(x)) {
            this.datos[this.indice] = x;
            this.indice++;
        }                
    }

    // siempre que el conjunto esté inicializado y no esté vacío
    public int Elegir() {
        
        int pos = this.randomNum.nextInt(this.indice);
        return this.datos[pos];
    };
    // siempre que el conjunto esté inicializado 
    public void Sacar(int x) {
        if (this.Pertenece(x)) {
            int pos = 0;
            while (this.datos[pos] != x) {
                pos++;
            }
            if (this.indice > 1) {
                this.datos[pos] = this.datos[this.indice -1];
            }
            this.indice--;
        }
    }

    public boolean Pertenece(int x) {
        for (int i = 0; i< this.indice; i++) {
            if (this.datos[i] == x) {
                return true;
            }
        }
        return false;
    }

    // public String toString() {
    //     String out = "";
    //     for (int i = 0; i < this.indice; i++) {
    //         out = out + " " + this.datos[i];
    //     }
    //     out = "Conjunto: ("+ out+" )"+"\n";
    //     out = out + "Tamaño: "+ this.indice+"\n";
    //     out = out + "Elegir: "+ this.Elegir()+"\n";

    //     return out;
    // }  
    public String toString() {
        String out = "";
        for (int i = 0; i < this.indice; i++) {
            out = out + " " + this.datos[i];
        }
        return "{" + out + "}";
    }    
}
