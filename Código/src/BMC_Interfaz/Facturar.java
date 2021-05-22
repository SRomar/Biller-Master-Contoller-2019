package BMC_Interfaz;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;

import BMC_DAO.ClientesDAO;
import BMC_DAO.FacturasDAO;
import BMC_DAO.No_hay_error;
import BMC_DAO.ProductoDAO;
import BMC_DAO.UsuariosDAO;
import BMC_Modelo.Cliente;
import BMC_Modelo.Factura;
import BMC_Modelo.Usuario;

import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Image;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Facturar extends JPanel {
	private JTextField textFieldDni;
	private JTextField textFieldUnidades;
	private JTextField textFieldProducto;
	private JTextField textFieldPago;
	private JTable table_productos;

	ClientesDAO cd = new ClientesDAO();
	ProductoDAO pd = new ProductoDAO();	
	FacturasDAO fd = new FacturasDAO();
	UsuariosDAO ud = new UsuariosDAO();
	
	long dni_cliente = 0;

	public Facturar(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		setLayout(null);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Facturacion.png")));
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(839, 14, 60, 38);
		lblInicio.setToolTipText("Atrás");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ud.esAdmin(u.getDni())==true) {
					Principal panel = new Principal(frame, u);
					setVisible(false);
					frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
				}
				else if(ud.esVendedor(u.getDni())==true) {
					Principal_Vendedor panel = new Principal_Vendedor(frame, u);
					setVisible(false);
					frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Facturacion.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Facturacion.png")));
				
			}
		});
		add(lblInicio);
		
		JLabel lblCadena = new JLabel("");
		lblCadena.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadena.setBounds(38, 64, 93, 38);
		add(lblCadena);
		
		JLabel lblDireccion = new JLabel("");
		lblDireccion.setBounds(38, 107, 129, 14);
		add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("");
		lblTelefono.setBounds(38, 125, 129, 14);
		add(lblTelefono);
		
		JLabel lblSucursal = new JLabel("");
		lblSucursal.setBounds(38, 143, 129, 14);
		add(lblSucursal);
		
		JLabel lblNombreCliente = new JLabel("");
		lblNombreCliente.setBounds(367, 107, 129, 14);
		add(lblNombreCliente);
		
		JLabel lblApellidoCliente = new JLabel("");
		lblApellidoCliente.setBounds(367, 125, 129, 14);
		add(lblApellidoCliente);
		
		JLabel lblTelefonoCliente = new JLabel("");
		lblTelefonoCliente.setBounds(367, 147, 129, 14);
		add(lblTelefonoCliente);
		
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setBounds(38, 464, 48, 14);
		add(lblImporte);
		
		JLabel lblPago = new JLabel("Pago:");
		lblPago.setBounds(38, 489, 48, 14);
		add(lblPago);
		
		JLabel lblVuelto = new JLabel("Vuelto:");
		lblVuelto.setBounds(38, 514, 48, 14);
		add(lblVuelto);
		
		JLabel lblPesosImporte = new JLabel("");
		lblPesosImporte.setBounds(99, 464, 115, 14);
		add(lblPesosImporte);
		
		JLabel lblPesosPago = new JLabel("");
		lblPesosPago.setBounds(96, 489, 118, 14);
		add(lblPesosPago);
		
		JLabel lblPesosVuelto = new JLabel("");
		lblPesosVuelto.setBounds(96, 514, 118, 14);
		add(lblPesosVuelto);

		
		JLabel lblCrearCliente = new JLabel("");
		lblCrearCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Alta_Clientes panel = new Alta_Clientes(frame, true, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lblCrearCliente.setBounds(544, 185, 144, 38);
		add(lblCrearCliente);
		
		String[] nombresColumnas = {"Nombre", "Precio x Unidad", "Cantidad"};
				
		DefaultTableModel model = new DefaultTableModel(nombresColumnas, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 185, 458, 263);
		add(scrollPane);
		
		table_productos = new JTable();
		table_productos.setModel(model);
		scrollPane.setViewportView(table_productos);
		
		textFieldDni = new JTextField();
		textFieldDni.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldDni.setBorder(null);
		textFieldDni.setBounds(544, 135, 328, 26);
		add(textFieldDni);
		textFieldDni.setColumns(10);
		
		JLabel lblAnadirCliente = new JLabel("");
		lblAnadirCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
				
				No_hay_error nh = new No_hay_error();
				
				if(nh.Solo_Numeros(textFieldDni.getText())==false || cd.existeDni(new Integer(textFieldDni.getText().toString()))==false) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				
				if(textFieldDni.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Datos incompletos");
					a = 1;
				}
				
				if(a == 0) {
					int dniCliente = new Integer(textFieldDni.getText());
			    	Cliente cliente = new Cliente();
			    				    	
			    	if(a==0) {
			    		if(cd.existeDni(dniCliente) == false) {
			    			JOptionPane.showMessageDialog(null, "Cliente Inexistente");
			    			textFieldDni.setText(null);
			    			a = 1;
			    		}
			    		else {
			    			cliente = cd.buscarCliente(dniCliente);
			    			dni_cliente = dniCliente;
			    			lblNombreCliente.setText(cliente.getNombre());
			    			lblApellidoCliente.setText(cliente.getApellido());
			    			lblTelefonoCliente.setText(cliente.getTelefono());
			    			textFieldDni.setText(null);			    			
			    		}
			    	}
				}
			}
		});
		lblAnadirCliente.setBounds(740, 185, 137, 38);
		add(lblAnadirCliente);
		
		JLabel lblAnadirProducto = new JLabel("");
		lblAnadirProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int v = 0;
				
				No_hay_error nh = new No_hay_error();
				
				if(nh.Solo_Numeros(textFieldProducto.getText())==false || nh.Solo_Numeros(textFieldUnidades.getText())==false) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					v = 1;
				}
				
				if(textFieldProducto.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Datos Incompletos");
					v = 1;
				}
				
				if(v == 0) {
					float a;
					if(lblPesosImporte.getText().equals("")) {
						a = 0;
					}
					else {
						a = new Float(lblPesosImporte.getText());
					}
					float precio = 0;
					Long id = new Long(textFieldProducto.getText());
			    	int cantidad = new Integer(textFieldUnidades.getText());
					
					if(v == 0) {
						if(pd.existeId(id)==false) {
							JOptionPane.showMessageDialog(null, "Id inexistente");
							textFieldProducto.setText(null);
							v = 1;							
						}
						
						if(v==0) {
							if(model.getRowCount()>0) {
								for (int i = 0; i < table_productos.getRowCount(); i++) {
									long ID = pd.buscarId(table_productos.getValueAt(i, 0).toString());
									if (ID == id) {
										JOptionPane.showMessageDialog(null, "El Producto ya está en la tabla");
										v = 1;
			                         }
			                     }
							}
						}
						
						if(v == 0) {
							if(pd.hayStock(id, cantidad)==false) {
								JOptionPane.showMessageDialog(null, "Unidades mayor al stock");
								textFieldUnidades.setText("1");
								v = 1;
							}
						}
						
						if(v == 0) {
							ArrayList<String> tablita = pd.buscarPrecioUnitario(id);
					    	
							precio = cantidad * new Float(tablita.get(1));
							
					    	Object [] registro = {tablita.get(0), "$" + tablita.get(1), cantidad};
							model.addRow(registro);
							
							a = a + precio;
							lblPesosImporte.setText(new Float(a).toString());
							
							textFieldProducto.setText(null);
						}
					}
			    	
			    		
			    	
			    	
				}
			}
		});
		lblAnadirProducto.setBounds(740, 440, 137, 38);
		add(lblAnadirProducto);
		
		JLabel lblSumar = new JLabel("");
		lblSumar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textFieldUnidades.getText().matches("^[A-Za-z!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$") == false) {
					if(new Integer(textFieldUnidades.getText()) > 0) {
						Integer cantidad = new Integer(textFieldUnidades.getText());
						cantidad++;
						textFieldUnidades.setText(cantidad.toString());
					}
					else {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
		    			textFieldUnidades.setText("1");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
	    			textFieldUnidades.setText("1");
				}
			}
		});
		lblSumar.setBounds(594, 391, 37, 38);
		add(lblSumar);
		
		JLabel lblFacturar = new JLabel("");
		lblFacturar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
		    	
				No_hay_error nh = new No_hay_error();
				
				float pago = new Float(textFieldPago.getText());
				float importe = new Float(lblPesosImporte.getText());
						
				
				if (importe > pago) {
					
					JOptionPane.showMessageDialog(null, "Pago insuficiente.");
					a = 1;
				}
				
				
		    	if (nh.Solo_Numeros(textFieldPago.getText())==false) {
		    		JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
		    	if(dni_cliente == 0 || model.getRowCount() == 0 || lblPesosImporte.getText().equals("") || lblNombreCliente.getText().equals("") || textFieldPago.getText().equals("")) {
		    		JOptionPane.showMessageDialog(null, "Datos Incompletos");
					a = 1;
		    	}
		    	
		    	if(a==0) {
		    		Factura f = new Factura();
		    		f.setCantidadItems(model.getRowCount());
		    		f.setIdCliente(dni_cliente);
		    		f.setImporte(new Float(lblPesosImporte.getText()));
		    		f.setPago(new Float(textFieldPago.getText()));
		    		f.setVuelto(new Float(textFieldPago.getText())-f.getImporte());
		    		f.setIdVendedor(u.getDni());
		    		fd.ALTA(f);
		    		
		    		dni_cliente = 0;
		    		 for (int i = 0; i < table_productos.getRowCount(); i++) {
                         if (table_productos.getValueAt(i, 0) != null) {
                        	 String nombre = table_productos.getValueAt(i, 0).toString();
                        	 long id = pd.buscarId(nombre);
                             fd.AltaFacturas_productos(id);
                             pd.BAJA(id);
                         }
                     }
		    		
		    		
		    		lblPesosVuelto.setText(new Float(new Float(textFieldPago.getText())-new Float(lblPesosImporte.getText())).toString());
		    		lblPesosPago.setText(new Float(textFieldPago.getText()).toString());
		    		
		    		lblNombreCliente.setText(null);
		    		lblApellidoCliente.setText(null);
		    		lblTelefonoCliente.setText(null);
		    		model.setRowCount(0);
		    		lblPesosImporte.setText(null);
		    		lblPesosVuelto.setText(null);
		    		lblPesosPago.setText(null);
		    		textFieldPago.setText(null);
		    	}
			}
		});
		lblFacturar.setBounds(584, 574, 259, 38);
		add(lblFacturar);
		
		JLabel lblResta = new JLabel("");
		lblResta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textFieldUnidades.getText().matches("^[A-Za-z!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$") == false) {				
					if(new Integer(textFieldUnidades.getText()) > 1) {
						Integer cantidad = new Integer(textFieldUnidades.getText());
						cantidad--;				
						textFieldUnidades.setText(cantidad.toString());
					}
					else {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
		    			textFieldUnidades.setText("1");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
	    			textFieldUnidades.setText("1");
				}
			}
		});
		lblResta.setBounds(641, 391, 37, 38);
		add(lblResta);
		
		textFieldUnidades = new JTextField();
		textFieldUnidades.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUnidades.setEditable(false);
		textFieldUnidades.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldUnidades.setBorder(null);
		textFieldUnidades.setBounds(543, 395, 34, 25);
		add(textFieldUnidades);
		textFieldUnidades.setColumns(10);
		textFieldUnidades.setText("1");
		
		
		textFieldProducto = new JTextField();
		textFieldProducto.setBorder(null);
		textFieldProducto.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldProducto.setBounds(542, 306, 332, 26);
		add(textFieldProducto);
		textFieldProducto.setColumns(10);
		
		textFieldPago = new JTextField();
		textFieldPago.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldPago.setBorder(null);
		textFieldPago.setBounds(641, 496, 231, 28);
		add(textFieldPago);
		textFieldPago.setColumns(10);
		
		
		
		JLabel lblVaciarCampos = new JLabel("");
		lblVaciarCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldDni.setText(null);
				textFieldProducto.setText(null);
				textFieldUnidades.setText("1");
				textFieldPago.setText(null);
				model.setRowCount(0);
			}
		});
		lblVaciarCampos.setBounds(531, 14, 267, 38);
		add(lblVaciarCampos);
		
		
		ArrayList<String> datos = fd.datosSucursal();
		lblCadena.setText(datos.get(0));
		lblSucursal.setText("73");
		lblDireccion.setText(datos.get(2));
		lblTelefono.setText("+54 11 4323-4438");
		
		
		
		add(lblFondo);

	}

}
