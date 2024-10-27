package Arboles;

public class Nodo {

    Nodo izq;
    Nodo der;
    int data;

    public Nodo() {
        this.izq = null; // Inicializar a null
        this.der = null; // Inicializar a null
        this.data = 0;   // Inicializar data a 0
    }

    public Nodo(int data) {
        this.izq = null; // Inicializar a null
        this.der = null; // Inicializar a null
        this.data = data;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
