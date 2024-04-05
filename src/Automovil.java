public class Automovil {

    // Atributos de la clase Automovil. Se declaran como publicos para poder acceder a ellos desde otra clase
    String fabricante = "Ford";
    String modelo = "Fiesta";
    String color = "Gris"; // Valor por defecto que puede ser modificado
    double cilindrada = 1.6; // Valor por defecto que puede ser modificado

    // Los atributos o métodos estáticos pertenecen a la clase y no a una instancia de la clase. Se accede a ellos mediante el nombre de la clase
    public void imprimirDetalle() {
        System.out.println("Mi auto es un " + this.fabricante + " " + this.modelo + " de color " + this.color + " y cilindrada " + this.cilindrada + " litros.");
        // "this" es una referencia al objeto actual. Se utiliza para acceder a los atributos y métodos de la clase. Se podría omitir en este caso. Pero es una buena práctica utilizarlo.
    }

}
