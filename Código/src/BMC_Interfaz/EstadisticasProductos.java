package BMC_Interfaz;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BMC_DAO.FacturasDAO;
import BMC_Modelo.Producto;
import BMC_Modelo.Usuario;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class EstadisticasProductos extends JPanel {

	FacturasDAO fd = new FacturasDAO();
		
	public EstadisticasProductos(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(837, 12, 62, 39);
		lblInicio.setToolTipText("Atrás");
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Estadisticas_Producto.png")));
		
		
		
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
			public void mouseExited(MouseEvent e) {		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Estadisticas_Producto.png")));
				
			}
		});
		
		
		
		setLayout(null);
		add(lblInicio);
	
		JLabel lblProductoMasVendidoNombre = new JLabel("mv");
		lblProductoMasVendidoNombre.setForeground(new Color(154, 205, 50));
		lblProductoMasVendidoNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblProductoMasVendidoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoMasVendidoNombre.setBounds(47, 196, 232, 23);
		add(lblProductoMasVendidoNombre);
		
		JLabel lblProductoMasVendidoMarca = new JLabel("mv");
		lblProductoMasVendidoMarca.setForeground(new Color(154, 205, 50));
		lblProductoMasVendidoMarca.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblProductoMasVendidoMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoMasVendidoMarca.setBounds(355, 196, 232, 23);
		add(lblProductoMasVendidoMarca);
		
		JLabel lblCantidadDeVentas = new JLabel("mv");
		lblCantidadDeVentas.setForeground(new Color(154, 205, 50));
		lblCantidadDeVentas.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCantidadDeVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadDeVentas.setBounds(668, 196, 232, 23);
		add(lblCantidadDeVentas);
		
		JLabel lblProductoMasRecaudaNombre = new JLabel("mr");
		lblProductoMasRecaudaNombre.setForeground(new Color(154, 205, 50));
		lblProductoMasRecaudaNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblProductoMasRecaudaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoMasRecaudaNombre.setBounds(47, 386, 232, 23);
		add(lblProductoMasRecaudaNombre);
		
		JLabel lblProductoMasRecaudaMarca = new JLabel("mr");
		lblProductoMasRecaudaMarca.setForeground(new Color(154, 205, 50));
		lblProductoMasRecaudaMarca.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblProductoMasRecaudaMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoMasRecaudaMarca.setBounds(355, 386, 232, 23);
		add(lblProductoMasRecaudaMarca);
		
		JLabel lblRecaudacion = new JLabel("mr");
		lblRecaudacion.setForeground(new Color(154, 205, 50));
		lblRecaudacion.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblRecaudacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecaudacion.setBounds(668, 386, 232, 23);
		add(lblRecaudacion);
		
		JLabel lblProductoMenosVendidoNombre = new JLabel("mev");
		lblProductoMenosVendidoNombre.setForeground(new Color(154, 205, 50));
		lblProductoMenosVendidoNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblProductoMenosVendidoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoMenosVendidoNombre.setBounds(47, 569, 232, 23);
		add(lblProductoMenosVendidoNombre);
		
		JLabel lblProductoMenosVendidoMarca = new JLabel("mev");
		lblProductoMenosVendidoMarca.setForeground(new Color(154, 205, 50));
		lblProductoMenosVendidoMarca.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblProductoMenosVendidoMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoMenosVendidoMarca.setBounds(355, 569, 232, 23);
		add(lblProductoMenosVendidoMarca);
		
		JLabel lblCantidadDeVentasMEV = new JLabel("mev");
		lblCantidadDeVentasMEV.setForeground(new Color(154, 205, 50));
		lblCantidadDeVentasMEV.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCantidadDeVentasMEV.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadDeVentasMEV.setBounds(668, 569, 231, 23);
		add(lblCantidadDeVentasMEV);
		
		Producto pMasVendido = fd.productoMasVendido();
		lblProductoMasVendidoNombre.setText(pMasVendido.getNombre());
		lblProductoMasVendidoMarca.setText(pMasVendido.getMarca());
		lblCantidadDeVentas.setText(new Integer(fd.cantidadVentasProdMasVendido()).toString());
		
		
		Producto pMasRecaudador = fd.productoMasRecaudador();
		lblProductoMasRecaudaNombre.setText(pMasRecaudador.getNombre());
		lblProductoMasRecaudaMarca.setText(pMasRecaudador.getMarca());
		lblRecaudacion.setText(new Float(fd.masRecaudado()).toString());
		
		
		Producto pMenosVendido = fd.productoMenosVendido();
		lblProductoMenosVendidoNombre.setText(pMenosVendido.getNombre());
		lblProductoMenosVendidoMarca.setText(pMenosVendido.getMarca());
		lblCantidadDeVentasMEV.setText(new Integer(fd.cantidadVentasProdMenosVendido()).toString());
		
		
		
		add(lblFondo);
	}
}
