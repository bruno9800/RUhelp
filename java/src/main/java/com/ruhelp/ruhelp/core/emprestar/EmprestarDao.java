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

  

  private EmprestarDao() {}

  public static EmprestarDao getInstance() throws SQLException {
    if(EmprestarDao.Instance == null){
        System.out.println("Entrando");
        EmprestarDao.Instance = new EmprestarDao();
    }

    System.out.println("\n\n\n\nVeio");
    return EmprestarDao.Instance;
  }
  

  public Emprestar findByCodigo(int codigo) {
    for (Emprestar current: this.disponiveis) {
          if(current.getCodigo() == codigo)
          return current;  
    }

    return null;
  }

  public void listarDisponiveis() throws SQLException {
    Session s = Session.getInstance();
    disponiveis = ListarDisponiveis.list(s.getUser().getCpf());
  }
}