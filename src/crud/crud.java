package crud;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class crud extends JFrame {

	private JPanel contentPane;
	private JTextField textid;
	private JTextField textnombre;
	private JTextField textapellido;
	private JTextField textedad;
	private JTextField textcorreo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crud frame = new crud();
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
	public crud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(10, 24, 46, 14);
		contentPane.add(lblId);
		
		textid = new JTextField();
		textid.setBounds(58, 21, 86, 20);
		contentPane.add(textid);
		textid.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 49, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 74, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(10, 101, 46, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 126, 46, 14);
		contentPane.add(lblEdad);
		
		textnombre = new JTextField();
		textnombre.setBounds(89, 46, 255, 20);
		contentPane.add(textnombre);
		textnombre.setColumns(10);
		
		textapellido = new JTextField();
		textapellido.setBounds(89, 71, 255, 20);
		contentPane.add(textapellido);
		textapellido.setColumns(10);
		
		textedad = new JTextField();
		textedad.setBounds(58, 99, 255, 20);
		contentPane.add(textedad);
		textedad.setColumns(10);
		
		textcorreo = new JTextField();
		textcorreo.setBounds(58, 126, 255, 20);
		contentPane.add(textcorreo);
		textcorreo.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.setBounds(436, 20, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpiar.setBounds(436, 54, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrar.setBounds(436, 88, 89, 23);
		contentPane.add(btnBorrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 179, 555, 218);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
	private void limpiar(){
		
		textid.setText("");
		textnombre.setText("");
		textapellido.setText("");
		textedad.setText("");
		textcorreo.setText("");
		
	}

}
