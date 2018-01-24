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

import com.mysql.jdbc.PreparedStatement;

import Bebidas.bebidas;
import utils.MySQLConexion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registros extends JFrame {

	private JPanel contentPane;
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
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JButton btnInsertar = new JButton("REVISAR  SU ORDEN");
		btnInsertar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnInsertar.setBackground(new Color(50, 205, 50));
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarDatos();
			}
		}); 
		btnInsertar.setBounds(60, 429, 220, 51);
		contentPane.add(btnInsertar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 55, 709, 314);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setForeground(Color.ORANGE);
		btnEliminar.setFont(new Font("Arial Black", Font.ITALIC, 14));
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con = null;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/restaurante";
					String usr = "root";
					//String psw = "RARO97";
					String psw = "";//

					
					con = DriverManager.getConnection(url, usr, psw);
					
				} catch (ClassNotFoundException e) {
					System.out.println("Error");
				} catch (SQLException e) {
					System.out.println("Error con la  conexión de BD");
				}
				
				int fila = table.getSelectedRow();
		        String valor = table.getValueAt(fila,0).toString();
		        if (fila>=0){
		            try {
		                PreparedStatement pps = (PreparedStatement) con.prepareStatement("DELETE FROM alimentos WHERE idalimentos='"+valor+"'");
		                pps.executeUpdate();
		                JOptionPane.showMessageDialog(null,"DESEA ELIMINAR \n ESTE PLATILLO");
		                mostrarDatos();
		            } catch (SQLException ex) {
		                Logger.getLogger(Registros.class.getName()).log(Level.SEVERE, null, ex);
		            }
		        }
				
				
			}
		});
		btnEliminar.addMouseListener(new MouseAdapter() {
			
			}
		);
		btnEliminar.setBounds(332, 429, 170, 51);
		contentPane.add(btnEliminar);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE SU ORDEN");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-103, 11, 793, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnRegresar.setBackground(Color.ORANGE);
		btnRegresar.setForeground(Color.RED);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Registros.this.dispose();
			}
		});
		btnRegresar.setBounds(663, 482, 140, 44);
		contentPane.add(btnRegresar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Registros.class.getResource("/ima1/restaurante.jpg")));
		lblNewLabel_1.setBounds(0, 0, 854, 595);
		contentPane.add(lblNewLabel_1);
	}
		public void mostrarDatos() {
			Connection con = null;
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost/restaurante";
				String usr = "root";
				//String psw = "RARO97";
				String psw = "";//
				con = DriverManager.getConnection(url, usr, psw);			
			} catch (ClassNotFoundException e) {
				System.out.println("Error");
			} catch (SQLException e) {
				System.out.println("Error con la  conexión de BD");
			}	
			String sql = "select * from alimentos";
			Statement st;
			
			DefaultTableModel modelo = new DefaultTableModel();
			modelo.addColumn("#");
			modelo.addColumn("PLATILLO ORDENADO");
			table.setModel(modelo);
				String[] dato = new String[3];
				try {
					st = con.createStatement();
					ResultSet resul = st.executeQuery(sql);				
					while (resul.next()) {
						dato[0]=resul.getString(1);
						dato[1]=resul.getString(2);	
						modelo.addRow(dato);					
					}
				} catch (Exception e) {
				}
		}
}
