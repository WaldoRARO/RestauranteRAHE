package Formulario;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bebidas.bebidas;
import Comida.comida;
import Postre.Postres;
import Registro.Registros;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.BorderLayout;


public class restaurante extends JFrame  {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					restaurante frame = new restaurante();
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
	public restaurante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		//contentPane.setForeground(Color.RED);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		
		JButton comi = new JButton("COMIDA");
		comi.setIcon(new ImageIcon("src/ima1/filete.png"));
		comi.setFont(new Font("Tahoma", Font.BOLD, 13));
		comi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			comida comid = null;
			try {
				comid = new comida();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			comid.setVisible(true);
				
			}
		});
		toolBar.add(comi);
		
		JButton bebidas = new JButton("BEBIDAS");
		bebidas.setIcon(new ImageIcon("src/ima1/vino.png"));
		bebidas.setFont(new Font("Tahoma", Font.BOLD, 13));
		bebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bebidas bebi = null;
				try {
					bebi = new bebidas();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bebi.setVisible(true);
					
				}
			});
		toolBar.add(bebidas);
		
		JButton postre = new JButton("POSTRES");
		postre.setIcon(new ImageIcon("src/ima1/helado.png"));
		postre.setFont(new Font("Tahoma", Font.BOLD, 13));
		postre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Postres postre= new Postres();
				postre.setVisible(true);
			}
		});
		toolBar.add(postre);
		
		JButton btnRegistro = new JButton("REGISTRO");
		btnRegistro.setIcon(new ImageIcon("src/ima1/notas.png"));
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registros registro = new Registros();
				registro.setVisible(true);
			}
		});
		toolBar.add(btnRegistro);
		
		JButton salir = new JButton("SALIR");
		salir.setIcon(new ImageIcon("src/ima1/comprobado.png"));
		salir.setFont(new Font("Tahoma", Font.BOLD, 13));
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null," ENSEGUIDA LO ATENDEMOS ");
				exit();			
			}
		});
		toolBar.add(salir);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src/ima1/res.jpg"));
		lblNewLabel.setBounds(0, 0, 891, 648);
		panel.add(lblNewLabel);
		this.setLocationRelativeTo(null);
		
		

		
		
	}
	
	private void exit() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}
