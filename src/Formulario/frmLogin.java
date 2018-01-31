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
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(-18, 114, 123, 14);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setFont(new Font("Arial Black", Font.ITALIC, 16));
		lblContrasea.setForeground(Color.BLACK);
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setBounds(-18, 206, 160, 14);
		contentPane.add(lblContrasea);
		
		


		txtUsuario = new JTextField();
		txtUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtUsuario.setBounds(163, 98, 240, 27);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(163, 193, 240, 27);
		contentPane.add(txtContraseña);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnSalir.setBackground(Color.RED);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		btnSalir.setBounds(483, 11, 101, 32);
		contentPane.add(btnSalir);

		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new Color(60, 179, 113));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnIngresar.setBounds(214, 231, 139, 34);
		contentPane.add(btnIngresar);
		
		JLabel lblNewLabel = new JLabel("BIENVENIDOS");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(90, -4, 427, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("..\\ima\\Login.jpg"));
		lblNewLabel_1.setBounds(0, 24, 437, 50);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAgregar = new JButton("REGISTRAR");
		btnAgregar.setBackground(SystemColor.textHighlight);
		btnAgregar.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnAgregar.setForeground(new Color(0, 0, 0));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				frmADD agregar = new frmADD();
				agregar.setVisible(true);
				frmLogin.this.dispose();
				
			}
		});
		btnAgregar.setBounds(10, 307, 147, 41);
		contentPane.add(btnAgregar);
		
		JButton btnNewButton = new JButton("ALTA");
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alta alt = new alta();
				alt.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(483, 308, 101, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(frmLogin.class.getResource("/ima1/frutos.jpg")));
		lblNewLabel_2.setBounds(0, 0, 594, 371);
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
