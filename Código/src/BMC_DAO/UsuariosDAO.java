package BMC_DAO;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import BMC_Modelo.Producto;
import BMC_Modelo.Usuario;

public class UsuariosDAO {

	public void ALTA(Usuario u) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		int dni = u.getDni();
		String usuario = u.getUsuario();
		String contrasenia = u.getContrasenia(); 
		String nombre = u.getNombre(); 
		String apellido = u.getApellido();		
		String domicilio = u.getDomicilio();
		String telefono = u.getTelefono();
		String tipo = u.getTipo();
		String foto = u.getFoto();
		
		try {		
		
		
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?,?,?,?,?,?)");
		
			stmt.setInt(1, dni);
			stmt.setString(2, nombre);
			stmt.setString(3, apellido);
			stmt.setString(4, usuario);
			stmt.setString(5, contrasenia);
			stmt.setString(6, domicilio);
			stmt.setString(7, telefono);
			stmt.setString(8, tipo);
			stmt.setString(9, foto);
			
	
			
			stmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
        	try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
        }
		
	}
	

	public void MODIFICACION(int dni, String nombre, String apellido, String usuario, String contrasenia, String domicilio,String telefono, String tipo, String foto) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		try {		
			
	
			PreparedStatement stmt = conn.prepareStatement("UPDATE usuarios SET nombre = ?, apellido = ?, usuario = ?, contrasenia = ?, domicilio = ?, telefono = ?, tipo = ?, foto = ? WHERE dni = ?");
			
			
			stmt.setString(1, nombre);
			stmt.setString(2, apellido);
			stmt.setString(3, usuario);
			stmt.setString(4, contrasenia);
			stmt.setString(5, domicilio);
			stmt.setString(6, telefono);		
			stmt.setString(7, tipo);
			stmt.setString(8, foto);
			stmt.setInt(9, dni);
			
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
	

	public void BAJA(int dni) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		try {		
		
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuarios WHERE dni = ?");
			
			stmt.setInt(1, dni);
			
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
	
	
	public boolean existeDni(int dniUsuario) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT dni FROM usuarios");
			
			while(rs.next()) {
				int DNI = rs.getInt("dni");
				if(dniUsuario == DNI) {
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

	
	public boolean existeNombre(String nombreUsuario) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		try {
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT usuario FROM usuarios");
			
			while(rs.next()) {
				String NOMBRE = rs.getString("usuario");
				if(nombreUsuario.equals(NOMBRE)) {
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
	
	public int existeUsuarioModificacion(String u) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		try {
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");
			
			while(rs.next()) {
				String us = rs.getString("usuario");
				if(u.equals(us)) {
					return rs.getInt("dni");
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
		return 0;
	}

	public boolean esAdmin(int dni) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		String jerarquia;
		try {		
		
			PreparedStatement stmt = conn.prepareStatement("SELECT tipo FROM usuarios WHERE dni = ?");
			
			stmt.setInt(1, dni);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				jerarquia = rs.getString("tipo");
				
				if(jerarquia.equals("Administrador")) {					
					return true;
				}
				else {
					
					return false;
				}
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
		return false;
	}
	
	
	public boolean esVendedor(int dni) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		String jerarquia;
		try {		
		
			PreparedStatement stmt = conn.prepareStatement("SELECT tipo FROM usuarios WHERE dni = ?");
			
			stmt.setInt(1, dni);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				jerarquia = rs.getString("tipo");
				
				if(jerarquia.equals("Vendedor")) {					
					return true;
				}
				else {
					
					return false;
				}
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
		return false;
	}
	
	
	public boolean esAlmacen(int dni) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		String jerarquia;
		try {		
		
			PreparedStatement stmt = conn.prepareStatement("SELECT tipo FROM usuarios WHERE dni = ?");
			
			stmt.setInt(1, dni);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				jerarquia = rs.getString("tipo");
				
				if(jerarquia.equals("Empleado de Almacen")) {					
					return true;
				}
				else {
					
					return false;
				}
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
		return false;
	}



	public boolean arregloVacio() {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");
			//System.out.println(rs.toString());
			
			rs.next();
			
			if(rs.getRow() == 0) {
				//System.out.println("esta vacio");
				return true;
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
		//System.out.println("no esta vacio");
		return false;
		
	}

	public boolean validacionDeUsuario(String nombreUsuario, String contrasenia) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT contrasenia FROM usuarios WHERE usuario = ?");
			stmt.setString(1, nombreUsuario);	
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("contrasenia").equals(contrasenia)) {
					return true;
				}
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
		
		return false;
	}

	
	public ArrayList<Usuario> consultar_tabla(){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		ArrayList<Usuario> us = new ArrayList<Usuario>();
		
		try {
			Statement stmt = conn.createStatement();
				
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");
			
			while(rs.next()) {
				Usuario u = new Usuario();
				int d = rs.getInt("dni");
				String nom = rs.getString("nombre");
				String ape = rs.getString("apellido");
				String usu = rs.getString("usuario");
				String contra = rs.getString("contrasenia");
				String domi = rs.getString("domicilio");
				String tel = rs.getString("telefono");
				String tip = rs.getString("tipo");
				
				u.setDni(d);
				u.setNombre(nom);
				u.setApellido(ape);
				u.setUsuario(usu);
				u.setContrasenia(contra);
				u.setDomicilio(domi);
				u.setTelefono(tel);
				u.setTipo(tip);
				us.add(u);
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
		
		return us;
	}


	public int getDni(String usuario) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		int d = 0;
		try {		
		
			PreparedStatement stmt = conn.prepareStatement("SELECT dni FROM usuarios WHERE usuario = ?");
			
			stmt.setString(1, usuario);
			
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

	public ArrayList<Usuario> buscarPorTipo(String tipo){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		ArrayList<Usuario> usuarios= new ArrayList<>();
		try {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE tipo = ?");
			stmt.setString(1, tipo);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setDni(rs.getInt("dni"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setUsuario(rs.getString("usuario"));
				u.setContrasenia(rs.getString("contrasenia"));
				u.setDomicilio(rs.getString("domicilio"));
				u.setTelefono(rs.getString("telefono"));
				u.setTipo(rs.getString("tipo"));
				u.setFoto(rs.getString("foto"));
				usuarios.add(u);
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
		return usuarios;
	}

	public Usuario buscarUsuario(int d){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		Usuario u = new Usuario();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE dni = ?");
			stmt.setInt(1, d);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {				
				u.setDni(d);
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setUsuario(rs.getString("usuario"));
				u.setContrasenia(rs.getString("contrasenia"));
				u.setDomicilio(rs.getString("domicilio"));
				u.setTelefono(rs.getString("telefono"));
				u.setTipo(rs.getString("tipo"));
				u.setFoto(rs.getString("foto"));
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
		return u;
	}


	public Usuario empleadoDelMes(){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
	    Usuario u = new Usuario();
		
		
		
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id_vendedor, COUNT(id_vendedor) AS total FROM facturas GROUP BY id_vendedor ORDER BY total DESC");
			
			while(rs.next()) {
				int id = rs.getInt("id_vendedor");
				u = buscarUsuario(id);
				return u;
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
		return u;
		
	}

	public int cantidadVentasEmpleadoDelMes() {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		Usuario u = new Usuario();
		
		int cantidad = 0 ;
		
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id_vendedor, COUNT(id_vendedor) AS total FROM facturas GROUP BY id_vendedor ORDER BY total DESC");
			
			while(rs.next()) {
				cantidad = rs.getInt("total");
				
				return cantidad;
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
		return cantidad;
		
	}

	
	public Usuario empleadoMasVago(){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		Usuario u = new Usuario();
		
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id_vendedor, COUNT(id_vendedor) AS total FROM facturas GROUP BY id_vendedor ORDER BY total ASC");
			
			while(rs.next()) {
				int id = rs.getInt("id_vendedor");
				u = buscarUsuario(id);
				return u;
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
		return u;
		
	}

	public int cantidadVentasEmpleadoMasVago() {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		Usuario u = new Usuario();
		
		int cantidad = 0 ;
		
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id_vendedor, COUNT(id_vendedor) AS total FROM facturas GROUP BY id_vendedor ORDER BY total ASC");
			
			while(rs.next()) {
				cantidad = rs.getInt("total");
				
				return cantidad;
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
		return cantidad;
		
	}
	
	
	public int cantidadVentasUsuario(int dni) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		Usuario u = new Usuario();
		
		int cantidad = 0 ;
		
		try {		
			
			PreparedStatement stmt = conn.prepareStatement("SELECT id_vendedor, COUNT(id_vendedor) AS total FROM facturas WHERE id_vendedor = ?");

			stmt.setInt(1, dni);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				cantidad = rs.getInt("total");
				
				return cantidad;
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
		return cantidad;
		
	}

	public float cantidadRecaudadoUsuario(int dni) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		
		float recaudado = 0 ;
		
		try {		
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facturas WHERE id_vendedor = ?");

			stmt.setInt(1, dni);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				float importe = rs.getFloat("importe");
				recaudado = recaudado + importe;
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
		return recaudado;
	}
	
	
	public void agregarProductoRegistrado(int dni) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();

		try {		
			
			PreparedStatement stmt = conn.prepareStatement("UPDATE almaceneros_productos SET cant_prod_registrados = (cant_prod_registrados+1) WHERE id_almacenero = ?");

			stmt.setInt(1, dni);
			
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
	
	public int obtenerProductoRegistrado(int dni) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();

		int cantidad = 0;
		
		try {		
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM almaceneros_productos WHERE id_almacenero = ?");

			stmt.setInt(1, dni);
			
			ResultSet rs = stmt.executeQuery();
	
			while(rs.next()) {
				cantidad = rs.getInt("cant_prod_registrados");
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
		return cantidad;
		
	}

	public void registrarAlmacenero(int dni) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();

		try {		
			
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO almaceneros_productos VALUES (?, 0)");

			stmt.setInt(1, dni);
			
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
}

