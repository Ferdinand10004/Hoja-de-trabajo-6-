public class ListaEnlazada {
    private NodoLista cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    
    public void insertar(String llave, Superheroe valor) {
        NodoLista actual = cabeza;

        while (actual != null) {
            if (actual.llave.equals(llave)) {
                actual.valor = valor;
                return;
            }
            actual = actual.siguiente;
        }

        NodoLista nuevo = new NodoLista(llave, valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }
    
    public Superheroe buscar(String llave) {
        NodoLista actual = cabeza;

        while (actual != null) {
            if (actual.llave.equals(llave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }

        return null;
    }
    
    public void mostrar() {
        NodoLista actual = cabeza;

        while (actual != null) {
            System.out.println("  Llave: \"" + actual.llave + "\" -> " + actual.valor);
            actual = actual.siguiente;
        }
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
}