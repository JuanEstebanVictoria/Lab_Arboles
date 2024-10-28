package Controller;

import Arboles.Arbol;
import Arboles.ArbolVisual;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ArbolController {

    @FXML
    private ComboBox<String> comboBoxArbol1;

    @FXML
    private ComboBox<String> comboBoxArbol2;

    @FXML
    private TextArea resultadoArbol1;

    @FXML
    private TextArea resultadoArbol2;

    @FXML
    private TextField inputEliminarArbol1;

    @FXML
    private TextField inputEliminarArbol2;

    @FXML
    private TextField numeroArbol1;

    @FXML
    private TextField numeroArbol2;

    @FXML
    private Pane panelArbol1;

    @FXML
    private Pane panelArbol2;

    private Arbol arbol1;
    private Arbol arbol2;
    private ArbolVisual visualizador1;
    private ArbolVisual visualizador2;

    @FXML
    public void initialize() {

        comboBoxArbol1.getItems().clear();
        comboBoxArbol2.getItems().clear();

        // Inicialización de los ComboBox
        comboBoxArbol1.getItems().addAll("Obtener altura",
                "Valor más pequeño recursivo", "Valor más pequeño no recursivo",
                "Verificar igualdad de árboles", "Recorrer en amplitud", "Obtener altura sin recursividad");

        comboBoxArbol2.getItems().addAll("Obtener altura",
                "Valor más pequeño recursivo", "Valor más pequeño no recursivo",
                "Verificar igualdad de árboles", "Recorrer en amplitud", "Obtener altura sin recursividad");

        arbol1 = new Arbol();
        arbol2 = new Arbol();
        visualizador1 = new ArbolVisual(arbol1);
        visualizador2 = new ArbolVisual(arbol2);

        panelArbol1.getChildren().add(visualizador1);
        panelArbol2.getChildren().add(visualizador2);

        comboBoxArbol1.setOnAction(event -> manejarSeleccionComboBoxArbol1());
        comboBoxArbol2.setOnAction(event -> manejarSeleccionComboBoxArbol2());
    }

    @FXML
    private void agregarNumeroArbol1() {
        try {
            int valor = Integer.parseInt(numeroArbol1.getText());
            arbol1.insertar(valor);
            resultadoArbol1.appendText("Número " + valor + " agregado al árbol 1\n");
            numeroArbol1.clear();
            visualizador1.actualizarVisualizacion();
        } catch (NumberFormatException e) {
            mostrarError("Por favor, ingrese un número válido", resultadoArbol1);
        }
    }

    @FXML
    private void agregarNumeroArbol2() {
        try {
            int valor = Integer.parseInt(numeroArbol2.getText());
            arbol2.insertar(valor);
            resultadoArbol2.appendText("Número " + valor + " agregado al árbol 2\n");
            numeroArbol2.clear();
            visualizador2.actualizarVisualizacion();
        } catch (NumberFormatException e) {
            mostrarError("Por favor, ingrese un número válido", resultadoArbol2);
        }
    }

    @FXML
    private void eliminarNumeroArbol1() {
        try {
            int valor = Integer.parseInt(inputEliminarArbol1.getText());
            arbol1.eliminar(valor);
            resultadoArbol1.appendText("Número " + valor + " eliminado del árbol 1\n");
            inputEliminarArbol1.clear();
            visualizador1.actualizarVisualizacion();
        } catch (NumberFormatException e) {
            mostrarError("Por favor, ingrese un número válido", resultadoArbol1);
        }
    }

    @FXML
    private void eliminarNumeroArbol2() {
        try {
            int valor = Integer.parseInt(inputEliminarArbol2.getText());
            arbol2.eliminar(valor);
            resultadoArbol2.appendText("Número " + valor + " eliminado del árbol 2\n");
            inputEliminarArbol2.clear();
            visualizador2.actualizarVisualizacion();
        } catch (NumberFormatException e) {
            mostrarError("Por favor, ingrese un número válido", resultadoArbol2);
        }
    }

    @FXML
    private void manejarSeleccionComboBoxArbol1() {
        String seleccion = comboBoxArbol1.getValue();
        if (seleccion == null) return;

        switch (seleccion) {
            case "Valor más pequeño recursivo":
                encontrarValorMinimoRecursivoArbol1();
                break;
            case "Valor más pequeño no recursivo":
                encontrarValorMinimoNoRecursivoArbol1();
                break;
            case "Verificar igualdad de árboles":
                verificarIgualdadArboles();
                break;
            case "Obtener altura":
                obtenerAlturaArbol1();
                break;
            case "Recorrer en amplitud":
                recorrerArbol1EnAmplitud();
                break;
            case "Obtener altura sin recursividad":
                obtenerAlturaSinRecursividadArbol1();
                break;
        }
    }

    @FXML
    private void manejarSeleccionComboBoxArbol2() {
        String seleccion = comboBoxArbol2.getValue();
        if (seleccion == null) return;

        switch (seleccion) {
            case "Valor más pequeño recursivo":
                encontrarValorMinimoRecursivoArbol2();
                break;
            case "Valor más pequeño no recursivo":
                encontrarValorMinimoRecursivoArbol2();
                break;
            case "Verificar igualdad de árboles":
                verificarIgualdadArboles();
                break;
            case "Obtener altura":
                obtenerAlturaArbol2();
                break;
            case "Recorrer en amplitud":
                recorrerArbol2EnAmplitud();
                break;
            case "Obtener altura sin recursividad":
                obtenerAlturaSinRecursividadArbol2();
                break;
        }
    }

    private void mostrarError(String mensaje, TextArea areaTexto) {
        areaTexto.setText(mensaje);
    }

    @FXML
    private void encontrarValorMinimoRecursivoArbol1() {
        try {
            int valorMinimo = arbol1.valorMinimoRecursivo();
            resultadoArbol1.appendText("El valor mínimo recursivo en el árbol 1 es: " + valorMinimo + "\n");
        } catch (IllegalStateException e) {
            mostrarError(e.getMessage(), resultadoArbol1);
        }
    }

    @FXML
    private void encontrarValorMinimoNoRecursivoArbol1() {
        try {
            int valorMinimo = arbol1.valorMinimoNoRecursivo();
            resultadoArbol1.appendText("El valor mínimo no recursivo en el árbol 1 es: " + valorMinimo + "\n");
        } catch (IllegalStateException e) {
            mostrarError(e.getMessage(), resultadoArbol1);
        }
    }

    @FXML
    private void encontrarValorMinimoRecursivoArbol2() {
        try {
            int valorMinimo = arbol2.valorMinimoRecursivo();
            resultadoArbol2.appendText("El valor mínimo recursivo en el árbol 2 es: " + valorMinimo + "\n");
        } catch (IllegalStateException e) {
            mostrarError(e.getMessage(), resultadoArbol2);
        }
    }

    @FXML
    private void verificarIgualdadArboles() {
        boolean iguales = arbol1.determinarArbolesIguales(arbol2);
        resultadoArbol1.clear();
        resultadoArbol2.clear();

        if (iguales) {
            resultadoArbol1.appendText("Los árboles son iguales.\n");
            resultadoArbol2.appendText("Los árboles son iguales.\n");
            visualizador1.setStyle("-fx-background-color: lightgreen;"); // Resaltar árbol 1
            visualizador2.setStyle("-fx-background-color: lightgreen;"); // Resaltar árbol 2
        } else {
            resultadoArbol1.appendText("Los árboles no son iguales.\n");
            resultadoArbol2.appendText("Los árboles no son iguales.\n");
            visualizador1.setStyle("-fx-background-color: lightcoral;"); // Resaltar árbol 1
            visualizador2.setStyle("-fx-background-color: lightcoral;"); // Resaltar árbol 2
        }

        visualizador1.actualizarVisualizacion();
        visualizador2.actualizarVisualizacion();
    }

    @FXML
    private void obtenerAlturaArbol1() {
        int altura = arbol1.obtenerAltura();
        resultadoArbol1.appendText("La altura del árbol 1 es: " + altura + "\n");
    }

    @FXML
    private void obtenerAlturaArbol2() {
        int altura = arbol2.obtenerAltura();
        resultadoArbol2.appendText("La altura del árbol 2 es: " + altura + "\n");
    }

    @FXML
    private void recorrerArbol1EnAmplitud() {
        String resultado = arbol1.recorridoAmplitud();
        resultadoArbol1.appendText("Recorrido en amplitud del árbol 1: " + resultado + "\n");
    }

    @FXML
    private void recorrerArbol2EnAmplitud() {
        String resultado = arbol2.recorridoAmplitud();
        resultadoArbol2.appendText("Recorrido en amplitud del árbol 2: " + resultado + "\n");
    }

    @FXML
    private void obtenerAlturaSinRecursividadArbol1() {
        int altura = Arbol.retornarAlturaNoR(arbol1.getRaiz());
        resultadoArbol1.appendText("La altura del árbol 1 sin recursividad es: " + altura + "\n");
    }

    @FXML
    private void obtenerAlturaSinRecursividadArbol2() {
        int altura = Arbol.retornarAlturaNoR(arbol2.getRaiz());
        resultadoArbol2.appendText("La altura del árbol 2 sin recursividad es: " + altura + "\n");
    }

    @FXML
    private void manejarNivelArbol1() {
        try {
            int valor = Integer.parseInt(numeroArbol1.getText());
            int nivel = arbol1.determinarNivel(valor);
            if (nivel != -1) {
                resultadoArbol1.appendText("El nivel del valor " + valor + " en el árbol 1 es: " + nivel + "\n");
            } else {
                resultadoArbol1.appendText("El valor " + valor + " no se encuentra en el árbol 1.\n");
            }
        } catch (NumberFormatException e) {
            mostrarError("Por favor, ingrese un número válido", resultadoArbol1);
        }
    }

    @FXML
    private void manejarNivelArbol2() {
        try {
            int valor = Integer.parseInt(numeroArbol2.getText());
            int nivel = arbol2.determinarNivel(valor);
            if (nivel != -1) {
                resultadoArbol2.appendText("El nivel del valor " + valor + " en el árbol 2 es: " + nivel + "\n");
            } else {
                resultadoArbol2.appendText("El valor " + valor + " no se encuentra en el árbol 2.\n");
            }
        } catch (NumberFormatException e) {
            mostrarError("Por favor, ingrese un número válido", resultadoArbol2);
        }
    }
}
