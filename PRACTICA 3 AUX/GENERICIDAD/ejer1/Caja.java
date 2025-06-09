package caja_genericidad;


public class Caja <T>{
	T contenido ;
	
	

	
	public void guardar( T contenido) {
		this.contenido=contenido;
	}
	
	public T obtener() {
	return contenido;
	}
}
