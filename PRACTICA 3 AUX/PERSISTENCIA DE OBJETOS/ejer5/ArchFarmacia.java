package farmacia_persistencia;

import java.io.*;
import java.util.ArrayList;

public class ArchFarmacia {
    private String na;

    public ArchFarmacia(String na) {
        this.na = na;
    }

    public void crearArchivo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(na));
            oos.writeObject(new ArrayList<Farmacia>());
            oos.close();
        } catch (IOException e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }

    public void adicionar() {
        ArrayList<Farmacia> lista = leer();
        Farmacia f = new Farmacia();
        f.leer();
        lista.add(f);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(na));
            oos.writeObject(lista);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void listar() {
        ArrayList<Farmacia> lista = leer();
        for (Farmacia f : lista) {
            f.mostrar();
        }
    }

    public void mostrarMedicamentosTosSucursal(int sucursal) {
        ArrayList<Farmacia> lista = leer();
        for (Farmacia f : lista) {
            if (f.getSucursal() == sucursal) {
                f.mostrarMedicamentos("tos");
            }
        }
    }

    public void mostrarSucursalYDireccionDe(String medicamento) {
        ArrayList<Farmacia> lista = leer();
        for (Farmacia f : lista) {
            if (f.buscaMedicamento(medicamento)) {
                System.out.println("Sucursal: " + f.getSucursal() + ", Dirección: " + f.getDireccion());
            }
        }
    }

    public double precioMedicamentoTos() {
        ArrayList<Farmacia> lista = leer();
        double total = 0;
        for (Farmacia f : lista) {
            total += f.precioMedicamentoTos();
        }
        return total;
    }

    @SuppressWarnings("unchecked")
    private ArrayList<Farmacia> leer() {
        ArrayList<Farmacia> lista = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(na));
            lista = (ArrayList<Farmacia>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Archivo vacío o no existe.");
        }
        return lista;
    }
}
