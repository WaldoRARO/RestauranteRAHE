package Formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class frmADD extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmADD frame = new frmADD();
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
	public frmADD() {
		setResizable(false);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(177, 263, 204, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 332, 201, 29);
		panel.add(passwordField);
		
		nombre = new JTextField();
		nombre.setBounds(177, 63, 204, 29);
		panel.add(nombre);
		//textField_1.setColumns(10);
		apellido = new JTextField();
		apellido.setBounds(177, 132, 204, 29);
		panel.add(apellido);
		
		email = new JTextField();
		email.setBounds(177, 198, 204, 29);
		panel.add(email);
		email.setColumns(10);
		
		
		JButton btnAdd = new JButton("REGISTRAR");
		btnAdd.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Ingresar usuario","ERROR",JOptionPane.WARNING_MESSAGE);
				}else if(passwordField.getPassword().length==0){
					JOptionPane.showMessageDialog(null, "Ingresar contraseña","ERROR",JOptionPane.WARNING_MESSAGE);
				}else{
						
						
						Connection con = null;
						try {
							
							Class.forName("com.mysql.jdbc.Driver");
							String url = "jdbc:mysql://localhost/bd_tutorial";
							String usr = "root";
							//String psw = "RARO97";
							String psw = "";

							
							con = DriverManager.getConnection(url, usr, psw);
							
							String usuario= textField.getText();
							String clave = String.valueOf(passwordField.getPassword());
							String usuario1= nombre.getText();
							String usuario2= apellido.getText();
							String usuario3= email.getText();
	
							String query = "INSERT INTO tb_usuario (usuario,clave,nombre,apellido,cuidad) values ('"+usuario+"','"+clave+"','"+usuario1+"','"+usuario2+"','"+usuario3+"')";
	
							Statement stm = con.createStatement();
							
							stm.executeUpdate(query);
							
							textField.setText("");
							passwordField.setText("");
							nombre.setText("");
							apellido.setText("");
							email.setText("");
							
							JOptionPane.showMessageDialog(null, "USUARIO INGRESADO A LA BD");
							
						} catch (ClassNotFoundException e) {
							System.out.println("Error");
						} catch (SQLException e) {
							System.out.println("Error con la  conexión de BD");
						}
						
						
				}
				
				
				
				frmLogin bienvenida = new frmLogin();
				bienvenida.setVisible(true);
				frmADD.this.dispose();
				
				
				
			}
		});
		btnAdd.setBounds(308, 402, 166, 35);
		panel.add(btnAdd);
		
		JLabel lblUsername = new JLabel("USUARIO");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(9, 278, 105, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("CONTRASE\u00D1A");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(9, 347, 142, 14);
		panel.add(lblPassword);
		
		JLabel lblNombre = new JLabel("NOMBRE (S)");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNombre.setBounds(21, 72, 130, 23);
		panel.add(lblNombre);
		
		
		JLabel lblApellido = new JLabel("APELLIDOS");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblApellido.setBounds(21, 136, 130, 14);
		panel.add(lblApellido);
		
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblEmail.setBounds(21, 213, 80, 14);
		panel.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("FICHA DE REGISTRO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 11, 341, 35);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(frmADD.class.getResource("/ima1/logo.jpg")));
		lblNewLabel_1.setBounds(0, 0, 484, 461);
		panel.add(lblNewLabel_1);
		
		
	
	}
	}


