package com.italo.sistema_rh.model;

import java.time.LocalDate;
import java.time.Period;

public class Funcionario {
    private Long id;
    private String nome;
    private String email;
    private Cargo cargo;
    private Departamento departamento;
    private LocalDate dataNascimento;
    private LocalDate dataAdmissao;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String email, Cargo cargo, Departamento departamento,
            LocalDate dataNascimento, LocalDate dataAdmissao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.departamento = departamento;
        this.dataNascimento = dataNascimento;
        this.dataAdmissao = dataAdmissao;
    }

    // getters e setters para todos os campos

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public int getIdade() {
        if (dataNascimento == null)
            return 0;
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public int getTempoDeEmpresa() {
        if (dataAdmissao == null)
            return 0;
        return Period.between(dataAdmissao, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Nome : " + this.nome + "\nEmail : " + this.email + "\nCargo : " + this.cargo + "\nDepartamento : "
                + this.departamento.getNome();
    }
}