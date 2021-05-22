package BMC_DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BMC_Modelo.Cliente;
import BMC_Modelo.Producto;

public class ClientesDAO {

	public void ALTA(Cliente c) {		
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		int dni = c.getDni();
		String nombre = c.getNombre(); 
		String apellido = c.getApellido(); 
		String domicilio = c.getDomicilio();
		String telefono = c.getTelefono();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO clientes VALUES (?,?,?,?,?)");
		
			stmt.setLong(1, dni);
			stmt.setString(2, nombre);
			stmt.setString(3, apellido);
			stmt.setString(4, domicilio);
			stmt.setString(5, telefono);
	
	
		
			stmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
        	try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
        }
		
	}

	public void MODIFICACION(long dni, String nombre, String apellido, String domicilio,String telefono) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		try {
	
			PreparedStatement stmt = conn.prepareStatement("UPDATE clientes SET nombre = ?, apellido = ?, domicilio = ?, telefono = ? WHERE dni = ?");
			
			
			stmt.setString(1, nombre);
			stmt.setString(2, apellido);
			stmt.setString(3, domicilio);
			stmt.setString(4, telefono);					
			stmt.setLong(5, dni);
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
        	try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
        }
	}

	public void BAJA(long dni) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		try {
	
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM clientes WHERE dni = ?");
			
			stmt.setLong(1, dni);
			
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

	public boolean existeDni(int dniCliente) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT dni FROM clientes");
			
			while(rs.next()) {
				Long DNI = rs.getLong("dni");
				if(dniCliente == DNI) {
					return true;
				}
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
	        	try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
	        }
		return false;
	}

	public ArrayList<Cliente> consultar_tabla(){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		ArrayList<Cliente> cl = new ArrayList<Cliente>();
		
		try {
			Statement stmt = conn.createStatement();
				
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");
			
			while(rs.next()) {
				Cliente c = new Cliente();
				int dni = rs.getInt("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String domicilio = rs.getString("domicilio");
				String telefono = rs.getString("telefono");

				c.setDni(dni);
				c.setNombre(nombre);
				c.setApellido(apellido);
				c.setDomicilio(domicilio);
				c.setTelefono(telefono);
				
				cl.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
        	try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
        }
		
		return cl;
	}

	
	public int getDni(String cliente) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		int d = 0;
		try {		
		
			PreparedStatement stmt = conn.prepareStatement("SELECT dni FROM clientes WHERE usuario = ?");
			
			stmt.setString(1, cliente);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				d = rs.getInt("dni");					
			}
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
		return d;
	}
	
	public Cliente buscarCliente(int dni) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		Cliente c = new Cliente();
		try {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM clientes WHERE dni = ?");

			stmt.setLong(1, dni);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {			
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String domicilio = rs.getString("domicilio");
				String telefono = rs.getString("telefono");
				
				c.setDni(dni);
				c.setNombre(nombre);
				c.setApellido(apellido);
				c.setDomicilio(domicilio);
				c.setTelefono(telefono);
				
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		finally {
        	try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
        }
		return c;
	}

	
	public ArrayList<Cliente> existeNombre(String nombre){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		System.out.println(nombre);
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");
			
			while(rs.next()) {
				Cliente c = new Cliente();
				int dni = rs.getInt("dni");
				String nom = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String domicilio = rs.getString("domicilio");
				String telefono = rs.getString("telefono");
				
				c.setDni(dni);
				c.setNombre(nombre);
				c.setApellido(apellido);
				c.setDomicilio(domicilio);
				c.setTelefono(telefono);
				
				if(nombre == nom) {
					clientes.add(c);
				}
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		finally {
       	 
       	 
         	try {
 				conn.close();
 			} catch (SQLException e) {
 				e.printStackTrace();
 			}
         }
		return clientes;
	}

	public ArrayList<Cliente> existeApellido(String ape){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");
			
			while(rs.next()) {
				Cliente c = new Cliente();
				int dni = rs.getInt("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String domicilio = rs.getString("domicilio");
				String telefono = rs.getString("telefono");
				
				c.setDni(dni);
				c.setNombre(nombre);
				c.setApellido(apellido);
				c.setDomicilio(domicilio);
				c.setTelefono(telefono);
				
				if(ape == apellido) {
					clientes.add(c);
				}
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		finally {
       	 
       	 
         	try {
 				conn.close();
 			} catch (SQLException e) {
 				e.printStackTrace();
 			}
         }
		return clientes;
	}
	
}
