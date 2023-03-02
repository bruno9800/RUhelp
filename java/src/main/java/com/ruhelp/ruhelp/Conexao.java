package com.ruhelp.ruhelp;

import java.sql.*;

public class Conexao {

	private static Connection c = null;



	private Conexao() {}

	static  {
		try {
			if(c == null){
				Class.forName("org.postgresql.Driver");
				c = (DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "test123"));
			}
		} catch( SQLException | ClassNotFoundException e) {
			
		}
	}

	

	public static Connection getConexao() {
		return c;
	}

}