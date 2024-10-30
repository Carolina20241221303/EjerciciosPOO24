//clase profesor
public class profesor {
//se declaran protected paar que la subclase pueda acceder a los atributos
//Si añosConsolidados se hubiera declarado como private en la clase Profesor, no se podría acceder directamente desde ProfesorEmerito. En ese caso, sería necesario utilizar un método getAñosConsolidados() para obtener su valor, ya que los atributos private no son accesibles fuera de su propia clase.
protected String nombre;
    protected int edad;
    protected int añosConsolidados;


    public profesor(String nombre, int edad, int añosConsolidados) {
        this.nombre = nombre;
        this.edad = edad;
        this.añosConsolidados = añosConsolidados;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getAñosConsolidados() {
        return añosConsolidados;
    }
}

//subclase profesorEmerito
public class profesorEmerito extends profesor {

    private int añosEmerito;
//El método obtenerSalarioBase() accede directamente a añosConsolidados sin necesidad de un método get o de invocar super, ya que añosConsolidados es protected y está disponible en la subclase.
    public profesorEmerito(String nombre, int edad, int añosConsolidados, int añosEmerito) {
        super(nombre, edad, añosConsolidados);
        this.añosEmerito = añosEmerito;
    }

    public double obtenerSalarioBase() {
        return 925 + (añosConsolidados * 12.25) + (23.40 * añosEmerito);
    }

    public int getAñosEmerito() {
        return añosEmerito;
    }
    
}

//prueba
public class pruebaProfesor {

    public static void main(String[] args) {
        profesorEmerito profesorEmerito = new profesorEmerito("Juan Pérez", 65, 20, 5);
        
        System.out.println("Nombre: " + profesorEmerito.getNombre());
        System.out.println("Edad: " + profesorEmerito.getEdad());
        System.out.println("Años Consolidados: " + profesorEmerito.getAñosConsolidados());
        System.out.println("Años Emerito: " + profesorEmerito.getAñosEmerito());
        System.out.println("Salario Base: " + profesorEmerito.obtenerSalarioBase());
    }
    
}
