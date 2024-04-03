public class PilaLDV {
   private ListaDoble lista;

   public PilaLDV() {
      this.InicializarPila();
   }

   public void InicializarPila() {
      this.lista = new ListaDoble();
   }

   void Apilar(int x) {
      this.lista.add(x);
   }

   boolean PilaVacia() {
      return this.lista.vacia();      
   }

   int Tope() {
      return this.lista.getUltimo();      
   }

   void Desapilar() {
      this.lista.sacarUltimo();
   }

   public String toString() {
      String out = "[";

      out = out + this.lista.toString() + "|";

      return out;
   }    
   
}
