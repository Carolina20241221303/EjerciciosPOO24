//clase aeropuerto
public abstract class aeropuerto {

    String nombre;
    String ciudad;
    aviones[] aviones; // Arreglo de aviones
    int contadorAviones;

    aeropuerto(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.aviones = new aviones[capacidad]; // Inicializa el arreglo con la capacidad
        this.contadorAviones = 0;
    }

    void agregarAvion(aviones avion) {
        if (contadorAviones < aviones.length) {
            aviones[contadorAviones] = avion;
            contadorAviones++;
        } else {
            System.out.println("Capacidad máxima de aviones alcanzada.");
        }
    }
    
}

//clase hija aeropuertoMilitar
public class aeropuertoMilitar extends aeropuerto {

    String nombreEnClave;

    aeropuertoMilitar(String nombre, String ciudad, String nombreEnClave, int capacidad) {
        super(nombre, ciudad, capacidad);
        this.nombreEnClave = nombreEnClave;
    }
    
}

//clase hija aeropuertoComercial
public class aeropurtoComercial extends aeropuerto {

    int numeroTerminales;

    public aeropurtoComercial(String nombre, String ciudad, int capacidad, int numeroTerminales) {
        super(nombre, ciudad, capacidad);
        this.numeroTerminales = numeroTerminales;
    }
    
}

//clase aviones
public abstract class aviones {
    
    String nombre;
    String matricula;
    int autonomiaVuelo;
    static pasajero[] pasajeros; // Arreglo de pasajeros
    int contadorPasajeros;

   

   



     public aviones(String nombre, String matricula, int autonomiaVuelo, pasajero[] pasajeros, int contadorPasajeros) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.autonomiaVuelo = autonomiaVuelo;
        this.pasajeros = pasajeros;
        this.contadorPasajeros = contadorPasajeros;
    }


}

//clase hija avionPasajeros
public class avionPasajeros extends aviones {

    int numeroPasajeros;

    public avionPasajeros(String nombre, String matricula, int autonomiaVuelo, pasajero[] pasajeros,
            int contadorPasajeros, int numeroPasajeros) {
        super(nombre, matricula, autonomiaVuelo, pasajeros, contadorPasajeros);
        this.numeroPasajeros = numeroPasajeros;
    }
    
}

//clase hija avionCarga
public class avionCarga extends aviones {

    int cargaMaxima;

    public avionCarga(String nombre, String matricula, int autonomiaVuelo, pasajero[] pasajeros, int contadorPasajeros,
            int cargaMaxima) {
        super(nombre, matricula, autonomiaVuelo, pasajeros, contadorPasajeros);
        this.cargaMaxima = cargaMaxima;
    }


}

//clase hija avioneta
public class avioneta extends aviones {
    int numeroPasajeros;

    public avioneta(String nombre, String matricula, int autonomiaVuelo, pasajero[] pasajeros, int contadorPasajeros,
            int numeroPasajeros) {
        super(nombre, matricula, autonomiaVuelo, pasajeros, contadorPasajeros);
        this.numeroPasajeros = numeroPasajeros;
    }
    
}

//clase pasajero
public class pasajero {

    String nombre;
    String dni;
    int edad;

    pasajero(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }
    
}

//prueba
public class pruebaAeropuerto {

    public static void main(String[] args) {
        // Crear un aeropuerto militar
        AeropuertoMilitar aeropuertoMilitar = new AeropuertoMilitar("Base Aérea", "Ciudad Militar", "Alpha", 5);
        
        // Crear un aeropuerto comercial
        AeropuertoComercial aeropuertoComercial = new AeropuertoComercial("Aeropuerto Internacional", "Ciudad Comercial", 3, 5);
        
        // Crear aviones
        avionPasajeros avionPasajeros = new avionPasajeros("Boeing 737", "ABC123", 3000, 180, 10);
        avionCarga avionCarga = new avionCarga("Carguero 747", "CDE456", 5000, 10000, 5);
        avioneta avioneta = new avioneta("cessna 172", "FGH789", 800, 4, 4)
        
        // Agregar aviones a los aeropuertos
        aeropuertoMilitar.agregarAvion(avionCarga);
        aeropuertoComercial.agregarAvion(avionPasajeros);
        aeropuertoComercial.agregarAvion(avioneta);
        
        // Crear pasajeros
        pasajero pasajero1 = new pasajero("Juan Pérez", "12345678", 30);
        pasajero pasajero2 = new pasajero("Ana Gómez", "87654321", 25);
        
        // Agregar pasajeros al avión de pasajeros
        avionPasajeros.agregarPasajero(pasajero1);
        avionPasajeros.agregarPasajero(pasajero2);
        
        // Mostrar información de los aeropuertos y aviones
        System.out.println("Aeropuerto Militar: " + aeropuertoMilitar.nombre + ", Ciudad: " + aeropuertoMilitar.ciudad);
        System.out.println("Aeropuerto Comercial: " + aeropuertoComercial.nombre + ", Ciudad: " + aeropuertoComercial.ciudad);
        
        System.out.println("Aviones en Aeropuerto Militar:");
        for (int i = 0; i < aeropuertoMilitar.contadorAviones; i++) {
            aviones avion = aeropuertoMilitar.aviones[i];
            System.out.println("Avión: " + avion.nombre + ", Matrícula: " + avion.matricula);
        }

        System.out.println("Aviones en Aeropuerto Comercial:");
        for (int i = 0; i < aeropuertoComercial.contadorAviones; i++) {
            aviones avion = aeropuertoComercial.aviones[i];
            System.out.println("Avión: " + avion.nombre + ", Matrícula: " + avion.matricula);
        }

        System.out.println("Pasajeros en el avión de pasajeros:");
        for (int i = 0; i < avionPasajeros.contadorPasajeros; i++) {
            pasajero pasajero = avionPasajeros.pasajeros[i];
            System.out.println("Pasajero: " + pasajero.nombre + ", DNI: " + pasajero.dni + ", Edad: " + pasajero.edad);
        }
    }
    
}
