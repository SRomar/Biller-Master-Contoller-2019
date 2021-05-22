package BMC_Interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import BMC_DAO.UsuariosDAO;
import BMC_Modelo.EmpleadoDeAlmacen;
import BMC_Modelo.Usuario;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Iniciar_Sesion extends JPanel {
	private JTextField nombRe;

	/**
	 * Create the panel.
	 */
	public Iniciar_Sesion(JFrame frame) {
		setLayout(null);
		setSize(920, 640);
		JPasswordField p_1 = new JPasswordField(10);
		UsuariosDAO ud = new UsuariosDAO();
		JLabel lblFondo = new JLabel("");
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBounds(385, 391, 155, 28);
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("Biller.png"));

		frame.setIconImage(img.getImage());

		nombRe = new JTextField();
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {

				if (ud.validacionDeUsuario(nombRe.getText().toString(), p_1.getText().toString()) == true) {

					Usuario us = new Usuario();

					if (ud.esAdmin(ud.getDni(nombRe.getText().toString())) == true) {
						us.setUsuario(nombRe.getText().toString());
						us.setContrasenia(p_1.toString());
						us.setDni(ud.getDni(nombRe.getText().toString()));
						Principal panel = new Principal(frame, us);
						frame.setContentPane(panel);
						setVisible(false);
						frame.validate();
						cerrarminimizar cm = new cerrarminimizar(frame);
						frame.add(cm);

					} else if (ud.esVendedor(ud.getDni(nombRe.getText().toString()))) {
						Usuario u = ud.buscarUsuario(ud.getDni(nombRe.getText().toString()));
						u.setDni(new Integer(ud.getDni(nombRe.getText().toString())));						
						Principal_Vendedor panel = new Principal_Vendedor(frame, u);
						frame.setContentPane(panel);
						setVisible(false);
						frame.validate();
						cerrarminimizar cm = new cerrarminimizar(frame);
						frame.add(cm);
					} else if (ud.esAlmacen(ud.getDni(nombRe.getText().toString()))) {
						Usuario u = ud.buscarUsuario(ud.getDni(nombRe.getText().toString()));
						u.setDni(new Integer(ud.getDni(nombRe.getText().toString())));
						Principal_Almacenero panel = new Principal_Almacenero(frame, u);
						frame.setContentPane(panel);
						setVisible(false);
						frame.validate();
						cerrarminimizar cm = new cerrarminimizar(frame);
						frame.add(cm);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Nombre o contrseña inválidos.", "Datos Inválidos.",
							JOptionPane.WARNING_MESSAGE);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Menu inicio plantilla.png")));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("inicio_ingresar.png")));
			}
		});
		add(lblNewLabel);

		nombRe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

			}
		});
		nombRe.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		nombRe.setBorder(null);
		nombRe.setBackground(SystemColor.controlHighlight);
		nombRe.setBounds(366, 202, 194, 28);
		add(nombRe);
		nombRe.setColumns(10);

		p_1.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		p_1.setColumns(10);
		p_1.setBorder(null);
		p_1.setBackground(SystemColor.controlHighlight);
		p_1.setBounds(366, 282, 194, 28);
		add(p_1);

		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Menu inicio plantilla.png")));
		lblFondo.setBounds(0, 0, 920, 640);
		add(lblFondo);

	}
}
