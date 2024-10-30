import java.util.Scanner;

// Interfaz iGarage
public interface iGarage {
    double calcularIngresos();
    int calcularOcupacionPorTipoVehiculo(Vehiculo v);
}

// Clase Vehiculo
public class Vehiculo {
    protected String matricula;
    protected String marca;
    protected double precio;
    protected int cilindrada;
    protected double impuestoCirculacion;
    protected double cuotaMesGarage;
    protected static final double CUOTA_BASE_GARAGE = 100;

    public Vehiculo(String marca, double precio, int cilindrada) {
        this.marca = marca;
        this.precio = precio;
        this.cilindrada = cilindrada;
        this.cuotaMesGarage = CUOTA_BASE_GARAGE;
        calcularImpuestoCirculacion();
    }

    public void calcularImpuestoCirculacion() {
        this.impuestoCirculacion = 0.02 * precio;
    }

    public boolean matricular(String matricula) {
        if (matricula.length() == 7) {
            this.matricula = matricula;
            return true;
        }
        return false;
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public double getCuotaMesGarage() {
        return cuotaMesGarage;
    }

    public void setCuotaMesGarage(double cuotaMesGarage) {
        if (cuotaMesGarage >= 0) {
            this.cuotaMesGarage = cuotaMesGarage;
        }
    }
}

// Clase Moto
public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, double precio, int cilindrada, boolean tieneSidecar) {
        super(marca, precio, cilindrada);
        this.tieneSidecar = tieneSidecar;
        calcularImpuestoCirculacion();
        if (tieneSidecar) {
            this.impuestoCirculacion *= 1.10; // Incremento del 10%
            this.cuotaMesGarage *= 1.50; // Aumento del 50%
        }
    }

    @Override
    public void calcularImpuestoCirculacion() {
        super.calcularImpuestoCirculacion();
    }
}

// Clase Coche
public class Coche extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;
    public Coche(String marca, double precio, int cilindrada, boolean tieneRadio, boolean tieneNavegador) {
        super(marca, precio, cilindrada);
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;
        calcularImpuestoCirculacion();
        if (tieneRadio) {
            this.impuestoCirculacion *= 1.01; // Incremento del 1%
        }
        if (tieneNavegador) {
            this.impuestoCirculacion *= 1.02; // Incremento del 2%
        }
        if (cilindrada > 2999) {
            this.cuotaMesGarage *= 1.20; // Aumento del 20%
        }
    }

    @Override
    public void calcularImpuestoCirculacion() {
        super.calcularImpuestoCirculacion();
    }
}

// Clase Garaje
public class Garaje implements iGarage {
    private static final int NUM_PLAZAS = 10;
    private Vehiculo[] plazas;
    private int ocupacion;

    public Garaje() {
        plazas = new Vehiculo[NUM_PLAZAS];
        ocupacion = 0;
    }

    @Override
    public double calcularIngresos() {
        double ingresos = 0;
        for (Vehiculo vehiculo : plazas) {
            if (vehiculo != null) {
                ingresos += vehiculo.getCuotaMesGarage();
            }
        }
        return ingresos;
    }

    @Override
    public int calcularOcupacionPorTipoVehiculo(Vehiculo v) {
        int contador = 0;
        for (Vehiculo vehiculo : plazas) {
            if (vehiculo != null && vehiculo.getClass() == v.getClass()) {
                contador++;
            }
        }
        return contador;
    }

    public boolean alquilarPlaza(Vehiculo vehiculo ) {
        if (ocupacion < NUM_PLAZAS && vehiculo.getMatricula() != null) {
            for (int i = 0; i < NUM_PLAZAS; i++) {
                if (plazas[i] == null) {
                    plazas[i] = vehiculo;
                    ocupacion++;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean bajaAlquiler(Vehiculo vehiculo) {
        for (int i = 0; i < NUM_PLAZAS; i++) {
            if (plazas[i] != null && plazas[i].equals(vehiculo)) {
                plazas[i] = null;
                ocupacion--;
                return true;
            }
        }
        return false;
    }
}

// prueba
public class pruebaGarage{
    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Alquilar una plaza");
            System.out.println("2. Baja de alquiler");
            System.out.println("3. Consulta de ingresos mensuales");
            System.out.println("4. Consulta proporción coches / motos");
            System.out.println("5. Listado de matriculas y couta mensual y tipo vehículo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la marca del vehículo: ");
                    String marca = scanner.next();
                    System.out.print("Ingrese el precio del vehículo: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese la cilindrada del vehículo: ");
                    int cilindrada = scanner.nextInt();
                    System.out.print("Es una moto? (true/false): ");
                    boolean esMoto = scanner.nextBoolean();
                    System.out.print("Tiene sidecar? (true/false): ");
                    boolean tieneSidecar = scanner.nextBoolean();
                    System.out.print("Tiene radio? (true/false): ");
                    boolean tieneRadio = scanner.nextBoolean();
                    System.out.print("Tiene navegador? (true/false): ");
                    boolean tieneNavegador = scanner.nextBoolean();

                    Vehiculo vehiculo;
                    if (esMoto) {
                        vehiculo = new Moto(marca, precio, cilindrada, tieneSidecar);
                    } else {
                        vehiculo = new Coche(marca, precio, cilindrada, tieneRadio, tieneNavegador);
                    }

                    if (garaje.alquilarPlaza(vehiculo)) {
                        System.out.println("Plaza alquilada con éxito.");
                    } else {
                        System.out.println("No se puede alquilar la plaza.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la matrícula del vehículo: ");
                    String matricula = scanner.next();
                    Vehiculo vehiculoBaja = null;
                    for (Vehiculo v : garaje.plazas) {
                        if (v != null && v.getMatricula().equals(matricula)) {
                            vehiculoBaja = v;
                            break;
                        }
                    }
                    if (vehiculoBaja != null && garaje.bajaAlquiler(vehiculoBaja)) {
                        System.out.println("Baja de alquiler realizada con éxito.");
                    } else {
                        System.out.println("No se puede realizar la baja de alquiler.");
                    }
                    break;
                case 3:
                    System.out.println("Ingresos mensuales: " + garaje.calcularIngresos());
                    break;
                case 4:
                    int numCoches = garaje.calcularOcupacionPorTipoVehiculo(new Coche("", 0, 0, false, false));
                    int numMotos = garaje.calcularOcupacionPorTipoVehiculo(new Moto("", 0, 0, false));
                    System.out.println("Proporción coches / motos: " + numCoches + " / " + numMotos);
                    break;
                case 5:
                    for (Vehiculo v : garaje.plazas) {
                        if (v != null) {
                            System.out.println("Matrícula: " + v.getMatricula() + ", Cuota mensual: " + v.getCuotaMesGarage() + ", Tipo vehículo: " + v.getClass().getSimpleName());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
