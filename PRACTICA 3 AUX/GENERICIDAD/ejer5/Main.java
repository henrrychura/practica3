package pila_Generecidad;

import java.util.Stack;

public class Main {
	 public static void main(String[] args) {
	// Prueba con Strings
    Pila<String> pilaString = new Pila<>();
    pilaString.apilar("Hola");
    pilaString.apilar("Mundo");
    pilaString.mostrarPila();
    System.out.println("\nDesapilando: " + pilaString.desapilar());
    pilaString.mostrarPila();

    //Prueba con Integer
    Pila<Integer> pilaEnteros = new Pila<>();
    pilaEnteros.apilar(10);
    pilaEnteros.apilar(20);
    pilaEnteros.mostrarPila();
    System.out.println("\nDesapilando: " + pilaEnteros.desapilar());
    pilaEnteros.mostrarPila();
	
}
}