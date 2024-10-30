import java.util.Scanner;

// Interfaz IFastFood
public interface IFastFood {
    int tiempoDePreparacion(); // tiempo en minutos
    boolean isVegetariano();
    String tipoPreparacion();
}

// Clase abstracta Receta
public abstract class Receta implements IFastFood {
    protected String nombre;
    protected String[] ingredientes;
    protected String[] pasosPreparacion;

    public Receta(String nombre, String[] ingredientes, String[] pasosPreparacion) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.pasosPreparacion = pasosPreparacion;
    }
}

// Clase Pizza
public class Pizza extends Receta {
    public Pizza(String nombre, String[] ingredientes, String[] pasosPreparacion) {
        super(nombre, ingredientes, pasosPreparacion);
    }

    @Override
    public boolean isVegetariano() {
        for (String ingrediente : ingredientes) {
            if (ingrediente.toLowerCase().contains("carne")) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String tipoPreparacion() {
        return "horno";
    }

    @Override
    public int tiempoDePreparacion() {
        return 2 + nombre.length(); // 2 minutos base + longitud del nombre
    }
}

// Clase Sandwich
public class Sandwich extends Receta {
    public Sandwich(String nombre, String[] ingredientes, String[] pasosPreparacion) {
        super(nombre, ingredientes, pasosPreparacion);
    }

    @Override
    public boolean isVegetariano() {
        return true; // El sandwich es siempre vegetariano
    }

    @Override
    public String tipoPreparacion() {
        return "plancha";
    }

    @Override
    public int tiempoDePreparacion() {
        int vocales = 0;
        for (char c : nombre.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                vocales++;
            }
        }
        return 2 + vocales; // 2 minutos base + número de vocales en el nombre
    }
}

// Clase Menu
public class Menu {
    private IFastFood[] elementos;
    private int contador;

    public Menu(int capacidad) {
        this.elementos = new IFastFood[capacidad];
        this.contador = 0;
    }

    public void anadirReceta(IFastFood receta) {
        if (contador < elementos.length) {
            elementos[contador++] = receta;
        } else {
            System.out.println("El menú está lleno.");
        }
    }

    public IFastFood[] getElementos() {
        return elementos;
    }

    public int getContador() {
        return contador;
    }
}

// Clase Restaurante
public class Restaurante {
    private IFastFood[] mapaRecetasRestaurante;
    private int contadorRecetas;
    private Menu menu;

    public Restaurante(int capacidadRecetas, int capacidadMenu) {
        this.mapaRecetasRestaurante = new IFastFood[capacidadRecetas];
        this.contadorRecetas = 0;
        this.menu = new Menu(capacidadMenu);
    }

    public void crearReceta(String nombre, String[] ingredientes, String[] pasosPreparacion, boolean esPizza) {
        IFastFood receta;
        if (esPizza) {
            receta = new Pizza(nombre, ingredientes, pasosPreparacion);
        } else {
            receta = new Sandwich(nombre, ingredientes, pasosPreparacion);
        }
        if (contadorRecetas < mapaRecetasRestaurante.length) {
            mapaRecetasRestaurante[contadorRecetas++] = receta;
        } else {
            System.out.println("El mapa de recetas está lleno.");
        }
    }

    public void anadirRecetaAlMenu(IFastFood receta) {
        menu.anadirReceta(receta);
    }

    public void anadirRecetaAlMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una receta del siguiente menú:");
        for (int i = 0; i < contadorRecetas; i++) {
            System.out.println(i + 1 + ". " + mapaRecetasRestaurante[i].getClass().getSimpleName() + ": " + mapaRecetasRestaurante[i].tiempoDePreparacion() + " minutos");
        }
        System.out.print("Ingrese el número de la receta: ");
        int opcion = scanner.nextInt();
        if (opcion > 0 && opcion <= contadorRecetas) {
            anadirRecetaAlMenu(mapaRecetasRestaurante[opcion - 1]);
            System.out.println("Receta añadida al menú.");
        } else {
            System.out.println("Receta no encontrada.");
        }
    }

    public double tiempoMedio() {
        if (menu.getContador() == 0) {
            return -1;
        }
        int totalTiempo = 0;
        for (int i = 0; i < menu.getContador(); i++) {
            totalTiempo += menu.getElementos()[i].tiempoDePreparacion();
        }
        return (double) totalTiempo / menu.getContador();
    }

    public double porcentajeVegetariano() {
        if (menu.getContador() == 0) {
            return 0;
        }
        int vegetarianos = 0;
        for (int i = 0; i < menu.getContador(); i++) {
            if (menu.getElementos()[i].isVegetariano()) {
                vegetarianos++;
            }
        }
        return (double) vegetarianos / menu.getContador() * 100;
    }

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante(10, 5);

        restaurante.crearReceta("Pizza Veggie", new String[]{"Tomate", "Queso", "Orégano"}, new String[]{"Poner la masa en el horno", "Agregar los ingredientes", "Hornear durante 10 minutos"}, true);
        restaurante.crearReceta("Sandwich de Pollo", new String[]{"Pollo", "Lechuga", "Tomate"}, new String[]{"Poner la carne en la plancha", "Agregar los ingredientes", "Servir"}, false);

        restaurante.anadirRecetaAlMenu();

        System.out.println("Tiempo medio de preparación: " + restaurante.tiempoMedio() + " minutos");
        System.out.println("Porcentaje de recetas vegetarianas: " + restaurante.porcentajeVegetariano() + "%");
    }
}
