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

import BMC_DAO.No_hay_error;
import BMC_DAO.UsuariosDAO;
import BMC_Modelo.Usuario;

import java.awt.Font;

public class IngresoDniModificacionUsuario extends JPanel {
	private JTextField textFieldDni;

	UsuariosDAO ud = new UsuariosDAO();
	
	public IngresoDniModificacionUsuario(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("dni_mod_vendedor.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(847, 12, 63, 39);
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
		add(lblInicio);
		
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
					
					if(dni<10000000 || ud.existeDni(dni)==false) {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
						a = 1;
					}
					if(a == 0) {
						Mod_Usuarios panel = new Mod_Usuarios(frame, dni, u);
			   			frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
			   			frame.validate();
					}
				}
			}
		});
		lblModificar.setBounds(379, 560, 179, 33);
		add(lblModificar);
		
		textFieldDni = new JTextField();
		textFieldDni.setBorder(null);
		textFieldDni.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldDni.setBounds(300, 284, 324, 20);
		add(textFieldDni);
		textFieldDni.setColumns(10);
		
		
		
		
		
		add(lblFondo);
	}
}
