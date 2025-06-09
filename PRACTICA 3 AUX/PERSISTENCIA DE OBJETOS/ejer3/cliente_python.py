import pickle
import os


class Cliente:
    def __init__(self, id: int, nombre: str, telefono: int):
        self.id = id
        self.nombre = nombre
        self.telefono = telefono

    def __str__(self):
        return f"Cliente(id={self.id}, nombre='{self.nombre}', telefono={self.telefono})"


class ArchivoCliente:
    def __init__(self, nomA: str):
        self.nomA = nomA

    def crearArchivo(self):
        with open(self.nomA, "wb") as archivo:
            pickle.dump([], archivo)

    def guardarCliente(self, c: Cliente):
        clientes = self._leer()
        clientes.append(c)
        with open(self.nomA, "wb") as archivo:
            pickle.dump(clientes, archivo)

    def buscarCliente(self, c: int):
        clientes = self._leer()
        for cli in clientes:
            if cli.id == c:
                return cli
        return None

    def buscarCelularCliente(self, c: int):
        cliente = self.buscarCliente(c)
        if cliente:
            return f"{cliente} - Celular: {cliente.telefono}"
        return None

    def _leer(self):
        if not os.path.exists(self.nomA):
            return []
        with open(self.nomA, "rb") as archivo:
            return pickle.load(archivo)


def main():
    archivo = ArchivoCliente("clientes.dat")


    if not os.path.exists("clientes.dat"):
        archivo.crearArchivo()


    archivo.guardarCliente(Cliente(1, "Juan", 77712345))
    archivo.guardarCliente(Cliente(2, "Ana", 79999888))
    archivo.guardarCliente(Cliente(3, "Carlos", 75555111))


    encontrado = archivo.buscarCliente(2)
    print("Cliente encontrado:", encontrado)


    info = archivo.buscarCelularCliente(3)
    print("Datos con celular:", info)

if __name__ == "__main__":
    main()
