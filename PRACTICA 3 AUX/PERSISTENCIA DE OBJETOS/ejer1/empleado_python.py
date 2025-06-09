import pickle
import os


class Empleado:
    def __init__(self, nombre: str, edad: int, salario: float):
        self.nombre = nombre
        self.edad = edad
        self.salario = salario

    def __str__(self):
        return f"Empleado(nombre='{self.nombre}', edad={self.edad}, salario={self.salario})"


class ArchivoEmpleado:
    def __init__(self, nomA: str):
        self.nomA = nomA

    def crearArchivo(self):
        with open(self.nomA, "wb") as archivo:
            pickle.dump([], archivo)

    def guardarEmpleado(self, e: Empleado):
        empleados = self._leer()
        empleados.append(e)
        with open(self.nomA, "wb") as archivo:
            pickle.dump(empleados, archivo)

    def buscaEmpleado(self, nombre: str):
        empleados = self._leer()
        for emp in empleados:
            if emp.nombre.lower() == nombre.lower():
                return emp
        return None

    def mayorSalario(self, sueldo: float):
        empleados = self._leer()
        for emp in empleados:
            if emp.salario > sueldo:
                return emp
        return None

    def _leer(self):
        if not os.path.exists(self.nomA):
            return []
        with open(self.nomA, "rb") as archivo:
            return pickle.load(archivo)


def main():
    archivo = ArchivoEmpleado("empleados.dat")

   
    if not os.path.exists("empleados.dat"):
        archivo.crearArchivo()

    
    archivo.guardarEmpleado(Empleado("Carlos", 25, 4000))
    archivo.guardarEmpleado(Empleado("Maria", 30, 6000))
    archivo.guardarEmpleado(Empleado("Luis", 22, 4500))

    
    resultado = archivo.buscaEmpleado("Maria")
    print("Resultado de búsqueda:", resultado)

    
    resultado2 = archivo.mayorSalario(5000)
    print("Primer empleado con salario mayor a 5000:", resultado2)

if __name__ == "__main__":
    main()
