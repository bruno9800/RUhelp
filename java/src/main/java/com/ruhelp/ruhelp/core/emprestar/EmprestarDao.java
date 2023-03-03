package com.ruhelp.ruhelp.core.emprestar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ruhelp.ruhelp.core.session.Session;
import com.ruhelp.ruhelp.core.users.ListarDisponiveis;

public class EmprestarDao {
  private List<Emprestar> disponiveis = new ArrayList<Emprestar>();


  private static EmprestarDao Instance = null;

  public List<Emprestar> getDisponiveis(){
    return this.disponiveis;
  }

  

  private EmprestarDao() {
      this.disponiveis.clear();
      try {
        System.out.println("\n\n\n\nEntrou");
        Session s = Session.getInstance();
        ResultSet rs = ListarDisponiveis.list(s.getUser().getCpf());

        System.out.println("Testando");
        while(rs.next()){
            System.out.println("teste "+rs.getString("horario"));
            Emprestar e = new Emprestar(Integer.parseInt(rs.getString("pk_codDisp")) , rs.getString("nome"), rs.getString("categoria"), rs.getString("diaSemana"), rs.getString("horario"));
            this.disponiveis.add(e);
          }
        for(Emprestar e: this.disponiveis) {
            System.out.println("\n" + e.getName());
        }
      }catch(SQLException e) {
    }
  }

  public static EmprestarDao getInstance() {
    if(EmprestarDao.Instance == null){
        System.out.println("Entrando");
        EmprestarDao.Instance = new EmprestarDao();
    }

    System.out.println("\n\n\n\nVeio");
    return EmprestarDao.Instance;
  }

  public void AtualizarInstance() {
      
  }
  

  public Emprestar findByCodigo(int codigo) {
    for (Emprestar current: this.disponiveis) {
          if(current.getCodigo() == codigo)
          return current;  
    }

    return null;
  }
}