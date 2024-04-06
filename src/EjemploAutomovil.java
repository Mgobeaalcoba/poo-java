import java.util.Date;

public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil toyota = new Automovil("Toyota", "Corolla");

        // Uso los métodos setters para asignar valores a los atributos de la clase Automovil
        toyota.setColor("Blanco");
        toyota.setCilindrada(1.6);
        toyota.setCapacidadTanque(50);

        // Creo un nuevo objeto de la clase Automovil
        Automovil ford = new Automovil("Ford", "Fiesta");

        // Creo un nuevo objeto de la clase Automovil
        Automovil chevrolet = new Automovil("Chevrolet", "Corsa");

        // Seteo los atributos que son publicos y puedo acceder a ellos. Mala práctica. Se deben proteger y leer o modificar mediante métodos (getters y setters)
        chevrolet.setColor("Gris");
        chevrolet.setCilindrada(1.4);
        chevrolet.setCapacidadTanque(45);

        // Creo un nuevo automovil nissan
        Automovil nissan = new Automovil("Nissan", "Sentra", "Rojo", 1.8, 60);
        Automovil nissan2 = new Automovil("Nissan", "Sentra", "Rojo", 1.8, 60);
        Automovil autoDefault = new Automovil();

        // Creo un objeto de tipo Date para comparar con el nissan
        Date fecha = new Date();

        // Modifico el color de la patente de la clase
        Automovil.setColorPatente("Amarillo");

        System.out.println();
        System.out.println("nissan == nissan2: " + (nissan == nissan2));
        System.out.println("nissan.equals(nissan2): " + nissan.equals(nissan2)); // Hace lo mismo que el == salvo que se puede sobreescribir
        // Sin sobreescritura de equals() en la clase Automovil, el resultado es el mismo que el ==. Si se sobreescribe, se puede comparar por los atributos de la clase
        System.out.println("nissan.equals(autoDefault): " + nissan.equals(autoDefault)); // false
        System.out.println("nissan.equals(fecha): " + nissan.equals(fecha)); // false
        // También puede pasar que comparé el objeto con si mismo
        System.out.println("nissan.equals(nissan): " + nissan.equals(nissan)); // true
        System.out.println();

        // Sección de toString()
        System.out.println("toyota.toString(): " + toyota.toString()); // Imprime la dirección de memoria del objeto dado que no se ha sobreescrito el método toString() Automovil@4f023edb
        // Con el metodo sobreescrito se imprime el detalle del objeto: Automovil [fabricante=Toyota, modelo=Corolla, color=Blanco, cilindrada=1.6, capacidadTanque=50]
        System.out.println();

        Automovil[] autos = new Automovil[4];
        autos[0] = toyota;
        autos[1] = ford;
        autos[2] = chevrolet;
        autos[3] = nissan;

        for (Automovil auto : autos) {
            System.out.println(auto); // Aplica el método toString() de la clase Automovil
        }

        System.out.println();

        for (Automovil auto : autos) {
            String detalle = auto.retornarDetalle();
            System.out.println(detalle);
        } // Imprime los detalles de cada auto

        // Acelerar el auto Toyota
        System.out.println(toyota.acelerar(3000));

        // Frenar el auto Toyota
        System.out.println(toyota.frenar());

        // Acelerar y frenar el auto ford;
        System.out.println(ford.acelerarFrenar(2000));

        // Calcular el consumo del auto Chevrolet
        double consumo = chevrolet.calcularConsumo(100, 0.5);
        System.out.println("El consumo del auto Chevrolet es de " + consumo + " litros cada 100 kms.");

        // Calcular el consumo del auto Toyota con el porcentaje de combustible como entero
        consumo = toyota.calcularConsumo(100, 50);
        System.out.println("El consumo del auto Toyota es de " + consumo + " litros cada 100 kms.");

        // Imprimo el fabricante de cada auto
        for (Automovil auto : autos) {
            System.out.println("Fabricante: " + auto.getFabricante());
        }
    }
}
