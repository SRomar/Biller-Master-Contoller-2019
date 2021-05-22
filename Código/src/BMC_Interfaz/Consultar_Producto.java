package BMC_Interfaz;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BMC_DAO.No_hay_error;
import BMC_DAO.ProductoDAO;
import BMC_DAO.UsuariosDAO;
import BMC_Modelo.Producto;
import BMC_Modelo.Usuario;

import javax.swing.JScrollPane;

public class Consultar_Producto extends JPanel {

	private JTable table;
	private JTextField textFieldNombre;
	
	ProductoDAO pd = new ProductoDAO();
	Producto p = new Producto();
	UsuariosDAO ud = new UsuariosDAO();
	
	public Consultar_Producto(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Consultar_Productos.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(838, 12, 60, 39);
		lblInicio.setToolTipText("Atrás");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
				if(ud.esAdmin(u.getDni())==true) {
					Stock panel = new Stock(frame, u);
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
				setCursor(c);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		setLayout(null);
		
		String[] nombresColumnas = {"SKU", "Nombre", "Existencias"};
		DefaultTableModel model = new DefaultTableModel(nombresColumnas, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 109, 639, 489);
		add(scrollPane);
		
		ArrayList<Producto> productos = pd.consultar_tabla();
		
		for(Producto p: productos) {
			String SKU = new Long(p.getId()).toString();
			String nombre = p.getNombre();
			String cantidad = new Integer(p.getCantidad()).toString();
			
			Object[] registro = {SKU, nombre, cantidad};
			model.addRow(registro);
		}
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		
		JTextField txtBuscar = new JTextField();
		txtBuscar.setBounds(700, 150, 210, 15);
		txtBuscar.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		txtBuscar.setBorder(null);
		txtBuscar.setBackground(SystemColor.text);
		add(txtBuscar);
		
		JLabel lblAmpliar = new JLabel("");
		lblAmpliar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				Producto prod = new Producto();
				int fila = table.getSelectedRow();
				
				String i = model.getValueAt(fila, 0).toString();
				
				long id = new Long(i);
				
				
				prod=pd.buscarProducto(id);
				String marca = prod.getMarca();
				String categoria = prod.getCategoria();
				String precioCompra = new Float(prod.getPrecioDeCompra()).toString();
				String precioVenta = new Float(prod.getPrecioDeVenta()).toString();
				String descripcion  = prod.getDescripcionDelProducto();
				
				JOptionPane.showMessageDialog(null, "Marca: " + marca + "\n" +
						"Categoría: " + categoria + "\n" +
						"Precio de Compra: " + precioCompra  + "\n" +
						"Precio de Venta" + precioVenta + "\n" +
						"Descripción: " + descripcion + "\n");
				
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lblAmpliar.setBounds(699, 567, 209, 31);
		add(lblAmpliar);
		
		JLabel lblBuscar = new JLabel("");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int a = 0;
				No_hay_error nh = new No_hay_error();
				
				
				
				if(nh.Solo_Numeros_y_Letras(txtBuscar.getText().toString())==false) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
			
				if(a == 0) {
					if(nh.textoVacio(txtBuscar.getText().toString())) {
						model.setRowCount(0);
						for(Producto p: productos) {
							String SKU = new Long(p.getId()).toString();
					
							String nombre = p.getNombre();
							String cantidad = new Integer(p.getCantidad()).toString();
							
							Object[] registro = {SKU, nombre, cantidad};
							model.addRow(registro);
						}
						
						a = 1;
					}
				}
			
				if (a == 0) {
					if (nh.Solo_Letras(txtBuscar.getText().toString())==true) {
						
						
						model.setRowCount(0);
						for(Producto p: productos) {
							
							
							
							Integer idd = (int) p.getId();
							String SKU = idd.toString();
					
							String nombre = p.getNombre();
							String cantidad = new Integer(p.getCantidad()).toString();
							
							Object[] registro = {SKU, nombre, cantidad};
							
							
							if (nombre.contentEquals(txtBuscar.getText().toString())) {
								
								model.addRow(registro);
							}
							
						}
						
						a = 1;
					}
				}
				
				
				if(a == 0) {
					long sku = new Long(txtBuscar.getText());
					
					if(sku<=0 || pd.existeId(sku) == false) {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
						a = 1;
					}
					if(a == 0) {
						model.setRowCount(0);
						p = pd.buscarProducto(sku);
						String nombre = p.getNombre();
						int cantidad = p.getCantidad();
											
						Object[] registro = {sku, nombre, cantidad};
						model.addRow(registro);
					}
					
				}
				else if (model.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					for(Producto p: productos) {
					
						String SKU = new Long(p.getId()).toString();
				
						String nombre = p.getNombre();
						String cantidad = new Integer(p.getCantidad()).toString();
						
						Object[] registro = {SKU, nombre, cantidad};
						model.addRow(registro);
					}
					
					a = 1;
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lblBuscar.setBounds(756, 188, 94, 31);
		add(lblBuscar);
				
		
		
		
		
		add(lblInicio);add(lblFondo);
	}

}
