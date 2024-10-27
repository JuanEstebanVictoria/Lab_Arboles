package Arboles;

public class Nodo {

    Nodo izq, der;

    int data;

    public Nodo() {
        this.izq = new Nodo();
        this.der = new Nodo();
        this.data = data;
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
