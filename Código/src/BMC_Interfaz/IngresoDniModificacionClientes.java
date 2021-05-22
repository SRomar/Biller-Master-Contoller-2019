package BMC_Interfaz;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BMC_DAO.ClientesDAO;
import BMC_DAO.No_hay_error;
import BMC_Modelo.Usuario;

import java.awt.Font;

public class IngresoDniModificacionClientes extends JPanel {
	private JTextField textFieldDni;

	ClientesDAO cd = new ClientesDAO();
	
	public IngresoDniModificacionClientes(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("dni_mod_cliente.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(838, 12, 60, 39);
		lblInicio.setToolTipText("Atrás");
		
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
		add(lblInicio);
		
		textFieldDni = new JTextField();
		textFieldDni.setBorder(null);
		textFieldDni.setBounds(301, 282, 320, 25);
		add(textFieldDni);
		textFieldDni.setColumns(10);
		
		JLabel lblModificar = new JLabel("");
		lblModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
				No_hay_error nh = new No_hay_error();

				if(nh.Solo_Numeros(textFieldDni.getText())==false || textFieldDni.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				
				if(a == 0) {
					int dni = new Integer(textFieldDni.getText());
					
					if(dni<10000000 || cd.existeDni(dni)==false) {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
						a = 1;
					}
					if(a == 0) {
						Mod_Clientes panel = new Mod_Clientes(frame, dni, u);
			   			frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
			   			frame.validate();
					}
				}
			}
		});
		lblModificar.setBounds(369, 556, 187, 39);
		add(lblModificar);
		
		
		
		
		
		
		add(lblFondo);
	}

}
