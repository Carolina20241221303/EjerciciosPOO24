//clase vivienda
public class vivienda {

    protected String calle;
    protected double precio;
    protected int superficieEnMetros;

    // Constructor
    public vivienda(String calle, int superficieEnMetros) {
        this.calle = calle;
        this.superficieEnMetros = superficieEnMetros;
        this.precio = calcularPrecio(); // Calcular el precio al crear la vivienda
    }

    public double calcularPrecio() {
        return superficieEnMetros * 1000; // Precio base para Vivienda
    }

    public String getCalle() {
        return calle;
    }

    public double getPrecio() {
        return precio;
    }

    public int getSuperficieEnMetros() {
        return superficieEnMetros;
    }
}
//subclase piso
public class piso extends vivienda {

private int planta;
    private int puerta;

    public piso(String calle, int superficieEnMetros, int planta, int puerta) {
        super(calle, superficieEnMetros);
        this.planta = planta;
        this.puerta = puerta;
    }

    public int getPlanta() {
        return planta;
    }

    public int getPuerta() {
        return puerta;
    }
    
}

//subclase adosado
public class adosado extends vivienda {

    private int numPlantas;

    public adosado(String calle, int superficieEnMetros, int numPlantas) {
        super(calle, superficieEnMetros);
        this.numPlantas = numPlantas;
    }


    public int getNumPlantas() {
        return numPlantas;
    }
}

//subclase chalet
public class chalet extends vivienda {
    
    private int numParcela;
    private boolean conPiscina;

    // Constructor
    public chalet(String calle, int superficieEnMetros, int numParcela, boolean conPiscina) {
        super(calle, superficieEnMetros);
        this.numParcela = numParcela;
        this.conPiscina = conPiscina;
    }

    // Sobrescribir el método calcularPrecio para Chalet
    @Override
    public double calcularPrecio() {
        return superficieEnMetros * 1300; // Precio especial para Chalet
    }

    // Getters
    public int getNumParcela() {
        return numParcela;
    }

    public boolean isConPiscina() {
        return conPiscina;
    }
}

//prueba
public class pruebaVivienda {

    public static void main(String[] args) {
        
        piso piso = new piso("Calle Falsa 123", 80, 2, 5);
        adosado adosado = new adosado("Calle Verdosa 456", 120, 3);
        chalet chalet = new chalet("Calle Soleada 789", 150, 1, true);

        System.out.println("Información del Piso:");
        System.out.println("Calle: " + piso.getCalle());
        System.out.println("Superficie: " + piso.getSuperficieEnMetros() + " m²");
        System.out.println("Precio: " + piso.getPrecio() + " $");
        System.out.println("Planta: " + piso.getPlanta());
        System.out.println("Puerta: " + piso.getPuerta());
        System.out.println();

        System.out.println("Información del Adosado:");
        System.out.println("Calle: " + adosado.getCalle());
        System.out.println("Superficie: " + adosado.getSuperficieEnMetros() + " m²");
        System.out.println("Precio: " + adosado.getPrecio() + " $");
        System.out.println("Número de Plantas: " + adosado.getNumPlantas());
        System.out.println();

        System.out.println("Información del Chalet:");
        System.out.println("Calle: " + chalet.getCalle());
        System.out.println("Superficie: " + chalet.getSuperficieEnMetros() + " m²");
        System.out.println("Precio: " + chalet.getPrecio() + " $");
        System.out.println("Número de Parcela: " + chalet.getNumParcela());
        System.out.println("¿Con Piscina?: " + (chalet.isConPiscina() ? "Sí" : "No"));
    }
}
