package BMC_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import BMC_Modelo.Cliente;
import BMC_Modelo.Factura;
import BMC_Modelo.Producto;
import BMC_Modelo.Usuario;

public class FacturasDAO {

	public void ALTA(Factura f) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		
		LocalDate fecha = LocalDate.now(); 
		float importe = f.getImporte(); 
		int cantidadItems = f.getCantidadItems();
		long idCliente = f.getIdCliente();
		float pago = f.getPago();
		float vuelto = f.getVuelto();
		int id_vendedor = f.getIdVendedor();
		
		
		try {
	
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO facturas (fecha, importe, cantidaditems, idCliente, pago, vuelto, id_vendedor) VALUES (?,?,?,?,?,?,?)");
		
			
			stmt.setDate(1, (java.sql.Date.valueOf(fecha)));
			stmt.setFloat(2, importe);
			stmt.setInt(3, cantidadItems);
			stmt.setLong(4, idCliente);
			stmt.setFloat(5, pago);
			stmt.setFloat(6, vuelto);
			stmt.setInt(7, id_vendedor);
		
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

	public void MODIFICACION(long id, String fecha, float importe, int cantidadItems, long idCliente, float pago, float vuelto) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		try {
	
			PreparedStatement stmt = conn.prepareStatement("UPDATE facturas SET fecha = ?, importe = ?, cantidaditems = ?, idCliente = ?, pago = ?, vuelto = ? WHERE id = ?");
			
			
			stmt.setString(1, fecha);
			stmt.setFloat(2, importe);
			stmt.setInt(3, cantidadItems);
			stmt.setLong(4, idCliente);
			stmt.setFloat(5, pago);		
			stmt.setFloat(6, vuelto);		
			stmt.setLong(7, id);
			
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

	public void BAJA(long id) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM facturas WHERE id = ?");
			
			stmt.setLong(1, id);
			
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

	
	
	public ArrayList<String> datosSucursal(){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<String> datos = new ArrayList<>();
		
		try {
			
			Statement stmt = conn.createStatement();
			
			
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM sucursal");
			
			while(rs.next()) {
				datos.add(rs.getString("cadena"));
				datos.add(new Integer(rs.getInt("id_sucursal")).toString());
				datos.add(rs.getString("direccion"));
				datos.add(new Integer(rs.getInt("telefono")).toString()); 
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
		return datos;
	}

	public long buscarIdFactura() {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		long idFacturita = 0;
		try {
			
			Statement stmt = conn.createStatement();
			
			
			
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM facturas ORDER BY id DESC LIMIT 1 ");
			
			while(rs.next()) {
				idFacturita = rs.getLong("id");
			}
			
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
	
		return idFacturita;
	}

	public void AltaFacturas_productos(long id_producto) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		long id_factura = buscarIdFactura();
		try {
			
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO facturas_productos VALUES(?,?)");
			
			stmt.setLong(1, id_factura);
			stmt.setLong(2, id_producto);
			
			
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
	
	public Factura buscarFactura(long id) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		Factura f = new Factura();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facturas WHERE id = ?");
			
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
			}
			
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
		
		return f;
	}

	
	public ArrayList<Factura> consultar_tabla(){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Factura> fa = new ArrayList<Factura>();
		
		try {
			Statement stmt = conn.createStatement();
				
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM facturas");
			
			while(rs.next()) {
				Factura f = new Factura();
				long id = rs.getLong("id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
				fa.add(f);
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
		
		return fa;
	}

	public boolean existeId(long idFactura) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id FROM facturas");
			
			while(rs.next()) {
				long id = rs.getLong("id");
				if(idFactura == id) {
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

	public ArrayList<Factura> facturasMismoVendedor(int dni){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Factura> fac = new ArrayList<>();
		
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM facturas");
			
			while(rs.next()) {
				Factura f = new Factura();
				long id = new Long("id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
				if(dni == idVendedor) {
					fac.add(f);
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
		return fac;
	}
	
	public ArrayList<Factura> facturasHistorialAmbas(Date fechaDesde, Date fechaHasta, int dniVendedor){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Factura> fac = new ArrayList<>();
		
		try {		
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facturas WHERE fecha >= ? AND fecha <= ?");

			stmt.setDate(1, fechaDesde);
			stmt.setDate(2, fechaHasta);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Factura f = new Factura();
				long id = rs.getLong("id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
				if(dniVendedor == idVendedor) {
					fac.add(f);
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
		return fac;
	}

	public ArrayList<Factura> facturasHistorialFecha(Date fechaDesde, Date fechaHasta){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Factura> fac = new ArrayList<>();
		
		try {		
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facturas WHERE fecha >= ? AND fecha <= ?");

			stmt.setDate(1, fechaDesde);
			stmt.setDate(2, fechaHasta);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Factura f = new Factura();
				long id = rs.getLong("id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
				
				fac.add(f);
				
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
		return fac;
	}

	public ArrayList<Factura> facturasHistorialVendedor(int dniVendedor){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Factura> fac = new ArrayList<>();
		
		try {		
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM facturas");
			
			while(rs.next()) {
				Factura f = new Factura();
				long id = rs.getLong("id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
				if(dniVendedor == idVendedor) {
					fac.add(f);
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
		return fac;
	}
	
	public ArrayList<Factura> facturasHistorialFechaDesde(Date fechaDesde){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Factura> fac = new ArrayList<>();
		
		try {		
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facturas WHERE fecha >= ?");

			stmt.setDate(1, fechaDesde);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Factura f = new Factura();
				long id = rs.getLong("id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
				
				fac.add(f);
				
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
		return fac;
	}
	
	public ArrayList<Factura> facturasHistorialFechaHasta(Date fechaHasta){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Factura> fac = new ArrayList<>();
		
		try {		
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facturas WHERE fecha <= ?");

			stmt.setDate(1, fechaHasta);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Factura f = new Factura();
				long id = rs.getLong("id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
				
				fac.add(f);
				
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
		return fac;
	}

	public ArrayList<Factura> facturasHistorialFechaDesdeVendedor(Date fechaDesde, int dniVendedor){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Factura> fac = new ArrayList<>();
		
		try {		
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facturas WHERE fecha >= ? AND id_vendedor = ?");

			stmt.setDate(1, fechaDesde);
			stmt.setInt(2, dniVendedor);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Factura f = new Factura();
				long id = rs.getLong("id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
				if(dniVendedor == idVendedor) {
					fac.add(f);
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
		return fac;
	}

	public ArrayList<Factura> facturasHistorialFechaHastaVendedor(Date fechaHasta, int dniVendedor){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Factura> fac = new ArrayList<>();
		
		try {		
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facturas WHERE fecha <= ?");

			stmt.setDate(1, fechaHasta);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Factura f = new Factura();
				long id = rs.getLong("id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
				if(dniVendedor == idVendedor) {
					fac.add(f);
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
		return fac;
	}

	
	public ArrayList<Factura> consultar_tabla_vendedor(int dni){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Factura> fa = new ArrayList<Factura>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facturas WHERE id_vendedor = ?");
				
			stmt.setInt(1, dni);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Factura f = new Factura();
				long id = rs.getLong("id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
				fa.add(f);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
       	 
       	 
         	try {
 				conn.close();
 			} catch (SQLException e) {
 				e.printStackTrace();
 			}
         }
		
		return fa;
	}
	
	public ArrayList<Factura> facturasHistorialFecha_vendedor(Date fechaDesde, Date fechaHasta, int dni){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Factura> fac = new ArrayList<>();
		
		try {		
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facturas WHERE fecha >= ? AND fecha <= ? AND id_vendedor = ?");

			stmt.setDate(1, fechaDesde);
			stmt.setDate(2, fechaHasta);
			stmt.setInt(3, dni);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Factura f = new Factura();
				long id = rs.getLong("id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
				
				fac.add(f);
				
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
		return fac;
	}

	public ArrayList<Factura> facturasHistorialFechaDesde_vendedor(Date fechaDesde, int dni){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Factura> fac = new ArrayList<>();
		
		try {		
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facturas WHERE fecha >= ? AND id_vendedor = ?");

			stmt.setDate(1, fechaDesde);
			stmt.setInt(2, dni);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Factura f = new Factura();
				long id = rs.getLong("id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
				
				fac.add(f);
				
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
		return fac;
	}
	
	public ArrayList<Factura> facturasHistorialFechaHasta_vendedor(Date fechaHasta, int dni){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		ArrayList<Factura> fac = new ArrayList<>();
		
		try {		
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facturas WHERE fecha <= ? AND id_vendedor = ?");

			stmt.setDate(1, fechaHasta);
			stmt.setInt(2, dni);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Factura f = new Factura();
				long id = rs.getLong("id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				float importe = rs.getFloat("importe");
				int cantidadItems = rs.getInt("cantidaditems");
				long idCliente = rs.getLong("idCliente");
				float pago = rs.getFloat("pago");
				float vuelto = rs.getFloat("vuelto");
				int idVendedor = rs.getInt("id_vendedor");
				
				f.setId(id);
				f.setFecha(fecha);
				f.setImporte(importe);
				f.setCantidadItems(cantidadItems);
				f.setIdCliente(idCliente);
				f.setPago(pago);
				f.setVuelto(vuelto);
				f.setIdVendedor(idVendedor);
				
				
				fac.add(f);
				
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
		return fac;
	}
	
	
	
	public Producto productoMasVendido(){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		Producto p = new Producto();
		ProductoDAO pd = new ProductoDAO();
		int cont = 0 ;
		
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id_productos, COUNT(id_productos) AS total FROM facturas_productos GROUP BY id_productos ORDER BY total DESC");
			
			while(rs.next()) {
				int id = rs.getInt("id_productos");
				p = pd.buscarProducto(id);
				return p;
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
		return p;
		
	}

	public int cantidadVentasProdMasVendido() {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		Producto p = new Producto();
		
		int cantidad = 0 ;
		
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id_productos, COUNT(id_productos) AS total FROM facturas_productos GROUP BY id_productos ORDER BY total DESC");
			
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

	public Producto productoMenosVendido(){
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		Producto p = new Producto();
		ProductoDAO pd = new ProductoDAO();
		
		
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id_productos, COUNT(id_productos) AS total FROM facturas_productos GROUP BY id_productos ORDER BY total ASC");
			
			while(rs.next()) {
				int id = rs.getInt("id_productos");
				p = pd.buscarProducto(id);
				return p;
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
		return p;
		
	}

	public int cantidadVentasProdMenosVendido() {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		Producto p = new Producto();
		
		int cantidad = 0 ;
		
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id_productos, COUNT(id_productos) AS total FROM facturas_productos GROUP BY id_productos ORDER BY total ASC");
			
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

	public int cantidadVentas(int id) {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		
		
		int cantidad = 0 ;
		
		try {		
			
			PreparedStatement stmt = conn.prepareStatement("SELECT id_productos, COUNT(id_productos) AS total FROM facturas_productos WHERE id_productos = ?");

			stmt.setInt(1, id);
			
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
	
	public Producto productoMasRecaudador() {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();
		Producto p = new Producto();
		ProductoDAO pd = new ProductoDAO();
		float cont = 0;
		int ventas=0;
		float pu=0;
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM facturas_productos");
			
			while(rs.next()) {
				Producto pTransitorio = new Producto();
				float a = 0;
				int id = rs.getInt("id_productos");
				pTransitorio = pd.buscarProducto(id);
				pu = pTransitorio.getPrecioDeVenta();
				ventas = cantidadVentas(id);
				a = pu*ventas;
				if(a>cont) {
					cont = a;
					p = pTransitorio;
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
		return p;
		
	}

	public float masRecaudado() {
		Conexion con = new Conexion();
		Connection conn = null;
		
		conn = con.conectar();	
		ProductoDAO pd = new ProductoDAO();
		float cont = 0;
		int ventas=0;
		float pu=0;
		try {		
			
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM facturas_productos");
			
			while(rs.next()) {
				Producto pTransitorio = new Producto();
				float a = 0;
				int id = rs.getInt("id_productos");
				pTransitorio = pd.buscarProducto(id);
				pu = pTransitorio.getPrecioDeVenta();
				ventas = cantidadVentas(id);
				a = pu*ventas;
				if(a>cont) {
					cont = a;
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
		return cont;

	}
}
