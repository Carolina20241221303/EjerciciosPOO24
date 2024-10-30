//clase empleado2
import java.util.Scanner;

public class empleado2 {

    private String nombre;
    private String telefono;
    private static int numeroEmpleados = 0;

    // Constructor
    public empleado2(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        numeroEmpleados++; // Incrementar el contador de empleados cada vez que se crea una instancia
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método estático para obtener el número de empleados
    public static int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    // Método para mostrar la información del empleado
    public String mostrarInfo() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono;
    }
}

//prueba
import java.util.Scanner;
public class prueba {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        empleado2[] empleados = new empleado2[4];

        // Leer datos de los empleados
        for (int i = 0; i < empleados.length; i++) {
            System.out.println("Ingrese los datos del empleado " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            // Crear una nueva instancia de Empleado y almacenarla en el array
            empleados[i] = new empleado2(nombre, telefono);
        }

        // Mostrar datos de cada empleado
        System.out.println("\nDatos de los empleados:");
        for (empleado2 empleado : empleados) {
            System.out.println(empleado.mostrarInfo());
        }

        // Mostrar el número de empleados instanciados
        System.out.println("\nNúmero total de empleados: " + empleado2.getNumeroEmpleados());

        scanner.close();
    }
    
}
