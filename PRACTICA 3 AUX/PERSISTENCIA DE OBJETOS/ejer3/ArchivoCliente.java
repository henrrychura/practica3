package cliente_Persistencia;



import java.io.*;
import java.util.ArrayList;

public class ArchivoCliente {
    private String nomA;

    public ArchivoCliente(String nomA) {
        this.nomA = nomA;
    }

    public void crearArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(new ArrayList<Cliente>());
        } catch (IOException e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }

    public void guardarCliente(Cliente c) {
        ArrayList<Cliente> lista = leer();
        lista.add(c);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(lista);
        } catch (IOException e1) {
            System.out.println("Error al guardar cliente: " + e1.getMessage());
        }
    }

    public Cliente buscarCliente(int id) {
        ArrayList<Cliente> lista = leer();
        for (Cliente c : lista) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public Cliente buscarCelularCliente(int id) {
        return buscarCliente(id);
    }

    @SuppressWarnings("unchecked")
    private ArrayList<Cliente> leer() {
        ArrayList<Cliente> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomA))) {
            lista = (ArrayList<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
        return lista;
    }
}

