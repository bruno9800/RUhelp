package com.ruhelp.ruhelp.core.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ruhelp.ruhelp.Conexao;

public class FazerCadastro {

    public boolean cadastro(String cpfCad, String matriculaCad,String nome, String categoriaCad, String senha) throws SQLException, ClassNotFoundException{
      
      // Verificar se usuario já existe

        Long cpf = Long.parseLong(cpfCad);
        Long matricula = Long.parseLong(matriculaCad);
        try{
        Connection c = Conexao.getConexao();
        String query = "Insert into usuario (pk_cpf,matricula,nome,categoria,senha) values (?,?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(query);

        stmt.setLong(1, cpf);
        stmt.setLong(2, matricula);
        stmt.setString(3, nome);
        stmt.setString(4,categoriaCad);
        stmt.setString(5, senha);

        stmt.executeUpdate();
        return true;
        }
        catch(SQLException ex){
            return false;
        }

    }
}
