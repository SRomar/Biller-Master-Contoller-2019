package BMC_Interfaz;

import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BMC_DAO.ClientesDAO;
import BMC_DAO.No_hay_error;
import BMC_Modelo.Cliente;
import BMC_Modelo.Usuario;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
public class Alta_Clientes extends JPanel {	
	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDomicilio;
	private JTextField textFieldTelefono;
	
	ClientesDAO cd = new ClientesDAO();
	Cliente c = new Cliente();
	private JLabel lblRegistrar;

	public Alta_Clientes(JFrame frame, boolean facturacion, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Clientes.png")));
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(833, 11, 77, 47);
		lblInicio.setToolTipText("Atrás");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(facturacion == false) {
					AbmClientes panel = new AbmClientes(frame, u);
					setVisible(false);
					frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
				}
				else if(facturacion == true) {
					Facturar panel = new Facturar(frame, u);
					setVisible(false);
					frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Clientes_Retro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Clientes.png")));
				
			}
		});
		setLayout(null);
		add(lblInicio);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(106, 395, 333, 30);
		textFieldDni.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldDni.setBorder(null);
		textFieldDni.setBackground(SystemColor.text);
		add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(106, 158, 333, 30);
		textFieldNombre.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldNombre.setBorder(null);
		textFieldNombre.setBackground(SystemColor.text);
		textFieldNombre.setColumns(10);
		add(textFieldNombre);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(106, 276, 333, 30);
		textFieldApellido.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldApellido.setBorder(null);
		textFieldApellido.setBackground(SystemColor.text);
		textFieldApellido.setColumns(10);
		add(textFieldApellido);
		
		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setBounds(485, 158, 333, 30);
		textFieldDomicilio.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldDomicilio.setBorder(null);
		textFieldDomicilio.setBackground(SystemColor.text);
		textFieldDomicilio.setColumns(10);
		add(textFieldDomicilio);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(485, 278, 333, 30);
		textFieldTelefono.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldTelefono.setBorder(null);
		textFieldTelefono.setBackground(SystemColor.text);
		textFieldTelefono.setColumns(10);
		add(textFieldTelefono);
				
		
		JLabel lblVaciarCampos = new JLabel("");
		lblVaciarCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldDni.setText(null);
		    	textFieldNombre.setText(null);
		    	textFieldApellido.setText(null);
		    	textFieldDomicilio.setText(null);
		    	textFieldTelefono.setText(null);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Clientes_Vaciar.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Clientes.png")));
			}
		});
		lblVaciarCampos.setBounds(258, 590, 187, 39);
		add(lblVaciarCampos);
		
		lblRegistrar = new JLabel("");
		lblRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
		    	
				No_hay_error nh = new No_hay_error();
	
				if (nh.Solo_Numeros(textFieldTelefono.getText())) {
		    		JOptionPane.showMessageDialog(null, "El telefono debe contener caracteres especiales.\n Ejemplo: +54 11 5031-3150");
		    		a=1;
				}
		    	
				if(nh.Solo_Letras_Y_Espacios(textFieldNombre.getText()) == false|| nh.Solo_Letras_Y_Espacios(textFieldApellido.getText()) == false|| nh.Solo_Numeros_y_Letras(textFieldDomicilio.getText())==false	|| nh.Solo_Numeros(textFieldDni.getText())==false || 
						nh.telefono(textFieldTelefono.getText())==false) 
				{
					
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
		
				
				if(a == 0) {
					int dni = new Integer(textFieldDni.getText()); 
			    	String nombre = textFieldNombre.getText();
			    	String apellido = textFieldApellido.getText();
			    	String domicilio = textFieldDomicilio.getText();
			    	String telefono = textFieldTelefono.getText();
			    	
			    	
			    	//Datos incompletos
			    	if(textFieldDni.getText().equals("") || nombre.equals("") || apellido.equals("") || domicilio.equals("") || textFieldTelefono.getText().equals("")) {
			    		//lblDatosIncompletos.setVisible(true);
			    		a = 1;
			    	}			    	
			    	
			    	//verificaciones
			    	if(a==0) {
			    		if(dni<=0 || cd.existeDni(dni)==true) {
			    			JOptionPane.showMessageDialog(null, "Datos Incorrectos");
			    			textFieldDni.setText(null);
			    			a = 1;
			    		}
			    		
			    	}
			    	
			    	if(a==0) {
			    		c.setDni(dni);
			    		c.setNombre(nombre);
			    		c.setApellido(apellido);
			    		c.setDomicilio(domicilio);
			    		c.setTelefono(telefono);
			    		cd.ALTA(c);
			    		
			    		textFieldDni.setText(null);
				    	textFieldNombre.setText(null);
				    	textFieldApellido.setText(null);
				    	textFieldDomicilio.setText(null);
				    	textFieldTelefono.setText(null);
				    	
			    		
			    	}
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Clientes_Registrar.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Clientes.png")));
			}
		});
		lblRegistrar.setBounds(479, 590, 187, 39);
		add(lblRegistrar);
		
		
		
		
		
		add(lblFondo);
	}
}
