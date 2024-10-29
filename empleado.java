//clase empleado
public class empleado {
    
    private String nombre;
    private String dni;
    private int edad; // Rango entre 18 y 45 años
    private boolean casado;
    public double salario;
    
    // Constructor parametrizado
    public empleado(String nombre, String dni, int edad, boolean casado, double salario) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad=edad;
        this.casado = casado;
        this.salario = salario;
    
    }
     // constructor sin parametrizar
    public empleado() {
        this.nombre = "";
        this.dni = "";
        this.edad = 0;
        this.casado = false;
        this.salario = 0.0;

    }
//Metodos
public int edad(int edad) {
    if (edad < 18 || edad > 45) {
    System.out.println ("Edad debe estar entre 18 y 45 años.");
    }
    return this.edad = edad;
}
    public String clasifica() {
        if (edad <= 21) {
            return( "Principiante");
        } else if (edad >= 22 && edad <= 35) {
            return ( "Intermedio");
        } else {
            return ("Senior");
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "DNI: " + dni + "\n" +
               "Edad: " + edad + "\n" +
               "Casado: " + casado + "\n" +
               "Salario: " + salario + "\n";
    }

    public double subirSalario(int x) {
        salario += salario * x / 100;
        return salario;
    }
    
//Setters y Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 18 || edad > 45) {
     System.out.println("La edad debe estar entre 18 y 45 años.");
        }
        this.edad = edad;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}

//subclase programador

public class programador extends empleado {
    
    private int lineasDeCodigoPorHora;
    private String lenguajeDominante;
    

       //constructor parametrizado
    public programador(String nombre, String dni, int edad, boolean casado, double salario, int lineasDeCodigoPorHora, String lenguajeDominante) {
        super(nombre, dni, edad, casado, salario);
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
        this.lenguajeDominante = lenguajeDominante;
    }
   
// constructor sinparametrizar
public programador() {
    super();
    this.lineasDeCodigoPorHora = 0;
    this.lenguajeDominante = "";
}
 
//metodos
public double calculaSalario() {
    return 10 * lineasDeCodigoPorHora;
}

@Override
    public String toString() {
        return super.toString() + 
               "Líneas de código por hora: " + lineasDeCodigoPorHora + "\n" +
               "Lenguaje dominante: " + lenguajeDominante + "\n";
    }
 
}


//prueba
public static void main(String[] args) {
    
        empleado empleado = new empleado("Juan Pérez", "12345678", 30, true, 30000);
        System.out.println(empleado);
        System.out.println("Clasificación: " + empleado.clasifica());
        empleado.subirSalario(10);
        System.out.println("Salario después de aumento: " +empleado.salario);

        programador programador = new programador("Ana Gómez", "87654321", 25, false, 40000, 50, "Java");
        System.out.println(programador);
        System.out.println("Clasificación: " + programador.clasifica());
        System.out.println("Salario calculado: " + programador.calculaSalario());

    }

