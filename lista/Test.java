public class Test {
    public static void main(String[] args) {
        Lista L = new Lista();

        if (L.Existe(17)) {
            System.out.println("Existe 17");
        } else {
            System.out.println("NO Existe 17");
        }

        L.Agregar(5);
        L.Agregar(7);
        L.Agregar(1);
        L.Agregar(9);

        System.out.println(L);

        L.Eliminar(7);
        System.out.println(L);

        while (!L.Vacia())
        {
            L.EliminarUltimo();
            System.out.println(L);
        }
        
        L.Agregar(2);
        System.out.println(L);
    }
}
