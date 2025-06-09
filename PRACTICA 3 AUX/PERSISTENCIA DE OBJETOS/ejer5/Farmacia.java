package farmacia_persistencia;

import java.io.Serializable;
import java.util.Scanner;

public class Farmacia implements Serializable {
    private String nombreFarmacia;
    private int sucursal;
    private String direccion;
    private int nroMedicamentos;
    private Medicamento[] m = new Medicamento[100];

    public Farmacia() {}

    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de la farmacia: ");
        nombreFarmacia = sc.nextLine();
        System.out.print("Sucursal: ");
        sucursal = sc.nextInt();
        sc.nextLine();
        System.out.print("Dirección: ");
        direccion = sc.nextLine();
        System.out.print("Cantidad de medicamentos: ");
        nroMedicamentos = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nroMedicamentos; i++) {
            m[i] = new Medicamento();
            m[i].leer();
        }
    }

    public void mostrar() {
        System.out.println("Farmacia: " + nombreFarmacia + ", Sucursal: " + sucursal + ", Dirección: " + direccion);
        for (int i = 0; i < nroMedicamentos; i++) {
            m[i].mostrar();
        }
    }

    public int getSucursal() {
        return sucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void mostrarMedicamentos(String tipo) {
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getTipo().equalsIgnoreCase(tipo)) {
                m[i].mostrar();
            }
        }
    }

    public boolean buscaMedicamento(String nombre) {
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public double precioMedicamentoTos() {
        double suma = 0;
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getTipo().equalsIgnoreCase("tos")) {
                suma += m[i].getPrecio();
            }
        }
        return suma;
    }
}
