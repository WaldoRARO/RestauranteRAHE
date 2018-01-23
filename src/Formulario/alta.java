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

public class alta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		contentPane.add(textField_2);
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
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(380, 173, 137, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REGISTRAR");
		btnNewButton_2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(380, 241, 138, 32);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SALIR");
		btnNewButton_3.setForeground(Color.ORANGE);
		btnNewButton_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnNewButton_3.setBackground(Color.RED);
		btnNewButton_3.setBounds(1034, 7, 129, 43);
		contentPane.add(btnNewButton_3);
		
		JLabel lblAltaDePaltillos = new JLabel("ALTA DE PALTILLOS");
		lblAltaDePaltillos.setBackground(Color.BLACK);
		lblAltaDePaltillos.setForeground(Color.RED);
		lblAltaDePaltillos.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblAltaDePaltillos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDePaltillos.setBounds(398, 11, 445, 53);
		contentPane.add(lblAltaDePaltillos);
		
		JLabel lblComidas = new JLabel("CARNE");
		lblComidas.setForeground(Color.ORANGE);
		lblComidas.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblComidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblComidas.setBounds(134, 82, 87, 14);
		contentPane.add(lblComidas);
		
		JLabel lblBebidas = new JLabel("ENTRADAS");
		lblBebidas.setForeground(Color.ORANGE);
		lblBebidas.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblBebidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBebidas.setBounds(139, 150, 93, 14);
		contentPane.add(lblBebidas);
		
		JLabel lblPostres = new JLabel("ENSALADAS");
		lblPostres.setForeground(Color.ORANGE);
		lblPostres.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblPostres.setHorizontalAlignment(SwingConstants.CENTER);
		lblPostres.setBounds(127, 218, 123, 14);
		contentPane.add(lblPostres);
		
		JLabel lblNewLabel_1 = new JLabel("MARISCOS");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(134, 287, 116, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(20, 310, 338, 32);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("REGISTRAR");
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
		btnNewButton_5.setFont(new Font("Arial Black", Font.ITALIC, 14));
		btnNewButton_5.setBackground(Color.ORANGE);
		btnNewButton_5.setBounds(993, 126, 136, 30);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("REGISTRO");
		btnNewButton_6.setFont(new Font("Arial Black", Font.ITALIC, 14));
		btnNewButton_6.setBackground(Color.ORANGE);
		btnNewButton_6.setBounds(994, 205, 135, 34);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("REGISTRAR");
		btnNewButton_7.setFont(new Font("Arial Black", Font.ITALIC, 14));
		btnNewButton_7.setBackground(Color.ORANGE);
		btnNewButton_7.setBounds(993, 285, 136, 32);
		contentPane.add(btnNewButton_7);
		
		JLabel lblHelados = new JLabel("HELADOS");
		lblHelados.setForeground(Color.ORANGE);
		lblHelados.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblHelados.setBounds(645, 101, 109, 14);
		contentPane.add(lblHelados);
		
		JLabel lblTartas = new JLabel("TARTAS");
		lblTartas.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblTartas.setForeground(Color.ORANGE);
		lblTartas.setBounds(645, 184, 109, 14);
		contentPane.add(lblTartas);
		
		JLabel lblEspecialidades = new JLabel("ESPECIALIDADES");
		lblEspecialidades.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblEspecialidades.setForeground(Color.ORANGE);
		lblEspecialidades.setBounds(645, 263, 137, 14);
		contentPane.add(lblEspecialidades);
	}
}
