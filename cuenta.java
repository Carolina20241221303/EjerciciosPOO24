//clase persona
public class persona {

    private String nombre;
    private String nif;

    // Constructor parametrizado
    public persona(String nombre, String nif) {
        this.nombre = nombre;
        this.nif = nif;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public String getNif() {
        return nif;
    }

}

//clase cuenta
public class cuenta {

      private long numeroCuenta;
    private double saldo;
    private persona cliente;
    
    public cuenta(persona cliente, long numeroCuenta) {
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.0; 
    }

        
        public long getNumeroCuenta() {
            return numeroCuenta;
        }
    
        public double getSaldo() {
            return saldo;
        }
    
        public persona getCliente() {
            return cliente;
        }
        
        public void ingresar(double x) {
            if (x > 0) {
                saldo += x;
                System.out.println("Se han ingresado " + x + " en la cuenta.");
            } else {
                System.out.println("El importe a ingresar debe ser mayor que 0.");
            }
        }
    
        
        public void retirar(double x) {
            if (x > 0 && x <= saldo) {
                saldo -= x;
                System.out.println("Se han retirado " + x + " de la cuenta.");
            } else {
                System.out.println("El importe a retirar debe ser mayor que 0 y menor o igual al saldo disponible.");
            }
        }
    }

//Subclase cuentaCorriente
public class cuentaCorriente extends cuenta {

    private double maximoRetirable;

     public cuentaCorriente(persona cliente, long numeroCuenta, double maximoRetirable) {
        super(cliente, numeroCuenta);
        this.maximoRetirable = maximoRetirable;
    }

    public double getMaximoRetirable() {
        return maximoRetirable;
    }

    @Override
    public void retirar(double x) {
        if (x > 0 && x <= getSaldo() && x <= maximoRetirable) {
            super.retirar(x);
        } else {
            System.out.println("La cantidad a retirar debe ser mayor que 0 y menor o igual al saldo disponible");
        }
    }

    @Override
    public String toString() {
        return "Cuenta Corriente\n" +
               "Número de cuenta: " + getNumeroCuenta() + "\n" +
               "Saldo: " + getSaldo() + "\n" +
               "Cliente: " + getCliente().getNombre() + "\n" +
               "NIF: " + getCliente().getNif() + "\n" +
               "Máximo Retirable: " + maximoRetirable + "\n";
    }

    
}

//Subclase cuentaAhorros
public class cuentaAhorros extends cuenta {

    private double saldoMinimo;

    public cuentaAhorros(persona cliente, long numeroCuenta, double saldoMinimo) {
        super(cliente, numeroCuenta);
        this.saldoMinimo = saldoMinimo;
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    @Override
    public void retirar(double x) {
        if (x > 0 && (getSaldo() - x) >= saldoMinimo) {
            super.retirar(x);
        } else {
            System.out.println("No se puede retirar esa cantidad, se debe mantener el saldo mínimo de " + saldoMinimo);
        }
    }

    @Override
    public String toString() {
        return "Cuenta Ahorro\n" +
               "Número de cuenta: " + getNumeroCuenta() + "\n" +
               "Saldo: " + getSaldo() + "\n" +
               "Cliente: " + getCliente().getNombre() + "\n" +
               "NIF: " + getCliente().getNif() + "\n" +
               "Saldo Mínimo: " + saldoMinimo + "\n";
    }
}

//clase prueba
public class pruebaCuenta {

    public static void main(String[] args) {
        
        persona persona1 = new persona("Juan Pérez", "12345678A");
        persona persona2 = new persona("Ana Gómez", "87654321B");
        
        cuentaCorriente cuentaCorriente1 = new cuentaCorriente(persona1, 1001, 500);
        cuentaAhorros cuentaAhorro1 = new cuentaAhorros(persona2, 2001, 1000);
        
        
        System.out.println(cuentaCorriente1);
        cuentaCorriente1.ingresar(1000);
        System.out.println("Saldo después del ingreso: " + cuentaCorriente1.getSaldo());
        
        cuentaCorriente1.retirar(300);
        System.out.println("Saldo después de retirar 300: " + cuentaCorriente1.getSaldo());
        
        cuentaCorriente1.retirar(600); 
        System.out.println("Saldo después de intentar retirar 600: " + cuentaCorriente1.getSaldo());
        
    
        System.out.println(cuentaAhorro1);
        cuentaAhorro1.ingresar(1500);
        System.out.println("Saldo después del ingreso: " + cuentaAhorro1.getSaldo());
        
        cuentaAhorro1.retirar(400);
        System.out.println("Saldo después de retirar 400: " + cuentaAhorro1.getSaldo());
        
        cuentaAhorro1.retirar(1000); 
        System.out.println("Saldo después de intentar retirar 1000: " + cuentaAhorro1.getSaldo());
        
        cuentaAhorro1.retirar(100);
        System.out.println("Saldo después de retirar 100: " + cuentaAhorro1.getSaldo());
    }
}

