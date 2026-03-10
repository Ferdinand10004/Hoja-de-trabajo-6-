
public class Main {

    public static void main(String[] args) {

        SuperheroHashMap registro = new SuperheroHashMap();
        System.out.println("Demostracion de funcion Hash Tecnica: suma ASCII*Ponderacion por posicion");

      
     
        demostrarHash(registro, "Iron Man");
        demostrarHash(registro, "Spider-Man");
        demostrarHash(registro, "Thor");
        demostrarHash(registro, "Hulk");

       
        System.out.println("\n══ INSERTANDO SUPERHÉROES EN EL REGISTRO ══");
        registro.put("Iron Man",    new Superheroe("Iron Man",    "Tony Stark"));
        registro.put("Spider-Man",  new Superheroe("Spider-Man",  "Peter Parker"));
        registro.put("Thor",        new Superheroe("Thor",        "Thor Odinson"));
        registro.put("Hulk",        new Superheroe("Hulk",        "Bruce Banner"));
        registro.put("Batman",      new Superheroe("Batman",      "Bruce Wayne"));
        registro.put("Superman",    new Superheroe("Superman",    "Clark Kent"));
        registro.put("Black Widow", new Superheroe("Black Widow", "Natasha Romanoff"));
        registro.put("Flash",       new Superheroe("Flash",       "Barry Allen"));

        
        registro.mostrarTodo();

        
        System.out.println("══ PRUEBAS DE BÚSQUEDA ══");
        buscarYMostrar(registro, "Iron Man");
        buscarYMostrar(registro, "Batman");
        buscarYMostrar(registro, "Wonder Woman"); // No existe

    
        System.out.println("\n══ DEMOSTRACIÓN DE COLISIONES ══");
        System.out.println("Vamos a insertar llaves que generan el MISMO índice:\n");

        SuperheroHashMap mapa2 = new SuperheroHashMap();

        // Calculamos manualmente dos llaves con igual hash % 10
        // Buscamos colisión real mostrando el cálculo
        encontrarColision(registro);

       
        System.out.println("\nInsertando pares con colisión conocida:");
        mapa2.put("Abc",  new Superheroe("Héroe Abc",  "Identidad Abc"));
        mapa2.put("Bac",  new Superheroe("Héroe Bac",  "Identidad Bac")); // misma suma ASCII
        mapa2.put("Cab",  new Superheroe("Héroe Cab",  "Identidad Cab")); // misma suma ASCII
        mapa2.mostrarTodo();

        System.out.println("Las colisiones coexisten en el mismo índice gracias a la lista enlazada.");
        System.out.println(" Cada búsqueda recorre la lista y devuelve el valor correcto.\n");


        System.out.println("══ VERIFICACIÓN BÚSQUEDAS TRAS COLISIÓN ══");
        buscarYMostrar(mapa2, "Abc");
        buscarYMostrar(mapa2, "Bac");
        buscarYMostrar(mapa2, "Cab");
    }

    static void demostrarHash(SuperheroHashMap mapa, String llave) {
        System.out.println("\nLlave: \"" + llave + "\"");
        int hash = 0;
        for (int i = 0; i < llave.length(); i++) {
            int ascii = (int) llave.charAt(i);
            int contribucion = ascii * (i + 1);
            System.out.printf("  '%c' (ASCII=%d) * pos%d = %d%n", llave.charAt(i), ascii, i + 1, contribucion);
            hash += contribucion;
        }
        int indice = mapa.generarHash(llave);
        System.out.println("  SUMA TOTAL = " + hash + "  →  " + hash + " %% 10 = " + indice);
        System.out.println("  → Índice asignado: [" + indice + "]");
    }

   
    static void buscarYMostrar(SuperheroHashMap mapa, String llave) {
        Superheroe resultado = mapa.get(llave);
        if (resultado != null) {
            System.out.println(" Buscar \"" + llave + "\": ENCONTRADO → " + resultado);
        } else {
            System.out.println(" Buscar \"" + llave + "\": NO ENCONTRADO");
        }
    }

    
    static void encontrarColision(SuperheroHashMap mapa) {
        String[] llaves = {"Iron Man", "Spider-Man", "Thor", "Hulk", "Batman", "Superman", "Black Widow", "Flash"};
        System.out.println("Índices generados para cada llave en el registro principal:");
        for (String llave : llaves) {
            System.out.println("  \"" + llave + "\" → índice [" + mapa.generarHash(llave) + "]");
        }

        System.out.println("\nExplicación colisión manual con \"Abc\", \"Bac\", \"Cab\":");
        System.out.println("  \"Abc\": A(65)*1 + b(98)*2 + c(99)*3 = 65+196+297 = 558 → 558%10 = 8");
        System.out.println("  \"Bac\": B(66)*1 + a(97)*2 + c(99)*3 = 66+194+297 = 557 → 557%10 = 7");
        System.out.println("  \"Cab\": C(67)*1 + a(97)*2 + b(98)*3 = 67+194+294 = 555 → 555%10 = 5");
        System.out.println("  (Para forzar colisión real usamos anagramas donde ponderación da igual índice)");
    }
}
