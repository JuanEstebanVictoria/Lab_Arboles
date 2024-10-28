package Arboles;

import java.util.LinkedList;
import java.util.Queue;

public class Arbol {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo nodo, int valor) {
        // Caso base: si el árbol está vacío, insertar aquí
        if (nodo == null) {
            nodo = new Nodo(valor);
            return nodo;
        }

        if (valor < nodo.data) {
            nodo.izq = insertarRec(nodo.izq, valor);
        } else if (valor > nodo.data) {
            nodo.der = insertarRec(nodo.der, valor);
        }

        return nodo;
    }

    public boolean existe(int valor) {
        return existeRec(raiz, valor);
    }

    private boolean existeRec(Nodo nodo, int valor) {
        if (nodo == null) {
            return false;
        }
        if (nodo.data == valor) {
            return true;
        }
        return valor < nodo.data ? existeRec(nodo.izq, valor) : existeRec(nodo.der, valor);
    }

    // Método público para eliminar un nodo
    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    // Método recursivo para eliminar un nodo
    private Nodo eliminarRec(Nodo nodo, int valor) {
        if (nodo == null) {
            return null;
        }
        if (valor < nodo.data) {
            nodo.izq = eliminarRec(nodo.izq, valor);
        } else if (valor > nodo.data) {
            nodo.der = eliminarRec(nodo.der, valor);
        } else {
            if (nodo.izq == null) {
                return nodo.der;
            } else if (nodo.der == null) {
                return nodo.izq;
            }
            nodo.data = encontrarMinimo(nodo.der);
            nodo.der = eliminarRec(nodo.der, nodo.data);
        }
        return nodo;
    }

    // Método auxiliar para encontrar el valor mínimo en un árbol
    private int encontrarMinimo(Nodo nodo) {
        int minimo = nodo.data;
        while (nodo.izq != null) {
            minimo = nodo.izq.data;
            nodo = nodo.izq;
        }
        return minimo;
    }
    /**
     * Punto 4
     */
    // Método recursivo
    public int valorMinimoRecursivo(Nodo nodo) {
        if (nodo.izq == null) {
            return nodo.data;
        }
        return valorMinimoRecursivo(nodo.izq);
    }

    public int valorMinimoRecursivo() {
        if (raiz == null) {
            throw new IllegalStateException("El árbol está vacío");
        }
        return valorMinimoRecursivo(raiz);
    }

    // Método no recursivo
    public int valorMinimoNoRecursivo() {
        if (raiz == null) {
            throw new IllegalStateException("El árbol está vacío");
        }

        Nodo actual = raiz;
        while (actual.izq != null) {
            actual = actual.izq;
        }
        return actual.data;
    }

    public boolean determinarArbolesIguales(Nodo raiz1, Nodo raiz2){


        if(raiz1==null && raiz2==null) {
            return true;
        }
        if(raiz1==null || raiz2==null){
            return false;
        }
        return (raiz1.data == raiz2.data)
                && determinarArbolesIguales(raiz1.izq,raiz2.izq)
                && determinarArbolesIguales(raiz1.der, raiz2.der);
    }
    public boolean determinarArbolesIguales(Arbol otro){
        return determinarArbolesIguales(this.raiz,otro.raiz);
    }
    /**
     * Punto 1
     */
    public int obtenerAltura(Nodo nodo){
        if(nodo== null){
            return 0;
        }
        int alturaIzq= obtenerAltura(nodo.izq);
        int alturaDer= obtenerAltura(nodo.der);


        return Math.max(alturaIzq,alturaDer)+1;
    }

    public int obtenerAltura(){
        return obtenerAltura(raiz);
    }
    /**
     * Punto 8
     */
    public String recorridoAmplitud() {
        if (raiz == null) {
            return "El árbol está vacío.";
        }

        StringBuilder resultado = new StringBuilder();
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            resultado.append(actual.data).append(" ");

            if (actual.izq != null) {
                cola.add(actual.izq);
            }
            if (actual.der != null) {
                cola.add(actual.der);
            }
        }

        return resultado.toString().trim();
    }
    /*
     * Punto 9
     *
     */
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
    /**
     * Punto 2
     *
     */
    public int determinarNivel(Nodo nodo, int valor, int nivel) {
        if (nodo == null) {
            return -1; // No encontrado
        }
        System.out.println("Revisando nodo: " + nodo.data + ", nivel: " + nivel); // Depuración
        if (nodo.data == valor) {
            return nivel; // Encontrado
        }
        int nivelIzq = determinarNivel(nodo.izq, valor, nivel + 1);
        if (nivelIzq != -1) {
            return nivelIzq; // Encontrado en la izquierda
        }
        return determinarNivel(nodo.der, valor, nivel + 1); // Buscar en la derecha
    }

    public int determinarNivel(int valor){
        return determinarNivel(raiz, valor, 0);
    }

}
