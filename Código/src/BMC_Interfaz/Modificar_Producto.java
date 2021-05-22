package BMC_Interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.TextArea;
import javax.swing.JTextField;

import BMC_DAO.No_hay_error;
import BMC_DAO.ProductoDAO;
import BMC_Modelo.Producto;
import BMC_Modelo.Usuario;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class Modificar_Producto extends JPanel {
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldMarca;
	private JTextField textFieldPrecioDeCompra;
	private JTextField textFieldPrecioDeVenta;
	private JTextField textFieldCantidad;

	ProductoDAO pd = new ProductoDAO();
	/**
	 * Create the panel.
	 */
	public Modificar_Producto(JFrame frame, int s, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		setLayout(null);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Mod_Producto.png")));
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(827, 18, 65, 39);
		lblInicio.setToolTipText("Atrás");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stock panel = new Stock(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Mod_Producto.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Mod_Producto.png")));
				
			}
		});
		
		
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(414, 125, 373, 90);
		add(textAreaDescripcion);
		textAreaDescripcion.setLineWrap(true);
		
		textFieldId = new JTextField();
		textFieldId.setBorder(null);
		textFieldId.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldId.setBounds(38, 125, 322, 27);
		add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldNombre.setBorder(null);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(38, 242, 322, 27);
		add(textFieldNombre);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setBorder(null);
		textFieldMarca.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldMarca.setColumns(10);
		textFieldMarca.setBounds(38, 363, 322, 22);
		add(textFieldMarca);
		
		JComboBox comboBoxCategorias = new JComboBox();
		comboBoxCategorias.setForeground(new Color(34, 139, 34));
		comboBoxCategorias.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxCategorias.setModel(new DefaultComboBoxModel(new String[] {"Muebles de Exterior", "Herramientas Manuales", "Aberturas", "Muebles de Interior", "Camping", "Orgnaizadores", "Plomer\u00EDa", "Pisos y Revestimientos", "Electrodom\u00E9sticos", "Jard\u00EDn", "Automotor", "Electricidad", "Piletas, Parrillas y Juegos", "Pinturas", "Textil", "Navidad", "Herramientas El\u00E9ctricas", "Construcci\u00F3n", "Bazar y Hogar", "Ferreter\u00EDa", "Maderas", "Ba\u00F1os y Cocinas", "Iluminaci\u00F3n"}));
		comboBoxCategorias.setBounds(33, 460, 334, 22);
		add(comboBoxCategorias);
		
		textFieldPrecioDeCompra = new JTextField();
		textFieldPrecioDeCompra.setBorder(null);
		textFieldPrecioDeCompra.setBounds(414, 288, 204, 14);
		add(textFieldPrecioDeCompra);
		textFieldPrecioDeCompra.setColumns(10);
		
		textFieldPrecioDeVenta = new JTextField();
		textFieldPrecioDeVenta.setBorder(null);
		textFieldPrecioDeVenta.setColumns(10);
		textFieldPrecioDeVenta.setBounds(414, 369, 216, 14);
		add(textFieldPrecioDeVenta);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setEditable(false);
		textFieldCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantidad.setBorder(null);
		textFieldCantidad.setBounds(660, 283, 37, 24);
		add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setText("1");
		
		JLabel lblSumar = new JLabel("");
		lblSumar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textFieldCantidad.getText().matches("^[A-Za-z!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$") == false) {
					if(new Integer(textFieldCantidad.getText()) >=0) {
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
		lblSumar.setBounds(717, 278, 32, 29);
		add(lblSumar);
		
		JLabel lblRestar = new JLabel("");
		lblRestar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textFieldCantidad.getText().matches("^[A-Za-z!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$") == false) {				
					if(new Integer(textFieldCantidad.getText()) >0) {
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
		lblRestar.setBounds(762, 278, 32, 29);
		add(lblRestar);
		
		JLabel lblModificarProducto = new JLabel("");
		lblModificarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Producto p = new Producto();
		    	int a = 0;
		    	No_hay_error nh = new No_hay_error();
		    	
		    	try {
					int sku = new Integer (textFieldId.getText().toString());
					}
					catch (Exception f) {
						JOptionPane.showMessageDialog(null, "SKU invalido.");
						a=1;
					}
		    	if (textFieldPrecioDeCompra.getText().contains(",") || textFieldPrecioDeVenta.getText().contains(",")) {
					JOptionPane.showMessageDialog(null, "Para decimales utilice '.' en vez de ','");
		    		a =1;
				}
				
		    	if (nh.Solo_Numeros(textFieldId.getText())==false || nh.Solo_Letras(textFieldNombre.getText())==false || nh.Solo_Letras_Y_Espacios(textFieldNombre.getText())==false
		    			|| nh.Solo_Numeros(textFieldPrecioDeCompra.getText())==false || nh.Solo_Numeros(textFieldPrecioDeVenta.getText())==false || nh.Solo_Numeros(textFieldCantidad.getText())==false) {
		    		JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
		    	
				if(a == 0) {
		    	long sku = new Long(textFieldId.getText());
		    	String nombre = textFieldNombre.getText();
		    	String marca = textFieldMarca.getText();
		    	int cantidad = new Integer(textFieldCantidad.getText());
		    	String descripcion = textAreaDescripcion.getText();
		    	String categoria = (String) comboBoxCategorias.getSelectedItem();
		    	float precioCompra = new Float(textFieldPrecioDeCompra.getText());
		    	float precioVenta = new Float(textFieldPrecioDeVenta.getText());
		    	
		    	String S = textFieldPrecioDeCompra.getText();
				
		    	
		    	if (precioCompra > precioVenta) {
		    		JOptionPane.showMessageDialog(null, "El precio de compra debe ser menor al de venta.");
		    		
		    		
		    		
		    		textFieldPrecioDeCompra.setText(textFieldPrecioDeVenta.getText());
		    		textFieldPrecioDeVenta.setText(S);
		    		
		    		
		    		 precioCompra = new Float(textFieldPrecioDeCompra.getText());
			    	 precioVenta = new Float(textFieldPrecioDeVenta.getText());
					
		    		a =1;
					
				}
		    	
		    	
		    	//datos incompletos
		    	if(textFieldId.equals("") || nombre.equals("") || marca.equals("") || textFieldCantidad.getText().equals("") || descripcion.equals("") || textFieldPrecioDeCompra.getText().equals("") || textFieldPrecioDeVenta.getText().equals("")) {
		    		JOptionPane.showMessageDialog(null, "Datos Incompletos");
		    		a = 1;
		    	}
		    	
		    	
		    	//verificaciones
		    	if(a==0) {
		    		if(sku<=0 || pd.existeId(sku)==false) {
		    			JOptionPane.showMessageDialog(null, "Datos Incorrectos");
		    			textFieldId.setText(null);
		    			a = 1;
		    		}
		    	
		    		if(cantidad<=0) {
		    			JOptionPane.showMessageDialog(null, "Datos Incorrectos");
		    			textFieldCantidad.setText(null);
		    			a = 1;
		    		}
		    		if(precioCompra<0) {
		    			JOptionPane.showMessageDialog(null, "Datos Incorrectos");
		    			textFieldPrecioDeCompra.setText(null);
		    			a = 1;
		    		}
		    		if(precioVenta<0) {
		    			JOptionPane.showMessageDialog(null, "Datos Incorrectos");
		    			textFieldPrecioDeVenta.setText(null);
		    			a = 1;
		    		}
		    	}
				
		    	
		    	
		    	if(a==0){
		    		pd.MODIFICACION(sku, nombre, marca, descripcion, categoria, precioCompra, precioVenta, cantidad);
		    		
		    		p.setNombre(nombre);
		    		p.setMarca(marca);
		    		p.setDescripcionDelProducto(descripcion);
		    		p.setCategoria(categoria);
		    		p.setPrecioDeCompra(precioCompra);
		    		p.setPrecioDeVenta(precioVenta);
		    		p.setCantidad(cantidad);
		    			    		
		    		
		    		
		    		JOptionPane.showMessageDialog(null, "Modificacion realizada.");
			   		textFieldCantidad.setText("1");
			   		
		    	}
			   }	    	
	    
		    }
				
			
		});
		lblModificarProducto.setBounds(619, 567, 194, 27);
		add(lblModificarProducto);
		add(lblInicio);
		
		
		
		Producto pr = pd.buscarProducto(s);
		
		int sku = (int) pr.getId();
		String str1 = Integer.toString(sku); 
		textFieldId.setText(str1);
		textFieldNombre.setText(pr.getNombre());
		textFieldMarca.setText(pr.getMarca());
		textFieldPrecioDeCompra.setText(new Float(pr.getPrecioDeCompra()).toString());
		textFieldPrecioDeVenta.setText(new Float(pr.getPrecioDeVenta()).toString());
		textFieldCantidad.setText(new Integer(pr.getCantidad()).toString());
		comboBoxCategorias.setSelectedItem(pr.getCategoria());
		textAreaDescripcion.setText(pr.getDescripcionDelProducto());
		
		JLabel lblVaciarCampos = new JLabel("");
		lblVaciarCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNombre.setText(null);
		   		textFieldMarca.setText(null);
		   		textAreaDescripcion.setText(null);
		   		comboBoxCategorias.setSelectedItem(0);
		   		textFieldPrecioDeCompra.setText(null);
		   		textFieldPrecioDeVenta.setText(null);
		   		textFieldCantidad.setText("1");
			}
		});
		lblVaciarCampos.setBounds(383, 567, 188, 27);
		add(lblVaciarCampos);
		
		
		
		add(lblFondo);

	}
}
