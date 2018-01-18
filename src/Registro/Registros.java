package Registro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registros extends JFrame {

	private JPanel contentPane;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registros frame = new Registros();
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
	public Registros() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(null);
		
		
		
		JButton btnInsertar = new JButton("insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mostrarTabla();
			}
		});
		btnInsertar.setBounds(10, 374, 89, 23);
		contentPane.add(btnInsertar);
		
		table_2 = new JTable();
		table_2.setFillsViewportHeight(true);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table_2.setBounds(407, 41, -383, 23);
		contentPane.add(table_2);
		
		
	}

	void mostrarTabla() {
		
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/Restaurante";
			String usr = "root";
			String psw = "RARO97";
			//String psw = "";//
			con = DriverManager.getConnection(url, usr, psw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error");
		} catch (SQLException e) {
			System.out.println("Error con LAAa  conexión de BD");
		}
		
		String query = "SELECT * FROM alimentos";
				//+ "UNION"
				//+ "SELECT bebidas FROM tb_bebida";	
	
		Statement st;
		DefaultTableModel modelo = new DefaultTableModel();
	
		modelo.addColumn("id");
		modelo.addColumn("comida");
		
		
		table_2.setModel(modelo);
		
		String [] datos = new String[3];
		try {
			st = con.createStatement();
			
			ResultSet resultado = st.executeQuery(query);
			
			while (resultado.next()) {
				datos[0]=resultado.getString(1);
				datos[1]=resultado.getString(2);
				
				modelo.addRow(datos);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
