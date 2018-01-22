package Formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class alta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(94, 105, 338, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 224, 338, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(94, 341, 338, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(487, 105, 137, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGISTRAR");
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(487, 224, 137, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REGISTRAR");
		btnNewButton_2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(486, 341, 138, 32);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SALIR");
		btnNewButton_3.setForeground(Color.ORANGE);
		btnNewButton_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnNewButton_3.setBackground(Color.RED);
		btnNewButton_3.setBounds(495, 11, 129, 43);
		contentPane.add(btnNewButton_3);
		
		JLabel lblAltaDePaltillos = new JLabel("ALTA DE PALTILLOS");
		lblAltaDePaltillos.setBackground(Color.BLACK);
		lblAltaDePaltillos.setForeground(Color.RED);
		lblAltaDePaltillos.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblAltaDePaltillos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDePaltillos.setBounds(165, 11, 220, 32);
		contentPane.add(lblAltaDePaltillos);
		
		JLabel lblComidas = new JLabel("COMIDAS");
		lblComidas.setForeground(Color.ORANGE);
		lblComidas.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblComidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblComidas.setBounds(94, 79, 87, 14);
		contentPane.add(lblComidas);
		
		JLabel lblBebidas = new JLabel("BEBIDAS");
		lblBebidas.setForeground(Color.ORANGE);
		lblBebidas.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblBebidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBebidas.setBounds(94, 199, 93, 14);
		contentPane.add(lblBebidas);
		
		JLabel lblPostres = new JLabel("POSTRES");
		lblPostres.setForeground(Color.ORANGE);
		lblPostres.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblPostres.setHorizontalAlignment(SwingConstants.CENTER);
		lblPostres.setBounds(94, 303, 87, 14);
		contentPane.add(lblPostres);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setIcon(new ImageIcon(alta.class.getResource("/ima1/alta.jpg")));
		lblNewLabel.setBounds(0, 0, 634, 471);
		contentPane.add(lblNewLabel);
	}
}
