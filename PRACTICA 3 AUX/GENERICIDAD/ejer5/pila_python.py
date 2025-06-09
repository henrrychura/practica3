from typing import TypeVar, Generic, List

T = TypeVar('T')

class Pila(Generic[T]):
    def __init__(self):
        self.elementos: List[T] = []

    def apilar(self, elemento: T):
        self.elementos.append(elemento)

    def desapilar(self) -> T:
        if not self.elementos:
            raise IndexError("La pila está vacía")
        return self.elementos.pop()

    def mostrar(self):
        print("Pila:", self.elementos)


if __name__ == "__main__":
    print("--------PILA CON ENTEROS --------------")
    pila_enteros = Pila[int]()
    pila_enteros.apilar(10)
    pila_enteros.apilar(20)
    pila_enteros.mostrar()
    print("Elemento desapilado:", pila_enteros.desapilar())
    pila_enteros.mostrar()
    print()

    print("---------------------- PILA CON CADENAS ----------------")
    pila_cadenas = Pila[str]()
    pila_cadenas.apilar("uno")
    pila_cadenas.apilar("dos")
    pila_cadenas.mostrar()
    print("Elemento desapilado:", pila_cadenas.desapilar())
    pila_cadenas.mostrar()
