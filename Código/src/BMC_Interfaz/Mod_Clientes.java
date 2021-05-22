package BMC_Interfaz;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BMC_DAO.ClientesDAO;
import BMC_DAO.No_hay_error;
import BMC_Modelo.Cliente;
import BMC_Modelo.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import BMC_Modelo.Usuario;
import java.awt.Font;

public class Mod_Clientes extends JPanel {

	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDomicilio;
	private JTextField textFieldTelefono;

	ClientesDAO cd = new ClientesDAO();
	
	
	public Mod_Clientes(JFrame frame, int d, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Mod_Clientes.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(838, 12, 60, 39);
		lblInicio.setToolTipText("AtrÃ¡s");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
		
				AbmClientes panel = new AbmClientes(frame, u);
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
		
		textFieldDni = new JTextField();
		textFieldDni.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldDni.setBorder(null);
		textFieldDni.setOpaque(false);
		textFieldDni.setBounds(106, 400, 333, 27);
		add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldNombre.setBorder(null);
		textFieldNombre.setOpaque(false);
		textFieldNombre.setBounds(106, 162, 333, 24);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldApellido.setBorder(null);
		textFieldApellido.setOpaque(false);
		textFieldApellido.setBounds(106, 279, 333, 27);
		add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldDomicilio.setBorder(null);
		textFieldDomicilio.setOpaque(false);
		textFieldDomicilio.setBounds(487, 158, 333, 32);
		add(textFieldDomicilio);
		textFieldDomicilio.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldTelefono.setBorder(null);
		textFieldTelefono.setOpaque(false);
		textFieldTelefono.setBounds(487, 279, 333, 32);
		add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblVolver = new JLabel("");
		lblVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AbmClientes panel = new AbmClientes(frame, u);
		        frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
		        frame.validate();
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		lblVolver.setBounds(836, 12, 62, 39);
		add(lblVolver);
		textFieldDni.setEditable(false);
		JLabel lblCancelar = new JLabel("");
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNombre.setText(null);
		    	textFieldApellido.setText(null);
		    	textFieldDomicilio.setText(null);
		    	textFieldTelefono.setText(null);
		    	textFieldDni.setText(null);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lblCancelar.setBounds(260, 590, 189, 39);
		add(lblCancelar);
		
		JLabel lblActualizar = new JLabel("");
		lblActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int a = 0;
				
				No_hay_error nh = new No_hay_error();
				if (nh.Solo_Numeros(textFieldTelefono.getText())) {
		    		JOptionPane.showMessageDialog(null, "El telefono debe contener caracteres especiales.\n Ejemplo: +54 11 5031-3150");
		    		a=1;
				}
		    	
		    	
				if(nh.Solo_Letras_Y_Espacios(textFieldNombre.getText()) == false|| nh.Solo_Letras_Y_Espacios(textFieldApellido.getText()) == false|| nh.Solo_Numeros_y_Letras(textFieldDomicilio.getText())==false	|| nh.Solo_Numeros(textFieldDni.getText())==false || nh.Solo_Numeros(textFieldTelefono.getText())==false) 
				{
					
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				if(textFieldDni.getText().matches("^[A-Za-z!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$")) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				if(textFieldTelefono.getText().matches("^[A-Za-z!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$")) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				if(textFieldDomicilio.getText().matches("^[!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$")) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				if(textFieldNombre.getText().matches("^[!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$")) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				if(textFieldApellido.getText().matches("^[!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$")) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				
				if(a == 0) {
					int dni = new Integer(textFieldDni.getText());
			    	String nombre = textFieldNombre.getText();
			    	String apellido = textFieldApellido.getText();	    	
			    	String domicilio = textFieldDomicilio.getText();
			    	String telefono = textFieldTelefono.getText();
			    	
			    	
			    	
			    	
			    	//datos incompletos		    	
			    	if(textFieldDni.equals("") || nombre.equals("") || apellido.equals("") || domicilio.equals("") || textFieldTelefono.getText().equals("")) {
			    		JOptionPane.showMessageDialog(null, "Datos Incompletos");
			    		a = 1;		    	
			    	}		    	
			    	
			    	
			    	//verificaciones
			    	if(a==0) {		
			    		if(dni<=0 || cd.existeDni(dni)==false) {
			    			JOptionPane.showMessageDialog(null, "Datos Incorrectos");
			    			textFieldDni.setText(null);
			    			a = 1;	
			    		}
			    		
			    	}
			    	
			    	
			    	
			    	if(a==0){
			    		cd.MODIFICACION(dni, nombre, apellido, domicilio, telefono);
			    		/*u.setNombre(nombre);
			    		u.setApellido(apellido);		    		
			    		u.setDomicilio(domicilio);
			    		u.setTelefono(telefono);*/
			    		
			    			    		
			    		JOptionPane.showMessageDialog(null, "Modificacion realizada.");
				   	}	    	
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lblActualizar.setBounds(478, 590, 189, 39);
		add(lblActualizar);
		textFieldDni.setColumns(10);
		
		
		
		
		add(lblInicio);add(lblFondo);

		Cliente cliente = cd.buscarCliente(d);
		int dni = cliente.getDni();
		String str1 = Integer.toString(dni); 
		textFieldDni.setText(str1);
		
		
		String telefon = cliente.getTelefono();
		textFieldTelefono.setText(telefon);
		textFieldNombre.setText(cliente.getNombre());
		textFieldApellido.setText(cliente.getApellido());
		textFieldDomicilio.setText(cliente.getDomicilio());
	
		
		
		
	}

}
