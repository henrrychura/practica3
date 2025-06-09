package catalogosGenerecidad;

public class Main {
    public static void main(String[] args) {
        // libros
        Catalogo<Libro> catalogoLibros = new Catalogo<>();
        catalogoLibros.agregar(new Libro("El principito"));
        catalogoLibros.agregar(new Libro("Cien años de soledad"));
        System.out.println("Catálogo de libros:");
        catalogoLibros.mostrar();
        
        Libro lib = catalogoLibros.buscar(1);
        System.out.println("el libro buscado es: "+lib);
        
        
        
        //productos
        Catalogo<Producto> catalogoProductos = new Catalogo<>();
        catalogoProductos.agregar(new Producto("Laptop", 1200.50));
        catalogoProductos.agregar(new Producto("Mouse", 25.99));
        System.out.println("\nCatálogo de productos:");
        catalogoProductos.mostrar();
        
        Producto prod = catalogoProductos.buscar(0);
        System.out.println("el producto buscado es: "+prod);
    }
}

