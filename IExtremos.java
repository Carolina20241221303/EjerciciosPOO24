//IExtremos
public interface IExtremos {
    
    int min(int[] a);
    int max(int[] a);
    double min(double[] a);
    double max(double[] a);
}
//clase math2
public class math2 implements IExtremos{
    @Override
    public int min(int[] a) {
        if (a == null || a.length == 0) {
            System.out.println("El array no puede estar vacío");
        }
        int minValue = a[0];
        for (int num : a) {
            if (num < minValue) {
                minValue = num;
            }
        }
        return minValue;
    }

    @Override
    public int max(int[] a) {
        if (a == null || a.length == 0) {
            System.out.println("El array no puede estar vacío");
        }
        int maxValue = a[0];
        for (int num : a) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        return maxValue;
    }

    @Override
    public double min(double[] a) {
        if (a == null || a.length == 0) {
            System.out.println("El array no puede estar vacío");
        }
        double minValue = a[0];
        for (double num : a) {
            if (num < minValue) {
                minValue = num;
            }
        }
        return minValue;
    }

    @Override
    public double max(double[] a) {
        if (a == null || a.length == 0) {
            System.out.println("El array no puede estar vacío");
        }
        double maxValue = a[0];
        for (double num : a) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        return maxValue;
    }
}

//prueba
public class pruebaIExtremos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        math2 math2 = new math2();

        // Probar métodos con un array de enteros
        System.out.println("Ingrese el tamaño del array de enteros:");
        int sizeInt = scanner.nextInt();
        int[] intArray = new int[sizeInt];

        System.out.println("Ingrese los elementos del array de enteros:");
        for (int i = 0; i < sizeInt; i++) {
            intArray[i] = scanner.nextInt();
        }

        System.out.println("Mínimo en enteros: " + math2.min(intArray));
        System.out.println("Máximo en enteros: " + math2.max(intArray));

        // Probar métodos con un array de dobles
        System.out.println("Ingrese el tamaño del array de double:");
        int sizeDouble = scanner.nextInt();
        double[] doubleArray = new double[sizeDouble];

        System.out.println("Ingrese los elementos del array de double:");
        for (int i = 0; i < sizeDouble; i++) {
            doubleArray[i] = scanner.nextDouble();
        }

        System.out.println("Mínimo en dobles: " + math2.min(doubleArray));
        System.out.println("Máximo en dobles: " + math2.max(doubleArray));

        scanner.close();
    }
}
