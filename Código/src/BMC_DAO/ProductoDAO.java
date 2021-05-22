package BMC_DAO;
import java.sql.*;
import java.util.ArrayList;

import BMC_Modelo.Producto;

public class ProductoDAO {

	
	public void ALTA(Producto p) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		long id = p.getId();
		String nombre = p.getNombre(); 
		String marca = p.getMarca(); 
		String descripcionDelProducto = p.getDescripcionDelProducto(); 
		String categoria = p.getCategoria(); 
		float precioDeCompra = p.getPrecioDeCompra(); 
		float precioDeVenta = p.getPrecioDeVenta(); 
		int cantidad = p.getCantidad();
		
		try {
				
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO productos VALUES (?,?,?,?,?,?,?,?)");
		
			stmt.setLong(1, id);
			stmt.setString(2, nombre);
			stmt.setString(3, marca);
			stmt.setString(4, descripcionDelProducto);
			stmt.setString(5, categoria);
			stmt.setFloat(6, precioDeCompra);
			stmt.setFloat(7, precioDeVenta);
			stmt.setInt(8, cantidad);
		
			stmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
        }
		
		
	}
	
	public void MODIFICACION(long id, String nombre, String marca, String descripcion,String categoria, float precioDeCompra, float precioDeVenta, int cantidad) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		try {
	
			PreparedStatement stmt = conn.prepareStatement("UPDATE productos SET nombre = ?, marca = ?, descripcion = ?, categoria = ?, precio_compra = ?, precio_venta = ?, cantidad = ? WHERE id = ?");
			
			
			stmt.setString(1, nombre);
			stmt.setString(2, marca);
			stmt.setString(3, descripcion);
			stmt.setString(4, categoria);
			stmt.setFloat(5, precioDeCompra);
			stmt.setFloat(6, precioDeVenta);
			stmt.setInt(7, cantidad);
			stmt.setLong(8, id);
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
        	try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
        }
	}
	
	public void BAJA(long id, int cantidad) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement("UPDATE productos SET cantidad = ? WHERE id = ?");
			
			stmt.setLong(1, cantidad);
			stmt.setLong(2, id);
			
			stmt.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Producto> consultar_tabla() {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		ArrayList<Producto> tabla = new ArrayList<>();
		
		try {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM productos");
			
			while(rs.next()) {
				long id = rs.getLong("id");
				String nombre = rs.getString("nombre"); 
				String marca = rs.getString("marca"); 
				String descripcionDelProducto = rs.getString("descripcion"); 
				String categoria = rs.getString("categoria"); 
				int precioDeCompra = rs.getInt("precio_compra"); 
				int precioDeVenta = rs.getInt("precio_venta"); 
				int cantidad = rs.getInt("cantidad");
				Producto p = new Producto();
				
				p.setId(id);
				p.setNombre(nombre);
	    		p.setMarca(marca);
	    		p.setDescripcionDelProducto(descripcionDelProducto);
	    		p.setCategoria(categoria);
	    		p.setPrecioDeCompra(precioDeCompra);
	    		p.setPrecioDeVenta(precioDeVenta);
	    		p.setCantidad(cantidad);
				
				tabla.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tabla;
	}

	public float consultarPrecioUnitario(long id) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		float precioUnitario = 0;
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT precio_venta FROM productos WHERE id = ?");
		
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			
			precioUnitario = rs.getFloat("precio_venta");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return precioUnitario;
	}

	public boolean existeId(long id) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		try {
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id FROM productos");
			
			while(rs.next()) {
				long ID = rs.getLong("id");
				if(id == ID) {
					return true;
				}
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public Producto buscarProducto(long id) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		Producto p = new Producto();
		try {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productos WHERE id = ?");

			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {			
				String nombre = rs.getString("nombre");
				String marca = rs.getString("marca"); 
				String descripcionDelProducto = rs.getString("descripcion");
				String categoria = rs.getString("categoria");
				float precioDeCompra = rs.getFloat("precio_compra");
				float precioDeVenta = rs.getFloat("precio_venta");
				int cantidad = rs.getInt("cantidad");
				p.setId(id);
				p.setNombre(nombre);
				p.setMarca(marca);
				p.setDescripcionDelProducto(descripcionDelProducto);
				p.setCategoria(categoria);
				p.setPrecioDeCompra(precioDeCompra);
				p.setPrecioDeVenta(precioDeVenta);
				p.setCantidad(cantidad);
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return p;
	}

	public boolean hayStock(long id, int cant) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productos WHERE id = ?");

			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {			
				int cantidad = rs.getInt("cantidad");
				if(cant>cantidad) {
					return false;
				}
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return true;
	}

	public ArrayList<String> buscarPrecioUnitario(long id) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<String> a = new ArrayList<>();
		
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productos WHERE id = ?");
		
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				String precioUnitario = new Float(rs.getFloat("precio_venta")).toString();
				String nombre = rs.getString("nombre");
				
				
				a.add(nombre);
				a.add(precioUnitario);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public long buscarId(String nombre) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		long id=0;
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productos WHERE nombre = ?");
			stmt.setString(1, nombre);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {				
				id = rs.getLong("id");
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return id;
	}

	public void BAJA(long id) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement("UPDATE productos SET cantidad = (cantidad-1) WHERE id = ?");
			
			stmt.setLong(1, id);
			
			stmt.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
