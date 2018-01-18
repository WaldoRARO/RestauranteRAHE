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
	private JTable table;


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
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		
		
		
		JButton btnInsertar = new JButton("insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/restaurante";
					String usr = "root";
					String psw = "RARO97";
					//String psw = "";//

					
					con = DriverManager.getConnection(url, usr, psw);
					
				} catch (ClassNotFoundException e) {
					System.out.println("Error");
				} catch (SQLException e) {
					System.out.println("Error con la  conexión de BD");
				}
				
				String sql = "select * from alimentos";
				Statement st;
				
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("PLATILLOS RODENADOS");
				modelo.addColumn("comida");
				

					table.setModel(modelo);
					
					String[] dato = new String[3];
					try {
						st = con.createStatement();
						ResultSet resul = st.executeQuery(sql);
						
						while (resul.next()) {
							dato[0]=resul.getString(1);
							dato[0]=resul.getString(2);
							
							modelo.addRow(dato);
							
						}
					} catch (Exception e) {
					}
			}
		}); 
		btnInsertar.setBounds(10, 256, 89, 23);
		contentPane.add(btnInsertar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 234);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnModificar = new JButton("modificar");
		btnModificar.setBounds(120, 256, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnActu = new JButton("actualizar");
		btnActu.setBounds(227, 256, 89, 23);
		contentPane.add(btnActu);
		
		JButton btnEliminar = new JButton("eliminar");
		btnEliminar.setBounds(335, 256, 89, 23);
		contentPane.add(btnEliminar);
		
	
		
	}
}
