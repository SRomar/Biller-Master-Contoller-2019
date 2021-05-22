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

public class EstadisticasUsuarios extends JPanel {
	private JLabel lblCantidadDeVentasEM;

	UsuariosDAO ud = new UsuariosDAO();
	
	public EstadisticasUsuarios(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(837, 12, 62, 39);
		lblInicio.setToolTipText("Atrás");
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Estadisticas_Vendedor.png")));
		
		
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
				
				Estadisticas panel = new Estadisticas(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Estadisticas_Vendedor.png")));
			}
		});
		
		
		
		setLayout(null);
		add(lblInicio);
		
		JLabel lblFotoEmpleadoDelMes = new JLabel();
		lblFotoEmpleadoDelMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoEmpleadoDelMes.setBounds(160, 161, 163, 163);
		add(lblFotoEmpleadoDelMes);
		
		JLabel lblFotoEmpleadoMasVago = new JLabel();
		lblFotoEmpleadoMasVago.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoEmpleadoMasVago.setBounds(606, 161, 163, 163);
		add(lblFotoEmpleadoMasVago);
		
		JLabel lblNombreEM = new JLabel("nombre");
		lblNombreEM.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNombreEM.setForeground(new Color(154, 205, 50));
		lblNombreEM.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEM.setBounds(123, 417, 232, 14);
		add(lblNombreEM);
		

		
		JLabel lblDniEM = new JLabel("dni");
		lblDniEM.setHorizontalAlignment(SwingConstants.CENTER);
		lblDniEM.setForeground(new Color(154, 205, 50));
		lblDniEM.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDniEM.setBounds(123, 509, 232, 20);
		add(lblDniEM);
		
		lblCantidadDeVentasEM = new JLabel("cantidad de ventas");
		lblCantidadDeVentasEM.setForeground(new Color(154, 205, 50));
		lblCantidadDeVentasEM.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCantidadDeVentasEM.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadDeVentasEM.setBounds(114, 600, 241, 16);
		add(lblCantidadDeVentasEM);
		
		JLabel lblNombreEV = new JLabel("nombre");
		lblNombreEV.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEV.setForeground(new Color(154, 205, 50));
		lblNombreEV.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNombreEV.setBounds(570, 419, 232, 14);
		add(lblNombreEV);
		
		
		JLabel lblDniEV = new JLabel("dni");
		lblDniEV.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDniEV.setHorizontalAlignment(SwingConstants.CENTER);
		lblDniEV.setForeground(new Color(154, 205, 50));
		lblDniEV.setBounds(570, 514, 232, 14);
		add(lblDniEV);
		
		JLabel lblCantidadDeVentasEV = new JLabel("cantidad de ventas");
		lblCantidadDeVentasEV.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadDeVentasEV.setForeground(new Color(154, 205, 50));
		lblCantidadDeVentasEV.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCantidadDeVentasEV.setBounds(570, 600, 220, 14);
		add(lblCantidadDeVentasEV);
		
		
		
		Usuario empleadoDelMes = ud.empleadoDelMes();
		lblDniEM.setText(new Integer(empleadoDelMes.getDni()).toString());
		lblNombreEM.setText(empleadoDelMes.getNombre() + " " + empleadoDelMes.getApellido());
		lblCantidadDeVentasEM.setText(new Integer(ud.cantidadVentasEmpleadoDelMes()).toString());
		ImageIcon imagen = new ImageIcon(empleadoDelMes.getFoto());
		lblFotoEmpleadoDelMes.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFotoEmpleadoDelMes.getWidth(), lblFotoEmpleadoDelMes.getHeight(), Image.SCALE_SMOOTH)));
		
		Usuario empleadoMasVago = ud.empleadoMasVago();
		lblDniEV.setText(new Integer(empleadoMasVago.getDni()).toString());
		lblNombreEV.setText(empleadoMasVago.getNombre() + " " + empleadoMasVago.getApellido());
		lblCantidadDeVentasEV.setText(new Integer(ud.cantidadVentasEmpleadoMasVago()).toString());
		ImageIcon imagen2 = new ImageIcon(empleadoMasVago.getFoto());
		lblFotoEmpleadoMasVago.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(lblFotoEmpleadoMasVago.getWidth(), lblFotoEmpleadoMasVago.getHeight(), Image.SCALE_SMOOTH)));
		
		
		add(lblFondo);
	}

}
