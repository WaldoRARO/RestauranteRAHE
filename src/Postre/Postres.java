package Postre;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Postres extends JFrame {

	private JComboBox<String> tartas;
	private JComboBox<String> helados;
	private JComboBox<String> especial;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Postres frame = new Postres();
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
	public Postres() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		////////////////COMBOBOX
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
		
		tartas = new JComboBox<String>();
		tartas.setFont(new Font("Arial Black", Font.PLAIN, 13));
		tartas.setBackground(Color.ORANGE);
		tartas.setBounds(22, 127, 343, 36);
		contentPane.add(tartas);
		tartas.addItem("");
		Statement sent = con.createStatement();
		ResultSet res = sent.executeQuery("SELECT * FROM tartas");
		while(res.next()) {
			
			this.tartas.addItem(res.getString("postre"));
		}
		
		
		helados = new JComboBox<String>();
		helados.setFont(new Font("Arial Black", Font.PLAIN, 13));
		helados.setBackground(Color.ORANGE);
		helados.setBounds(465, 233, 346, 36);
		contentPane.add(helados);
		helados.addItem("");
		Statement sent1 = con.createStatement();
		ResultSet res1 = sent1.executeQuery("SELECT * FROM helados");
		while(res1.next()) {
			
			this.helados.addItem(res1.getString("postre"));
		}
		
		especial = new JComboBox<String>();
		especial.setFont(new Font("Arial Black", Font.PLAIN, 13));
		especial.setBackground(Color.ORANGE);
		especial.setBounds(22, 348, 343, 36);
		contentPane.add(especial);	
		especial.addItem("");
		Statement sent2 = con.createStatement();
		ResultSet res2 = sent2.executeQuery("SELECT * FROM especialidades");
		while(res2.next()) {
			
			this.especial.addItem(res2.getString("postre"));
		}

		///////////////FIN DE LOS COMBOBOX
		
		JLabel lblTartas = new JLabel("TARTAS");
		lblTartas.setForeground(Color.ORANGE);
		lblTartas.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblTartas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTartas.setBounds(0, 95, 154, 21);
		contentPane.add(lblTartas);
		
		JLabel lblHelados = new JLabel("HELADOS");
		lblHelados.setForeground(Color.ORANGE);
		lblHelados.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblHelados.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelados.setBounds(685, 201, 126, 21);
		contentPane.add(lblHelados);
		
		

		
		JLabel lblVariedad = new JLabel("ESPECIALIDADES");
		lblVariedad.setForeground(Color.ORANGE);
		lblVariedad.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblVariedad.setHorizontalAlignment(SwingConstants.CENTER);
		lblVariedad.setBounds(22, 310, 196, 21);
		contentPane.add(lblVariedad);
	
		JButton btnNewButton = new JButton("REGRESAR");
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Postres.this.dispose();
			}
		});
		btnNewButton.setBounds(670, 7, 154, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ORDENAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(especial.getSelectedIndex()==0) {
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
					String cora = especial.getSelectedItem().toString();	
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
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.setBounds(22, 395, 126, 51);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("POSTRES");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(357, 11, 142, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("ORDENAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(helados.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "INGRESE UN PRODUCTO", "ERROR",JOptionPane.WARNING_MESSAGE);
					
				}else {
				Connection con = null;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/Restaurante";
					String usr = "root";
					String psw = "RARO97";
					//String psw = "";//
					con = DriverManager.getConnection(url, usr, psw);
					
					//String comida= textFieldresultado.getText();
					//carne.getSelectedItem().toString();
					String cora = helados.getSelectedItem().toString();	
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
		btnNewButton_2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(484, 280, 126, 51);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ORDENAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tartas.getSelectedIndex()==0) {
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
					String cora = tartas.getSelectedItem().toString();	
					String query = "INSERT INTOalimentos (comida) values ('"+cora+"')";	
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
		btnNewButton_3.setBackground(Color.ORANGE);
		btnNewButton_3.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_3.setBounds(32, 174, 126, 51);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Postres.class.getResource("/ima1/Patel.jpg")));
		lblNewLabel_1.setBounds(0, 0, 834, 561);
		contentPane.add(lblNewLabel_1);
		
	}
}
