package pila_Generecidad;

import java.util.ArrayList;
import java.util.List;

class Pila<T> {
    private List<T> elementos = new ArrayList<>();

    public void apilar(T elemento) {
        elementos.add(elemento);
    }

    public T desapilar() {
        return !elementos.isEmpty() ? elementos.remove(elementos.size() - 1) : null;
    }

    public void mostrarPila() {
        System.out.println("Elementos en la pila:");
        for (T elemento : elementos) {
            System.out.println(elemento);
        }
    }
}