//Clase forma
public class forma {

    public String nombre;
    public double posicionX;
    public double posicionY;
    public String color;
//Constructor
    public forma(String nombre, double posicionX, double posicionY, String color) {
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.color = color;
    }
//Metodos
    public double calcularArea() {
        return 0;
    }

    public String getNombre() {
        return nombre;
    }
//Setters y Getters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}


//Subclase triangulo
public class triangulo extends forma {
    private double base;
    private double altura;
//Constructor
    public triangulo(String nombre, double posicionX, double posicionY, String color, double base, double altura) {
        super(nombre, posicionX, posicionY, color);
        this.base = base;
        this.altura = altura;
    }
//Metodos
    @Override
    public double calcularArea() {
        return (base * altura) / 2;

    }
    // Setters y Getters
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}

//Subclase cuadrado

public class cuadrado extends forma{
    private double lado;
//Constructor
    public cuadrado(String nombre, double posicionX, double posicionY, String color, double lado) {
        super(nombre, posicionX, posicionY, color);
        this.lado = lado;
    }
//Metodos
    @Override
    public double calcularArea() {
        return lado * lado;
    }

    public double calcularPerimetro() {
        return 4 * lado;
    }
//Setters y Getters
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
}

//Prueba Formas

public class pruebaFormas {
    public static void main(String[] args) {
//Objeto de triangulo
        triangulo triangulo = new triangulo ("Triángulo 1", 0, 0, "Rojo", 5, 10);
          System.out.println("Área del " + triangulo.getNombre() + ": " + triangulo.calcularArea());
//Objeto de cuadrado
          cuadrado cuadrado = new cuadrado("Cuadrado 1", 0, 0, "Azul", 4);
          System.out.println("Área del " + cuadrado.getNombre() + ": " + cuadrado.calcularArea());
          System.out.println("Perímetro del " + cuadrado.getNombre() + ": " + cuadrado.calcularPerimetro());
    }
}

