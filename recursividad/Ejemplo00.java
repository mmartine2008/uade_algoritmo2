package recursividad;

class Ejemplo00 {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n -1);
        }
    }

    public static int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * potencia(base, exponente-1);
        }
    }

    public static void main(String[] args) {

        System.out.println(factorial(3));
        System.out.println(potencia(2, 3));

    }

}