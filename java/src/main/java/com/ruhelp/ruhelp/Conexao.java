package com.ruhelp.ruhelp;

import java.sql.*;

public class Conexao {
	//private String local = "postgresql";
	//private String user = "postgres";
	//private String senha = "test123";
	private static Connection c = null;

	private static volatile Conexao UNIQUE_INSTANCE;
	//private String str_conexao = "jdbc:"+user+"://"+local+":5432/postgres";
	//private String driverjdbc = "org.postgresql.Driver";



	private Conexao() {}

	static  {
		try {
			if(c == null){
				Class.forName("org.postgresql.Driver");
				c = (DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "test123"));

				System.out.println("Conectou");
			}
		} catch( SQLException | ClassNotFoundException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	public static Connection getConexao() {
		return c;
	}

	/*
	public Conexao( String local, String porta,
	String banco, String user, String senha) {
  			setStr_conexao("jdbc:postgresql://"+ local +":" + porta +"/"+ banco);
  			setLocal(local);
  			setSenha(senha);
  			setUser(user);
  			setDriverjdbc("org.postgresql.Driver");

  	}

	public void configUser(String user, String senha) {
		setUser(user);
		setSenha(senha);
	}

	public void configLocal(String banco) {
		setLocal(banco);
	}

	//Conexão com o Banco de Dados
	public void conect(){
		try {
			Class.forName(getDriverjdbc());
			setC(DriverManager.getConnection("localhost", getUser(), getSenha()));
			setStatment(getC().createStatement());
		}catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	public void disconect(){
		try {
			getC().close();
		}catch (SQLException ex) {
			System.err.println(ex);
			ex.printStackTrace();
		}
	}

	public ResultSet query(String query){
		try {
			return getStatment().executeQuery(query);
		}catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// GETs AND SETs
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public static String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public static String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static Connection getC() {
		return c;
	}

	public static void setC(Connection c) {
		this.c = c;
	}

	public Statement getStatment() {
		return statment;
	}

	public static void setStatment(Statement statment) {
		this.statment = statment;
	}

	public static String getStr_conexao() {
		return str_conexao;
	}

	public void setStr_conexao(String str_conexao) {
		this.str_conexao = str_conexao;
	}

	public static String getDriverjdbc() {
		return driverjdbc;
	}

	public void setDriverjdbc(String driverjdbc) {
		this.driverjdbc = driverjdbc;
	}

	 */

}