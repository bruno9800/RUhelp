package com.ruhelp.ruhelp.core.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruhelp.ruhelp.Conexao;
import com.ruhelp.ruhelp.core.session.Session;

public class ListarDisponiveis {
    public static ResultSet list(Long cpf) throws SQLException{
        Connection c = Conexao.getConexao();
        Session s = Session.getInstance();
        String query = "select usuario.nome, usuario.categoria, emprestar.pk_codDisp, emprestar.horario, emprestar.diaSemana from usuario, emprestar where emprestar.fk_cpf2 is null  and usuario.pk_cpf = emprestar.pkfk_cpf and usuario.pk_cpf != ?";
        PreparedStatement stmt = c.prepareStatement(query);
        stmt.setLong(1, s.getUser().getCpf());


        return stmt.executeQuery();
        
        
        
    }
}
