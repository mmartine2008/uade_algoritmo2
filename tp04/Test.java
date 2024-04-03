class Test {

    public static void testLista00() {
        Lista l = new Lista();

        l.add(5);
        System.out.println(l);

        l.add(3);
        System.out.println(l);

        l.add(8);
        System.out.println(l);


    }

    public static void testLista() {
        Lista l = new Lista();

        l.add(5);
        l.add(3);
        l.add(8);

        System.out.println(l);

        l.eliminar(3);
        System.out.println(l);

        l.eliminar(8);
        System.out.println(l);        

        l.eliminar(5);
        System.out.println(l);        

    }

    public static void testListaDoble() {
        ListaDoble l = new ListaDoble();

        l.add(5);
        l.add(3);
        l.add(8);

        System.out.println(l);

        l.eliminar(3);
        System.out.println(l);

        l.eliminar(8);
        System.out.println(l);        

        l.eliminar(5);
        System.out.println(l);        

    }

    public static void main(String[] args) {

        testLista();

    }

}