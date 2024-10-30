//interface
public interface  IAlfombras {

    double calcularSuperficie();
    double calcularPrecio();
    
}

//clase alfombra
public abstract class alfombra implements IAlfombras {

    private String color;
    private int precioMetro;

    
    public alfombra(String color, int precioMetro) {
        this.color = color;
        this.precioMetro = precioMetro;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrecioMetro() {
        return precioMetro;
    }

    public void setPrecioMetro(int precioMetro) {
        this.precioMetro = precioMetro;
    }

    @Override
    public abstract double calcularSuperficie();

    @Override
    public double calcularPrecio() {
        return calcularSuperficie() * precioMetro; // Precio basado en la superficie
    }
    
}

//clase hija alfombraRedonda
public class alfombraRedonda extends alfombra {

    private int radio;

    public alfombraRedonda(String color, int precioMetro, int radio) {
        super(color, precioMetro);
        this.radio = radio;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
    
    @Override
    public double calcularSuperficie() {
        return Math.PI * Math.pow(radio, 2); // Superficie de un círculo
    }
}

//clase hija alfombraCuadrada
public class alfombraCuadrada extends alfombra{

    private int lado;

    public alfombraCuadrada(String color, int precioMetro, int lado) {
        super(color, precioMetro);
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    @Override
    public double calcularSuperficie() {
        return lado * lado; 
    }
    
}

//prueba
public class pruebaAlfombra {

    public static void main(String[] args) {
        // Crear objetos de las clases hijas
        alfombraRedonda alfombraRedonda = new alfombraRedonda("Rojo", 30, 2);
        alfombraCuadrada alfombraCuadrada = new alfombraCuadrada("Azul", 40, 3);

        // Mostrar información de la alfombra redonda
        System.out.println("Alfombra Redonda:");
        System.out.println("Color: " + alfombraRedonda.getColor());
        System.out.println("Radio: " + alfombraRedonda.getRadio() + " m");
        System.out.println("Superficie: " + alfombraRedonda.calcularSuperficie() + " m²");
        System.out.println("Precio: " + alfombraRedonda.calcularPrecio() + " $");
        System.out.println();

        // Mostrar información de la alfombra cuadrada
        System.out.println("Alfombra Cuadrada:");
        System.out.println("Color: " + alfombraCuadrada.getColor());
        System.out.println("Lado: " + alfombraCuadrada.getLado() + " m");
        System.out.println("Superficie: " + alfombraCuadrada.calcularSuperficie() + " m²");
        System.out.println("Precio: " + alfombraCuadrada.calcularPrecio() + " $");
    }
    
}
