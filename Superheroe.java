/**
 * ESTUDIANTE 1 - Representación de datos
 * Clase que representa un Superhéroe en el sistema.
 */
public class Superheroe {
    private String nombreHeroe;
    private String identidadSecreta;

    public Superheroe(String nombreHeroe, String identidadSecreta) {
        this.nombreHeroe = nombreHeroe;
        this.identidadSecreta = identidadSecreta;
    }

    public String getNombreHeroe() {
        return nombreHeroe;
    }

    public String getIdentidadSecreta() {
        return identidadSecreta;
    }

    @Override
    public String toString() {
        return "Héroe: " + nombreHeroe + " | Identidad Secreta: " + identidadSecreta;
    }
}
