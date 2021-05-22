package BMC_Interfaz;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BMC_Modelo.Usuario;

public class Stock extends JPanel {

	/**
	 * Create the panel.
	 */
	public Stock(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		JLabel lblFondo = new JLabel("");
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(847, 12, 63, 39);
		lblInicio.setToolTipText("Atrás");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
				
				Principal panel = new Principal(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Productos_retro.png")));
				setCursor(c);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ABMP.png")));
			}
		});
		setLayout(null);
		add(lblInicio);
		
		JLabel lblAlta = new JLabel("");
		lblAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Alta_Producto panel = new Alta_Producto(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ABMP.png")));
			}
			@Override
			public void mouseEntered(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Productos_pro.png")));
			}
		});
		lblAlta.setBounds(467, 193, 322, 39);
		add(lblAlta);
		
		JLabel lblBaja = new JLabel("");
		lblBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Baja_Producto panel = new Baja_Producto(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Productos_baja.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ABMP.png")));
			}
		});
		lblBaja.setBounds(467, 253, 322, 49);
		add(lblBaja);
		
		JLabel lblModificar = new JLabel("");
		lblModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IngresoSKUModificacionProductos panel = new IngresoSKUModificacionProductos(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Productos_mod.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ABMP.png")));
			}
		});
		lblModificar.setBounds(467, 318, 331, 49);
		add(lblModificar);
		
		JLabel lblConsulta = new JLabel("");
		lblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Consultar_Producto panel = new Consultar_Producto(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Productos_cons.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ABMP.png")));
			}
		});
		lblConsulta.setBounds(467, 388, 322, 49);
		add(lblConsulta);
		
		
		
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ABMP.png")));
		add(lblFondo);
	}
	}

