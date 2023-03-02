package com.ruhelp.ruhelp.core.users;

enum Categories{
  P1, P2
}

public class User {
    private Long cpf;
    private Long matricula;
    private String nome;
    private Categories categoria;
    private String senha;

    public User () {}
}
