package Bebidas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Registro.Registros;
import Formulario.restaurante;
import Postre.Postres;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Choice;
import java.awt.SystemColor;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class bebidas extends JFrame {
	private JPanel contentPane;

	private JComboBox<String> bebidas;
	private JComboBox<String> alcohol;
	private JComboBox<String> agua;
	private JComboBox<String> aguaPreparada; 

	
	Formulario.restaurante form = new Formulario.restaurante();
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bebidas frame = new bebidas();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public bebidas() throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		
		JLabel lblBebidas = new JLabel("REFRESCOS");
		lblBebidas.setForeground(Color.WHITE);
		lblBebidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBebidas.setFont(new Font("DFGothic-EB", Font.BOLD, 22));
		lblBebidas.setBounds(20, 53, 814, 37);
		contentPane.add(lblBebidas);
		this.setLocationRelativeTo(null);
		ImageIcon foto1 = new ImageIcon("src/ima1/coca.jpg");
		
		JLabel lblNewLabel = new JLabel("BEBIDAS CON ALCOHOL");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("DFGothic-EB", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 160, 814, 37);
		contentPane.add(lblNewLabel);
		ImageIcon foto = new ImageIcon("src/ima1/bebidas.jpg");
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 bebidas.this.dispose();
	     		
				
			}
		});
		btnNewButton.setBounds(46, 520, 128, 30);
		contentPane.add(btnNewButton);
		
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/restaurante";
			String usr = "root";
			//String psw = "RARO97";
			String psw = "";//

			
			con = DriverManager.getConnection(url, usr, psw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error");
		} catch (SQLException e) {
			System.out.println("Error con la  conexión de BD");
		}
		
		
		
		bebidas = new JComboBox<String>();
		bebidas.setForeground(SystemColor.desktop);
		bebidas.setFont(new Font("Arial Black", Font.PLAIN, 13));
		bebidas.setBackground(SystemColor.controlHighlight);
		bebidas.setBounds(196, 101, 408, 38);
		getContentPane().add(bebidas);
		bebidas.addItem("");
	
		
		Statement sta = con.createStatement();
		ResultSet res = sta.executeQuery("SELECT * FROM refresco");
		while(res.next()) {
			
			this.bebidas.addItem(res.getString("bebida"));
		}
		
		
		
	
		
		
		alcohol = new JComboBox<String>();
		alcohol.setForeground(SystemColor.desktop);
		alcohol.setFont(new Font("Arial Black", Font.PLAIN, 13));
		alcohol.setBackground(SystemColor.controlHighlight);
		alcohol.setBounds(196, 199, 408, 38);
		getContentPane().add(alcohol);
		
		alcohol.addItem("");

		Statement sta1 = con.createStatement();
		ResultSet res1 = sta1.executeQuery("SELECT * FROM bebida_alcoholica");
		while(res1.next()) {
			
			this.alcohol.addItem(res1.getString("bebida"));
		}
		
		
		alcohol.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		agua = new JComboBox<String>();
		agua.setForeground(SystemColor.desktop);
		agua.setFont(new Font("Arial Black", Font.PLAIN, 13));
		agua.setBackground(SystemColor.controlHighlight);
		agua.setBounds(196, 291, 408, 38);
		getContentPane().add(agua);
		
		agua.addItem("");
		Statement sta3 = con.createStatement();
		ResultSet res3 = sta3.executeQuery("SELECT * FROM aguas");
		while(res3.next()) {
			
			this.agua.addItem(res3.getString("bebida"));
		}
		
		
		
		
	
		agua.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
			

			}
		});
		
		
		aguaPreparada = new JComboBox<String>();
		aguaPreparada.setForeground(SystemColor.desktop);
		aguaPreparada.setFont(new Font("Arial Black", Font.PLAIN, 13));
		aguaPreparada.setBackground(SystemColor.controlHighlight);
		aguaPreparada.setBounds(196, 388, 408, 38);
		getContentPane().add(aguaPreparada);
		
		aguaPreparada.addItem("");
		Statement sta2 = con.createStatement();
		ResultSet res2 = sta2.executeQuery("SELECT * FROM bebida_preparadas");
		while(res2.next()) {
			
			this.aguaPreparada.addItem(res2.getString("bebida"));
		}
		
		
		
		aguaPreparada.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
			
				
			}
		});
		
		JLabel lblBebidasPreparadas = new JLabel("AGUAS");
		lblBebidasPreparadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBebidasPreparadas.setForeground(Color.WHITE);
		lblBebidasPreparadas.setFont(new Font("DFGothic-EB", Font.BOLD, 22));
		lblBebidasPreparadas.setBackground(Color.BLACK);
		lblBebidasPreparadas.setBounds(20, 253, 814, 37);
		contentPane.add(lblBebidasPreparadas);
		
		JLabel lblBebidas_1 = new JLabel("BEBIDAS");
		lblBebidas_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBebidas_1.setForeground(Color.ORANGE);
		lblBebidas_1.setFont(new Font("DFGothic-EB", Font.BOLD, 25));
		lblBebidas_1.setBounds(20, 11, 814, 37);
		contentPane.add(lblBebidas_1);
		
		JButton botonRefresco = new JButton("Ordenar");
		botonRefresco.setForeground(SystemColor.window);
		botonRefresco.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonRefresco.setBackground(SystemColor.controlShadow);
		botonRefresco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				if(bebidas.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "INGRESE UN PRODUCTO", "ERROR",JOptionPane.WARNING_MESSAGE);
					
				}else {
				
				
				Connection con = null;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/Restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					
					con = DriverManager.getConnection(url, usr, psw);
					
					
					String bebida = bebidas.getSelectedItem().toString();	
					String query = "INSERT INTO alimentos (comida) values ('"+bebida+"')";	
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					//textFieldresultado.setText("");
					JOptionPane.showMessageDialog(null, "BEBIDA ORDENADA :" + "\n"+ bebida);
					
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con LAAa  conexión de BD");
				}
		
				}
			}
			
		});
		botonRefresco.setBounds(628, 105, 122, 33);
		contentPane.add(botonRefresco);
		
		JButton buttonAlcohol = new JButton("Ordenar");
		buttonAlcohol.setForeground(SystemColor.window);
		buttonAlcohol.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonAlcohol.setBackground(SystemColor.controlShadow);
		buttonAlcohol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(alcohol.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "INGRESE UN PRODUCTO", "ERROR",JOptionPane.WARNING_MESSAGE);
					
				}else {
				
				
				
				Connection con = null;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/Restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					
					con = DriverManager.getConnection(url, usr, psw);
					
					
					String alco = alcohol.getSelectedItem().toString();	
					String query = "INSERT INTO alimentos (comida) values ('"+alco+"')";	
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					//textFieldresultado.setText("");
					JOptionPane.showMessageDialog(null, "BEBIDA ORDENADA" + "\n"+ alco);
					
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con LAAa  conexión de BD");
				}
		
				}
			
			}
				
			
		});
		buttonAlcohol.setBounds(628, 203, 122, 33);
		contentPane.add(buttonAlcohol);
		
		JButton botonAgua = new JButton("Ordenar");
		botonAgua.setForeground(SystemColor.window);
		botonAgua.setBackground(SystemColor.controlShadow);
		botonAgua.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonAgua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(agua.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "INGRESE UN PRODUCTO", "ERROR",JOptionPane.WARNING_MESSAGE);
					
				}else {
				
				
			
				Connection con = null;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/Restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					con = DriverManager.getConnection(url, usr, psw);
					
					
					String aguas = agua.getSelectedItem().toString();	
					String query = "INSERT INTO alimentos (comida) values ('"+aguas+"')";	
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					//textFieldresultado.setText("");
					JOptionPane.showMessageDialog(null, "BEBIDA ORDENADA" + "\n"+ aguas);
					
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con LAAa  conexión de BD");
				}
		
				}
			
			}
			
		});
		botonAgua.setBounds(628, 295, 122, 33);
		contentPane.add(botonAgua);
		
		JButton botonpreparadas = new JButton("Ordenar");
		botonpreparadas.setForeground(SystemColor.window);
		botonpreparadas.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonpreparadas.setBackground(SystemColor.controlShadow);
		botonpreparadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(aguaPreparada.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "INGRESE UN PRODUCTO", "ERROR",JOptionPane.WARNING_MESSAGE);
					
				}else {
				
				
				
				Connection con = null;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/Restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					con = DriverManager.getConnection(url, usr, psw);
					
					
					String preparada = aguaPreparada.getSelectedItem().toString();	
					String query = "INSERT INTO alimentos (comida) values ('"+preparada+"')";	
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					//textFieldresultado.setText("");
					JOptionPane.showMessageDialog(null, "BEBIDA ORDENADA" + "\n"+ preparada);
					
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con LAAa  conexión de BD");
				}
		
				}
			}
			
		});
		botonpreparadas.setBounds(628, 392, 122, 33);
		contentPane.add(botonpreparadas);
		
		JLabel lblBeidasPreparadas = new JLabel("BEBIDAS PREPARADAS");
		lblBeidasPreparadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeidasPreparadas.setForeground(Color.WHITE);
		lblBeidasPreparadas.setFont(new Font("DFGothic-EB", Font.BOLD, 22));
		lblBeidasPreparadas.setBackground(Color.BLACK);
		lblBeidasPreparadas.setBounds(31, 340, 814, 37);
		contentPane.add(lblBeidasPreparadas);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(bebidas.class.getResource("/ima1/bebidasPo.jpeg")));
		lblNewLabel_1.setBounds(0, 0, 878, 600);
		contentPane.add(lblNewLabel_1);
		

	
		
		
	}
	
	
	
}
