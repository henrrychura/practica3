package catalogosGenerecidad;

import java.util.*;
public class Catalogo<T>{
	ArrayList<T> v;
	
	public Catalogo() {
		this.v=new ArrayList<>();
	}
	
	public void agregar(T valor) {
		v.add(valor);
	}
	
	public T buscar(int i) {
		if(i>=0 && i<v.size()) {
			return v.get(i);
		}
	return null;
	
	}
	public void mostrar() {
		for(T va : v) {
			System.out.println(va);
		}
	}
}
