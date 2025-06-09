package caja_genericidad;

public class Main {

	public static void main(String[] args) {
		//primera instancia integer
	Caja<Integer> num = new Caja<>();
	num.guardar(23);
	System.out.println(num.obtener());
	//segunda instancia String
	Caja<String> let = new Caja<>();
	let.guardar("hola");
	System.out.println(let.obtener());
	}
}
