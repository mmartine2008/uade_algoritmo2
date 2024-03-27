public class PilaTF implements PilaTDA {    
    int[] datos;     
    int indice;  

    public PilaTF() {
        this.InicializarPila();
    }

 	public void InicializarPila() {
        // Declara un array de 100 elementos
        this.datos = new int[100]; 
        // indice también es contador
        this.indice=0;
 	} 

    public void Apilar(int x){  
        this.datos[indice] = x;  
        this.indice++; 
    } 

    public void Desapilar(){  
        this.indice--; 
    } 
    
    public boolean PilaVacia(){  
        return (this.indice == 0); 
    } 

    public int  Tope(){  
        int tope = this.datos[this.indice-1]; 
        return tope; 
    }

    public String toString() {
        String out = "";
        for (int i = 0; i < this.indice; i++) {
            out = out + " " + this.datos[i];
        }
        out = "PilaTF: ["+ out+"|"+"\n";
        out = out + "Tamaño: "+ this.indice+"\n";
        out = out + "Tope: "+ this.datos[this.indice-1]+"\n";

        return out;
    } 
} 