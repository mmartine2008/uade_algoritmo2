public class PilaTU implements PilaTDA {    
    int[] datos;     
    int indice;  

    public PilaTU() {
        this.InicializarPila();
    }

 	public void InicializarPila() {
        // Declara un array de 100 elementos
        this.datos = new int[100]; 
        // indice también es contador
        this.indice=0;
 	} 

    public void Apilar(int x){  
        for (int i = indice-1; i >= 0; i--) {
            this.datos[i+1] = this.datos[i];  
        }
        this.datos[0] = x;
        this.indice++; 
    } 

    public void Desapilar(){  
        for (int i = 0; i <indice-1; i++) {
            this.datos[i] = this.datos[i+1];  
        }
        this.indice--; 
        
    } 
    
    public boolean PilaVacia(){  
        return (this.indice == 0); 
    } 

    public int  Tope(){  
        int tope = this.datos[0]; 
        return tope; 
    }

    public String toString() {
        String out = "";
        for (int i = this.indice-1; i >= 0; i--) {
            out = out + " " + this.datos[i];
        }
        out = "PilaTU: ["+ out+"|"+"\n";
        out = out + "Tamaño: "+ this.indice+"\n";
        out = out + "Tope: "+ this.Tope()+"\n";

        return out;
    } 
} 