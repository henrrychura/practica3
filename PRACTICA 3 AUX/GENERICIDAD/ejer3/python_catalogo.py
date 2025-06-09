from typing import TypeVar, Generic, List

T = TypeVar('T')

class Catalogo(Generic[T]):
    def __init__(self):
        self.elementos: List[T] = []

    def agregar(self, elemento: T):
        self.elementos.append(elemento)

    def buscar(self, elemento: T) -> bool:
        return elemento in self.elementos

    def mostrar(self):
        print("Catálogo:", self.elementos)


if __name__ == "__main__":
    print("-------------------- CATÁLOGO CON LIBROS -----------------")
    catalogo_libros = Catalogo[str]()
    catalogo_libros.agregar("Cien años de soledad")
    catalogo_libros.agregar("Don Quijote")
    catalogo_libros.mostrar()
    print("¿Existe 'Don Quijote'?", catalogo_libros.buscar("Don Quijote"))
    print()

    print("------------------ CATÁLOGO CON PRODUCTOS -------------------")
    catalogo_productos = Catalogo[tuple]()
    catalogo_productos.agregar(("P001", "Leche"))
    catalogo_productos.agregar(("P002", "Pan"))
    catalogo_productos.mostrar()
    print("¿Existe ('P001', 'Leche')?", catalogo_productos.buscar(("P001", "Leche")))
