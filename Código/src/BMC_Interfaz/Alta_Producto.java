package BMC_Interfaz;

import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

import BMC_DAO.No_hay_error;
import BMC_DAO.ProductoDAO;
import BMC_DAO.UsuariosDAO;
import BMC_Modelo.Producto;
import BMC_Modelo.Usuario;
import javax.swing.SwingConstants;

public class Alta_Producto extends JPanel {
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldMarca;
	private JTextField textFieldPrecioDeVenta;
	private JTextField textFieldPrecioDeCompra;
	private JTextField textFieldCantidad;

	UsuariosDAO ud = new UsuariosDAO();
	
	public Alta_Producto(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		setLayout(null);
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(840, 11, 58, 40);
		lblInicio.setToolTipText("AtrÃ¡s");
		JLabel lblFondo = new JLabel("");
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ud.esAdmin(u.getDni())==true) {
					Stock panel = new Stock(frame, u);
					setVisible(false);
					frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
				}
				if(ud.esAlmacen(u.getDni())==true) {
					Principal_Almacenero panel = new Principal_Almacenero(frame, u);
					setVisible(false);
					frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Producto.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Producto.png")));
				
			}
		});
		
		textFieldId = new JTextField();
		textFieldId.setBounds(36, 127, 327, 23);
		textFieldId.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldId.setBorder(null);
		textFieldId.setBackground(SystemColor.text);
		add(textFieldId);
		textFieldId.setColumns(10);
		
		
		
		
		add(lblInicio);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBorder(null);
		textFieldNombre.setBackground(Color.WHITE);
		textFieldNombre.setBounds(34, 244, 327, 23);
		add(textFieldNombre);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldMarca.setColumns(10);
		textFieldMarca.setBorder(null);
		textFieldMarca.setBackground(Color.WHITE);
		textFieldMarca.setBounds(36, 361, 326, 23);
		add(textFieldMarca);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(34, 139, 34));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Muebles de Exterior", "Herramientas Manuales", "Aberturas", "Muebles de Interior", "Camping", "Orgnaizadores", "Plomer\u00EDa", "Pisos y Revestimientos", "Electrodom\u00E9sticos", "Jard\u00EDn", "Automotor", "Electricidad", "Piletas, Parrillas y Juegos", "Pinturas", "Textil", "Navidad", "Herramientas El\u00E9ctricas", "Construcci\u00F3n", "Bazar y Hogar", "Ferreter\u00EDa", "Maderas", "Ba\u00F1os y Cocinas", "Iluminaci\u00F3n"}));
		comboBox.setBounds(30, 464, 344, 24);
		add(comboBox);
		
		textFieldPrecioDeVenta = new JTextField();
		textFieldPrecioDeVenta.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldPrecioDeVenta.setColumns(10);
		textFieldPrecioDeVenta.setBorder(null);
		textFieldPrecioDeVenta.setBackground(Color.WHITE);
		textFieldPrecioDeVenta.setBounds(406, 369, 223, 15);
		add(textFieldPrecioDeVenta);
		
		textFieldPrecioDeCompra = new JTextField();
		textFieldPrecioDeCompra.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldPrecioDeCompra.setColumns(10);
		textFieldPrecioDeCompra.setBorder(null);
		textFieldPrecioDeCompra.setBackground(Color.WHITE);
		textFieldPrecioDeCompra.setBounds(406, 286, 223, 15);
		add(textFieldPrecioDeCompra);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setEditable(false);
		textFieldCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantidad.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBorder(null);
		textFieldCantidad.setBackground(Color.WHITE);
		textFieldCantidad.setBounds(659, 286, 38, 16);
		add(textFieldCantidad);
		textFieldCantidad.setText("1");
		
	
		JTextPane textPane = new JTextPane();
		textPane.setBounds(406, 130, 386, 82);
		add(textPane);
		
		JLabel lblLblcancelar = new JLabel("");
		lblLblcancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldId.setText(null);
				textFieldNombre.setText(null);
		    	textFieldMarca.setText(null);
		    	textFieldCantidad.setText("1");
		    	textPane.setText(null);	
		    	comboBox.setSelectedItem(0);
		    	textFieldPrecioDeCompra.setText(null);
		    	textFieldPrecioDeVenta.setText(null);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lblLblcancelar.setBounds(389, 569, 177, 23);
		add(lblLblcancelar);
		
		
				
				
				lblFondo.setBounds(0, 0, 920, 640);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Producto.png")));
				
				
				JLabel lblRegistrarProducto = new JLabel("");
				lblRegistrarProducto.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ProductoDAO pd = new ProductoDAO();
						int a = 0;
						
						try {
						int sku = new Integer (textFieldId.getText().toString());
						}
						catch (Exception f) {
							JOptionPane.showMessageDialog(null, "SKU invalido.");
							a=1;
						}
					
						No_hay_error nh = new No_hay_error();
						if (textFieldPrecioDeCompra.getText().contains(",") || textFieldPrecioDeVenta.getText().contains(",")) {
							JOptionPane.showMessageDialog(null, "Para decimales utilice '.' en vez de ','");
				    		a =1;
						}
						
						if (nh.Solo_Numeros(textFieldId.getText())==false || nh.Solo_Letras_Y_Espacios(textFieldNombre.getText())==false || 
				    			nh.Solo_Letras_Y_Espacios(textFieldMarca.getText())==false || nh.Solo_Numeros(textFieldPrecioDeCompra.getText())==false 
				    			|| nh.Solo_Numeros(textFieldPrecioDeVenta.getText())==false) {
				    		JOptionPane.showMessageDialog(null, "Datos Incorrectos");
				    		a =1;
						}
						
						
						if (a==0) {
							Long id = new Long(textFieldId.getText());
					    	String nombre = textFieldNombre.getText();
					    	String marca = textFieldMarca.getText();
					    	int cantidad = new Integer(textFieldCantidad.getText());
					    	String descripcion = textPane.getText();
					    	String categoria = (String) comboBox.getSelectedItem();
					    	Float precioCompra = new Float(textFieldPrecioDeCompra.getText());
					    	Float precioVenta = new Float(textFieldPrecioDeVenta.getText());
					    	
					    	
						
					    	String s =  textFieldPrecioDeCompra.getText();
					    	
				    	
					    	if (precioCompra>precioVenta) {
					    		JOptionPane.showMessageDialog(null, "El precio de venta tiene que ser mayor al precio de compra.");
					    		textFieldPrecioDeCompra.setText(textFieldPrecioDeVenta.getText());
					    		textFieldPrecioDeVenta.setText(s);
					    		
					    		 precioCompra = new Float(textFieldPrecioDeCompra.getText());
						    	 precioVenta = new Float(textFieldPrecioDeVenta.getText());
								
					    		a =1;
								
							}
				    	
				    	
			
				    	
				    	
				    	//verificaciones
				    	if(a==0) {
				    		if(pd.existeId(id)==true) {
				    			JOptionPane.showMessageDialog(null, "SKU ya registrado.");
				    			textFieldId.setText(null);
				    			a = 1;
				    		}
				    		   		    	
				    		if(cantidad<0) {
				    			//lblDatosIncorrectos.setVisible(true);
				    			textFieldCantidad.setText("1");
				    			a = 1;
				    		}
				    		if(precioCompra<0) {
				    			//lblDatosIncorrectos.setVisible(true);
				    			textFieldPrecioDeCompra.setText(null);
				    			a = 1;
				    		}
				    		if(precioVenta<0) {
				    			//lblDatosIncorrectos.setVisible(true);
				    			textFieldPrecioDeVenta.setText(null);
				    			a = 1;
				    		}
				    	}
						
				    	
				    	if(a==0) {			    		
				    		Producto p = new Producto();
				    		
				    		p.setId(id);
				    		p.setNombre(nombre);
				    		p.setMarca(marca);
				    		p.setDescripcionDelProducto(descripcion);
				    		p.setCategoria(categoria);
				    		p.setPrecioDeCompra(precioCompra);
				    		p.setPrecioDeVenta(precioVenta);
				    		p.setCantidad(cantidad);
				    		
				    		pd.ALTA(p);
				    		
							
				    		
				    		
				    		if(ud.esAlmacen(new Integer(u.getDni()))==true) {
				    			ud.agregarProductoRegistrado(u.getDni());				    			
				    		}
				    		
				    		
				    		textFieldId.setText(null);
					    	textFieldNombre.setText(null);
					    	textFieldMarca.setText(null);
					    	textFieldCantidad.setText("1");
					    	textPane.setText(null);
					    	//comboBoxCategorias.setSelectedItem(0);
					    	textFieldPrecioDeCompra.setText(null);
					    	textFieldPrecioDeVenta.setText(null);
					    	//lblIdExistente.setVisible(false);
							//lblDatosIncompletos.setVisible(false);
							//lblDatosIncorrectos.setVisible(false);
					    	add(lblInicio);
				    	}
				    	}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
					}
					@Override
					public void mouseExited(MouseEvent e) {
					}
				});
				lblRegistrarProducto.setBounds(623, 569, 185, 29);
				add(lblRegistrarProducto);
				
		
	
		
		ActionListener volver = new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Stock panel = new Stock(frame, u);
		        frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
		        frame.validate();
		    }
		};
		
		JLabel lblSumar = new JLabel("");
		lblSumar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textFieldCantidad.getText().matches("^[A-Za-z!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$") == false) {
					if(new Integer(textFieldCantidad.getText()) > 0) {
						Integer cantidad = new Integer(textFieldCantidad.getText());
						cantidad++;
						textFieldCantidad.setText(cantidad.toString());
					}
					else {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
		    			textFieldCantidad.setText("1");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
	    			textFieldCantidad.setText("1");
				}
			}
		});
		lblSumar.setBounds(714, 277, 38, 35);
		add(lblSumar);
		
		JLabel lblRestar = new JLabel("");
		lblRestar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
		    	
				if(textFieldCantidad.getText().matches("^[A-Za-z!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$") == false) {				
					if(new Integer(textFieldCantidad.getText()) > 1) {
						Integer cantidad = new Integer(textFieldCantidad.getText());
						cantidad--;				
						textFieldCantidad.setText(cantidad.toString());
					}
					else {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
		    			textFieldCantidad.setText("1");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
	    			textFieldCantidad.setText("1");
				}
			}
		});
		lblRestar.setBounds(760, 277, 38, 35);
		add(lblRestar);
		add(lblFondo);
		
	
	}
}
