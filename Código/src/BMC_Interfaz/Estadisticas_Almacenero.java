package BMC_Interfaz;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BMC_Modelo.Usuario;
import javax.swing.SwingConstants;

import BMC_DAO.UsuariosDAO;

import java.awt.Font;
import java.awt.Color;

public class Estadisticas_Almacenero extends JPanel {

	UsuariosDAO ud = new UsuariosDAO();
	
	public Estadisticas_Almacenero(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Estadisticas_Almacenero.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(838, 12, 60, 39);
		lblInicio.setToolTipText("Atrás");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
				
				Principal_Almacenero panel = new Principal_Almacenero(frame, u);
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

		JLabel lblProductosRegistrados = new JLabel("");
		lblProductosRegistrados.setForeground(new Color(50, 205, 50));
		lblProductosRegistrados.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblProductosRegistrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosRegistrados.setBounds(355, 301, 209, 39);
		add(lblProductosRegistrados);
		
		
		
		lblProductosRegistrados.setText(new Integer(ud.obtenerProductoRegistrado(u.getDni())).toString());
		
		
		add(lblFondo);
	}

}
