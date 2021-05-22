package BMC_Interfaz;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;

import BMC_DAO.UsuariosDAO;
import BMC_Modelo.Usuario;

public class Perfil_Usuario extends JPanel {

	/**
	 * Create the panel.
	 */
	public Perfil_Usuario(JFrame frame, int DNI, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);

		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Perfil_Usuario.png")));

		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(844, 11, 54, 39);
		lblInicio.setToolTipText("Atrás");

		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);

				Consultar_Usuarios panel = new Consultar_Usuarios (frame, u);
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
		
		
		UsuariosDAO UD = new UsuariosDAO();
		
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setBounds(108, 100, 163, 163);
	
		ImageIcon imagen = new ImageIcon(UD.buscarUsuario(DNI).getFoto());
		lblFoto.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH)));
		
		
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBackground(Color.WHITE);
		lblFoto.revalidate();
		add(lblFoto);
		
		
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		
		
		lblUsuario.setText(UD.buscarUsuario(DNI).getUsuario());
		lblUsuario.revalidate();

		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(new Color(154, 205, 50));
		lblUsuario.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblUsuario.setBounds(471, 106, 296, 29);
		add(lblUsuario);
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setText(UD.buscarUsuario(DNI).getNombre() + " " + UD.buscarUsuario(DNI).getApellido());
		lblNombre.revalidate();
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(new Color(154, 205, 50));
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNombre.setBounds(471, 165, 307, 29);
		add(lblNombre);
		JLabel lblID = new JLabel("DNI");
		
		int DNI1 = UD.buscarUsuario(DNI).getDni();
		String DNI2 = Integer.toString(DNI1);
		
		lblID.setText(DNI2);
		lblID.revalidate();
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setForeground(new Color(154, 205, 50));
		lblID.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblID.setBounds(471, 230, 307, 29);
		
		add(lblID);
		add(lblFondo);
		

	}
}
