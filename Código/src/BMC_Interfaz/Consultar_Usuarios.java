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

import BMC_Modelo.Producto;
import BMC_Modelo.Usuario;
import javax.swing.JScrollPane;

public class Consultar_Usuarios extends JPanel {

	private JTable table;
	
	
	UsuariosDAO ud = new UsuariosDAO();
	
	public Consultar_Usuarios(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
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
		
		
		
		String[] nombresColumnas = {"Dni", "Nombre", "Apellido", "Tipo"};
		DefaultTableModel model = new DefaultTableModel(nombresColumnas, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 109, 639, 489);
		add(scrollPane);
		
		ArrayList<Usuario> usuarios = ud.consultar_tabla();
		
		for(Usuario us: usuarios) {
			int DNI1 = us.getDni();
			String dni = Integer.toString(DNI1);
			String nombre = us.getNombre();
			String apellido = us.getApellido();
			String tipo = us.getTipo();
			
			Object[] registro = {dni, nombre, apellido, tipo};
			model.addRow(registro);
			
		}
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		add(lblInicio);
		
		JLabel lblPerfilDelUsuario = new JLabel("");
		lblPerfilDelUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectionModel().isSelectionEmpty()!=true) {
					int i = table.getSelectedRow();
					int c = Integer.parseInt(table.getValueAt(i, 0).toString());
					Perfil_Usuario panel = new Perfil_Usuario(frame, c, u);
					setVisible(false);
					frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
				}
				else {
					JOptionPane.showMessageDialog(null, "Seleccione a un usuario.");
				}
			
			}
		});
		
		lblPerfilDelUsuario.setBounds(700, 571, 210, 31);
		add(lblPerfilDelUsuario);
		
		
		JTextField txtBuscar = new JTextField();
		txtBuscar.setBounds(700, 150, 210, 15);
		txtBuscar.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		txtBuscar.setBorder(null);
		txtBuscar.setBackground(SystemColor.text);
		add(txtBuscar);
		
		JLabel lblBuscar = new JLabel("");
		lblBuscar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int a = 0;
			No_hay_error nh = new No_hay_error();
			
			if(a == 0) {
				if(nh.textoVacio(txtBuscar.getText().toString())==true) {
					model.setRowCount(0);
					for(Usuario us: usuarios) {
		
						int DNI1 = us.getDni();
						String dni = Integer.toString(DNI1);
						String nombre = us.getNombre();
						String apellido = us.getApellido();
						String tipo = us.getTipo();
						
						Object[] registro = {dni, nombre, apellido, tipo};
						model.addRow(registro);
					}
					
					a = 1;
				}
			}
			
			if (nh.Solo_Numeros(txtBuscar.getText().toString())==true) {
				
				model.setRowCount(0);
				
				for(Usuario us: usuarios) {
					int DNI1 = us.getDni();
					String dni = Integer.toString(DNI1);
					String nombre = us.getNombre();
					String apellido = us.getApellido();
					String tipo = us.getTipo();
					
					Object[] registro = {dni, nombre, apellido, tipo};
					
					if (dni.contentEquals(txtBuscar.getText().toString())) {
						
						model.addRow(registro);
					
					
						}					
					}
		
				a = 1;				
			}
			else if (nh.Solo_Letras(txtBuscar.getText().toString())==true) {
				
				model.setRowCount(0);
				
				for(Usuario us: usuarios) {
					int DNI1 = us.getDni();
					String dni = Integer.toString(DNI1);
					String nombre = us.getNombre();
					String apellido = us.getApellido();
					String tipo = us.getTipo();
					
					Object[] registro = {dni, nombre, apellido, tipo};
					
					if (nombre.contentEquals(txtBuscar.getText().toString())|| apellido.contentEquals(txtBuscar.getText().toString()) || tipo.contentEquals(txtBuscar.getText().toString())) {
						
						model.addRow(registro);
					
					}				
				a = 1;		
				
			}
				}
			else if (nh.letras_y_numeros_separados(txtBuscar.getText().toString())==false) {
				JOptionPane.showMessageDialog(null, "Datos Incorrectos");
				a = 1;
			}
			if (model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null, "Datos Incorrectos");
				for(Usuario us: usuarios) {
				
					int DNI1 = us.getDni();
					String dni = Integer.toString(DNI1);
					String nombre = us.getNombre();
					String apellido = us.getApellido();
					String tipo = us.getTipo();
					
					Object[] registro = {dni, nombre, apellido, tipo};
					
					
						
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
		lblBuscar.setBounds(765, 195, 85, 15);
		add(lblBuscar);
		
		
		add(lblInicio);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Consultar_Usuarios.png")));
		add(lblFondo);

	}
}
