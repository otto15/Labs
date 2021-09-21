import java.lang.Math;

public class Main {

    // печатает полученный в результате массив в формате с пятью знаками после запятой
    public static void answer_output(double[][] ar, int len_a, int len_x) {
        for (int i = 0; i < len_a; i++) {
            for (int j = 0; j < len_x; j++) {
                System.out.printf("%.5f   ", ar[i][j]);
            }
            System.out.println();
        }
    }

    // генерирует случайное число в диапазоне от -4.0 до 7.0
    public static double random_double() {
        return (Math.random() * (7.0 - (-4.0))) + (-4.0);
    }

    // вычисляет элемент двумерного массива по формуле из 1 условия
    public static double fst_condition(double num) {
        return Math.pow((Math.pow(Math.log(Math.abs(num)), num - 1)), Math.cos(Math.sin(num)) / 2.0);
    }

    // вычисляет элемент двумерного массива по формуле из 2 условия
    public static double snd_condition(double num) {
        return Math.pow((0.5) / (1 - Math.cos(Math.cbrt(num))), Math.pow(Math.pow(Math.E, num) + 1, 3));
    }

    // вычисляет элемент двумерного массива по формуле из 3 условия
    public static double trd_condition(double num) {
        return Math.cos(Math.tan(Math.cbrt(Math.sin(num))));
    }

    public static void main(String[] args) {
        long[] a = new long[7];
        double[] x = new double[12];
        double[][] b = new double[7][12];
        for (int num = 17, i = 0; num >= 5 && i < 7; num -= 2, i++) {
            a[i] = num;
        }
        for (int i = 0; i < 12; i++) {
            x[i] = random_double();
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (a[i] == 11) {
                    b[i][j] = fst_condition(x[j]);
                } else if (a[i] == 9 || a[i] == 13 || a[i] == 17) {
                    b[i][j] = snd_condition(x[j]);
                } else {
                    b[i][j] = trd_condition(x[j]);
                }
            }
        }
        answer_output(b, a.length, x.length);
    }
}
