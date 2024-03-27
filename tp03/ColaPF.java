public class ColaPF implements ColaTDA {    
    int[] datos;     
    int indice;  

    public ColaPF() {
        this.InicializarCola();
    }

 	public void InicializarCola() {
        // Declara un array de 100 elementos
        this.datos = new int[100]; 
        // indice también es contador
        this.indice=0;
 	} 

    public void Acolar(int x){  
        for (int i = indice-1; i >= 0; i--) {
            this.datos[i+1] = this.datos[i];  
        }
        this.datos[0] = x;
        this.indice++;         
    } 

    public void Desacolar(){  
        this.indice--; 
    } 
    
    public boolean ColaVacía(){  
        return (this.indice == 0); 
    } 

    public int  Primero(){  
        int primero = this.datos[this.indice-1]; 
        return primero; 
    }

    public String toString() {
        String out = "";
        for (int i = 0; i < this.indice; i++) {
            out = out + " " + this.datos[i];
        }
        out = "ColaPF: >"+ out+" >"+"\n";
        out = out + "Tamaño: "+ this.indice+"\n";
        out = out + "Primero: "+ this.Primero()+"\n";

        return out;
    } 
} 