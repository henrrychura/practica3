package cliente_Persistencia;


public class Main {
	    public static void main(String[] args) {
	        ArchivoCliente archivo = new ArchivoCliente("clientes.dat");

	        archivo.crearArchivo();

	        archivo.guardarCliente(new Cliente(1, "Juan", 76543210));
	        archivo.guardarCliente(new Cliente(2, "Ana", 78901234));
	        archivo.guardarCliente(new Cliente(3, "Luis", 71234567));

	        System.out.println("Buscar cliente con ID 2:");
	        System.out.println(archivo.buscarCliente(2));

	        System.out.println("Buscar celular del cliente con ID 3:");
	        Cliente c = archivo.buscarCelularCliente(3);
	        if (c != null) {
	            System.out.println("Cliente: " + c + ", Celular: " + c.getTelefono());
	        }
	    }
	}

