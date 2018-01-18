package Comida;

import java.io.Serializable;

public class alimentos implements Serializable {
	
	private static final String [] x = null;
	private String carne;
	private String mariscos;
	
	
	public alimentos(String carne,String mariscos) {
		
		this.carne = carne;
		this.mariscos = mariscos;
		resultado();
		
		
	}
	

	private void resultado() {
		// TODO Auto-generated method stub
		
	}


	public String getCarne() {
		return carne;
	}



	public void setCarne(String carne) {
		this.carne = carne;
	}



	public String getMariscos() {
		return mariscos;
	}



	public void setMariscos(String mariscos) {
		this.mariscos = mariscos;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		
	}

}
