//clase vehiculo
public class vehiculo {

    private double precioCompra;
    private String marca;

    public vehiculo(double precioCompra, String marca) {
        this.precioCompra = precioCompra;
        this.marca = marca;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public String getMarca() {
        return marca;
    }

    public double precioVenta() {
        return precioCompra * 1.6; // 60% más
    }
} 

//subclase coche7
public class coche7 extends vehiculo{

    private int numPuertas;

    public coche7(double precioCompra, String marca, int numPuertas) {
        super(precioCompra, marca);
        this.numPuertas = numPuertas;
    }

    @Override
    public double precioVenta() {
        return super.precioVenta(); // Llama al método de la clase base
    }
}
//subclase furgoneta
public class furgoneta extends vehiculo {

    private double capacidadCarga; // en metros cúbicos

    public furgoneta(double precioCompra, String marca, double capacidadCarga) {
        super(precioCompra, marca);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double precioVenta() {
        double precioBase = super.precioVenta(); // Llama al método de la clase base
        if (capacidadCarga > 10) {
            precioBase *= 1.2; // 20% más si la capacidad de carga es mayor de 10 m³
        }
        return precioBase;
    }
}

//subclase camion
public class camion extends vehiculo {
    
    private double tamanoRemolque; // en metros
    private int numEjes;

    public camion(double precioCompra, String marca, double tamanoRemolque, int numEjes) {
        super(precioCompra, marca);
        this.tamanoRemolque = tamanoRemolque;
        this.numEjes = numEjes;
    }

    @Override
    public double precioVenta() {
        return super.precioVenta() * numEjes; // 60% más y multiplicado por el número de ejes
    }
}

//prueba
public class pruebaVehiculo {

    public static void main(String[] args) {
        // Crear un array de 3 camiones
        camion[] camiones = new camion[3];
        camiones[0] = new camion(20000, "MarcaA", 15, 2);
        camiones[1] = new camion(25000, "MarcaB", 10, 3);
        camiones[2] = new camion(30000, "MarcaC", 20, 4);

        // Mostrar el precio de venta de todos los camiones
        for (camion camion : camiones) {
            System.out.println("Precio de venta del camión: " + camion.precioVenta());
        }

        // Crear un array de 2 furgonetas
        furgoneta[] furgonetas = new furgoneta[2];
        furgonetas[0] = new furgoneta(15000, "MarcaD", 12);
        furgonetas[1] = new furgoneta(18000, "MarcaE", 8);

        // Mostrar el precio de venta de todas las furgonetas
        for (furgoneta furgoneta : furgonetas) {
            System.out.println("Precio de venta de la furgoneta: " + furgoneta.precioVenta());
        }
    } 
    
}
