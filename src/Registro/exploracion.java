package Registro;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class exploracion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		frame frame = new frame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnBoton = new JButton("boton");
		panel.add(btnBoton);
		frame.setVisible(true);

	}

}

class frame extends JFrame{
	
	public frame() {
		
		setBounds(500, 100, 500, 400);
		panel p = new panel();
		add(p);
	}
	
}
class panel extends JPanel{
	
	
	
	public panel() {
		
	
		
		setLayout( new BorderLayout());
		
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/Restaurante";
			String usr = "root";

			String psw = "RARO97";
			//String psw = "";

			Connection conexion = (Connection) DriverManager.getConnection(url, usr, psw);
			
			Statement st = (Statement) conexion.createStatement();
			ResultSet rs =  (ResultSet) st.executeQuery("select comida, bebidas, postres from alimentos, tb_bebida,tb_postres");
			
			
			String comida,bebidas,postres;
					
			String [] columnas= {"comida", "bebida","postre"};
					
			JTable tabla = new JTable();
			DefaultTableModel modelo = new DefaultTableModel();
			modelo.setColumnIdentifiers(columnas);
			tabla.setModel(modelo);
			
			 while(rs.next()) {
				 comida = rs.getString("comida");
				 bebidas = rs.getString("bebidas");
				 postres = rs.getString("postres");
				
				 
				modelo.addRow(new Object[] {comida, bebidas, postres});
			 }
			JScrollPane scroll = new JScrollPane(tabla);
			add(scroll,BorderLayout.CENTER);
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "nel prro :v");

			
		}
		
		
		
	}
}