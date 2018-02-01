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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Registros extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ResultSet resul ;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
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
		btnInsertar.setBounds(292, 285, 212, 44);
		contentPane.add(btnInsertar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 57, 709, 217);
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
				//	String psw = "RARO97";
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
		btnEliminar.setBounds(10, 506, 170, 44);
		contentPane.add(btnEliminar);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE SU ORDEN");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 23, 793, 23);
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
		btnRegresar.setBounds(629, 506, 140, 44);
		contentPane.add(btnRegresar);
		
		JButton btnOrden = new JButton("ENVIAR");
		btnOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				DatosMeseros();				
				
			}
		});
		btnOrden.setForeground(Color.MAGENTA);
		btnOrden.setFont(new Font("Arial Black", Font.ITALIC, 14));
		btnOrden.setBackground(new Color(154, 205, 50));
		btnOrden.setBounds(315, 389, 170, 51);
		contentPane.add(btnOrden);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Registros.class.getResource("/ima1/fu.jpg")));
		lblNewLabel_1.setBounds(0, -2, 793, 575);
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
			modelo.addColumn("# DE PLATILLO");
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
		
		public void DatosMeseros() {
		

		/*	File agre = new File("C:\\Users\\Administrador\\Desktop\\prueba.txt");
			
		try {
				
				BufferedWriter bw = new BufferedWriter(new  FileWriter(agre, true)); //docuemntos				
				
		
				
				
				bw.newLine();
				bw.close();

				bw.newLine();
				bw.close();

				
			
			} catch (Exception e2) {
				// TODO: handle exception
			}
			*/
			
			 try {

		            String restauranteRAHE = "C:\\Users\\jahc6\\Desktop\\DatosTabla.txt";
		            BufferedWriter bfw = new BufferedWriter(new FileWriter(restauranteRAHE ));

		            for (int i = 0 ; i < table.getRowCount(); i++) 
		            {
		                for(int j = 0 ; j < table.getColumnCount();j++) 
		                {
		                    bfw.write((String)(table.getValueAt(i,j)));
		                    if (j < table.getColumnCount() -1) { 
		                        bfw.write(",");
		                    }
		                }
		                bfw.newLine(); 
		            }

		            bfw.close(); 
		            JOptionPane.showMessageDialog(table, "La orden llego a la terminal !");
		         
		        } catch (IOException e) {
		        	  JOptionPane.showMessageDialog(table, "Ocurrio un error con su orden  !"+ e.getMessage());
		          
		        }
			
			
			
		}
}
