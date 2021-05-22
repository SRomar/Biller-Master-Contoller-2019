package BMC_Interfaz;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BMC_DAO.No_hay_error;
import BMC_DAO.UsuariosDAO;
import BMC_Modelo.Usuario;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Baja_Usuarios extends JPanel {
	private JTextField textFieldDni;
	private JTable table;
	
	UsuariosDAO ud = new UsuariosDAO();

	public Baja_Usuarios(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Baja_Usuarios.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(838, 12, 60, 39);
		lblInicio.setToolTipText("Atrás");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
				
				Personal panel = new Personal(frame, u);
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
		add(lblInicio);textFieldDni = new JTextField();
		textFieldDni.setBorder(null);
		textFieldDni.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDni.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldDni.setBounds(561, 145, 326, 20);
		add(textFieldDni);
		textFieldDni.setColumns(10);
		
		String[] nombresColumnas = {"Dni", "Nombre", "Apellido", "Tipo"};
		DefaultTableModel model = new DefaultTableModel(nombresColumnas, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 68, 436, 538);
		add(scrollPane);
		
		ArrayList<Usuario> usuarios = ud.consultar_tabla();
		
		for(Usuario us: usuarios) {
			String dni = new Long(us.getDni()).toString();
			String nombre =us.getNombre();
			String apellido = us.getApellido();
			String tipo = us.getTipo();
			
			Object[] resgistro = {dni, nombre, apellido, tipo};
			model.addRow(resgistro);
		}
		
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblBuscar = new JLabel("");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
				Usuario usuario = new Usuario();
				No_hay_error nh = new No_hay_error();
				
				if(nh.Solo_Numeros(textFieldDni.getText())==false) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				
				
				if(a == 0) {
					int dni = new Integer(textFieldDni.getText());
					
					if(dni<=0 || ud.existeDni(dni) == false) {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
						a = 1;
					}
					if(a == 0) {
						model.setRowCount(0);
						usuario = ud.buscarUsuario(dni);
						String nombre = usuario.getNombre();
						String apellido = usuario.getApellido();
						String tipo = usuario.getTipo();
											
						Object[] registro = {dni, nombre, apellido, tipo};
						model.addRow(registro);
					}
					
				}
			}
		});
		lblBuscar.setBounds(648, 193, 160, 31);
		add(lblBuscar);
		
		JLabel lblEliminarUsuario = new JLabel("");
		lblEliminarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usuario usuario = new Usuario();
				
				if(model.getRowCount()==1) {
					String d = model.getValueAt(0, 0).toString();
					int dni = new Integer(d);
					ud.BAJA(dni);
				}
				else {
				int fila = table.getSelectedRow();
				
				String d = model.getValueAt(fila, 0).toString();				
				int dni = new Integer(d);
				
				ud.BAJA(dni);
				}
			}
		});
		lblEliminarUsuario.setBounds(597, 567, 263, 39);
		add(lblEliminarUsuario);
		
		add(lblFondo);
	}
}
