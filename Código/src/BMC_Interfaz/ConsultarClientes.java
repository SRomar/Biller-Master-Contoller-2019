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

import BMC_DAO.ClientesDAO;
import BMC_DAO.No_hay_error;
import BMC_DAO.UsuariosDAO;
import BMC_Modelo.Cliente;
import BMC_Modelo.Usuario;
import javax.swing.JScrollPane;

public class ConsultarClientes extends JPanel {
	
	private JTable table;
	private JTextField textFieldNombre;
	
	ClientesDAO cd = new ClientesDAO();
	UsuariosDAO ud = new UsuariosDAO();
	
	public ConsultarClientes(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Consultar_Clientes.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(838, 12, 60, 39);
		lblInicio.setToolTipText("Atrás");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);			
				if(ud.esAdmin(u.getDni())==true) {
					AbmClientes panel = new AbmClientes(frame, u);
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
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Consultar_Clientes_Retro.png")));
				setCursor(c);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Consultar_Clientes.png")));
				
			}
		});
		setLayout(null);
		
		String[] nombresColumnas = {"Dni", "Nombre", "Apellido"};
		DefaultTableModel model = new DefaultTableModel(nombresColumnas, 0);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 109, 639, 489);
		add(scrollPane);
		
		ArrayList<Cliente> clientes = cd.consultar_tabla();
		
		for(Cliente cl: clientes) {
			String d = new Long(cl.getDni()).toString();
			String nombre = cl.getNombre();
			String apellido = cl.getApellido();
			
			Object[] registro = {d, nombre, apellido};
			model.addRow(registro);
		}
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		JTextField txtBuscar = new JTextField();
		txtBuscar.setBounds(704, 149, 194, 15);
		txtBuscar.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		txtBuscar.setBorder(null);
		txtBuscar.setBackground(SystemColor.text);
		add(txtBuscar);
		
		
		JLabel lblAmpliar = new JLabel("");
		lblAmpliar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = new Cliente();
				
				int fila = table.getSelectedRow();
				
				String d = model.getValueAt(fila, 0).toString();
				
				int dni = new Integer(d);
				
				
				cli = cd.buscarCliente(dni);
				String domicilio = cli.getDomicilio();
				String telefono = cli.getTelefono().toString();
				
				
				JOptionPane.showMessageDialog(null, "Domicilio: " + domicilio + "\n" +
						"Teléfono: " + telefono + "\n");
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Consultar_Clientes_Amp.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Consultar_Clientes.png")));
			}
		});
		lblAmpliar.setBounds(706, 567, 202, 39);
		add(lblAmpliar);
		
		JLabel lblBuscar = new JLabel("");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
				Cliente cliente = new Cliente();
				No_hay_error nh = new No_hay_error();
				
				if (nh.Solo_Numeros(txtBuscar.getText().toString())==true) {
					
					model.setRowCount(0);
					
					for(Cliente c: clientes) {
						int DNI1 = c.getDni();
						String dni = Integer.toString(DNI1);
						String nombre = c.getNombre();
						String apellido = c.getApellido();
			
						Object[] registro = {dni, nombre, apellido};
						
						if (dni.contentEquals(txtBuscar.getText().toString())) {
							
							model.addRow(registro);
						
						
							}					
						}
			
					a = 1;				
				}
				else if (nh.Solo_Letras(txtBuscar.getText().toString())) {
					
					model.setRowCount(0);
					
					for(Cliente c: clientes) {
						int DNI1 = c.getDni();
						String dni = Integer.toString(DNI1);
						String nombre = c.getNombre();
						String apellido = c.getApellido();

						Object[] registro = {dni, nombre, apellido};
						
						if (nombre.contentEquals(txtBuscar.getText().toString()) || apellido.contentEquals(txtBuscar.getText().toString())) {
							
							model.addRow(registro);
						
						}				
					a = 1;		
					
				}
					}
				else if (nh.letras_y_numeros_separados(txtBuscar.getText().toString())==false) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				else if (nh.textoVacio(txtBuscar.getText().toString())) {
					model.setRowCount(0);
					for(Cliente c: clientes) {
						int DNI1 = c.getDni();
						String dni = Integer.toString(DNI1);
						String nombre = c.getNombre();
						String apellido = c.getApellido();

						
						Object[] registro = {dni, nombre, apellido};
						
						
							
							model.addRow(registro);
						
						}				
					a = 1;			
				}
				 if (model.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					for(Cliente c: clientes) {
					
						int DNI1 = c.getDni();
						String dni = Integer.toString(DNI1);
						String nombre = c.getNombre();
						String apellido = c.getApellido();
		
						
						Object[] registro = {dni, nombre, apellido};
						
						
							
							model.addRow(registro);
							
					}
					
					a = 1;
					
				}
				
					
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Consultar_Clientes_Buscar.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Consultar_Clientes.png")));
			}
		});
		lblBuscar.setBounds(736, 187, 133, 23);
		add(lblBuscar);
		
		
		
		add(lblInicio);add(lblFondo);
	}

}
