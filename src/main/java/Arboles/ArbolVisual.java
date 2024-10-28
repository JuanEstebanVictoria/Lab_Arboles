package Arboles;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ArbolVisual extends Pane {
    private Arbol arbol;
    private static final double RADIO = 20;
    private static final double V_GAP = 50;

    public ArbolVisual(Arbol arbol) {
        this.arbol = arbol;
        setMinSize(400, 300);
    }

    public void mostrarArbol() {
        getChildren().clear();
        if (arbol.getRaiz() != null) {
            mostrarArbol(arbol.getRaiz(), getWidth() / 2, RADIO + 10, getWidth() / 4);
        }
    }

    public void actualizarVisualizacion() {
        mostrarArbol();
    }

    private void mostrarArbol(Nodo nodo, double x, double y, double hGap) {
        // Dibujar círculo
        Circle circulo = new Circle(x, y, RADIO);
        circulo.setFill(Color.WHITE);
        circulo.setStroke(Color.BLACK);

        // Agregar texto (valor del nodo)
        Text texto = new Text(x - 6, y + 4, nodo.getData() + "");

        if (nodo.getIzq() != null) {

            double endX = x - hGap;
            double endY = y + V_GAP;

            Line linea = new Line(x, y + RADIO, endX, endY - RADIO);
            getChildren().add(linea);

            mostrarArbol(nodo.getIzq(), endX, endY, hGap / 2);
        }

        if (nodo.getDer() != null) {

            double endX = x + hGap;
            double endY = y + V_GAP;

            Line linea = new Line(x, y + RADIO, endX, endY - RADIO);
            getChildren().add(linea);

            mostrarArbol(nodo.getDer(), endX, endY, hGap / 2);
        }

        getChildren().addAll(circulo, texto);
    }
}
