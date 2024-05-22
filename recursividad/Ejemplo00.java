package recursividad;

class Ejemplo00 {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n -1);
        }
    }

    public static int factorialN(int n) {

        int total = 1;

        for (int i = 1; i <= n; i++) {
            total = total * i;
        }

        return total;
    }


    public static int factorial2(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial2(n -2);
        }
    }    

    public static int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * potencia(base, exponente-1);
        }
    }

    public static int fibonacci(int x) {
        if (x <= 1) {
            return x;
        } else {
            return fibonacci(x-1) + fibonacci(x-2);
        }
    }
    

    public static void main(String[] args) {

        System.out.println(fibonacci(3));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(7));
    }

}