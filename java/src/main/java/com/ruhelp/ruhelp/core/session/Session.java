package com.ruhelp.ruhelp.core.session;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruhelp.ruhelp.core.users.User;
import com.ruhelp.ruhelp.core.users.VerificarLogin;

public class Session {

    private boolean status = false;
    private User user = null;
    

    public User getUser() {
        return user;
    }

    public boolean isStatus() {
        return status;
    }
    
    private static Session instance = null;
    // Session s = Session.getInstace();
    private Session() {}

    public static Session getInstance() {
        if(Session.instance == null ) {
          Session.instance = new Session();
        }
        return Session.instance;
    }

    private void setLogged(User user) {
      this.status = true;
      this.user = user;
    }

    public void setUnlogged() {
      this.status = false;
      this.user = null;
    }
    

    public boolean isValidateLogin(String cpf, String password) {
      try {
        VerificarLogin login = new VerificarLogin();
        ResultSet rs = login.Verificar(cpf, password);
        if(rs.next()){
            User userLogged = new User(
                rs.getLong("pk_cpf"), 
                rs.getLong("matricula"),
                rs.getString("nome").trim(),
                rs.getString("categoria")
              );
            setLogged(userLogged);
        }
        return rs.next(); 
      }catch(SQLException e) {
        return false;  
      }
    }
}