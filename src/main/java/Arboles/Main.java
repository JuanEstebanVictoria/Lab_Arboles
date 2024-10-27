package Arboles;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Crear nodos
        Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        Nodo nodo3 = new Nodo(3);
        Nodo nodo4 = new Nodo(4);
        Nodo nodo5 = new Nodo(5);

        // Construir el árbol
        nodo1.setIzq(nodo2);
        nodo1.setDer(nodo3);
        nodo2.setIzq(nodo4);
        nodo2.setDer(nodo5);

        // Crear la instancia del árbol
        Arbol arbol = new Arbol(nodo1);

        // Obtener altura del árbol de manera recursiva
        int alturaRecursiva = arbol.obtenerAltura();
        JOptionPane.showMessageDialog(null, "Altura del árbol (recursiva): " + alturaRecursiva);
        //System.out.println("Altura del árbol (recursiva): " + alturaRecursiva);

        // Obtener altura del árbol de manera no recursiva
        int alturaNoRecursiva = Arbol.retornarAlturaNoR(nodo1);
        JOptionPane.showMessageDialog(null, "Altura del árbol (no recursiva): " + alturaNoRecursiva);
    }
}
