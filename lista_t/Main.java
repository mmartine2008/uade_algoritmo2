import java.util.ArrayList;

public class Main {
    public static void test01 () {
        Lista<Integer> l = new Lista<Integer>();

        l.Agregar(5);
        l.Agregar(10);

        System.out.println(l.toString());

        Lista<String> s = new Lista<String>();

        s.Agregar("Hola");
        s.Agregar("Java !");

        System.out.println(s.toString());

    }

    public static void main(String[] args) {
        
        ArrayList<String> listaDeStrings = new ArrayList<>();
      
        // Agregar elementos a la lista
        listaDeStrings.add("Hola");
        listaDeStrings.add("Mundo");
        listaDeStrings.add("!");

        // Obtener el tamaño de la lista
        int tamaño = listaDeStrings.size();
        System.out.println("Tamaño de la lista: " + tamaño);

    }
}