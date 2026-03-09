public class NodoLista {
    String llave;
    Superheroe valor;
    NodoLista siguiente;

    public NodoLista(String llave, Superheroe valor) {
        this.llave = llave;
        this.valor = valor;
        this.siguiente = null;
    }
}