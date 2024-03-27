class Test {
    public static void pruebaPTF() {
        PilaTF p1 = new PilaTF();

        p1.Apilar(5);
        p1.Apilar(3);
        p1.Apilar(8);

        System.out.println(p1);

    }

    public static void pruebaPTU() {
        PilaTU p2 = new PilaTU();

        p2.Apilar(5);
        p2.Apilar(3);
        p2.Apilar(8);

        System.out.println(p2);        

        p2.Desapilar();

        System.out.println(p2);        

    }

    public static void pruebaCPF() {
        ColaPF c1 = new ColaPF();

        c1.Acolar(5);
        c1.Acolar(4);
        c1.Acolar(1);
        c1.Acolar(3);
        c1.Acolar(8);
    
        System.out.println(c1);        

        c1.Desacolar();

        System.out.println(c1);         
    }

    public static void pruebaConjunto() {
        Conjunto c1 = new Conjunto();

        c1.Agregar(5);
        c1.Agregar(4);
        c1.Agregar(1);
        c1.Agregar(3);
        c1.Agregar(8);
        System.out.println(c1);        

        System.out.println(">c1.Sacar(1)");         
        c1.Sacar(1);
        System.out.println(c1);         

        System.out.println(">c1.Agregar(9)");         
        c1.Agregar(9);
        System.out.println(c1);         

    }    

    public static void main(String[] args) {

        pruebaConjunto();

    }

}