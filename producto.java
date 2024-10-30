//clase producto
public class producto {

    private String fechaCaducidad;
    private String numeroLote;

    public producto(String fechaCaducidad, String numeroLote) {
        this.fechaCaducidad = fechaCaducidad;
        this.numeroLote = numeroLote;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public String mostrarInfo() {
        return "Fecha de Caducidad: " + fechaCaducidad + ", Número de Lote: " + numeroLote;
    }
}

//subclase productoFresco
public class productoFresco extends producto{

    private String fechaEnvasado;
    private String paisOrigen;

    public productoFresco(String fechaCaducidad, String numeroLote, String fechaEnvasado, String paisOrigen) {
        super(fechaCaducidad, numeroLote);
        this.fechaEnvasado = fechaEnvasado;
        this.paisOrigen = paisOrigen;
    }

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Fecha de Envasado: " + fechaEnvasado + ", País de Origen: " + paisOrigen;
    }
}

//subclase productoRefrigerado
public class productoRefrigerado extends producto{

    private String codigoSupervision;
    private String fechaEnvasado;
    private String temperaturaMantenimiento;
    private String paisOrigen;

    public productoRefrigerado(String fechaCaducidad, String numeroLote, String codigoSupervision, String fechaEnvasado, String temperaturaMantenimiento, String paisOrigen) {
        super(fechaCaducidad, numeroLote);
        this.codigoSupervision = codigoSupervision;
        this.fechaEnvasado = fechaEnvasado;
        this.temperaturaMantenimiento = temperaturaMantenimiento;
        this.paisOrigen = paisOrigen;
    }

    public String getCodigoSupervision() {
        return codigoSupervision;
    }

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public String getTemperaturaMantenimiento() {
        return temperaturaMantenimiento;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Código de Supervisión: " + codigoSupervision + ", Fecha de Envasado: " + fechaEnvasado + ", Temperatura de Mantenimiento: " + temperaturaMantenimiento + ", País de Origen: " + paisOrigen;
    }
}

//subclase productoCongelado
public class productosCongelados extends producto {

    private String fechaEnvasado;
    private String paisOrigen;
    private String temperaturaMantenimiento;

    public productosCongelados(String fechaCaducidad, String numeroLote, String fechaEnvasado, String paisOrigen, String temperaturaMantenimiento) {
        super(fechaCaducidad, numeroLote);
        this.fechaEnvasado = fechaEnvasado;
        this.paisOrigen = paisOrigen;
        this.temperaturaMantenimiento = temperaturaMantenimiento;
    }

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public String getTemperaturaMantenimiento() {
        return temperaturaMantenimiento;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Fecha de Envasado: " + fechaEnvasado + ", País de Origen: " + paisOrigen + ", Temperatura de Mantenimiento: " + temperaturaMantenimiento;
    }
}

//subclase productoCongeladoAire
public class productoCongeladoAire extends productoCongelados{

    private float porcentajeNitrogeno;
    private float porcentajeOxigeno;
    private float porcentajeDioxidoCarbono;
    private float porcentajeVaporAgua;

  

    public productoCongeladoAire(String fechaCaducidad, String numeroLote, float porcentajeNitrogeno,
            float porcentajeOxigeno, float porcentajeDioxidoCarbono, float porcentajeVaporAgua) {
        super(fechaCaducidad, numeroLote);
        this.porcentajeNitrogeno = porcentajeNitrogeno;
        this.porcentajeOxigeno = porcentajeOxigeno;
        this.porcentajeDioxidoCarbono = porcentajeDioxidoCarbono;
        this.porcentajeVaporAgua = porcentajeVaporAgua;
    }

    public float getPorcentajeNitrogeno() {
        return porcentajeNitrogeno;
    }

    public float getPorcentajeOxigeno() {
        return porcentajeOxigeno;
    }

    public float getPorcentajeDioxidoCarbono() {
        return porcentajeDioxidoCarbono;
    }

    public float getPorcentajeVaporAgua() {
        return porcentajeVaporAgua;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Porcentaje de Nitrógeno: " + porcentajeNitrogeno + ", Porcentaje de Oxígeno: " + porcentajeOxigeno + ", Porcentaje de Dióxido de Carbono: " + porcentajeDioxidoCarbono + ", Porcentaje de Vapor de Agua: " + porcentajeVaporAgua;
    }
}   

//subclase productoCongeladoAgua
public class productoCongeladoAgua extends productoCongelados {

    private float salinidadAgua;

  

    public productoCongeladoAgua(String fechaCaducidad, String numeroLote, float salinidadAgua) {
        super(fechaCaducidad, numeroLote);
        this.salinidadAgua = salinidadAgua;
    }

    public float getSalinidadAgua() {
        return salinidadAgua;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Salinidad del Agua: " + salinidadAgua + " gramos por litro";
    }
}

//subclase productoCongeladoNitrogeno
public class productoCongeladoNitrogeno extends productoCongelados {
             
    private String metodoCongelacion;
    private int tiempoExposicionNitrogeno;

    public productoCongeladoNitrogeno(String fechaCaducidad, String numeroLote, String fechaEnvasado, String paisOrigen, String temperaturaMantenimiento, String metodoCongelacion, int tiempoExposicionNitrogeno) {
        super(fechaCaducidad, numeroLote, fechaEnvasado, paisOrigen, temperaturaMantenimiento);
        this.metodoCongelacion = metodoCongelacion;
        this.tiempoExposicionNitrogeno = tiempoExposicionNitrogeno;
    }

    public String getMetodoCongelacion() {
        return metodoCongelacion;
    }

    public int getTiempoExposicionNitrogeno() {
        return tiempoExposicionNitrogeno;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Método de Congelación: " + metodoCongelacion + ", Tiempo de Exposición al Nitrógeno: " + tiempoExposicionNitrogeno + " segundos";
    }
}

//prueba

public class pruebaProducto {

    public static void main(String[] args) {
        // Crear productos frescos
        productoFresco productoFresco1 = new productoFresco("2022-01-01", "Lote 1", "2021-12-01", "España");
        productoFresco productoFresco2 = new productoFresco("2022-01-15", "Lote 2", "2021-12-15", "Francia");

        // Crear productos refrigerados
        productoRefrigerado productoRefrigerado1 = new productoRefrigerado("2022-02-01", "Lote 3", "Codigo 1", "2021-12-01", "4°C", "Italia");
        productoRefrigerado productoRefrigerado2 = new productoRefrigerado("2022-02-15", "Lote 4", "Codigo 2", "2021-12-15", "5°C", "Alemania");
        productoRefrigerado productoRefrigerado3 = new productoRefrigerado("2022-03-01", "Lote 5", "Codigo 3", "2021-12-01", "6°C", "Reino Unido");

        // Crear productos congelados
        productoCongeladoAire productoCongeladoPorAire1 = new productoCongeladoAire("2022-04-01", "Lote 6", "2021-12-01", "España", "-20°C", 80, 15, 3, 2);
        productoCongeladoAire productoCongeladoPorAire2 = new productoCongeladoAire("2022-04-15", "Lote 7", "2021-12-15", "Francia", "-20°C", 75, 18, 4, 3);

        productoCongeladoAgua productoCongeladoPorAgua1 = new productoCongeladoAgua("2022-05-01", "Lote 8", "2021-12-01", "Italia", "-20°C", 10);
        productoCongeladoAgua productoCongeladoPorAgua2 = new productoCongeladoAgua("2022-05-15", "Lote 9", "2021-12-15", "Alemania", "-20°C", 12);

        productoCongeladoNitrogeno productoCongeladoPorNitrogeno1 = new productoCongeladoNitrogeno("2022-06-01", "Lote 10", "2021-12-01", "Reino Unido", "-20°C", "Metodo 1", 30);

        // Mostrar información de cada producto
        System.out.println("Producto Fresco 1: " + productoFresco1.mostrarInfo());
        System.out.println("Producto Fresco 2: " + productoFresco2.mostrarInfo());

        System.out.println("Producto Refrigerado 1: " + productoRefrigerado1.mostrarInfo());
        System.out.println("Producto Refrigerado 2: " + productoRefrigerado2.mostrarInfo());
        System.out.println("Producto Refrigerado 3: " + productoRefrigerado3.mostrarInfo());

        System.out.println("Producto Congelado por Aire 1: " + productoCongeladoPorAire1.mostrarInfo());
        System.out.println("Producto Congelado por Aire 2: " + productoCongeladoPorAire2.mostrarInfo());

        System.out.println("Producto Congelado por Agua 1: " + productoCongeladoPorAgua1.mostrarInfo());
        System.out.println("Producto Congelado por Agua 2: " + productoCongeladoPorAgua2.mostrarInfo());

        System.out.println("Producto Congelado por Nitrógeno 1: " + productoCongeladoPorNitrogeno1.mostrarInfo());
    }
    
}
