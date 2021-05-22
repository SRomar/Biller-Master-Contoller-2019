package BMC_Interfaz;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import BMC_DAO.UsuariosDAO;
import BMC_Modelo.Usuario;
import java.awt.Font;
import java.awt.Color;

public class Mi_Perfil extends JPanel {

	UsuariosDAO ud = new UsuariosDAO();
	
	public Mi_Perfil(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Mi_Perfil.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(835, 22, 60, 39);
		lblInicio.setToolTipText("Atrás");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
				if (ud.esAlmacen(u.getDni()) == true) {
					Principal_Almacenero panel = new Principal_Almacenero(frame, u);
					setVisible(false);
					frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
				}
				else if(ud.esVendedor(u.getDni()) == true) {
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
		add(lblInicio);
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBounds(95, 106, 240, 228);
		add(lblFoto);
		
		JLabel lblDni = new JLabel("as");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setForeground(new Color(154, 205, 50));
		lblDni.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDni.setBounds(541, 112, 217, 17);
		add(lblDni);
		
		JLabel lblNombre = new JLabel("as");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(new Color(154, 205, 50));
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNombre.setBounds(541, 155, 217, 27);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("as");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setForeground(new Color(154, 205, 50));
		lblApellido.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblApellido.setBounds(541, 207, 217, 27);
		add(lblApellido);
		
		JLabel lblUsuario = new JLabel("as");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(new Color(154, 205, 50));
		lblUsuario.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblUsuario.setBounds(240, 364, 211, 27);
		add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("as");
		lblContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasenia.setForeground(new Color(154, 205, 50));
		lblContrasenia.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblContrasenia.setBounds(240, 422, 211, 27);
		add(lblContrasenia);
		
		JLabel lblDomicilio = new JLabel("as");
		lblDomicilio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDomicilio.setForeground(new Color(154, 205, 50));
		lblDomicilio.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDomicilio.setBounds(567, 260, 191, 27);
		add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("as");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setForeground(new Color(154, 205, 50));
		lblTelefono.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTelefono.setBounds(541, 314, 217, 17);
		add(lblTelefono);
		
		JLabel lblTipo = new JLabel("as");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setForeground(new Color(154, 205, 50));
		lblTipo.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTipo.setBounds(240, 478, 211, 27);
		add(lblTipo);
		
		
		
		lblDni.setText(new Integer(u.getDni()).toString());
		lblNombre.setText(u.getNombre());
		lblApellido.setText(u.getApellido());
		lblUsuario.setText(u.getUsuario());
		lblContrasenia.setText(u.getContrasenia());
		lblDomicilio.setText(u.getDomicilio());
		lblTelefono.setText((u.getTelefono()).toString());
		lblTipo.setText(u.getTipo());
		ImageIcon imagen = new ImageIcon(u.getFoto());
    	lblFoto.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH)));
    	
		
		
		add(lblFondo);
	}

}
