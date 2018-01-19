package Comida;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import Formulario.restaurante;
import Postre.Postres;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Registro.Registros;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import Comida.alimentos;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class comida extends JFrame implements ActionListener{
	
	
	private JComboBox<String> carne;
	private JComboBox<String> mariscos;
	private JComboBox<String> ensaladas;
	private JComboBox<String> entradas;
	private JPanel contentPane;
	Formulario.restaurante form = new Formulario.restaurante();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comida frame = new comida();
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
	 */
	public comida() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		carne = new JComboBox<String>();
		carne.setForeground(new Color(255, 250, 250));
		carne.setFont(new Font("Arial Black", Font.PLAIN, 13));
		carne.setBackground(new Color(0, 128, 128));
		carne.setBounds(10, 446, 348, 29);
		getContentPane().add(carne);
		
		carne.addItem("");
		carne.addItem("Puyazo \"Best Seller\"");
		carne.addItem("Filete Blue Cheese");
		carne.addItem("Filete de Res de Exportación");
		carne.addItem("Filete Mignon");
		carne.addItem("Filete de Res Nacional");
		carne.addItem("Lomo de Costilla 10 OZ");
		carne.addItem("Lomo de Costilla 16 OZ");
		carne.addItem("Fajitas de Res");
		
		
		mariscos = new JComboBox<String>();
		mariscos.setFont(new Font("Arial Black", Font.PLAIN, 13));
		mariscos.setBackground(new Color(0, 128, 128));
		mariscos.setForeground(new Color(255, 250, 250));
		mariscos.setBounds(420, 446, 348, 29);
		getContentPane().add(mariscos);
		mariscos.addItem("");
		mariscos.addItem("Filete de Pescado");
		mariscos.addItem("Camarones Empanizados");
		mariscos.addItem("Camarones al Ajillo");
		mariscos.addItem("Pescado a \"la Tipitapa\"");
		mariscos.addItem("Curritos de Pescado");
		mariscos.addItem("Especial de Langosta");
		
		JLabel lblNewLabel = new JLabel("CARNES");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setBackground(new Color(153, 153, 102));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(231, 399, 168, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MARISCOS");
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(420, 399, 104, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ORDENAR");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				if(carne.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "INGRESE UN PRODUCTO", "ERROR",JOptionPane.WARNING_MESSAGE);
					
				}else {
				
				Connection con = null;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/Restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";//
					con = DriverManager.getConnection(url, usr, psw);
					
					//String comida= textFieldresultado.getText();
					//carne.getSelectedItem().toString();
					String cora = carne.getSelectedItem().toString();	
					String query = "INSERT INTO alimentos (comida) values ('"+cora+"')";	
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					//textFieldresultado.setText("");
					JOptionPane.showMessageDialog(null, "	PLATILLO ORDENADO");
					
				} catch (ClassNotFoundException e) {
					System.out.println("Error");
				} catch (SQLException e) {
					System.out.println("Error con LAAa  conexión de BD");
				}
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(10, 491, 111, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGRESAR");
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comida.this.dispose();
			}
		});
		btnNewButton_1.setBounds(646, 11, 138, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("ENTRADAS");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 152, 138, 29);
		contentPane.add(lblNewLabel_2);
		
		entradas = new JComboBox<String>();
		entradas.setForeground(new Color(255, 250, 250));
		entradas.setFont(new Font("Arial Black", Font.PLAIN, 13));
		entradas.setBackground(new Color(0, 128, 128));
		entradas.setBounds(10, 192, 364, 29);
		contentPane.add(entradas);
		entradas.addItem("");
		entradas.addItem("Tostones con Bolitas de carne");
		entradas.addItem("Tostones Rellenos");
		entradas.addItem("Tostones Mini Churrasco");
		entradas.addItem("Tostones Mini Jalapeños");
		entradas.addItem("Frijolitos Refritos");
		entradas.addItem("Súper Nachos Nica");
		entradas.addItem("Quesadillas de res, Pollo o Cerdo");
		entradas.addItem("Parrillada de Chorizos Importados");
	
		
		JLabel lblEntradas = new JLabel("ENSALADA");
		lblEntradas.setForeground(Color.WHITE);
		lblEntradas.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradas.setBounds(630, 154, 138, 24);
		contentPane.add(lblEntradas);
		ensaladas = new JComboBox<String>();
		ensaladas.setForeground(new Color(255, 250, 250));
		ensaladas.setBackground(new Color(0, 128, 128));
		ensaladas.setFont(new Font("Arial Black", Font.PLAIN, 13));
		ensaladas.setBounds(420, 192, 348, 29);
		contentPane.add(ensaladas);
		ensaladas.addItem("");
		ensaladas.addItem("Ensalada de La Casa");
		ensaladas.addItem("Ensalada Cesar");
		ensaladas.addItem("Ensalada César con Pollo");
		ensaladas.addItem("Ensalada Iceberg");
		
		JButton btnMari = new JButton("ORDENAR");
		btnMari.setForeground(new Color(255, 255, 255));
		btnMari.setBackground(new Color(0, 128, 128));
		btnMari.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 15));
		btnMari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(mariscos.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "INGRESE UN PRODUCTO", "ERROR",JOptionPane.WARNING_MESSAGE);
					
				}else {
				Connection con = null;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/Restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";//
					con = DriverManager.getConnection(url, usr, psw);
					
					//String comida= textFieldresultado.getText();
					//carne.getSelectedItem().toString();
					String cora = mariscos.getSelectedItem().toString();	
					String query = "INSERT INTO alimentos (comida) values ('"+cora+"')";	
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					//textFieldresultado.setText("");
					JOptionPane.showMessageDialog(null, "	PLATILLO ORDENADO");
					
				} catch (ClassNotFoundException e1) {
					System.out.println("Error");
				} catch (SQLException e1) {
					System.out.println("Error con LAAa  conexión de BD");
				}
			}
			}
		});
		btnMari.setBounds(657, 491,111, 45);
		contentPane.add(btnMari);
		
		JButton btnEntra = new JButton("ORDENAR");
		btnEntra.setForeground(new Color(255, 255, 255));
		btnEntra.setBackground(new Color(0, 128, 128));
		btnEntra.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 15));
		btnEntra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(entradas.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "INGRESE UN PRODUCTO", "ERROR",JOptionPane.WARNING_MESSAGE);
					
				}else {
				
				Connection con = null;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/Restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";//
					con = DriverManager.getConnection(url, usr, psw);
					
					//String comida= textFieldresultado.getText();
					//carne.getSelectedItem().toString();
					String cora = entradas.getSelectedItem().toString();	
					String query = "INSERT INTO alimentos (comida) values ('"+cora+"')";	
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					//textFieldresultado.setText("");
					JOptionPane.showMessageDialog(null, "	PLATILLO ORDENADO");
					
				} catch (ClassNotFoundException e) {
					System.out.println("Error");
				} catch (SQLException e) {
					System.out.println("Error con LAAa  conexión de BD");
				}
				}
			}
		});
		btnEntra.setBounds(10, 232,111, 45);
		contentPane.add(btnEntra);
		
		JButton btnEnsala = new JButton("ORDENAR");
		btnEnsala.setForeground(new Color(255, 255, 255));
		btnEnsala.setBackground(new Color(0, 128, 128));
		btnEnsala.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 15));
		btnEnsala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(ensaladas.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "INGRESE UN PRODUCTO", "ERROR",JOptionPane.WARNING_MESSAGE);
					
				}else {
				Connection con = null;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/Restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";//
					con = DriverManager.getConnection(url, usr, psw);
					
					//String comida= textFieldresultado.getText();
					//carne.getSelectedItem().toString();
					String cora = ensaladas.getSelectedItem().toString();	
					String query = "INSERT INTO alimentos (comida) values ('"+cora+"')";	
					Statement stm = con.createStatement();
					stm.executeUpdate(query);
					//textFieldresultado.setText("");
					JOptionPane.showMessageDialog(null, "	PLATILLO ORDENADO");
					
				} catch (ClassNotFoundException e2) {
					System.out.println("Error");
				} catch (SQLException e2) {
					System.out.println("Error con LAAa  conexión de BD");
				}
				}
			}
		});
		btnEnsala.setBounds(657, 232,111, 45);
		contentPane.add(btnEnsala);
		
		JLabel lblNewLabel_3 = new JLabel("COMIDAS");
		lblNewLabel_3.setForeground(new Color(255, 250, 250));
		lblNewLabel_3.setFont(new Font("Franklin Gothic Heavy", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(290, 56, 188, 45);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(comida.class.getResource("/ima1/comida.jpg")));
		lblNewLabel_4.setBounds(0, 0, 809, 600);
		contentPane.add(lblNewLabel_4);
		
		
		
		
		carne.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		mariscos.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ensaladas.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				

			}
		});
		
		entradas.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
		

			}
		});
			

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
