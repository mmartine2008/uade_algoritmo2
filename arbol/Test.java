package arbol;
import java.util.*;

public class Test {

    public static void test01 () {
        ArbolB arbol = new ArbolB();

        arbol.Agregar(6);
        arbol.Agregar(2);
        arbol.Agregar(8);
        arbol.Agregar(1);
        arbol.Agregar(5);
        arbol.Agregar(9);

        System.out.println(arbol);
        System.out.println("----------------------------");

        System.out.print("PreOrder: "); arbol.preOrder(arbol);
        System.out.println("----------------------------");
        System.out.print("InOrder: "); arbol.inOrder(arbol);
        System.out.println("----------------------------");
        System.out.print("PostOrder: "); arbol.postOrder(arbol);
        System.out.println("----------------------------");

    }

    public static boolean existe(int numero, int [] numeros, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            if (numeros[i] == numero) {
                return true;
            }
        }
        return false;
    }

    public static int[] numerosAleatoriosSinRepetir(int cantidad, int hasta) {
        // numeros = numerosAleatoriosSinRepetir(20, 15);
        // [1 , 3, 8, ... 0, 12, ... ] no repetidos
        int[] numeros = new int[cantidad];
        Random ran = new Random();
        // [ ]
        int ubicados = 0;
        do {
            int aleatorio;
            do {
                aleatorio = ran.nextInt(hasta);
            } while (existe(aleatorio, numeros, ubicados));
            numeros[ubicados] = aleatorio;
            ubicados++;

        } while (ubicados < cantidad);

        return numeros;
    }

    public static void mostrarArreglo(int [] numeros, int cantidad) {

        for (int i = 0; i < cantidad; i++) {
            System.out.print(numeros[i]+" ");
        }
        System.out.println("\n");
    }

    public static void test02() {
        int maximo = 5;
        int [] numeros = numerosAleatoriosSinRepetir(maximo, 25);
        mostrarArreglo(numeros, maximo);
        ArbolB arbol = new ArbolB();

        for (int i = 0; i < maximo; i++) {
            arbol.Agregar(numeros[i]);
        }

        arbol.setDiferenciaAltura(arbol);
        
        System.out.println(arbol);
    }

    public static void test03() {
        int maximo = 5;
        int [] numeros = numerosAleatoriosSinRepetir(maximo, 25);
        mostrarArreglo(numeros, maximo);
        
        ArbolB arbol = new ArbolB();

        for (int i = 0; i < maximo; i++) {
            arbol.Agregar(numeros[i]);
        }

//        arbol.setDiferenciaAltura(arbol);
        
        System.out.println(arbol);
        
    }

    public static void main(String[] args) {
        test03();
    }

}
