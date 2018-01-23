package Formulario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Usuario;
import mantenimientos.GestionUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	JRadioButton Hombre;
	ButtonGroup bH;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					 frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 226);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("USERNAME");
		lblUsuario.setFont(new Font("Consolas", Font.BOLD, 12));
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(50, 81, 85, 14);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("PASSWORD");
		lblContrasea.setFont(new Font("Consolas", Font.BOLD, 12));
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setBounds(50, 110, 85, 14);
		contentPane.add(lblContrasea);
		
		


		txtUsuario = new JTextField();
		txtUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtUsuario.setBounds(166, 78, 190, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(166, 107, 190, 20);
		contentPane.add(txtContraseña);

		JButton btnSalir = new JButton("exit");
		btnSalir.setForeground(Color.DARK_GRAY);
		btnSalir.setFont(new Font("Microsoft JhengHei", Font.BOLD, 11));
		btnSalir.setBackground(new Color(230, 230, 250));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		btnSalir.setBounds(232, 147, 85, 23);
		contentPane.add(btnSalir);

		JButton btnIngresar = new JButton("login");
		btnIngresar.setFont(new Font("Microsoft JhengHei", Font.BOLD, 11));
		btnIngresar.setForeground(Color.DARK_GRAY);
		btnIngresar.setBackground(new Color(230, 230, 250));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnIngresar.setBounds(116, 147, 85, 23);
		contentPane.add(btnIngresar);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 427, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("..\\ima\\Login.jpg"));
		lblNewLabel_1.setBounds(0, 24, 437, 50);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAgregar = new JButton("REGISTRAR");
		btnAgregar.setFont(new Font("Microsoft JhengHei", Font.BOLD, 11));
		btnAgregar.setForeground(Color.DARK_GRAY);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				frmADD agregar = new frmADD();
				agregar.setVisible(true);
				frmLogin.this.dispose();
				
			}
		});
		btnAgregar.setBounds(10, 147, 85, 23);
		contentPane.add(btnAgregar);
		
		JButton btnNewButton = new JButton("ALTA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alta alt = new alta();
				alt.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(338, 148, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(frmLogin.class.getResource("/ima1/Login.jpg")));
		lblNewLabel_2.setBounds(0, -1, 437, 198);
		contentPane.add(lblNewLabel_2);
	}

	protected void ingresar() {

		String usuario = txtUsuario.getText();
		String clave = String.valueOf(txtContraseña.getPassword());

		GestionUsuario gestionUsuario = new GestionUsuario();

		Usuario usuario2 = new Usuario();
		usuario2.setUsuario(usuario);
		usuario2.setClave(clave);

		Usuario usu = gestionUsuario.obtenerUsuario(usuario2);
		if(txtUsuario.getText().length()==0){
		JOptionPane.showMessageDialog(txtUsuario, "Ingresar usuario" ,"Error", JOptionPane.WARNING_MESSAGE);
		}else{
		


		if (usu != null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");

			this.dispose();
			
			restaurante bienvenida = new restaurante();
			bienvenida.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(contentPane, "Datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		}
	}

	protected void salir() {
		System.exit(0);
	}
}
