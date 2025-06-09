package empleado_persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoEmpleado {
    private String nomA;

    public ArchivoEmpleado(String nomA) {
        this.nomA = nomA;
    }

    public void crearArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            // Creamos archivo vacío con lista vacía
            oos.writeObject(new ArrayList<Empleado>());
        } catch (IOException e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }

    public void guardarEmpleado(Empleado e) {
        try {
            ArrayList<Empleado> empleados = leerEmpleados();
            empleados.add(e);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA));
            oos.writeObject(empleados);
            oos.close();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al guardar empleado: " + ex.getMessage());
        }
    }

    public Empleado buscaEmpleado(String n) {
        try {
            ArrayList<Empleado> empleados = leerEmpleados();
            for (Empleado emp : empleados) {
                if (emp.getNombre().equalsIgnoreCase(n)) {
                    return emp;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar empleado: " + e.getMessage());
        }
        return null;
    }

    public Empleado mayorSalario(float sueldo) {
        try {
            ArrayList<Empleado> empleados = leerEmpleados();
            for (Empleado emp : empleados) {
                if (emp.getSalario() > sueldo) {
                    return emp;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar mayor salario: " + e.getMessage());
        }
        return null;
    }


    private ArrayList<Empleado> leerEmpleados() throws IOException, ClassNotFoundException {
        File archivo = new File(nomA);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomA));
        ArrayList<Empleado> empleados = (ArrayList<Empleado>) ois.readObject();
        ois.close();
        return empleados;
    }
    
    public void mostrarEmpleados() {
        try {
            ArrayList<Empleado> empleados = leerEmpleados();
            if (empleados.isEmpty()) {
                System.out.println("No hay empleados registrados.");
            } else {
                System.out.println("Empleados en archivo:");
                for (Empleado emp : empleados) {
                    System.out.println(emp);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer empleados: " + e.getMessage());
        }
    }

	

    
    
    
    
}

