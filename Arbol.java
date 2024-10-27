package Arboles;

public class Arbol {

    Nodo raiz;
    
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
}
