package farmacia_persistencia;

public class Main {
    public static void main(String[] args) {
        ArchFarmacia archivo = new ArchFarmacia("farmacias.dat");

        archivo.crearArchivo();
        archivo.adicionar(); 
        archivo.listar();

        System.out.println("Medicamentos para la tos en la sucursal 1:");
        archivo.mostrarMedicamentosTosSucursal(1);

        System.out.println("Farmacias con Golpex:");
        archivo.mostrarSucursalYDireccionDe("Golpex");
    }
}
