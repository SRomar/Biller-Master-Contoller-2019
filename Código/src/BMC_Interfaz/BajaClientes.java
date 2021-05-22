package BMC_Interfaz;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import BMC_Modelo.Cliente;
import BMC_Modelo.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BMC_DAO.ClientesDAO;
import BMC_DAO.No_hay_error;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import BMC_Modelo.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;

public class BajaClientes extends JPanel {

	private JTable table;
	private JTextField textFieldDni;
	
	ClientesDAO cd = new ClientesDAO();
	
	Cliente cliente = new Cliente();
	ArrayList<Cliente> clientes = cd.consultar_tabla();
	private JLabel lblQuitarCliente;

	public BajaClientes(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Baja_Clientes.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(838, 12, 60, 39);
		lblInicio.setToolTipText("Atr√°s");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
		
				AbmClientes panel = new AbmClientes(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
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
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(51, 70, 434, 535);
		add(scrollPane);
		
		String[] nombresColumnas = {"Dni", "Nombre", "Apellido"};
		DefaultTableModel model = new DefaultTableModel(nombresColumnas, 0); 
		
		table = new JTable();
		table.setGridColor(Color.WHITE);
		table.setModel(model);
		scrollPane.setViewportView(table);		
		
		No_hay_error nh = new No_hay_error();
		
		
		lblQuitarCliente = new JLabel("");
		lblQuitarCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuitarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
			
			
				if(nh.Solo_Numeros(textFieldDni.getText().toString())==false) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				if(a == 0) {
					int  dni = new Integer(textFieldDni.getText());
					
					if(dni<=0 || cd.existeDni(dni) == false) {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
						a = 1;
					}
					
					if(a == 0) {
						int b = 0;
						for(Cliente c: clientes) {
							if(dni == c.getDni()) {							
								b=1;
							}
						}
						if(b == 0) {
							JOptionPane.showMessageDialog(null, "El cliente no est· en la tabla");
							a = 1;
						}
						
					}
					
					if(a == 0) {
						for(int i = 0; i < table.getRowCount(); i++) {
							int valor = new Integer (model.getValueAt(i, 0).toString());
							if(dni == valor) {
								model.removeRow(i);
								table.remove(i);
								table.revalidate();
							}
							
							
						}
					
	
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
		lblQuitarCliente.setBounds(624, 243, 234, 25);
		add(lblQuitarCliente);
		
		JLabel lblAnadirCliente = new JLabel("");
		lblAnadirCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAnadirCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
				
				if(nh.Solo_Numeros(textFieldDni.getText())==false) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				
				
				if(a == 0) {
					int dni = new Integer(textFieldDni.getText());				
					
					if(dni<=9999999 || cd.existeDni(dni) == false) {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
						a = 1;
					}
					if(cd.existeDni(dni) == false) {
						JOptionPane.showMessageDialog(null, "No se encontro DNI");
						a = 1;
					}
					if(a == 0 && model.getRowCount() > 0) {
						for(int i = 0; i <model.getRowCount(); i++) {
							if(textFieldDni.getText().contentEquals(model.getValueAt(i, 0).toString())) {
								JOptionPane.showMessageDialog(null, "El cliente ya est· en la tabla");
								a = 1;
							}
						}
					}
					
					if(a == 0) {
						cliente = cd.buscarCliente(dni);					
						
						Object[] registro = {dni, cliente.getNombre(), cliente.getApellido()};
						model.addRow(registro);
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
		lblAnadirCliente.setBounds(624, 191, 234, 31);
		add(lblAnadirCliente);
		
		JLabel lblVolver = new JLabel("");
		lblVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AbmClientes panel = new AbmClientes(frame, u);
		        frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
		        frame.validate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lblVolver.setBounds(834, 12, 64, 39);
		add(lblVolver);
		
		JLabel lblDarDeBaja = new JLabel("");
		lblDarDeBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
				
				if(model.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Tabla vacÌa");
					a = 1;
				}
				if(a==0) {
					for(int i = 0; i < table.getRowCount(); i++) {
						int dni = new Integer(model.getValueAt(i, 0).toString());
						cd.BAJA(dni);				
					}
					model.setRowCount(0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lblDarDeBaja.setBounds(594, 574, 264, 31);
		add(lblDarDeBaja);
	
		textFieldDni = new JTextField();
		textFieldDni.setBorder(null);
		textFieldDni.setOpaque(false);
		textFieldDni.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldDni.setBounds(563, 144, 326, 25);
		add(textFieldDni);
		textFieldDni.setColumns(10);
		
		
		add(lblInicio);add(lblFondo);
		}

}
