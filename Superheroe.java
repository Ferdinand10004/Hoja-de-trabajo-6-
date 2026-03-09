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
        return "Heroe: " + nombreHeroe + " | Identidad Secreta: " + identidadSecreta;
    }
}