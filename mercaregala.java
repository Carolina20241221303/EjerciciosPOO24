//interface
public interface IProducto {

    double calcularPrecio();
    String getNombre();
    
}

//clase productoBase
public abstract class productoBse implements IProducto{

String nombre;
    double peso;
    double precioKilo;

    public productoBse(String nombre, double peso, double precioKilo) {
        this.nombre = nombre;
        this.peso = peso;
        this.precioKilo = precioKilo;
    }

    @Override
    public double calcularPrecio() {
        return peso * precioKilo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    
}

//subclase carne
public abstract class carnes extends productoBse {
    
    String origen;

    public carnes(String nombre, double peso, double precioKilo, String origen) {
        super(nombre, peso, precioKilo);
        this.origen = origen;
    }

    
}

//subclase carneFresca
public class carnesFrescas extends carnes{

    int diasCaducidad;



    public carnesFrescas(String nombre, double peso, double precioKilo, String origen, int diasCaducidad) {
        super(nombre, peso, precioKilo, origen);
        this.diasCaducidad = diasCaducidad;
    }



    public int getDiasCaducidad() {
        return diasCaducidad;
    }
    
}

// subclase carnesCongeladas
public abstract class carneCongelada extends carnes{
 
    String empresaDistribuidora;

    carneCongelada(String nombre, double peso, double precioKilo, String origen, String empresaDistribuidora) {
        super(nombre, peso, precioKilo, origen);
        this.empresaDistribuidora = empresaDistribuidora;
    }
}

//subclase carneCongeEntera
public class carneCongeEntera extends carneCongelada{

    boolean enBandeja;

    carneCongeEntera(String nombre, double peso, double precioKilo, String origen, String empresaDistribuidora, boolean enBandeja) {
        super(nombre, peso, precioKilo, origen, empresaDistribuidora);
        this.enBandeja = enBandeja;
    }

    public boolean isEnBandeja() {
        return enBandeja;
    }
    
}

//subclase carneCongeTroceada
public class carneCongeTroceadas extends carneCongelada {

    int piezasMedias;

    carneCongeTroceadas(String nombre, double peso, double precioKilo, String origen, String empresaDistribuidora, int piezasMedias) {
        super(nombre, peso, precioKilo, origen, empresaDistribuidora);
        this.piezasMedias = piezasMedias;
    }
    
}

// subclase pescado
public class pescados extends productoBse {

    String tipoPescado;

    pescados(String nombre, double peso, double precioKilo, String tipoPescado) {
        super(nombre, peso, precioKilo);
        this.tipoPescado = tipoPescado;
    }
    
}

// clase mercaregala
import java.util.Scanner;

public class mercaregala {

     private static IProducto[] productos = new IProducto[100]; // Capacidad máxima del almacén
    private static int contadorProductos = 0; // Contador de productos
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Productos en peligro");
            System.out.println("4. Calculo precio medio");
            System.out.println("5. Eliminar bandejas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    añadirProducto();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    productosEnPeligro();
                    break;
                case 4:
                    calcularPrecioMedio();
                    break;
                case 5:
                    eliminarBandejas();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void añadirProducto() {
        System.out.print ("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el peso del producto (kg): ");
        double peso = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el precio por kilo del producto: ");
        double precioKilo = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("¿Qué tipo de producto es?");
        System.out.println("1. Carne");
        System.out.println("2. Pescado");
        int tipoProducto = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        if (tipoProducto == 1) {
            System.out.println("¿Qué tipo de carne es?");
            System.out.println("1. Fresca");
            System.out.println("2. Congelada");
            int tipoCarne = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            if (tipoCarne == 1) {
                System.out.print("Ingrese los días de caducidad: ");
                int diasCaducidad = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                productos[contadorProductos] = new carnesFrescas(nombre, peso, precioKilo, "vacuno", diasCaducidad);
            } else {
                System.out.println("¿Qué tipo de carne congelada es?");
                System.out.println("1. Entera");
                System.out.println("2. Troceada");
                int tipoCarneCongelada = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                if (tipoCarneCongelada == 1) {
                    System.out.print("Ingrese si la carne viene en bandeja (true/false): ");
                    boolean enBandeja = scanner.nextBoolean();
                    scanner.nextLine(); // Consumir el salto de línea
                    productos[contadorProductos] = new carneCongeEntera(nombre, peso, precioKilo, "vacuno", "empresa", enBandeja);
                } else {
                    System.out.print("Ingrese el número medio de piezas: ");
                    int piezasMedias = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    productos[contadorProductos] = new carneCongeTroceada(nombre, peso, precioKilo, "vacuno", "empresa", piezasMedias);
                }
            }
        } else {
            System.out.print("Ingrese el tipo de pescado: ");
            String tipoPescado = scanner.nextLine();
            productos[contadorProductos] = new pescados(nombre, peso, precioKilo, tipoPescado);
        }

        contadorProductos++;
        System.out.println("Producto agregado con éxito.");
    }

    private static void listarProductos() {
        for (int i = 0; i < contadorProductos; i++) {
            System.out.println("Nombre: " + productos[i].getNombre() + ", Precio: " + productos[i].calcularPrecio());
        }
    }

    private static void productosEnPeligro() {
        for (int i = 0; i < contadorProductos; i++) {
            if (productos[i] instanceof carnesFrescas) {
                carnesFrescas carneFresca = (carnesFrecas) IProducto[i];
                if (carneFresca.getDiasCaducidad() < 10) {
                    System.out.println("Nombre: " + carneFresca.getNombre() + ", Días de caducidad: " + carneFresca.getDiasCaducidad());
                }
            }
        }
    }

    private static void calcularPrecioMedio() {
        double sumaPrecios = 0;
        for (int i = 0; i < contadorProductos; i++) {
            sumaPrecios += productos[i].calcularPrecio();
        }
        double precioMedio = sumaPrecios / contadorProductos;
        System.out.println("Precio medio: " + precioMedio);
    }

    private static void eliminarBandejas() {
        for (int i = 0; i < contadorProductos; i++) {
            if (IProducto[i] instanceof carneCongeEntera) {
                carneCongeEntera carneCongeladaEntera = (carneCongeEntera) IProducto[i];
                if (carneCongeladaEntera.isEnBandeja()) {
                    productos[i] = null;
                    System.out.println("Bandeja eliminada.");
                }
            }
        }
    }
    
}


