package BMC_Modelo;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Stock {
	
	private ArrayList<Producto> todosLosProductos = new ArrayList<Producto>();
	
	public void registrarProducto(Producto p) {
		
				todosLosProductos.add(p);
		
	}
	
	
	public ArrayList<Producto> todosLosProductosDeUnaCategoria(String Categoria) {
		
		ArrayList<Producto> unaCategoria = new ArrayList<Producto>();
		
		for (Producto producto : todosLosProductos) {
			
			if (producto.getCategoria().contentEquals(Categoria)) {
				
				unaCategoria.add(producto);
				
			}
		}
		return unaCategoria;
	}
	
	public ArrayList<Producto> getTodosLosProductos(){
		return todosLosProductos;
	}

	
	public void borrarProducto(Producto prod) {
		for(Producto p: todosLosProductos) {
			if(p.getId() == prod.getId()) {
				todosLosProductos.remove(p);
			}
		}
	}
}
