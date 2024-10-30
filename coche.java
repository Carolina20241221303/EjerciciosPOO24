//clase coche
public class coche {
    
    private String marca; // No se puede modificar
    private String color; // Se puede modificar
    private int km; // Inicializa en 0 y se puede incrementar
    private double precio; // Se puede modificar
    private double factorContaminacion; // No se puede modificar
    private  int anio; // No se puede modificar
    private String matricula; // Se puede modificar una vez
    private String dniTitular; // Se puede modificar
    
    public coche(String marca, String color, double precio, double factorContaminacion, int anio) {
        this.marca = marca;
        this.color = color;
        this.km = 0;
        this.precio = precio;
        this.factorContaminacion = factorContaminacion;
        this.anio = anio;
        this.matricula = null; // Inicialmente no tiene matrícula
        this.dniTitular = null; // Inicialmente no tiene DNI titular
    }
    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKm() {
        return km;
    }

    public void incrementarKm(int km) {
        if (km > 0) {
            this.km += km;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getFactorContaminacion() {
        return factorContaminacion;
    }

    public int getAnio() {
        return anio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (this.matricula == null) {
            this.matricula = matricula;
        }
    }

    public String getDniTitular() {
        return dniTitular;
    }

    public void setDniTitular(String dniTitular) {
        this.dniTitular = dniTitular;
    }

    public void comprarCoche(coche otroCoche) {
        if (this.dniTitular != null && otroCoche.dniTitular != null) {
            this.dniTitular = otroCoche.dniTitular;
        } else {
            System.out.println("No se puede realizar la compra");
        }
    }
}

//subclase cocheMatriculado
public class cocheMatriculado extends coche {

    private int anioMatriculacion;
    private int mesMatriculacion;
    private double impuestoMatriculacion; 

    public cocheMatriculado(String marca, String color, double precio, double factorContaminacion, int anio, String matricula, String dniTitular, int anioMatriculacion, int mesMatriculacion) {
        super(marca, color, precio, factorContaminacion, anio);
        setMatricula(matricula);
        setDniTitular(dniTitular);
        this.anioMatriculacion = anioMatriculacion;
        this.mesMatriculacion = mesMatriculacion;
        calculaImpuestoMatriculacion();
    }

    public void calculaImpuestoMatriculacion() {
        impuestoMatriculacion = getPrecio() / 20; // Vigésima parte del precio
        if (2023 - getAnio() > 10) { // Si el coche tiene más de 10 años
            impuestoMatriculacion += 100; // Recargo de 100 euros
        }
    }

    public int getAnioMatriculacion() {
        return anioMatriculacion;
    }

    public void setAnioMatriculacion(int anioMatriculacion) {
        this.anioMatriculacion = anioMatriculacion;
    }

    public int getMesMatriculacion() {
        return mesMatriculacion;
    }

    public void setMesMatriculacion(int mesMatriculacion) {
        this.mesMatriculacion = mesMatriculacion;
    }

    public double getImpuestoMatriculacion() {
        return impuestoMatriculacion;
    }


    
}

//prueba
public class pruebaCoche {
     public static void main(String[] args) {
        coche coche1 = new coche("Toyota", "Rojo", 20000, 1.2, 2020);
        coche1.setDniTitular("12345678A");
        coche1.setMatricula("ABC1234");

        System.out.println("Coche 1:");
        System.out.println("Marca: " + coche1.getMarca());
        System.out.println("Color: " + coche1.getColor());
        System.out.println("Kilómetros: " + coche1.getKm());
        System.out.println("Precio: " + coche1.getPrecio());
        System.out.println("Año: " + coche1.getAnio());
        System.out.println("Matrícula: " + coche1.getMatricula());
        System.out.println("DNI Titular: " + coche1.getDniTitular());

        // Incrementar kilómetros
        coche1.incrementarKm(150);
        System.out.println("Kilómetros después de incrementar: " + coche1.getKm());

        // Crear un objeto de la clase CocheMatriculado
        cocheMatriculado cocheMatriculado1 = new cocheMatriculado("Ford", "Azul", 25000, 1.5, 2010, "XYZ5678", "87654321B", 2023, 5);

        System.out.println("\nCoche Matriculado 1:");
        System.out.println("Marca: " + cocheMatriculado1.getMarca());
        System.out.println("Color: " + cocheMatriculado1.getColor());
        System.out.println("Kilómetros: " + cocheMatriculado1.getKm());
        System.out.println("Precio: " + cocheMatriculado1.getPrecio());
        System.out.println("Año: " + cocheMatriculado1.getAnio());
        System.out.println("Matrícula: " + cocheMatriculado1.getMatricula());
        System.out.println("DNI Titular: " + cocheMatriculado1.getDniTitular());
        System.out.println("Año de Matriculación: " + cocheMatriculado1.getAnioMatriculacion());
        System.out.println("Mes de Matriculación: " + cocheMatriculado1.getMesMatriculacion());
        System.out.println("Impuesto de Matriculación: " + cocheMatriculado1.getImpuestoMatriculacion());

    
        cocheMatriculado1.setDniTitular("11223344C");
        System.out.println("Nuevo DNI Titular del Coche Matriculado: " + cocheMatriculado1.getDniTitular());

    
        coche1.comprarCoche(cocheMatriculado1);
        System.out.println("DNI Titular del Coche 1 después de la compra: " + coche1.getDniTitular());
    }
}
