package com.italo.sistema_rh.model;

public class Funcionario {
    private Long id;
    private String nome;
    private String email;
    private Cargo cargo;
    private Departamento departamento;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String email, Cargo cargo, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.departamento = departamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Nome : " + this.nome + "\nEmail : " + this.email + "\nCargo : " + this.cargo + "\nDepartamento : "
                + this.departamento.getNome();
    }
}