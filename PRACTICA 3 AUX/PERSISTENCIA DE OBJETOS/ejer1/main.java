package empleado_persistencia;

public class main {
    public static void main(String[] args) {
        ArchivoEmpleado archivo = new ArchivoEmpleado("empleados.dat");
        archivo.crearArchivo();

        Empleado e1 = new Empleado("Carlos", 25, 4000f);
        Empleado e2 = new Empleado("María", 30, 6000f);

        archivo.guardarEmpleado(e1);
        archivo.guardarEmpleado(e2);

        System.out.println("Buscar Carlos: " + archivo.buscaEmpleado("Carlos"));
        System.out.println("Buscar salario mayor a 5000: " + archivo.mayorSalario(5000f));
        
        
        archivo.mostrarEmpleados();

    }
}

