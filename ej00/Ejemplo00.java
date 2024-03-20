import java.util.Random;

class Ejemplo00 {


    public static void main(String[] args) {
        Random random = new Random();

        int[] numeros = new int[4];

        int total = 0;
        for (int i = 0; i < 4; i++) {
            numeros[i] = random.nextInt(100);
            System.out.println(numeros[i]);
            total = total +numeros[i];
        }
        System.out.println("------");
        int promedio = total/4;
        System.out.println(promedio);
        float promedio2 = ((float) total)/4;
        System.out.println(promedio2);
    }
}
