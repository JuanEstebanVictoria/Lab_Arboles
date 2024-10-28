package Arboles;

public class Nodo {

    public Nodo izq, der;
    public int data;

    public Nodo(int data) {
        this.data = data;
        this.izq = null;
        this.der = null;
    }

    public Nodo getIzq() {
        return izq;
    }

    public Nodo getDer() {
        return der;
    }

    public int getData() {
        return data;
    }
}
