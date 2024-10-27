package Arboles;

import java.util.LinkedList;
import java.util.Queue;

public class Arbol {

    private Nodo raiz;

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    /**
     *  Punto 1: Obtener la altura de un árbol
     * 
     */  
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

    
    /**
     * Punto 2: Retorna el nivel de un elemento en el árbol.
     *
     */
    public int determinarNivel(Nodo nodo, int valor, int nivel) {

        if(nodo == null){
            return -1;
        }
        if(nodo.data==valor){
            return nivel;
        }
        int nivelIzq= determinarNivel(nodo.izq, valor, nivel+1);
        if(nivelIzq!=-1){
            return nivelIzq;
        }
        return determinarNivel(nodo.der, valor, nivel+1);

    }

    public int determinarNivel(int valor){
        return determinarNivel(raiz, valor, 0);
    }
    
    /**
     * Punto 3: Retorna el nivel de un elemento en el árbol.
     *
     */


    /**
     * Punto 4:Obtener el valor más pequeño que esté guardado en el árbol. (no recursivo y recursivo)
     * 
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

    /**
     * Punto 5: Imprimir un árbol de manera horizontal. ejemplo:
     * 
     */

     /**
     * Punto 6: Elimine un elemento del árbol.
     * 
     */
    

    /**
     * Punto 7:Verificar si dos árboles son idénticos.
     * 
     */
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

    /*
     * Punto 8: Recorrido en amplitud (use una Cola).
     * 
     */

    /*
     * Punto 9: Retornar la altura del árbol sin usar recursividad
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

}
