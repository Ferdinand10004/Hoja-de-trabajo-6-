public class FuncionHash {
    private int capacidad;
    private static final int CONSTANTE_BASE = 10;
    private static final int CONSTANTE_J = 74; // ASCII de 'J'

    public FuncionHash(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public int generarHash(String llave) {
        if (llave == null || llave.isEmpty()) {
            return 0;
        }

        long hash = 1;

        for (int i = 0; i < llave.length(); i++) {
            int ascii = llave.charAt(i);

            if (i % 2 == 0) {
                hash = hash + (ascii * CONSTANTE_BASE);
            } else {
                hash = hash * (ascii + CONSTANTE_J);
            }
        }

        return (int) (Math.abs(hash) % capacidad);
    }
}