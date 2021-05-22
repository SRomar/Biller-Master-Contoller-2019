package BMC_Interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BMC_Modelo.Cliente;
import BMC_Modelo.Factura;
import BMC_Modelo.Usuario;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BMC_DAO.FacturasDAO;
import BMC_DAO.No_hay_error;
import BMC_DAO.UsuariosDAO;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HistorialPosta extends JPanel {
	private JTable table;
	private JTextField textFieldAnoDesde;
	private JTextField textFieldMesDesde;
	private JLabel lblBuscar;
	
	FacturasDAO fd = new FacturasDAO();
	UsuariosDAO ud = new UsuariosDAO();
	No_hay_error nh = new No_hay_error();
	
	private JTextField txtVendedor;
	private JTextField textFieldDiaDesde;
	private JTextField textFieldDiaHasta;
	private JTextField textFieldMesHasta;
	private JTextField textFieldAnoHasta;

	public HistorialPosta(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);		
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(838, 12, 60, 39);
		lblInicio.setToolTipText("Atr√°s");
		
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
		
		String[] nombreColumnas = {"Id", "importe", "fecha", "vendedor"}; 
		DefaultTableModel model = new DefaultTableModel(nombreColumnas, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setFocusable(false);
		scrollPane.setFocusTraversalKeysEnabled(false);
		scrollPane.setBorder(null);
		
		scrollPane.setBounds(25, 61, 480, 541);
		scrollPane.getViewport().setBackground(Color.WHITE);
		add(scrollPane);
		
		ArrayList<Factura> facturitas = fd.consultar_tabla();
		
		for(Factura f: facturitas) {
			String id = new Long(f.getId()).toString();
			String importe = new Float(f.getImporte()).toString();
			String fecha = f.getFecha().toString();
			String vendedor = new Integer(f.getIdVendedor()).toString();
			
			Object[] registro = {id, importe, fecha, vendedor};
			model.addRow(registro);
		}
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(model);
		table.setBorder(null);
		
		scrollPane.setViewportView(table);
		
		textFieldAnoDesde = new JTextField();
		textFieldAnoDesde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textFieldAnoDesde.getText().contentEquals("AÒo")) {
					textFieldAnoDesde.setText(null);
				}
			}
		});
		textFieldAnoDesde.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAnoDesde.setBorder(null);
		textFieldAnoDesde.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldAnoDesde.setText("A\u00F1o");
		textFieldAnoDesde.setBounds(563, 151, 79, 24);
		add(textFieldAnoDesde);
		textFieldAnoDesde.setColumns(10);
		
		textFieldMesDesde = new JTextField();
		textFieldMesDesde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textFieldMesDesde.getText().contentEquals("Mes")) {
					textFieldMesDesde.setText(null);
				}
			}
		});
		textFieldMesDesde.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMesDesde.setBorder(null);
		textFieldMesDesde.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldMesDesde.setText("Mes");
		textFieldMesDesde.setBounds(686, 151, 79, 23);
		add(textFieldMesDesde);
		textFieldMesDesde.setColumns(10);
		
		textFieldDiaDesde = new JTextField();
		textFieldDiaDesde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textFieldDiaDesde.getText().contentEquals("DÌa")) {
					textFieldDiaDesde.setText(null);
				}
			}
		});
		textFieldDiaDesde.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDiaDesde.setBorder(null);
		textFieldDiaDesde.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldDiaDesde.setText("D\u00EDa");
		textFieldDiaDesde.setColumns(10);
		textFieldDiaDesde.setBounds(807, 153, 85, 20);
		add(textFieldDiaDesde);
		
		lblBuscar = new JLabel("");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
				int vacioDesde = 0;
				int vacioHasta = 0;
				
				int diaDesde = 0;
				int diaHasta = 0;
				int mesDesde = 0;
				int mesHasta = 0;
				int anoDesde = 0;
				int anoHasta = 0;
				
				ArrayList<Factura> fac = new ArrayList<>();
		
				Date fechaDesde = new Date(1, 1, 1);
				Date fechaHasta = new Date(1, 1, 1);
				
				if(nh.Solo_Numeros(txtVendedor.getText())==false) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				
				if(nh.Solo_Numeros_Y_Espacios(textFieldDiaDesde.getText())==false || nh.Solo_Numeros_Y_Espacios(textFieldDiaHasta.getText())==false || nh.Solo_Numeros_Y_Espacios(textFieldMesDesde.getText())==false || nh.Solo_Numeros_Y_Espacios(textFieldMesHasta.getText())==false || nh.Solo_Numeros_Y_Espacios(textFieldAnoDesde.getText())==false || nh.Solo_Numeros_Y_Espacios(textFieldAnoHasta.getText())==false) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				if(textFieldDiaDesde.getText().equals("")) {
					vacioDesde++;
				}
				if(textFieldDiaHasta.getText().equals("")) {
					vacioHasta++;
				}
				if(textFieldMesDesde.getText().equals("")) {
					vacioDesde++;
				}
				if(textFieldMesHasta.getText().equals("")) {
					vacioHasta++;
				}
				if(textFieldAnoDesde.getText().equals("")) {
					vacioDesde++;
				}
				if(textFieldAnoHasta.getText().equals("")) {
					vacioHasta++;
				}
				
				if(vacioDesde > 0 && vacioDesde <3) {
					JOptionPane.showMessageDialog(null, "Datos incompletos");
					textFieldDiaHasta.setText(null);
					a = 1;
				}
				if(vacioHasta > 0 && vacioHasta <3) {
					JOptionPane.showMessageDialog(null, "Datos incompletos");
					textFieldDiaHasta.setText(null);
					a = 1;
				}
				
					if(a == 0) {	
						if(txtVendedor.getText().equals("") && textFieldDiaDesde.getText().equals("")==false && textFieldDiaHasta.getText().equals("")==false && textFieldMesDesde.getText().equals("")==false && textFieldMesHasta.getText().equals("")==false && textFieldAnoDesde.getText().equals("")==false && textFieldAnoHasta.getText().equals("")==false) {
							diaDesde = new Integer(textFieldDiaDesde.getText()); 
							diaHasta = new Integer(textFieldDiaHasta.getText()); 
							mesDesde = new Integer(textFieldMesDesde.getText());
							mesHasta = new Integer(textFieldMesHasta.getText());
							anoDesde = new Integer(textFieldAnoDesde.getText());
							anoHasta = new Integer(textFieldAnoHasta.getText());
							
							a = verificacionesCompletas(diaDesde, diaHasta, mesDesde, mesHasta, anoDesde, anoHasta);
							
							if(a == 0) {
								fechaDesde.setDate(diaDesde);
								fechaDesde.setMonth(mesDesde-1);
								fechaDesde.setYear(anoDesde-1900);
									
								fechaHasta.setDate(diaHasta);
								fechaHasta.setMonth(mesHasta-1);
								fechaHasta.setYear(anoHasta-1900);
								fac = fd.facturasHistorialFecha(fechaDesde, fechaHasta);
								model.setRowCount(0); 
								for(Factura f: fac) {
									String idd = new Long(f.getId()).toString(); 
									String importe = new Float(f.getImporte()).toString();
									String fecha = f.getFecha().toString();
									String vendedor = new Integer(f.getIdVendedor()).toString();
									
									Object[] registro = {idd, importe, fecha, vendedor};
									model.addRow(registro);
								}
							}
							
						}
						else if(txtVendedor.getText().equals("")==false && textFieldDiaDesde.getText().equals("")==false && textFieldDiaHasta.getText().equals("")==false && textFieldMesDesde.getText().equals("")==false && textFieldMesHasta.getText().equals("")==false && textFieldAnoDesde.getText().equals("")==false && textFieldAnoHasta.getText().equals("")==false) {
							diaDesde = new Integer(textFieldDiaDesde.getText()); 
							diaHasta = new Integer(textFieldDiaHasta.getText()); 
							mesDesde = new Integer(textFieldMesDesde.getText());
							mesHasta = new Integer(textFieldMesHasta.getText());
							anoDesde = new Integer(textFieldAnoDesde.getText());
							anoHasta = new Integer(textFieldAnoHasta.getText());
							
							int dni = new Integer(txtVendedor.getText());
							
							if(dni<=0 || ud.existeDni(dni) == false) {
								JOptionPane.showMessageDialog(null, "Datos Incorrectos");
								a = 1;
							}
							
							a = verificacionesCompletas(diaDesde, diaHasta, mesDesde, mesHasta, anoDesde, anoHasta);
							
							if(a == 0) {
								fechaDesde.setDate(diaDesde);
								fechaDesde.setMonth(mesDesde-1);
								fechaDesde.setYear(anoDesde-1900);
									
								fechaHasta.setDate(diaHasta);
								fechaHasta.setMonth(mesHasta-1);
								fechaHasta.setYear(anoHasta-1900);
								fac = fd.facturasHistorialAmbas(fechaDesde, fechaHasta, dni);
								model.setRowCount(0); 
								for(Factura f: fac) {
									String idd = new Long(f.getId()).toString(); 
									String importe = new Float(f.getImporte()).toString();
									String fecha = f.getFecha().toString();
									String vendedor = new Integer(f.getIdVendedor()).toString();
									
									Object[] registro = {idd, importe, fecha, vendedor};
									model.addRow(registro);
								}
							}
							
						}

						else if(textFieldDiaDesde.getText().equals("") && textFieldDiaHasta.getText().equals("") && textFieldMesDesde.getText().equals("") && textFieldMesHasta.getText().equals("") && textFieldAnoDesde.getText().equals("") && textFieldAnoHasta.getText().equals("") && txtVendedor.getText().equals("")==false) {
							int dni = new Integer(txtVendedor.getText());
							
							if(dni<=0 || ud.existeDni(dni) == false) {
								JOptionPane.showMessageDialog(null, "Datos Incorrectos");
								a = 1;
							}
							if(a == 0) {
								fac = fd.facturasHistorialVendedor(dni);
								model.setRowCount(0); 
								for(Factura f: fac) {
									String idd = new Long(f.getId()).toString(); 
									String importe = new Float(f.getImporte()).toString();
									String fecha = f.getFecha().toString();
									String vendedor = new Integer(f.getIdVendedor()).toString();
									
									Object[] registro = {idd, importe, fecha, vendedor};
									model.addRow(registro);
								}
							}
						}
						else if(textFieldDiaDesde.getText().equals("") && textFieldDiaHasta.getText().equals("") && textFieldMesDesde.getText().equals("") && textFieldMesHasta.getText().equals("") && textFieldAnoDesde.getText().equals("") && textFieldAnoHasta.getText().equals("") && txtVendedor.getText().equals("")) {
							fac = fd.consultar_tabla();
							model.setRowCount(0); 
							for(Factura f: fac) {
								String idd = new Long(f.getId()).toString(); 
								String importe = new Float(f.getImporte()).toString();
								String fecha = f.getFecha().toString();
								String vendedor = new Integer(f.getIdVendedor()).toString();
								
								Object[] registro = {idd, importe, fecha, vendedor};
								model.addRow(registro);
							}
						}
						
						else if(textFieldDiaDesde.getText().equals("") && textFieldDiaHasta.getText().equals("")==false && textFieldMesDesde.getText().equals("") && textFieldMesHasta.getText().equals("")==false && textFieldAnoDesde.getText().equals("") && textFieldAnoHasta.getText().equals("")==false && txtVendedor.getText().equals("")) {
							 
							diaHasta = new Integer(textFieldDiaHasta.getText()); 						
							mesHasta = new Integer(textFieldMesHasta.getText());							
							anoHasta = new Integer(textFieldAnoHasta.getText());
							
							a = verificacionesFechaHasta(diaHasta, mesHasta, anoHasta);
								
							if(a == 0){
								fechaHasta.setDate(diaHasta);
								fechaHasta.setMonth(mesHasta-1);
								fechaHasta.setYear(anoHasta-1900);
								
								fac = fd.facturasHistorialFechaHasta(fechaHasta);
								model.setRowCount(0); 
								for(Factura f: fac) {
									String idd = new Long(f.getId()).toString(); 
									String importe = new Float(f.getImporte()).toString();
									String fecha = f.getFecha().toString();
									String vendedor = new Integer(f.getIdVendedor()).toString();
									
									Object[] registro = {idd, importe, fecha, vendedor};
									model.addRow(registro);
								}
							}
						}
						else if(textFieldDiaDesde.getText().equals("")==false && textFieldDiaHasta.getText().equals("") && textFieldMesDesde.getText().equals("")==false && textFieldMesHasta.getText().equals("") && textFieldAnoDesde.getText().equals("")==false && textFieldAnoHasta.getText().equals("") && txtVendedor.getText().equals("")) {
							diaDesde = new Integer(textFieldDiaDesde.getText()); 							 
							mesDesde = new Integer(textFieldMesDesde.getText());							
							anoDesde = new Integer(textFieldAnoDesde.getText());
							
							a = verificacionesFechaDesde(diaDesde, mesDesde, anoDesde);
							
							if(a == 0) {
								fechaDesde.setDate(diaDesde);
								fechaDesde.setMonth(mesDesde-1);
								fechaDesde.setYear(anoDesde-1900);
								
								fac = fd.facturasHistorialFechaDesde(fechaDesde);
								model.setRowCount(0); 
								for(Factura f: fac) {
									String idd = new Long(f.getId()).toString(); 
									String importe = new Float(f.getImporte()).toString();
									String fecha = f.getFecha().toString();
									String vendedor = new Integer(f.getIdVendedor()).toString();
									
									Object[] registro = {idd, importe, fecha, vendedor};
									model.addRow(registro);
								}
							}
						}
						else if(textFieldDiaDesde.getText().equals("") && textFieldDiaHasta.getText().equals("")==false && textFieldMesDesde.getText().equals("") && textFieldMesHasta.getText().equals("")==false && textFieldAnoDesde.getText().equals("") && textFieldAnoHasta.getText().equals("")==false && txtVendedor.getText().equals("")==false) {
							
							diaHasta = new Integer(textFieldDiaHasta.getText()); 						
							mesHasta = new Integer(textFieldMesHasta.getText());							
							anoHasta = new Integer(textFieldAnoHasta.getText());
							
							a = verificacionesFechaHasta(diaHasta, mesHasta, anoHasta);

							if(a == 0) {
								fechaHasta.setDate(diaHasta);
								fechaHasta.setMonth(mesHasta-1);
								fechaHasta.setYear(anoHasta-1900);
								
								int dni = new Integer(txtVendedor.getText());
								
								if(dni<=0 || ud.existeDni(dni) == false) {
									JOptionPane.showMessageDialog(null, "Datos Incorrectos");
									a = 1;
								}
								if(a == 0) {
									fac = fd.facturasHistorialFechaHastaVendedor(fechaHasta, dni);
									model.setRowCount(0); 
									for(Factura f: fac) {
										String idd = new Long(f.getId()).toString(); 
										String importe = new Float(f.getImporte()).toString();
										String fecha = f.getFecha().toString();
										String vendedor = new Integer(f.getIdVendedor()).toString();
										
										Object[] registro = {idd, importe, fecha, vendedor};
										model.addRow(registro);
									}
								}
							}
						}
						else if(textFieldDiaDesde.getText().equals("")==false && textFieldDiaHasta.getText().equals("") && textFieldMesDesde.getText().equals("")==false && textFieldMesHasta.getText().equals("") && textFieldAnoDesde.getText().equals("")==false && textFieldAnoHasta.getText().equals("") && txtVendedor.getText().equals("")==false) {
							
							diaDesde = new Integer(textFieldDiaDesde.getText()); 							 
							mesDesde = new Integer(textFieldMesDesde.getText());							
							anoDesde = new Integer(textFieldAnoDesde.getText());
							
							
							a = verificacionesFechaDesde(diaDesde, mesDesde, anoDesde); 
							
							if(a == 0) { 
								fechaDesde.setDate(diaDesde);
								fechaDesde.setMonth(mesDesde-1);
								fechaDesde.setYear(anoDesde-1900);
								
								int dni = new Integer(txtVendedor.getText());
								
								if(dni<=0 || ud.existeDni(dni) == false) {
									JOptionPane.showMessageDialog(null, "Datos Incorrectos");
									a = 1;
								}
								
								if(a == 0) {
									fac = fd.facturasHistorialFechaDesdeVendedor(fechaDesde, dni);
									model.setRowCount(0); 
									for(Factura f: fac) {
										String idd = new Long(f.getId()).toString(); 
										String importe = new Float(f.getImporte()).toString();
										String fecha = f.getFecha().toString();
										String vendedor = new Integer(f.getIdVendedor()).toString();
										
										Object[] registro = {idd, importe, fecha, vendedor};
										model.addRow(registro);
									}
								}
							}
						}
						
					}
					
					
				}
				
			
		});
		lblBuscar.setBounds(640, 575, 175, 33);
		add(lblBuscar);
		
		txtVendedor = new JTextField();
		txtVendedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtVendedor.getText().contentEquals("DNI Vendedor")) {
					txtVendedor.setText(null);
				}
			}
		});
		txtVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		txtVendedor.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtVendedor.setBorder(null);
		txtVendedor.setText("DNI Vendedor");
		txtVendedor.setColumns(10);
		txtVendedor.setBounds(563, 412, 322, 20);
		add(txtVendedor);
		
		textFieldDiaHasta = new JTextField();
		textFieldDiaHasta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textFieldDiaHasta.getText().contentEquals("DÌa")) {
					textFieldDiaHasta.setText(null);
				}
			}
		});
		textFieldDiaHasta.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDiaHasta.setBorder(null);
		textFieldDiaHasta.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldDiaHasta.setText("D\u00EDa");
		textFieldDiaHasta.setColumns(10);
		textFieldDiaHasta.setBounds(807, 283, 85, 20);
		add(textFieldDiaHasta);
		
		textFieldMesHasta = new JTextField();
		textFieldMesHasta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textFieldMesHasta.getText().contentEquals("Mes")) {
					textFieldMesHasta.setText(null);
				}
			}
		});
		textFieldMesHasta.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMesHasta.setBorder(null);
		textFieldMesHasta.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldMesHasta.setText("Mes");
		textFieldMesHasta.setColumns(10);
		textFieldMesHasta.setBounds(686, 283, 79, 20);
		add(textFieldMesHasta);
		
		textFieldAnoHasta = new JTextField();
		textFieldAnoHasta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textFieldAnoHasta.getText().contentEquals("AÒo")) {
					textFieldAnoHasta.setText(null);
				}
			}
		});
		textFieldAnoHasta.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAnoHasta.setBorder(null);
		textFieldAnoHasta.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldAnoHasta.setText("A\u00F1o");
		textFieldAnoHasta.setColumns(10);
		textFieldAnoHasta.setBounds(563, 283, 79, 20);
		add(textFieldAnoHasta);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("HistorialPosta.png")));
		
		add(lblFondo);
	}
	
	
	public int verificacionesCompletas(int diaDesde, int diaHasta, int mesDesde, int mesHasta, int anoDesde, int anoHasta) {
		int a = 0;
		
		if((diaDesde/100)>0 || diaDesde>31 || diaDesde<1) {
			JOptionPane.showMessageDialog(null, "Dia Fuera de Rango");
			textFieldDiaDesde.setText(null);
			a = 1;
		}
		if((diaHasta/100)>0 || diaHasta>31) {
			JOptionPane.showMessageDialog(null, "Dia Fuera de Rango");
			textFieldDiaHasta.setText(null);
			a = 1;
		}
		if((mesDesde/100)>0 || mesDesde>12 || mesDesde<1) {
			JOptionPane.showMessageDialog(null, "Mes Fuera de Rango");
			textFieldMesDesde.setText(null);
			a = 1;
		}
		if((mesHasta/100)>0 || mesHasta>12 || mesHasta<1) {
			JOptionPane.showMessageDialog(null, "Mes Fuera de Rango");
			textFieldMesHasta.setText(null);
			a = 1;
		}
		if((anoDesde/10000)>0 || anoDesde>2019 || anoDesde<2018) {
			JOptionPane.showMessageDialog(null, "AÒo Fuera de Rango");
			textFieldAnoDesde.setText(null);
			a = 1;
		}
		if((anoHasta/10000)>0 || anoHasta>2019 || anoHasta<2018) {
			JOptionPane.showMessageDialog(null, "AÒo Fuera de Rango");
			textFieldAnoHasta.setText(null);
			a = 1;
		}
		
		if(anoDesde > anoHasta) {
			JOptionPane.showMessageDialog(null, "AÒos incorrectos");
			textFieldAnoDesde.setText(null);
			textFieldAnoHasta.setText(null);
			a = 1;
		}
		if((anoDesde == anoHasta) && (mesDesde > mesHasta)) {
			JOptionPane.showMessageDialog(null, "Meses incorrectos");
			textFieldMesDesde.setText(null);
			textFieldMesHasta.setText(null);
			a = 1;
		}
		if((mesDesde == 4 || mesDesde == 6 || mesDesde == 9 || mesDesde == 11) && (diaDesde == 31)) {
			JOptionPane.showMessageDialog(null, "Dia Fuera de Rango");
			textFieldDiaDesde.setText(null);
			a = 1;
		}
		if((mesHasta == 4 || mesHasta == 6 || mesHasta == 9 || mesHasta == 11) && (diaHasta == 31)) {
			JOptionPane.showMessageDialog(null, "Dia Fuera de Rango");
			textFieldDiaHasta.setText(null);
			a = 1;
		}
		if((mesDesde == 2) && (diaDesde>28)) {
			JOptionPane.showMessageDialog(null, "Dia Fuera de Rango");
			textFieldDiaDesde.setText(null);
			a = 1;
		}
		if((mesHasta == 2) && (diaHasta>28)) {
			JOptionPane.showMessageDialog(null, "Dia Fuera de Rango");
			textFieldDiaHasta.setText(null);
			a = 1;
		}
		return a;
	}
	
	public int verificacionesFechaDesde(int diaDesde, int mesDesde, int anoDesde) {
		int a = 0;
		
		if((diaDesde/100)>0 || diaDesde>31 || diaDesde<1) {
			JOptionPane.showMessageDialog(null, "Dia Fuera de Rango");
			textFieldDiaDesde.setText(null);
			a = 1;
		}							
		if((mesDesde/100)>0 || mesDesde>12 || mesDesde<1) {
			JOptionPane.showMessageDialog(null, "Mes Fuera de Rango");
			textFieldMesDesde.setText(null);
			a = 1;
		}							
		if((anoDesde/10000)>0 || anoDesde>2019 || anoDesde<2018) {
			JOptionPane.showMessageDialog(null, "AÒo Fuera de Rango");
			textFieldAnoDesde.setText(null);
			a = 1;
		}
		if((mesDesde == 4 || mesDesde == 6 || mesDesde == 9 || mesDesde == 11) && (diaDesde == 31)) {
			JOptionPane.showMessageDialog(null, "Dia Fuera de Rango");
			textFieldDiaDesde.setText(null);
			a = 1;
		}							
		if((mesDesde == 2) && (diaDesde>28)) {
			JOptionPane.showMessageDialog(null, "Dia Fuera de Rango");
			textFieldDiaDesde.setText(null);
			a = 1;
		}
		
		return a;
	}

	public int verificacionesFechaHasta(int diaHasta, int mesHasta, int anoHasta) {
		int a = 0;
		
		if((diaHasta/100)>0 || diaHasta>31) {
			JOptionPane.showMessageDialog(null, "Dia Fuera de Rango");
			textFieldDiaHasta.setText(null);
			a = 1;
		}							
		if((mesHasta/100)>0 || mesHasta>12 || mesHasta<1) {
			JOptionPane.showMessageDialog(null, "Mes Fuera de Rango");
			textFieldMesHasta.setText(null);
			a = 1;
		}							
		if((anoHasta/10000)>0 || anoHasta>2019 || anoHasta<2018) {
			JOptionPane.showMessageDialog(null, "AÒo Fuera de Rango");
			textFieldAnoHasta.setText(null);
			a = 1;
		}						
		if((mesHasta == 4 || mesHasta == 6 || mesHasta == 9 || mesHasta == 11) && (diaHasta == 31)) {
			JOptionPane.showMessageDialog(null, "Dia Fuera de Rango");
			textFieldDiaHasta.setText(null);
			a = 1;
		}							
		if((mesHasta == 2) && (diaHasta>28)) {
			JOptionPane.showMessageDialog(null, "Dia Fuera de Rango");
			textFieldDiaHasta.setText(null);
			a = 1;
		}
		
		return a;	
	}
}
