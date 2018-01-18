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
		setBounds(100, 100, 450, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(210, 44, 156, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(210, 91, 156, 20);
		panel.add(passwordField);
		
		JButton btnAdd = new JButton("ADD");
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
							
						 
						
							String query = "INSERT INTO tb_usuario (usuario,clave) values ('"+usuario+"','"+clave+"')";
							
					
							
							Statement stm = con.createStatement();
							
							stm.executeUpdate(query);
							
							textField.setText("");
							passwordField.setText("");
							
							
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
		btnAdd.setBounds(279, 122, 89, 23);
		panel.add(btnAdd);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(72, 47, 80, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(72, 94, 80, 14);
		panel.add(lblPassword);
	
	}
	}


