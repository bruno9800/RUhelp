package com.ruhelp.ruhelp.core.emprestar;


public class Emprestar {
  private int codigo;
  private String nome;
  private String categoria;
  private String diaSemana;
  private String horario;
  private double valorTotal;

  public int getCodigo() {
    return codigo;
  }

  public String getName() {
    return nome;
  }

  public String getcategoria() {
    return categoria;
  }

  public String getDiaSemana() {
    return diaSemana;
  }

  public String gethorario() {
    return horario;
  }

  public double getvalorTotal() {
    return valorTotal;
  }

  public Emprestar(int codigo,String nome, String categoria, String diaSemana, String horario) {
    this.codigo = codigo;
    this.nome = nome;
    this.categoria = categoria;
    this.diaSemana = diaSemana;
    this.horario = horario;
    if(categoria.equals("P1"))
      this.valorTotal = 7.5;
    else
      this.valorTotal = 12;
  }
}