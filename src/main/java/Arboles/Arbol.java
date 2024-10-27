package Arboles;

import java.util.LinkedList;
import java.util.Queue;

public class Arbol {

    private Nodo raiz;

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    // Punto 1: Obtener la altura de un árbol
    public int obtenerAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int alturaIzq = obtenerAltura(nodo.izq);
            int alturaDer = obtenerAltura(nodo.der);
            return Math.max(alturaIzq, alturaDer) + 1;
        }
    }

    public int obtenerAltura() {
        return obtenerAltura(raiz);
    }

    // Punto 2: Retornar la altura del árbol sin usar recursividad
    public static int retornarAlturaNoR(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        // Cola para realizar el recorrido en anchura
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(nodo);
        int altura = 0;

        while (!cola.isEmpty()) {
            int tamanioNivel = cola.size();

            for (int i = 0; i < tamanioNivel; i++) {
                Nodo actual = cola.poll();

                if (actual.izq != null) {
                    cola.add(actual.izq);
                }

                if (actual.der != null) {
                    cola.add(actual.der);
                }
            }
            altura++;
        }
        return altura;
    }
}
