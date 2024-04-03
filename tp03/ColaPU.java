public class ColaPU implements ColaTDA {    
    int[] datos;     
    int indice;  

    public ColaPU() {
        this.InicializarCola();
    }

 	public void InicializarCola() {
        // Declara un array de 100 elementos
        this.datos = new int[100]; 
        // indice también es contador
        this.indice=0;
 	} 

    public void Acolar(int x){  
        this.datos[this.indice] = x;
        this.indice++;         
    } 

    public void Desacolar(){  
        for (int i = 0; i < this.indice; i++) {
            this.datos[i] = this.datos[i+1];
        }
        this.indice--; 
    } 
    
    public boolean ColaVacía(){  
        return (this.indice == 0); 
    } 

    public int  Primero(){  
        int primero = this.datos[0]; 
        return primero; 
    }

    public String toString() {
        String out = "";
        for (int i = this.indice-1; i >= 0; i--) {
            out = out + " " + this.datos[i];
        }
        out = "ColaPU: >"+ out+" >"+"\n";
        out = out + "Tamaño: "+ this.indice+"\n";
        out = out + "Primero: "+ this.Primero()+"\n";

        return out;
    } 
} 