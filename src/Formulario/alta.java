package Formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class alta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alta frame = new alta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public alta() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		setResizable(false);


		
		textField = new JTextField();
		textField.setBounds(20, 107, 338, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(20, 175, 338, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(20, 243, 338, 32);
		contentPane.add(textField_2);//ensaladas
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Connection con = null;
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					con = DriverManager.getConnection(url, usr, psw);
					String usuario= textField.getText();
					String query = "INSERT INTO carne (platillo) values ('"+usuario+"')";
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					textField.setText("");
					JOptionPane.showMessageDialog(null, "USUARIO INGRESADO A LA BD");
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con la  conexión de BD");
				}	
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(380, 105, 137, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGISTRAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					con = DriverManager.getConnection(url, usr, psw);
					String usuario= textField_2.getText();
					String query = "INSERT INTO entrada (platillo) values ('"+usuario+"')";
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					textField.setText("");
					JOptionPane.showMessageDialog(null, "USUARIO INGRESADO A LA BD");
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con la  conexión de BD");
				}	
			}
			
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(380, 173, 137, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REGISTRAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					con = DriverManager.getConnection(url, usr, psw);
					String usuario= textField_1.getText();
					String query = "INSERT INTO ensaladas (platillo) values ('"+usuario+"')";
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					textField.setText("");
					JOptionPane.showMessageDialog(null, "USUARIO INGRESADO A LA BD");
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con la  conexión de BD");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(380, 241, 138, 32);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SALIR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alta.this.dispose();
			}
		});
		btnNewButton_3.setForeground(Color.ORANGE);
		btnNewButton_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnNewButton_3.setBackground(Color.RED);
		btnNewButton_3.setBounds(1034, 7, 129, 43);
		contentPane.add(btnNewButton_3);
		
		JLabel lblAltaDePaltillos = new JLabel("ALTA DE PLATILLOS");
		lblAltaDePaltillos.setBackground(Color.BLACK);
		lblAltaDePaltillos.setForeground(Color.RED);
		lblAltaDePaltillos.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblAltaDePaltillos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDePaltillos.setBounds(398, 11, 445, 53);
		contentPane.add(lblAltaDePaltillos);
		
		JLabel lblComidas = new JLabel("CARNE");
		lblComidas.setForeground(SystemColor.desktop);
		lblComidas.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblComidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblComidas.setBounds(134, 82, 87, 14);
		contentPane.add(lblComidas);
		
		JLabel lblBebidas = new JLabel("ENTRADAS");
		lblBebidas.setForeground(SystemColor.desktop);
		lblBebidas.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblBebidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBebidas.setBounds(139, 150, 93, 14);
		contentPane.add(lblBebidas);
		
		JLabel lblPostres = new JLabel("ENSALADAS");
		lblPostres.setForeground(SystemColor.desktop);
		lblPostres.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblPostres.setHorizontalAlignment(SwingConstants.CENTER);
		lblPostres.setBounds(127, 218, 123, 14);
		contentPane.add(lblPostres);
		
		JLabel lblNewLabel_1 = new JLabel("MARISCOS");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(134, 287, 116, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(20, 310, 338, 32);
		contentPane.add(textField_3);//mariscos
		textField_3.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("REGISTRAR");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					con = DriverManager.getConnection(url, usr, psw);
					String usuario= textField_3.getText();
					String query = "INSERT INTO mariscos (platillo) values ('"+usuario+"')";
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					textField.setText("");
					JOptionPane.showMessageDialog(null, "USUARIO INGRESADO A LA BD");
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con la  conexión de BD");
				}
			}
		});
		btnNewButton_4.setBackground(Color.ORANGE);
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setFont(new Font("Arial Black", Font.ITALIC, 14));
		btnNewButton_4.setBounds(380, 310, 137, 28);
		contentPane.add(btnNewButton_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(645, 126, 338, 32);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(645, 205, 338, 32);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(645, 287, 338, 30);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("REGISTRO");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					con = DriverManager.getConnection(url, usr, psw);
					String usuario= textField_4.getText();
					String query = "INSERT INTO helados (postre) values ('"+usuario+"')";
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					textField.setText("");
					JOptionPane.showMessageDialog(null, "USUARIO INGRESADO A LA BD");
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con la  conexión de BD");
				}
			}
		});
		btnNewButton_5.setFont(new Font("Arial Black", Font.ITALIC, 14));
		btnNewButton_5.setBackground(Color.ORANGE);
		btnNewButton_5.setBounds(993, 126, 136, 30);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("REGISTRO");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					con = DriverManager.getConnection(url, usr, psw);
					String usuario= textField_5.getText();
					String query = "INSERT INTO tartas (postre) values ('"+usuario+"')";
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					textField.setText("");
					JOptionPane.showMessageDialog(null, "USUARIO INGRESADO A LA BD");
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con la  conexión de BD");
				}
			}
		});
		btnNewButton_6.setFont(new Font("Arial Black", Font.ITALIC, 14));
		btnNewButton_6.setBackground(Color.ORANGE);
		btnNewButton_6.setBounds(994, 205, 135, 34);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("REGISTRAR");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					con = DriverManager.getConnection(url, usr, psw);
					String usuario= textField_6.getText();
					String query = "INSERT INTO especialidades (postre) values ('"+usuario+"')";
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					textField.setText("");
					JOptionPane.showMessageDialog(null, "USUARIO INGRESADO A LA BD");
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con la  conexión de BD");
				}
			}
		});
		btnNewButton_7.setFont(new Font("Arial Black", Font.ITALIC, 14));
		btnNewButton_7.setBackground(Color.ORANGE);
		btnNewButton_7.setBounds(993, 285, 136, 32);
		contentPane.add(btnNewButton_7);
		
		JLabel lblHelados = new JLabel("HELADOS");
		lblHelados.setForeground(SystemColor.desktop);
		lblHelados.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblHelados.setBounds(645, 101, 109, 14);
		contentPane.add(lblHelados);
		
		JLabel lblTartas = new JLabel("TARTAS");
		lblTartas.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblTartas.setForeground(SystemColor.desktop);
		lblTartas.setBounds(645, 184, 109, 14);
		contentPane.add(lblTartas);
		
		JLabel lblEspecialidades = new JLabel("ESPECIALIDADES");
		lblEspecialidades.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblEspecialidades.setForeground(SystemColor.desktop);
		lblEspecialidades.setBounds(645, 263, 137, 14);
		contentPane.add(lblEspecialidades);
		
		textField_7 = new JTextField();
		textField_7.setBounds(20, 405, 338, 32);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(20, 487, 338, 32);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("REGISTRAR");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					con = DriverManager.getConnection(url, usr, psw);
					String usuario= textField_7.getText();
					String query = "INSERT INTO refresco (bebida) values ('"+usuario+"')";
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					textField.setText("");
					JOptionPane.showMessageDialog(null, "USUARIO INGRESADO A LA BD");
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con la  conexión de BD");
				}
			}
		});
		btnNewButton_8.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_8.setBackground(Color.ORANGE);
		btnNewButton_8.setBounds(380, 405, 137, 32);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("REGISTRAR");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					con = DriverManager.getConnection(url, usr, psw);
					String usuario= textField_8.getText();
					String query = "INSERT INTO bebida_alcoholica (bebida) values ('"+usuario+"')";
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					textField.setText("");
					JOptionPane.showMessageDialog(null, "USUARIO INGRESADO A LA BD");
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con la  conexión de BD");
				}
			}
		});
		btnNewButton_9.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_9.setBackground(Color.ORANGE);
		btnNewButton_9.setBounds(380, 487, 137, 32);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("REGISTRAR");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					con = DriverManager.getConnection(url, usr, psw);
					String usuario= textField_9.getText();
					String query = "INSERT INTO aguas (bebida) values ('"+usuario+"')";
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					textField.setText("");
					JOptionPane.showMessageDialog(null, "USUARIO INGRESADO A LA BD");
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con la  conexión de BD");
				}
			}
		});
		btnNewButton_10.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_10.setBackground(Color.ORANGE);
		btnNewButton_10.setBounds(645, 402, 137, 34);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("REGISTRAR");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";
					con = DriverManager.getConnection(url, usr, psw);
					String usuario= textField_10.getText();
					String query = "INSERT INTO bebida_preparadas (bebida) values ('"+usuario+"')";
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					textField.setText("");
					JOptionPane.showMessageDialog(null, "USUARIO INGRESADO A LA BD");
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con la  conexión de BD");
				}
			}
		});
		btnNewButton_11.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_11.setBackground(Color.ORANGE);
		btnNewButton_11.setBounds(645, 485, 137, 32);
		contentPane.add(btnNewButton_11);
		
		textField_9 = new JTextField();
		textField_9.setBounds(791, 405, 338, 32);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(791, 487, 338, 32);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("REFRESCOS");
		lblNewLabel.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBounds(20, 380, 121, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("BEBIDAS CON ALCOHOL");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblNewLabel_2.setForeground(SystemColor.desktop);
		lblNewLabel_2.setBounds(168, 462, 251, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AGUAS");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblNewLabel_3.setForeground(SystemColor.desktop);
		lblNewLabel_3.setBounds(791, 380, 129, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("BEBIDAS PREPARADAS");
		lblNewLabel_4.setForeground(SystemColor.desktop);
		lblNewLabel_4.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblNewLabel_4.setBounds(791, 462, 203, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(alta.class.getResource("/ima1/alta.jpg")));
		lblNewLabel_5.setBounds(0, 0, 1304, 607);
		contentPane.add(lblNewLabel_5);
	}
}
