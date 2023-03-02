package com.ruhelp.ruhelp.core.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruhelp.ruhelp.Conexao;

public class VerificarLogin {

    public ResultSet Verificar (String cpfLogin, String senha) throws SQLException{

        Long cpf = Long.parseLong(cpfLogin);

        Connection c = Conexao.getConexao();

        String query = "Select * from usuario where pk_cpf = ? and senha = ?";
        PreparedStatement stmt = c.prepareStatement(query);
        stmt.setLong(1, cpf);
        stmt.setString(2, senha);

        return stmt.executeQuery();

    }
    
}
