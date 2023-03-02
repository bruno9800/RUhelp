package com.ruhelp.ruhelp.core.users;

import java.sql.Connection;

import com.ruhelp.ruhelp.Conexao;

public class UserRepository {
    private User[] users;

    public UserRepository() {
      Connection c = Conexao.getConexao(); 
    }


}
