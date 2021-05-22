package BMC_Interfaz;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BMC_Modelo.Usuario;

import java.awt.Font;
import java.awt.Color;

public class Principal_Vendedor extends JPanel {

	/**
	 * Create the panel.
	 */
	public Principal_Vendedor(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		Cursor cc = new Cursor(Cursor.DEFAULT_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(838, 12, 60, 39);
		lblInicio.setToolTipText("AtrÃ¡s");
		
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
		
		add(lblInicio);
		
		JLabel labelPerfilUsuario = new JLabel("");
		labelPerfilUsuario.setToolTipText("Mi Perfil");
		labelPerfilUsuario.addMouseListener(new MouseAdapter() {
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
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Personal.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
		});
		labelPerfilUsuario.setBounds(213, 187, 100, 124);
		add(labelPerfilUsuario);
		
		JLabel lblEstadisticas = new JLabel("");
		lblEstadisticas.setToolTipText("Mis Estadisticas");
		lblEstadisticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Estadisticas_Vendedor panel = new Estadisticas_Vendedor(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Estadisticas.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
		});
		lblEstadisticas.setBounds(207, 333, 106, 141);
		add(lblEstadisticas);
		
		JLabel lblClientes = new JLabel("");
		lblClientes.setToolTipText("Consultar Clientes");
		lblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConsultarClientes panel = new ConsultarClientes (frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Clientes.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
		});
		lblClientes.setBounds(325, 75, 122, 106);
		add(lblClientes);
		
		JLabel lblConfiguracion = new JLabel("");
		lblConfiguracion.setToolTipText("Configuración");
		lblConfiguracion.setBounds(470, 66, 130, 115);
		add(lblConfiguracion);
		
		JLabel lblFacturar = new JLabel("");
		lblFacturar.setToolTipText("Facturar");
		lblFacturar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Facturar.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Facturar panel = new Facturar(frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
		});
		lblFacturar.setBounds(609, 187, 106, 124);
		add(lblFacturar);
		
		JLabel lblStock = new JLabel("");
		lblStock.setToolTipText("Consultar Stock");
		lblStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Stock.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Consultar_Producto panel = new Consultar_Producto(frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
		});
		lblStock.setBounds(609, 333, 100, 130);
		add(lblStock);
		
		JLabel lblDevoluciones = new JLabel("");
		lblDevoluciones.setToolTipText("Devoluciones");
		lblDevoluciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Devol.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Devoluciones panel = new Devoluciones(frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
		});
		lblDevoluciones.setBounds(470, 475, 140, 99);
		add(lblDevoluciones);
		
		JLabel lblHistorial = new JLabel("");
		lblHistorial.setToolTipText("Mi Historial");
		lblHistorial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Historial_Vendedor panel = new Historial_Vendedor(frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.getContentPane().add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Historial.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
		});
		lblHistorial.setBounds(325, 475, 135, 99);
		add(lblHistorial);
		add(lblFondo);
	}
}
