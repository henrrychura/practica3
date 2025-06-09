from typing import Generic, TypeVar

T = TypeVar('T')

class Caja(Generic[T]):
    def __init__(self):
        self.objeto = None

    def guardar(self, obj: T):
        self.objeto = obj

    def obtener(self) -> T:
        return self.objeto

    def mostrar(self):
        print(f"Contenido de la caja: {self.objeto}")
caja1 = Caja[int]()
caja1.guardar(42)

caja2 = Caja[str]()
caja2.guardar("Hola mundo")

caja1.mostrar()  
caja2.mostrar()  
