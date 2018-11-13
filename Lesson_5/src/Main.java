public class Main {
    // Создаем одномерный длинный массив
    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;

    // Проходим по всему массиву и для каждой ячейки считаем новое значение по формуле:
    public float[] calc(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }


    public void firstMethod() {
        float[] arr = new float[SIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long a = System.currentTimeMillis();
        // Вызываем метод calc() и замеряем за сколько выполнился результат
        calc(arr);
        // Вывод результата измерения времени
        System.out.println("Первый метод выполнился за " + (System.currentTimeMillis() - a) + " миллисекунд(ы)");
    }

    public void secondMethod() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF_SIZE];
        float[] arr2 = new float[HALF_SIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long a = System.currentTimeMillis();

        // Заносим в половинные массивы первую и вторую половины нашего массива
        System.arraycopy(arr, 0, arr1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, arr2, 0, HALF_SIZE);

        // Создаем новый поток и выполяем там работу над первым полу-массивом
        new Thread() {
            public void run() {
                float[] a1 = calc(arr1);
                System.arraycopy(a1, 0, arr1, 0, a1.length);
            }
        }.start();

        // Создаем еще один поток и выполяем там работу над вторым полу-массивом
        new Thread() {
            public void run() {
                float[] a2 = calc(arr2);
                System.arraycopy(a2, 0, arr2, 0, a2.length);
            }
        }.start();

        // Склеиваем массив и выводим результат выполнения работы по второму методу
        System.arraycopy(arr1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(arr2, 0, arr, HALF_SIZE, HALF_SIZE);
        System.out.println("Второй метод выполнился за " + (System.currentTimeMillis() - a) + " миллисекунд(ы)");
    }

    public static void main(String s[]) {
        Main p = new Main();
        p.firstMethod();
        p.secondMethod();
    }
}