package com.ruhelp.ruhelp.core.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ruhelp.ruhelp.Conexao;
import com.ruhelp.ruhelp.core.emprestar.Emprestar;
import com.ruhelp.ruhelp.core.session.Session;

public class ListarDisponiveis {
    public static List<Emprestar> list(Long cpf) throws SQLException{
        Connection c = Conexao.getConexao();
        Session s = Session.getInstance();
        
        String query = "select usuario.nome, usuario.categoria, emprestar.pk_codDisp, emprestar.horario, emprestar.diaSemana from usuario, emprestar where emprestar.fk_cpf2 is null  and usuario.pk_cpf = emprestar.pkfk_cpf and usuario.pk_cpf != ?";
        PreparedStatement stmt = c.prepareStatement(query);
        stmt.setLong(1, s.getUser().getCpf());
        ResultSet rs = stmt.executeQuery();

        List<Emprestar > l = new ArrayList<Emprestar>();
        while(rs.next()){
            Emprestar e = new Emprestar(Integer.parseInt(rs.getString("pk_codDisp")) , rs.getString("nome"), rs.getString("categoria"), rs.getString("diaSemana"), rs.getString("horario"));
            l.add(e);
            
        }
        
        return l;
    }
}
