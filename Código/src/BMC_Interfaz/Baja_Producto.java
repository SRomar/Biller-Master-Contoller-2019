package BMC_Interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import BMC_DAO.No_hay_error;
import BMC_DAO.ProductoDAO;
import BMC_Modelo.Producto;
import BMC_Modelo.Usuario;

import javax.swing.JTextField;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BMC_Modelo.Producto;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Baja_Producto extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTable table;
	private JTextField textFieldId;
	private JTextField textFieldUnidades;

	ProductoDAO pd = new ProductoDAO();
	Producto p = new Producto();
	ArrayList<Long> ids = new ArrayList<>();
	
	
	
	
	public Baja_Producto(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		setLayout(null);
		
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Baja_Producto.png")));
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(839, 11, 63, 40);
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
			
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Baja_Producto.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Baja_Producto.png")));
				
			}
		});
		add(lblInicio);
		
		
		
		String[] nombresColumnas = {"SKU", "Nombre", "Marca", "Categoria", "Cantidad"};
		DefaultTableModel model = new DefaultTableModel(nombresColumnas, 0);
		
		
		table = new JTable();
		table.setBorder(null);
		table.setGridColor(new Color(255, 255, 255));
		table.setModel(model);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(52, 41, 476, 569);
		add(scrollPane);
		scrollPane.setViewportView(table);
		
		textFieldId = new JTextField();
		textFieldId.setBorder(null);
		textFieldId.setBounds(566, 181, 330, 21);
		add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldUnidades = new JTextField();
		textFieldUnidades.setBackground(new Color(255, 255, 255));
		textFieldUnidades.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUnidades.setEditable(false);
		textFieldUnidades.setFocusable(false);
		textFieldUnidades.setBorder(null);
		textFieldUnidades.setBounds(566, 272, 63, 25);
		add(textFieldUnidades);
		textFieldUnidades.setColumns(10);
		textFieldUnidades.setText("1");
		
		JLabel lblQuitarProducto = new JLabel("");
		lblQuitarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
				
				No_hay_error nh = new No_hay_error();
				if(nh.Solo_Numeros(textFieldId.getText())==false) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				
				if(a == 0) {
					long id = new Long(textFieldId.getText());
					
					if(id<=0 || pd.existeId(id) == false) {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
						a = 1;
					}
					if(a == 0) {
						int b = 0;
						for(Long i: ids) {
							if(id == i) {							
								b=1;
							}
						}
						if(b == 0) {
							JOptionPane.showMessageDialog(null, "El producto no está en la tabla");
							a = 1;
						}
						
					}
					if(a == 0) {
						for(int i = 0; i < table.getRowCount(); i++) {
							long valor = (long) model.getValueAt(i, 0);
							if(id == valor) {
								model.removeRow(i);
							}
							
						}
						ids.remove(id);
						
					}
				}
			}
		});
		lblQuitarProducto.setBounds(608, 324, 260, 34);
		add(lblQuitarProducto);
		
		JLabel lblAnadirProducto = new JLabel("");
		lblAnadirProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
				No_hay_error nh = new No_hay_error();
				
				if(nh.Solo_Numeros(textFieldId.getText())==false || nh.Solo_Numeros(textFieldUnidades.getText())==false) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				if(textFieldId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Datos Incompletos");
					a = 1;
				}
				if(textFieldUnidades.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Datos Incompletos");
					a = 1;
				}
				
				if(a == 0) {
					long id = new Long(textFieldId.getText());
					int cantidad = new Integer(textFieldUnidades.getText());
					
					if(id<=0 || pd.existeId(id) == false) {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
						a = 1;
					}
					if(cantidad<=0 || pd.hayStock(id, cantidad) == false) {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
						a = 1;
					}
					
					if(a == 0 && model.getRowCount() > 0) {
						for(int i = 0; i <model.getRowCount(); i++) {
							if(textFieldId.getText().contentEquals(model.getValueAt(i, 0).toString())) {
								JOptionPane.showMessageDialog(null, "El Producto ya está en la tabla");
								a = 1;
							}
						}
					}
					
					if(a == 0) {
						p = pd.buscarProducto(id);
						int cantPosta = p.getCantidad()-cantidad;
						ids.add(id);
						Object[] registro = {id, p.getNombre(), p.getMarca(), p.getCategoria(), cantPosta};
						model.addRow(registro);
					}
				}
			}
		});
		lblAnadirProducto.setBounds(608, 376, 260, 34);
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
		lblSumar.setBounds(657, 272, 33, 27);
		add(lblSumar);
		
		JLabel lblRestar = new JLabel("");
		lblRestar.addMouseListener(new MouseAdapter() {
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
		lblRestar.setBounds(707, 272, 33, 27);
		add(lblRestar);
		
		JLabel lblDarDeBaja = new JLabel("");
		lblDarDeBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int a = 0;
				
				if(model.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Tabla vacía");
					a = 1;
				}
				if(a==0) {
					for(int i = 0; i < table.getRowCount(); i++) {
						long id = (long) model.getValueAt(i, 0);
						int cantidad = (int) model.getValueAt(i, 4);
						pd.BAJA(id, cantidad);				
					}
					model.setRowCount(0);
				}
			}
		});
		lblDarDeBaja.setBounds(621, 558, 215, 34);
		add(lblDarDeBaja);
		add(lblInicio);
		
		
		
		
		
		
		
		
		
		
		add(lblFondo);
	}

}
