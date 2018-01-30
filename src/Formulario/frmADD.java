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

public class frmADD extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField ciudad;
	private JTextField apellido;
	private JTextField nombre;

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
		setBounds(100, 100, 450, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(160, 175, 156, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 225, 156, 20);
		panel.add(passwordField);
		
		ciudad = new JTextField();
		ciudad.setBounds(160, 132, 156, 20);
		panel.add(ciudad);
		ciudad.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(160, 85, 156, 20);
		panel.add(apellido);
		apellido.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(160, 36, 156, 20);
		panel.add(nombre);
		nombre.setColumns(10);
		
		JButton btnAdd = new JButton("ALTA DE USUARIO");
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
							String usuario3= ciudad.getText();



							
						 
						
							String query = "INSERT INTO tb_usuario (usuario,clave,nombre,apellido,ciudad) values ('"+usuario+"','"+clave+"','"+usuario1+"','"+usuario2+"','"+usuario3+"')";
							
					
							
							Statement stm = con.createStatement();
							
							stm.executeUpdate(query);
							
							textField.setText("");
							passwordField.setText("");
							nombre.setText("");
							apellido.setText("");
							ciudad.setText("");
							
							
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
		btnAdd.setBounds(278, 275, 146, 34);
		panel.add(btnAdd);
		
		JLabel lblUsername = new JLabel("USUARIO");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(50, 181, 80, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("CONTRASE\u00D1A");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(61, 224, 89, 23);
		panel.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("CIUDAD");
		lblNewLabel.setBounds(67, 135, 46, 14);
		panel.add(lblNewLabel);
		
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(67, 88, 72, 14);
		panel.add(lblApellido);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(67, 39, 46, 14);
		panel.add(lblNombre);
	
	}
	}


