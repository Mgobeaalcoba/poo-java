public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil toyota = new Automovil(); // El new crea una instancia de la clase Automovil

        // Seteo los atributos que son publicos y puedo acceder a ellos. Mala práctica. Se deben proteger y leer o modificar mediante métodos (getters y setters)
        toyota.fabricante = "Toyota";
        toyota.modelo = "Corolla";
        toyota.color = "Rojo";
        toyota.cilindrada = 1.8;

        // Creo un nuevo objeto de la clase Automovil
        Automovil ford = new Automovil();

        // Creo un nuevo objeto de la clase Automovil
        Automovil chevrolet = new Automovil();

        // Seteo los atributos que son publicos y puedo acceder a ellos. Mala práctica. Se deben proteger y leer o modificar mediante métodos (getters y setters)
        chevrolet.fabricante = "Chevrolet";
        chevrolet.modelo = "Corsa";
        chevrolet.color = "Azul";
        chevrolet.cilindrada = 1.4;

        Automovil[] autos = new Automovil[3];
        autos[0] = toyota;
        autos[1] = ford;
        autos[2] = chevrolet;

        for (Automovil auto : autos) {
            auto.imprimirDetalle();
        } // Imprime los detalles de cada auto

    }
}
