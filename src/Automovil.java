public class Automovil {

    // Atributos de las instancias de la clase Automóvil. Se declaran como públicos para poder acceder a ellos desde otra clase
    private int id; // Atributo de instancia. Es redundante asignar por defecto el valor 0 ya que es el valor por defecto de los enteros
    private String fabricante = "Ford"; // private indica que el atributo es privado y solo se puede acceder a él desde la misma clase
    private String modelo = "Ka";
    private String color = "Gris"; // Valor por defecto que puede ser modificado
    private double cilindrada = 1.6; // Valor por defecto que puede ser modificado
    private int capacidadTanque = 32; // Valor por defecto que puede ser modificado

    // Atributos de clase o atributos estáticos
    private static int cantidadRuedas = 4; // Se puede acceder a este atributo sin necesidad de crear una instancia de la clase Automóvil
    private static String colorPatente = "Naranja"; // Se puede acceder a este atributo sin necesidad de crear una instancia de la clase Automóvil
    private static int ultimoId; // Se puede acceder a este atributo sin necesidad de crear una instancia de la clase Automóvil

    // 1° Sección de métodos: Constructores
    // Creo el constructor de la clase Automóvil
    // Puedo tener sobre carga de constructores por si necesito crear objetos de la clase Automóvil con diferentes atributos o con ninguno
    public Automovil() {
        // Constructor vacío
        this.id = ++ultimoId; // Incremento el valor de la variable últimoId y se lo asigno al atributo id. Si es el primer objeto creado, id valdrá 1
    }

    public Automovil(String fabricante, String modelo) {
        // El constructor es un método especial que se llama al crear una instancia de la clase
        // Se puede utilizar para inicializar los atributos de la clase
        this(); // Llamo al constructor sin parámetros
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public Automovil(String fabricante, String modelo, String color) {
        this(fabricante, modelo); // Llamo al constructor con dos parámetros
        this.color = color;
    }

    public Automovil(String fabricante, String modelo, String color, double cilindrada) {
        this(fabricante, modelo, color); // Llamo al constructor con tres parámetros
        this.cilindrada = cilindrada;
    }

    public Automovil(String fabricante, String modelo, String color, double cilindrada, int capacidadTanque) {
        this(fabricante, modelo, color, cilindrada); // Llamo al constructor con cuatro parámetros
        this.capacidadTanque = capacidadTanque;
    }

    // 2° Sección de métodos: Getters y Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabricante() {
        return this.fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCilindrada() {
        return this.cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getCapacidadTanque() {
        return this.capacidadTanque;
    }

    public void setCapacidadTanque(int capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }

    // Getters & Setters de los atributos de clase o atributos estáticos
    public static int getCantidadRuedas() {
        return cantidadRuedas;
    }

    public static void setCantidadRuedas(int cantidadRuedas) {
        Automovil.cantidadRuedas = cantidadRuedas; // Se accede a un atributo estático con el nombre de la clase
    }

    public static String getColorPatente() {
        return colorPatente;
    }

    public static void setColorPatente(String colorPatente) {
        Automovil.colorPatente = colorPatente; // Se accede a un atributo estático con el nombre de la clase
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        Automovil.ultimoId = ultimoId; // Se accede a un atributo estático con el nombre de la clase
    }

    // En un método estético no se puede acceder a atributos de instancia, solo a atributos de clase. También a valores que se pase por parámetro.

    // 3° sección de métodos: Métodos de la clase Automóvil que usan sus objetos
    public void imprimirDetalle() {
        System.out.println("Mi auto es un " + this.fabricante + " " + this.modelo + " de color " + this.color + " y cilindrada " + this.cilindrada + " litros.");
        // "this" es una referencia al objeto actual. Se utiliza para acceder a los atributos y métodos de la clase. Se podría omitir en este caso. Pero es una buena práctica utilizarlo.
        // Dentro de una clase que representa datos no es buena práctica utilizar System.out.println. Se debe separar la lógica de la presentación. Esto iría en una clase main.
    }

    public String retornarDetalle() {
        return "Mi auto es un " + this.getFabricante() + " " + this.getModelo() + " de color " + this.getColor() + " y cilindrada " + this.getCilindrada() + " litros.";
    }

    public String acelerar(int rpm) {
        return "El auto " + this.fabricante + " " + this.modelo + " está acelerando a " + rpm + " rpm.";
    }

    public String frenar() {
        return "El auto " + this.fabricante + " " + this.modelo + " está frenando.";
    }

    public String acelerarFrenar(int rpm) {
        String aceleracion = this.acelerar(rpm);
        String frenado = this.frenar();
        return aceleracion + "\n" + frenado;
    }

    public double calcularConsumo(double kms, double porcentajeCombustible) {
        return kms / (this.capacidadTanque * porcentajeCombustible);
    }

    public double calcularConsumo(double kms, int porcentajeCombustible) {
        return kms / (this.capacidadTanque * (porcentajeCombustible / 100f));
    } // Se sobrecarga el método calcularConsumo para recibir un porcentaje como entero. Se convierte a float para que la división sea decimal

    // 4° Sección de métodos: Sobreescribir métodos de la clase o superclase
    // Sobreescribo el método equals de la clase Object para comparar dos objetos de la clase Automóvil
    @Override
    public boolean equals(Object obj) {
        // Se verifica que el objeto de comparación no sea el mismo objeto
        if (this == obj) {
            return true;
        }
        // Se verifica que el objeto sea de la clase Automóvil
        if (!(obj instanceof Automovil)) {
            return false;
        }
        // Se castea el objeto a la clase Automóvil y se comparan los atributos
        Automovil auto = (Automovil) obj;
        return (this.getFabricante() != null
                && this.getModelo() != null
                && this.getFabricante().equals(auto.getFabricante())
                && this.getModelo().equals(auto.getModelo())
                && this.getColor().equals(auto.getColor()));
    }

    // Sobreescribo el método toString de la clase Object para devolver una representación en String del objeto
    @Override
    public String toString() {
        return "Automovil [fabricante=" + this.fabricante + // Los atributos de objeto se acceden con this
                ", modelo=" + this.modelo +
                ", color=" + this.getColor() + // Los métodos de objeto se acceden con this
                ", cilindrada=" + this.getCilindrada() +
                ", capacidadTanque=" + this.capacidadTanque +
                ", cantidadRuedas=" + Automovil.cantidadRuedas + // Los atributos de clase se acceden con el nombre de la clase
                ", colorPatente=" + Automovil.colorPatente +
                ", id=" + this.id +
                "]";
    }
}
