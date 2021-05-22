package BMC_Interfaz;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BMC_Modelo.Usuario;

public class Principal_Almacenero extends JPanel {

	/**
	 * Create the panel.
	 */
	public Principal_Almacenero(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		Cursor cc = new Cursor(Cursor.DEFAULT_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Fondo Biller Almacenero.png")));
		
		
		JLabel Salir = new JLabel("");
		Salir.setToolTipText("Cerrar Sesion");
		Salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Iniciar_Sesion panel = new Iniciar_Sesion(frame) ;
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Salir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("exit 2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Salir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("exit 1.png")));
			}
		});
		Salir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("exit 1.png")));
		Salir.setBounds(10, 11, 90, 87);
		add(Salir);
		setLayout(null);
		
		JLabel lblMiPerfil = new JLabel("");
		lblMiPerfil.setToolTipText("Mi Perfil");
		lblMiPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mi_Perfil panel = new Mi_Perfil(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FBA_Perfil.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Fondo Biller Almacenero.png")));
			}
		});
		lblMiPerfil.setBounds(201, 205, 112, 108);
		add(lblMiPerfil);
		
		JLabel lblMiPerfil2 = new JLabel("");
		lblMiPerfil2.setToolTipText("Mi Perfil");
		lblMiPerfil2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mi_Perfil panel = new Mi_Perfil(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FBA_Perfil.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Fondo Biller Almacenero.png")));
			}
		});
		lblMiPerfil2.setBounds(322, 67, 137, 124);
		add(lblMiPerfil2);
		
		JLabel lblMiPerfil3 = new JLabel("");
		lblMiPerfil3.setToolTipText("Mi Perfil");
		lblMiPerfil3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mi_Perfil panel = new Mi_Perfil(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FBA_Perfil.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Fondo Biller Almacenero.png")));
			}
		});
		lblMiPerfil3.setBounds(245, 120, 112, 124);
		add(lblMiPerfil3);
		
		JLabel lblConfiguracion = new JLabel("");
		lblConfiguracion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FBA_Config.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Fondo Biller Almacenero.png")));
			}
		});
		lblConfiguracion.setToolTipText("Configuración");
		lblConfiguracion.setBounds(469, 77, 119, 114);
		add(lblConfiguracion);
		
		JLabel lblConfiguracion2 = new JLabel("");
		lblConfiguracion2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FBA_Config.png")));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Fondo Biller Almacenero.png")));
			}
		});
		lblConfiguracion2.setToolTipText("Configuración");
		lblConfiguracion2.setBounds(562, 120, 112, 124);
		add(lblConfiguracion2);
		
		JLabel lblConfiguracion3 = new JLabel("");
		lblConfiguracion3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FBA_Config.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Fondo Biller Almacenero.png")));
			}
		});
		lblConfiguracion3.setToolTipText("Configuración");
		lblConfiguracion3.setBounds(609, 205, 112, 108);
		add(lblConfiguracion3);
		
		JLabel lblStock = new JLabel("");
		lblStock.setToolTipText("Consultar Stock");
		lblStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {setCursor(c);
			lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FBA_Stock.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {setCursor(cc);
			lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Fondo Biller Almacenero.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Alta_Producto panel = new Alta_Producto(frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
		});
		lblStock.setBounds(609, 331, 112, 108);
		add(lblStock);
		
		JLabel lblStock2 = new JLabel("");
		lblStock2.setToolTipText("Consultar Stock");
		lblStock2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FBA_Stock.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Fondo Biller Almacenero.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Alta_Producto panel = new Alta_Producto(frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
		});
		lblStock2.setBounds(562, 412, 112, 124);
		add(lblStock2);
		
		JLabel lblStock3 = new JLabel("");
		lblStock3.setToolTipText("Consultar Stock");
		lblStock3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {setCursor(c);
				//lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Stock.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {setCursor(cc);
				//lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Alta_Producto panel = new Alta_Producto(frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
		});
		lblStock3.setBounds(469, 464, 137, 124);
		add(lblStock3);
		
		JLabel lblEstadisticas = new JLabel("");
		lblEstadisticas.setToolTipText("Mis Estadisticas");
		lblEstadisticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Estadisticas_Almacenero panel = new Estadisticas_Almacenero(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FBA_Estadisticas.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Fondo Biller Almacenero.png")));
			}
		});
		lblEstadisticas.setBounds(322, 464, 137, 124);
		add(lblEstadisticas);
		
		JLabel lblEstadisticas3 = new JLabel("");
		lblEstadisticas3.setToolTipText("Mis Estadisticas");
		lblEstadisticas3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Estadisticas_Almacenero panel = new Estadisticas_Almacenero(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FBA_Estadisticas.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Fondo Biller Almacenero.png")));
			}
		});
		lblEstadisticas3.setBounds(201, 331, 112, 108);
		add(lblEstadisticas3);
		
		JLabel lblEstadisticas2 = new JLabel("");
		lblEstadisticas2.setToolTipText("Mis Estadisticas");
		lblEstadisticas2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Estadisticas_Almacenero panel = new Estadisticas_Almacenero(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FBA_Estadisticas.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Fondo Biller Almacenero.png")));
			}
		});
		lblEstadisticas2.setBounds(245, 412, 112, 124);
		add(lblEstadisticas2);
		
		
		
		
		
		
		add(lblFondo);

	}
}
