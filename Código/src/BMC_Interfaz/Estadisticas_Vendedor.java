package BMC_Interfaz;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BMC_DAO.UsuariosDAO;
import BMC_Modelo.Usuario;
import javax.swing.SwingConstants;

public class Estadisticas_Vendedor extends JPanel {

	UsuariosDAO ud = new UsuariosDAO();
	
	public Estadisticas_Vendedor(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("esvendedor.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(838, 12, 60, 39);
		lblInicio.setToolTipText("Atrás");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
				
				Principal_Vendedor panel = new Principal_Vendedor(frame, u);
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
		
		JLabel lblCantidadDeVentas = new JLabel("");
		lblCantidadDeVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadDeVentas.setBounds(105, 214, 702, 46);
		add(lblCantidadDeVentas);
		
		JLabel lblFacturado = new JLabel("");
		lblFacturado.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacturado.setBounds(105, 403, 702, 46);
		add(lblFacturado);
		
		
		lblCantidadDeVentas.setText(new Integer(ud.cantidadVentasUsuario(u.getDni())).toString());
		lblFacturado.setText(new Float(ud.cantidadRecaudadoUsuario(u.getDni())).toString());
		
		
		add(lblFondo);
	}

}
