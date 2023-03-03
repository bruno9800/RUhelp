package com.ruhelp.ruhelp.core.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ruhelp.ruhelp.Conexao;

public class DisponibilizarCartao {
    
    public DisponibilizarCartao(Long cpf, String horario, String diaSemana) throws SQLException{
        
        Connection c = Conexao.getConexao();
        String query = "Insert into emprestar (pkfk_cpf,horario,diasemana) values (?,?,?)";
        PreparedStatement stmt = c.prepareStatement(query);
        stmt.setLong(1, cpf);
        stmt.setString(2, horario);
        stmt.setString(3, diaSemana);

        stmt.executeUpdate();
        
    }

}
