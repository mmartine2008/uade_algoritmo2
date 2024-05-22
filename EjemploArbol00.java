import arbol.*;

class EjemploArbol00 {


    public static void main(String[] args) {

        ArbolB a = new ArbolB();
        a.Agregar(6);
        a.Agregar(2);
        a.Agregar(8);
        a.Agregar(1);
        a.Agregar(4);                        
        a.Agregar(3);
        a.Agregar(5);
        a.Agregar(0);
        a.Agregar(7);
        a.Agregar(10);        
        System.out.println(a);
        System.out.println("------------------------");

        a.Eliminar(5);
        System.out.println(a);
        System.out.println("------------------------");

        a.Eliminar(6);
        System.out.println(a);
    }

}