import pickle
import os

class Medicamento:
    def __init__(self, nombre, codigo, tipo, precio):
        self.nombre = nombre
        self.codigo = codigo
        self.tipo = tipo
        self.precio = precio

    def mostrar(self):
        print(f"Nombre: {self.nombre}, Tipo: {self.tipo}, Precio: {self.precio}")

class Farmacia:
    def __init__(self, nombre, sucursal, direccion):
        self.nombreFarmacia = nombre
        self.sucursal = sucursal
        self.direccion = direccion
        self.medicamentos = []

    def agregar_medicamento(self, medicamento):
        self.medicamentos.append(medicamento)

    def mostrar(self):
        print(f"Farmacia: {self.nombreFarmacia}, Sucursal: {self.sucursal}, Dirección: {self.direccion}")
        for m in self.medicamentos:
            m.mostrar()

    def mostrar_medicamentos(self, tipo):
        for m in self.medicamentos:
            if m.tipo.lower() == tipo.lower():
                m.mostrar()

    def buscar_medicamento(self, nombre):
        for m in self.medicamentos:
            if m.nombre.lower() == nombre.lower():
                return True
        return False

class ArchFarmacia:
    def __init__(self, archivo):
        self.archivo = archivo

    def crear_archivo(self):
        with open(self.archivo, "wb") as f:
            pickle.dump([], f)

    def adicionar(self, farmacia):
        lista = self._leer()
        lista.append(farmacia)
        with open(self.archivo, "wb") as f:
            pickle.dump(lista, f)

    def listar(self):
        for f in self._leer():
            f.mostrar()

    def mostrar_medicamentos_tos_sucursal(self, suc):
        for f in self._leer():
            if f.sucursal == suc:
                f.mostrar_medicamentos("tos")

    def mostrar_sucursal_y_direccion_de(self, nombre_med):
        for f in self._leer():
            if f.buscar_medicamento(nombre_med):
                print(f"Sucursal: {f.sucursal}, Dirección: {f.direccion}")

    def _leer(self):
        if not os.path.exists(self.archivo):
            return []
        with open(self.archivo, "rb") as f:
            return pickle.load(f)


if __name__ == "__main__":
    arch = ArchFarmacia("farmacias.dat")
    arch.crear_archivo()

    f1 = Farmacia("Farmacia Central", 1, "Av. Principal")
    f1.agregar_medicamento(Medicamento("Golpex", 101, "tos", 12.5))
    f1.agregar_medicamento(Medicamento("Paracetamol", 102, "resfrio", 5.0))

    arch.adicionar(f1)

    print("\n== Lista de farmacias ==")
    arch.listar()

    print("\n== Medicamentos para la tos (Sucursal 1) ==")
    arch.mostrar_medicamentos_tos_sucursal(1)

    print("\n== Farmacias que tienen 'Golpex' ==")
    arch.mostrar_sucursal_y_direccion_de("Golpex")
