package com.ruhelp.ruhelp.core.users;

public class User {
    private Long cpf;
    private Long matricula;
    private String nome;
    private String categoria;

    public User (Long cpf, Long matricula, String nome, String categoria) {
      this.cpf = cpf;
      this.matricula = matricula;
      this.categoria = categoria;
      this.nome = nome;
    }

    public Long getCpf(){
      return this.cpf;
    }

    public Long getMatricula(){
      return this.matricula;
    }
    
    public String getNome(){
      return this.nome;
    }
    
    public String getCategoria(){
      return this.categoria;
    }
    
}
