package BMC_Interfaz;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BMC_Modelo.Usuario;

public class Estadisticas extends JPanel {

	/**
	 * Create the panel.
	 */
	public Estadisticas(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(837, 12, 62, 39);
		lblInicio.setToolTipText("Atrás");
		
		
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
				
				Principal panel = new Principal(frame, u);
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
		
		JLabel lblEstadisticasPersonal = new JLabel("");
		lblEstadisticasPersonal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EstadisticasUsuarios panel = new EstadisticasUsuarios(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lblEstadisticasPersonal.setBounds(467, 190, 327, 39);
		add(lblEstadisticasPersonal);
		
		JLabel lblEstadisticasProductoss = new JLabel("");
		lblEstadisticasProductoss.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EstadisticasProductos panel = new EstadisticasProductos(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		lblEstadisticasProductoss.setBounds(467, 259, 327, 39);
		add(lblEstadisticasProductoss);
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Estadisticas.png")));
		add(lblFondo);
	}
	}


